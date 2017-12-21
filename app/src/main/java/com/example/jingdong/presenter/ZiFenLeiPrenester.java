package com.example.jingdong.presenter;

import com.example.jingdong.bean.XiangQingBean;
import com.example.jingdong.model.ZiFenLeiModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.IXiangQing;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZiFenLeiPrenester {
    IXiangQing iXiangQing;
    ZiFenLeiModel ziFenLeiModel;

    public ZiFenLeiPrenester(IXiangQing iXiangQing) {
        this.iXiangQing = iXiangQing;
        ziFenLeiModel=new ZiFenLeiModel();
    }
    public void getshowZi(String pscid){
        ziFenLeiModel.getZi(pscid, new OnNetListine<XiangQingBean>() {
            @Override
            public void OnSucc(XiangQingBean xiangQingBean) {

                iXiangQing.showzi(xiangQingBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
