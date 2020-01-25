package com.retrofit.recyclerview.ui;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

public class ViewModelActivity extends ViewModel {
    LoginListener loginListener = new LoginActivity();
    public void onLoginButtonClick(View view){
        loginListener.onSuccess("MVVM is done");
    }
}
