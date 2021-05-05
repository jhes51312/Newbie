package com.sunshihhung.a0505sqqqql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDB db = null;
    Button button1 , button2 , button3 , button4;
    EditText editText1 , editText2;
    ListView listView;
    Cursor cursor;
    long myid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);

        listView = (ListView)findViewById(R.id.listView1);

        button1.setOnClickListener(listen);
        button2.setOnClickListener(listen);
        button3.setOnClickListener(listen);
        button4.setOnClickListener(listen);
        listView.setOnItemClickListener(listlisten);

        db = new MyDB(this);
        db.open();
        cursor = db.getAll();
        UpdateAdpater(cursor);

    }

    private ListView.OnItemClickListener listlisten = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            ShowData(id);
        }
    };

    private void ShowData(long id){
        Cursor c = db.get(id);
        myid = id;
        editText1.setText(c.getString(1));
        editText2.setText(""+c.getString(2));
    }


    private Button.OnClickListener listen = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                switch (view.getId()) {
                    case R.id.button1: {
                        int price = Integer.parseInt(editText2.getText().toString());
                        String name = editText1.getText().toString();
                        if (db.append(name, price) > 0) {
                            cursor = db.getAll();
                            UpdateAdpater(cursor);
                            ClearEdit();
                        }
                        break;
                    }
                    case R.id.button2:{
                        int price = Integer.parseInt(editText2.getText().toString());
                        String name = editText1.getText().toString();
                        if(db.updata(myid,name,price)){
                            cursor =db.getAll();
                            UpdateAdpater(cursor);
                        }
                        break;
                    }
                    case R.id.button3: {
                        if (cursor != null && cursor.getCount() >= 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("confirm delete");
                            builder.setMessage("really confirm" + editText1.getText() + "this data?");
                            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (db.delete(myid)) {
                                        cursor = db.getAll();
                                        UpdateAdpater(cursor);
                                        ClearEdit();
                                    }
                                }
                            });
                            builder.show();
                        }
                        break;
                    }
                    case R.id.button4:{
                        ClearEdit();
                        break;
                    }
                }
            } catch (Exception err) {
                Toast.makeText(getApplicationContext(), "wrong data", Toast.LENGTH_SHORT).show();

            }
        }
    };

    public void ClearEdit(){
        editText1.setText("");
        editText2.setText("");
    }

    public void UpdateAdpater(Cursor cursor){
        if(cursor != null&&cursor.getCount()>=0){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"name","price"},
                    new int[]{android.R.id.text1,
                            android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }

}