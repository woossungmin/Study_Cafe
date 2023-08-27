package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Seatpanel extends JPanel {
	JPanel borderpanel;
	JButton homebutton;
	JButton closebutton;
	/**
	 * Create the panel.
	 */
	/**
	 * 
	 */
	public Seatpanel(JPanel borderpanel, JButton homebutton, JButton closebutton) {
		this.borderpanel = borderpanel;
		this.homebutton = homebutton;
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(23, 40, 816, 580);
	    
	    JPanel panel = new JPanel();;
		panel.setBounds(0, 82, 153, 295);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(border);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(151, 82, 518, 135);
		add(panel_1_2);
		panel_1_2.setBorder(border);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(151, 215, 518, 162);
		add(panel_1);
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255,255,255));
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(Color.WHITE);
		panel_1_2_1.setBounds(667, 82, 145, 295);
		add(panel_1_2_1);
		panel_1_2_1.setBackground(new Color(255,255,255));
		panel_1_2_1.setBorder(border);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 375, 812, 188);
		add(panel_1_1);
		panel_1_1.setBorder(border);
		panel_1_1.setBackground(new Color(255,255,255));
	        
	      RoundedButton s1 = new RoundedButton("1" + "<br>" +"1인석");
			s1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if (s1.isBackgroundColorEqual(new Color(200, 196, 196))) {
				            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
				            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
				            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 1", "s1", borderpanel, homebutton, closebutton);
				        }
				}
			});
			s1.setFont(new Font("굴림", Font.BOLD, 13));
			s1.setBounds(12, 38, 50, 44);
			panel.add(s1); 
			 
			RoundedButton s2 = new RoundedButton("2" + "<br>" +"1인석");
			s2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s2.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 2", "s2", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s2.setFont(new Font("굴림", Font.BOLD, 13));
			s2.setBounds(12, 89, 50, 44);
			panel.add(s2);
			
			RoundedButton s3 = new RoundedButton("3" + "<br>" +"1인석");
			s3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s3.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 3", "s3", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s3.setFont(new Font("굴림", Font.BOLD, 13));
			s3.setBounds(12, 140, 50, 44);
			panel.add(s3);
			 
			RoundedButton s4 = new RoundedButton("4" + "<br>" +"1인석");
			s4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s4.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 4", "s4", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s4.setFont(new Font("굴림", Font.BOLD, 13));
			s4.setBounds(12, 190, 50, 44);
			panel.add(s4);
			 
			RoundedButton s5 = new RoundedButton("5" + "<br>" +"1인석");
			s5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s5.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 5", "s5", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s5.setFont(new Font("굴림", Font.BOLD, 13));
			s5.setBounds(12, 240, 50, 44);
			panel.add(s5);
			
			RoundedButton s6 = new RoundedButton("6" + "<br>" +"1인석");
			s6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s6.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 6", "s6", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s6.setFont(new Font("굴림", Font.BOLD, 13));
			s6.setBounds(92, 38, 50, 44);
			panel.add(s6);
			
			RoundedButton s7 = new RoundedButton("7" + "<br>" +"1인석");
			s7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s7.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 7", "s7", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s7.setFont(new Font("굴림", Font.BOLD, 13));
			s7.setBounds(92, 89, 50, 44);
			panel.add(s7);
			
			RoundedButton s8 = new RoundedButton("8" + "<br>" +"1인석");
			s8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s8.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 8", "s8", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s8.setFont(new Font("굴림", Font.BOLD, 13));
			s8.setBounds(92, 140, 50, 44);
			panel.add(s8);
			
			RoundedButton s9 = new RoundedButton("9" + "<br>" +"1인석");
			s9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s9.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 9", "s9", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s9.setFont(new Font("굴림", Font.BOLD, 13));
			s9.setBounds(92, 190, 50, 44);
			panel.add(s9);
			
			RoundedButton s10 = new RoundedButton("10" + "<br>" +"1인석");
			s10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s10.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("LAPTOP ZONE , 10", "s10", borderpanel, homebutton, closebutton);
			        }
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
			
			JLabel label2 = new JLabel("STUDY ZONE");
			label2.setForeground(new Color(0, 0, 255));
			label2.setFont(new Font("굴림", Font.BOLD, 13));
			label2.setBounds(215, 69, 90, 24);
			panel_1.add(label2);
			
			RoundedButton s11 = new RoundedButton("11" + "<br>" +"1인석");
			s11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s11.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 11", "s11", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s11.setFont(new Font("굴림", Font.BOLD, 13));
			s11.setBounds(30, 15, 50, 44);
			panel_1.add(s11);
			
			RoundedButton s12 = new RoundedButton("12" + "<br>" +"1인석");
			s12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s12.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 12", "s12", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s12.setFont(new Font("굴림", Font.BOLD, 13));
			s12.setBounds(90, 15, 50, 44);
			panel_1.add(s12);
			
			RoundedButton s13 = new RoundedButton("13" + "<br>" +"1인석");
			s13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s13.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 13", "s13", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s13.setFont(new Font("굴림", Font.BOLD, 13));
			s13.setBounds(150, 15, 50, 44);
			panel_1.add(s13);
			
			RoundedButton s14 = new RoundedButton("14" + "<br>" +"1인석");
			s14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s14.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 14", "s14", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s14.setFont(new Font("굴림", Font.BOLD, 13));
			s14.setBounds(210, 15, 50, 44);
			panel_1.add(s14);
		
			RoundedButton s15 = new RoundedButton("15" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s15.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 15", "s15", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s15.setFont(new Font("굴림", Font.BOLD, 13));
			s15.setBounds(270, 15, 50, 44);
			panel_1.add(s15);
			
			RoundedButton s16 = new RoundedButton("16" + "<br>" +"1인석");
			s16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s16.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 16", "s16", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s16.setFont(new Font("굴림", Font.BOLD, 13));
			s16.setBounds(330, 15, 50, 44);
			panel_1.add(s16);
			
			RoundedButton s17 = new RoundedButton("17" + "<br>" +"1인석");
			s17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s17.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 17", "s17", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s17.setFont(new Font("굴림", Font.BOLD, 13));
			s17.setBounds(390, 15, 50, 44);
			panel_1.add(s17);
			
			RoundedButton s18 = new RoundedButton("18" + "<br>" +"1인석");
			s18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s18.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 18", "s18", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s18.setFont(new Font("굴림", Font.BOLD, 13));
			s18.setBounds(450, 15, 50, 44);
			panel_1.add(s18);
			
			RoundedButton s19 = new RoundedButton("19" + "<br>" +"1인석");
			s19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s19.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 19", "s19", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s19.setFont(new Font("굴림", Font.BOLD, 13));
			s19.setBounds(30, 105, 50, 44);
			panel_1.add(s19);
			
			RoundedButton s20 = new RoundedButton("20" + "<br>" +"1인석");
			s20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s20.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 20", "s20", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s20.setFont(new Font("굴림", Font.BOLD, 13));
			s20.setBounds(90, 105, 50, 44);
			panel_1.add(s20);
			
			RoundedButton s21 = new RoundedButton("21" + "<br>" +"1인석");
			s21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s21.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 21", "s21", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s21.setFont(new Font("굴림", Font.BOLD, 13));
			s21.setBounds(150, 105, 50, 44);
			panel_1.add(s21);
			
			RoundedButton s22 = new RoundedButton("22" + "<br>" +"1인석");
			s22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s22.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 22", "s22", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s22.setFont(new Font("굴림", Font.BOLD, 13));
			s22.setBounds(210, 105, 50, 44);
			panel_1.add(s22);
			
			RoundedButton s23 = new RoundedButton("23" + "<br>" +"1인석");
			s23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s23.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 23", "s23", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s23.setFont(new Font("굴림", Font.BOLD, 13));
			s23.setBounds(270, 105, 50, 44);
			panel_1.add(s23);
			
			RoundedButton s24 = new RoundedButton("24" + "<br>" +"1인석");
			s24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s24.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 24", "s24", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s24.setFont(new Font("굴림", Font.BOLD, 13));
			s24.setBounds(330, 105, 50, 44);
			panel_1.add(s24);
			
			RoundedButton s25 = new RoundedButton("25" + "<br>" +"1인석");
			s25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s25.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 25", "s25", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s25.setFont(new Font("굴림", Font.BOLD, 13));
			s25.setBounds(390, 105, 50, 44);
			panel_1.add(s25);
			
			RoundedButton s26 = new RoundedButton("26" + "<br>" +"1인석");
			s26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (s26.isBackgroundColorEqual(new Color(200, 196, 196))) {
			            // 배경색이 바뀌었을 때의 이벤트 처리 코드를 여기에 추가하세요
			            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
			            SeatCompulsory se = new SeatCompulsory("STUDY ZOON , 26", "s26", borderpanel, homebutton, closebutton);
			        }
				}
			});
			s26.setFont(new Font("굴림", Font.BOLD, 13));
			s26.setBounds(450, 105, 50, 44);
			panel_1.add(s26);
			
			RoundedButton s27 = new RoundedButton("27<br>1인석");
			s27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 27", "s27", borderpanel, homebutton, closebutton);
				}
			});
			s27.setFont(new Font("굴림", Font.BOLD, 13));
			s27.setBounds(12, 10, 50, 44);
			panel_1_1.add(s27);
			
			RoundedButton s28 = new RoundedButton("28<br>1인석");
			s28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 28", "s28", borderpanel, homebutton, closebutton);
				}
			});
			s28.setFont(new Font("굴림", Font.BOLD, 13));
			s28.setBounds(68, 10, 50, 44);
			panel_1_1.add(s28);
			
			RoundedButton s29 = new RoundedButton("29<br>1인석");
			s29.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 29", "s29", borderpanel, homebutton, closebutton);
				}
			});
			s29.setFont(new Font("굴림", Font.BOLD, 13));
			s29.setBounds(152, 10, 50, 44);
			panel_1_1.add(s29);
			
			RoundedButton s30 = new RoundedButton("30<br>1인석");
			s30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 30", "s30", borderpanel, homebutton, closebutton);
				}
			});
			s30.setFont(new Font("굴림", Font.BOLD, 13));
			s30.setBounds(208, 10, 50, 44);
			panel_1_1.add(s30);
			
			RoundedButton s31 = new RoundedButton("31<br>1인석");
			s31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 31", "s31", borderpanel, homebutton, closebutton);
				}
			});
			s31.setFont(new Font("굴림", Font.BOLD, 13));
			s31.setBounds(264, 10, 50, 44);
			panel_1_1.add(s31);
			
			RoundedButton s32 = new RoundedButton("32<br>1인석");
			s32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 32", "s32", borderpanel, homebutton, closebutton);
				}
			});
			s32.setFont(new Font("굴림", Font.BOLD, 13));
			s32.setBounds(348, 10, 50, 44);
			panel_1_1.add(s32);
			
			RoundedButton s33 = new RoundedButton("33<br>1인석");
			s33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 33", "s33", borderpanel, homebutton, closebutton);
				}
			});
			s33.setFont(new Font("굴림", Font.BOLD, 13));
			s33.setBounds(404, 10, 50, 44);
			panel_1_1.add(s33);
			
			RoundedButton s34 = new RoundedButton("34<br>1인석");
			s34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 34", "s34", borderpanel, homebutton, closebutton);
				}
			});
			s34.setFont(new Font("굴림", Font.BOLD, 13));
			s34.setBounds(488, 10, 50, 44);
			panel_1_1.add(s34);
			
			RoundedButton s35 = new RoundedButton("35<br>1인석");
			s35.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 35", "s35", borderpanel, homebutton, closebutton);
				}
			});
			s35.setFont(new Font("굴림", Font.BOLD, 13));
			s35.setBounds(544, 10, 50, 44);
			panel_1_1.add(s35);
			
			RoundedButton s36 = new RoundedButton("36<br>1인석");
			s36.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 36", "s36", borderpanel, homebutton, closebutton);
				}
			});
			s36.setFont(new Font("굴림", Font.BOLD, 13));
			s36.setBounds(628, 10, 50, 44);
			panel_1_1.add(s36);
			
			RoundedButton s37 = new RoundedButton("37<br>1인석");
			s37.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 37", "s37", borderpanel, homebutton, closebutton);
				}
			});
			s37.setFont(new Font("굴림", Font.BOLD, 13));
			s37.setBounds(684, 10, 50, 44);
			panel_1_1.add(s37);
			
			RoundedButton s38 = new RoundedButton("38<br>1인석");
			s38.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 38", "s38", borderpanel, homebutton, closebutton);
				}
			});
			s38.setFont(new Font("굴림", Font.BOLD, 13));
			s38.setBounds(740, 10, 50, 44);
			panel_1_1.add(s38);
			
			RoundedButton s39 = new RoundedButton("39<br>1인석");
			s39.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 39", "s39", borderpanel, homebutton, closebutton);
				}
			});
			s39.setFont(new Font("굴림", Font.BOLD, 13));
			s39.setBounds(12, 77, 50, 44);
			panel_1_1.add(s39);
			
			RoundedButton s40 = new RoundedButton("40<br>1인석");
			s40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 40", "s40", borderpanel, homebutton, closebutton);
				}
			});
			s40.setFont(new Font("굴림", Font.BOLD, 13));
			s40.setBounds(68, 77, 50, 44);
			panel_1_1.add(s40);
			
			RoundedButton s41 = new RoundedButton("41<br>1인석");
			s41.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 41", "s41", borderpanel, homebutton, closebutton);
				}
			});
			s41.setFont(new Font("굴림", Font.BOLD, 13));
			s41.setBounds(12, 131, 50, 44);
			panel_1_1.add(s41);
			
			RoundedButton s42 = new RoundedButton("42<br>1인석");
			s42.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 42", "s42", borderpanel, homebutton, closebutton);
				}
			});
			s42.setFont(new Font("굴림", Font.BOLD, 13));
			s42.setBounds(68, 131, 50, 44);
			panel_1_1.add(s42);
			
			RoundedButton s43 = new RoundedButton("43<br>1인석");
			s43.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 43", "s43", borderpanel, homebutton, closebutton);
				}
			});
			s43.setFont(new Font("굴림", Font.BOLD, 13));
			s43.setBounds(152, 77, 50, 44);
			panel_1_1.add(s43);
			
			RoundedButton s44 = new RoundedButton("44<br>1인석");
			s44.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 44", "s44", borderpanel, homebutton, closebutton);
				}
			});
			s44.setFont(new Font("굴림", Font.BOLD, 13));
			s44.setBounds(208, 77, 50, 44);
			panel_1_1.add(s44);
			
			RoundedButton s45 = new RoundedButton("45<br>1인석");
			s45.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 45", "s45", borderpanel, homebutton, closebutton);
				}
			});
			s45.setFont(new Font("굴림", Font.BOLD, 13));
			s45.setBounds(264, 77, 50, 44);
			panel_1_1.add(s45);
			
			RoundedButton s46 = new RoundedButton("46<br>1인석");
			s46.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 46", "s46", borderpanel, homebutton, closebutton);
				}
			});
			s46.setFont(new Font("굴림", Font.BOLD, 13));
			s46.setBounds(152, 131, 50, 44);
			panel_1_1.add(s46);
			
			RoundedButton s47 = new RoundedButton("47<br>1인석");
			s47.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 47", "s47", borderpanel, homebutton, closebutton);
				}
			});
			s47.setFont(new Font("굴림", Font.BOLD, 13));
			s47.setBounds(208, 131, 50, 44);
			panel_1_1.add(s47);
			
			RoundedButton s48 = new RoundedButton("48<br>1인석");
			s48.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 48", "s48", borderpanel, homebutton, closebutton);
				}
			});
			s48.setFont(new Font("굴림", Font.BOLD, 13));
			s48.setBounds(264, 131, 50, 44);
			panel_1_1.add(s48);
			
			RoundedButton s49 = new RoundedButton("49<br>1인석");
			s49.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 49", "s49", borderpanel, homebutton, closebutton);
				}
			});
			s49.setFont(new Font("굴림", Font.BOLD, 13));
			s49.setBounds(572, 77, 50, 44);
			panel_1_1.add(s49);
			
			RoundedButton s50 = new RoundedButton("50<br>1인석");
			s50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 50", "s50", borderpanel, homebutton, closebutton);
				}
			});
			s50.setFont(new Font("굴림", Font.BOLD, 13));
			s50.setBounds(628, 77, 50, 44);
			panel_1_1.add(s50);
			
			RoundedButton s51 = new RoundedButton("51<br>1인석");
			s51.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 51", "s51", borderpanel, homebutton, closebutton);
				}
			});
			s51.setFont(new Font("굴림", Font.BOLD, 13));
			s51.setBounds(684, 77, 50, 44);
			panel_1_1.add(s51);
			
			RoundedButton s52 = new RoundedButton("52<br>1인석");
			s52.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 52", "s52", borderpanel, homebutton, closebutton);
				}
			});
			s52.setFont(new Font("굴림", Font.BOLD, 13));
			s52.setBounds(740, 77, 50, 44);
			panel_1_1.add(s52);
			
			RoundedButton s53 = new RoundedButton("53<br>1인석");
			s53.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 53", "s53", borderpanel, homebutton, closebutton);
				}
			});
			s53.setFont(new Font("굴림", Font.BOLD, 13));
			s53.setBounds(572, 131, 50, 44);
			panel_1_1.add(s53);
			
			RoundedButton s54 = new RoundedButton("54<br>1인석");
			s54.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 54", "s54", borderpanel, homebutton, closebutton);
				}
			});
			s54.setFont(new Font("굴림", Font.BOLD, 13));
			s54.setBounds(628, 131, 50, 44);
			panel_1_1.add(s54);
			
			RoundedButton s55 = new RoundedButton("55<br>1인석");
			s55.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 55", "s55", borderpanel, homebutton, closebutton);
				}
			});
			s55.setFont(new Font("굴림", Font.BOLD, 13));
			s55.setBounds(684, 131, 50, 44);
			panel_1_1.add(s55);
			
			RoundedButton s56 = new RoundedButton("56<br>1인석");
			s56.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            Seatpanel sa = new Seatpanel(borderpanel, homebutton, closebutton);
		            SeatCompulsory se = new SeatCompulsory("CAFE ZOON , 56", "s56", borderpanel, homebutton, closebutton);
				}
			});
			s56.setFont(new Font("굴림", Font.BOLD, 13));
			s56.setBounds(740, 131, 50, 44);
			panel_1_1.add(s56);
			
			JSONObject data = new JSONObject();
			try {
				String activations = "0";
				data.put("activations", activations);
				Post po = new Post();
				
				JSONObject check = po.jsonpost("/FindSeatNumber", data);
				if((check.get("check")).equals("true"))
				{
					JSONArray jArray = new JSONArray();
					jArray = (JSONArray) check.get("seat_numbers");
					count = (int) check.get("count");
					
					data.put("activations", activations);
					data.put("id", "LAPTOP ZONE");
					check = po.jsonpost("/FindSeatType", data);
					count1 = (int) check.get("count");
					
					data.put("activations", activations);
					data.put("id", "STUDY ZONE");
					check = po.jsonpost("/FindSeatType", data);
					count2 = (int) check.get("count");
					
					data.put("activations", activations);
					data.put("id", "CAFE ZONE");
					check = po.jsonpost("/FindSeatType", data);
					count3 = (int) check.get("count");
					
					Map<String, RoundedButton> buttonMap = new HashMap<>(); //hashMap으로 문자열과 버튼 객체 매칭함
					buttonMap.put("s1",s1);
					buttonMap.put("s2",s2);
					buttonMap.put("s3",s3);
					buttonMap.put("s4",s4);
					buttonMap.put("s5",s5);
					buttonMap.put("s6",s6);
					buttonMap.put("s7",s7);
					buttonMap.put("s8",s8);
					buttonMap.put("s9",s9);
					buttonMap.put("s10",s10);
					buttonMap.put("s11",s11);
					buttonMap.put("s12",s12);
					buttonMap.put("s13",s13);
					buttonMap.put("s14",s14);
					buttonMap.put("s15",s15);
					buttonMap.put("s16",s16);
					buttonMap.put("s17",s17);
					buttonMap.put("s18",s18);
					buttonMap.put("s19",s19);
					buttonMap.put("s20",s20);
					buttonMap.put("s21",s21);
					buttonMap.put("s22",s22);
					buttonMap.put("s23",s23);
					buttonMap.put("s24",s24);
					buttonMap.put("s25",s25);
					buttonMap.put("s26",s26);
					buttonMap.put("s27",s27);
					buttonMap.put("s28",s28);
					buttonMap.put("s29",s29);
					buttonMap.put("s30",s30);
					buttonMap.put("s31",s31);
					buttonMap.put("s32",s32);
					buttonMap.put("s33",s33);
					buttonMap.put("s34",s34);
					buttonMap.put("s35",s35);
					buttonMap.put("s36",s36);
					buttonMap.put("s37",s37);
					buttonMap.put("s38",s38);
					buttonMap.put("s39",s39);
					buttonMap.put("s40",s40);
					buttonMap.put("s41",s41);
					buttonMap.put("s42",s42);
					buttonMap.put("s43",s43);
					buttonMap.put("s44",s44);
					buttonMap.put("s45",s45);
					buttonMap.put("s46",s46);
					buttonMap.put("s47",s47);
					buttonMap.put("s48",s48);
					buttonMap.put("s49",s49);
					buttonMap.put("s50",s50);
					buttonMap.put("s51",s51);
					buttonMap.put("s52",s52);
					buttonMap.put("s53",s53);
					buttonMap.put("s54",s54);
					buttonMap.put("s55",s55);
					buttonMap.put("s56",s56);

			        for(int i = 0; i < jArray.length(); i++) {
			            String seatNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.

		                	RoundedButton button = buttonMap.get(seatNumber);
	                    	button.setBorderPainted(false);
	                    	button.setBackgroundColor(new Color(200, 196, 196));
	                    	button.repaint();
			            }

				    } else {
				        // ...
				    }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(0, 0, 64, 64);
			panel_1_2.add(panel_2);
			panel_2.setBackground(new Color(255,255,255));
			panel_2.setBorder(border);
			panel_2.setLayout(null);
			
			JLabel label18 = new JLabel("");
			label18.setBounds(5, 4, 54, 54);
			panel_2.add(label18);
			label18.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\espresso.png"));
			
			
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
			label13.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\stairs (1).png"));
			label13.setBounds(81, 190, 64, 100);
			panel_1_2_1.add(label13);
			
			JLabel label14 = new JLabel("계단");
			label14.setForeground(new Color(0, 0, 0));
			label14.setFont(new Font("굴림", Font.BOLD, 12));
			label14.setBounds(100, 169, 36, 29);
			panel_1_2_1.add(label14);
			
			String countStr = Integer.toString(count);
			String countStr1 = Integer.toString(count1);
			String countStr2 = Integer.toString(count2);
			String countStr3 = Integer.toString(count3);
			
			JLabel lblNewLabel = new JLabel(" 28");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel.setBounds(110, 22, 53, 48);
			add(lblNewLabel);
			lblNewLabel.setForeground(new Color(114,166,255));
			JLabel seatlabel = new JLabel("");
			seatlabel.setFont(new Font("굴림", Font.PLAIN, 30));
			seatlabel.setBounds(40, 22, 53, 48);
			add(seatlabel);
			seatlabel.setForeground(new Color(255, 128, 128));
			seatlabel.setText(countStr);
			JLabel lblNewLabel_3 = new JLabel("/");
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_3.setBounds(90, 20, 17, 52);
			add(lblNewLabel_3);
			lblNewLabel_3.setForeground(new Color(114,166,255));
			JLabel lblNewLabel_4 = new JLabel("좌석 총 사용 현황");
			lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_4.setBounds(12, 8, 164, 24);
			add(lblNewLabel_4);
			lblNewLabel_4.setForeground(new Color(114,166,255));
			JLabel lblNewLabel_4_1 = new JLabel("LAPTOP ZONE");
			lblNewLabel_4_1.setForeground(new Color(114, 166, 255));
			lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_4_1.setBounds(233, 8, 153, 24);
			add(lblNewLabel_4_1);
			JLabel LaptopZone = new JLabel("28");
			LaptopZone.setForeground(new Color(255, 128, 128));
			LaptopZone.setFont(new Font("굴림", Font.PLAIN, 30));
			LaptopZone.setBounds(251, 22, 53, 48);
			add(LaptopZone);
			LaptopZone.setText(countStr1);
			JLabel lblNewLabel_3_1 = new JLabel("/");
			lblNewLabel_3_1.setForeground(new Color(114, 166, 255));
			lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_3_1.setBounds(301, 20, 17, 52);
			add(lblNewLabel_3_1);
			JLabel lblNewLabel_1 = new JLabel(" 28");
			lblNewLabel_1.setForeground(new Color(114, 166, 255));
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(321, 22, 53, 48);
			add(lblNewLabel_1);
			JLabel lblNewLabel_4_2 = new JLabel("STUDY ROOM");
			lblNewLabel_4_2.setForeground(new Color(114, 166, 255));
			lblNewLabel_4_2.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_4_2.setBounds(654, 8, 164, 24);
			add(lblNewLabel_4_2);
			JLabel StudyRoom = new JLabel("28");
			StudyRoom.setForeground(new Color(255, 128, 128));
			StudyRoom.setFont(new Font("굴림", Font.PLAIN, 30));
			StudyRoom.setBounds(668, 22, 53, 48);
			add(StudyRoom);
			StudyRoom.setText(countStr3);
			JLabel lblNewLabel_3_2 = new JLabel("/");
			lblNewLabel_3_2.setForeground(new Color(114, 166, 255));
			lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_3_2.setBounds(718, 20, 17, 52);
			add(lblNewLabel_3_2);
			JLabel lblNewLabel_2 = new JLabel(" 28");
			lblNewLabel_2.setForeground(new Color(114, 166, 255));
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_2.setBounds(738, 22, 53, 48);
			add(lblNewLabel_2);
			JLabel lblNewLabel_4_3 = new JLabel("CAFE   ZONE");
			lblNewLabel_4_3.setForeground(new Color(114, 166, 255));
			lblNewLabel_4_3.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_4_3.setBounds(449, 8, 139, 24);
			add(lblNewLabel_4_3);
			JLabel StudyZone = new JLabel("28");
			StudyZone.setForeground(new Color(255, 128, 128));
			StudyZone.setFont(new Font("굴림", Font.PLAIN, 30));
			StudyZone.setBounds(459, 22, 53, 48);
			add(StudyZone);
			StudyZone.setText(countStr2);
			JLabel lblNewLabel_3_3 = new JLabel("/");
			lblNewLabel_3_3.setForeground(new Color(114, 166, 255));
			lblNewLabel_3_3.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_3_3.setBounds(509, 20, 17, 52);
			add(lblNewLabel_3_3);
			JLabel lblNewLabel_5 = new JLabel(" 28");
			lblNewLabel_5.setForeground(new Color(114, 166, 255));
			lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 30));
			lblNewLabel_5.setBounds(529, 22, 53, 48);
			add(lblNewLabel_5);
	}
}
