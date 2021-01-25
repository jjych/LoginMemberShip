package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.java.ex.db.*;

public class LoginNew extends JFrame{
	
	public LoginNew() {
		Customer customer = new Customer();        // Customer �����ͺ��̽� ���� �ڵ� �ҷ�����
		Container ct = getContentPane();
		
		setTitle("ȸ������");
		setSize(500,650);
		
		JPanel jp1 = new JPanel();         // �г� ����
		jp1.setLayout(null);
		
		JLabel Main = new JLabel("ȸ������");                 // ���� ���� �ΰ�
		Main.setBounds(160,30,200,50);
		Main.setFont(new Font("ȸ������",Font.BOLD,40));
		jp1.add(Main);
		
		JLabel IDLabel = new JLabel("���̵�");               // ���̵� �Է� ��
		IDLabel.setBounds(55,100,100,50);
		IDLabel.setFont(new Font("���̵�",Font.BOLD,13));
		jp1.add(IDLabel);
		
		JTextField IDText = new JTextField(10);             // ���̵� �Է��Ҽ��ִ� �ؽ�Ʈĭ
		IDText.setBounds(120,110,280,30);
		jp1.add(IDText);
		
		JLabel PWLabel = new JLabel("��й�ȣ");              // ��й�ȣ �Է� ��
		PWLabel.setBounds(50,150,200,50);
		PWLabel.setFont(new Font("��й�ȣ",Font.BOLD,13));
		jp1.add(PWLabel);
		
		JPasswordField PWText = new JPasswordField(10);             // ��й�ȣ �Է��Ҽ��ִ� �ؽ�Ʈĭ
		PWText.setBounds(120,160,280,30);
		jp1.add(PWText);
		
		JLabel PWLabelRe = new JLabel("��й�ȣ ��Ȯ��");       // ��й�ȣ ��Ȯ�� ��
		PWLabelRe.setBounds(15,195,200,50);
		PWLabelRe.setFont(new Font("��й�ȣ ��Ȯ��",Font.BOLD,13));
		jp1.add(PWLabelRe);
		
		JPasswordField PWTextRe = new JPasswordField(10);             // ��й�ȣ ��Ȯ�� �Է��Ҽ��ִ� �ؽ�Ʈĭ
		PWTextRe.setBounds(120,205,280,30);
		jp1.add(PWTextRe);
		
		JLabel PWCompareLb = new JLabel("��й�ȣ�� ���������ʽ��ϴ�.");         // ��й�ȣ��ġx �⺻��
		PWCompareLb.setBounds(120,225,200,30);
		PWCompareLb.setForeground(Color.red);
		PWCompareLb.setFont(new Font("��й�ȣ�� ���������ʽ��ϴ�.",Font.BOLD,10));
		jp1.add(PWCompareLb);
		
		JButton PWReBtn = new JButton("��Ȯ��");         // ��Ȯ�� ��ư
		PWReBtn.setBounds(400,205,80,30);
		jp1.add(PWReBtn);
		
		PWReBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PWText.getText().equals(PWTextRe.getText())) {            // ���� �ؽ�Ʈ�� ��ġ�������
					PWCompareLb.setForeground(Color.blue);                 // �󺧻��� ���
					PWCompareLb.setText("��й�ȣ�� �����մϴ�."); 
				}
				else if(PWText.getText() != PWTextRe.getText()) {        // ��ġ�����ʾ��� ���
					PWCompareLb.setForeground(Color.red);                // �󺧻��� ����
					PWCompareLb.setText("��й�ȣ�� ���������ʽ��ϴ�.");
				}
			}
		});
		
		JLabel NameLabel = new JLabel("�� ��");              // �̸� ��
		NameLabel.setBounds(60,270,280,30);
		NameLabel.setFont(new Font("�̸�",Font.BOLD,13));
		jp1.add(NameLabel);
		
		JTextField NameText = new JTextField(10);         // �̸� �Է��Ҽ��ִ� �ؽ�Ʈĭ
		NameText.setBounds(120,270,280,30);
		jp1.add(NameText);
		
		JLabel GenderLabel = new JLabel("�� ��");           // ���� ��
		GenderLabel.setBounds(60,310,280,30);
		GenderLabel.setFont(new Font("����",Font.BOLD,13));
		jp1.add(GenderLabel);
		
		JComboBox GenderCombo = new JComboBox(new String[] {"Male","Female"});    // ���� ���� �޺��ڽ�
		GenderCombo.setBackground(Color.WHITE);
		GenderCombo.setBounds(120,310,280,30);
		jp1.add(GenderCombo);
		
		JLabel BirthLabel = new JLabel("�������");          // ������� ��
		BirthLabel.setBounds(50,350,280,30);
		BirthLabel.setFont(new Font("�������",Font.BOLD,13));
		jp1.add(BirthLabel);
		
		JTextField BirthText = new JTextField(10);         // ������� �Է��Ҽ��ִ� �ؽ�Ʈĭ
		BirthText.setBounds(120,350,280,30);
		jp1.add(BirthText);
		
		JLabel BirthErrorLabel = new JLabel("�ֹε�Ͼ� 6�ڸ� �Է����ּ���. ex)980304"); // ������� �����
		BirthErrorLabel.setBounds(120,370,280,30);
		BirthErrorLabel.setFont(new Font("�ֹε�Ͼ� 6�ڸ� �Է����ּ���. ex)980304",Font.BOLD,10));
		jp1.add(BirthErrorLabel);
		
		JLabel EmailLabel = new JLabel("�̸���");           // �̸��� �� 
		EmailLabel.setBounds(55,400,280,30);
		EmailLabel.setFont(new Font("�̸���",Font.BOLD,13));
		jp1.add(EmailLabel);
		
		JTextField EmailText = new JTextField(10);         // �̸��� �Է��Ҽ��ִ� �ؽ�Ʈĭ
		EmailText.setBounds(120,400,280,30);
		jp1.add(EmailText);
		
		JLabel HandPhoneLabel = new JLabel("�޴���ȭ");      // �޴���ȭ ��
		HandPhoneLabel.setBounds(50,450,280,30);
		HandPhoneLabel.setFont(new Font("�޴���ȭ",Font.BOLD,13));
		jp1.add(HandPhoneLabel);
		
		JTextField HandPhoneText = new JTextField(10);         // �޴���ȭ�Է��Ҽ��ִ� �ؽ�Ʈĭ
		HandPhoneText.setBounds(120,450,280,30);
		jp1.add(HandPhoneText);
		
		JLabel HandPhoneErrorLabel = new JLabel("' - ' �� ���� �Է����ּ���."); // �޴���ȭ �����
		HandPhoneErrorLabel.setBounds(130,470,280,30);
		HandPhoneErrorLabel.setFont(new Font("' - ' �� ���� �Է����ּ���.",Font.BOLD,10));
		jp1.add(HandPhoneErrorLabel);
		
		JButton Back = new JButton("�ڷΰ���");        // �α���â���� �ǵ�����
		Back.setBounds(25,500,90,50);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Join = new JButton("�����ϱ�");        // �����ϱ� ��ư
		Join.setBounds(120,500,280,50);
		jp1.add(Join);
		
		Join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IDTxt = IDText.getText();                // ���̵� 
				String PWTxt = PWText.getText();               // ��й�ȣ
				String NameTxt = NameText.getText();            // �̸�
				String GenderTxt = GenderCombo.getSelectedItem().toString();     // ����
				String BirthTxt = BirthText.getText();                 // �������
				String EmailTxt = EmailText.getText();                 // �̸���
				String PhoneTxt = HandPhoneText.getText();             // �޴���ȭ
				
				if(IDTxt.equals("") || PWTxt.equals("") || NameTxt.equals("") || BirthTxt.equals("") || PWTxt.equals("")
						|| EmailTxt.equals("") || PhoneTxt.equals("")) {      // �Է¶��� �ϳ��̻� ���������.
					JOptionPane.showMessageDialog(null,"��ĭ���� �Է����ּ���.","����",JOptionPane.ERROR_MESSAGE);   // �˾�â
				}
				else {
					customer.createCustomer(IDTxt, PWTxt, NameTxt, GenderTxt, BirthTxt, EmailTxt, PhoneTxt); // customer���� createCustomer�� ��ɹ��� ������ ����
					JOptionPane.showMessageDialog(null,"ȸ�������� �Ϸ�Ǿ����ϴ�.","ȸ�����Լ���",JOptionPane.INFORMATION_MESSAGE); // �˾�â
					
					LoginHome LH = new LoginHome();
					LH.setVisible(true);
					dispose();
				}
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,500,650);
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true);                              // JFrame�� �����ֶ�
	}
	public static void main(String[] args) {
		LoginNew LN = new LoginNew();
	}
}
