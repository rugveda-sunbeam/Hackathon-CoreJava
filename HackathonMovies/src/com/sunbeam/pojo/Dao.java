package com.sunbeam.pojo;

import java.sql.Connection;

import com.sunbeam.util.DBUtils;

public class Dao implements AutoCloseable {
	protected static Connection con;
	
	protected Dao() throws Exception {
		con = DBUtils.getConnection();
	}
	
	@Override
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}