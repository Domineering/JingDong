package com.example.jingdong.view;

import com.example.jingdong.bean.CartBean;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/18.
 */

public interface ISelectActivity {
    public void getselect(List<CartBean.DataBean> groupchild,List<List<CartBean.DataBean.ListBean>> childlist);
}
