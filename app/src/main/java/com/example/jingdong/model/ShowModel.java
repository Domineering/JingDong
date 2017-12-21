package com.example.jingdong.model;

import com.example.jingdong.bean.UserBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class ShowModel implements IShowModel{
    @Override
    public void shuju(final OnNetListine<UserBean> onNetListine) {
        RetrofitHolder.getApi().tags()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        onNetListine.OnSucc(userBean);
                    }
                });
    }
}
