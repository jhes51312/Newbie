package com.mple.a0421posttest;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText edtname, edtage, edthight;
    Button btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtname = (EditText) findViewById(R.id.edtname);
        edtage = (EditText) findViewById(R.id.edtage);
        edthight = (EditText) findViewById(R.id.edthight);

        btnhome = (Button) findViewById(R.id.btnhome);

        btnhome.setOnClickListener(listener);

    }

    private Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view){

            if(!edtname.getText().toString().equals("")
                || !edtage.getText().toString().equals("")
                || !edthight.getText().toString().equals("")){

                getIntent().putExtra("name",edtname.getText().toString());
                getIntent().putExtra("age",edtage.getText().toString());
                getIntent().putExtra("hight",edthight.getText().toString());

                setResult(RESULT_OK , getIntent());

                finish();

            }
        }
    };


}
