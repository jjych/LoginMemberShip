package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginIDSearch extends JFrame{
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
		
		JTextField NameText = new JTextField();       // 이름 쓰는칸
		NameText.setBounds(100,40,200,30);
		jp1.add(NameText);
		
		JLabel EmailLb = new JLabel("이메일");         // 이메일 라벨
		EmailLb.setBounds(45,80,50,50);
		EmailLb.setFont(new Font("이메일",Font.BOLD,15));
		jp1.add(EmailLb);
		
		JTextField EmailText = new JTextField();       // 이메일 쓰는칸
		EmailText.setBounds(100,90,200,30);
		jp1.add(EmailText);
		
		JLabel PhoneLb = new JLabel("휴대전화");        // 휴대전화 라벨
		PhoneLb.setBounds(35,130,80,50);
		PhoneLb.setFont(new Font("휴대전화",Font.BOLD,15));
		jp1.add(PhoneLb);
		
		JTextField PhoneText = new JTextField();       // 휴대전화 쓰는칸
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
		
		ct.add(jp1);
		
		setBounds(1,1,400,300);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
}
