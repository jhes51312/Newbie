package commple.a0505sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private  final static String CREATE_TABLE = "CREATE TABLE table01(_id INTEGER PRIMARY KEY,name TEXT,price INTERGER)";
    ListView listView;
    Button button1 , button2;
    EditText editText;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(listen);
        button2.setOnClickListener(listen);
        listView.setOnItemClickListener(listlisten);

        db = openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        try {
            db.execSQL(CREATE_TABLE);
            db.execSQL("INSERT INTO table01(name,price)values('banana',30)");
            db.execSQL("INSERT INTO table01(name,price)values('watermelon',120)");
            db.execSQL("INSERT INTO table01(name,price)values('pear',250)");
            db.execSQL("INSERT INTO table01(name,price)values('peach',280)");
        }catch(Exception e) {
        }
        cursor = getAll();
        UpdateAdapter(cursor);

        }



    private ListView.OnItemClickListener listlisten = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Cursor c= get(id);
            String s =
                    "position="+position+"\r\n"+
                     "id="+id+"\r\n"+
                     "name="+c.getString(1)+"\r\n"+
                     "price="+c.getInt(2);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        }
    };

    protected void onDestroy(){
        super.onDestroy();
        db.close();

    }

    int posNOW = 0;

    private Button.OnClickListener listen = new Button.OnClickListener() {
        public void onClick(View view) {
            try {
                switch (view.getId()) {
                    case R.id.button1: {
                        long id = Integer.parseInt(editText.getText().toString());
                        cursor = get(id);
                        posNOW = cursor.getInt(0);
                        Toast.makeText(getApplicationContext(), cursor.getString(2), Toast.LENGTH_SHORT).show();
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.button2: {
                        cursor = getAll();
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.button3: {
                        posNOW = 1;
                        cursor = get(posNOW);
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.button4: {
                        posNOW--;
                        cursor = get(posNOW);
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.button5: {
                        posNOW++;
                        cursor = get(posNOW);
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.button6: {
                        Cursor c = getAll();
                        posNOW = c.getCount();
                        cursor = get(posNOW);
                        UpdateAdapter(cursor);
                        break;
                    }
                }
            } catch (Exception err) {
                Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_SHORT).show();
            }
        }
    };
    public void UpdateAdapter(Cursor cursor){
        if(cursor != null&&cursor.getCount()>=0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"pname","price"},
                    new int[]{android.R.id.text1,
                              android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        }


    }

    private Cursor getAll() {
        Cursor cursor = db.rawQuery("SELECT _id,_id||'.'||name pname,price FROM table01",null);
        return cursor;
    }

    public Cursor get(long rowId)throws SQLException{
        Cursor cursor = db.rawQuery("SELECT _id,_id||'.'||name pname,price FROM table01 WHERE _id="+rowId,null);
        if(cursor.getCount()>0)
            cursor.moveToFirst();
        else
            Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_SHORT).show();
        return cursor;
    }

}