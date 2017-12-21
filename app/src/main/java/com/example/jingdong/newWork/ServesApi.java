package com.example.jingdong.newWork;

import com.example.jingdong.bean.AddSBean;
import com.example.jingdong.bean.CartBean;
import com.example.jingdong.bean.GoodsBean;
import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.bean.SouSuoBean;
import com.example.jingdong.bean.UserBean;
import com.example.jingdong.bean.XiangQingBean;
import com.example.jingdong.bean.ZiFenLeiXiangBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public interface ServesApi {

    @GET(UrlUtils.TAG)
    Flowable<UserBean> tags();

    @GET(UrlUtils.ZUO)
    Flowable<GoodsBean> goods(@Query("cid") String cid);

    @GET(UrlUtils.XIANG)
    Flowable<XiangQingBean> xiang(@Query("pscid") String pscid);

    @GET(UrlUtils.FEN)
    Flowable<ZiFenLeiXiangBean> ZiFenLeiXiang(@Query("pid") String pid,@Query("source") String str);//传入公共参数

    @GET(UrlUtils.LUNBO)
    Flowable<LunBoBean> lunbo();

    @GET(UrlUtils.SOU)
    Flowable<SouSuoBean> sou(@Query("keywords") String keywords,@Query("source") String str);

    @GET(UrlUtils.ADD)
    Flowable<AddSBean> adds(@Query("pid") String pid,@Query("source") String str);

    @GET(UrlUtils.SELECT)
    Flowable<CartBean> selects(@Query("source") String str);

}
