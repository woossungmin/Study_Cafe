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
	public Lockerpanel(JPanel borderpanel, JButton homebutton) {
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
			}
		});
		l1.setFont(new Font("굴림", Font.BOLD, 15));
		l1.setBounds(40, 43, 129, 87);
		borderpanel2.add(l1);
		
		RoundedButton3 l2 = new RoundedButton3("사물함" + "<br>" +"2번");
		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l2.setFont(new Font("굴림", Font.BOLD, 15));
		l2.setBounds(181, 43, 129, 87);
		borderpanel2.add(l2);
		
		RoundedButton3 l3 = new RoundedButton3("사물함" + "<br>" +"3번");
		l3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l3.setFont(new Font("굴림", Font.BOLD, 15));
		l3.setBounds(322, 43, 129, 87);
		borderpanel2.add(l3);
		
		RoundedButton3 l4 = new RoundedButton3("사물함" + "<br>" +"4번");
		l4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l4.setFont(new Font("굴림", Font.BOLD, 15));
		l4.setBounds(463, 43, 129, 87);
		borderpanel2.add(l4);
		
		RoundedButton3 l5 = new RoundedButton3("사물함" + "<br>" +"5번");
		l5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l5.setFont(new Font("굴림", Font.BOLD, 15));
		l5.setBounds(604, 43, 129, 87);
		borderpanel2.add(l5);
		
		RoundedButton3 l6 = new RoundedButton3("사물함" + "<br>" +"6번");
		l6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l6.setFont(new Font("굴림", Font.BOLD, 15));
		l6.setBounds(40, 140, 129, 87);
		borderpanel2.add(l6);
		
		RoundedButton3 l7 = new RoundedButton3("사물함" + "<br>" +"7번");
		l7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l7.setFont(new Font("굴림", Font.BOLD, 15));
		l7.setBounds(181, 140, 129, 87);
		borderpanel2.add(l7);
		
		RoundedButton3 l8 = new RoundedButton3("사물함" + "<br>" +"8번");
		l8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l8.setFont(new Font("굴림", Font.BOLD, 15));
		l8.setBounds(322, 140, 129, 87);
		borderpanel2.add(l8);
		
		RoundedButton3 l9 = new RoundedButton3("사물함" + "<br>" +"9번");
		l9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l9.setFont(new Font("굴림", Font.BOLD, 15));
		l9.setBounds(463, 140, 129, 87);
		borderpanel2.add(l9);
		
		RoundedButton3 l10 = new RoundedButton3("사물함" + "<br>" +"10번");
		l10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l10.setFont(new Font("굴림", Font.BOLD, 15));
		l10.setBounds(604, 140, 129, 87);
		borderpanel2.add(l10);
		
		RoundedButton3 l11 = new RoundedButton3("사물함" + "<br>" +"11번");
		l11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l11.setFont(new Font("굴림", Font.BOLD, 15));
		l11.setBounds(40, 237, 129, 87);
		borderpanel2.add(l11);
		
		RoundedButton3 l12 = new RoundedButton3("사물함" + "<br>" +"12번");
		l12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l12.setFont(new Font("굴림", Font.BOLD, 15));
		l12.setBounds(181, 237, 129, 87);
		borderpanel2.add(l12);
		
		RoundedButton3 l13 = new RoundedButton3("사물함" + "<br>" +"13번");
		l13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l13.setFont(new Font("굴림", Font.BOLD, 15));
		l13.setBounds(322, 237, 129, 87);
		borderpanel2.add(l13);
		
		RoundedButton3 l14 = new RoundedButton3("사물함" + "<br>" +"14번");
		l14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l14.setFont(new Font("굴림", Font.BOLD, 15));
		l14.setBounds(463, 237, 129, 87);
		borderpanel2.add(l14);
		
		RoundedButton3 l15 = new RoundedButton3("사물함" + "<br>" +"15번");
		l15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l15.setFont(new Font("굴림", Font.BOLD, 15));
		l15.setBounds(604, 237, 129, 87);
		borderpanel2.add(l15);
		
		RoundedButton3 l16 = new RoundedButton3("사물함" + "<br>" +"16번");
		l16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l16.setFont(new Font("굴림", Font.BOLD, 15));
		l16.setBounds(40, 334, 129, 87);
		borderpanel2.add(l16);
		
		RoundedButton3 l17 = new RoundedButton3("사물함" + "<br>" +"17번");
		l17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l17.setFont(new Font("굴림", Font.BOLD, 15));
		l17.setBounds(181, 334, 129, 87);
		borderpanel2.add(l17);
		
		RoundedButton3 l18 = new RoundedButton3("사물함" + "<br>" +"18번");
		l18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l18.setFont(new Font("굴림", Font.BOLD, 15));
		l18.setBounds(322, 334, 129, 87);
		borderpanel2.add(l18);
		
		RoundedButton3 l19 = new RoundedButton3("사물함" + "<br>" +"19번");
		l19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		l19.setFont(new Font("굴림", Font.BOLD, 15));
		l19.setBounds(463, 334, 129, 87);
		borderpanel2.add(l19);
		
		RoundedButton3 l20 = new RoundedButton3("사물함" + "<br>" +"20번");
		l20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
		        Color selectedColor = new Color(114,166,255).brighter();
		        Color defaultColor = new Color(200, 196, 196);

			        for(int i = 0; i < jArray.length(); i++) {
			            String lockNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.
			                RoundedButton3 button = buttonMap.get(lockNumber);
			                if (Info.lock_number.equals(lockNumber)) {
			                    button.setBackgroundColor(selectedColor);
			                } else {
			                    button.setBackgroundColor(defaultColor);
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
		
		
		JLabel lblNewLabel = new JLabel(" 28");
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
		}catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
