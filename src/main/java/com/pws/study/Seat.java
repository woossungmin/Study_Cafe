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
			s11.setBounds(28, 15, 50, 44);
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
			panel_1_1.setBounds(12, 394, 813, 188);
			borderpanel.add(panel_1_1);
			panel_1_1.setBorder(border);
			panel_1_1.setBackground(new Color(255,255,255));
			
			RoundedButton s27 = new RoundedButton("27<br>1인석");
			s27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 27","s27",frame);
				}
			});
			s27.setFont(new Font("굴림", Font.BOLD, 13));
			s27.setBounds(12, 10, 50, 44);
			panel_1_1.add(s27);
			
			RoundedButton s28 = new RoundedButton("28<br>1인석");
			s28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 28","s28",frame);
				}
			});
			s28.setFont(new Font("굴림", Font.BOLD, 13));
			s28.setBounds(68, 10, 50, 44);
			panel_1_1.add(s28);
			
			RoundedButton s29 = new RoundedButton("29<br>1인석");
			s29.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 29","s29",frame);
				}
			});
			s29.setFont(new Font("굴림", Font.BOLD, 13));
			s29.setBounds(152, 10, 50, 44);
			panel_1_1.add(s29);
			
			RoundedButton s30 = new RoundedButton("30<br>1인석");
			s30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 30","s30",frame);
				}
			});
			s30.setFont(new Font("굴림", Font.BOLD, 13));
			s30.setBounds(208, 10, 50, 44);
			panel_1_1.add(s30);
			
			RoundedButton s31 = new RoundedButton("31<br>1인석");
			s31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 31","s31",frame);
				}
			});
			s31.setFont(new Font("굴림", Font.BOLD, 13));
			s31.setBounds(264, 10, 50, 44);
			panel_1_1.add(s31);
			
			RoundedButton s32 = new RoundedButton("32<br>1인석");
			s32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 32","s32",frame);
				}
			});
			s32.setFont(new Font("굴림", Font.BOLD, 13));
			s32.setBounds(348, 10, 50, 44);
			panel_1_1.add(s32);
			
			RoundedButton s33 = new RoundedButton("33<br>1인석");
			s33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 33","s33",frame);
				}
			});
			s33.setFont(new Font("굴림", Font.BOLD, 13));
			s33.setBounds(404, 10, 50, 44);
			panel_1_1.add(s33);
			
			RoundedButton s34 = new RoundedButton("34<br>1인석");
			s34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 34","s34",frame);
				}
			});
			s34.setFont(new Font("굴림", Font.BOLD, 13));
			s34.setBounds(488, 10, 50, 44);
			panel_1_1.add(s34);
			
			RoundedButton s35 = new RoundedButton("35<br>1인석");
			s35.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 35","s35",frame);
				}
			});
			s35.setFont(new Font("굴림", Font.BOLD, 13));
			s35.setBounds(544, 10, 50, 44);
			panel_1_1.add(s35);
			
			RoundedButton s36 = new RoundedButton("36<br>1인석");
			s36.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 36","s36",frame);
				}
			});
			s36.setFont(new Font("굴림", Font.BOLD, 13));
			s36.setBounds(628, 10, 50, 44);
			panel_1_1.add(s36);
			
			RoundedButton s37 = new RoundedButton("37<br>1인석");
			s37.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 37","s37",frame);
				}
			});
			s37.setFont(new Font("굴림", Font.BOLD, 13));
			s37.setBounds(684, 10, 50, 44);
			panel_1_1.add(s37);
			
			RoundedButton s38 = new RoundedButton("38<br>1인석");
			s38.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 38","s38",frame);
				}
			});
			s38.setFont(new Font("굴림", Font.BOLD, 13));
			s38.setBounds(740, 10, 50, 44);
			panel_1_1.add(s38);
			
			RoundedButton s39 = new RoundedButton("39<br>1인석");
			s39.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 39","s39",frame);
				}
			});
			s39.setFont(new Font("굴림", Font.BOLD, 13));
			s39.setBounds(12, 77, 50, 44);
			panel_1_1.add(s39);
			
			RoundedButton s40 = new RoundedButton("40<br>1인석");
			s40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 40","s40",frame);
				}
			});
			s40.setFont(new Font("굴림", Font.BOLD, 13));
			s40.setBounds(68, 77, 50, 44);
			panel_1_1.add(s40);
			
			RoundedButton s41 = new RoundedButton("41<br>1인석");
			s41.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 41","s41",frame);
				}
			});
			s41.setFont(new Font("굴림", Font.BOLD, 13));
			s41.setBounds(12, 131, 50, 44);
			panel_1_1.add(s41);
			
			RoundedButton s42 = new RoundedButton("42<br>1인석");
			s42.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 42","s42",frame);
				}
			});
			s42.setFont(new Font("굴림", Font.BOLD, 13));
			s42.setBounds(68, 131, 50, 44);
			panel_1_1.add(s42);
			
			RoundedButton s43 = new RoundedButton("43<br>1인석");
			s43.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 43","s43",frame);
				}
			});
			s43.setFont(new Font("굴림", Font.BOLD, 13));
			s43.setBounds(152, 77, 50, 44);
			panel_1_1.add(s43);
			
			RoundedButton s44 = new RoundedButton("44<br>1인석");
			s44.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 44","s44",frame);
				}
			});
			s44.setFont(new Font("굴림", Font.BOLD, 13));
			s44.setBounds(208, 77, 50, 44);
			panel_1_1.add(s44);
			
			RoundedButton s45 = new RoundedButton("45<br>1인석");
			s45.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 45","s45",frame);
				}
			});
			s45.setFont(new Font("굴림", Font.BOLD, 13));
			s45.setBounds(264, 77, 50, 44);
			panel_1_1.add(s45);
			
			RoundedButton s46 = new RoundedButton("46<br>1인석");
			s46.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 46","s46",frame);
				}
			});
			s46.setFont(new Font("굴림", Font.BOLD, 13));
			s46.setBounds(152, 131, 50, 44);
			panel_1_1.add(s46);
			
			RoundedButton s47 = new RoundedButton("47<br>1인석");
			s47.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 47","s47",frame);
				}
			});
			s47.setFont(new Font("굴림", Font.BOLD, 13));
			s47.setBounds(208, 131, 50, 44);
			panel_1_1.add(s47);
			
			RoundedButton s48 = new RoundedButton("48<br>1인석");
			s48.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 48","s48",frame);
				}
			});
			s48.setFont(new Font("굴림", Font.BOLD, 13));
			s48.setBounds(264, 131, 50, 44);
			panel_1_1.add(s48);
			
			RoundedButton s49 = new RoundedButton("49<br>1인석");
			s49.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 49","s49",frame);
				}
			});
			s49.setFont(new Font("굴림", Font.BOLD, 13));
			s49.setBounds(572, 77, 50, 44);
			panel_1_1.add(s49);
			
			RoundedButton s50 = new RoundedButton("50<br>1인석");
			s50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 50","s50",frame);
				}
			});
			s50.setFont(new Font("굴림", Font.BOLD, 13));
			s50.setBounds(628, 77, 50, 44);
			panel_1_1.add(s50);
			
			RoundedButton s51 = new RoundedButton("51<br>1인석");
			s51.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 51","s51",frame);
				}
			});
			s51.setFont(new Font("굴림", Font.BOLD, 13));
			s51.setBounds(684, 77, 50, 44);
			panel_1_1.add(s51);
			
			RoundedButton s52 = new RoundedButton("52<br>1인석");
			s52.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 52","s52",frame);
				}
			});
			s52.setFont(new Font("굴림", Font.BOLD, 13));
			s52.setBounds(740, 77, 50, 44);
			panel_1_1.add(s52);
			
			RoundedButton s53 = new RoundedButton("53<br>1인석");
			s53.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 53","s53",frame);
				}
			});
			s53.setFont(new Font("굴림", Font.BOLD, 13));
			s53.setBounds(572, 131, 50, 44);
			panel_1_1.add(s53);
			
			RoundedButton s54 = new RoundedButton("54<br>1인석");
			s54.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 54","s54",frame);
				}
			});
			s54.setFont(new Font("굴림", Font.BOLD, 13));
			s54.setBounds(628, 131, 50, 44);
			panel_1_1.add(s54);
			
			RoundedButton s55 = new RoundedButton("55<br>1인석");
			s55.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 55","s55",frame);
				}
			});
			s55.setFont(new Font("굴림", Font.BOLD, 13));
			s55.setBounds(684, 131, 50, 44);
			panel_1_1.add(s55);
			
			RoundedButton s56 = new RoundedButton("56<br>1인석");
			s56.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeatCheck se = new SeatCheck("CAFE ZONE , 56","s56",frame);
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
					
			        Color selectedColor = new Color(114, 166, 255);
			        Color defaultColor = new Color(200, 196, 196);

			        for(int i = 0; i < jArray.length(); i++) {
			            String seatNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.

			                RoundedButton button = buttonMap.get(seatNumber);
			                if (Info.seat_number.equals(seatNumber)) {
			                    button.setBackgroundColor(selectedColor);
			                } else {
			                    button.setBackgroundColor(defaultColor);
			                }
			                button.setBorderPainted(false);
			                button.setEnabled(false);
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
			panel_2.setBounds(0, 0, 64, 64);
			panel_1_2.add(panel_2);
			panel_2.setBackground(new Color(255,255,255));
			panel_2.setBorder(border);
			panel_2.setLayout(null);
			
			JLabel label18 = new JLabel("");
			label18.setBounds(5, 4, 54, 54);
			panel_2.add(label18);
			label18.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\espresso.png"));
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setLayout(null);
			panel_2_1.setBackground(Color.WHITE);
			panel_2_1.setBounds(447, 64, 71, 71);
			panel_1_2.add(panel_2_1);
			panel_2_1.setBorder(border);
			panel_2_1.setBackground(new Color(255,255,255));
			
			JLabel label4 = new JLabel("CAFE ZONE");
			label4.setBounds(404, 110, 101, 29);
			panel_1_1.add(label4);
			label4.setFont(new Font("굴림", Font.BOLD, 13));
			label4.setForeground(new Color(0,0,255));
			
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
				  s29.setEnabled(false);
				  s30.setEnabled(false);
				  s31.setEnabled(false);
				  s32.setEnabled(false);
				  s33.setEnabled(false);
				  s34.setEnabled(false);
				  s35.setEnabled(false);
				  s36.setEnabled(false);
				  s37.setEnabled(false);
				  s38.setEnabled(false);
				  s39.setEnabled(false);
				  s40.setEnabled(false);
				  s41.setEnabled(false);
				  s42.setEnabled(false);
				  s43.setEnabled(false);
				  s44.setEnabled(false);
				  s45.setEnabled(false);
				  s46.setEnabled(false);
				  s47.setEnabled(false);
				  s48.setEnabled(false);
				  s49.setEnabled(false);
				  s50.setEnabled(false);
				  s51.setEnabled(false);
				  s52.setEnabled(false);
				  s53.setEnabled(false);
				  s54.setEnabled(false);
				  s55.setEnabled(false);
				  s56.setEnabled(false);
			  }	   
			  
	}
}
