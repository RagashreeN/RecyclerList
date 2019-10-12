package com.retrofit.recyclerview.common.model.restaurant;


import com.google.gson.annotations.SerializedName;


public class ShareData{

	@SerializedName("should_show")
	private int shouldShow;

	public void setShouldShow(int shouldShow){
		this.shouldShow = shouldShow;
	}

	public int getShouldShow(){
		return shouldShow;
	}

	@Override
 	public String toString(){
		return 
			"ShareData{" + 
			"should_show = '" + shouldShow + '\'' + 
			"}";
		}
}