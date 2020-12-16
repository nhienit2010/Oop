package com.kma.qltkb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Search;
	private JTextArea Label_KQ;
	public static String newline = "\n";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp ng\u00E0y/th\u00E1ng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(97, 128, 120, 24);
		contentPane.add(lblNewLabel);
		
		textField_Search = new JTextField();
		textField_Search.setBounds(247, 128, 175, 24);
		contentPane.add(textField_Search);
		textField_Search.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(97, 171, 120, 24);
		contentPane.add(lblNewLabel_1);

		Label_KQ = new JTextArea(5, 20);
		Label_KQ.setBounds(247, 171, 175, 100);
		contentPane.add(Label_KQ);
		
		JLabel lblNewLabel_3 = new JLabel("Qu\u1EA3n l\u00FD th\u1EDDi kh\u00F3a bi\u1EC3u");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(183, 56, 202, 24);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date = textField_Search.getText(); 
					ParseXLS parse = new ParseXLS();
					Label_KQ.setText("Mon hoc cua ngay thu " + date + newline + newline);
					String data[] = parse.findSubjects(date).replace("[", "").replace("]", "").replaceAll("\n", "").split(",");
					if (data[0].equals("null")) {
						Label_KQ.append("Khong co mon nao" + newline);
						return;
					}
					for (int i=0; i<data.length; ++i) {
							String subject = data[i].substring(0, data[i].indexOf('(')).strip();
							String room = data[i].substring(data[i].indexOf('(') + 1, data[i].indexOf(')')).strip();
							Label_KQ.append("Hoc mon " + subject + " tai "  + room + newline);
					}
				}catch(IOException error) {
					Label_KQ.setText("Something went wrong!" + newline);
				}
			}
		});
		btnNewButton.setBounds(437, 128, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login t = new Login();
				t.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(448, 315, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}
