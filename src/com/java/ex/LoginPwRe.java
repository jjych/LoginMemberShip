package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPwRe extends JFrame{
	public LoginPwRe() {
		Container ct = getContentPane();
		
		setTitle("��й�ȣ �缳��");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel pwL = new JLabel("�� ��й�ȣ");         // �� ��й�ȣ ��
		pwL.setBounds(30,30,100,50);
		pwL.setFont(new Font("�� ��й�ȣ",Font.BOLD,13));
		jp1.add(pwL);
		
		JTextField pwText = new JTextField();      // �� ��й�ȣ ���� ĭ
		pwText.setBounds(120,40,180,30);
		jp1.add(pwText);
		
		JLabel pwRe = new JLabel("��Ȯ��");           // ��Ȯ�� ��
		pwRe.setBounds(50,80,100,50);
		pwRe.setFont(new Font("��Ȯ��",Font.BOLD,13));
		jp1.add(pwRe);
		
		JTextField pwReText = new JTextField();       // ��Ȯ�� ���� ĭ
		pwReText.setBounds(120,90,180,30);
		jp1.add(pwReText);
		
		JButton Success = new JButton("�Ϸ�");       // �Ϸ� ��ư
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
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true); 
	}
}
