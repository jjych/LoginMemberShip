package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.java.ex.db.Customer;

public class LoginIDSearch extends JFrame{
	
	JTextField NameText = null;
	JTextField EmailText = null;
	JTextField PhoneText = null;
	
	public LoginIDSearch() {
		Container ct = getContentPane();
		
		setTitle("아이디찾기");
		setSize(400,300);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel NameLb = new JLabel("이름");            // 이름 라벨
		NameLb.setBounds(60,30,50,50);
		NameLb.setFont(new Font("이름",Font.BOLD,15));
		jp1.add(NameLb);
		
		NameText = new JTextField();       // 이름 쓰는칸
		NameText.setBounds(100,40,200,30);
		jp1.add(NameText);
		
		JLabel EmailLb = new JLabel("이메일");         // 이메일 라벨
		EmailLb.setBounds(45,80,50,50);
		EmailLb.setFont(new Font("이메일",Font.BOLD,15));
		jp1.add(EmailLb);
		
		EmailText = new JTextField();       // 이메일 쓰는칸
		EmailText.setBounds(100,90,200,30);
		jp1.add(EmailText);
		
		JLabel PhoneLb = new JLabel("휴대전화");        // 휴대전화 라벨
		PhoneLb.setBounds(35,130,80,50);
		PhoneLb.setFont(new Font("휴대전화",Font.BOLD,15));
		jp1.add(PhoneLb);
		
		PhoneText = new JTextField();       // 휴대전화 쓰는칸
		PhoneText.setBounds(100,140,200,30);
		jp1.add(PhoneText);
		
		JButton Back = new JButton("뒤로가기");           // 뒤로가기 버튼
		Back.setBounds(50,190,100,50);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener(){          
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Search = new JButton("아이디찾기");       // 아이디찾기 버튼
		Search.setBounds(180,190,150,50);
		jp1.add(Search);
		
		Search.addActionListener(new ActionListener() {     // 버튼누를시 IDSearch 메소드로 이동
			public void actionPerformed(ActionEvent e) {
				IDSearch();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,400,300);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
	
	// 아이디찾기 메소드
	public void IDSearch() {
		Customer customer = new Customer();             // Customer.java 연결
		customer.SelectIDCustomer(NameText.getText(),EmailText.getText(),PhoneText.getText());
		try {
			customer.pstmt.setString(1, NameText.getText());   // 이름텍스트칸 불러오기
			customer.pstmt.setString(2, EmailText.getText());  // 이메일텍스트칸 불러오기
			customer.pstmt.setString(3, PhoneText.getText());  // 휴대번호텍스트칸 불러오기
			customer.rs = customer.pstmt.executeQuery(); 
			
			// 일치하는 데이터가 있을경우
			if(customer.rs.next()) {
				JOptionPane.showMessageDialog(null, "아이디 : " + customer.rs.getString("ID"),"아이디찾기",JOptionPane.INFORMATION_MESSAGE);
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
			// 텍스트창 중 하나라도 빈칸이있을경우
			else if(NameText.getText().equals("") || EmailText.getText().equals("") || PhoneText.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"빈칸없이 입력해주세요.","오류",JOptionPane.ERROR_MESSAGE);
			}
			// 일치하는 데이터가 없을경우
			else {
				JOptionPane.showMessageDialog(null, "해당하는 정보와 일치하는 아이디는 없습니다." , "아이디찾기", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		customer.Close(); // DB 닫아주기
	}
}
