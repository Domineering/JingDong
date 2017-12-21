package com.example.jingdong.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdong.R;

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mZhuceFan;
    /**
     * 快速注册
     */
    private TextView mZhuceTitle;
    /**
     * 账号
     */
    private TextView mZhuceUser;
    /**
     * 邮箱/手机号/账号
     */
    private EditText mZhuceUserShu;
    /**
     * 密码
     */
    private TextView mZhucePassword;
    /**
     * 请输入密码
     */
    private EditText mEditText4;
    /**
     * 注册
     */
    private Button mZhuceBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initView();
    }

    private void initView() {
        mZhuceFan = (ImageView) findViewById(R.id.zhuce_fan);
        mZhuceFan.setOnClickListener(this);
        mZhuceTitle = (TextView) findViewById(R.id.zhuce_title);
        mZhuceTitle.setOnClickListener(this);
        mZhuceUser = (TextView) findViewById(R.id.zhuce_user);
        mZhuceUser.setOnClickListener(this);
        mZhuceUserShu = (EditText) findViewById(R.id.zhuce_user_shu);
        mZhuceUserShu.setOnClickListener(this);
        mZhucePassword = (TextView) findViewById(R.id.zhuce_password);
        mZhucePassword.setOnClickListener(this);
        mEditText4 = (EditText) findViewById(R.id.editText4);
        mEditText4.setOnClickListener(this);
        mZhuceBut = (Button) findViewById(R.id.zhuce_but);
        mZhuceBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zhuce_fan:
                finish();
                break;
            case R.id.zhuce_title:
                break;
            case R.id.zhuce_user:
                break;
            case R.id.zhuce_user_shu:
                break;
            case R.id.zhuce_password:
                break;
            case R.id.editText4:
                break;
            case R.id.zhuce_but:
                break;
        }
    }
}
