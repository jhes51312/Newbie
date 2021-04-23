package f.com.mple.db_0423;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1 , button2;
    private TextView textView;
    private EditText editText;
    private String sname , msg;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editTextNumber);

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);

        preferences = getSharedPreferences("proFile",MODE_PRIVATE);
        sname = preferences.getString("name","");

        if(sname.equals("")) {
            textView.setVisibility(TextView.VISIBLE);
            editText.setVisibility(EditText.VISIBLE);
            button2.setVisibility(Button.INVISIBLE);
            msg = "welcome , enter profile";
        }else{
            msg = "Dear"+sname+" , hello , welcome back stoopid";

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Welcome use us")
                    .setMessage(msg)
                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();
        }
    }

    private Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (view.getId()){
                case R.id.button1:
                    finish();
                    break;
                case R.id.button2:
                    if(!sname.equals("")){
                        preferences.edit()
                                .clear()
                                .commit();
                        Toast.makeText(getApplicationContext(),"ALL CLEAR",Toast.LENGTH_LONG).show();
                    }
                    button2.setVisibility(Button.INVISIBLE);
                    break;
            }
        }
    };

    protected  void onStop(){
        super.onStop();
        if(sname.equals("")){
            preferences.edit()
                    .putString("name",editText.getText().toString())
                    .commit();
        }
    }
}