package com.retrofit.recyclerview.common.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retrofit.recyclerview.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    public static NetworkService instance = null;
    private Retrofit retrofit;
    private NetworkAPI networkAPI;

    public static final String USER_KEY = "eedf7dc822b2f9219d02afe92e12af59";

    public NetworkService(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client).build();
        networkAPI = retrofit.create(NetworkAPI.class);
    }

    public static NetworkService getInstance(){
        if(instance==null){
            instance = new NetworkService();
        }
        return instance;
    }

    public NetworkAPI getNetworkAPI() {
        return networkAPI;
    }
}
