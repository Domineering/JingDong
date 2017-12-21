package com.example.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.UserBean;
import com.example.jingdong.fragment.ClassifyFragment;
import com.example.jingdong.newWork.SetOnClicklistener;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class ClassZuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<UserBean.DataBean> list;
    private SetOnClicklistener setOn;
    private LayoutInflater layoutInflater;

    public ClassZuoAdapter(Context context, List<UserBean.DataBean> list,SetOnClicklistener setOn) {
        this.context = context;
        this.list = list;
        this.setOn=setOn;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.classzuo_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder= (MyViewHolder) holder;
        final UserBean.DataBean dataBean = list.get(position);
        myViewHolder.tv.setText(dataBean.getName());
        myViewHolder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOn.OnClikLinter(dataBean.getCid()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final RelativeLayout rel;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rel = itemView.findViewById(R.id.rel);
        }
    }
}
