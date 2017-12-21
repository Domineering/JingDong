package com.example.jingdong.presenter;

import android.content.Context;

import com.example.jingdong.bean.UserBean;
import com.example.jingdong.model.ShowModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.ISuccessActivity;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class ShowPrenester {

ISuccessActivity iSuccessActivity;
ShowModel showModel;

    public ShowPrenester(ISuccessActivity iSuccessActivity) {
        this.iSuccessActivity = iSuccessActivity;
        showModel=new ShowModel();
    }
    public void getData(){
        showModel.shuju(new OnNetListine<UserBean>() {
            @Override
            public void OnSucc(UserBean userBean) {
                iSuccessActivity.show(userBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
