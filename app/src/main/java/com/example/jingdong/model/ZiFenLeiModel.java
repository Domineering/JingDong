package com.example.jingdong.model;

import com.example.jingdong.bean.XiangQingBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;
import com.example.jingdong.view.XiangQingActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZiFenLeiModel {
    public void getZi(String pscid, final OnNetListine<XiangQingBean> onNetListine){
        RetrofitHolder.getApi().xiang(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean xiangQingBean) throws Exception {
                        onNetListine.OnSucc(xiangQingBean);
                    }
                });
    }
}
