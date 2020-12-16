package com.kma.qltkb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_1;
	private JTextField textField_Id;
	private JTextField textField_FullName;
	private JLabel Label_check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 400);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp th\u00F4ng tin \u0111\u0103ng k\u00ED");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(203, 26, 258, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 89, 126, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(50, 130, 126, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(50, 171, 126, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm PASSWORD");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(50, 212, 147, 28);
		contentPane.add(lblNewLabel_4);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(209, 212, 166, 28);
		contentPane.add(passwordField_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(209, 171, 166, 28);
		contentPane.add(passwordField_1);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(209, 130, 166, 28);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_FullName = new JTextField();
		textField_FullName.setBounds(209, 89, 166, 28);
		contentPane.add(textField_FullName);
		textField_FullName.setColumns(10);
		
		JButton ButtonOK = new JButton("OK");
		ButtonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if (textField_Id.getText().equals("") || 
					  textField_Id.getText().equals("") || 
					  textField_FullName.getText().equals("") ||
					  passwordField_1.getText().equals("") ||
					  passwordField_2.getText().equals("") ) {
				  Label_check.setText("Không được bỏ trống!!");
				  return;
			  }
				  
			  if(Student.checkExists(textField_Id.getText()) == false) {
				  
				  if(String.valueOf(passwordField_1.getPassword()).equals(String.valueOf(passwordField_2.getPassword()))==true) {
					  Student reg = new Student(textField_FullName.getText(), textField_Id.getText(),String.valueOf(passwordField_1.getPassword()));
					  reg.addIntoSQL();
					  Label_check.setText("Đăng ký thành công!!");
				  }else {
					  Label_check.setText("Mật khẩu không trùng khớp!!");
				  }	
				  
			  }else {
				  Label_check.setText("MSSV đã tồn tại!");
			  }
				
			}
		});
		ButtonOK.setBounds(245, 253, 97, 25);
		contentPane.add(ButtonOK);
		
		Label_check = new JLabel("");
		Label_check.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		Label_check.setBounds(50, 300, 195, 28);
		contentPane.add(Label_check);
		
		JButton Button_Login = new JButton("Login");
		Button_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login d = new Login();
				d.setVisible(true);
				setVisible(false);
			}
		});
		Button_Login.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button_Login.setBounds(245, 302, 97, 25);
		contentPane.add(Button_Login);
	}
	
	
	public void registerForUser() {
		String ps ;
		ps = String.valueOf(passwordField_1.getPassword());
		
		System.out.println(textField_FullName.getText() + textField_Id.getText() + ps);
	}

}
