package com.ple.balabababa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    int[] imgID = {R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06};

    private Button button , button2;
    private ImageView imageView;

    int p = 0;
    int count = imgID.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        imageView = (ImageView)findViewById(R.id.imageView);

        button.setOnClickListener(btn1);
        button2.setOnClickListener(btn2);

    }

    private Button.OnClickListener btn1 = new Button.OnClickListener(){
        public  void onClick(View view){

            p--;
            if(p<0)
                p = count-1;
            imageView.setImageResource(imgID[p]);
            setTitle("No."+(p+1)+"/"+count);

        }
    };

    private Button.OnClickListener btn2 = new Button.OnClickListener(){
        public void onClick(View view){

            p++;
            if (p==count)
                p=0;
            imageView.setImageResource(imgID[p]);
            setTitle("No."+(p+1)+"/"+count);

        }
    };

}