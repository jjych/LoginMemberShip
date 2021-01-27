package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginPwRe extends JFrame{
	
	int pwNum = 0;
	
	public LoginPwRe() {
		Container ct = getContentPane();
		
		setTitle("��й�ȣ �缳��");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel pwL = new JLabel("�� ��й�ȣ");         // �� ��й�ȣ ��
		pwL.setBounds(30,20,100,50);
		pwL.setFont(new Font("�� ��й�ȣ",Font.BOLD,13));
		jp1.add(pwL);
		
		JTextField pwText = new JTextField();      // �� ��й�ȣ ���� ĭ
		pwText.setBounds(120,30,140,30);
		jp1.add(pwText);
		
		JLabel pwRe = new JLabel("��Ȯ��");           // ��Ȯ�� ��
		pwRe.setBounds(50,60,100,50);
		pwRe.setFont(new Font("��Ȯ��",Font.BOLD,13));
		jp1.add(pwRe);
		
		JTextField pwReText = new JTextField();       // ��Ȯ�� ���� ĭ
		pwReText.setBounds(120,70,140,30);
		jp1.add(pwReText);
		
		JButton PWReBtn = new JButton("��Ȯ��");         // ��Ȯ�� ��ư
		PWReBtn.setBounds(260,70,80,30);
		jp1.add(PWReBtn);
		
		JLabel PWCompareLb = new JLabel();        // ��ġ��ȿ�� Ȯ�� ��
		PWCompareLb.setBounds(120,90,200,30);
		PWCompareLb.setFont(new Font("",Font.BOLD,10));
		jp1.add(PWCompareLb);
		
		PWReBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pwText.getText().equals(pwReText.getText())) {            // ���� �ؽ�Ʈ�� ��ġ�������
					PWCompareLb.setForeground(Color.blue);                 // �󺧻��� ���
					PWCompareLb.setText("��й�ȣ�� ��ġ�մϴ�.");
					pwNum = 1;
				}
				else if(pwText.getText() != pwReText.getText()) {        // ��ġ�����ʾ��� ���
					PWCompareLb.setForeground(Color.red);                // �󺧻��� ����
					PWCompareLb.setText("��й�ȣ�� ��ġ�����ʽ��ϴ�.");
					pwNum = 0;
				}
			}
		});
		
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
	
	public static void main(String[] args) {
		LoginPwRe LN = new LoginPwRe();
	}
}
