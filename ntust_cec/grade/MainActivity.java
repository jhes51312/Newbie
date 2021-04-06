package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText2, editText3, editText4;
    private Button button, button3;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        button3 = (Button) findViewById(R.id.button3);
        textView6 = (TextView) findViewById(R.id.textView6);

        button.setOnClickListener(btnTransListener);
        button3.setOnClickListener(btnClean);
    }


    private Button.OnClickListener btnTransListener = new Button.OnClickListener() {
        public void onClick(View view) {

            double total = Double.parseDouble(editText.getText().toString());
            double total2 = Double.parseDouble(editText2.getText().toString());
            double total3 = Double.parseDouble(editText3.getText().toString());
            double total4 = Double.parseDouble(editText4.getText().toString());
            double average = (total + total2 + total3 + total4) / 4;
            textView6.setText("Average Score = " + average);
        }
    };

    private Button.OnClickListener btnClean = new Button.OnClickListener(){
        public void onClick(View view) {

            editText.setText(" ");
            editText2.setText(" ");
            editText3.setText(" ");
            editText4.setText(" ");
            textView6.setText(" ");

        }
    };
}
    