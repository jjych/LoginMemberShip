package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.java.ex.db.*;

public class LoginNew extends JFrame{
	
	int idNum = 0;            // 아이디 중복확인 0 or 1
	int pwNum = 0;            // 비밀번호 재확인 0 or 1
	JTextField IDText = null;
	
	public LoginNew() {
		Customer customer = new Customer();        // Customer.java 연결
		Container ct = getContentPane();
		
		setTitle("회원가입");
		setSize(500,650);
		
		JPanel jp1 = new JPanel();         // 패널 생성
		jp1.setLayout(null);
		
		JLabel Main = new JLabel("회원가입");                 // 맨위 메인 로고
		Main.setBounds(160,30,200,50);
		Main.setFont(new Font("회원가입",Font.BOLD,40));
		jp1.add(Main);
		
		JLabel IDLabel = new JLabel("아이디");               // 아이디 입력 라벨
		IDLabel.setBounds(55,100,100,50);
		IDLabel.setFont(new Font("아이디",Font.BOLD,13));
		jp1.add(IDLabel);
		
		IDText = new JTextField(10);             // 아이디 입력할수있는 텍스트칸
		IDText.setBounds(120,110,280,30);
		jp1.add(IDText);
		
		JLabel IDCheck = new JLabel("");               // 아이디체크라벨
		IDCheck.setBounds(120,120,200,50);
		IDCheck.setFont(new Font("",Font.BOLD,10));
		jp1.add(IDCheck);
		
		JButton IDBtn = new JButton("중복확인");              // 아이디 중복확인 버튼
		IDBtn.setFont(new Font("중복확인",Font.BOLD,10));
		IDBtn.setBounds(400,110,80,30);
		jp1.add(IDBtn);
		
		// 중복버튼 클릭시
		IDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.Select("select * from membership where ID = ?");
				try {
					customer.pstmt.setString(1, IDText.getText());
					customer.rs = customer.pstmt.executeQuery();
					if(customer.rs.next()) {
						if(IDText.getText().equals(customer.rs.getString("ID"))) {
							IDCheck.setForeground(Color.red);                 // 라벨색상 레드
							IDCheck.setText("중복된 아이디입니다.");
							idNum = 0;
						}
					}
					else if(IDText.getText().equals("")){
						IDCheck.setForeground(Color.red);                 // 라벨색상 레드
						IDCheck.setText("아이디를 입력해주세요.");
						idNum = 0;
					}
					else{
						IDCheck.setForeground(Color.blue);                 // 라벨색상 블루
						IDCheck.setText("사용할 수 있는 아이디입니다.");
						idNum = 1;
					}
				}catch(Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		
		JLabel PWLabel = new JLabel("비밀번호");              // 비밀번호 입력 라벨
		PWLabel.setBounds(50,150,200,50);
		PWLabel.setFont(new Font("비밀번호",Font.BOLD,13));
		jp1.add(PWLabel);
		
		JPasswordField PWText = new JPasswordField(10);             // 비밀번호 입력할수있는 텍스트칸
		PWText.setBounds(120,160,280,30);
		jp1.add(PWText);
		
		JLabel PWLabelRe = new JLabel("비밀번호 재확인");       // 비밀번호 재확인 라벨
		PWLabelRe.setBounds(15,195,200,50);
		PWLabelRe.setFont(new Font("비밀번호 재확인",Font.BOLD,13));
		jp1.add(PWLabelRe);
		
		JPasswordField PWTextRe = new JPasswordField(10);       // 비밀번호 재확인 입력할수있는 텍스트칸
		PWTextRe.setBounds(120,205,280,30);
		jp1.add(PWTextRe);
		
		JLabel PWCompareLb = new JLabel("");         // 비밀번호일치x 기본라벨
		PWCompareLb.setBounds(120,225,200,30);
		PWCompareLb.setFont(new Font("",Font.BOLD,10));
		jp1.add(PWCompareLb);
		
		JButton PWReBtn = new JButton("재확인");         // 재확인 버튼
		PWReBtn.setBounds(400,205,80,30);
		jp1.add(PWReBtn);
		
		PWReBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PWText.getText().equals("") || PWTextRe.getText().equals("")){
					PWCompareLb.setForeground(Color.red);                // 라벨색상 레드
					PWCompareLb.setText("비밀번호를 입력해주세요.");
					pwNum = 0;
				}
				else if(PWText.getText().equals(PWTextRe.getText())) {            // 둘의 텍스트가 일치했을경우
					PWCompareLb.setForeground(Color.blue);                 // 라벨색상 블루
					PWCompareLb.setText("비밀번호가 일치합니다.");
					pwNum = 1;
				}
				else if(PWText.getText() != PWTextRe.getText() ) {        // 일치하지않았을 경우
					PWCompareLb.setForeground(Color.red);                // 라벨색상 레드
					PWCompareLb.setText("비밀번호가 일치하지않습니다.");
					pwNum = 0;
				}
			}
		});
		
		JLabel NameLabel = new JLabel("이 름");              // 이름 라벨
		NameLabel.setBounds(60,270,280,30);
		NameLabel.setFont(new Font("이름",Font.BOLD,13));
		jp1.add(NameLabel);
		
		JTextField NameText = new JTextField(10);         // 이름 입력할수있는 텍스트칸
		NameText.setBounds(120,270,280,30);
		jp1.add(NameText);
		
		JLabel GenderLabel = new JLabel("성 별");           // 성별 라벨
		GenderLabel.setBounds(60,310,280,30);
		GenderLabel.setFont(new Font("성별",Font.BOLD,13));
		jp1.add(GenderLabel);
		
		JComboBox GenderCombo = new JComboBox(new String[] {"Male","Female"});    // 성별 고르는 콤보박스
		GenderCombo.setBackground(Color.WHITE);
		GenderCombo.setBounds(120,310,280,30);
		jp1.add(GenderCombo);
		
		JLabel BirthLabel = new JLabel("생년월일");          // 생년월일 라벨
		BirthLabel.setBounds(50,350,280,30);
		BirthLabel.setFont(new Font("생년월일",Font.BOLD,13));
		jp1.add(BirthLabel);
		
		JTextField BirthText = new JTextField(10);         // 생년월일 입력할수있는 텍스트칸
		BirthText.setBounds(120,350,280,30);
		jp1.add(BirthText);
		
		JLabel BirthErrorLabel = new JLabel("주민등록앞 6자리 입력해주세요. ex)980304"); // 생년월일 경고문구
		BirthErrorLabel.setBounds(120,370,280,30);
		BirthErrorLabel.setFont(new Font("주민등록앞 6자리 입력해주세요. ex)980304",Font.BOLD,10));
		jp1.add(BirthErrorLabel);
		
		JLabel EmailLabel = new JLabel("이메일");           // 이메일 라벨 
		EmailLabel.setBounds(55,400,280,30);
		EmailLabel.setFont(new Font("이메일",Font.BOLD,13));
		jp1.add(EmailLabel);
		
		JTextField EmailText = new JTextField(10);         // 이메일 입력할수있는 텍스트칸
		EmailText.setBounds(120,400,280,30);
		jp1.add(EmailText);
		
		JLabel HandPhoneLabel = new JLabel("휴대전화");      // 휴대전화 라벨
		HandPhoneLabel.setBounds(50,450,280,30);
		HandPhoneLabel.setFont(new Font("휴대전화",Font.BOLD,13));
		jp1.add(HandPhoneLabel);
		
		JTextField HandPhoneText = new JTextField(10);         // 휴대전화입력할수있는 텍스트칸
		HandPhoneText.setBounds(120,450,280,30);
		jp1.add(HandPhoneText);
		
		JLabel HandPhoneErrorLabel = new JLabel("' - ' 을 빼고 입력해주세요."); // 휴대전화 경고문구
		HandPhoneErrorLabel.setBounds(130,470,280,30);
		HandPhoneErrorLabel.setFont(new Font("' - ' 을 빼고 입력해주세요.",Font.BOLD,10));
		jp1.add(HandPhoneErrorLabel);
		
		JButton Back = new JButton("뒤로가기");        // 로그인창으로 되돌리기
		Back.setBounds(25,500,90,50);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Join = new JButton("가입하기");        // 가입하기 버튼
		Join.setBounds(120,500,280,50);
		jp1.add(Join);
		
		Join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDTxt = IDText.getText();                // 아이디 
				String PWTxt = PWText.getText();               // 비밀번호
				String NameTxt = NameText.getText();            // 이름
				String GenderTxt = GenderCombo.getSelectedItem().toString();     // 성별
				String BirthTxt = BirthText.getText();                 // 생년월일
				String EmailTxt = EmailText.getText();                 // 이메일
				String PhoneTxt = HandPhoneText.getText();             // 휴대전화
				
				if(IDTxt.equals("") || PWTxt.equals("") || NameTxt.equals("") || BirthTxt.equals("") || PWTxt.equals("")
						|| EmailTxt.equals("") || PhoneTxt.equals("")) {      // 입력란이 하나이상 빠졌을경우.
					JOptionPane.showMessageDialog(null,"빈칸없이 입력해주세요.","오류",JOptionPane.ERROR_MESSAGE);   // 팝업창
				}
				else {
					if(pwNum == 1 && idNum == 1) {
						customer.insertCustomer(IDTxt, PWTxt, NameTxt, GenderTxt, BirthTxt, EmailTxt, PhoneTxt); // customer에서 createCustomer의 명령문에 값들을 실행
						JOptionPane.showMessageDialog(null,"회원가입이 완료되었습니다.","회원가입성공",JOptionPane.INFORMATION_MESSAGE); // 팝업창
						
						LoginHome LH = new LoginHome();
						LH.setVisible(true);
						dispose();
					}
					else if(idNum == 0) {
						JOptionPane.showMessageDialog(null,"아이디를 다시확인해주세요.","오류",JOptionPane.ERROR_MESSAGE);
					}
					else if(pwNum == 0){
						JOptionPane.showMessageDialog(null,"비밀번호를 다시확인해주세요.","오류",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,500,650);
		setLocationRelativeTo(null);                  // 실행된창 정중앙으로 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 다음창으로 옮길시 창을닫아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 종료시 JFrame 자동종료
		setVisible(true);                              // JFrame을 보여주라
	}
}
