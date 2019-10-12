package com.retrofit.recyclerview.common.model.restaurant;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Event{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("photos")
	private List<PhotosItem> photos;

	@SerializedName("event_category_name")
	private String eventCategoryName;

	@SerializedName("friendly_end_date")
	private String friendlyEndDate;

	@SerializedName("friendly_timing_str")
	private String friendlyTimingStr;

	@SerializedName("disclaimer")
	private String disclaimer;

	@SerializedName("start_date")
	private String startDate;

	@SerializedName("show_share_url")
	private int showShareUrl;

	@SerializedName("types")
	private List<Object> types;

	@SerializedName("is_active")
	private int isActive;

	@SerializedName("end_time")
	private String endTime;

	@SerializedName("is_end_time_set")
	private int isEndTimeSet;

	@SerializedName("event_category")
	private int eventCategory;

	@SerializedName("share_data")
	private ShareData shareData;

	@SerializedName("display_time")
	private String displayTime;

	@SerializedName("start_time")
	private String startTime;

	@SerializedName("date_added")
	private String dateAdded;

	@SerializedName("friendly_start_date")
	private String friendlyStartDate;

	@SerializedName("event_id")
	private int eventId;

	@SerializedName("display_date")
	private String displayDate;

	@SerializedName("share_url")
	private String shareUrl;

	@SerializedName("is_valid")
	private int isValid;

	@SerializedName("restaurants")
	private List<Object> restaurants;

	@SerializedName("book_link")
	private String bookLink;

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPhotos(List<PhotosItem> photos){
		this.photos = photos;
	}

	public List<PhotosItem> getPhotos(){
		return photos;
	}

	public void setEventCategoryName(String eventCategoryName){
		this.eventCategoryName = eventCategoryName;
	}

	public String getEventCategoryName(){
		return eventCategoryName;
	}

	public void setFriendlyEndDate(String friendlyEndDate){
		this.friendlyEndDate = friendlyEndDate;
	}

	public String getFriendlyEndDate(){
		return friendlyEndDate;
	}

	public void setFriendlyTimingStr(String friendlyTimingStr){
		this.friendlyTimingStr = friendlyTimingStr;
	}

	public String getFriendlyTimingStr(){
		return friendlyTimingStr;
	}

	public void setDisclaimer(String disclaimer){
		this.disclaimer = disclaimer;
	}

	public String getDisclaimer(){
		return disclaimer;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setShowShareUrl(int showShareUrl){
		this.showShareUrl = showShareUrl;
	}

	public int getShowShareUrl(){
		return showShareUrl;
	}

	public void setTypes(List<Object> types){
		this.types = types;
	}

	public List<Object> getTypes(){
		return types;
	}

	public void setIsActive(int isActive){
		this.isActive = isActive;
	}

	public int getIsActive(){
		return isActive;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setIsEndTimeSet(int isEndTimeSet){
		this.isEndTimeSet = isEndTimeSet;
	}

	public int getIsEndTimeSet(){
		return isEndTimeSet;
	}

	public void setEventCategory(int eventCategory){
		this.eventCategory = eventCategory;
	}

	public int getEventCategory(){
		return eventCategory;
	}

	public void setShareData(ShareData shareData){
		this.shareData = shareData;
	}

	public ShareData getShareData(){
		return shareData;
	}

	public void setDisplayTime(String displayTime){
		this.displayTime = displayTime;
	}

	public String getDisplayTime(){
		return displayTime;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setDateAdded(String dateAdded){
		this.dateAdded = dateAdded;
	}

	public String getDateAdded(){
		return dateAdded;
	}

	public void setFriendlyStartDate(String friendlyStartDate){
		this.friendlyStartDate = friendlyStartDate;
	}

	public String getFriendlyStartDate(){
		return friendlyStartDate;
	}

	public void setEventId(int eventId){
		this.eventId = eventId;
	}

	public int getEventId(){
		return eventId;
	}

	public void setDisplayDate(String displayDate){
		this.displayDate = displayDate;
	}

	public String getDisplayDate(){
		return displayDate;
	}

	public void setShareUrl(String shareUrl){
		this.shareUrl = shareUrl;
	}

	public String getShareUrl(){
		return shareUrl;
	}

	public void setIsValid(int isValid){
		this.isValid = isValid;
	}

	public int getIsValid(){
		return isValid;
	}

	public void setRestaurants(List<Object> restaurants){
		this.restaurants = restaurants;
	}

	public List<Object> getRestaurants(){
		return restaurants;
	}

	public void setBookLink(String bookLink){
		this.bookLink = bookLink;
	}

	public String getBookLink(){
		return bookLink;
	}

	@Override
 	public String toString(){
		return 
			"Event{" + 
			"end_date = '" + endDate + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",photos = '" + photos + '\'' + 
			",event_category_name = '" + eventCategoryName + '\'' + 
			",friendly_end_date = '" + friendlyEndDate + '\'' + 
			",friendly_timing_str = '" + friendlyTimingStr + '\'' + 
			",disclaimer = '" + disclaimer + '\'' + 
			",start_date = '" + startDate + '\'' + 
			",show_share_url = '" + showShareUrl + '\'' + 
			",types = '" + types + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",end_time = '" + endTime + '\'' + 
			",is_end_time_set = '" + isEndTimeSet + '\'' + 
			",event_category = '" + eventCategory + '\'' + 
			",share_data = '" + shareData + '\'' + 
			",display_time = '" + displayTime + '\'' + 
			",start_time = '" + startTime + '\'' + 
			",date_added = '" + dateAdded + '\'' + 
			",friendly_start_date = '" + friendlyStartDate + '\'' + 
			",event_id = '" + eventId + '\'' + 
			",display_date = '" + displayDate + '\'' + 
			",share_url = '" + shareUrl + '\'' + 
			",is_valid = '" + isValid + '\'' + 
			",restaurants = '" + restaurants + '\'' + 
			",book_link = '" + bookLink + '\'' + 
			"}";
		}
}