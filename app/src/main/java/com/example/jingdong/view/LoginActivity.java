package com.example.jingdong.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdong.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMyImage;
    /**
     * 京东登录
     */
    private TextView mMyTitle;
    /**
     * 账号
     */
    private TextView mMyUser;
    /**
     * 用户名/邮箱/手机号
     */
    private EditText mMyShu;
    /**
     * 密码
     */
    private TextView mMyPassword;
    /**
     * 请输入密码
     */
    private EditText mEditText3;
    private ImageView mImageView3;
    private ImageView mImageView4;
    /**
     * 登录
     */
    private Button mMyButLogin;
    /**
     * 注册账号
     */
    private TextView mMyTvZhuce;
    /**
     * 忘记密码?
     */
    private TextView mMyTvWang;
    private ImageView mMyQqLogin;
    private ImageView mMyWeixinLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        mMyImage = (ImageView) findViewById(R.id.my_image);
        mMyImage.setOnClickListener(this);
        mMyTitle = (TextView) findViewById(R.id.my_title);
        mMyTitle.setOnClickListener(this);
        mMyUser = (TextView) findViewById(R.id.my_user);
        mMyUser.setOnClickListener(this);
        mMyShu = (EditText) findViewById(R.id.my_shu);
        mMyShu.setOnClickListener(this);
        mMyPassword = (TextView) findViewById(R.id.my_password);
        mMyPassword.setOnClickListener(this);
        mEditText3 = (EditText) findViewById(R.id.editText3);
        mEditText3.setOnClickListener(this);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mImageView3.setOnClickListener(this);
        mImageView4 = (ImageView) findViewById(R.id.imageView4);
        mImageView4.setOnClickListener(this);
        mMyButLogin = (Button) findViewById(R.id.my_but_login);
        mMyButLogin.setOnClickListener(this);
        mMyTvZhuce = (TextView) findViewById(R.id.my_tv_zhuce);
        mMyTvZhuce.setOnClickListener(this);
        mMyTvWang = (TextView) findViewById(R.id.my_tv_wang);
        mMyTvWang.setOnClickListener(this);
        mMyQqLogin = (ImageView) findViewById(R.id.my_qq_login);
        mMyQqLogin.setOnClickListener(this);
        mMyWeixinLogin = (ImageView) findViewById(R.id.my_weixin_login);
        mMyWeixinLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_image:
                finish();
                break;
            case R.id.my_title:
                break;
            case R.id.my_user:
                break;
            case R.id.my_shu:
                break;
            case R.id.my_password:
                break;
            case R.id.editText3:
                break;
            case R.id.imageView3:
                break;
            case R.id.imageView4:
                break;
            case R.id.my_but_login:

                break;
            case R.id.my_tv_zhuce:
                Intent intent = new Intent(this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.my_tv_wang:
                break;
            case R.id.my_qq_login:
                break;
            case R.id.my_weixin_login:
                break;
        }
    }
}
