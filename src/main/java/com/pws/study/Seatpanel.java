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
	/**
	 * Create the panel.
	 */
	/**
	 * 
	 */
	public Seatpanel(JPanel borderpanel, JButton homebutton) {
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
		panel_1_1.setBounds(0, 375, 357, 188);
		add(panel_1_1);
		panel_1_1.setBorder(border);
		panel_1_1.setBackground(new Color(255,255,255));
		
		  JPanel panel_1_1_1 = new JPanel();
	      panel_1_1_1.setLayout(null);
	      panel_1_1_1.setBackground(Color.WHITE);
	      panel_1_1_1.setBounds(354, 375, 458, 188);
	      add(panel_1_1_1);
	      panel_1_1_1.setBorder(border);
	      
	      RoundedButton s1 = new RoundedButton("1" + "<br>" +"1인석");
			s1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 1","s1",borderpanel,homebutton);
				}
			});
			s1.setFont(new Font("굴림", Font.BOLD, 13));
			s1.setBounds(12, 38, 50, 44);
			panel.add(s1); 
			
			RoundedButton s2 = new RoundedButton("2" + "<br>" +"1인석");
			s2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 2","s2",borderpanel,homebutton);
				}
			});
			s2.setFont(new Font("굴림", Font.BOLD, 13));
			s2.setBounds(12, 89, 50, 44);
			panel.add(s2);
			
			RoundedButton s3 = new RoundedButton("3" + "<br>" +"1인석");
			s3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 3","s3",borderpanel,homebutton);
				}
			});
			s3.setFont(new Font("굴림", Font.BOLD, 13));
			s3.setBounds(12, 140, 50, 44);
			panel.add(s3);
			 
			RoundedButton s4 = new RoundedButton("4" + "<br>" +"1인석");
			s4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 4","s4",borderpanel,homebutton);
				}
			});
			s4.setFont(new Font("굴림", Font.BOLD, 13));
			s4.setBounds(12, 190, 50, 44);
			panel.add(s4);
			 
			RoundedButton s5 = new RoundedButton("5" + "<br>" +"1인석");
			s5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 5","s5",borderpanel,homebutton);
				}
			});
			s5.setFont(new Font("굴림", Font.BOLD, 13));
			s5.setBounds(12, 240, 50, 44);
			panel.add(s5);
			
			RoundedButton s6 = new RoundedButton("6" + "<br>" +"1인석");
			s6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 6","s6",borderpanel,homebutton);
				}
			});
			s6.setFont(new Font("굴림", Font.BOLD, 13));
			s6.setBounds(92, 38, 50, 44);
			panel.add(s6);
			
			RoundedButton s7 = new RoundedButton("7" + "<br>" +"1인석");
			s7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 7","s7",borderpanel,homebutton);
				}
			});
			s7.setFont(new Font("굴림", Font.BOLD, 13));
			s7.setBounds(92, 89, 50, 44);
			panel.add(s7);
			
			RoundedButton s8 = new RoundedButton("8" + "<br>" +"1인석");
			s8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 8","s8",borderpanel,homebutton);
				}
			});
			s8.setFont(new Font("굴림", Font.BOLD, 13));
			s8.setBounds(92, 140, 50, 44);
			panel.add(s8);
			
			RoundedButton s9 = new RoundedButton("9" + "<br>" +"1인석");
			s9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 9","s9",borderpanel,homebutton);
				}
			});
			s9.setFont(new Font("굴림", Font.BOLD, 13));
			s9.setBounds(92, 190, 50, 44);
			panel.add(s9);
			
			RoundedButton s10 = new RoundedButton("10" + "<br>" +"1인석");
			s10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("LAPTOP ZONE , 10","s10",borderpanel,homebutton);
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
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ROOM , 27","s27",borderpanel,homebutton);
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
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 11","s11",borderpanel,homebutton);
				}
			});
			s11.setFont(new Font("굴림", Font.BOLD, 13));
			s11.setBounds(30, 15, 50, 44);
			panel_1.add(s11);
			
			RoundedButton s12 = new RoundedButton("12" + "<br>" +"1인석");
			s12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 12","s12",borderpanel,homebutton);
				}
			});
			s12.setFont(new Font("굴림", Font.BOLD, 13));
			s12.setBounds(90, 15, 50, 44);
			panel_1.add(s12);
			
			RoundedButton s13 = new RoundedButton("13" + "<br>" +"1인석");
			s13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 13","s13",borderpanel,homebutton);
				}
			});
			s13.setFont(new Font("굴림", Font.BOLD, 13));
			s13.setBounds(150, 15, 50, 44);
			panel_1.add(s13);
			
			RoundedButton s14 = new RoundedButton("14" + "<br>" +"1인석");
			s14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 14","s14",borderpanel,homebutton);
				}
			});
			s14.setFont(new Font("굴림", Font.BOLD, 13));
			s14.setBounds(210, 15, 50, 44);
			panel_1.add(s14);
		
			RoundedButton s15 = new RoundedButton("15" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 15","s15",borderpanel,homebutton);
				}
			});
			s15.setFont(new Font("굴림", Font.BOLD, 13));
			s15.setBounds(270, 15, 50, 44);
			panel_1.add(s15);
			
			RoundedButton s16 = new RoundedButton("16" + "<br>" +"1인석");
			s16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 16","s16",borderpanel,homebutton);
				}
			});
			s16.setFont(new Font("굴림", Font.BOLD, 13));
			s16.setBounds(330, 15, 50, 44);
			panel_1.add(s16);
			
			RoundedButton s17 = new RoundedButton("17" + "<br>" +"1인석");
			s17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 17","s17",borderpanel,homebutton);
				}
			});
			s17.setFont(new Font("굴림", Font.BOLD, 13));
			s17.setBounds(390, 15, 50, 44);
			panel_1.add(s17);
			
			RoundedButton s18 = new RoundedButton("18" + "<br>" +"1인석");
			s18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 18","s18",borderpanel,homebutton);
				}
			});
			s18.setFont(new Font("굴림", Font.BOLD, 13));
			s18.setBounds(450, 15, 50, 44);
			panel_1.add(s18);
			
			RoundedButton s19 = new RoundedButton("19" + "<br>" +"1인석");
			s19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 19","s19",borderpanel,homebutton);
				}
			});
			s19.setFont(new Font("굴림", Font.BOLD, 13));
			s19.setBounds(30, 105, 50, 44);
			panel_1.add(s19);
			
			RoundedButton s20 = new RoundedButton("20" + "<br>" +"1인석");
			s20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 20","s20",borderpanel,homebutton);
				}
			});
			s20.setFont(new Font("굴림", Font.BOLD, 13));
			s20.setBounds(90, 105, 50, 44);
			panel_1.add(s20);
			
			RoundedButton s21 = new RoundedButton("21" + "<br>" +"1인석");
			s21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 21","s21",borderpanel,homebutton);
				}
			});
			s21.setFont(new Font("굴림", Font.BOLD, 13));
			s21.setBounds(150, 105, 50, 44);
			panel_1.add(s21);
			
			RoundedButton s22 = new RoundedButton("22" + "<br>" +"1인석");
			s22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 22","s22",borderpanel,homebutton);
				}
			});
			s22.setFont(new Font("굴림", Font.BOLD, 13));
			s22.setBounds(210, 105, 50, 44);
			panel_1.add(s22);
			
			RoundedButton s23 = new RoundedButton("23" + "<br>" +"1인석");
			s23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 23","s23",borderpanel,homebutton);
				}
			});
			s23.setFont(new Font("굴림", Font.BOLD, 13));
			s23.setBounds(270, 105, 50, 44);
			panel_1.add(s23);
			
			RoundedButton s24 = new RoundedButton("24" + "<br>" +"1인석");
			s24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 24","s24",borderpanel,homebutton);
				}
			});
			s24.setFont(new Font("굴림", Font.BOLD, 13));
			s24.setBounds(330, 105, 50, 44);
			panel_1.add(s24);
			
			RoundedButton s25 = new RoundedButton("25" + "<br>" +"1인석");
			s25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 25","s25",borderpanel,homebutton);
				}
			});
			s25.setFont(new Font("굴림", Font.BOLD, 13));
			s25.setBounds(390, 105, 50, 44);
			panel_1.add(s25);
			
			RoundedButton s26 = new RoundedButton("26" + "<br>" +"1인석");
			s26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ZONE , 26","s26",borderpanel,homebutton);
				}
			});
			s26.setFont(new Font("굴림", Font.BOLD, 13));
			s26.setBounds(450, 105, 50, 44);
			panel_1.add(s26);
			
			RoundedButton1 s28 = new RoundedButton1("");
			s28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Seatpanel sa = new Seatpanel(borderpanel,homebutton);
					SeatDeactivation se = new SeatDeactivation("STUDY ROOM , 28","s28",borderpanel,homebutton);
				}
			});
			s28.setText(" 스터디룸 2 <br><br>6~12 인실");
			s28.setFont(new Font("굴림", Font.BOLD, 20));
			s28.setBounds(80, 35, 306, 118);
			panel_1_1_1.add(s28);
			
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
					data.put("id", "STUDY ROOM");
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
					
					Map<String, RoundedButton1> buttonMap1 = new HashMap<>(); //hashMap으로 문자열과 버튼 객체 매칭함
						buttonMap1.put("s27",s27);
						buttonMap1.put("s28", s28);
					
				        Color selectedColor = new Color(114, 166, 255);
				        Color defaultColor = new Color(200, 196, 196);

				        for(int i = 0; i < jArray.length(); i++) {
				            String seatNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.

				            if (seatNumber.equals("s27") || seatNumber.equals("s28")) {
				                RoundedButton1 button1 = buttonMap1.get(seatNumber);
				                if (Info.seat_number.equals(seatNumber)) {
				                    button1.setBackgroundColor(selectedColor);
				                } else {
				                    button1.setBackgroundColor(defaultColor);
				                }
				                button1.setBorderPainted(false);
				            } else {
				                RoundedButton button = buttonMap.get(seatNumber);
				                if (Info.seat_number.equals(seatNumber)) {
				                    button.setBackgroundColor(selectedColor);
				                } else {
				                    button.setBackgroundColor(defaultColor);
				                }
				                button.setBorderPainted(false);
				            }
				        }

				    } else {
				        // ...
				    }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
			JLabel lblNewLabel_4_3 = new JLabel("STUDY ZONE");
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
