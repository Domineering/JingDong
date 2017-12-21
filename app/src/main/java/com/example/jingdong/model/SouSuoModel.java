package com.example.jingdong.model;

import com.example.jingdong.bean.SouSuoBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/15.
 */

public class SouSuoModel {
    public void getsousuo(String keywords, final OnNetListine<SouSuoBean> onNetListine){
        RetrofitHolder.getApi().sou(keywords,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SouSuoBean>() {
                    @Override
                    public void accept(SouSuoBean souSuoBean) throws Exception {
                        onNetListine.OnSucc(souSuoBean);
                    }
                });
    }

}
