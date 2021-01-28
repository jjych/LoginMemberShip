package com.java.ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.java.ex.db.Customer;

public class LoginPwRe extends JFrame{
	
	private String userid;  // �������� �����Ҽ��ִ� userid ���� ����
	
	int pwNum = 0;
	JPasswordField pwText = null;
	JPasswordField pwReText = null;
	JLabel idLb = null;
	
	public LoginPwRe(String userid) {
		this.userid = userid;                 // userid �ҷ�����
		Container ct = getContentPane();
		
		setTitle("��й�ȣ �缳��");
		setSize(370,250);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		
		idLb = new JLabel("���̵� :     " + userid);       // ���� ���̵� ǥ�� ��
		idLb.setBounds(80,0,200,50);
		idLb.setFont(new Font("���̵� : ",Font.BOLD,13));
		jp1.add(idLb);
		
		JLabel pwL = new JLabel("�� ��й�ȣ");         // �� ��й�ȣ ��
		pwL.setBounds(30,30,100,50);
		pwL.setFont(new Font("�� ��й�ȣ",Font.BOLD,13));
		jp1.add(pwL);
		
		pwText = new JPasswordField();      // �� ��й�ȣ ���� ĭ
		pwText.setBounds(120,40,140,30);
		jp1.add(pwText);
		
		JLabel pwRe = new JLabel("��Ȯ��");           // ��Ȯ�� ��
		pwRe.setBounds(50,70,100,50);
		pwRe.setFont(new Font("��Ȯ��",Font.BOLD,13));
		jp1.add(pwRe);
		
		pwReText = new JPasswordField();       // ��Ȯ�� ���� ĭ
		pwReText.setBounds(120,80,140,30);
		jp1.add(pwReText);
		
		JButton PWReBtn = new JButton("��Ȯ��");         // ��Ȯ�� ��ư
		PWReBtn.setBounds(260,80,80,30);
		jp1.add(PWReBtn);
		
		JLabel PWCompareLb = new JLabel();        // ��ġ��ȿ�� Ȯ�� ��
		PWCompareLb.setBounds(120,100,200,30);
		PWCompareLb.setFont(new Font("",Font.BOLD,10));
		jp1.add(PWCompareLb);
		
		// ��Ȯ�� ��ư������
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
		
		// �Ϸ��ư ������
		Success.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ĭ���������
				if(pwText.getText().equals("") || pwReText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��ĭ���� �Է����ּ���.","����",JOptionPane.ERROR_MESSAGE);
				}
				// ��й�ȣ�� ��ġ�����������
				else if(pwNum == 0) {
					JOptionPane.showMessageDialog(null,"��й�ȣ�� ��Ȯ�����ּ���.","����", JOptionPane.ERROR_MESSAGE);
				}
				// ��й�ȣ�� ��ġ�Ұ��
				else if(pwNum == 1) {
					Customer customer = new Customer();   // Customer ����
					customer.Update("update membership set PW = ? where ID = '" + userid +"'");
					try {
						customer.pstmt.setString(1 ,pwText.getText());         // PwText ĭ�� �Է��� �� �ҷ�����
						int result = customer.pstmt.executeUpdate();           // �� ������ ������Ʈ
						if(1 == result) {                                      // ����������� ����
							JOptionPane.showMessageDialog(null, "��й�ȣ�� �缳���Ǿ����ϴ�.","��й�ȣ �缳��",JOptionPane.INFORMATION_MESSAGE);
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
		setLocationRelativeTo(null);                  // �����â ���߾����� 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // ����â���� �ű�� â���ݾ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // â ����� JFrame �ڵ�����
		setVisible(true); 
	}

}
