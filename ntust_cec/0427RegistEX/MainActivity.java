package comample.a0427regist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int counter = 3;
    String account , pwd;
    TextView textView1 , textView2 , textView3;
    Button button1 , button2;
    EditText editText1 , editText2;


    int[]resIds = new int[]{R.drawable.us1,R.drawable.us2,R.drawable.us3,R.drawable.us4,R.drawable.us5};
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);

        textView3 = (TextView)findViewById(R.id.textView3);

        registerForContextMenu(textView3);

        button1.setOnClickListener(btnCH);
        button2.setOnClickListener(btnCane);

    }

    protected static final int MENU_first = ContextMenu.FIRST;
    protected static final int MENU_second = ContextMenu.FIRST+1;

    public void onCreateContextMenu(ContextMenu menu, View v ,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==textView3){
        menu.add(0,MENU_first,1,"forget account");
        menu.add(0,MENU_second,2,"forget password");

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_first:
                Intent intent = new Intent(MainActivity.this,register.class);
                startActivity(intent);
                break;
            case MENU_second:
                Intent intents = new Intent(MainActivity.this,forget.class);
                startActivity(intents);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private Button.OnClickListener btnCH = new Button.OnClickListener(){
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View view) {
            preferences = getSharedPreferences(editText1.getText().toString(),MODE_APPEND);
            account = preferences.getString("account","");
            pwd = preferences.getString("pwd","");

            if(account.equals("")){
                Toast.makeText(getApplicationContext(),"not regist ready",Toast.LENGTH_SHORT).show();
            }else{

                if(account.equals(editText1.getText().toString())&&pwd.equals(editText2.getText().toString())){

                    Intent intent = new Intent(MainActivity.this,detail.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("img",preferences.getInt("img",0));
                    bundle.putString("name",preferences.getString("name",""));
                    bundle.putString("both",preferences.getString("both",""));
                    bundle.putString("phone",preferences.getString("phone",""));
                    bundle.putString("address",preferences.getString("address",""));

                    intent.putExtras(bundle);

                    startActivity(intent);

                }else{
                    counter--;
                    Toast.makeText(getApplicationContext(),"wrong , left"+counter+"chance",Toast.LENGTH_SHORT).show();

                    if(counter == 0){
                        button1.setEnabled(false);
                    }
                }
            }


        }
    };

    private Button.OnClickListener btnCane = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {

        }
    };


}