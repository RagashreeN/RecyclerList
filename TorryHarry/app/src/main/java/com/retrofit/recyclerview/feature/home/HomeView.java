package com.retrofit.recyclerview.feature.home;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.retrofit.recyclerview.common.model.restaurant.RestaurantResponse;

public interface HomeView extends MvpView {
    boolean isNetworkAvailable();
    public void showOrHideProgress(boolean showOrHide);
    public void getResponse(RestaurantResponse restaurantResponse);
}
