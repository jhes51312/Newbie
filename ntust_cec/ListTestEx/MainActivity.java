package com.ple.listtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView List;
    private TextView textView;
    private Button button;
    String[] Balls = new String[]{"baseket","soccer","base","other"};
    int count;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = (ListView)findViewById(R.id.List);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Balls);
        List.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        List.setAdapter(adapterBalls);
        //List.setTextFilterEnabled(true);
        count = adapterBalls.getCount();
        //List.setSelector(R.drawable.green);

        button.setOnClickListener(btn);
        List.setOnItemClickListener(listlisten);
    }

    private Button.OnClickListener btn = new Button.OnClickListener(){
        public void onClick(View view){
            String selall ="";
            for (int p=0; p<count;p++){
                if(List.isItemChecked(p))
                    selall += Balls[p]+" ";
            }
            textView.setText("My Favorite : " + selall);
        }
    };

    private ListView.OnItemClickListener listlisten = new ListView.OnItemClickListener() {

        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String sel = parent.getItemAtPosition(position).toString();
            if(List.isItemChecked(position)){
                setTitle(" Now select :" +sel);
            }
            else{
                setTitle(" Now cancle :"+sel);
            }
            //textView.setText("My Favorite : " + sel);
        }
    };
}