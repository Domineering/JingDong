package com.example.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.bean.XiangQingBean;
import com.example.jingdong.view.ZiFenLeiXiang;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZiFenLeiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<XiangQingBean.DataBean> list;
    private LayoutInflater inflater;

    public ZiFenLeiAdapter(Context context, List<XiangQingBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=inflater.inflate(R.layout.zifenlei_item,parent,false);
            MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final XiangQingBean.DataBean dataBean1 = list.get(position);
        String[] split=dataBean1.getImages().split("\\|");
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.image_zifenlei.setImageURI(split[0]);
        myViewHolder.tv_title.setText(dataBean1.getTitle());
        myViewHolder.tv_price.setText("¥"+dataBean1.getPrice()+"");
        myViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ZiFenLeiXiang.class);
                intent.putExtra("pid",dataBean1.getPid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image_zifenlei;
        private final TextView tv_title;
        private final TextView tv_price;
        private final RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_zifenlei = itemView.findViewById(R.id.image_zifenlei);
            tv_title = itemView.findViewById(R.id.tv_zifenlei_title);
            tv_price = itemView.findViewById(R.id.tv_zifenlei_price);
            relativeLayout = itemView.findViewById(R.id.rv_zifenlei);
        }
    }
}
