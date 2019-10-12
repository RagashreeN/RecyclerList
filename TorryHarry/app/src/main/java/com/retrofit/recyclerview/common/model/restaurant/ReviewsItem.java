package com.retrofit.recyclerview.common.model.restaurant;


import com.google.gson.annotations.SerializedName;


public class ReviewsItem{

	@SerializedName("review")
	private Review review;

	public void setReview(Review review){
		this.review = review;
	}

	public Review getReview(){
		return review;
	}

	@Override
 	public String toString(){
		return 
			"ReviewsItem{" + 
			"review = '" + review + '\'' + 
			"}";
		}
}