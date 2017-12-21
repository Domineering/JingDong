package com.example.jingdong.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdong.R;
import com.example.jingdong.bean.AddSBean;
import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.bean.ZiFenLeiXiangBean;
import com.example.jingdong.presenter.AddPresenter;
import com.example.jingdong.presenter.LunBoPrenester;
import com.example.jingdong.presenter.ZiFenLeiXiangPrenester;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class ZiFenLeiXiang extends AppCompatActivity implements IZiFenLeiXiang, IlunBo,IAddActivity, View.OnClickListener {

    private String pid;
    private Banner mBanner;
    private List<String> listimg = new ArrayList<>();
    /**
     * TextView
     */
    private TextView mTextView;
    /**
     * TextView
     */
    private TextView mTextView2;
    /**
     * 加入购物车
     */
    private Button mTvJiaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_fen_lei_xiang);
        initView();
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");

        LunBoPrenester lunBoPrenester = new LunBoPrenester(this);
        lunBoPrenester.getShowLunBo();
        //实例化P层
        ZiFenLeiXiangPrenester ziFenLeiXiangPrenester = new ZiFenLeiXiangPrenester(this);
        ziFenLeiXiangPrenester.getShowZiFen(pid);


    }

    @Override
    public String getid() {
        return pid;
    }

    @Override
    public void showZiFenLeiXiang(ZiFenLeiXiangBean ziFenLeiXiangBean) {
        ZiFenLeiXiangBean.DataBean data = ziFenLeiXiangBean.getData();
        mTextView.setText(data.getTitle());
        mTextView2.setText("¥" + data.getPrice() + "");
    }

    @Override
    public void showLunBo(LunBoBean lunBoBean) {
        List<LunBoBean.DataBean> data = lunBoBean.getData();
        for (int i = 0; i < data.size(); i++) {
            LunBoBean.DataBean dataBean = data.get(i);
            listimg.add(dataBean.getIcon());
        }
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(listimg);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTvJiaru = (Button) findViewById(R.id.tv_jiaru);
        mTvJiaru.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_jiaru:
                AddPresenter addPresenter=new AddPresenter(this);
                addPresenter.getshow(pid);
                break;
        }
    }

    @Override
    public String getpid() {
        return pid;
    }

    @Override
    public void addshow(AddSBean addSBean) {
        Toast.makeText(this,addSBean.getMsg(),Toast.LENGTH_LONG).show();
    }
}
