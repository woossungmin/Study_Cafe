package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class EventPanel extends JPanel {

	JSONObject[] b = new JSONObject[6];
	JSONObject[] e = new JSONObject[6];
    RoundedButton2[] ticketButtons = new RoundedButton2[6];
	RoundedButton2[] eventButtons = new RoundedButton2[6];
	
	public EventPanel(JPanel borderpanel, JButton homeButton, JButton closeButton) {
		 Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
	     setBackground(new Color(255, 255, 255));
	     setBounds(23, 40, 816, 580);
	     setLayout(null);
	     JSONObject data = new JSONObject();
	     
	     JPanel borderpanel2 = new JPanel();
			borderpanel2.setBounds(24, 240, 766, 330);
			add(borderpanel2);
			borderpanel2.setBackground(new Color(255,255,255));
			borderpanel2.setBorder(border);
			borderpanel2.setLayout(null);
			borderpanel2.setBackground(new Color(217,231,255));
			
		    JComboBox sales = new JComboBox();
		    sales.setFont(new Font("굴림", Font.BOLD, 12));
		    sales.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"}));
		    sales.setBounds(658, 10, 59, 27);
		    borderpanel2.add(sales);
		    sales.setBackground(new Color(255,255,255));
		    sales.setBorder(border);
			
		    JButton timeticket = new JButton("시간 이용권");
		    timeticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		fetchDataAndUpdate("a");
		    	}
		    });
		    timeticket.setBounds(67, 45, 145, 33);
		    borderpanel2.add(timeticket);
		    timeticket.setFont(new Font("굴림", Font.BOLD, 20));
		    timeticket.setBorderPainted(false);
		    timeticket.setContentAreaFilled(false); 
		    timeticket.setForeground(new Color(114,166,255));
		    timeticket.setFocusPainted(false);
		    
		    JButton seasonticket = new JButton("기간 이용권");
		    seasonticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		fetchDataAndUpdate("b");
		    	}
		    });
		    seasonticket.setBounds(304, 45, 158, 33);
		    borderpanel2.add(seasonticket);
		    seasonticket.setFont(new Font("굴림", Font.BOLD, 20));
		    seasonticket.setContentAreaFilled(false);
		    seasonticket.setBorderPainted(false);
		    seasonticket.setForeground(new Color(114,166,255));
		    seasonticket.setFocusPainted(false);
		    
		    JButton lockticket = new JButton("사물함 이용권");
		    lockticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		fetchDataAndUpdate("c");
		    	}
		    });
		    lockticket.setBounds(552, 45, 165, 33);
		    borderpanel2.add(lockticket);
		    lockticket.setFont(new Font("굴림", Font.BOLD, 20));
		    lockticket.setContentAreaFilled(false);
		    lockticket.setBorderPainted(false);
		    lockticket.setForeground(new Color(114,166,255));
		    lockticket.setFocusPainted(false);
					
		    JPanel panel = new JPanel();
		    panel.setBounds(24, 10, 766, 220);
		    add(panel);
		    panel.setBackground(new Color(217,231,255));
		    panel.setBorder(border);
		    panel.setLayout(null);
		    
		    JLabel sss = new JLabel("%");
		    sss.setBounds(726, 5, 28, 40);
		    borderpanel2.add(sss);
		    sss.setFont(new Font("굴림", Font.BOLD, 20));
		    sss.setForeground(new Color(114,166,255));
		    
		    JLabel sss_1 = new JLabel("할인율 : ");
		    sss_1.setForeground(new Color(114, 166, 255));
		    sss_1.setFont(new Font("굴림", Font.BOLD, 20));
		    sss_1.setBounds(565, 7, 83, 33);
		    borderpanel2.add(sss_1);
		    
		    JLabel lblNewLabel = new JLabel("행사중인 이용권 !");
		    lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		    lblNewLabel.setBounds(303, 10, 179, 40);
		    panel.add(lblNewLabel);
		    lblNewLabel.setForeground(new Color(114,166,255));
		    
		    int[] xeventButtons = {65, 310, 555, 65, 310, 555};
		    int[] yeventButtons = {50, 50, 50, 137, 137, 137};
		    
		    for (int i = 0; i < 6; i++) {
		        eventButtons[i] = new RoundedButton2("");
		        eventButtons[i].setForeground(Color.WHITE);
		        eventButtons[i].setFont(new Font("굴림", Font.BOLD, 20));
		        eventButtons[i].setBackground(new Color(114, 166, 255));
		        eventButtons[i].setBounds(xeventButtons[i], yeventButtons[i], 148, 68);
		        panel.add(eventButtons[i]);
		        int finalII = i;
		        eventButtons[i].addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	 String buttonText = eventButtons[finalII].getText();
		            	 String[] parts = buttonText.split("<br>");
		                 String name = parts[1].replaceAll("\\<.*?\\>", ""); // HTML 태그 제거
		                 String money = parts[2].replaceAll("\\<.*?\\>", ""); // HTML 태그 제거
		                 money = money.substring(0, money.length() - 1); // 마지막 문자(원) 제거
			                try {
			                    data.put("name", name);
			                    data.put("money", money);
			                    data.put("id", "d");
			                    Post po = new Post();
			                    JSONObject check = po.jsonpost("/DeleteTicket", data);
			                    if((check.get("check")).equals("true")) {
			                    	EventPanel ev = new EventPanel(borderpanel,homeButton,closeButton);
			                    	switchPanel(ev,borderpanel,homeButton,closeButton);
			                    } else if((check.get("check")).equals("false")) {
			                    	Message ms = new Message("    삭제를 실패했습니다.");
			                    }
			                } catch (JSONException e1) {
			                    // TODO Auto-generated catch block
			                    e1.printStackTrace();
			                }
		            }
		        });
		    }
		    fetchDataAndUpdate1("d");
		    
		    int[] xticketButtons = {42, 42, 292, 292, 542, 542};
		    int[] yticketButtons = {84, 213, 84, 213, 84, 213};

		    for (int i = 0; i < 6; i++) {
		        ticketButtons[i] = new RoundedButton2();
		        ticketButtons[i].setFont(new Font("굴림", Font.BOLD, 20));
		        ticketButtons[i].setBackground(new Color(114, 166, 255));
		        ticketButtons[i].setForeground(Color.WHITE);
		        ticketButtons[i].setBounds(xticketButtons[i], yticketButtons[i], 186, 107);
		        borderpanel2.add(ticketButtons[i]);
		        
		        int finalI = i;
		        ticketButtons[i].addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                JSONArray jArray = null;
		                String buttonText = ticketButtons[finalI].getText();
		                String[] parts = buttonText.split("<br>");
		                String name = parts[0];
		                String money = parts[1];
		                money = money.substring(0, money.length() - 1); // 마지막 문자(원) 제거
		                try {
		                    data.put("name", name);
		                    data.put("money", money);
		                    data.put("sale", sales.getSelectedItem());
		                    Post po = new Post();
		                    JSONObject check = po.jsonpost("/InsertEvent", data);
		                    if((check.get("check")).equals("true")) {
		                    	EventPanel ev = new EventPanel(borderpanel,homeButton,closeButton);
		                    	switchPanel(ev,borderpanel,homeButton,closeButton);
		                    } else if((check.get("check")).equals("false")) {
		                    	Message ms = new Message("이미 존재하는 행사 상품.");
		                    } else if((check.get("check")).equals("false1")) {
		                    	Message ms = new Message("행사 상품을 삭제 해주세요.");
		                    }
		                } catch (JSONException e1) {
		                    // TODO Auto-generated catch block
		                    e1.printStackTrace();
		                }
		                // 이제 name 및 money를 사용할 수 있습니다.
		            }
		        });
		    }
		    fetchDataAndUpdate("a");
		    
	}
	private void switchPanel(JPanel newPanel,JPanel borderpanel, JButton homebutton, JButton closebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(closebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
	
	private void fetchDataAndUpdate(String id) {
		JSONObject data = new JSONObject();
	    JSONArray jArray = null;
	    try {
	        data.put("id", id);
	        Post po = new Post();
	        JSONObject check = po.jsonpost("/FindTicket", data);

	        if ((check.get("check")).equals("true")) {
	            jArray = check.getJSONArray("tickets");
	        } else {
	            // Handle if check is not true
	        }
	    } catch (JSONException e1) {
	        e1.printStackTrace();
	    }

	    if (jArray != null && jArray.length() >= 6) {
	        for (int i = 0; i < jArray.length(); i++) {
	            try {
	                b[i] = jArray.getJSONObject(i);
		            ticketButtons[i].setText((String) b[i].get("t_name") + "<br>" + (String) b[i].get("t_money") + "원");
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    }
	private void fetchDataAndUpdate1(String id) {
	    JSONObject data = new JSONObject();
	    JSONArray jArray = null;
	    try {
	        data.put("id", id);
	        
	        Post po = new Post();
	        JSONObject check = po.jsonpost("/FindTicket", data);

	        if ((check.get("check")).equals("true")) {
	            jArray = check.getJSONArray("tickets");
	        } else {
	            // Handle if check is not true
	        }
	    } catch (JSONException e1) {
	        e1.printStackTrace();
	    }

	    for (int i = 0; i < 6; i++) {
	        if (jArray != null && jArray.length() > i) {
	            try {
	                e[i] = jArray.getJSONObject(i);
	                String name = e[i].optString("t_name", "");
	                String money = e[i].optString("t_money", "");
	                if (name.equals("") || money.equals("")) {
	                    eventButtons[i].setText("X");
	                } else {
		                if(e[i].get("origin_id").equals("a") || e[i].get("origin_id").equals("b")) {
		                    eventButtons[i].setText("좌석 이용권 " + "<br>" + name + "<br>" + money + "원");
		                    eventButtons[i].setTextSize(15);
		                }
		                else if(e[i].get("origin_id").equals("c")) {
		                	 eventButtons[i].setText("사물함 이용권 " + "<br>" + name + "<br>" + money + "원");
		                	 eventButtons[i].setTextSize(15);
		                }

	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	        } else {
	            eventButtons[i].setText("X");
	        }
	    }
	}

}
