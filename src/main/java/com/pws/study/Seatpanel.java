package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Seatpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Seatpanel() {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(23, 80, 816, 494);
	    
	    JPanel panel = new JPanel();;
		panel.setBounds(0, 10, 153, 295);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(border);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(151, 10, 518, 135);
		add(panel_1_2);
		panel_1_2.setBorder(border);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(151, 143, 518, 162);
		add(panel_1);
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255,255,255));
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(Color.WHITE);
		panel_1_2_1.setBounds(667, 10, 145, 295);
		add(panel_1_2_1);
		panel_1_2_1.setBackground(new Color(255,255,255));
		panel_1_2_1.setBorder(border);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 302, 357, 188);
		add(panel_1_1);
		panel_1_1.setBorder(border);
		panel_1_1.setBackground(new Color(255,255,255));
		
		  JPanel panel_1_1_1 = new JPanel();
	      panel_1_1_1.setLayout(null);
	      panel_1_1_1.setBackground(Color.WHITE);
	      panel_1_1_1.setBounds(354, 302, 458, 188);
	      add(panel_1_1_1);
	      panel_1_1_1.setBorder(border);
	      
	      RoundedButton s1 = new RoundedButton("1" + "<br>" +"1인석");
			s1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s1.setFont(new Font("굴림", Font.BOLD, 13));
			s1.setBounds(12, 38, 50, 44);
			panel.add(s1); 
			
			RoundedButton s2 = new RoundedButton("2" + "<br>" +"1인석");
			s2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s2.setFont(new Font("굴림", Font.BOLD, 13));
			s2.setBounds(12, 89, 50, 44);
			panel.add(s2);
			
			RoundedButton s3 = new RoundedButton("3" + "<br>" +"1인석");
			s3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s3.setFont(new Font("굴림", Font.BOLD, 13));
			s3.setBounds(12, 140, 50, 44);
			panel.add(s3);
			 
			RoundedButton s4 = new RoundedButton("4" + "<br>" +"1인석");
			s4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s4.setFont(new Font("굴림", Font.BOLD, 13));
			s4.setBounds(12, 190, 50, 44);
			panel.add(s4);
			 
			RoundedButton s5 = new RoundedButton("5" + "<br>" +"1인석");
			s5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s5.setFont(new Font("굴림", Font.BOLD, 13));
			s5.setBounds(12, 240, 50, 44);
			panel.add(s5);
			
			RoundedButton s6 = new RoundedButton("6" + "<br>" +"1인석");
			s6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s6.setFont(new Font("굴림", Font.BOLD, 13));
			s6.setBounds(92, 38, 50, 44);
			panel.add(s6);
			
			RoundedButton s7 = new RoundedButton("7" + "<br>" +"1인석");
			s7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s7.setFont(new Font("굴림", Font.BOLD, 13));
			s7.setBounds(92, 89, 50, 44);
			panel.add(s7);
			
			RoundedButton s8 = new RoundedButton("8" + "<br>" +"1인석");
			s8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s8.setFont(new Font("굴림", Font.BOLD, 13));
			s8.setBounds(92, 140, 50, 44);
			panel.add(s8);
			
			RoundedButton s9 = new RoundedButton("9" + "<br>" +"1인석");
			s9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s9.setFont(new Font("굴림", Font.BOLD, 13));
			s9.setBounds(92, 190, 50, 44);
			panel.add(s9);
			
			RoundedButton s10 = new RoundedButton("10" + "<br>" +"1인석");
			s10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s10.setFont(new Font("굴림", Font.BOLD, 13));
			s10.setBounds(92, 240, 50, 44);
			panel.add(s10);
		
			JLabel label1 = new JLabel("LAPTOP ZONE");
			label1.setForeground(new Color(0, 0, 255));
			label1.setBounds(28, 8, 101, 25);
			panel.add(label1);
			label1.setFont(new Font("굴림", Font.BOLD, 13));
			
			RoundedButton1 s27 = new RoundedButton1(""); 
			s27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s27.setText(" 스터디룸 1 <br><br>4~8 인실");
			s27.setFont(new Font("굴림", Font.BOLD, 20));
			s27.setBounds(56, 35, 248, 118);
			panel_1_1.add(s27);
			
			JLabel label4 = new JLabel("Study Room");
			label4.setBounds(130, 6, 101, 29);
			panel_1_1.add(label4);
			label4.setFont(new Font("굴림", Font.BOLD, 13));
			label4.setForeground(new Color(0,0,255));
			
			JLabel label2 = new JLabel("STUDY ZONE");
			label2.setForeground(new Color(0, 0, 255));
			label2.setFont(new Font("굴림", Font.BOLD, 13));
			label2.setBounds(215, 69, 90, 24);
			panel_1.add(label2);
			
			RoundedButton s11 = new RoundedButton("11" + "<br>" +"1인석");
			s11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s11.setFont(new Font("굴림", Font.BOLD, 13));
			s11.setBounds(30, 15, 50, 44);
			panel_1.add(s11);
			
			RoundedButton s12 = new RoundedButton("12" + "<br>" +"1인석");
			s12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s12.setFont(new Font("굴림", Font.BOLD, 13));
			s12.setBounds(90, 15, 50, 44);
			panel_1.add(s12);
			
			RoundedButton s13 = new RoundedButton("13" + "<br>" +"1인석");
			s13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s13.setFont(new Font("굴림", Font.BOLD, 13));
			s13.setBounds(150, 15, 50, 44);
			panel_1.add(s13);
			
			RoundedButton s14 = new RoundedButton("14" + "<br>" +"1인석");
			s14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s14.setFont(new Font("굴림", Font.BOLD, 13));
			s14.setBounds(210, 15, 50, 44);
			panel_1.add(s14);
		
			RoundedButton s15 = new RoundedButton("15" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s15.setFont(new Font("굴림", Font.BOLD, 13));
			s15.setBounds(270, 15, 50, 44);
			panel_1.add(s15);
			
			RoundedButton s16 = new RoundedButton("16" + "<br>" +"1인석");
			s16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s16.setFont(new Font("굴림", Font.BOLD, 13));
			s16.setBounds(330, 15, 50, 44);
			panel_1.add(s16);
			
			RoundedButton s17 = new RoundedButton("17" + "<br>" +"1인석");
			s17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s17.setFont(new Font("굴림", Font.BOLD, 13));
			s17.setBounds(390, 15, 50, 44);
			panel_1.add(s17);
			
			RoundedButton s18 = new RoundedButton("18" + "<br>" +"1인석");
			s18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s18.setFont(new Font("굴림", Font.BOLD, 13));
			s18.setBounds(450, 15, 50, 44);
			panel_1.add(s18);
			
			RoundedButton s19 = new RoundedButton("19" + "<br>" +"1인석");
			s19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s19.setFont(new Font("굴림", Font.BOLD, 13));
			s19.setBounds(30, 105, 50, 44);
			panel_1.add(s19);
			
			RoundedButton s20 = new RoundedButton("20" + "<br>" +"1인석");
			s20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s20.setFont(new Font("굴림", Font.BOLD, 13));
			s20.setBounds(90, 105, 50, 44);
			panel_1.add(s20);
			
			RoundedButton s21 = new RoundedButton("21" + "<br>" +"1인석");
			s21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s21.setFont(new Font("굴림", Font.BOLD, 13));
			s21.setBounds(150, 105, 50, 44);
			panel_1.add(s21);
			
			RoundedButton s22 = new RoundedButton("22" + "<br>" +"1인석");
			s22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s22.setFont(new Font("굴림", Font.BOLD, 13));
			s22.setBounds(210, 105, 50, 44);
			panel_1.add(s22);
			
			RoundedButton s23 = new RoundedButton("23" + "<br>" +"1인석");
			s23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s23.setFont(new Font("굴림", Font.BOLD, 13));
			s23.setBounds(270, 105, 50, 44);
			panel_1.add(s23);
			
			RoundedButton s24 = new RoundedButton("24" + "<br>" +"1인석");
			s24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s24.setFont(new Font("굴림", Font.BOLD, 13));
			s24.setBounds(330, 105, 50, 44);
			panel_1.add(s24);
			
			RoundedButton s25 = new RoundedButton("25" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s25.setFont(new Font("굴림", Font.BOLD, 13));
			s25.setBounds(390, 105, 50, 44);
			panel_1.add(s25);
			
			RoundedButton s26 = new RoundedButton("26" + "<br>" +"1인석");
			s26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s26.setFont(new Font("굴림", Font.BOLD, 13));
			s26.setBounds(450, 105, 50, 44);
			panel_1.add(s26);
			
			RoundedButton1 s28 = new RoundedButton1("");
			s28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			s28.setText(" 스터디룸 2 <br><br>6~12 인실");
			s28.setFont(new Font("굴림", Font.BOLD, 20));
			s28.setBounds(80, 35, 306, 118);
			panel_1_1_1.add(s28);
			
			JLabel label4_1 = new JLabel("Study Room");
			label4_1.setForeground(Color.BLUE);
			label4_1.setFont(new Font("굴림", Font.BOLD, 13));
			label4_1.setBounds(189, 6, 101, 29);
			panel_1_1_1.add(label4_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(0, 0, 71, 71);
			panel_1_2.add(panel_2);
			panel_2.setBackground(new Color(255,255,255));
			panel_2.setBorder(border);
			panel_2.setLayout(null);
			
			JLabel label18 = new JLabel("");
			label18.setBounds(5, 5, 62, 62);
			panel_2.add(label18);
			label18.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\coffee-cup (2).png"));
			
			
			JLabel label18_1 = new JLabel("");
			label18_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\meeting-room.png"));
			label18_1.setBounds(85, 29, 128, 64);
			panel_1_2.add(label18_1);
			
			JLabel label18_1_1 = new JLabel("");
			label18_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\meeting-room.png"));
			label18_1_1.setBounds(302, 29, 128, 64);
			panel_1_2.add(label18_1_1);
			
			JLabel label15 = new JLabel("로비 & 휴게실");
			label15.setForeground(new Color(0, 0, 255));
			label15.setFont(new Font("굴림", Font.BOLD, 13));
			label15.setBounds(215, 96, 101, 29);
			panel_1_2.add(label15);
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setLayout(null);
			panel_2_1.setBackground(Color.WHITE);
			panel_2_1.setBounds(447, 64, 71, 71);
			panel_1_2.add(panel_2_1);
			panel_2_1.setBorder(border);
			panel_2_1.setBackground(new Color(255,255,255));
			
			JLabel label21 = new JLabel("");
			label21.setBounds(5, 5, 62, 62);
			panel_2_1.add(label21);
			label21.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\toilet.png"));
			
			JLabel label6 = new JLabel("");
			label6.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\kiosk (2).png"));
			label6.setBounds(0, 5, 62, 62);
			panel_1_2_1.add(label6);
			
			JLabel label8 = new JLabel("");
			label8.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\lockers.png"));
			label8.setBounds(71, 5, 62, 62);
			panel_1_2_1.add(label8);
			
			JLabel label9 = new JLabel("키오스크");
			label9.setForeground(new Color(0, 0, 0));
			label9.setFont(new Font("굴림", Font.BOLD, 12));
			label9.setBounds(9, 61, 50, 29);
			panel_1_2_1.add(label9);
			
			
			JLabel label10 = new JLabel("사물함");
			label10.setForeground(new Color(0, 0, 0));
			label10.setFont(new Font("굴림", Font.BOLD, 12));
			label10.setBounds(82, 59, 50, 29);
			panel_1_2_1.add(label10);
			
			JLabel label11 = new JLabel("");
			label11.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\elevator.png"));
			label11.setBounds(11, 191, 62, 62);
			panel_1_2_1.add(label11);
			
			JLabel label12 = new JLabel("엘레베이터");
			label12.setForeground(new Color(0, 0, 0));
			label12.setFont(new Font("굴림", Font.BOLD, 12));
			label12.setBounds(12, 170, 70, 29);
			panel_1_2_1.add(label12);
			
			JLabel label13 = new JLabel("");
			label13.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\계단.png"));
			label13.setBounds(81, 185, 64, 100);
			panel_1_2_1.add(label13);
			
			JLabel label14 = new JLabel("계단");
			label14.setForeground(new Color(0, 0, 0));
			label14.setFont(new Font("굴림", Font.BOLD, 12));
			label14.setBounds(100, 169, 36, 29);
			panel_1_2_1.add(label14);
	}
}
