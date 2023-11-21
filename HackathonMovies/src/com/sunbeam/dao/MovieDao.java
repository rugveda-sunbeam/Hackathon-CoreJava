package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojo.Dao;
import com.sunbeam.pojo.Movie;
import com.sunbeam.util.DateUtil;

public class MovieDao extends Dao {

	public MovieDao() throws Exception {
		// TODO Auto-generated constructor stub
	}

	public int save(Movie m) throws Exception {
		String sql = "INSERT INTO movies VALUES(?, ? ,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, m.getMovie_id());
			stmt.setString(2, m.getTitle());
			stmt.setDate(3, DateUtil.utilToSqlDate(m.getReleaseDate()));

			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	/*
	 * Movie m = new Movie(movie_id, title, DateUtil.parse(strreleaseDate));
	 */
	public List<Movie> displayAllMovies() throws Exception {
		List<Movie> movielist = new ArrayList<Movie>();
		String sql = "SELECT * FROM movies";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("movie_id");
					String title = rs.getString("title");
					Date rdate = rs.getDate("releaseDate");
					Movie m = new Movie(id, title, rdate);
					movielist.add(m);
				}
			}
		}
		return movielist;
	}
}
