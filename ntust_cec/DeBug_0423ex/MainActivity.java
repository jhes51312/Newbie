package f.com.mple.debug_0423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber , editTextNumber2 ;
    private TextView textView2 ;
    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = (EditText)findViewById(R.id.editTextNumber);
        editTextNumber2 = (EditText)findViewById(R.id.editTextNumber2);
        button = (Button)findViewById(R.id.button);
        textView2 = (TextView)findViewById(R.id.textView2);

        button.setOnClickListener(listen);

    }

    private Button.OnClickListener listen = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            try{
                int x = Integer.parseInt(editTextNumber.getText().toString());
                int y = Integer.parseInt(editTextNumber2.getText().toString());
                int r = x % y;
                textView2.setText(x+"%"+y+"="+r);
            }catch (NumberFormatException err){
                Toast toast = Toast.makeText(getApplicationContext(),"WRONG BEACH",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                Log.d("my log","wrong beach");
            }catch (Exception err){
                Toast toast = Toast.makeText(getApplicationContext(),"nonononono"+err.toString(),Toast.LENGTH_SHORT);
                toast.show();
            }
            finally {
                Toast.makeText(getApplicationContext(),"finally access",Toast.LENGTH_SHORT).show();
            }
        }
    };

}