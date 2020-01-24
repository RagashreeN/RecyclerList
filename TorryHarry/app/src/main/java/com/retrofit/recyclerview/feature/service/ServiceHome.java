package com.retrofit.recyclerview.feature.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.retrofit.recyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceHome extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.startService)
    Button startService;
    @BindView(R.id.stopService)
    Button stopService;

    private Intent intentService;
    private boolean mStopLoop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

        intentService = new Intent(getApplicationContext(),ServiceMainClass.class);
    }

    @OnClick({R.id.startService, R.id.stopService})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.startService:
                mStopLoop = true;
                startService(intentService);
                break;
            case R.id.stopService:
                stopService(intentService);
                break;
        }
    }
}
