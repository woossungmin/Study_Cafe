package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Lockerpanel extends JPanel {
	String Lockcount = "";
	public Lockerpanel(JPanel borderpanel, JButton homebutton, JButton closebutton) {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(20, 40, 816, 580);
		
		JPanel borderpanel2 = new JPanel();
		borderpanel2.setBounds(28, 110, 766, 448);
		add(borderpanel2);
		borderpanel2.setBorder(border);
		borderpanel2.setBackground(new Color(255,255,255));
		borderpanel2.setLayout(null);
		
		RoundedButton3 l1 = new RoundedButton3("사물함" + "<br>" +"1번");
		l1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l1.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 1 ", "l1");
			        }
				 else if(l1.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 1","l1",borderpanel,homebutton,closebutton);
				 }
				 else if(l1.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 1","l1",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l1.setFont(new Font("굴림", Font.BOLD, 15));
		l1.setBounds(40, 43, 129, 87);
		borderpanel2.add(l1);
		
		RoundedButton3 l2 = new RoundedButton3("사물함" + "<br>" +"2번");
		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l2.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 2 ", "l2");
			        }
				 else if(l2.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 2","l2",borderpanel,homebutton,closebutton);
				 }
				 else if(l2.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 2","l2",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l2.setFont(new Font("굴림", Font.BOLD, 15));
		l2.setBounds(181, 43, 129, 87);
		borderpanel2.add(l2);
		
		RoundedButton3 l3 = new RoundedButton3("사물함" + "<br>" +"3번");
		l3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l3.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 3 ", "l1");
			        }
				 else if(l3.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 3","l1",borderpanel,homebutton,closebutton);
				 }
				 else if(l3.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 3","l3",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l3.setFont(new Font("굴림", Font.BOLD, 15));
		l3.setBounds(322, 43, 129, 87);
		borderpanel2.add(l3);
		
		RoundedButton3 l4 = new RoundedButton3("사물함" + "<br>" +"4번");
		l4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l4.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 4 ", "l4");
			        }
				 else if(l4.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 4","l4",borderpanel,homebutton,closebutton);
				 }
				 else if(l4.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 4","l4",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l4.setFont(new Font("굴림", Font.BOLD, 15));
		l4.setBounds(463, 43, 129, 87);
		borderpanel2.add(l4);
		
		RoundedButton3 l5 = new RoundedButton3("사물함" + "<br>" +"5번");
		l5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l5.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 5 ", "l5");
			        }
				 else if(l5.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 5","l5",borderpanel,homebutton,closebutton);
				 }
				 else if(l5.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 5","l5",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l5.setFont(new Font("굴림", Font.BOLD, 15));
		l5.setBounds(604, 43, 129, 87);
		borderpanel2.add(l5);
		
		RoundedButton3 l6 = new RoundedButton3("사물함" + "<br>" +"6번");
		l6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l6.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 6 ", "l6");
			        }
				 else if(l6.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 6","l6",borderpanel,homebutton,closebutton);
				 }
				 else if(l6.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 6","l6",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l6.setFont(new Font("굴림", Font.BOLD, 15));
		l6.setBounds(40, 140, 129, 87);
		borderpanel2.add(l6);
		
		RoundedButton3 l7 = new RoundedButton3("사물함" + "<br>" +"7번");
		l7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l7.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 7 ", "l7");
			        }
				 else if(l7.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 7","l7",borderpanel,homebutton,closebutton);
				 }
				 else if(l7.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 7","l7",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l7.setFont(new Font("굴림", Font.BOLD, 15));
		l7.setBounds(181, 140, 129, 87);
		borderpanel2.add(l7);
		
		RoundedButton3 l8 = new RoundedButton3("사물함" + "<br>" +"8번");
		l8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l8.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 8 ", "l8");
			        }
				 else if(l8.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 8","l1",borderpanel,homebutton,closebutton);
				 }
				 else if(l8.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 8","l8",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l8.setFont(new Font("굴림", Font.BOLD, 15));
		l8.setBounds(322, 140, 129, 87);
		borderpanel2.add(l8);
		
		RoundedButton3 l9 = new RoundedButton3("사물함" + "<br>" +"9번");
		l9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l9.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 9 ", "l9");
			        }
				 else if(l9.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 9","l9",borderpanel,homebutton,closebutton);
				 }
				 else if(l9.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 9","l9",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l9.setFont(new Font("굴림", Font.BOLD, 15));
		l9.setBounds(463, 140, 129, 87);
		borderpanel2.add(l9);
		
		RoundedButton3 l10 = new RoundedButton3("사물함" + "<br>" +"10번");
		l10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l10.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 10 ", "l10");
			        }
				 else if(l10.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 10","l10",borderpanel,homebutton,closebutton);
				 }
				 else if(l10.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 10","l10",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l10.setFont(new Font("굴림", Font.BOLD, 15));
		l10.setBounds(604, 140, 129, 87);
		borderpanel2.add(l10);
		
		RoundedButton3 l11 = new RoundedButton3("사물함" + "<br>" +"11번");
		l11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l11.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 11 ", "l11");
			        }
				 else if(l11.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 11","l11",borderpanel,homebutton,closebutton);
				 }
				 else if(l11.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 11","l11",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l11.setFont(new Font("굴림", Font.BOLD, 15));
		l11.setBounds(40, 237, 129, 87);
		borderpanel2.add(l11);
		
		RoundedButton3 l12 = new RoundedButton3("사물함" + "<br>" +"12번");
		l12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l12.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 12 ", "l12");
			        }
				 else if(l12.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 12","l12",borderpanel,homebutton,closebutton);
				 }
				 else if(l12.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 12","l12",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l12.setFont(new Font("굴림", Font.BOLD, 15));
		l12.setBounds(181, 237, 129, 87);
		borderpanel2.add(l12);
		
		RoundedButton3 l13 = new RoundedButton3("사물함" + "<br>" +"13번");
		l13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l13.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 13 ", "l13");
			        }
				 else if(l13.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 13","l13",borderpanel,homebutton,closebutton);
				 }
				 else if(l13.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 13","l13",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l13.setFont(new Font("굴림", Font.BOLD, 15));
		l13.setBounds(322, 237, 129, 87);
		borderpanel2.add(l13);
		
		RoundedButton3 l14 = new RoundedButton3("사물함" + "<br>" +"14번");
		l14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l14.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 14 ", "l14");
			        }
				 else if(l14.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 14","l14",borderpanel,homebutton,closebutton);
				 }
				 else if(l14.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 14","l14",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l14.setFont(new Font("굴림", Font.BOLD, 15));
		l14.setBounds(463, 237, 129, 87);
		borderpanel2.add(l14);
		
		RoundedButton3 l15 = new RoundedButton3("사물함" + "<br>" +"15번");
		l15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l15.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 15 ", "l15");
			        }
				 else if(l15.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 15","l15",borderpanel,homebutton,closebutton);
				 }
				 else if(l15.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 15","l15",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l15.setFont(new Font("굴림", Font.BOLD, 15));
		l15.setBounds(604, 237, 129, 87);
		borderpanel2.add(l15);
		
		RoundedButton3 l16 = new RoundedButton3("사물함" + "<br>" +"16번");
		l16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l16.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 16 ", "l16");
			        }
				 else if(l16.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 16","l16",borderpanel,homebutton,closebutton);
				 }
				 else if(l16.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 16","l16",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l16.setFont(new Font("굴림", Font.BOLD, 15));
		l16.setBounds(40, 334, 129, 87);
		borderpanel2.add(l16);
		
		RoundedButton3 l17 = new RoundedButton3("사물함" + "<br>" +"17번");
		l17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l17.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 17 ", "l17");
			        }
				 else if(l17.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 17","l17",borderpanel,homebutton,closebutton);
				 }
				 else if(l17.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 17","l17",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l17.setFont(new Font("굴림", Font.BOLD, 15));
		l17.setBounds(181, 334, 129, 87);
		borderpanel2.add(l17);
		
		RoundedButton3 l18 = new RoundedButton3("사물함" + "<br>" +"18번");
		l18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l18.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 18 ", "l18");
			        }
				 else if(l18.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 18","l18",borderpanel,homebutton,closebutton);
				 }
				 else if(l18.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 18","l19",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l18.setFont(new Font("굴림", Font.BOLD, 15));
		l18.setBounds(322, 334, 129, 87);
		borderpanel2.add(l18);
		
		RoundedButton3 l19 = new RoundedButton3("사물함" + "<br>" +"19번");
		l19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l19.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 19 ", "l19");
			        }
				 else if(l19.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 19","l19",borderpanel,homebutton,closebutton);
				 }
				 else if(l19.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 19","l19",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l19.setFont(new Font("굴림", Font.BOLD, 15));
		l19.setBounds(463, 334, 129, 87);
		borderpanel2.add(l19);
		
		RoundedButton3 l20 = new RoundedButton3("사물함" + "<br>" +"20번");
		l20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (l20.isBackgroundColorEqual(new Color(200, 196, 196))) {
					  LockInformation lo = new LockInformation("사물함 20 ", "l20");
			        }
				 else if(l20.isBackgroundColorEqual(new Color(114, 166, 255))){
					  LockDeactivation de = new LockDeactivation("사물함 20","l20",borderpanel,homebutton,closebutton);
				 }
				 else if(l20.isBackgroundColorEqual(new Color(255, 128, 128))){
					 Lockactivation de = new Lockactivation("사물함 20","l20",borderpanel,homebutton,closebutton);
				 }
			}
		});
		l20.setFont(new Font("굴림", Font.BOLD, 15));
		l20.setBounds(604, 334, 129, 87);
		borderpanel2.add(l20);
		JSONObject data = new JSONObject();
		try {
			String activations = "0";
			data.put("activations", activations);
			Post po = new Post();
			
			JSONObject check = po.jsonpost("/FindLockNumber", data);
			if((check.get("check")).equals("true"))
			{
				JSONArray jArray = new JSONArray();
				jArray = (JSONArray) check.get("lock_numbers");
				
				Map<String, RoundedButton3> buttonMap = new HashMap<>(); //hashMap으로 문자열과 버튼 객체 매칭함
				buttonMap.put("l1",l1);
				buttonMap.put("l2",l2);
				buttonMap.put("l3",l3);
				buttonMap.put("l4",l4);
				buttonMap.put("l5",l5);
				buttonMap.put("l6",l6);
				buttonMap.put("l7",l7);
				buttonMap.put("l8",l8);
				buttonMap.put("l9",l9);
				buttonMap.put("l10",l10);
				buttonMap.put("l11",l11);
				buttonMap.put("l12",l12);
				buttonMap.put("l13",l13);
				buttonMap.put("l14",l14);
				buttonMap.put("l15",l15);
				buttonMap.put("l16",l16);
				buttonMap.put("l17",l17);
				buttonMap.put("l18",l18);
				buttonMap.put("l19",l19);
				buttonMap.put("l20",l20);
				
			        for(int i = 0; i < jArray.length(); i++) {
			            String lockNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.
			                RoundedButton3 button = buttonMap.get(lockNumber);
			                if (Info.lock_number.equals(lockNumber)) {
			                    button.setBackgroundColor(new Color(114,166,255));
			                    button.repaint();
			                } else {
			                    button.setBackgroundColor(new Color(200,196,196));
			                    button.repaint();
			                }
			                button.setBorderPainted(false);
			        }
			    } else {
			        // ...
			    }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			String activations = "2";
			data.put("activations", activations);
			Post po = new Post();
			
			JSONObject check = po.jsonpost("/FindLockNumber", data);
			if((check.get("check")).equals("true"))
			{
				JSONArray jArray = new JSONArray();
				jArray = (JSONArray) check.get("lock_numbers");
				
				Map<String, RoundedButton3> buttonMap = new HashMap<>(); //hashMap으로 문자열과 버튼 객체 매칭함
				buttonMap.put("l1",l1);
				buttonMap.put("l2",l2);
				buttonMap.put("l3",l3);
				buttonMap.put("l4",l4);
				buttonMap.put("l5",l5);
				buttonMap.put("l6",l6);
				buttonMap.put("l7",l7);
				buttonMap.put("l8",l8);
				buttonMap.put("l9",l9);
				buttonMap.put("l10",l10);
				buttonMap.put("l11",l11);
				buttonMap.put("l12",l12);
				buttonMap.put("l13",l13);
				buttonMap.put("l14",l14);
				buttonMap.put("l15",l15);
				buttonMap.put("l16",l16);
				buttonMap.put("l17",l17);
				buttonMap.put("l18",l18);
				buttonMap.put("l19",l19);
				buttonMap.put("l20",l20);
				
			        for(int i = 0; i < jArray.length(); i++) {
			            String lockNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.
			                RoundedButton3 button = buttonMap.get(lockNumber);
			                if (Info.lock_number.equals(lockNumber)) {
			                    button.setBackgroundColor(new Color(114,166,255));
			                    button.repaint();
			                } else {
			                    button.setBackgroundColor(new Color(255,128,128));
			                    button.repaint();
			                }
			                button.setBorderPainted(false);
			        }
			    } else {
			        // ...
			    }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		JLabel lblNewLabel = new JLabel(" 20");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(120, 41, 53, 48);
		add(lblNewLabel);
		lblNewLabel.setForeground(new Color(114,166,255));
		JLabel locklabel = new JLabel("");
		locklabel.setFont(new Font("굴림", Font.PLAIN, 30));
		locklabel.setBounds(50, 41, 53, 48);
		add(locklabel);
		locklabel.setForeground(new Color(255, 128, 128));
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(100, 39, 17, 52);
		add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(114,166,255));
		JLabel lblNewLabel_4 = new JLabel("사물함 사용 현황");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setBounds(28, 21, 164, 24);
		add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(114,166,255));
		
		JLabel lblNewLabel_4_1 = new JLabel("사물함 비활성화 현황");
		lblNewLabel_4_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(238, 21, 216, 24);
		add(lblNewLabel_4_1);
		
		JLabel locklabel_1 = new JLabel("");
		locklabel_1.setForeground(new Color(255, 128, 128));
		locklabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
		locklabel_1.setBounds(285, 41, 53, 48);
		add(locklabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("/");
		lblNewLabel_3_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(335, 39, 17, 52);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel(" 20");
		lblNewLabel_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(355, 41, 53, 48);
		add(lblNewLabel_1);
		
		data = new JSONObject();
		try {
			String activations = "0";
			data.put("activations", activations);
			Post po = new Post();
			JSONObject check = po.jsonpost("/Count", data);
			if(check.getString("check").equals("true")) {
				int lockcount = (int) check.get("count_Lock");
				Lockcount = Integer.toString(lockcount);
				locklabel.setText(Lockcount);
			}else {
				System.out.println(1234);
			}
			activations = "2";
			data.put("activations", activations);
			check = po.jsonpost("/Count", data);
			int lockcount1 = (int) check.get("count_Lock");
			Lockcount = Integer.toString(lockcount1);
			locklabel_1.setText(Lockcount);
		}catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
