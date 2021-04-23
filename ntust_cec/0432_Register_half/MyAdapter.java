package f.com.mple.my0423welll;

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
    private  ArrayList<PlanetsItem>mUpdateData = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<PlanetsItem> PlanentItem){
        this.mContext = context;
        this.mUpdateData = PlanentItem;

    }

    @Override
    public  int getCount(){return mUpdateData.size();}

    @Override
    public PlanetsItem getItem(int position) {return mUpdateData.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View converView, ViewGroup parent) {

        converView = LayoutInflater.from(mContext).inflate(R.layout.updatedata_item,null);

        ImageView imageView2 = (ImageView)converView.findViewById(R.id.imgLogo);
        TextView textView2 = (TextView)converView.findViewById(R.id.txtName);
        TextView textView3 = (TextView)converView.findViewById(R.id.txt_phone);

        PlanetsItem updatedata = getItem(position);

        imageView2.setImageResource(updatedata.getImgId());
        textView2.setText(updatedata.getName());
        textView3.setText(updatedata.getPhone());

        return converView;
    }

    public void add(PlanetsItem updatedata){
        mUpdateData.add(updatedata);
        notifyDataSetChanged();
    }

}