package comxple.gradesave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button, button2, button3, button4;
    private TextView textView;
    private EditText editText;
    String[] score = new String[5];
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(listen);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(change);
        button4.setOnClickListener(delete);

    }

    private Button.OnClickListener listen = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = editText.getText().toString();
            if (num > score.length - 1) {
                Toast toast = Toast.makeText(MainActivity.this, "too much" + score.length + " bala", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            } else {
                score[num] = str;
                num++;
                editText.setText("");
                Toast toast = Toast.makeText(MainActivity.this, "no." + num + " bala", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        }
    };

    private Button.OnClickListener listener = new Button.OnClickListener() {
        public void onClick(View view) {
            String str = "";
            for (int i = 0; i < score.length; i++) {
                str = str + score[i] + '\n';
            }
            textView.setText(str);
        }
    };

    private Button.OnClickListener change = new Button.OnClickListener() {
        public void onClick(View view) {
            int id = Integer.parseInt(button3.getText().toString());
            String str = editText.getText().toString();
            int item = id;

            if (id > score.length - 1) {
                Toast toast = Toast.makeText(MainActivity.this, "lololol", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                id = id - 1;
                score[id] = str;
                Toast toast = Toast.makeText(MainActivity.this, "LOLOLOL", Toast.LENGTH_SHORT);
                toast.show();

            }
        }

        ;

        private Button.OnClickListener delete = new Button.OnClickListener() {
            public void onClick(View view) {
                int id = Integer.parseInt(button3.getText().toString());
                int item = id;
                if (id > score.length) {
                    Toast toast = Toast.makeText(MainActivity.this, "lololol", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    id = id - 1;
                    score[id] = "0";
                    Toast toast = Toast.makeText(MainActivity.this, "LOLOLOL", Toast.LENGTH_SHORT);
                    toast.show();

                }
            };

        }
    };
}


