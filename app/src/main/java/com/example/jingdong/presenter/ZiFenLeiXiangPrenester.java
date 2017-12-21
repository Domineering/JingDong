package com.example.jingdong.presenter;

import com.example.jingdong.bean.ZiFenLeiXiangBean;
import com.example.jingdong.model.ZiFenLeiXiangModel;
import com.example.jingdong.newWork.OnNetListine;
import com.example.jingdong.view.IZiFenLeiXiang;

/**
 * Created by 绅丶士 on 2017/12/13.
 */

public class ZiFenLeiXiangPrenester {
    IZiFenLeiXiang iZiFenLeiXiang;
    ZiFenLeiXiangModel ziFenLeiXiangModel;

    public ZiFenLeiXiangPrenester(IZiFenLeiXiang iZiFenLeiXiang) {
        this.iZiFenLeiXiang = iZiFenLeiXiang;
        ziFenLeiXiangModel=new ZiFenLeiXiangModel();
    }
    public void getShowZiFen(String pid){
        ziFenLeiXiangModel.getFen(pid, new OnNetListine<ZiFenLeiXiangBean>() {
            @Override
            public void OnSucc(ZiFenLeiXiangBean ziFenLeiXiangBean) {
                iZiFenLeiXiang.showZiFenLeiXiang(ziFenLeiXiangBean);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }
}
