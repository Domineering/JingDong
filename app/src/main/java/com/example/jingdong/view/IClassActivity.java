package com.example.jingdong.view;

import com.example.jingdong.bean.GoodsBean;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public interface IClassActivity {
    public void showZuo(List<GoodsBean.DataBean> groupList,List<List<GoodsBean.DataBean.ListBean>> childList);
}
