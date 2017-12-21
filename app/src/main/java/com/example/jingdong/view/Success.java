package com.example.jingdong.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jingdong.R;
import com.example.jingdong.fragment.ClassifyFragment;
import com.example.jingdong.fragment.DiscoverFragment;
import com.example.jingdong.fragment.HomePageFragment;
import com.example.jingdong.fragment.MyFragment;
import com.example.jingdong.fragment.ShoppingFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.youth.banner.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class Success extends AppCompatActivity {
    private BottomTabBar mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);
        AdDialog dialog = new AdDialog(this);
        dialog.show();
        mb.init(getSupportFragmentManager())
                .setImgSize(130,130)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("",R.mipmap.ac0, HomePageFragment.class)
                .addTabItem("",R.mipmap.abw, ClassifyFragment.class)
                .addTabItem("",R.mipmap.aby, DiscoverFragment.class)
                .addTabItem("",R.mipmap.abu, ShoppingFragment.class)
                .addTabItem("",R.mipmap.ac2, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

}
