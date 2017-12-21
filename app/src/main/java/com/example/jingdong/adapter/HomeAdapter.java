package com.example.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/15.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<UserBean.DataBean> list;
    private LayoutInflater inflater;

    public HomeAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.home_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserBean.DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.home_image.setImageURI(dataBean.getIcon());
        myViewHolder.home_tv.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView home_image;
        private final TextView home_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            home_image = itemView.findViewById(R.id.home_item_image);
            home_tv = itemView.findViewById(R.id.home_item_tv);
        }
    }
}
