package com.ple.phalaxxaxa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] imageID = {R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06};
    private ImageView imageView;
    private GridView gridView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        gridView01 = (GridView) findViewById(R.id.gridView01);

        //MyAdapter adapter = new MyAdapter(this);
        MyAdapter adapter = new MyAdapter(this,imageID);
        gridView01.setAdapter(adapter);
        gridView01.setOnItemClickListener(lister);
    }

    private AdapterView.OnItemClickListener lister = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            imageView.setImageResource(imageID[i]);
        }
    };
    /*
        gridView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                imageView.setImageResource(imageID[position]);
            }
        });

    }

    class MyAdapter extends BaseAdapter {
        private Context mContext;

        public MyAdapter(Context c){mContext=c;}
        @Override
        public int getCount(){return imageID.length;}
        @Override
        public Object getItem(int position){return position;}
        @Override
        public long getItemId(int position){return position;}

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageID[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new GridView.LayoutParams(320,240));
            return iv;
        }
    }*/

}