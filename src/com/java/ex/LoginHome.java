package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.java.ex.*;

public class LoginHome extends JFrame{
	public LoginHome() {
		Container ct = getContentPane();
		
		setTitle("�α���");
		setSize(500,300);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
//		JLabel jl1 = new JLabel("����������");
//		jl1.setHorizontalAlignment(JLabel.CENTER);            // ���߾����� ����
//		jl1.setFont(new Font("�α���", Font.BOLD, 30));        // �۾� ũ�� ��Ʈ ����
		
		JLabel tema = new JLabel("�α���");
		tema.setBounds(200,30,100,50);
		tema.setFont(new Font("�α���", Font.BOLD, 30));
		jp1.add(tema);
		
		JLabel idLabel = new JLabel("ID");                  // ���̵� ��
		idLabel.setBounds(100,80,100,50);
		idLabel.setFont(new Font("���̵�", Font.BOLD,15));
		jp1.add(idLabel);
		
		JTextField idText = new JTextField(10);             // ���̵� ġ�� �ؽ�Ʈ�ʵ�
		idText.setBounds(140,90,200,30);
		jp1.add(idText);
		
		JLabel pwLabel = new JLabel("PW");                  // ��й�ȣ ��
		pwLabel.setBounds(100,120,100,50);
		pwLabel.setFont(new Font("��й�ȣ", Font.BOLD,15));
		jp1.add(pwLabel);
		
		JTextField pwText = new JTextField(10);             // ��й�ȣ ġ�� �ؽ�Ʈ�ʵ�
		pwText.setBounds(140,130,200,30);
		jp1.add(pwText);
		
		JButton Login = new JButton("Login");               // �α��� Ŭ����ư
		Login.setFont(new Font("Login", Font.BOLD, 15));
		Login.setBounds(350,90,100,70);
		jp1.add(Login);
		
		JLabel IdSearch = new JLabel("���̵� ��");           // ���̵�ã�� ȭ������ �Ѿ�� ��
		IdSearch.setFont(new Font("���̵�",Font.BOLD,12));
		IdSearch.setBounds(150,140,50,70);
		jp1.add(IdSearch);
		
		IdSearch.addMouseListener(new MouseAdapter() {             // ���̵�ã��ȭ������ �̵�
			@Override
			public void mouseClicked(MouseEvent e) {
				 LoginIDSearch IDS = new LoginIDSearch();
		         IDS.setVisible(true);
		         dispose();
				}
			});
		
		JLabel PwSearch = new JLabel("��й�ȣ ã��");          // ��й�ȣ ã�� ȭ������ �Ѿ�� ��
		PwSearch.setFont(new Font("��й�ȣ ã��", Font.BOLD,12));
		PwSearch.setBounds(200,140,100,70);
		jp1.add(PwSearch);		
		
		PwSearch.addMouseListener(new MouseAdapter() {             // ��й�ȣã��ȭ������ �̵�
			@Override
			public void mouseClicked(MouseEvent e) {
				 LoginPWSearch PWS = new LoginPWSearch();
		         PWS.setVisible(true);
		         dispose();
				}
			});
		
		JLabel HW = new JLabel("ȸ������");                   // ȸ������ ȭ������ �Ѿ�� ��
		HW.setFont(new Font("ȸ������", Font.BOLD, 12));
		HW.setBounds(380,140,100,70);
		jp1.add(HW);
		
		HW.addMouseListener(new MouseAdapter() {             // ȸ������ȭ������ �̵�
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
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true);                              // JFrame�� �����ֶ�
	}
}
