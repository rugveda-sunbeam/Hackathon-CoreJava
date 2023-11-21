package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.pojo.Dao;
import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtil;

public class UserDao extends Dao {
	private static Scanner sc = new Scanner(System.in);

	public UserDao() throws Exception {
		// TODO Auto-generated constructor stub
	}

	public int save(User u) throws Exception {
		String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, u.getId());
			stmt.setString(2, u.getFirstName());
			stmt.setString(3, u.getLastName());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getPassword());
			stmt.setString(6, u.getMobile());
			stmt.setDate(7, DateUtil.utilToSqlDate(u.getBirthdate()));

			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}

	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("firstName");
					String lname = rs.getString("lastName");
					String password = rs.getString("password");
					String mobile = rs.getString("mobile");
					Date uDate = DateUtil.sqlToUtilDate(rs.getDate("birthdate"));
					return new User(id, fname, lname, email, password, mobile, uDate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	public void updateUser() {
		String sql = "UPDATE users SET firstName=?, lastName=?, mobile=? WHERE ID=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			System.out.print("User Id to be updated: ");
			int id = sc.nextInt();
			System.out.print("First Name: ");
			String fname = sc.next();
			System.out.print("Last Name: ");
			String lname = sc.next();
			System.out.print("Mobile: ");
			String mobile = sc.next();
			System.out.print("Birth Date (dd-MM-yyyy): ");
			String dateStr = sc.next();
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, mobile);
			stmt.setInt(4, id);
			int cnt = stmt.executeUpdate();
			System.out.println("Rows updated: " + cnt);
		} // stmt.close();

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changePassword() {
		String sql = "UPDATE users SET password = ? WHERE email = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			System.out.print("Enter email: ");
			String email = sc.nextLine();
			System.out.print("Enter new password: ");
			String newPassword = sc.nextLine();
			stmt.setString(1, newPassword);
			stmt.setString(2, email);
			int cnt = stmt.executeUpdate();
			System.out.println("Rows updated: " + cnt);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<User> displayAllUser() throws Exception {
		List<User> list = new ArrayList<>();
		String sql = "SELECT ID , firstName , lastName , email FROM users";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("ID");
					String fname = rs.getString("firstName");
					String lname = rs.getString("lastName");
					String email = rs.getString("email");
					User u = new User(id, fname, lname, email);
					list.add(u);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

}
