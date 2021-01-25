package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPwRe extends JFrame{
	public LoginPwRe() {
		Container ct = getContentPane();
		
		setTitle("비밀번호 재설정");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel pwL = new JLabel("새 비밀번호");         // 새 비밀번호 라벨
		pwL.setBounds(30,30,100,50);
		pwL.setFont(new Font("새 비밀번호",Font.BOLD,13));
		jp1.add(pwL);
		
		JTextField pwText = new JTextField();      // 새 비밀번호 쓰는 칸
		pwText.setBounds(120,40,180,30);
		jp1.add(pwText);
		
		JLabel pwRe = new JLabel("재확인");           // 재확인 라벨
		pwRe.setBounds(50,80,100,50);
		pwRe.setFont(new Font("재확인",Font.BOLD,13));
		jp1.add(pwRe);
		
		JTextField pwReText = new JTextField();       // 재확인 쓰는 칸
		pwReText.setBounds(120,90,180,30);
		jp1.add(pwReText);
		
		JButton Success = new JButton("완료");       // 완료 버튼
		Success.setBounds(80,130,200,50);
		jp1.add(Success);
		
		Success.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,370,250);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true); 
	}
}
