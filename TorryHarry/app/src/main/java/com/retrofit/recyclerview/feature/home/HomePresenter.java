package com.retrofit.recyclerview.feature.home;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.retrofit.recyclerview.common.model.restaurant.RestaurantResponse;
import com.retrofit.recyclerview.common.utils.MainApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter extends MvpBasePresenter<HomeView> {
    HomeView homeView;
    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    /*Note : Calling the getRestuarantResponse in NetworkAPI class and fetching the response*/
    public void getSearchList(int entity_id,String entity_type,String q,double lat,double lon,int radius){
        if(homeView.isNetworkAvailable()){
            homeView.showOrHideProgress(true);
            Call call = MainApplication.networkService.getNetworkAPI()
                    .getRestuarantResponse(entity_id,entity_type,q,lat,lon,radius);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    homeView.showOrHideProgress(false);
                    RestaurantResponse restaurantResponse = (RestaurantResponse) response.body();
                    homeView.getResponse(restaurantResponse);
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    homeView.showOrHideProgress(false);
                }
            });
        }
    }
}
