package com.example.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdong.R;
import com.example.jingdong.adapter.HomeAdapter;
import com.example.jingdong.adapter.WeiNiAdapter;
import com.example.jingdong.bean.LunBoBean;
import com.example.jingdong.bean.UserBean;
import com.example.jingdong.presenter.LunBoPrenester;
import com.example.jingdong.presenter.ShowPrenester;
import com.example.jingdong.view.GlideImageLoader;
import com.example.jingdong.view.ISuccessActivity;
import com.example.jingdong.view.IlunBo;
import com.example.jingdong.view.MainActivity;
import com.example.jingdong.view.MipcaActivityCapture;
import com.example.jingdong.view.SouSuoActivity;
import com.youth.banner.Banner;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 绅丶士 on 2017/12/12.
 */

public class HomePageFragment extends Fragment implements IlunBo, ISuccessActivity, View.OnClickListener {
    private View view;
    private Banner mHomeBanner;
    private List<String> listimg = new ArrayList<>();
    private RecyclerView mHomeRev;
    private RecyclerView mWeiniRv;
    /**
     * 请输入关键字
     */
    private EditText mEditText;
    private ImageView mImageView;
    private ImageView mImageView2;
    /**
     * 扫啊扫
     */
    private TextView mTextView3;
    /**
     * 搜索
     */
    private Button mButSou;
    private LunBoPrenester lunBoPrenester;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm01_item, container, false);
        initView(view);
        lunBoPrenester = new LunBoPrenester(this);
        lunBoPrenester.getShowLunBo();

        ShowPrenester showPrenester = new ShowPrenester(this);
        showPrenester.getData();
        return view;

    }

    private void initView(View view) {
        mHomeBanner = (Banner) view.findViewById(R.id.home_banner);
        mHomeRev = (RecyclerView) view.findViewById(R.id.home_rev);
        mHomeRev.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        mWeiniRv = (RecyclerView) view.findViewById(R.id.weini_rv);
        mWeiniRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mEditText = (EditText) view.findViewById(R.id.editText);
        mImageView = (ImageView) view.findViewById(R.id.imageView);
        mImageView2 = (ImageView) view.findViewById(R.id.imageView2);
        mTextView3 = (TextView) view.findViewById(R.id.textView3);
        mButSou = (Button) view.findViewById(R.id.but_sou);
        mButSou.setOnClickListener(this);
        mImageView2.setOnClickListener(this);
    }

    @Override
    public void showLunBo(LunBoBean lunBoBean) {
        WeiNiAdapter weiNiAdapter = new WeiNiAdapter(getActivity(), lunBoBean.getTuijian().getList());
        mWeiniRv.setAdapter(weiNiAdapter);
        List<LunBoBean.DataBean> data = lunBoBean.getData();
        for (int i = 0; i < data.size(); i++) {
            LunBoBean.DataBean dataBean = data.get(i);
            listimg.add(dataBean.getIcon());
        }
        mHomeBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mHomeBanner.setImages(listimg);
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start();
    }

    @Override
    public void show(UserBean userBean) {
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), userBean.getData());
        mHomeRev.setAdapter(homeAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but_sou:
                String s = mEditText.getText() .toString();
                if(TextUtils.isEmpty(s)){
                    Toast.makeText(getActivity(),"搜索框不能为空",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getActivity(), SouSuoActivity.class);
                    intent.putExtra("sou", s);
                    startActivity(intent);
                }
                break;
            case R.id.imageView2:
                //扫描二维码
                Intent intent1 = new Intent(getActivity(), MipcaActivityCapture.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent1, 1);
                break;
        }
    }
}
