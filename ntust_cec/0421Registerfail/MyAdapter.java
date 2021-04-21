package com.mple.a0421register;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private  Context mContext;
    private  ArrayList<PlanentsItem>mUpdateData = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<PlanentsItem> PlanentsItem){
        this.mContext = context;
        this.mUpdateData = PlanentsItem;

    }

    @Override
    public  int getCount(){
        return mUpdateData.size();
    }

    @Override
    public Object getItem(int i) {
        return mUpdateData.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

        converView = LayoutInflater.from(mContext).inflate(R.layout.updatedata_item,null);

        ImageView imageView2 = (ImageView)converView.findViewById(R.id.imageView2);
        TextView textView2 = (TextView)converView.findViewById(R.id.textView2);
        TextView textView3 = (TextView)converView.findViewById(R.id.textView3);

        PlanentsItem updatedata_item = getItem(position);

        imageView2.setImageResource(updatedata_item.getImgId);
        textView2.setText(updatedata_item.getName());
        textView3.setText(updatedata_item.getPhone());

                return converView;
    }

}
