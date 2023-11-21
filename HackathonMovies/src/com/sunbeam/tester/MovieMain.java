package com.sunbeam.tester;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.Review;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtil;

public class MovieMain {

	public static Scanner sc = new Scanner(System.in);

	public static void acceptMoive() {

		System.out.print("Enter Moive ID: ");
		int movie_id = sc.nextInt();
		System.out.print("Enter Movie Title: ");
		String title = sc.next();
		System.out.print("Enter Movie Release Date (dd-MM-yyyy): ");
		String strreleaseDate = sc.next();
		Movie m = new Movie(movie_id, title, DateUtil.parse(strreleaseDate));
		try (MovieDao dao = new MovieDao()) {
			int count = dao.save(m);
			System.out.println("Movie registered: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void moviedisplay() {
		try (MovieDao dao = new MovieDao()) {
			List<Movie> list = dao.displayAllMovies();
			list.forEach(c -> System.out.println(c));
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		moviedisplay();
	}
}