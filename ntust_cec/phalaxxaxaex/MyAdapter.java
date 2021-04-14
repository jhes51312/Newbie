package com.ple.phalaxxaxa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class MyAdapter extends BaseAdapter {
    private Context context;
    int[] imageID;
    public MyAdapter(Context c, int[]img){
        context = c;
        imageID = img;
    }
    @Override
    public int getCount(){
        return imageID.length;
    }
    @Override
    public Object getItem(int position){
        return position;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView iv = new ImageView(context);
        iv.setImageResource(imageID[position]);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(new GridView.LayoutParams(320,240));
        return iv;
    }



}

