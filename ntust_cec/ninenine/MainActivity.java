package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        button.setOnClickListener(btnlistener);

    }

    private Button.OnClickListener btnlistener = new Button.OnClickListener() {
        public void onClick(View view) {
            String result = "";
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {

                    result = result + i + "*" + j + "=" + i * j + '\n';

                }
            }
            textView.setText(result);
        }

        ;
    };
}