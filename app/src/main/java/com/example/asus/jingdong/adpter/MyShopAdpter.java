package com.example.asus.jingdong.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jingdong.R;
import com.example.asus.jingdong.bean.Goods;

import java.util.List;

/**
 * Created by Asus on 2016/4/25.
 */
public class MyShopAdpter extends BaseAdapter {
    private List<Goods> list;
    private Context mContext;

    public MyShopAdpter(List<Goods> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHodler myViewHodler=null;
        if(convertView==null){
            myViewHodler=new MyViewHodler();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.goodstyle,null);
            myViewHodler.imageView=(ImageView)convertView.findViewById(R.id.image_goods);
            myViewHodler.textView1=(TextView) convertView.findViewById(R.id.text_good1);
            myViewHodler.textView2=(TextView) convertView.findViewById(R.id.text_good2);
            convertView.setTag(myViewHodler);
        }else{
            myViewHodler= (MyViewHodler) convertView.getTag();
        }
        myViewHodler.imageView.setImageResource(list.get(position).getImage());
        myViewHodler.textView1.setText(list.get(position).getName());
        myViewHodler.textView2.setText(list.get(position).getPrice()+"");
        return convertView;
    }
    class MyViewHodler{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
    }
}
