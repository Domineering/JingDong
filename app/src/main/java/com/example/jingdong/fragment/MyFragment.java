package com.example.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdong.R;
import com.example.jingdong.view.LoginActivity;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView mXiaoxi;
    private ImageView mTou;
    /**
     * 登录/注册 >
     */
    private TextView mLogin;
    private ImageView mZhi;
    private ImageView mWei;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm05_item, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        mXiaoxi = (ImageView) view.findViewById(R.id.xiaoxi);
        mTou = (ImageView) view.findViewById(R.id.tou);
        mLogin = (TextView) view.findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mZhi = (ImageView) view.findViewById(R.id.zhi);
        mWei = (ImageView) view.findViewById(R.id.wei);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
