package com.retrofit.recyclerview.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.retrofit.recyclerview.R;
import com.retrofit.recyclerview.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        ViewModelActivity viewModel = ViewModelProviders.of(this).get(ViewModelActivity.class);

        binding.setViewmodel(viewModel);

        viewModel.loginListener = this;
    }

    @Override
    public void onSuccess(String strSuccessMsg) {
        Toast.makeText(this, strSuccessMsg, Toast.LENGTH_SHORT).show();
    }
}
