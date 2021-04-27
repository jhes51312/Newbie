package comample.a0427regist;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forget extends AppCompatActivity {

    Button button4 , button5;
    EditText editText7;
    TextView textView;

    private SharedPreferences preferences;

    String account;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        editText7 = (EditText)findViewById(R.id.editText7);
        textView = (TextView)findViewById(R.id.textView);

        button4.setOnClickListener(btnlisten);
        button5.setOnClickListener(btnCane);
    }

    private Button.OnClickListener btnlisten = new Button.OnClickListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View view) {
            preferences = getSharedPreferences(editText7.toString(),MODE_APPEND);
            account = preferences.getString("account","");
            if(!account.equals("")) {
                textView.setText("Your pwd:" + preferences.getString("pwd", ""));
            }else{
                Toast.makeText(getApplicationContext(),"not regist ready",Toast.LENGTH_LONG);
            }
        }
    };

    private Button.OnClickListener btnCane = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {

            finish();

        }
    };

}
