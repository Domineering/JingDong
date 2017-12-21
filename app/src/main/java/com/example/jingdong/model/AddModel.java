package com.example.jingdong.model;

import com.example.jingdong.bean.AddSBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/18.
 */

public class AddModel{
    public void getadd(String pid, final OnNetListine<AddSBean> onNetListine){
        RetrofitHolder.getApi().adds(pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddSBean>() {
                    @Override
                    public void accept(AddSBean addSBean) throws Exception {
                        onNetListine.OnSucc(addSBean);
                    }
                });
    }
}
