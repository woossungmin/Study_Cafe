package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JTextField;
import javax.swing.Timer;

public class LockInformation {

	private JFrame frame;
	private JLabel locknumber;
	private JPanel jpanel;
	String Phone = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LockInformation window = new LockInformation("","");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LockInformation(String Lock, String locknumber) {
		initialize(Lock,locknumber);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String lock, String locknumber) {
		frame = new JFrame();
		frame.setBounds(560, 230, 360, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setResizable(false);
	    frame.setVisible(true);
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 346, 163);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 322, 143);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		
		
		RoundedButton2 btnNewButton = new RoundedButton2("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(108, 110, 95, 23);
		panel_1.add(btnNewButton);
		
		JLabel locklabel = new JLabel();
		locklabel.setFont(new Font("굴림", Font.BOLD, 15));
		locklabel.setBounds(44, 35, 95, 30);
		panel_1.add(locklabel);
		locklabel.setForeground(new Color(255, 128, 128));
		locklabel.setText(lock);
		
		JLabel phonetext = new JLabel("");
		phonetext.setForeground(new Color(114, 166, 255));
		phonetext.setFont(new Font("굴림", Font.BOLD, 15));
		phonetext.setBounds(30, 64, 135, 30);
		panel_1.add(phonetext);
		phonetext.setForeground(new Color(255, 128, 128));
		
		Post po = new Post();
		JSONObject data = new JSONObject();
		try {
			data.put("locknumber", locknumber);
			JSONObject check = po.jsonpost("/FindLock", data);
			String phone = check.getString("phone");
			phonetext.setText(phone);
			
			JLabel phonetext_1 = new JLabel("님이 사용중입니다.");
			phonetext_1.setForeground(new Color(114, 166, 255));
			phonetext_1.setFont(new Font("굴림", Font.BOLD, 15));
			phonetext_1.setBounds(155, 64, 150, 30);
			panel_1.add(phonetext_1);
			
			JLabel seatlabel_1 = new JLabel();
			seatlabel_1.setText("번은 회원 전화번호");
			seatlabel_1.setForeground(new Color(114, 166, 255));
			seatlabel_1.setFont(new Font("굴림", Font.BOLD, 15));
			seatlabel_1.setBounds(130, 35, 147, 30);
			panel_1.add(seatlabel_1);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
