package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.java.ex.*;

public class LoginHome extends JFrame{
	public LoginHome() {
		Container ct = getContentPane();
		
		setTitle("로그인");
		setSize(500,300);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
//		JLabel jl1 = new JLabel("혁수의전설");
//		jl1.setHorizontalAlignment(JLabel.CENTER);            // 정중앙으로 고정
//		jl1.setFont(new Font("로그인", Font.BOLD, 30));        // 글씨 크기 폰트 조절
		
		JLabel tema = new JLabel("로그인");
		tema.setBounds(200,30,100,50);
		tema.setFont(new Font("로그인", Font.BOLD, 30));
		jp1.add(tema);
		
		JLabel idLabel = new JLabel("ID");                  // 아이디 라벨
		idLabel.setBounds(100,80,100,50);
		idLabel.setFont(new Font("아이디", Font.BOLD,15));
		jp1.add(idLabel);
		
		JTextField idText = new JTextField(10);             // 아이디 치는 텍스트필드
		idText.setBounds(140,90,200,30);
		jp1.add(idText);
		
		JLabel pwLabel = new JLabel("PW");                  // 비밀번호 라벨
		pwLabel.setBounds(100,120,100,50);
		pwLabel.setFont(new Font("비밀번호", Font.BOLD,15));
		jp1.add(pwLabel);
		
		JTextField pwText = new JTextField(10);             // 비밀번호 치는 텍스트필드
		pwText.setBounds(140,130,200,30);
		jp1.add(pwText);
		
		JButton Login = new JButton("Login");               // 로그인 클릭버튼
		Login.setFont(new Font("Login", Font.BOLD, 15));
		Login.setBounds(350,90,100,70);
		jp1.add(Login);
		
		JLabel IdSearch = new JLabel("아이디 ·");           // 아이디찾기 화면으로 넘어가는 라벨
		IdSearch.setFont(new Font("아이디",Font.BOLD,12));
		IdSearch.setBounds(150,140,50,70);
		jp1.add(IdSearch);
		
		IdSearch.addMouseListener(new MouseAdapter() {             // 아이디찾기화면으로 이동
			@Override
			public void mouseClicked(MouseEvent e) {
				 LoginIDSearch IDS = new LoginIDSearch();
		         IDS.setVisible(true);
		         dispose();
				}
			});
		
		JLabel PwSearch = new JLabel("비밀번호 찾기");          // 비밀번호 찾기 화면으로 넘어가는 라벨
		PwSearch.setFont(new Font("비밀번호 찾기", Font.BOLD,12));
		PwSearch.setBounds(200,140,100,70);
		jp1.add(PwSearch);		
		
		PwSearch.addMouseListener(new MouseAdapter() {             // 비밀번호찾기화면으로 이동
			@Override
			public void mouseClicked(MouseEvent e) {
				 LoginPWSearch PWS = new LoginPWSearch();
		         PWS.setVisible(true);
		         dispose();
				}
			});
		
		JLabel HW = new JLabel("회원가입");                   // 회원가입 화면으로 넘어가는 라벨
		HW.setFont(new Font("회원가입", Font.BOLD, 12));
		HW.setBounds(380,140,100,70);
		jp1.add(HW);
		
		HW.addMouseListener(new MouseAdapter() {             // 회원가입화면으로 이동
			@Override
			public void mouseClicked(MouseEvent e) {
				 LoginNew LN = new LoginNew();
		         LN.setVisible(true);
		         dispose();
				}
			});
		
//		ct.add(jl1,BorderLayout.NORTH);
		ct.add(jp1);
		
		setBounds(1,1,500,300);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
}
