package commple.a0504sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private final static String CREATE_TABLE = "CREATE TABLE table01(_id INTEGER PRIMARY KEY, num INTERGER, data TEXT)";

    EditText editText;
    Button button;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);

        db = openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        try{
            db.execSQL(CREATE_TABLE);
        }catch(Exception c){
            Log.d("mylog","SQL created");

        }

        button.setOnClickListener(btn);

    }

    private Button.OnClickListener btn = new Button.OnClickListener(){

        public void onClick(View view) {
            try{
                String str = "INSERT INTO table01(num,data)values(1,'no.1')";
                db.execSQL(str);
                getall();
                Log.d("mylog","Success");
            }catch (Exception c){
                Log.d("mylog","FAILED");
            }
        }
    };

    public  void getall(){
        Cursor cursor = db.rawQuery("SELECT * FROM table01",null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"_id","data"},
                new int[]{android.R.id.text1,android.R.id.text2},
                0);

        listView.setAdapter(adapter);

    }


    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}