package com.retrofit.recyclerview.common.rest;


import com.retrofit.recyclerview.common.model.restaurant.RestaurantResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NetworkAPI {

    @Headers("user-key" +":"+ NetworkService.USER_KEY)
    @GET("api/v2.1/search")
    Call<RestaurantResponse> getRestuarantResponse(@Query("entity_id") int entity_id,
                                                   @Query("entity_type") String entity_type,
                                                   @Query("q") String q,
                                                   @Query("lat") double lat,
                                                   @Query("lon") double lon,
                                                   @Query("radius") int radius);

}
