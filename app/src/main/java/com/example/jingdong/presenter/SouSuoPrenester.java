package com.example.jingdong.presenter;

import com.example.jingdong.bean.SouSuoBean;
import com.example.jingdong.model.SouSuoModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.ISouSuoActivity;

/**
 * Created by 绅丶士 on 2017/12/15.
 */

public class SouSuoPrenester {
    ISouSuoActivity iSouSuoActivity;
    SouSuoModel souSuoModel;

    public SouSuoPrenester(ISouSuoActivity iSouSuoActivity) {
        this.iSouSuoActivity = iSouSuoActivity;
        souSuoModel=new SouSuoModel();
    }
    public void getsou(String sou){
        souSuoModel.getsousuo(sou, new OnNetListine<SouSuoBean>() {
            @Override
            public void OnSucc(SouSuoBean souSuoBean) {
                iSouSuoActivity.getsousuo(souSuoBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }

}
