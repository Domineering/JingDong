package com.example.jingdong.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jingdong.R;
import com.example.jingdong.adapter.SouSuoAdapter;
import com.example.jingdong.bean.SouSuoBean;
import com.example.jingdong.presenter.SouSuoPrenester;

public class SouSuoActivity extends AppCompatActivity implements ISouSuoActivity {

    private String sou;
    private RecyclerView mSousuoRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        initView();
        Intent intent = getIntent();
        sou = intent.getStringExtra("sou");
        Toast.makeText(this, sou, Toast.LENGTH_LONG).show();
        SouSuoPrenester souSuoPrenester = new SouSuoPrenester(this);
        souSuoPrenester.getsou(sou);
    }

    @Override
    public String gets() {
        return sou;
    }

    @Override
    public void getsousuo(SouSuoBean souSuoBean) {
        SouSuoAdapter souSuoAdapter = new SouSuoAdapter(this, souSuoBean.getData());
        mSousuoRv.setAdapter(souSuoAdapter);
    }

    private void initView() {
        mSousuoRv = (RecyclerView) findViewById(R.id.sousuo_rv);
        mSousuoRv.setLayoutManager(new LinearLayoutManager(this));
    }
}
