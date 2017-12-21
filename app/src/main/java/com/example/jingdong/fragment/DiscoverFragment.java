package com.example.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jingdong.R;
import com.example.jingdong.view.XianDianYing;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class DiscoverFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 点击观看小电影
     */
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm03_item, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                Intent intent = new Intent(getActivity(), XianDianYing.class);
                startActivity(intent);
                break;
        }
    }
}

