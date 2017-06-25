package com.aditya.webapp.constants;

public enum Rating {

	VERY_BAD(0,"Very Bad"),
	BAD(0,"Bad"),
	GOOD(0,"Good"),
	VERY_GOOD(0,"Very Good"),
	EXCELLENT(0,"Excellent");
	
	private int rating;
	private String ratingText;
	
	private Rating(int rating,String ratingText){
		this.rating=rating;
		this.ratingText=ratingText;
	}
	
	public int getRating(){
		return rating;
	}
	
	public String getRatingText(){
		return ratingText;
	}
	
}
