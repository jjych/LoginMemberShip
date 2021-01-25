package com.java.ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPWSearch extends JFrame{
	public LoginPWSearch() {
        Container ct = getContentPane();
		
		setTitle("비밀번호찾기");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel IDLb = new JLabel("ID");                // ID 라벨
		IDLb.setBounds(70,50,30,30);
		IDLb.setFont(new Font("ID",Font.BOLD,15));
		jp1.add(IDLb);
		
		JTextField IdText = new JTextField();         // ID 치는칸
		IdText.setBounds(100,50,200,30);
		jp1.add(IdText);
		
		JLabel BirthLb = new JLabel("생년월일");        // 생년월일 라벨
		BirthLb.setBounds(35,100,100,30);
		BirthLb.setFont(new Font("생년월일",Font.BOLD,13));
		jp1.add(BirthLb);
		
		JTextField BirthText = new JTextField();         // 생년월일 치는칸
		BirthText.setBounds(100,100,200,30);
		jp1.add(BirthText);
		
		JButton Back = new JButton("뒤로가기");            // 뒤로가기 버튼
		Back.setBounds(50,150,100,40);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Next = new JButton("다음");          // 다음 버튼
		Next.setBounds(200,150,100,40);
		jp1.add(Next);
		
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPwRe LPR = new LoginPwRe();
				LPR.setVisible(true);
				dispose();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,370,250);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
}
