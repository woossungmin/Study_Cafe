package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ManagerMessage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMessage window = new ManagerMessage(new JFrame());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerMessage(JFrame frame1) {
		initialize(frame1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame1) {
		frame = new JFrame();
		frame.setBounds(500, 230, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	      frame.setResizable(false);
	      frame.setVisible(true);
		
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 286, 113);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 262, 93);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		
		RoundedButton2 btnNewButton = new RoundedButton2("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame1.dispose();
				Manager ma = new Manager();
			}
		});
		btnNewButton.setBounds(23, 61, 95, 23);
		panel_1.add(btnNewButton);
		
		JLabel text = new JLabel("");
		text.setFont(new Font("굴림", Font.BOLD, 14));
		text.setBounds(13, 24, 238, 27);
		panel_1.add(text);
		text.setForeground(new Color(114,166,255));
		text.setText("관리자 화면으로 이동하시겠습니까?");
		
		RoundedButton2 btnNewButton_1 = new RoundedButton2("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setText("취소");
		btnNewButton_1.setBounds(143, 61, 95, 23);
		panel_1.add(btnNewButton_1);
		
		
	}
}
