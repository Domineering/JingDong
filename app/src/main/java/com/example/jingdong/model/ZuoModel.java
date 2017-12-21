package com.example.jingdong.model;

import com.example.jingdong.bean.GoodsBean;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZuoModel {

    public void getzuo(String cid, final OnNetListine<GoodsBean> onNetListine){
        RetrofitHolder.getApi().goods(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsBean>() {
                    @Override
                    public void accept(GoodsBean goodsBean) throws Exception {
                        onNetListine.OnSucc(goodsBean);
                    }
                });
    }
}
