package com.pws.study;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Ticketpanel extends JPanel {
	JSONObject b1 = null;
	JSONObject b2 = null;
	JSONObject b3 = null;
	JSONObject b4 = null;
	JSONObject b5 = null;
	JSONObject b6 = null;
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
    
	public Ticketpanel(JPanel borderpanel, JButton homeButton, JButton closeButton) {
        Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
        setBackground(new Color(255, 255, 255));
        setBounds(23, 40, 816, 580);
        setLayout(null);
		
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
		JPanel borderpanel2 = new JPanel();
		borderpanel2.setBounds(23, 200, 766, 370);
		add(borderpanel2);
		borderpanel2.setBackground(new Color(255,255,255));
		borderpanel2.setBorder(border);
		borderpanel2.setLayout(null);
		borderpanel2.setBackground(new Color(217,231,255));
		
		try {			
			    tMoney1 = (String) b1.get("t_money");
				ticketbutton = new RoundedButton2((String) b1.get("t_name") + "<br>" + (String) b1.get("t_money") + "원");
				ticketbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney1);
						
					}
				});
				ticketbutton.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton.setBounds(49, 84, 186, 107); 
				borderpanel2.add(ticketbutton);
				ticketbutton.setBackground(new Color(114,166,255));
				ticketbutton.setForeground(new Color(255,255,255));
				
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
		try {
				tMoney2 = (String) b2.get("t_money");
				ticketbutton_1 = new RoundedButton2((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
				ticketbutton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney2);
					}
				});
				ticketbutton_1.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_1.setBounds(289, 84, 186, 107);
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
						ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney3);
					}
				});
				ticketbutton_2.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_2.setBounds(529, 84, 186, 107);
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
						ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney4);
					}
				});
				ticketbutton_3.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_3.setBounds(49, 239, 186, 107);
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
						ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney5);
					}
				});
				ticketbutton_4.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_4.setBounds(289, 239, 186, 107);
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
						ModifyTicket mo = new ModifyTicket(borderpanel,homeButton,closeButton,tMoney6);
					}
				});
			    ticketbutton_5.setFont(new Font("굴림", Font.BOLD, 20));
			    ticketbutton_5.setBounds(529, 239, 186, 107);
			    borderpanel2.add(ticketbutton_5);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	    JButton timeticket = new JButton("시간 이용권");
	    timeticket.setBounds(71, 28, 145, 33);
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
	    seasonticket.setBounds(299, 28, 158, 33);
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
	    lockticket.setBounds(539, 28, 165, 33);
	    borderpanel2.add(lockticket);
	    lockticket.setFont(new Font("굴림", Font.BOLD, 20));
	    lockticket.setContentAreaFilled(false);
	    lockticket.setBorderPainted(false);
	    lockticket.setForeground(new Color(114,166,255));
	    lockticket.setFocusPainted(false);
	    
        JPanel timepanel = new JPanel();
		timepanel.setBounds(23, 36, 223, 154);
		add(timepanel);
		timepanel.setBackground(new Color(255,255,255));
		timepanel.setBorder(border);
		timepanel.setLayout(null);
		
		JLabel timelabel1 = new JLabel("");
		timelabel1.setForeground(new Color(114, 166, 255));
		timelabel1.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel1.setBounds(12, 8, 86, 20);
		timepanel.add(timelabel1);
		
		JLabel timelabel2 = new JLabel("");
		timelabel2.setForeground(new Color(114, 166, 255));
		timelabel2.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel2.setBounds(12, 32, 86, 20);
		timepanel.add(timelabel2);
		
		JLabel timelabel3 = new JLabel("");
		timelabel3.setForeground(new Color(114, 166, 255));
		timelabel3.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel3.setBounds(12, 56, 86, 20);
		timepanel.add(timelabel3);
		
		JLabel timelabel4 = new JLabel("");
		timelabel4.setForeground(new Color(114, 166, 255));
		timelabel4.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel4.setBounds(12, 80, 86, 20);
		timepanel.add(timelabel4);
		
		JLabel timelabel5 = new JLabel("");
		timelabel5.setForeground(new Color(114, 166, 255));
		timelabel5.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel5.setBounds(12, 104, 86, 20);
		timepanel.add(timelabel5);
		
		JLabel timelabel6 = new JLabel("");
		timelabel6.setForeground(new Color(114, 166, 255));
		timelabel6.setFont(new Font("굴림", Font.BOLD, 14));
		timelabel6.setBounds(12, 128, 86, 20);
		timepanel.add(timelabel6);
	    
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
            timelabel1.setText((String) b1.get("t_name") + " :");
            timelabel2.setText((String) b2.get("t_name") + " :");
            timelabel3.setText((String) b3.get("t_name") + " :");
            timelabel4.setText((String) b4.get("t_name") + " :");
            timelabel5.setText((String) b5.get("t_name") + " :");
            timelabel6.setText((String) b6.get("t_name") + " :");
		}
		else
		{
		}
		} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
	    JPanel seasonpanel = new JPanel();
	    seasonpanel.setLayout(null);
	    seasonpanel.setBackground(Color.WHITE);
	    seasonpanel.setBounds(295, 36, 223, 154);
	    add(seasonpanel);
	    seasonpanel.setBorder(border);
	    
	    JLabel seasonlabel1 = new JLabel("");
	    seasonlabel1.setForeground(new Color(114, 166, 255));
	    seasonlabel1.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel1.setBounds(12, 8, 86, 20);
	    seasonpanel.add(seasonlabel1);
	    
	    JLabel seasonlabel2 = new JLabel("");
	    seasonlabel2.setForeground(new Color(114, 166, 255));
	    seasonlabel2.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel2.setBounds(12, 32, 86, 20);
	    seasonpanel.add(seasonlabel2);
	    
	    JLabel seasonlabel3 = new JLabel("");
	    seasonlabel3.setForeground(new Color(114, 166, 255));
	    seasonlabel3.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel3.setBounds(12, 56, 86, 20);
	    seasonpanel.add(seasonlabel3);
	    
	    JLabel seasonlabel4 = new JLabel("");
	    seasonlabel4.setForeground(new Color(114, 166, 255));
	    seasonlabel4.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel4.setBounds(12, 80, 86, 20);
	    seasonpanel.add(seasonlabel4);
	    
	    JLabel seasonlabel5 = new JLabel("");
	    seasonlabel5.setForeground(new Color(114, 166, 255));
	    seasonlabel5.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel5.setBounds(12, 104, 86, 20);
	    seasonpanel.add(seasonlabel5);
	    
	    JLabel seasonlabel6 = new JLabel("");
	    seasonlabel6.setForeground(new Color(114, 166, 255));
	    seasonlabel6.setFont(new Font("굴림", Font.BOLD, 14));
	    seasonlabel6.setBounds(12, 128, 86, 20);
	    seasonpanel.add(seasonlabel6);
	    
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
            seasonlabel1.setText((String) b1.get("t_name") + " :");
            seasonlabel2.setText((String) b2.get("t_name") + " :");
            seasonlabel3.setText((String) b3.get("t_name") + " :");
            seasonlabel4.setText((String) b4.get("t_name") + " :");
            seasonlabel5.setText((String) b5.get("t_name") + " :");
            seasonlabel6.setText((String) b6.get("t_name") + " :");
		}
		else
		{
		}
		} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	    
	    JPanel lockpanel = new JPanel();
	    lockpanel.setLayout(null);
	    lockpanel.setBackground(Color.WHITE);
	    lockpanel.setBounds(566, 36, 223, 152);
	    add(lockpanel);
	    lockpanel.setBorder(border);
	    
	    JLabel locklabel1 = new JLabel("");
	    locklabel1.setForeground(new Color(114, 166, 255));
	    locklabel1.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel1.setBounds(12, 32, 86, 20);
	    lockpanel.add(locklabel1);
	    
	    JLabel locklabel2 = new JLabel("");
	    locklabel2.setForeground(new Color(114, 166, 255));
	    locklabel2.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel2.setBounds(12, 8, 86, 20);
	    lockpanel.add(locklabel2);
	    
	    JLabel locklabel3 = new JLabel("");
	    locklabel3.setForeground(new Color(114, 166, 255));
	    locklabel3.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel3.setBounds(12, 56, 86, 20);
	    lockpanel.add(locklabel3);
	    
	    JLabel locklabel4 = new JLabel("");
	    locklabel4.setForeground(new Color(114, 166, 255));
	    locklabel4.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel4.setBounds(12, 104, 86, 20);
	    lockpanel.add(locklabel4);
	    
	    JLabel locklabel5 = new JLabel("");
	    locklabel5.setForeground(new Color(114, 166, 255));
	    locklabel5.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel5.setBounds(12, 80, 86, 20);
	    lockpanel.add(locklabel5);
	    
	    JLabel locklabel6 = new JLabel("");
	    locklabel6.setForeground(new Color(114, 166, 255));
	    locklabel6.setFont(new Font("굴림", Font.BOLD, 14));
	    locklabel6.setBounds(12, 128, 86, 20);
	    lockpanel.add(locklabel6);
	    
	    try {
			String id = "c";
		data.put("id", id);
		Post po = new Post();
		
		JSONObject check = po.jsonpost("/FindTicket", data);
		
		if((check.get("check")).equals("true"))
		{
			JSONArray jArray = new JSONArray();
			jArray = (JSONArray) check.get("tickets");
			b1 = (JSONObject) jArray.get(1);
			b2 = (JSONObject) jArray.get(0);
			b3 = (JSONObject) jArray.get(2);
			b4 = (JSONObject) jArray.get(3);
			b5 = (JSONObject) jArray.get(4);
			b6 = (JSONObject) jArray.get(5);		
			locklabel1.setText((String) b1.get("t_name") + " :");
			locklabel2.setText((String) b2.get("t_name") + " :");
			locklabel3.setText((String) b3.get("t_name") + " :");
			locklabel4.setText((String) b4.get("t_name") + " :");
			locklabel5.setText((String) b5.get("t_name") + " :");
			locklabel6.setText((String) b6.get("t_name") + " :");
		}
		else
		{
		}
		} catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
	    
	    JLabel timelabel = new JLabel("시간 이용권");
	    timelabel.setFont(new Font("굴림", Font.BOLD, 16));
	    timelabel.setBounds(55, 12, 128, 24);
	    add(timelabel);
	    timelabel.setForeground(new Color(114,166,255));
	    
	    JLabel timeimage = new JLabel("");
	    timeimage.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\sand-clock.png"));
	    timeimage.setBounds(23, 10, 24, 24);
	    add(timeimage);
	    
	    JLabel timeimage_1 = new JLabel("");
	    timeimage_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\weekly-calendar-outline-event-interface-symbol.png"));
	    timeimage_1.setBounds(295, 10, 24, 24);
	    add(timeimage_1);
	    
	    JLabel timelabel_1 = new JLabel("정기 이용권");
	    timelabel_1.setForeground(new Color(114, 166, 255));
	    timelabel_1.setFont(new Font("굴림", Font.BOLD, 16));
	    timelabel_1.setBounds(329, 12, 128, 24);
	    add(timelabel_1);
	    
	    JLabel timelabel_1_1 = new JLabel("사물함 이용권");
	    timelabel_1_1.setForeground(new Color(114, 166, 255));
	    timelabel_1_1.setFont(new Font("굴림", Font.BOLD, 16));
	    timelabel_1_1.setBounds(598, 12, 191, 24);
	    add(timelabel_1_1);
	    
	    JLabel timeimage_1_1 = new JLabel("");
	    timeimage_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\padlock.png"));
	    timeimage_1_1.setBounds(566, 10, 223, 24);
	    add(timeimage_1_1);
	    lockticket.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            
	            if (model.isRollover()) {
	                lockticket.setForeground(new Color(255,255,255)); // 글자 색상 변경
	            } else {
	                lockticket.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	            }
	        }
	    });
	    seasonticket.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            
	            if (model.isRollover()) {
	            	seasonticket.setForeground(new Color(255,255,255)); // 글자 색상 변경
	            } else {
	                seasonticket.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	            }
	        }
	    });
	    timeticket.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            
	            if (model.isRollover()) {
	                timeticket.setForeground(new Color(255,255,255)); // 글자 색상 변경
	            } else {
	                timeticket.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	            }
	        }
	    });
	}
    private void switchPanel(JPanel newPanel,JPanel borderpanel, JButton homebutton, JButton closebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(closebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
}
