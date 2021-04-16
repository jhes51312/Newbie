package com.exa.durararala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button1 , button2 , button3 , button4 ;
    private TextView textView1;

    private MyAdapter mAdapter;
    private ArrayList<PlanetsItem> datas = new ArrayList<>();

    int[] resIds = new int[]{R.drawable.j0,R.drawable.j1,R.drawable.j2,R.drawable.j3};
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        View emptyview = findViewById(R.id.textView1);
        listView.setEmptyView(emptyview);

        mAdapter = new MyAdapter(MainActivity.this,datas);
        listView.setAdapter(mAdapter);

        button1.setOnClickListener(listadd);
        button2.setOnClickListener(listrandom);
        button3.setOnClickListener(listdel);
        button4.setOnClickListener(listclear);

    }

    private Button.OnClickListener listadd = new Button.OnClickListener(){
        @Override
        public  void  onClick(View view){
            int count = getRandomPosition();
            mAdapter.add(new PlanetsItem(resIds[count],"random"+id));
            id++;
        }
    };


    private Button.OnClickListener listrandom = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            int count = getRandomPosition();
            int an = getRandom();
            mAdapter.updata(new PlanetsItem(resIds[count],"update"+an));

        }
    };

    private Button.OnClickListener listdel = new Button.OnClickListener(){
        @Override
        public  void  onClick(View view) {
            id--;
            mAdapter.remove(id);
        }
     };

    private Button.OnClickListener listclear = new Button.OnClickListener(){
        @Override
        public  void  onClick(View view) {
            id = 0;
            mAdapter.clean();
        }
    };

   public int getRandomPosition(){
       int count = resIds.length;

       return (int)(Math.random()*count);
    }
    public int getRandom(){
        return (int)(Math.random()*100);
    }
}
