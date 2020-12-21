package com.kma.qltkb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.kma.qltkb.Student;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel Label_MSSV1;
	private JTextField textField_MSSV1;
	private JPasswordField passwordField_Login;
	private JButton ButtonSelect1;
	private JLabel LabelCheckLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setBackground(new Color(0, 255, 255));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Labeltitle1 = new JLabel("Ch\u00E0o m\u1EEBng b\u1EA1n \u0111\u1EBFn v\u1EDBi App Qu\u1EA3n l\u00FD th\u1EDDi kh\u00F3a bi\u1EC3u");
		Labeltitle1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		Labeltitle1.setBounds(78, 47, 407, 28);
		contentPane.add(Labeltitle1);
		
		Label_MSSV1 = new JLabel("MSSV");
		Label_MSSV1.setFont(new Font("Stencil", Font.PLAIN, 18));
		Label_MSSV1.setBounds(57, 110, 101, 28);
		contentPane.add(Label_MSSV1);
		
		JLabel Label_Pass1 = new JLabel("PASSWORD");
		Label_Pass1.setFont(new Font("Stencil", Font.PLAIN, 18));
		Label_Pass1.setBounds(57, 161, 101, 28);
		contentPane.add(Label_Pass1);
		
		textField_MSSV1 = new JTextField();
		textField_MSSV1.setBounds(197, 110, 145, 28);
		contentPane.add(textField_MSSV1);
		textField_MSSV1.setColumns(10);
		
		passwordField_Login = new JPasswordField();
		passwordField_Login.setBounds(197, 158, 145, 28);
		contentPane.add(passwordField_Login);
		
		ButtonSelect1 = new JButton("OK");
		// Bắt sự kiện khi click
		ButtonSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nếu checkLogin trả về kết quả true thì sẽ login thành công
				if(Student.checkLogin(textField_MSSV1.getText(), String.valueOf(passwordField_Login.getPassword()))==true) {
					Search a = new Search();
					a.setVisible(true);
					setVisible(false);
					
				}else {
					LabelCheckLogin.setText("Đăng nhập không thành công!! Hãy thử lại!!");
				}
			}
		});
		ButtonSelect1.setBackground(Color.LIGHT_GRAY);
		ButtonSelect1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonSelect1.setBounds(375, 133, 97, 33);
		contentPane.add(ButtonSelect1);
		
		JLabel LabelRegister_Login = new JLabel("   N\u1EBFu b\u1EA1n ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n h\u00E3y \u0111\u0103ng k\u00ED !!");
		LabelRegister_Login.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		LabelRegister_Login.setBounds(36, 312, 306, 28);
		contentPane.add(LabelRegister_Login);
		
		JButton ButtonSelect2 = new JButton("T\u1EA1i \u0111\u00E2y");
		ButtonSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register b =new Register();
				b.setVisible(true);
				setVisible(false);
			}
		});
		ButtonSelect2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonSelect2.setBounds(375, 315, 97, 25);
		contentPane.add(ButtonSelect2);
		
		LabelCheckLogin = new JLabel("");
		LabelCheckLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		LabelCheckLogin.setBounds(138, 202, 299, 28);
		contentPane.add(LabelCheckLogin);
	}
}
