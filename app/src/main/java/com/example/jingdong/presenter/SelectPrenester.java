package com.example.jingdong.presenter;

import com.example.jingdong.bean.CartBean;
import com.example.jingdong.model.SelectModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.ISelectActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/18.
 */

public class SelectPrenester {
ISelectActivity iSelectActivity;
SelectModel selectModel;

    public SelectPrenester(ISelectActivity iSelectActivity) {
        this.iSelectActivity = iSelectActivity;
        selectModel=new SelectModel();
    }
    public void getselects(){
      selectModel.getselect(new OnNetListine<CartBean>() {
          @Override
          public void OnSucc(CartBean cartBean) {
              List<CartBean.DataBean> data = cartBean.getData();
              List<List<CartBean.DataBean.ListBean>> childlist=new ArrayList<List<CartBean.DataBean.ListBean>>();
              for (int i = 0; i <data.size() ; i++) {
                  List<CartBean.DataBean.ListBean> list = data.get(i).getList();
                  childlist.add(list);
              }
              iSelectActivity.getselect(data,childlist);
          }

          @Override
          public void OnFile(String str) {

          }
      });
    }
}
