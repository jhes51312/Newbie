package com.exa.durararala;

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
    private Context content;
    private ArrayList<PlanetsItem>mUpdate = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<PlanetsItem> PlanetsItem) {
        this.content = context;
        this.mUpdate = PlanetsItem;
    }


    @Override
    public int getCount() {
        return mUpdate.size();
    }

    @Override
    public PlanetsItem getItem(int position) {
        return mUpdate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=LayoutInflater.from(content).inflate(R.layout.update,null);

        ImageView icon_img =(ImageView) convertView.findViewById(R.id.icon_img);
        TextView contect_tv =(TextView) convertView.findViewById(R.id.contect_tv);

        PlanetsItem update = getItem(position);
        icon_img.setImageResource(update.getImgId());
        contect_tv.setText(update.getContent());

        return convertView;

    }

    public void add(PlanetsItem UpdateData){
        mUpdate.add(UpdateData);
        notifyDataSetChanged();
    }

    public void updata(PlanetsItem UpdateData){
        if(mUpdate != null && mUpdate.size()>0) {
            mUpdate.set(mUpdate.size() - 1, UpdateData);
        }
        notifyDataSetChanged();
    }

    public void remove(int id){
        if(mUpdate != null && mUpdate.size()>0) {
            mUpdate.remove(id);
        }
        notifyDataSetChanged();
    }
    public void clean(){
        mUpdate.clear();
        notifyDataSetChanged();
    }
}
