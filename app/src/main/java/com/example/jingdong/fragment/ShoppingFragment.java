package com.example.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jingdong.MyEventBus.MessageEvent;
import com.example.jingdong.MyEventBus.PriceAndCountEvent;
import com.example.jingdong.R;
import com.example.jingdong.adapter.SelectAdapter;
import com.example.jingdong.bean.CartBean;
import com.example.jingdong.presenter.SelectPrenester;
import com.example.jingdong.view.ISelectActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class ShoppingFragment extends Fragment implements ISelectActivity {
    private View view;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private SelectAdapter selectAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm04_item, container, false);
        EventBus.getDefault().register(this);
        final SelectPrenester selectPrenester = new SelectPrenester(this);
        selectPrenester.getselects();
        initView(view);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    @Override
    public void getselect(List<CartBean.DataBean> groupchild, List<List<CartBean.DataBean.ListBean>> childlist) {
        selectAdapter = new SelectAdapter(getActivity(), groupchild, childlist);
        mElv.setAdapter(selectAdapter);
        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < groupchild.size(); i++) {
            mElv.expandGroup(i);
        }
    }

    private void initView(View view) {
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }
    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }
}
