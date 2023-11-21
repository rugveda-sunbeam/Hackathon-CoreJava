package com.sunbeam.tester;

import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Menus;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtil;

public class UserMain {
	public static Scanner sc = new Scanner(System.in);

	public static void signUp() {
		System.out.print("User id: ");
		int id = sc.nextInt();
		System.out.print("First Name: ");
		String fname = sc.next();
		System.out.print("Last Name: ");
		String lname = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Password: ");
		String passwd = sc.next();
		System.out.print("Mobile: ");
		String mobile = sc.next();
		System.out.print("Birth Date (dd-MM-yyyy): ");
		String dateStr = sc.next();
		User voter = new User(id, fname, lname, email, passwd, mobile, DateUtil.parse(dateStr));
		try (UserDao dao = new UserDao()) {
			int count = dao.save(voter);
			System.out.println("User registered: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static User signIn() {
		String email;
		String password;
		System.out.print("Enter email: ");
		email = sc.next();
		System.out.print("Enter password: ");
		password = sc.next();
		try (UserDao dao = new UserDao()) {
			User user = dao.findByEmail(email);
			if (user != null && password.equals(user.getPassword()))
				return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void displayAllUser() {
		try (UserDao dao = new UserDao()) {
			List<User> list = dao.displayAllUser();
			list.forEach(c -> System.out.println(c));
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editProfile() {
		try (UserDao dao = new UserDao()) {
			dao.updateUser();
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changePassword() {
		try (UserDao dao = new UserDao()) {
			dao.changePassword();
		} // dao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
