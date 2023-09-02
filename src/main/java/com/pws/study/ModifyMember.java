package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JTextField;

public class ModifyMember {

	private JFrame frame;
	private JTextField phonetext;
	private JTextField pwtext;
	private JTextField emailtext;
	private JTextField gendertext;
	private JTextField birthtext;
    private JButton homeButton;
    private JButton closeButton;
    private JPanel borderPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyMember window = new ModifyMember(new JButton(), new JButton(), new JPanel());
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
	public ModifyMember(JButton homeButton, JButton closeButton, JPanel borderPanel) {
		initialize(homeButton,closeButton,borderPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton homeButton, JButton closeButton,JPanel borderPanel) {
		frame = new JFrame();
		frame.setBounds(420, 120, 539, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	    Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);	
	    
	    this.homeButton = homeButton;
	    this.closeButton = closeButton;
	    this.borderPanel = borderPanel;
	    
	    JPanel panel = new JPanel();
		panel.setBounds(0, 0, 525, 457);
		panel.setBackground(new Color(255,255,255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 501, 437);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
	    panel_2.setBounds(122, 10, 271, 39);
	    panel_1.add(panel_2);
	    panel_2.setLayout(null);
	    panel_2.setBorder(border);
	    panel_2.setBackground(new Color(255,255,255));
	   
	    JLabel lblNewLabel = new JLabel("POTEN STUDY CAFE");
	    lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
	    lblNewLabel.setBounds(55, 6, 167, 28);
	    panel_2.add(lblNewLabel);
	    lblNewLabel.setForeground(new Color(114,166,255));
	    
	   JLabel lblNewLabel_1 = new JLabel("전  화  번  호  : ");
	   lblNewLabel_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1.setBounds(25, 110, 184, 28);
	   panel_1.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel_1_1 = new JLabel("비  밀  번  호  : ");
	   lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1.setBounds(25, 160, 184, 28);
	   panel_1.add(lblNewLabel_1_1);
	   
	   JLabel lblNewLabel_1_2 = new JLabel("이    메     일  :");
	   lblNewLabel_1_2.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_2.setBounds(25, 210, 184, 28);
	   panel_1.add(lblNewLabel_1_2);
	   
	   JLabel lblNewLabel_1_3 = new JLabel("성            별  : ");
	   lblNewLabel_1_3.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_3.setBounds(25, 260, 184, 28);
	   panel_1.add(lblNewLabel_1_3);
	   
	   JLabel lblNewLabel_1_4 = new JLabel("생  년  월  일  : ");
	   lblNewLabel_1_4.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_4.setBounds(25, 310, 184, 28);
	   panel_1.add(lblNewLabel_1_4);

	   RoundedButton2 okbutton = new RoundedButton2("수정");
	   okbutton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Post po = new Post();
	        JSONObject data = new JSONObject();
			try {
				data.put("phone", phonetext.getText());
				data.put("pw", pwtext.getText());
				data.put("email", emailtext.getText());
				data.put("gender", gendertext.getText());
				data.put("birth", birthtext.getText());
				data.put("phone1", Click.phone);
		        JSONObject check = po.jsonpost("/UpdateMember", data);
		   		if((check.get("check")).equals("true"))
					{
		   				frame.dispose();
			      		Memberpanel me = new Memberpanel(homeButton,closeButton,borderPanel);
			            switchPanel(me);
		   				Message ms = new Message("  수정이 완료되었습니다!");
		   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
			        }
		   		else {
		   			frame.dispose();
		   			Message ms = new Message("  수정을 실패하였습니다!");
		 			ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
		   		}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   	}
	   });
	   okbutton.setFont(new Font("굴림", Font.BOLD, 15));
	   okbutton.setText("수정");
	   okbutton.setBounds(108, 375, 95, 39);
	   panel_1.add(okbutton);
	   
	   RoundedButton2 deletebutton = new RoundedButton2("삭제");
	   deletebutton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Post po = new Post();
	        JSONObject data = new JSONObject();
			try {
				data.put("phone1", Click.phone);
		        JSONObject check = po.jsonpost("/DeleteMember", data);
		   		if((check.get("check")).equals("true"))
					{
		   				frame.dispose();
			      		Memberpanel me = new Memberpanel(homeButton,closeButton,borderPanel);
			            switchPanel(me);
		   				Message ms = new Message("  삭제가 완료되었습니다!");
		   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
			        }
		   		else {
		   			frame.dispose();
		   			Message ms = new Message("  삭제를 실패하였습니다!");
		 			ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
		   		}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   	}
	   });
	   deletebutton.setText("삭제");
	   deletebutton.setFont(new Font("굴림", Font.BOLD, 15));
	   deletebutton.setBounds(298, 375, 95, 39);
	   deletebutton.setBackgroundColor(new Color(255,128,128));
	   panel_1.add(deletebutton);

	   phonetext = new JTextField();
	   phonetext.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		phonetext.setFocusable(true);
		   	}
		   });
		   phonetext.setFocusable(false);
		   phonetext.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		phonetext.setForeground(new Color(0,0,0));
		   		phonetext.requestFocusInWindow();
		   	}
		   });
	   phonetext.setFont(new Font("굴림", Font.BOLD, 12));
	   phonetext.setBounds(197, 112, 263, 28);
	   panel_1.add(phonetext);
	   phonetext.setColumns(10);
	   phonetext.setBorder(border);
	   
	   pwtext = new JTextField();
	   pwtext.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		pwtext.setFocusable(true);
		   	}
		   });
		   pwtext.setFocusable(false);
		   pwtext.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		pwtext.setForeground(new Color(0,0,0));
		   		pwtext.requestFocusInWindow();
		   	}
		   });
	   pwtext.setFont(new Font("굴림", Font.BOLD, 12));
	   pwtext.setColumns(10);
	   pwtext.setBounds(197, 162, 263, 28);
	   panel_1.add(pwtext);
	   pwtext.setBorder(border);
	   
	   emailtext = new JTextField();
	   emailtext.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		emailtext.setFocusable(true);
		   	}
		   });
		   emailtext.setFocusable(false);
		   emailtext.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		emailtext.setForeground(new Color(0,0,0));
		   		emailtext.requestFocusInWindow();
		   	}
		   });
	   emailtext.setFont(new Font("굴림", Font.BOLD, 12));
	   emailtext.setColumns(10);
	   emailtext.setBounds(197, 212, 263, 28);
	   panel_1.add(emailtext);
	   emailtext.setBorder(border);
	   
	   gendertext = new JTextField();
	   gendertext.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		gendertext.setFocusable(true);
		   	}
		   });
		   gendertext.setFocusable(false);
		   gendertext.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		gendertext.setForeground(new Color(0,0,0));
		   		gendertext.requestFocusInWindow();
		   	}
		   });
	   gendertext.setFont(new Font("굴림", Font.BOLD, 12));
	   gendertext.setColumns(10);
	   gendertext.setBounds(197, 262, 263, 28);
	   panel_1.add(gendertext);
	   gendertext.setBorder(border);
	   
	   birthtext = new JTextField();
	   birthtext.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		birthtext.setFocusable(true);
		   	}
		   });
		   birthtext.setFocusable(false);
		   birthtext.addFocusListener(new FocusAdapter() {
		   	@Override
		   	public void focusGained(FocusEvent e) {
		   		birthtext.setForeground(new Color(0,0,0));
		   		birthtext.requestFocusInWindow();
		   	}
		   });
	   birthtext.setFont(new Font("굴림", Font.BOLD, 12));
	   birthtext.setColumns(10);
	   birthtext.setBounds(197, 312, 263, 28);
	   panel_1.add(birthtext);
	   birthtext.setBorder(border);
	   
		JButton closebutton1 = new JButton("");
		closebutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		closebutton1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
		closebutton1.setBounds(465, 10, 24, 24);
		panel_1.add(closebutton1);
		closebutton1.setBorderPainted(false); 
		closebutton1.setContentAreaFilled(false);
		closebutton1.setFocusPainted(false);
	
		 Post po = new Post();
        JSONObject data = new JSONObject();
		try {
			data.put("phone", Click.phone);
	        JSONObject check = po.jsonpost("/FindMember", data);
	   		if((check.get("check")).equals("true"))
				{
	   				String phone = check.getString("phone");
	   				String pw = check.getString("pw");
	   				String email = check.getString("email");
	   				String gender = check.getString("gender");
	   				String birth = check.getString("birth");
	   				phonetext.setText(phone);
	   				pwtext.setText(pw);
	   				emailtext.setText(email);
	   				gendertext.setText(gender);
	   				birthtext.setText(birth);
	   				
	   				phonetext.setForeground(new Color(151,148,154));
	   				pwtext.setForeground(new Color(151,148,154));
	   				emailtext.setForeground(new Color(151,148,154));
	   				gendertext.setForeground(new Color(151,148,154));
	   				birthtext.setForeground(new Color(151,148,154));
		        }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
    private void switchPanel(JPanel newPanel) {
        borderPanel.removeAll();
        borderPanel.add(homeButton);
        borderPanel.add(closeButton);
        borderPanel.add(newPanel);
        borderPanel.revalidate();
        borderPanel.repaint();
    }
}
