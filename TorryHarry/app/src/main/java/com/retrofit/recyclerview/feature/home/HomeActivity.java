package com.retrofit.recyclerview.feature.home;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.SearchView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.retrofit.recyclerview.R;
import com.retrofit.recyclerview.common.adapter.ListRecyclerAdapter;
import com.retrofit.recyclerview.common.model.restaurant.RestaurantResponse;
import com.retrofit.recyclerview.common.model.restaurant.RestaurantsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*Note : HomeActivity which has the search field and display the list of restuarant */
public class HomeActivity extends MvpActivity<HomeView, HomePresenter> implements HomeView, LocationListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.frame_progress)
    FrameLayout frameProgress;
    @BindView(R.id.search_view)
    SearchView searchView;

    /*Note : Adapter class reference for recyclerview*/
    ListRecyclerAdapter listAdapter;
    /*Note : Arraylist of RestaurantsItem*/
    private List<RestaurantsItem> listdata = new ArrayList<>();

    /*Note : The minimum distance to change Updates in meters*/
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
    /*Note : The minimum time between updates in milliseconds*/
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    protected LocationManager locationManager;
    protected Context context;
    protected boolean gps_enabled, network_enabled;
    protected double lat, lon;
    private String provider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*Note : Initializing UI*/
        initializeUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    /*Note : Initializing UI  and for functionality*/
    public void initializeUI() {
        /*Note : context initialize*/
        context = this;

        /*Note : LocationManager initialize*/
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        /*Note : Choosing the best criteria depending on what is available.*/
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        provider = LocationManager.GPS_PROVIDER; // We want to use the GPS

        /*Note : Asking for permission*/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    111);
        } else {
            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
        }

        /*Note : Searchview setting initialization*/
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /*Note : Showing the loading progress bar*/
                showOrHideProgress(true);
                /*Note : Calling search api by passing sarch string*/
                callRestaurantAPI(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*Note : Showing the loading progress bar*/
                showOrHideProgress(true);
                /*Note : Calling search api by passing sarch string*/
                callRestaurantAPI(newText);
                return false;
            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showOrHideProgress(true);
                callRestaurantAPI("");
            }
        }, 2000);
    }

    /*Note : Calling the api*/
    private void callRestaurantAPI(String query) {
        int entity_id = 4;
        String entity_type = "city";
        int radius = 100;
        /*Note : If lat and lon is not available, making the static lat lon*/
        if (lat == 0) {
            lat = 12.8504514;
        }
        if (lon == 0) {
            lon = 77.6722879;
        }
        /*Note : Calling the api through presenter class*/
        presenter.getSearchList(entity_id, entity_type, query, lat, lon, radius);
    }

    @Override
    public boolean isNetworkAvailable() {
        /*Note : Checking for internet*/
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    @Override
    public void showOrHideProgress(boolean showOrHide) {
        /*Note : Showing or hiding Progressbar*/
        if (showOrHide) {
            frameProgress.setVisibility(View.VISIBLE);
        } else {
            frameProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void getResponse(RestaurantResponse restaurantResponse) {
        if (restaurantResponse != null && restaurantResponse.getRestaurants() != null) {
            /*Note : Initializing and Setting Adapter*/
            listdata.clear();
            listdata.addAll(restaurantResponse.getRestaurants());
            /*Note : Initializing the adapter*/
            listAdapter = new ListRecyclerAdapter(listdata, this, this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(listAdapter);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        /*Note : Latitute and longitute fetching*/
        lat = location.getLatitude();
        lon = location.getLongitude();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            /*Note : If permission is given then asking for location update*/
            case 111:
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        /*Note : For keyboard hiding*/
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
