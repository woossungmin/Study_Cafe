package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifyTicket {

	private JFrame frame;
	private JTextField namefield;
	private JTextField moneyfield;
	private JTextField timefield;
	String t_name = "";
	String t_time = "";
	String t_money1 = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyTicket window = new ModifyTicket(new JPanel(),new JButton(), new JButton(), "");
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
	public ModifyTicket(JPanel borderpanel, JButton homeButton, JButton closeButton, String t_money) {
		initialize(borderpanel, homeButton, closeButton, t_money);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JPanel borderpanel, JButton homeButton, JButton closeButton, String t_money) {
		t_money1 = t_money;
		frame = new JFrame();
		frame.setBounds(490, 120, 487, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 473, 410);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 449, 390);
		panel.add(panel_1);
		panel_1.setBorder(border);
	   panel_1.setLayout(null);
	   panel_1.setBackground(new Color(255,255,255));
	   
	   JPanel panel_2 = new JPanel();
	   panel_2.setBounds(90, 10, 271, 39);
	   panel_1.add(panel_2);
	   panel_2.setLayout(null);
	   panel_2.setBorder(border);
	   panel_2.setBackground(new Color(255,255,255));
	   
	   JLabel lblNewLabel = new JLabel("POTEN STUDY CAFE");
	   lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
	   lblNewLabel.setBounds(55, 6, 167, 28);
	   panel_2.add(lblNewLabel);
	   lblNewLabel.setForeground(new Color(114,166,255));
	   
	   JLabel lblNewLabel_1 = new JLabel("이  용  권  명   : ");
	   lblNewLabel_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1.setBounds(40, 112, 164, 28);
	   panel_1.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel_1_1_1 = new JLabel("이 용 권 금 액  : ");
	   lblNewLabel_1_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1.setBounds(40, 174, 164, 28);
	   panel_1.add(lblNewLabel_1_1_1);
	   
	   namefield = new JTextField();
	   namefield.addMouseListener(new MouseAdapter() {
	   	@Override
	   	public void mouseClicked(MouseEvent e) {
	   		namefield.setFocusable(true);
	   	}
	   });
	   namefield.setFocusable(false);
	   namefield.addFocusListener(new FocusAdapter() {
	   	@Override
	   	public void focusGained(FocusEvent e) {
	   		namefield.setForeground(new Color(0,0,0));
	   		namefield.requestFocusInWindow();
	   	}
	   });
	   namefield.setFont(new Font("굴림", Font.BOLD, 15));
	   namefield.setBounds(203, 115, 205, 25);
	   panel_1.add(namefield);
	   namefield.setColumns(10);
	   namefield.setBorder(border);
	   
	   moneyfield = new JTextField();
	   moneyfield.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		moneyfield.setFocusable(true);
		   	}
		   });
		   moneyfield.setFocusable(false);
		   moneyfield.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		moneyfield.setForeground(new Color(0,0,0));
		   		moneyfield.requestFocusInWindow();
		   	}
		   });
	   moneyfield.setFont(new Font("굴림", Font.BOLD, 15));
	   moneyfield.setColumns(10);
	   moneyfield.setBounds(203, 177, 205, 25);
	   panel_1.add(moneyfield);
	   moneyfield.setBorder(border);
	   
	   timefield = new JTextField();
	   timefield.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		timefield.setFocusable(true);
		   	}
		   });
		   timefield.setFocusable(false);
		   timefield.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		timefield.setForeground(new Color(0,0,0));
		   		timefield.requestFocusInWindow();
		   	}
		   });
	   timefield.setFont(new Font("굴림", Font.BOLD, 15));
	   timefield.setColumns(10);
	   timefield.setBounds(203, 236, 205, 25);
	   panel_1.add(timefield);
	   timefield.setBorder(border);
	   
	   JSONObject data = new JSONObject();
	   try {
		   data.put("t_money", t_money);
		   Post po = new Post();
		
		   JSONObject check = po.jsonpost("/FindTicketTime", data);
		   if((check.get("check")).equals("true")) {
			   t_time = check.getString("t_time");
			   t_name = check.getString("t_name");
			   namefield.setText(t_name);
			   moneyfield.setText(t_money);
			   timefield.setText(t_time);
			   
			   namefield.setForeground(new Color(151,148,154));
			   moneyfield.setForeground(new Color(151,148,154));
			   timefield.setForeground(new Color(151,148,154));
		   }
	   } catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	   }
	   
	   RoundedButton2 okbutton = new RoundedButton2("New button");
	   okbutton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		String t_name = namefield.getText();
	   		String t_money = moneyfield.getText();
	   		String t_time = timefield.getText();
	   		
	   		JSONObject data = new JSONObject();
	 	   try {
	 		   data.put("t_name", t_name);
	 		   data.put("t_money", t_money);
	 		   data.put("t_time", t_time);
	 		   data.put("t_money1", t_money1);
	 		   
	 		   Post po = new Post();
	 		
	 		   JSONObject check = po.jsonpost("/UpdateTicket", data);
	 		   if((check.get("check")).equals("true")) {
	 			   Message ms = new Message("수정이 완료되었습니다.");
	 			   ms.frame.setBounds(600, 230, ms.frame.getWidth(), ms.frame.getHeight());
	 			   frame.dispose();
	 			   Ticketpanel ti = new Ticketpanel(borderpanel,homeButton,closeButton);
	 			   switchPanel(ti,borderpanel,homeButton,closeButton);
	 		   }
	 	   } catch (JSONException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 	   }
	   	}
	   });
		okbutton.setFont(new Font("굴림", Font.BOLD, 15));
		okbutton.setText("확인");
		okbutton.setBounds(90, 329, 95, 39);
		panel_1.add(okbutton);
		
		RoundedButton2 cancelbutton = new RoundedButton2("New button");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelbutton.setText("취소");
		cancelbutton.setFont(new Font("굴림", Font.BOLD, 15));
		cancelbutton.setBounds(266, 329, 95, 39);
		panel_1.add(cancelbutton);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("수정을 원하시면 확인을 눌러주세요.");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 128, 128));
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(98, 285, 259, 28);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("이 용 권 시 간  : ");
		lblNewLabel_1_1_1_2.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_1_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(40, 233, 164, 28);
		panel_1.add(lblNewLabel_1_1_1_2);
	
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
