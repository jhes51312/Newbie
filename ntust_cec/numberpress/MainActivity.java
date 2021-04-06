package com.exnumbertest;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);

        button.setOnClickListener(btn);
        button2.setOnClickListener(btn);
        button3.setOnClickListener(btn);
        button4.setOnClickListener(btn);
        button5.setOnClickListener(btn);
        button6.setOnClickListener(btn);
        button7.setOnClickListener(btn);
        button8.setOnClickListener(btn);
        button9.setOnClickListener(btn);
        button10.setOnClickListener(btn);
        button11.setOnClickListener(btn);
        button12.setOnClickListener(btn);
        button13.setOnClickListener(btn);
    }

    private Button.OnClickListener btn = new Button.OnClickListener() {
        public void onClick(View View) {
            String s = textView.getText().toString();
            switch (View.getId()) {
                case R.id.button: {
                    textView.setText(s + "1");
                    break;
                }
                case R.id.button2: {
                    textView.setText(s + "2");
                    break;
                }
                case R.id.button3: {
                    textView.setText(s + "3");
                    break;
                }
                case R.id.button4: {
                    textView.setText(s + "4");
                    break;
                }
                case R.id.button5: {
                    textView.setText(s + "5");
                    break;
                }
                case R.id.button6: {
                    textView.setText(s + "6");
                    break;
                }
                case R.id.button7: {
                    textView.setText(s + "7");
                    break;
                }
                case R.id.button8: {
                    textView.setText(s + "8");
                    break;
                }
                case R.id.button9: {
                    textView.setText(s + "9");
                    break;
                }
                case R.id.button10: {
                    textView.setText(s + "0");
                    break;
                }
                case R.id.button11: {
                    textView.setText(s + "*");
                    break;
                }
                case R.id.button12: {
                    textView.setText(s + "#");
                    break;
                }
                case R.id.button13: {
                    textView.setText(" ");
                    break;
                }

            }


        }

        ;
    };
}