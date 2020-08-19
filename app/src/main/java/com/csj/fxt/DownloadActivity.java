package com.csj.fxt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class DownloadActivity extends AppCompatActivity implements View.OnClickListener {


    private ProgressBar mProgress;
    private Button mBtn;
    private Button mInstalling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initView();

    }

    private void initView() {

        mProgress = (ProgressBar) findViewById(R.id.progress);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mInstalling = (Button) findViewById(R.id.installing);
        mInstalling.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/08/18
                break;
            case R.id.installing:
                // TODO 20/08/18
                break;
            default:
                break;
        }
    }
}
