package com.example.jingdong.presenter;

import com.example.jingdong.bean.GoodsBean;
import com.example.jingdong.model.ZuoModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.IClassActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZuoPrenester {
IClassActivity iClassActivity;
ZuoModel zuoModel;

    public ZuoPrenester(IClassActivity iClassActivity) {
        this.iClassActivity = iClassActivity;
        zuoModel=new ZuoModel();
    }
    public void getzuoshow(String cid){
        zuoModel.getzuo(cid, new OnNetListine<GoodsBean>() {
            @Override
            public void OnSucc(GoodsBean goodsBean) {
                List<GoodsBean.DataBean> data = goodsBean.getData();
                List<List<GoodsBean.DataBean.ListBean>> lists=new ArrayList<List<GoodsBean.DataBean.ListBean>>();
                for (int i = 0; i < data.size(); i++) {
                    List<GoodsBean.DataBean.ListBean> listBeans = data.get(i).getList();
                    lists.add(listBeans);
                }
                iClassActivity.showZuo(data,lists);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
