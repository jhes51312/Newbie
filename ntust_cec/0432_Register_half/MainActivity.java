package f.com.mple.my0423welll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button , button2;
    EditText editText , editText2;
    TextView textView;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

        button.setOnClickListener(btnlog);
        button2.setOnClickListener(btnout);

    }

    private Button.OnClickListener btnlog = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(editText.getText().toString().equals("root")&&editText2.getText().toString().equals("12345678")){
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,home.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","Eric");
                bundle.putString("phone","0912345678");
                intent.putExtras(bundle);
                startActivity(intent);
            }
            else{
                count--;
                Toast.makeText(getApplicationContext(),"wrong , left"+count+"chance",Toast.LENGTH_SHORT).show();
                if (count ==0){
                    button.setEnabled(false);
                }
            }
        }
    };


    private Button.OnClickListener btnout = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            finish();
        }
    };
}