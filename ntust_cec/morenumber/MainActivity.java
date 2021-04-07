package com.numbbberereios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16;
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
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);

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
        button14.setOnClickListener(btn);
        button15.setOnClickListener(btn);
        button16.setOnClickListener(btn);
    }

    private Button.OnClickListener btn;

    {
        btn = new Button.OnClickListener() {
            public void onClick(View View) {
                String s = textView.getText().toString();
                switch (View.getId()) {
                    case R.id.button: {
                        display("1");
                        break;
                    }
                    case R.id.button2: {
                        display("2");
                        break;
                    }
                    case R.id.button3: {
                        display("3");
                        break;
                    }
                    case R.id.button4: {
                        display("4");
                        break;
                    }
                    case R.id.button5: {
                        display("5");
                        break;
                    }
                    case R.id.button6: {
                        display("6");
                        break;
                    }
                    case R.id.button7: {
                        display("7");
                        break;
                    }
                    case R.id.button8: {
                        display("8");
                        break;
                    }
                    case R.id.button9: {
                        display("9");
                        break;
                    }
                    case R.id.button10: {
                        display("0");
                        break;
                    }
                    case R.id.button11: {
                        display("*");
                        break;
                    }
                    case R.id.button12: {
                        display("#");
                        break;
                    }
                    case R.id.button13: {
                        textView.setText("");
                        break;
                    }
                    case R.id.button14: {
                        String str = textView.getText().toString();
                        if (str.length() > 0) {
                            str = str.substring(0, str.length() - 1);
                            textView.setText(str);
                        }
                        break;
                    }
                    case R.id.button15: {
                        String str = textView.getText().toString();
                        if (str.equals("12345678")) {
                            Toast toast = Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER,0,200);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER,0,-200);
                            toast.show();
                            textView.setText("");
                        }
                        break;
                    }
                    case R.id.button16: {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Confirm")
                                .setIcon(R.mipmap.ic_launcher)
                                .setMessage("Really?")

                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialoginterface, int i) {
                                        finish();
                                    }
                                })
                                .show();
                        break;
                    }

                }
            }



    };
}
    private void display(String s){

            String str = textView.getText().toString();
            textView.setText(str+s);

    }
        ;
    }
