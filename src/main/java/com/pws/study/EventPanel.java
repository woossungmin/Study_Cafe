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
	JSONObject b1 = new JSONObject();
	JSONObject b2 = new JSONObject();
	JSONObject b3 = new JSONObject();
	JSONObject b4 = new JSONObject();
	JSONObject b5 = new JSONObject();
	JSONObject b6 = new JSONObject();
	JSONObject e1 = new JSONObject();
	JSONObject e2 = new JSONObject();
	JSONObject e3 = new JSONObject();
	JSONObject e4 = new JSONObject();
	JSONObject e5 = new JSONObject();
	JSONObject e6 = new JSONObject();
    RoundedButton2 ticketbutton = null;
    RoundedButton2 ticketbutton_1 = null;
    RoundedButton2 ticketbutton_2 = null;
    RoundedButton2 ticketbutton_3 = null;
    RoundedButton2 ticketbutton_4 = null;
    RoundedButton2 ticketbutton_5 = null;
    String tMoney1 = "";
    String tMoney2 = "";
    String tMoney3 = "";
    String tMoney4 = "";
    String tMoney5 = "";
    String tMoney6 = "";
    RoundedButton2 eventbutton = new RoundedButton2("null<br>null원");
    RoundedButton2 eventbutton_1= new RoundedButton2("null<br>null원");
    RoundedButton2 eventbutton_3 = new RoundedButton2("null<br>null원");
    RoundedButton2 eventbutton_4 = new RoundedButton2("null<br>null원");
    RoundedButton2 eventbutton_5 = new RoundedButton2("null<br>null원");
    RoundedButton2 eventbutton_6 = new RoundedButton2("null<br>null원");
    String eMoney1 = "";
    String eMoney2 = "";
    String eMoney3 = "";
    String eMoney4 = "";
    String eMoney5 = "";
    String eMoney6 = "";
    
	public EventPanel(JPanel borderpanel, JButton homeButton, JButton closeButton) {
		 Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
	     setBackground(new Color(255, 255, 255));
	     setBounds(23, 40, 816, 580);
	     setLayout(null);
	     JSONObject data = new JSONObject();
		 ss();  // e1, e2, ... 값을 초기화
		 tt();
	     
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
		    
		    try {
		        tMoney1 = (String) b1.get("t_money");
		        String tName1 = (String) b1.get("t_name");  // t_name 가져오기
		        ticketbutton = new RoundedButton2(tName1 + "<br>" + tMoney1 + "원");
		        ticketbutton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                JSONObject data = new JSONObject();
		                Post po = new Post();
		                String id = "d";
		                try {
		                    data.put("t_money", tMoney1);
		                    data.put("t_name", tName1); // t_name 전송
		                    data.put("id", id);
		                    data.put("sale", sales.getSelectedItem().toString());
		                    JSONObject check = po.jsonpost("/InsertEvent", data);
		                    if((check.get("check")).equals("true")) {
		                    	EventPanel ev = new EventPanel(borderpanel,homeButton,closeButton);
		                    	switchPanel(ev,borderpanel,homeButton,closeButton);
		                    }
		                } catch (JSONException e1) {
		                    e1.printStackTrace();
		                }
		            }
		        });
		        ticketbutton.setFont(new Font("굴림", Font.BOLD, 20));
		        ticketbutton.setBounds(48, 84, 186, 107); 
		        borderpanel2.add(ticketbutton);
		        ticketbutton.setBackground(new Color(114,166,255));
		        ticketbutton.setForeground(new Color(255,255,255));
		    } catch (JSONException e1) {
		        e1.printStackTrace();
		    }


			try {
					tMoney2 = (String) b2.get("t_money");
					ticketbutton_1 = new RoundedButton2((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
					ticketbutton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					ticketbutton_1.setFont(new Font("굴림", Font.BOLD, 20));
					ticketbutton_1.setBounds(288, 84, 186, 107);
					borderpanel2.add(ticketbutton_1);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
			try {
					tMoney3 = (String) b3.get("t_money");
					ticketbutton_2 = new RoundedButton2((String) b3.get("t_name") + "<br>" + (String) b3.get("t_money") + "원");
					ticketbutton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					ticketbutton_2.setFont(new Font("굴림", Font.BOLD, 20));
					ticketbutton_2.setBounds(528, 84, 186, 107);
			      borderpanel2.add(ticketbutton_2);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
			try {
					tMoney4 = (String) b4.get("t_money");
					ticketbutton_3 = new RoundedButton2((String) b4.get("t_name") + "<br>" + (String) b4.get("t_money") + "원");
					ticketbutton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					ticketbutton_3.setFont(new Font("굴림", Font.BOLD, 20));
					ticketbutton_3.setBounds(48, 213, 186, 107);
					borderpanel2.add(ticketbutton_3);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
			try {
					tMoney5 = (String) b5.get("t_money");
					ticketbutton_4 = new RoundedButton2((String) b5.get("t_name") + "<br>" + (String) b5.get("t_money") + "원");
					ticketbutton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					ticketbutton_4.setFont(new Font("굴림", Font.BOLD, 20));
					ticketbutton_4.setBounds(288, 213, 186, 107);
					borderpanel2.add(ticketbutton_4);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
			try {
					tMoney6 = (String) b6.get("t_money");
					ticketbutton_5 = new RoundedButton2((String) b6.get("t_name") + "<br>" + (String) b6.get("t_money") + "원");
					ticketbutton_5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
				    ticketbutton_5.setFont(new Font("굴림", Font.BOLD, 20));
				    ticketbutton_5.setBounds(528, 213, 186, 107);
				    borderpanel2.add(ticketbutton_5);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	
			
		    JButton timeticket = new JButton("시간 이용권");
		    timeticket.setBounds(67, 41, 145, 33);
		    borderpanel2.add(timeticket);
		    timeticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						String id = "a";
					data.put("id", id);
					Post po = new Post();
					
					JSONObject check = po.jsonpost("/FindTicket", data);
					
					if((check.get("check")).equals("true"))
					{
						JSONArray jArray = new JSONArray();
						jArray = (JSONArray) check.get("tickets");
						b1 = (JSONObject) jArray.get(0);
						b2 = (JSONObject) jArray.get(1);
						b3 = (JSONObject) jArray.get(2);
						b4 = (JSONObject) jArray.get(3);
						b5 = (JSONObject) jArray.get(4);
						b6 = (JSONObject) jArray.get(5);	
						
			            ticketbutton.setText((String) b1.get("t_name") + "<br>" + (String) b1.get("t_money") + "원");
			            ticketbutton_1.setText((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
			            ticketbutton_2.setText((String) b3.get("t_name") + "<br>" + (String) b3.get("t_money") + "원");
			            ticketbutton_3.setText((String) b4.get("t_name") + "<br>" + (String) b4.get("t_money") + "원");
			            ticketbutton_4.setText((String) b5.get("t_name") + "<br>" + (String) b5.get("t_money") + "원");
			            ticketbutton_5.setText((String) b6.get("t_name") + "<br>" + (String) b6.get("t_money") + "원");
			            
			            tMoney1 = (String) b1.get("t_money");
		                tMoney2 = (String) b2.get("t_money");
		                tMoney3 = (String) b3.get("t_money");
		                tMoney4 = (String) b4.get("t_money");
		                tMoney5 = (String) b5.get("t_money");
		                tMoney6 = (String) b6.get("t_money");
					}
					else
					{
					}
					} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				}
		    	}
		    });
		    timeticket.setFont(new Font("굴림", Font.BOLD, 20));
		    timeticket.setBorderPainted(false);
		    timeticket.setContentAreaFilled(false); 
		    timeticket.setForeground(new Color(114,166,255));
		    timeticket.setFocusPainted(false);
		    
		    JButton seasonticket = new JButton("기간 이용권");
		    seasonticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						String id = "b";
					data.put("id", id);
					Post po = new Post();
					
					JSONObject check = po.jsonpost("/FindTicket", data);
					
					if((check.get("check")).equals("true"))
					{
						JSONArray jArray = new JSONArray();
						jArray = (JSONArray) check.get("tickets");
						b1 = (JSONObject) jArray.get(0);
						b2 = (JSONObject) jArray.get(1);
						b3 = (JSONObject) jArray.get(2);
						b4 = (JSONObject) jArray.get(3);
						b5 = (JSONObject) jArray.get(4);
						b6 = (JSONObject) jArray.get(5);	
			            ticketbutton.setText((String) b1.get("t_name") + "<br>" + (String) b1.get("t_money") + "원");
			            ticketbutton_1.setText((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
			            ticketbutton_2.setText((String) b3.get("t_name") + "<br>" + (String) b3.get("t_money") + "원");
			            ticketbutton_3.setText((String) b4.get("t_name") + "<br>" + (String) b4.get("t_money") + "원");
			            ticketbutton_4.setText((String) b5.get("t_name") + "<br>" + (String) b5.get("t_money") + "원");
			            ticketbutton_5.setText((String) b6.get("t_name") + "<br>" + (String) b6.get("t_money") + "원");
			            
			            tMoney1 = (String) b1.get("t_money");
		                tMoney2 = (String) b2.get("t_money");
		                tMoney3 = (String) b3.get("t_money");
		                tMoney4 = (String) b4.get("t_money");
		                tMoney5 = (String) b5.get("t_money");
		                tMoney6 = (String) b6.get("t_money");
					}
					else
					{
					}
					} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				}
		    	}
		    });
		    seasonticket.setBounds(295, 41, 158, 33);
		    borderpanel2.add(seasonticket);
		    seasonticket.setFont(new Font("굴림", Font.BOLD, 20));
		    seasonticket.setContentAreaFilled(false);
		    seasonticket.setBorderPainted(false);
		    seasonticket.setForeground(new Color(114,166,255));
		    seasonticket.setFocusPainted(false);
		    
		    JButton lockticket = new JButton("사물함 이용권");
		    lockticket.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
						String id = "c";
					data.put("id", id);
					Post po = new Post();
					
					JSONObject check = po.jsonpost("/FindTicket", data);
					
					if((check.get("check")).equals("true"))
					{
						JSONArray jArray = new JSONArray();
						jArray = (JSONArray) check.get("tickets");
						b1 = (JSONObject) jArray.get(0);
						b2 = (JSONObject) jArray.get(1);
						b3 = (JSONObject) jArray.get(2);
						b4 = (JSONObject) jArray.get(3);
						b5 = (JSONObject) jArray.get(4);
						b6 = (JSONObject) jArray.get(5);		
			            ticketbutton.setText((String) b1.get("t_name") + "<br>" + (String) b1.get("t_money") + "원");
			            ticketbutton_1.setText((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
			            ticketbutton_2.setText((String) b3.get("t_name") + "<br>" + (String) b3.get("t_money") + "원");
			            ticketbutton_3.setText((String) b4.get("t_name") + "<br>" + (String) b4.get("t_money") + "원");
			            ticketbutton_4.setText((String) b5.get("t_name") + "<br>" + (String) b5.get("t_money") + "원");
			            ticketbutton_5.setText((String) b6.get("t_name") + "<br>" + (String) b6.get("t_money") + "원");
			            
			            tMoney1 = (String) b1.get("t_money");
		                tMoney2 = (String) b2.get("t_money");
		                tMoney3 = (String) b3.get("t_money");
		                tMoney4 = (String) b4.get("t_money");
		                tMoney5 = (String) b5.get("t_money");
		                tMoney6 = (String) b6.get("t_money");
					}
					else
					{
					}
					} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				}
		    	}
		    });
		    lockticket.setBounds(534, 41, 165, 33);
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
		    
		    
		    RoundedButton2 eventbutton = new RoundedButton2("");
		    eventbutton.setForeground(Color.WHITE);
		    eventbutton.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton.setBackground(new Color(114, 166, 255));
		    eventbutton.setBounds(65, 50, 148, 68);
		    panel.add(eventbutton);
		    
		    RoundedButton2 eventbutton1 = new RoundedButton2("");
		    eventbutton1.setForeground(Color.WHITE);
		    eventbutton1.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton1.setBackground(new Color(114, 166, 255));
		    eventbutton1.setBounds(310, 50, 148, 68);
		    panel.add(eventbutton1);
		    
		    RoundedButton2 eventbutton2 = new RoundedButton2("");
		    eventbutton2.setForeground(Color.WHITE);
		    eventbutton2.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton2.setBackground(new Color(114, 166, 255));
		    eventbutton2.setBounds(555, 50, 148, 68);
		    panel.add(eventbutton2);
		    
		    RoundedButton2 eventbutton3 = new RoundedButton2("");
		    eventbutton3.setForeground(Color.WHITE);
		    eventbutton3.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton3.setBackground(new Color(114, 166, 255));
		    eventbutton3.setBounds(65, 137, 148, 68);
		    panel.add(eventbutton3);
		    
		    RoundedButton2 eventbutton4 = new RoundedButton2("");
		    eventbutton4.setForeground(Color.WHITE);
		    eventbutton4.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton4.setBackground(new Color(114, 166, 255));
		    eventbutton4.setBounds(310, 137, 148, 68);
		    panel.add(eventbutton4);
		    
		    RoundedButton2 eventbutton5 = new RoundedButton2("");
		    eventbutton5.setForeground(Color.WHITE);
		    eventbutton5.setFont(new Font("굴림", Font.BOLD, 20));
		    eventbutton5.setBackground(new Color(114, 166, 255));
		    eventbutton5.setBounds(555, 137, 148, 68);
		    panel.add(eventbutton5);
		    
		    eMoney1 = e1.optString("t_money", "");
			String eName1 = e1.optString("t_name", "");  // t_name 가져오기
			if (e1.length() == 0) {
			    eventbutton.setText("X");
			} else {
			    eventbutton.setText(eName1 + "<br>" + eMoney1 + "원");
			}

			
		    eMoney2 = e2.optString("t_money", "");
			String eName2 = e2.optString("t_name", "");  // t_name 가져오기
			if (e2.length() == 0) {
			    eventbutton1.setText("X");
			} else {
			    eventbutton1.setText(eName2 + "<br>" + eMoney2 + "원");
			}
			
		    eMoney3 = e3.optString("t_money", "");
			String eName3 = e3.optString("t_name", "");  // t_name 가져오기
			if (e3.length() == 0) {
			    eventbutton2.setText("X");
			} else {
			    eventbutton2.setText(eName3 + "<br>" + eMoney3 + "원");
			}
			
		    eMoney4 = e4.optString("t_money", "");
			String eName4 = e4.optString("t_name", "");  // t_name 가져오기
			if (e4.length() == 0) {
			    eventbutton3.setText("X");
			} else {
			    eventbutton3.setText(eName4 + "<br>" + eMoney4 + "원");
			}
	       
		    eMoney5 = e5.optString("t_money", "");
			String eName5 = e5.optString("t_name", "");  // t_name 가져오기
			if (e5.length() == 0) {
			    eventbutton4.setText("X");
			} else {
			    eventbutton4.setText(eName5 + "<br>" + eMoney5 + "원");
			}
			
			eMoney6 = e6.optString("t_money", "");
			String eName6 = e6.optString("t_name", "");  // t_name 가져오기
			if (e6.length() == 0) {
			    eventbutton5.setText("X");
			} else {
			    eventbutton5.setText(eName6 + "<br>" + eMoney6 + "원");
			}
	        
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
		    lblNewLabel.setBounds(293, 10, 179, 40);
		    panel.add(lblNewLabel);
		    lblNewLabel.setForeground(new Color(114,166,255));
	     
	}
	private void switchPanel(JPanel newPanel,JPanel borderpanel, JButton homebutton, JButton closebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(closebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
	private void ss() {
		JSONObject data = new JSONObject();
		try {
    	    String id = "d";
    	    data.put("id", id);
    	    Post po = new Post();
    	    
    	    JSONObject check = po.jsonpost("/FindTicket", data);
    	    
    	    if((check.get("check")).equals("true")) {
    	        JSONArray jArray = new JSONArray();
    	        if (check.has("tickets") && !check.isNull("tickets")) { // Check if "tickets" is present and not null
    	            jArray = check.getJSONArray("tickets");
    	            if (jArray.length() >= 1) {
    	                e1 = (JSONObject) jArray.get(0);
    	            }
    	            if (jArray.length() >= 2) {
    	                e2 = (JSONObject) jArray.get(1);
    	            }
    	            if (jArray.length() >= 3) {
    	                e3 = (JSONObject) jArray.get(2);
    	            }
    	            if (jArray.length() >= 4) {
    	                e4 = (JSONObject) jArray.get(3);
    	            }
    	            if (jArray.length() >= 5) {
    	                e5 = (JSONObject) jArray.get(4);
    	            }
    	            if (jArray.length() >= 6) {
    	                e6 = (JSONObject) jArray.get(5);
    	            }
    	        }
    	    }
    	    else {
    	        // Handle if check is not true
    	    }
    	} catch (JSONException e) {
    	    e.printStackTrace();
    	}
	}
	private void tt() {
		JSONObject data = new JSONObject();
		 try {
				String id = "a";
			data.put("id", id);
			Post po = new Post();
			
			JSONObject check = po.jsonpost("/FindTicket", data);
			
			if((check.get("check")).equals("true"))
			{
				JSONArray jArray = new JSONArray();
				jArray = (JSONArray) check.get("tickets");
				b1 = (JSONObject) jArray.get(0);
				b2 = (JSONObject) jArray.get(1);
				b3 = (JSONObject) jArray.get(2);
				b4 = (JSONObject) jArray.get(3);
				b5 = (JSONObject) jArray.get(4);
				b6 = (JSONObject) jArray.get(5);				
			}
			else
			{
			}
			} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	
		}
	}
}
