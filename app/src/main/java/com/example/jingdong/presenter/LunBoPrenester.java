package com.example.jingdong.presenter;

import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.model.LunBoModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.IZiFenLeiXiang;
import com.example.jingdong.view.IlunBo;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class LunBoPrenester {
IlunBo ilunBo;
LunBoModel lunBoModel;

    public LunBoPrenester(IlunBo ilunBo) {
        this.ilunBo = ilunBo;
        lunBoModel=new LunBoModel();
    }
    public void getShowLunBo(){
        lunBoModel.getlunbo(new OnNetListine<LunBoBean>() {
            @Override
            public void OnSucc(LunBoBean lunBoBean) {
                ilunBo.showLunBo(lunBoBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
