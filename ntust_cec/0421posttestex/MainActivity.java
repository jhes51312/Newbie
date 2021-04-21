package com.mple.a0421posttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int FUNC_LOGIN = 1;
    boolean login = false;

    String[]arr_name = new String[5];
    String[]arr_age = new String[5];
    String[]arr_hight = new String[5];

    int num = 0;

    private Button btnjump;
    private TextView txtshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtshow = (TextView)findViewById(R.id.txtshow);
        btnjump = (Button)findViewById(R.id.btnjump);

        btnjump.setOnClickListener(listenerlogout);
    }

    private Button.OnClickListener listenerlogout = new Button.OnClickListener(){
        public void onClick(View view){

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MainActivity2.class);

            startActivityForResult(intent,FUNC_LOGIN);

        }

    };

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == FUNC_LOGIN){
            if(resultCode == RESULT_OK) {
                String str ="";
                String name = data.getStringExtra("name");
                String age = data.getStringExtra("age");
                String hight = data.getStringExtra("hight");
                arr_name[num] = name;
                arr_age[num] = age;
                arr_hight[num] = hight;
                num++;
                for(int i=0;i<num;i++){
                    str = str+arr_name[i]+"/"+arr_age[i]+"/"+arr_hight[i]+"\n";
            }
                txtshow.setText(str);
            }else{
                    finish();
                }
            }

        };
}
