package com.mple.a0421register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class home extends AppCompatActivity {
    public static final int FUNC_LOGIN = 1;
    private ListView listView1;
    private Button button3 , button4;
    private TextView textView5;
    private MyAdapter mAdapter;
    private ArrayList<PlanentsItem>datas = new ArrayList<>();

    int[] resIds = new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4};
    int id = 0;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_home);

        textView5 = (TextView)findViewById((R.id.textView5);
        listView1 = (ListView)findViewById(R.id.listView1);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        mAdapter = new MyAdapter(this,datas);
        listView1.setAdapter(mAdapter);

        View emptyView =  findViewById(R.id.textView5);
        listView1.setEmptyView(emptyView);

        button3.setOnClickListener(listenadd);

    }

    private Button.OnClickListener listenadd = new Button.OnClickListener(){
        @Override
        public void onClick(View view){

            Intent intent = new Intent(home.this,register.class);

            startActivityForResult(intent,FUNC_LOGIN);

        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == FUNC_LOGIN){
            if(resultCode == RESULT_OK){
                int imgId = data.getIntExtra("img",0);
                String name = data.getStringExtra("name");
                String phone = data.getStringExtra("phone");
                String age = data.getStringExtra("age");
                String address = data.getStringExtra("address");
            }
        }

    }



}
