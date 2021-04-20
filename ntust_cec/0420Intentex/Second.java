package commple.a0420intent;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.second);

        Button btnHome = (Button)findViewById(R.id.btnHome);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        btnHome.setOnClickListener(HomeListen);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        int age = bundle.getInt("AGE");
        Double tall = bundle.getDouble("TALL");
        String s = "Name: "+name+"\n"+"AGE: "+age+"\n"+"TALL"+tall;
        textView3.setText(s);

    }

    private Button.OnClickListener HomeListen = new Button.OnClickListener(){
        public void onClick(View view){
            finish();
        }
    };

}
