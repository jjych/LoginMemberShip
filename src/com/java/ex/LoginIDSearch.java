package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginIDSearch extends JFrame{
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
		
		JTextField NameText = new JTextField();       // �̸� ����ĭ
		NameText.setBounds(100,40,200,30);
		jp1.add(NameText);
		
		JLabel EmailLb = new JLabel("�̸���");         // �̸��� ��
		EmailLb.setBounds(45,80,50,50);
		EmailLb.setFont(new Font("�̸���",Font.BOLD,15));
		jp1.add(EmailLb);
		
		JTextField EmailText = new JTextField();       // �̸��� ����ĭ
		EmailText.setBounds(100,90,200,30);
		jp1.add(EmailText);
		
		JLabel PhoneLb = new JLabel("�޴���ȭ");        // �޴���ȭ ��
		PhoneLb.setBounds(35,130,80,50);
		PhoneLb.setFont(new Font("�޴���ȭ",Font.BOLD,15));
		jp1.add(PhoneLb);
		
		JTextField PhoneText = new JTextField();       // �޴���ȭ ����ĭ
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
		
		ct.add(jp1);
		
		setBounds(1,1,400,300);
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true);                              // JFrame�� �����ֶ�
	}
}
