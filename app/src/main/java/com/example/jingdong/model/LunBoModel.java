package com.example.jingdong.model;

import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class LunBoModel {
    public void getlunbo(final OnNetListine<LunBoBean> onNetListine){
        RetrofitHolder.getApi().lunbo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LunBoBean>() {
                    @Override
                    public void accept(LunBoBean lunBoBean) throws Exception {
                        onNetListine.OnSucc(lunBoBean);
                    }
                });
    }
}
