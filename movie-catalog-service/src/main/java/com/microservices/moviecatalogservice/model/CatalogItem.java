package com.microservices.moviecatalogservice.model;

public class CatalogItem {

	private String movieName;
	private String desc;
	private int ratings;
	
	
	public CatalogItem(String movieName, String desc, int ratings) {
		this.movieName = movieName;
		this.desc = desc;
		this.ratings = ratings;
	}
	
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
}
