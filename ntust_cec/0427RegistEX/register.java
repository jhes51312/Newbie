package comample.a0427regist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    EditText editText1 , editText2 , editText3 , editText4 , editText5 , editText6 ;
    Button button1 , button2;

    private SharedPreferences preferences;

    int[]resIds = new int[]{R.drawable.us1,R.drawable.us2,R.drawable.us3,R.drawable.us4,R.drawable.us5};

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(listen);
        button2.setOnClickListener(listencancel);

    }

    private Button.OnClickListener listen = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {

            int img = (int) (Math.random() * 5);
            if (!editText1.getText().toString().equals("")
                ||!editText2.getText().toString().equals("")
                || !editText3.getText().toString().equals("")
                || !editText4.getText().toString().equals("")
                || !editText5.getText().toString().equals("")
                || !editText6.getText().toString().equals("")){

                preferences = getSharedPreferences(editText1.getText().toString(),MODE_PRIVATE);
                preferences.edit()
                        .putInt("img",img)
                        .putString("account",editText1.getText().toString())
                        .putString("pwd",editText2.getText().toString())
                        .putString("name",editText3.getText().toString())
                        .putString("both",editText4.getText().toString())
                        .putString("phone",editText5.getText().toString())
                        .putString("address",editText6.getText().toString())
                        .commit();
                finish();
            }
        }
    };

    private Button.OnClickListener listencancel = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


}
