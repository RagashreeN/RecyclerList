package com.retrofit.recyclerview.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.retrofit.recyclerview.R;
import com.retrofit.recyclerview.common.model.restaurant.RestaurantsItem;
import com.retrofit.recyclerview.feature.home.HomeView;

import java.util.List;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder>{
    private List<RestaurantsItem> listdata;
    private Context context;
    private HomeView homeView;
    public ListRecyclerAdapter(List<RestaurantsItem> listdata, Context context, HomeView homeView) {
        this.listdata = listdata;
        this.context = context;
        this.homeView = homeView;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final RestaurantsItem myListData = listdata.get(position);
        if(myListData.getRestaurant() != null) {
            holder.textView.setText(myListData.getRestaurant().getName());

            holder.tvDescription.setText(myListData.getRestaurant().getCuisines());

            if (myListData.getRestaurant().getThumb() != null) {
                Glide.with(context)
                        .load(myListData.getRestaurant().getThumb())
                        .apply(new RequestOptions().fitCenter().placeholder(
                                ContextCompat.getDrawable(context, R.drawable.place_holder)
                        ).dontAnimate())
                        .into(holder.imageView);
            }
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, myListData.getRestaurant().getName() + " is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView,tvDescription;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.tvList);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tvListDescription);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_listItem);
        }
    }
}
