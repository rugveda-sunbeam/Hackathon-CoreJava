package com.sunbeam.tester;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Review;
import com.sunbeam.pojo.User;

public class ReviewMain {
	public static Scanner sc = new Scanner(System.in);

	public static void writeReview(User u) {
		System.out.print("Enter Review ID: ");
		int reviewid = sc.nextInt();
		System.out.print("Enter Movie ID: ");
		int movieid = sc.nextInt();
		System.out.print("Enter Movie review: ");
		StringBuilder multilineInput = new StringBuilder();
		String line;

		while (true) {
			line = sc.nextLine();

			if (line.equals("&")) {
				break;
			}

			multilineInput.append(line).append("");
		}
		System.out.println("Enter your rating (0.0 - 5.0):");
		double rating = sc.nextDouble();

		Review r = new Review(reviewid, movieid, multilineInput.toString(), rating, u.getId(),
				Timestamp.from(Instant.now()));
		try (ReviewDao dao = new ReviewDao()) {
			int count = dao.save(r);
			System.out.println("Review registered: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void reviewdisplay() {
		try (ReviewDao dao = new ReviewDao()) {
			List<Review> list = dao.displayAllReview();
			list.forEach(c -> System.out.println(c));
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editReview() {
		try (ReviewDao dao = new ReviewDao()) {
			dao.updateReview();
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updatereviewByUID() {
		try (ReviewDao dao = new ReviewDao()) {
			System.out.print("Enter User ID: ");
			int userid = sc.nextInt();
			List<Review> list = dao.displayReviewByUser(userid);
			list.forEach(c -> System.out.println(c));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deleteReview() {
		try (ReviewDao dao = new ReviewDao()) {
			dao.deleteReview();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void displayReviewByUser(User user) {
		try (ReviewDao rdao = new ReviewDao()) {
			List<Review> relist = rdao.displayReviewByUser(user.getId());
			System.out.println(relist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		reviewdisplay();
//		writeReview();
//		editReviw();
//		deleteReview();

		User user = UserMain.signIn();
		displayReviewByUser(user);
	}
}
