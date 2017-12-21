package com.example.jingdong.fragment;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.jingdong.R;
import com.example.jingdong.adapter.ClassZuoAdapter;
import com.example.jingdong.adapter.ZuoAdapter;
import com.example.jingdong.bean.GoodsBean;
import com.example.jingdong.bean.UserBean;
import com.example.jingdong.newWork.SetOnClicklistener;
import com.example.jingdong.presenter.ShowPrenester;
import com.example.jingdong.presenter.ZuoPrenester;
import com.example.jingdong.view.IClassActivity;
import com.example.jingdong.view.ISuccessActivity;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class ClassifyFragment extends Fragment implements ISuccessActivity,SetOnClicklistener,IClassActivity{
    private View view;
    private RecyclerView mRv;
    private ExpandableListView elv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm02_item, container, false);
        ShowPrenester showPrenester=new ShowPrenester(this);
        showPrenester.getData();
        initView(view);
        return view;

    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rvv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        elv = view.findViewById(R.id.elv);
    }

    @Override
    public void show(UserBean userBean) {
        ClassZuoAdapter classZuoAdapter = new ClassZuoAdapter(getActivity(),userBean.getData(),this);
        mRv.setAdapter(classZuoAdapter);
    }
    @Override
    public void OnClikLinter(String url){
        ZuoPrenester zuoPrenester=new ZuoPrenester(this);
        zuoPrenester.getzuoshow(url);
        Log.d("TAG",url);
    }

    @Override
    public void showZuo(List<GoodsBean.DataBean> groupList, List<List<GoodsBean.DataBean.ListBean>> childList) {
        ZuoAdapter zuoAdapter = new ZuoAdapter(getActivity(), groupList, childList);
        elv.setAdapter(zuoAdapter);
        elv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < groupList.size(); i++) {
            elv.expandGroup(i);
        }
    }
}
