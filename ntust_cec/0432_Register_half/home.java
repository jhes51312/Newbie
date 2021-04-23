package f.com.mple.my0423welll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<PlanetsItem>datas = new ArrayList<>();

    int[] resIds = new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4};
    int id = 0;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_home);

        textView5 = (TextView)findViewById(R.id.textView5);
        listView1 = (ListView)findViewById(R.id.listView1);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        View emptyView =  findViewById(R.id.textView5);
        listView1.setEmptyView(emptyView);

        mAdapter = new MyAdapter(this,datas);
        listView1.setAdapter(mAdapter);

        button3.setOnClickListener(listenadd);
        button4.setOnClickListener(listenout);
        listView1.setOnItemClickListener(listenclick);

    }

    private Button.OnClickListener listenadd = new Button.OnClickListener(){
        @Override
        public void onClick(View view){

            Intent intent = new Intent(home.this,register.class);

            startActivityForResult(intent,FUNC_LOGIN);

        }
    };

    private Button.OnClickListener listenout = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            finish();
        }
    };

    private ListView.OnItemClickListener listenclick = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            PlanetsItem str = datas.get(position);

            Intent intent = new Intent(home.this,detail.class);
            Bundle bundle = new Bundle();

            bundle.putInt("img",str.getImgId());
            bundle.putString("name",str.getName());
            bundle.putString("age",str.getAge());
            bundle.putString("phone",str.getPhone());
            bundle.putString("address",str.getAddress());
            intent.putExtras(bundle);

            startActivity(intent);

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

                mAdapter.add(new PlanetsItem(resIds[imgId],name,phone,age,address));

            }
        }

    }



}