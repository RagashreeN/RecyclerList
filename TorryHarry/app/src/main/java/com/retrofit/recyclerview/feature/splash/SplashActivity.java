package com.retrofit.recyclerview.feature.splash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.retrofit.recyclerview.R;
import com.retrofit.recyclerview.feature.home.HomeActivity;

/*Note : SplashActivity for the screen screen display and asking for the runtime location permission*/
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Note : For making the screen with no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*Note :  Setting the layout into the screen*/
        setContentView(R.layout.splash_main);
        /*Note : Checking for the Location permission is available or not*/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            /*Note : Asking the runtime ACCESS_FINE_LOCATION permission for location*/
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    111);
        } else {
            /*Note : If already permimssion available then it will move on to the */
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 111:
                /*Note : Calling the HomeActivity in post delay handler*/
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
                break;
        }
    }

}
