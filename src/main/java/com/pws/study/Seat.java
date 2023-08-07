package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;

public class Seat {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat window = new Seat();
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
	public Seat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		  frame = new JFrame();
	      frame.setBounds(210, 20, 870, 650);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      frame.setResizable(false);
	      frame.setVisible(true);
	 
	      Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
	      Border border1 =  BorderFactory.createLineBorder(new Color(0,0,0),1);
	      
	      JPanel panel_4 = new JPanel();
	      panel_4.setBounds(0, 0, 856, 613);
	      frame.getContentPane().add(panel_4);
	      panel_4.setLayout(null);
	      panel_4.setBackground(new Color(255,255,255));
	      
	      JPanel borderpanel = new JPanel();
	      borderpanel.setBounds(10, 10, 839, 593);
	      panel_4.add(borderpanel);
	      borderpanel.setLayout(null);
	      borderpanel.setBackground(new Color(255,255,255));
	      borderpanel.setBorder(border);
	      
	      JPanel panel_1_1_1 = new JPanel();
	      panel_1_1_1.setLayout(null);
	      panel_1_1_1.setBackground(Color.WHITE);
	      panel_1_1_1.setBounds(367, 394, 458, 188);
	      borderpanel.add(panel_1_1_1);
	      panel_1_1_1.setBorder(border);
	      
	      ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop");
	      JLabel label = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\clock.png"));
	      label.setBounds(265,10,43,43);
	      borderpanel.add(label);
	      
	      JLabel projectname = new JLabel("포텐스터디카페");
	      projectname.setFont(new Font("굴림", Font.BOLD, 35));
	      projectname.setForeground(new Color(114, 166, 255));
	      projectname.setBounds(313, 10, 338, 53);
	      borderpanel.add(projectname);
	      
	      JLabel projectname2 = new JLabel("POTEN STUDY CAFE");
	      projectname2.setForeground(new Color(114, 166, 255));
	      projectname2.setFont(new Font("굴림", Font.BOLD, 30));
	      projectname2.setBounds(265, 54, 398, 37);
	      borderpanel.add(projectname2);
	      
	      JButton BackButton = new JButton("");
			BackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					Login lo = new Login();
				}
			});
			BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
			BackButton.setBounds(0, 0, 45, 40);
			borderpanel.add(BackButton);
			BackButton.setBorderPainted(false); 
			BackButton.setContentAreaFilled(false);
			BackButton.setFocusPainted(false);
			
		    JPanel panel = new JPanel();;
			panel.setBounds(12, 101, 153, 295);
			borderpanel.add(panel);
			panel.setLayout(null);
			panel.setBorder(border);
			panel.setBackground(new Color(255,255,255));
			
			RoundedButton s1 = new RoundedButton("1" + "<br>" +"1인석");
			s1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 1","s1",frame);
				}
			});
			s1.setFont(new Font("굴림", Font.BOLD, 13));
			s1.setBounds(12, 38, 50, 44);
			panel.add(s1); 
			
			RoundedButton s2 = new RoundedButton("2" + "<br>" +"1인석");
			s2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 2","s2",frame);
				}
			});
			s2.setFont(new Font("굴림", Font.BOLD, 13));
			s2.setBounds(12, 89, 50, 44);
			panel.add(s2);
			
			RoundedButton s3 = new RoundedButton("3" + "<br>" +"1인석");
			s3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 3","s3",frame);
				}
			});
			s3.setFont(new Font("굴림", Font.BOLD, 13));
			s3.setBounds(12, 140, 50, 44);
			panel.add(s3);
			 
			RoundedButton s4 = new RoundedButton("4" + "<br>" +"1인석");
			s4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 4","s4",frame);
				}
			});
			s4.setFont(new Font("굴림", Font.BOLD, 13));
			s4.setBounds(12, 190, 50, 44);
			panel.add(s4);
			 
			RoundedButton s5 = new RoundedButton("5" + "<br>" +"1인석");
			s5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 5","s5",frame);
				}
			});
			s5.setFont(new Font("굴림", Font.BOLD, 13));
			s5.setBounds(12, 240, 50, 44);
			panel.add(s5);
			
			RoundedButton s6 = new RoundedButton("6" + "<br>" +"1인석");
			s6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 6","s6",frame);
				}
			});
			s6.setFont(new Font("굴림", Font.BOLD, 13));
			s6.setBounds(92, 38, 50, 44);
			panel.add(s6);
			
			RoundedButton s7 = new RoundedButton("7" + "<br>" +"1인석");
			s7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 7","s7",frame);
				}
			});
			s7.setFont(new Font("굴림", Font.BOLD, 13));
			s7.setBounds(92, 89, 50, 44);
			panel.add(s7);
			
			RoundedButton s8 = new RoundedButton("8" + "<br>" +"1인석");
			s8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 8","s8",frame);
				}
			});
			s8.setFont(new Font("굴림", Font.BOLD, 13));
			s8.setBounds(92, 140, 50, 44);
			panel.add(s8);
			
			RoundedButton s9 = new RoundedButton("9" + "<br>" +"1인석");
			s9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 9","s9",frame);
				}
			});
			s9.setFont(new Font("굴림", Font.BOLD, 13));
			s9.setBounds(92, 190, 50, 44);
			panel.add(s9);
			
			RoundedButton s10 = new RoundedButton("10" + "<br>" +"1인석");
			s10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("LAPTOP ZONE , 10","s10",frame);
				}
			});
			s10.setFont(new Font("굴림", Font.BOLD, 13));
			s10.setBounds(92, 240, 50, 44);
			panel.add(s10);
			
			JLabel label4 = new JLabel("Study Room");
			label4.setBounds(126, 303, 101, 29);
			panel.add(label4);
			label4.setFont(new Font("굴림", Font.BOLD, 13));
			
			JLabel label1 = new JLabel("LAPTOP ZONE");
			label1.setForeground(new Color(0, 0, 255));
			label1.setBounds(28, 8, 101, 25);
			panel.add(label1);
			label1.setFont(new Font("굴림", Font.BOLD, 13));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(163, 234, 518, 162);
			borderpanel.add(panel_1);
			panel_1.setBorder(border);
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(255,255,255));
			
			JLabel label2 = new JLabel("STUDY ZONE");
			label2.setForeground(new Color(0, 0, 255));
			label2.setFont(new Font("굴림", Font.BOLD, 13));
			label2.setBounds(215, 69, 90, 24);
			panel_1.add(label2);
			
			RoundedButton s11 = new RoundedButton("11" + "<br>" +"1인석");
			s11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 11","s11",frame);
				}
			});
			s11.setFont(new Font("굴림", Font.BOLD, 13));
			s11.setBounds(30, 15, 50, 44);
			panel_1.add(s11);
			
			RoundedButton s12 = new RoundedButton("12" + "<br>" +"1인석");
			s12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 12","s12",frame);
				}
			});
			s12.setFont(new Font("굴림", Font.BOLD, 13));
			s12.setBounds(90, 15, 50, 44);
			panel_1.add(s12);
			
			RoundedButton s13 = new RoundedButton("13" + "<br>" +"1인석");
			s13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 13","s13",frame);
				}
			});
			s13.setFont(new Font("굴림", Font.BOLD, 13));
			s13.setBounds(150, 15, 50, 44);
			panel_1.add(s13);
			
			RoundedButton s14 = new RoundedButton("14" + "<br>" +"1인석");
			s14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 14","s14",frame);
				}
			});
			s14.setFont(new Font("굴림", Font.BOLD, 13));
			s14.setBounds(210, 15, 50, 44);
			panel_1.add(s14);
		
			RoundedButton s15 = new RoundedButton("15" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 15","s15",frame);
				}
			});
			s15.setFont(new Font("굴림", Font.BOLD, 13));
			s15.setBounds(270, 15, 50, 44);
			panel_1.add(s15);
			
			RoundedButton s16 = new RoundedButton("16" + "<br>" +"1인석");
			s16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 16","s16",frame);
				}
			});
			s16.setFont(new Font("굴림", Font.BOLD, 13));
			s16.setBounds(330, 15, 50, 44);
			panel_1.add(s16);
			
			RoundedButton s17 = new RoundedButton("17" + "<br>" +"1인석");
			s17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 17","s17",frame);
				}
			});
			s17.setFont(new Font("굴림", Font.BOLD, 13));
			s17.setBounds(390, 15, 50, 44);
			panel_1.add(s17);
			
			RoundedButton s18 = new RoundedButton("18" + "<br>" +"1인석");
			s18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 18","s18",frame);
				}
			});
			s18.setFont(new Font("굴림", Font.BOLD, 13));
			s18.setBounds(450, 15, 50, 44);
			panel_1.add(s18);
			
			RoundedButton s19 = new RoundedButton("19" + "<br>" +"1인석");
			s19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 19","s19",frame);
				}
			});
			s19.setFont(new Font("굴림", Font.BOLD, 13));
			s19.setBounds(30, 105, 50, 44);
			panel_1.add(s19);
			
			RoundedButton s20 = new RoundedButton("20" + "<br>" +"1인석");
			s20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 20","s20",frame);
				}
			});
			s20.setFont(new Font("굴림", Font.BOLD, 13));
			s20.setBounds(90, 105, 50, 44);
			panel_1.add(s20);
			
			RoundedButton s21 = new RoundedButton("21" + "<br>" +"1인석");
			s21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 21","s21",frame);
				}
			});
			s21.setFont(new Font("굴림", Font.BOLD, 13));
			s21.setBounds(150, 105, 50, 44);
			panel_1.add(s21);
			
			RoundedButton s22 = new RoundedButton("22" + "<br>" +"1인석");
			s22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 22","s22",frame);
				}
			});
			s22.setFont(new Font("굴림", Font.BOLD, 13));
			s22.setBounds(210, 105, 50, 44);
			panel_1.add(s22);
			
			RoundedButton s23 = new RoundedButton("23" + "<br>" +"1인석");
			s23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 23","s23",frame);
				}
			});
			s23.setFont(new Font("굴림", Font.BOLD, 13));
			s23.setBounds(270, 105, 50, 44);
			panel_1.add(s23);
			
			RoundedButton s24 = new RoundedButton("24" + "<br>" +"1인석");
			s24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 24","s24",frame);
				}
			});
			s24.setFont(new Font("굴림", Font.BOLD, 13));
			s24.setBounds(330, 105, 50, 44);
			panel_1.add(s24);
			
			RoundedButton s25 = new RoundedButton("25" + "<br>" +"1인석");
			s15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 25","s25",frame);
				}
			});
			s25.setFont(new Font("굴림", Font.BOLD, 13));
			s25.setBounds(390, 105, 50, 44);
			panel_1.add(s25);
			
			RoundedButton s26 = new RoundedButton("26" + "<br>" +"1인석");
			s26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 26","s26",frame);
				}
			});
			s26.setFont(new Font("굴림", Font.BOLD, 13));
			s26.setBounds(450, 105, 50, 44);
			panel_1.add(s26);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setLayout(null);
			panel_1_1.setBounds(12, 394, 357, 188);
			borderpanel.add(panel_1_1);
			panel_1_1.setBorder(border);
			panel_1_1.setBackground(new Color(255,255,255));
			
			RoundedButton1 s27 = new RoundedButton1(""); 
			s27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 27","s27",frame);
				}
			});
			s27.setText(" 스터디룸 1 <br><br>4~8 인실");
			s27.setFont(new Font("굴림", Font.BOLD, 20));
			s27.setBounds(56, 35, 248, 118);
			panel_1_1.add(s27);
			
			RoundedButton1 s28 = new RoundedButton1("");
			s28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("STUDY ZONE , 28","s28",frame);
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
				                button1.setEnabled(false);
				            } else {
				                RoundedButton button = buttonMap.get(seatNumber);
				                if (Info.seat_number.equals(seatNumber)) {
				                    button.setBackgroundColor(selectedColor);
				                } else {
				                    button.setBackgroundColor(defaultColor);
				                }
				                button.setBorderPainted(false);
				                button.setEnabled(false);
				            }
				        }

				    } else {
				        // ...
				    }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JPanel panel_1_2_1 = new JPanel();
			panel_1_2_1.setLayout(null);
			panel_1_2_1.setBackground(Color.WHITE);
			panel_1_2_1.setBounds(680, 101, 145, 295);
			borderpanel.add(panel_1_2_1);
			panel_1_2_1.setBackground(new Color(255,255,255));
			panel_1_2_1.setBorder(border);
			
			JLabel label5 = new JLabel("Laptop Zone");
			label5.setFont(new Font("굴림", Font.BOLD, 15));
			label5.setBounds(240, 256, 101, 29);
			panel_1_2_1.add(label5);
			
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
			
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setLayout(null);
			panel_1_2.setBackground(Color.WHITE);
			panel_1_2.setBounds(163, 101, 518, 135);
			borderpanel.add(panel_1_2);
			panel_1_2.setBorder(border);
			
			JLabel label15 = new JLabel("로비 & 휴게실");
			label15.setForeground(new Color(0, 0, 255));
			label15.setFont(new Font("굴림", Font.BOLD, 13));
			label15.setBounds(215, 96, 101, 29);
			panel_1_2.add(label15);
			
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
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setLayout(null);
			panel_2_1.setBackground(Color.WHITE);
			panel_2_1.setBounds(447, 64, 71, 71);
			panel_1_2.add(panel_2_1);
			panel_2_1.setBorder(border);
			panel_2_1.setBackground(new Color(255,255,255));
			
			JLabel label20 = new JLabel("");
			label20.setBounds(16, 5, 40, 19);
			panel_2_1.add(label20);
			
			JLabel label21 = new JLabel("");
			label21.setBounds(5, 5, 62, 62);
			panel_2_1.add(label21);
			label21.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\toilet.png"));
			
			JLabel label18_1 = new JLabel("");
			label18_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\meeting-room.png"));
			label18_1.setBounds(85, 29, 128, 64);
			panel_1_2.add(label18_1);
			
			JLabel label18_1_1 = new JLabel("");
			label18_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\meeting-room.png"));
			label18_1_1.setBounds(302, 29, 128, 64);
			panel_1_2.add(label18_1_1);
			
			
			 JButton question = new JButton("");
			 question.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Explanation ex = new Explanation();
			 	}
			 });
		      question.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\question (1).png"));
		      
			question.setBounds(785, 15, 40, 40);
			borderpanel.add(question);
			question.setBorderPainted(false);
			question.setContentAreaFilled(false);
			question.setFocusPainted(false);
			  if(!Info.seat_number.equals("NULL"))
			  {
				  s1.setEnabled(false);
				  s2.setEnabled(false);
				  s3.setEnabled(false);
				  s4.setEnabled(false);
				  s5.setEnabled(false);
				  s6.setEnabled(false);
				  s7.setEnabled(false);
				  s8.setEnabled(false);
				  s9.setEnabled(false);
				  s10.setEnabled(false);
				  s11.setEnabled(false);
				  s12.setEnabled(false);
				  s13.setEnabled(false);
				  s14.setEnabled(false);
				  s15.setEnabled(false);
				  s16.setEnabled(false);
				  s17.setEnabled(false);
				  s18.setEnabled(false);
				  s19.setEnabled(false);
				  s20.setEnabled(false);
				  s21.setEnabled(false);
				  s22.setEnabled(false);
				  s23.setEnabled(false);
				  s24.setEnabled(false);
				  s25.setEnabled(false);
				  s26.setEnabled(false);
				  s27.setEnabled(false);
				  s28.setEnabled(false);
			  }	   
			  
	}
	
}
