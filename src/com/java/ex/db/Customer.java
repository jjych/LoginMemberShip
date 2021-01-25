package com.java.ex.db;

import java.sql.*;

public class Customer {
	public static void main(String[] args) {
		getConnection();
	}
	
	public static void createCustomer(String ID, String PW,String Name,String Gender, String Birth,String Email,String Phone) {
		try {
			Connection con = getConnection(); 
			PreparedStatement insert = con.prepareStatement("" + "INSERT INTO membership"
			                  + "(ID,PW,Name,Gender,Birth,Email,Phone)"
			                  + "VALUE"
			                  + "('"+ID+"','"+PW+"','"+Name+"','"+Gender+"','"+Birth+"','"+Email+"','"+Phone+"')");
			insert.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() {               // 회원정보 DB연결
		try {
			String driver = "org.mariadb.jdbc.Driver";
			String url = "jdbc:mariadb://Localhost:3307/loginpractice";
			String uid = "root";
			String upw = "1234";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,uid,upw);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
