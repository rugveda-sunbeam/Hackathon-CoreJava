package com.sunbeam.pojo;

import java.util.Date;

public class Movie {
	private int movie_id ;	
	private String title;
	private Date releaseDate;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(int movie_id, String title, Date releaseDate) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.releaseDate = releaseDate;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}
	
}
