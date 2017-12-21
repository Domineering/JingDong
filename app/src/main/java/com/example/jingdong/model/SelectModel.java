package com.example.jingdong.model;

import com.example.jingdong.bean.CartBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/18.
 */

public class SelectModel {
    public void getselect(final OnNetListine<CartBean> onNetListine){
        RetrofitHolder.getApi().selects("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onNetListine.OnSucc(cartBean);
                    }
                });
    }
}
