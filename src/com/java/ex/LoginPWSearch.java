package com.java.ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.java.ex.db.Customer;

public class LoginPWSearch extends JFrame{
	
	private String userid;    // 여러곳에 공유할수있는 userid 변수 설정
	
	JTextField IdText = null;
	JTextField BirthText = null;
	
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
		
		IdText = new JTextField();         // ID 치는칸
		IdText.setBounds(100,50,200,30);
		jp1.add(IdText);
		
		JLabel BirthLb = new JLabel("생년월일");        // 생년월일 라벨
		BirthLb.setBounds(35,100,100,30);
		BirthLb.setFont(new Font("생년월일",Font.BOLD,13));
		jp1.add(BirthLb);
		
		BirthText = new JTextField();         // 생년월일 치는칸
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
		
		Next.addActionListener(new ActionListener() {         // 버튼누를시 PWSearch 메소드 실행
			public void actionPerformed(ActionEvent e) {
				PWSearch();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,370,250);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
	
	// 비밀번호 찾는 메소드
	public void PWSearch() {
		Customer customer = new Customer();
		customer.SelectPWCustomer(IdText.getText(), BirthText.getText());
		try {
			customer.pstmt.setString(1,IdText.getText());       // 아이디 텍스트칸 불러오기
			customer.pstmt.setString(2,BirthText.getText());    // 생년월일 텍스트칸 불러오기
			customer.rs = customer.pstmt.executeQuery();
			
			if(customer.rs.next()) {            // 일치하는 데이터가 있을경우
//				customer.setOnline(IdText.getText());
				JOptionPane.showMessageDialog(null, "비밀번호를 재설정합니다.","비밀번호 찾기",JOptionPane.INFORMATION_MESSAGE);
				LoginPwRe LPR = new LoginPwRe(IdText.getText());
				LPR.setVisible(true);
				dispose();
			}
			else if(IdText.getText().equals("") || BirthText.getText().equals("")) {   // 빈칸이있을경우 
				JOptionPane.showMessageDialog(null,"빈칸없이 입력해주세요","오류",JOptionPane.ERROR_MESSAGE);
			}
			else {              // 일치하는 데이터가 없을경우
				JOptionPane.showMessageDialog(null, "아이디 또는 생년월일이 일치하지않습니다.","비밀번호 찾기",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		customer.Close();
	}
}
