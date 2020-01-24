package com.retrofit.recyclerview.feature.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class ServiceMainClass extends Service {
    boolean mIsRandomGeneratorOn;
    int randomNumber;

    private final int MIN = 0;
    private final int MAX = 100;


    class MyServiceBinder extends Binder{
        public ServiceMainClass getService(){
            return ServiceMainClass.this;
        }
    }

    private Binder iBinder = new MyServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomGenerator();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mIsRandomGeneratorOn = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomGenerator();
            }
        }).start();
        return START_STICKY;
    }

    private void startRandomGenerator(){
        while (mIsRandomGeneratorOn){
            try{
                Thread.sleep(1000);
                if(mIsRandomGeneratorOn){
                    randomNumber = new Random().nextInt(MAX)+MIN;
                    Log.i("Thread id: "+Thread.currentThread().getId()," Random : "+randomNumber);
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    private void stopRandomGenerator(){
        mIsRandomGeneratorOn = false;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public int getRandomNumber(){
        return randomNumber;
    }
}
