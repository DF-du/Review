package com.csj.fxt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private ImageView mImg;
    private TextView mResult;
    private Timer timer;
    private int i = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mImg = (ImageView) findViewById(R.id.img);
        mResult = (TextView) findViewById(R.id.result);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        mImg.startAnimation(animation);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i == 0) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));

                        }
                        mResult.setText(i + "s");
                        i--;
                    }
                });
            }
        }, 1000, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
