package com.retrofit.recyclerview.feature.NewConcepts;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class ViewModelActivity extends ViewModel {

    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber(){
        if(myRandomNumber == null){
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }

        return myRandomNumber;
    }

    public void createNumber(){
        Random random = new Random();
        //myRandomNumber = "Number : "+(random.nextInt(10-1)+1);
        myRandomNumber.setValue("Number : "+(random.nextInt(10-1)+1));
    }
}
