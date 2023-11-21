package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.atomic.DoubleAccumulator;

import com.sunbeam.pojo.Dao;
import com.sunbeam.pojo.Review;

public class ReviewDao extends Dao {
	private static Scanner sc = new Scanner(System.in);

	public ReviewDao() throws Exception {
		// TODO Auto-generated constructor stub
	}

	public int save(Review r) throws Exception {
		String sql = "INSERT INTO reviews VALUES(?, ?, ?, ?, ?,now())";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getId());
			stmt.setInt(2, r.getMovieid());
			stmt.setString(3, r.getReview());
			stmt.setDouble(4, r.getRating());
			stmt.setInt(5, r.getUserid());

			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	public List<Review> displayAllReview() throws Exception {
		List<Review> reviewsliList = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("review_id");
					int mid = rs.getInt("movieID");
					String review = rs.getString("review");
					double rating = rs.getInt("rating");
					int userID = rs.getInt("userID");
					Timestamp modified = rs.getTimestamp("modified");
					Review re = new Review(id, mid, review, rating, userID, modified);
					reviewsliList.add(re);
				}
			}
		}
		return reviewsliList;
	}

	public List<Review> displayReviewByUser(int id) throws Exception {
		List<Review> reviewsList = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews WHERE userID=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int rid = rs.getInt("review_id");
					int mid = rs.getInt("movieID");
					String review = rs.getString("review");
					double rating = rs.getInt("rating");
					int userID = rs.getInt("userID");
					Timestamp modified = rs.getTimestamp("modified");
					Review re = new Review(rid, mid, review, rating, userID, modified);
					reviewsList.add(re);
				}
			
			}
		}
		return reviewsList;
	}

	public List<Review> displayReviewByID(int id) throws Exception {
		List<Review> reviewsList = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews WHERE review_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int rid = rs.getInt("review_id");
					int mid = rs.getInt("movieID");
					String review = rs.getString("review");
					double rating = rs.getInt("rating");
					int userID = rs.getInt("userID");
					Timestamp modified = rs.getTimestamp("modified");
					Review re = new Review(id, mid, review, rating, userID, modified);
					reviewsList.add(re);
				}
			}
		}
		return reviewsList;
	}

	public void updateReview() throws SQLException {
		String sql = "UPDATE reviews SET review=?, rating=? WHERE review_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			System.out.print("Review Id to be updated: ");
			int id = sc.nextInt();
			List<Review> rlist = displayReviewByID(id);
			System.out.println(rlist);

			System.out.print("Review: ");
			StringBuilder updatedReview = new StringBuilder();
			String line;

			while (true) {
				line = sc.nextLine();

				if (line.equals("&")) {
					break;
				}
				updatedReview.append(line).append("");
			}

			// Set values in the prepared statement
			stmt.setString(1, updatedReview.toString());
			System.out.print("Rating: ");
			double rating = sc.nextDouble();
			stmt.setDouble(2, rating);
			stmt.setInt(3, id);
			int cnt = stmt.executeUpdate();
			System.out.println("Rows updated: " + cnt);
		} // stmt.close();

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteReview() {
		String sql = "DELETE FROM reviews WHERE review_id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			System.out.print("Enter review id to be deleted: ");
			int id = sc.nextInt();
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			System.out.println("Rows deleted: " + cnt);
		} // stmt.close();
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // con.close();

}
