package com.sunbeam.pojo;

public class Shares {
	private int review_id;
	private int user_id;

	public Shares() {
		// TODO Auto-generated constructor stub
	}

	
	public Shares(int review_id, int user_id) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
	}


	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
