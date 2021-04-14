package com.ple.listtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView List;
    private TextView textView;
    String[] Balls = new String[]{"baseket","soccer","base","other"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = (ListView)findViewById(R.id.List);
        textView = (TextView)findViewById(R.id.textView);

        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Balls);
        List.setAdapter(adapterBalls);
        List.setTextFilterEnabled(true);
        List.setSelector(R.drawable.green);
        List.setOnItemClickListener(listlisten);
    }

    private ListView.OnItemClickListener listlisten = new ListView.OnItemClickListener() {

        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String sel = parent.getItemAtPosition(position).toString();
            textView.setText("My Favorite : " + sel);
        }
/
    };
}