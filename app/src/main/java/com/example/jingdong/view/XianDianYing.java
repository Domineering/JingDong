package com.example.jingdong.view;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.dl7.player.media.IjkPlayerView;
import com.example.jingdong.R;

public class XianDianYing extends AppCompatActivity {

    private IjkPlayerView mPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_dian_ying);
        initView();
        mPlayerView = (IjkPlayerView) findViewById(R.id.player_view);
        Uri mUri = Uri.parse("http://ips.ifeng.com/video19.ifeng" +
                ".com/video09/2014/06/16/1989823-102-086-0009.mp4");

        mPlayerView.init()
                .setVideoPath(mUri)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                .enableDanmaku()
                .start();
    }

    private void initView() {
        mPlayerView = (IjkPlayerView) findViewById(R.id.player_view);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPlayerView.configurationChanged(newConfig);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
