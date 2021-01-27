package com.java.ex.db;

import java.sql.*;

public class Customer {
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://Localhost:3307/loginpractice";
	private static final String uid = "root";
	private static final String upw = "1234";
	
	private Connection con = null;
	private Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	public Customer() {
		getConnection();
	}
	
	// ȸ�������� �����ͺ��̽��� �߰��ϴ� �޼ҵ�
	public void insertCustomer(String ID, String PW,String Name,String Gender, String Birth,String Email,String Phone) {
		try { 
			pstmt = con.prepareStatement("INSERT INTO membership"
			                  + "(ID,PW,Name,Gender,Birth,Email,Phone)"
			                  + "VALUE"
			                  + "('"+ID+"','"+PW+"','"+Name+"','"+Gender+"','"+Birth+"','"+Email+"','"+Phone+"')");
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ���̵�ã�⿡�� �̸�, �̸��� , �޴��ȣ �����Ͱ� ����Ǿ��ִ��� Ȯ���ϴ� �޼ҵ�
	public void SelectIDCustomer(String name, String email, String phone) {
		try {
			pstmt = con.prepareStatement("select * from membership where Name = ? and Email = ? and Phone = ?");
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ��й�ȣ ã�⿡�� ID , ������� �����Ͱ� ����Ǿ��ִ��� Ȯ���ϴ� �޼ҵ�
	public void SelectPWCustomer(String id, String birth) {
		try {
			pstmt = con.prepareStatement("select * from membership where ID = ? and Birth = ?");
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	// ����й�ȣ ���� �޼ҵ�
//	public void UpdatePw(String pw) {
//		try {
//			pstmt = con.prepareStatement("Update membership set PW value"+"('"+ pw +"')"+ "where ID = 'jjych072'");
//			rs = pstmt.executeQuery();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public void getConnection() {               // ȸ������ DB����
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,uid,upw);
			System.out.println("The Connection Successful");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// DB���� ���� �޼ҵ�
	public void Close() {
		try {
			if(con != null) {
				con.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
