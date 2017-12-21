package com.example.jingdong.presenter;

import com.example.jingdong.bean.AddSBean;
import com.example.jingdong.model.AddModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.IAddActivity;

/**
 * Created by 绅丶士 on 2017/12/18.
 */

public class AddPresenter {
    IAddActivity iAddActivity;
    AddModel addModel;

    public AddPresenter(IAddActivity iAddActivity) {
        this.iAddActivity = iAddActivity;
        addModel=new AddModel();
    }

    public void getshow(String pid){
        addModel.getadd(pid, new OnNetListine<AddSBean>() {
            @Override
            public void OnSucc(AddSBean addSBean) {
                iAddActivity.addshow(addSBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
