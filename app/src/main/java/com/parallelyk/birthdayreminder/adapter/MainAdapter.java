package com.parallelyk.birthdayreminder.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parallelyk.birthdayreminder.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YK on 2016/5/25.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<HashMap<String,Object>> mData;
    public MainAdapter(Context context , ArrayList<HashMap<String,Object>> data){
        mContext = context;
        mData = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).get("name").toString());
        holder.dayleft.setText(mData.get(position).get("dayleft").toString());
        holder.birthday.setText(mData.get(position).get("birthday").toString());
        //holder.imageView.setImageResource(mData.get(position).get("imageView").toString());

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name,dayleft,birthday;

        public MyViewHolder(View view)
        {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image_item_main);
            name = (TextView) view.findViewById(R.id.name_item_main);
            dayleft = (TextView) view.findViewById(R.id.dayBefore_item_main);
            birthday = (TextView) view.findViewById(R.id.dayExact_item_main);
        }
    }
}
