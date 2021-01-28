package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.java.ex.db.Customer;

public class LoginPwRe extends JFrame{
	
	private String userid;  // 여러곳에 공유할수있는 userid 변수 설정
	
	int pwNum = 0;
	JPasswordField pwText = null;
	JPasswordField pwReText = null;
	JLabel idLb = null;
	
	public LoginPwRe(String userid) {
		this.userid = userid;                 // userid 불러오기
		Container ct = getContentPane();
		
		setTitle("비밀번호 재설정");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		idLb = new JLabel("아이디 :     " + userid);       // 맨위 아이디 표시 라벨
		idLb.setBounds(80,0,200,50);
		idLb.setFont(new Font("아이디 : ",Font.BOLD,13));
		jp1.add(idLb);
		
		JLabel pwL = new JLabel("새 비밀번호");         // 새 비밀번호 라벨
		pwL.setBounds(30,30,100,50);
		pwL.setFont(new Font("새 비밀번호",Font.BOLD,13));
		jp1.add(pwL);
		
		pwText = new JPasswordField();      // 새 비밀번호 쓰는 칸
		pwText.setBounds(120,40,140,30);
		jp1.add(pwText);
		
		JLabel pwRe = new JLabel("재확인");           // 재확인 라벨
		pwRe.setBounds(50,70,100,50);
		pwRe.setFont(new Font("재확인",Font.BOLD,13));
		jp1.add(pwRe);
		
		pwReText = new JPasswordField();       // 재확인 쓰는 칸
		pwReText.setBounds(120,80,140,30);
		jp1.add(pwReText);
		
		JButton PWReBtn = new JButton("재확인");         // 재확인 버튼
		PWReBtn.setBounds(260,80,80,30);
		jp1.add(PWReBtn);
		
		JLabel PWCompareLb = new JLabel();        // 일치유효성 확인 라벨
		PWCompareLb.setBounds(120,100,200,30);
		PWCompareLb.setFont(new Font("",Font.BOLD,10));
		jp1.add(PWCompareLb);
		
		// 재확인 버튼누를시
		PWReBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pwText.getText().equals(pwReText.getText())) {            // 둘의 텍스트가 일치했을경우
					PWCompareLb.setForeground(Color.blue);                 // 라벨색상 블루
					PWCompareLb.setText("비밀번호가 일치합니다.");
					pwNum = 1;
				}
				else if(pwText.getText() != pwReText.getText()) {        // 일치하지않았을 경우
					PWCompareLb.setForeground(Color.red);                // 라벨색상 레드
					PWCompareLb.setText("비밀번호가 일치하지않습니다.");
					pwNum = 0;
				}
			}
		});
		
		JButton Success = new JButton("완료");       // 완료 버튼
		Success.setBounds(80,130,200,50);
		jp1.add(Success);
		
		// 완료버튼 누를시
		Success.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 빈칸이있을경우
				if(pwText.getText().equals("") || pwReText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸없이 입력해주세요.","오류",JOptionPane.ERROR_MESSAGE);
				}
				// 비밀번호가 일치하지않을경우
				else if(pwNum == 0) {
					JOptionPane.showMessageDialog(null,"비밀번호를 재확인해주세요.","오류", JOptionPane.ERROR_MESSAGE);
				}
				// 비밀번호가 일치할경우
				else if(pwNum == 1) {
					Customer customer = new Customer();   // Customer 연결
					customer.Update("update membership set PW = ? where ID = '" + userid +"'");
					try {
						customer.pstmt.setString(1 ,pwText.getText());         // PwText 칸에 입력한 값 불러오기
						int result = customer.pstmt.executeUpdate();           // 그 값으로 업데이트
						if(1 == result) {                                      // 성공했을경우 실행
							JOptionPane.showMessageDialog(null, "비밀번호가 재설정되었습니다.","비밀번호 재설정",JOptionPane.INFORMATION_MESSAGE);
							LoginHome LH = new LoginHome();
							LH.setVisible(true);
							dispose();
						}
					}catch(Exception e2) {
						System.out.println(e2.getMessage());
					}
					customer.Close();
				}
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
