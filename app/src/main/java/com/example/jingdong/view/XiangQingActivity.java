package com.example.jingdong.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jingdong.R;
import com.example.jingdong.adapter.ZiFenLeiAdapter;
import com.example.jingdong.bean.XiangQingBean;
import com.example.jingdong.presenter.ZiFenLeiPrenester;

import java.util.List;

public class XiangQingActivity extends AppCompatActivity implements IXiangQing {

    private String pscid;
    private RecyclerView mZiFenLeiRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        Intent intent = getIntent();
        pscid = intent.getStringExtra("pscid");
        Toast.makeText(XiangQingActivity.this, pscid, Toast.LENGTH_LONG).show();

        ZiFenLeiPrenester ziFenLeiPrenester = new ZiFenLeiPrenester(this);
        ziFenLeiPrenester.getshowZi(pscid);
    }

    @Override
    public String getpscid() {
        return pscid;
    }

    @Override
    public void showzi(XiangQingBean xiangQingBean) {
        ZiFenLeiAdapter ziFenLeiAdapter = new ZiFenLeiAdapter(this,xiangQingBean.getData());
        mZiFenLeiRv.setAdapter(ziFenLeiAdapter);
    }

    private void initView() {
        mZiFenLeiRv = (RecyclerView) findViewById(R.id.ZiFenLeiRv);
        mZiFenLeiRv.setLayoutManager(new LinearLayoutManager(this));
    }
}
