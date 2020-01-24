package com.retrofit.recyclerview.feature.NewConcepts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.retrofit.recyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*Note : This package to study about ViewModel,LiveData,DataBinding and MVVM*/
public class NewConceptActivity extends AppCompatActivity {


    @BindView(R.id.btnFetchData)
    Button btnFetchData;
    @BindView(R.id.tvDisplayData)
    TextView tvDisplayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_concept_layout);
        ButterKnife.bind(this);

        ViewModelActivity viewModelActivity = ViewModelProviders.of(this).get(ViewModelActivity.class);
        LiveData<String> randomNumber = viewModelActivity.getNumber();
        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvDisplayData.setText(s);
            }
        });
    }


    @OnClick(R.id.btnFetchData)
    public void onViewClicked() {
        ViewModelActivity viewModelActivity = ViewModelProviders.of(this).get(ViewModelActivity.class);
        viewModelActivity.createNumber();
    }
}
