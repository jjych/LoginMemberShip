package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.java.ex.*;
import com.java.ex.db.Customer;

public class LoginHome extends JFrame{
	private String userid;    // userid 공유하는 변수 선언
	JTextField idText = null;
	JPasswordField pwText = null;
	
	public LoginHome() {
		Container ct = getContentPane();
		
		setTitle("로그인");
		setSize(500,300);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel tema = new JLabel("로그인");
		tema.setBounds(200,30,100,50);
		tema.setFont(new Font("로그인", Font.BOLD, 30));
		jp1.add(tema);
		
		JLabel idLabel = new JLabel("ID");                  // 아이디 라벨
		idLabel.setBounds(100,80,100,50);
		idLabel.setFont(new Font("아이디", Font.BOLD,15));
		jp1.add(idLabel);
		
		idText = new JTextField(10);             // 아이디 치는 텍스트필드
		idText.setBounds(140,90,200,30);
		jp1.add(idText);
		
		JLabel pwLabel = new JLabel("PW");                  // 비밀번호 라벨
		pwLabel.setBounds(100,120,100,50);
		pwLabel.setFont(new Font("비밀번호", Font.BOLD,15));
		jp1.add(pwLabel);
		
		pwText = new JPasswordField(10);             // 비밀번호 치는 텍스트필드
		pwText.setBounds(140,130,200,30);
		jp1.add(pwText);
		
		JButton Login = new JButton("Login");               // 로그인 클릭버튼
		Login.setFont(new Font("Login", Font.BOLD, 15));
		Login.setBounds(350,90,100,70);
		jp1.add(Login);
		
		// 로그인 버튼 눌렀을시 이벤트
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginOK();
			}
		});
		
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
		
		ct.add(jp1);
		
		setBounds(1,1,500,300);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
	
	// 로그인 확인하는 메소드
	public void LoginOK() {
		Customer customer = new Customer();
		customer.Select("select * from membership where ID = ? and PW = ?");
		try {
			customer.pstmt.setString(1, idText.getText());
			customer.pstmt.setString(2, pwText.getText());
			customer.rs = customer.pstmt.executeQuery();
			
			if(customer.rs.next()) {
				JOptionPane.showMessageDialog(null, "로그인 성공","로그인",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(idText.getText().equals("") || pwText.getText().equals("")){
				JOptionPane.showMessageDialog(null, "빈칸없이 입력했는지 확인해주세요.","오류",JOptionPane.ERROR_MESSAGE);
			}
			else if(!customer.rs.next()) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 잘못되었습니다.","오류",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
