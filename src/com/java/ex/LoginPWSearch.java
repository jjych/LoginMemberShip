package com.java.ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.java.ex.db.Customer;

public class LoginPWSearch extends JFrame{
	
	private String userid;    // �������� �����Ҽ��ִ� userid ���� ����
	
	JTextField IdText = null;
	JTextField BirthText = null;
	
	public LoginPWSearch() {
        Container ct = getContentPane();
		
		setTitle("��й�ȣã��");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		JLabel IDLb = new JLabel("ID");                // ID ��
		IDLb.setBounds(70,50,30,30);
		IDLb.setFont(new Font("ID",Font.BOLD,15));
		jp1.add(IDLb);
		
		IdText = new JTextField();         // ID ġ��ĭ
		IdText.setBounds(100,50,200,30);
		jp1.add(IdText);
		
		JLabel BirthLb = new JLabel("�������");        // ������� ��
		BirthLb.setBounds(35,100,100,30);
		BirthLb.setFont(new Font("�������",Font.BOLD,13));
		jp1.add(BirthLb);
		
		BirthText = new JTextField();         // ������� ġ��ĭ
		BirthText.setBounds(100,100,200,30);
		jp1.add(BirthText);
		
		JButton Back = new JButton("�ڷΰ���");            // �ڷΰ��� ��ư
		Back.setBounds(50,150,100,40);
		jp1.add(Back);
		
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginHome LH = new LoginHome();
				LH.setVisible(true);
				dispose();
			}
		});
		
		JButton Next = new JButton("����");          // ���� ��ư
		Next.setBounds(200,150,100,40);
		jp1.add(Next);
		
		Next.addActionListener(new ActionListener() {         // ��ư������ PWSearch �޼ҵ� ����
			public void actionPerformed(ActionEvent e) {
				PWSearch();
			}
		});
		
		ct.add(jp1);
		
		setBounds(1,1,370,250);
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true);                              // JFrame�� �����ֶ�
	}
	
	// ��й�ȣ ã�� �޼ҵ�
	public void PWSearch() {
		Customer customer = new Customer();
		customer.SelectPWCustomer(IdText.getText(), BirthText.getText());
		try {
			customer.pstmt.setString(1,IdText.getText());       // ���̵� �ؽ�Ʈĭ �ҷ�����
			customer.pstmt.setString(2,BirthText.getText());    // ������� �ؽ�Ʈĭ �ҷ�����
			customer.rs = customer.pstmt.executeQuery();
			
			if(customer.rs.next()) {            // ��ġ�ϴ� �����Ͱ� �������
//				customer.setOnline(IdText.getText());
				JOptionPane.showMessageDialog(null, "��й�ȣ�� �缳���մϴ�.","��й�ȣ ã��",JOptionPane.INFORMATION_MESSAGE);
				LoginPwRe LPR = new LoginPwRe(IdText.getText());
				LPR.setVisible(true);
				dispose();
			}
			else if(IdText.getText().equals("") || BirthText.getText().equals("")) {   // ��ĭ��������� 
				JOptionPane.showMessageDialog(null,"��ĭ���� �Է����ּ���","����",JOptionPane.ERROR_MESSAGE);
			}
			else {              // ��ġ�ϴ� �����Ͱ� �������
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��������� ��ġ�����ʽ��ϴ�.","��й�ȣ ã��",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		customer.Close();
	}
}
