package com.sunbeam.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Review {
	private int id;
	private int movieid;
	private String review;
	private double rating;
	private int userid;
	private Timestamp modified;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(int id, int movieid, String review, double rating, int userid, Timestamp modified) {
		this.id = id;
		this.movieid = movieid;
		this.review = review;
		this.rating = rating;
		this.userid = userid;
		this.modified = modified;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public Timestamp getModified() {
		return modified;
	}


	public void setModified(Timestamp modified) {
		this.modified = modified;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", movieid=" + movieid + ", review=" + review + ", rating=" + rating + ", userid="
				+ userid + ", modified=" + modified + "]";
	}

}
