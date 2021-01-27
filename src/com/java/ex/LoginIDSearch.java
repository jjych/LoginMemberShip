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
		
		setTitle("���̵�ã��");
		setSize(400,300);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel NameLb = new JLabel("�̸�");            // �̸� ��
		NameLb.setBounds(60,30,50,50);
		NameLb.setFont(new Font("�̸�",Font.BOLD,15));
		jp1.add(NameLb);
		
		NameText = new JTextField();       // �̸� ����ĭ
		NameText.setBounds(100,40,200,30);
		jp1.add(NameText);
		
		JLabel EmailLb = new JLabel("�̸���");         // �̸��� ��
		EmailLb.setBounds(45,80,50,50);
		EmailLb.setFont(new Font("�̸���",Font.BOLD,15));
		jp1.add(EmailLb);
		
		EmailText = new JTextField();       // �̸��� ����ĭ
		EmailText.setBounds(100,90,200,30);
		jp1.add(EmailText);
		
		JLabel PhoneLb = new JLabel("�޴���ȭ");        // �޴���ȭ ��
		PhoneLb.setBounds(35,130,80,50);
		PhoneLb.setFont(new Font("�޴���ȭ",Font.BOLD,15));
		jp1.add(PhoneLb);
		
		PhoneText = new JTextField();       // �޴���ȭ ����ĭ
		PhoneText.setBounds(100,140,200,30);
		jp1.add(PhoneText);
		
		JButton Back = new JButton("�ڷΰ���");           // �ڷΰ��� ��ư
		Back.setBounds(50,190,100,50);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener(){          
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Search = new JButton("���̵�ã��");       // ���̵�ã�� ��ư
		Search.setBounds(180,190,150,50);
		jp1.add(Search);
		
		Search.addActionListener(new ActionListener() {     // ��ư������ IDSearch �޼ҵ�� �̵�
			public void actionPerformed(ActionEvent e) {
				IDSearch();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,400,300);
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true);                              // JFrame�� �����ֶ�
	}
	
	// ���̵�ã�� �޼ҵ�
	public void IDSearch() {
		Customer customer = new Customer();             // Customer.java ����
		customer.SelectIDCustomer(NameText.getText(),EmailText.getText(),PhoneText.getText());
		try {
			customer.pstmt.setString(1, NameText.getText());   // �̸��ؽ�Ʈĭ �ҷ�����
			customer.pstmt.setString(2, EmailText.getText());  // �̸����ؽ�Ʈĭ �ҷ�����
			customer.pstmt.setString(3, PhoneText.getText());  // �޴��ȣ�ؽ�Ʈĭ �ҷ�����
			customer.rs = customer.pstmt.executeQuery(); 
			
			// ��ġ�ϴ� �����Ͱ� �������
			if(customer.rs.next()) {
				JOptionPane.showMessageDialog(null, "���̵� : " + customer.rs.getString("ID"),"���̵�ã��",JOptionPane.INFORMATION_MESSAGE);
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
			// �ؽ�Ʈâ �� �ϳ��� ��ĭ���������
			else if(NameText.getText().equals("") || EmailText.getText().equals("") || PhoneText.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"��ĭ���� �Է����ּ���.","����",JOptionPane.ERROR_MESSAGE);
			}
			// ��ġ�ϴ� �����Ͱ� �������
			else {
				JOptionPane.showMessageDialog(null, "�ش��ϴ� ������ ��ġ�ϴ� ���̵�� �����ϴ�." , "���̵�ã��", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		customer.Close(); // DB �ݾ��ֱ�
	}
}
