package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Findpw {

	private JFrame frame;
	private JTextField phonetext;
	private JTextField emailtext;
    int focusTextFeild = 1;
    private JTextField pwtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Findpw window = new Findpw();
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
	public Findpw() {
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
	      JPanel mainpanel = new JPanel();
	      mainpanel.setBounds(0, 0, 856, 613);
	      frame.getContentPane().add(mainpanel);
	      mainpanel.setLayout(null);
	      mainpanel.setBackground(new Color(255,255,255));
	      
	      JPanel borderpanel = new JPanel();
	      borderpanel.setBounds(10, 10, 837, 593);
	      mainpanel.add(borderpanel); 
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
	      
	      Border border2 =  BorderFactory.createLineBorder(new Color(114,166,250),2);
	      JPanel servepanel = new JPanel();
	      servepanel.setBorder(border2);
	      servepanel.setBounds(12, 100, 813, 244);
	      borderpanel.add(servepanel);
	      servepanel.setBackground(new Color(255,255,255));
	      servepanel.setLayout(null);
	      
	      JPanel keypadpanel = new JPanel();
	      keypadpanel.setBounds(12, 354, 813, 229);
	      keypadpanel.setBorder(border2);
	      borderpanel.add(keypadpanel);
	      keypadpanel.setLayout(null);
	      keypadpanel.setBackground(new Color(217,231,255));
	      
	      JPanel doublekeypadpanel_1 = new JPanel();
	      doublekeypadpanel_1.setBounds(12, 10, 789, 208);
	      keypadpanel.add(doublekeypadpanel_1);
	      doublekeypadpanel_1.setLayout(null);
	      doublekeypadpanel_1.setVisible(false);
	      doublekeypadpanel_1.setBackground(new Color(217,231,255));
	      
	      JPanel doublekeypadpanel = new JPanel();
	      doublekeypadpanel.setBounds(12, 10, 789, 208);
	      keypadpanel.add(doublekeypadpanel);
	      doublekeypadpanel.setLayout(null);
	      doublekeypadpanel.setVisible(true);
	      doublekeypadpanel.setBackground(new Color(217,231,255));
	      
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
			
			JLabel namelabel = new JLabel("전화번호 : ");
		    namelabel.setFont(new Font("굴림", Font.BOLD, 20));
		    namelabel.setForeground(new Color(114, 166, 255));
		    namelabel.setBounds(44, 62, 110, 24);
		    servepanel.add(namelabel);
		    
		    JLabel namelabel_1 = new JLabel("E - mail : ");
		    namelabel_1.setForeground(new Color(114, 166, 255));
		    namelabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		    namelabel_1.setBounds(44, 142, 110, 24);
		    servepanel.add(namelabel_1);
		    
		    phonetext = new JTextField();
		    phonetext.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		focusTextFeild = 1;
		    	} 
		    });
		    phonetext.setBounds(169, 65, 240, 21);
		    servepanel.add(phonetext);
		    phonetext.setColumns(10);
			phonetext.setBorder(border);
		    
		    emailtext = new JTextField();
		    emailtext.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseClicked(MouseEvent e) {
		    		focusTextFeild = 2;
		    	} 
		    });
		    emailtext.setColumns(10);
		    emailtext.setBounds(169, 145, 126, 21);
		    servepanel.add(emailtext);
			emailtext.setBorder(border);
		    
		    JPanel pwpanel = new JPanel();
		    pwpanel.setBounds(504, 10, 299, 224);
		    servepanel.add(pwpanel);
		    pwpanel.setBorder(border);
		    pwpanel.setBackground(new Color(255,255,255));
		    pwpanel.setLayout(null);
		    
		    JPanel panel1 = new JPanel();
		    panel1.setBounds(12, 10, 275, 204);
		    pwpanel.add(panel1);
		    panel1.setLayout(null);
		    panel1.setBackground(new Color(255,255,255));
		    
		    pwtext = new JTextField();
		    pwtext.setBounds(24, 102, 205, 21);
		    panel1.add(pwtext);
		    pwtext.setColumns(10); 
		    pwtext. setEditable(false);
			pwtext.setBorder(border);
		    
		    JLabel Label_1 = new JLabel("회원님의 비밀번호는");
		    Label_1.setForeground(new Color(114, 166, 255));
		    Label_1.setFont(new Font("굴림", Font.BOLD, 20));
		    Label_1.setBounds(24, 49, 251, 54);
		    panel1.add(Label_1);
		    panel1.setVisible(false);
		    
		    JLabel Label_1_1 = new JLabel("입니다.");
		    Label_1_1.setForeground(new Color(114, 166, 255));
		    Label_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		    Label_1_1.setBounds(24, 133, 251, 42);
		    panel1.add(Label_1_1);
		    
		    JPanel panel = new JPanel();
		    panel.setBounds(12, 10, 275, 204);
		    pwpanel.add(panel);
		    panel.setLayout(null);
		    panel.setBackground(new Color(255,255,255));
		    panel.setVisible(false);
		    
		    JLabel Label = new JLabel("존재하지 않는 회원입니다.");
		    Label.setFont(new Font("굴림", Font.BOLD, 20));
		    Label.setBounds(12, 78, 251, 54);
		    panel.add(Label);
		    Label.setForeground(new Color(114,166,255));
		    
	      JComboBox emailcombobox = new JComboBox();
	      emailcombobox.setModel(new DefaultComboBoxModel(new String[] {"gmail.com", "naver.com", "daum.net", "hanmail.net"}));
	      emailcombobox.setFont(new Font("굴림", Font.BOLD, 12));
	      emailcombobox.setBounds(321, 145, 88, 23);
	      servepanel.add(emailcombobox);
	      
	      JLabel lblNewLabel = new JLabel("@");
	      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
	      lblNewLabel.setBounds(299, 149, 20, 15);
	      servepanel.add(lblNewLabel);
		    
		    RoundedButton2 one_10_9_6_1_2_1_1_1 = new RoundedButton2("비밀번호 찾기");
		    one_10_9_6_1_2_1_1_1.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String phone = phonetext.getText();
		    		String email1 = emailtext.getText();
		    		String email2 = emailcombobox.getSelectedItem().toString();
		    		String email = email1 + "@" + email2;
		    		
		    		JSONObject data = new JSONObject();
		    		try {
						data.put("phone", phone);
						data.put("email", email);
						Post po = new Post();
						JSONObject check = po.jsonpost("/Findpw", data);
						if((check.get("check")).equals("true"))
						{ 
							String result = check.getString("pw");
							pwtext.setText(result);
							panel.setVisible(false);
							panel1.setVisible(true);
						}
						else if((check.get("check").equals("false")))
						{
							panel.setVisible(true);
							panel1.setVisible(false);
						}
		    		} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    });
		    one_10_9_6_1_2_1_1_1.setText("확인");
		    one_10_9_6_1_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		    one_10_9_6_1_2_1_1_1.setBounds(411, 195, 81, 39);
		    servepanel.add(one_10_9_6_1_2_1_1_1);
		    
		    
		    
		    RoundedButton2 rndbtn2Q = new RoundedButton2("Q");
		      rndbtn2Q.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Q";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Q";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}

		      	}
		      });
		      rndbtn2Q.setText("Q");
		      rndbtn2Q.setFont(new Font("굴림", Font.BOLD, 20));
		      rndbtn2Q.setBounds(89, 55, 43, 43);
		      doublekeypadpanel_1.add(rndbtn2Q);
		      
		      RoundedButton2 one_1_1 = new RoundedButton2("W");
		      one_1_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "W";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "W";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_1_1.setText("W");
		      one_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_1_1.setBounds(144, 55, 43, 43);
		      doublekeypadpanel_1.add(one_1_1);
		      
		      RoundedButton2 one_2_1 = new RoundedButton2("E");
		      one_2_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "E";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "E";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_2_1.setText("E");
		      one_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_2_1.setBounds(199, 55, 43, 43);
		      doublekeypadpanel_1.add(one_2_1);
		      
		      RoundedButton2 one_3_1 = new RoundedButton2("R");
		      one_3_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "R";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "R";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_3_1.setText("R");
		      one_3_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_3_1.setBounds(254, 55, 43, 43);
		      doublekeypadpanel_1.add(one_3_1);
		      
		      RoundedButton2 one_4_1 = new RoundedButton2("T");
		      one_4_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "T";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "T";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_4_1.setText("T");
		      one_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_4_1.setBounds(309, 55, 43, 43);
		      doublekeypadpanel_1.add(one_4_1);
		      
		      RoundedButton2 one_5_1 = new RoundedButton2("Y");
		      one_5_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Y";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Y";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_5_1.setText("Y");
		      one_5_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_5_1.setBounds(364, 55, 43, 43);
		      doublekeypadpanel_1.add(one_5_1);
		      
		      RoundedButton2 one_6_1 = new RoundedButton2("U");
		      one_6_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "U";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "U";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_6_1.setText("U");
		      one_6_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_6_1.setBounds(419, 55, 43, 43);
		      doublekeypadpanel_1.add(one_6_1);
		      
		      RoundedButton2 one_7_1 = new RoundedButton2("I");
		      one_7_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "I";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "I";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_7_1.setText("I");
		      one_7_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_7_1.setBounds(474, 55, 43, 43);
		      doublekeypadpanel_1.add(one_7_1);
		      
		      RoundedButton2 one_8_1 = new RoundedButton2("O");
		      one_8_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "O";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "O";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_8_1.setText("O");
		      one_8_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_8_1.setBounds(529, 55, 43, 43);
		      doublekeypadpanel_1.add(one_8_1);
		      
		      RoundedButton2 one_9_1 = new RoundedButton2("p");
		      one_9_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "P";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "P";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_9_1.setText("P");
		      one_9_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_9_1.setBounds(584, 55, 43, 43);
		      doublekeypadpanel_1.add(one_9_1);
		      
		      RoundedButton2 one_10_10 = new RoundedButton2("A");
		      one_10_10.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "A";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "A";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_10.setText("A");
		      one_10_10.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_10.setBounds(99, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_10);
		      
		      RoundedButton2 one_10_1_1 = new RoundedButton2("S");
		      one_10_1_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "S";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText);
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "S";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_1_1.setText("S");
		      one_10_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_1_1.setBounds(154, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_1_1);
		      
		      RoundedButton2 one_10_2_1 = new RoundedButton2("D");
		      one_10_2_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "D";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "D";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_2_1.setText("D");
		      one_10_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_2_1.setBounds(209, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_2_1);
		      
		      RoundedButton2 one_10_3_1 = new RoundedButton2("F");
		      one_10_3_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "F";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "F";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_3_1.setText("F");
		      one_10_3_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_3_1.setBounds(264, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_3_1);
		      
		      RoundedButton2 one_10_4_1 = new RoundedButton2("G");
		      one_10_4_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "G";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "G";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_4_1.setText("G");
		      one_10_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_4_1.setBounds(319, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_4_1);
		      
		      RoundedButton2 one_10_5_1 = new RoundedButton2("H");
		      one_10_5_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "H";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "H";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_5_1.setText("H");
		      one_10_5_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_5_1.setBounds(374, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_5_1);
		      
		      RoundedButton2 one_10_6_1 = new RoundedButton2("J");
		      one_10_6_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "J";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "J";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_6_1.setText("J");
		      one_10_6_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_6_1.setBounds(429, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_6_1);
		      
		      RoundedButton2 one_10_7_1 = new RoundedButton2("K");
		      one_10_7_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "K";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "K";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_7_1.setText("K");
		      one_10_7_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_7_1.setBounds(484, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_7_1);
		      
		      RoundedButton2 one_10_8_1 = new RoundedButton2("ㅣ");
		      one_10_8_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "L";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "L";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_8_1.setText("L");
		      one_10_8_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_8_1.setBounds(539, 108, 43, 43);
		      doublekeypadpanel_1.add(one_10_8_1);
		      
		      RoundedButton2 one_10_9_8 = new RoundedButton2("Z");
		      one_10_9_8.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Z";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "Z";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_8.setText("Z");
		      one_10_9_8.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_8.setBounds(109, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_8);
		      
		      RoundedButton2 one_10_9_1_1 = new RoundedButton2("X");
		      one_10_9_1_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "X";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "X";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_1_1.setText("X");
		      one_10_9_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_1_1.setBounds(164, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_1_1);
		      
		      RoundedButton2 one_10_9_2_1 = new RoundedButton2("C");
		      one_10_9_2_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "C";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "C";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_2_1.setText("C");
		      one_10_9_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_2_1.setBounds(219, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_2_1);
		      
		      RoundedButton2 one_10_9_3_1 = new RoundedButton2("V");
		      one_10_9_3_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "V";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "V";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_3_1.setText("V");
		      one_10_9_3_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_3_1.setBounds(274, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_3_1);
		      
		      RoundedButton2 one_10_9_4_1 = new RoundedButton2("B");
		      one_10_9_4_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "B";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "B";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_4_1.setText("B");
		      one_10_9_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_4_1.setBounds(329, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_4_1);
		      
		      RoundedButton2 one_10_9_5_1 = new RoundedButton2("N");
		      one_10_9_5_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "N";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "N";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_5_1.setText("N");
		      one_10_9_5_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_5_1.setBounds(384, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_5_1);
		      
		      RoundedButton2 one_10_9_6_2 = new RoundedButton2("M");
		      one_10_9_6_2.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "M";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "M";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_10_9_6_2.setText("M");
		      one_10_9_6_2.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_6_2.setBounds(439, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_6_2);
		      
		      RoundedButton2 one_10_9_6_1_3 = new RoundedButton2("Shift ↑");
		      one_10_9_6_1_3.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		doublekeypadpanel_1.setVisible(false);
		      		doublekeypadpanel.setVisible(true);
		      	}
		      });
		      one_10_9_6_1_3.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_6_1_3.setBounds(549, 163, 178, 43);
		      doublekeypadpanel_1.add(one_10_9_6_1_3);
		      
		      RoundedButton2 one_10_9_7_1 = new RoundedButton2("한/영");
		      one_10_9_7_1.setFont(new Font("굴림", Font.BOLD, 16));
		      one_10_9_7_1.setBounds(494, 163, 43, 43);
		      doublekeypadpanel_1.add(one_10_9_7_1);
		      
		      RoundedButton2 one_10_9_6_1_2_2 = new RoundedButton2("Enter");
		      one_10_9_6_1_2_2.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
		      			focusTextFeild = 2;
		      		}
		      		else if(focusTextFeild == 2)
		      		{
		      			focusTextFeild = 1;
		      		}
		      	}
		      });
		      one_10_9_6_1_2_2.setText("Enter");
		      one_10_9_6_1_2_2.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_6_1_2_2.setBounds(594, 108, 133, 43);
		      doublekeypadpanel_1.add(one_10_9_6_1_2_2);
		      
		      RoundedButton2 one_11_1_2 = new RoundedButton2("@");
		      one_11_1_2.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "@";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "@";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_1_2.setBounds(137, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_1_2);
		      
		      RoundedButton2 one_11_2_1 = new RoundedButton2("#");
		      one_11_2_1.addActionListener(new ActionListener() {
		    	    public void actionPerformed(ActionEvent e) {
		    	    	if(focusTextFeild == 1)
			      		{
					  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
							String newText = currentText + "#";  // 기존 문자열에 "~" 추가
							phonetext.setText(newText); 
			      		}
			      		else if(focusTextFeild == 2)
			      		{
					  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
							String newText = currentText + "#";  // 기존 문자열에 "~" 추가
							emailtext.setText(newText); 
			      		}
		    	    }
		      });
		      one_11_2_1.setText("#");
		      one_11_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_2_1.setBounds(192, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_2_1);
		      
		      RoundedButton2 one_11_3_1 = new RoundedButton2("$");
		      one_11_3_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "$";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "$";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_3_1.setText("$");
		      one_11_3_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_3_1.setBounds(247, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_3_1);
		      
		      RoundedButton2 one_11_4_1 = new RoundedButton2("%");
		      one_11_4_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "%";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "%";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_4_1.setText("%");
		      one_11_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_4_1.setBounds(302, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_4_1);
		      
		      RoundedButton2 one_11_5_1 = new RoundedButton2("^");
		      one_11_5_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "^";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "^";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_5_1.setText("^");
		      one_11_5_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_5_1.setBounds(357, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_5_1);
		      
		      RoundedButton2 one_11_6_1 = new RoundedButton2("&");
		      one_11_6_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "&";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "&";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_6_1.setText("&");
		      one_11_6_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_6_1.setBounds(412, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_6_1);
		      
		      RoundedButton2 one_11_7_1 = new RoundedButton2("*");
		      one_11_7_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "*";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "*";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_7_1.setText("*");
		      one_11_7_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_7_1.setBounds(467, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_7_1);
		      
		      RoundedButton2 one_11_8_1 = new RoundedButton2("(");
		      one_11_8_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "(";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "(";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_8_1.setText("(");
		      one_11_8_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_8_1.setBounds(522, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_8_1);
		      
		      RoundedButton2 one_11_9_1 = new RoundedButton2(")");
		      one_11_9_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + ")";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + ")";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_9_1.setText(")");
		      one_11_9_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_9_1.setBounds(577, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_9_1);
		      
		      RoundedButton2 one_10_9_6_1_2_1_1 = new RoundedButton2("Back");
		      one_10_9_6_1_2_1_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
						String currentText = phonetext.getText();
						if (!currentText.isEmpty()) {
						    String newText = currentText.substring(0, currentText.length() - 1);
						    phonetext.setText(newText);
						}
		      		}
		      		else if(focusTextFeild == 2)
		      		{
						String currentText = emailtext.getText();
						if (!currentText.isEmpty()) {
						    String newText = currentText.substring(0, currentText.length() - 1);
						    emailtext.setText(newText);
						}
		      		}
		      	
		      	}
		      });
		      one_10_9_6_1_2_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_10_9_6_1_2_1_1.setBounds(632, 2, 95, 43);
		      doublekeypadpanel_1.add(one_10_9_6_1_2_1_1);
		      
		      RoundedButton2 one_11_1_1_1 = new RoundedButton2("!");
		      one_11_1_1_1.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "!";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "!";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		      	}
		      });
		      one_11_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		      one_11_1_1_1.setBounds(82, 2, 43, 43);
		      doublekeypadpanel_1.add(one_11_1_1_1);
		      
		    
			  RoundedButton2 one = new RoundedButton2("q");
			  one.setText("q");
			  one.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "q";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "q";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
			  	}
			  });
			  one.setFont(new Font("굴림", Font.BOLD, 20));
			  one.setBounds(89, 55, 43, 43);
			  doublekeypadpanel.add(one);
			  
			  
			  RoundedButton2 one_1 = new RoundedButton2("w");
			  one_1.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "w";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "w";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
			  	}
			  });
			  one_1.setText("w");
			  one_1.setFont(new Font("굴림", Font.BOLD, 20));
			  one_1.setBounds(144, 55, 43, 43);
			  doublekeypadpanel.add(one_1);
			  
			  RoundedButton2 one_2 = new RoundedButton2("e");
			  one_2.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "e";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "e";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
			  	}
			  });
			  one_2.setText("e");
			  one_2.setFont(new Font("굴림", Font.BOLD, 20));
			  one_2.setBounds(199, 55, 43, 43);
			  doublekeypadpanel.add(one_2);
			  
			  RoundedButton2 one_3 = new RoundedButton2("r");
			  one_3.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "r";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "r";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
			  	}
			  });
			  one_3.setText("r");
			  one_3.setFont(new Font("굴림", Font.BOLD, 20));
			  one_3.setBounds(254, 55, 43, 43);
			  doublekeypadpanel.add(one_3);
			  
			  RoundedButton2 one_4 = new RoundedButton2("t");
			  one_4.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "t";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "t";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
			  	}
			  });
			  one_4.setText("t");
			  one_4.setFont(new Font("굴림", Font.BOLD, 20));
			  one_4.setBounds(309, 55, 43, 43);
			  doublekeypadpanel.add(one_4);
			  
		     RoundedButton2 one_5 = new RoundedButton2("y");
		     one_5.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "y";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "y";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_5.setText("y");
		     one_5.setFont(new Font("굴림", Font.BOLD, 20));
		     one_5.setBounds(364, 55, 43, 43);
		     doublekeypadpanel.add(one_5);
		     
		     RoundedButton2 one_6 = new RoundedButton2("u");
		     one_6.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "u";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "u";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_6.setText("u");
		     one_6.setFont(new Font("굴림", Font.BOLD, 20));
		     one_6.setBounds(419, 55, 43, 43);
		     doublekeypadpanel.add(one_6);
		     
		     RoundedButton2 one_7 = new RoundedButton2("i");
		     one_7.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "i";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "i";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_7.setText("i");
		     one_7.setFont(new Font("굴림", Font.BOLD, 20));
		     one_7.setBounds(474, 55, 43, 43);
		     doublekeypadpanel.add(one_7);
		     
		     RoundedButton2 one_8 = new RoundedButton2("o");
		     one_8.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "o";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "o";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_8.setText("o");
		     one_8.setFont(new Font("굴림", Font.BOLD, 20));
		     one_8.setBounds(529, 55, 43, 43);
		     doublekeypadpanel.add(one_8);
		     
		     RoundedButton2 one_9 = new RoundedButton2("p");
		     one_9.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "p";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "p";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_9.setText("p");
		     one_9.setFont(new Font("굴림", Font.BOLD, 20));
		     one_9.setBounds(584, 55, 43, 43);
		     doublekeypadpanel.add(one_9);
		     
		     RoundedButton2 one_10 = new RoundedButton2("a");
		     one_10.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "a";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "a";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10.setText("a");
		     one_10.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10.setBounds(99, 108, 43, 43);
		     doublekeypadpanel.add(one_10);
		     
		     RoundedButton2 one_10_1 = new RoundedButton2("s");
		     one_10_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "s";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "s";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_1.setText("s");
		     one_10_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_1.setBounds(154, 108, 43, 43);
		     doublekeypadpanel.add(one_10_1);
		     
		     RoundedButton2 one_10_2 = new RoundedButton2("d");
		     one_10_2.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "d";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "d";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_2.setText("d");
		     one_10_2.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_2.setBounds(209, 108, 43, 43);
		     doublekeypadpanel.add(one_10_2);
		     
		     RoundedButton2 one_10_3 = new RoundedButton2("f");
		     one_10_3.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "f";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "f";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_3.setText("f");
		     one_10_3.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_3.setBounds(264, 108, 43, 43);
		     doublekeypadpanel.add(one_10_3);
		     
		     RoundedButton2 one_10_4 = new RoundedButton2("g");
		     one_10_4.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "g";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "g";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_4.setText("g");
		     one_10_4.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_4.setBounds(319, 108, 43, 43);
		     doublekeypadpanel.add(one_10_4);
		     
		     RoundedButton2 one_10_5 = new RoundedButton2("h");
		     one_10_5.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "h";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "h";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_5.setText("h");
		     one_10_5.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_5.setBounds(374, 108, 43, 43);
		     doublekeypadpanel.add(one_10_5);
		     
		     RoundedButton2 one_10_6 = new RoundedButton2("j");
		     one_10_6.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "j";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "j";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_6.setText("j");
		     one_10_6.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_6.setBounds(429, 108, 43, 43);
		     doublekeypadpanel.add(one_10_6);
		     
		     RoundedButton2 one_10_7 = new RoundedButton2("k");
		     one_10_7.setText("k");
		     one_10_7.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "k";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "k";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_7.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_7.setBounds(484, 108, 43, 43);
		     doublekeypadpanel.add(one_10_7);
		     
		     RoundedButton2 one_10_8 = new RoundedButton2("ㅣ");
		     one_10_8.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "l";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "l";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_8.setText("l");
		     one_10_8.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_8.setBounds(539, 108, 43, 43);
		     doublekeypadpanel.add(one_10_8);
		     
		     RoundedButton2 one_10_9 = new RoundedButton2("z");
		     one_10_9.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "z";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "z";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9.setText("z");
		     one_10_9.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9.setBounds(109, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9);
		     
		     RoundedButton2 one_10_9_1 = new RoundedButton2("x");
		     one_10_9_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "x";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "x";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_1.setText("x");
		     one_10_9_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_1.setBounds(164, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_1);
		     
		     RoundedButton2 one_10_9_2 = new RoundedButton2("c");
		     one_10_9_2.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "c";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "c";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_2.setText("c");
		     one_10_9_2.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_2.setBounds(219, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_2);
		     
		     RoundedButton2 one_10_9_3 = new RoundedButton2("v");
		     one_10_9_3.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "v";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "v";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_3.setText("v");
		     one_10_9_3.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_3.setBounds(274, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_3);
		     
		     RoundedButton2 one_10_9_4 = new RoundedButton2("b");
		     one_10_9_4.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "b";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "b";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_4.setText("b");
		     one_10_9_4.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_4.setBounds(329, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_4);
		     
		     RoundedButton2 one_10_9_5 = new RoundedButton2("n");
		     one_10_9_5.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "n";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "n";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_5.setText("n");
		     one_10_9_5.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_5.setBounds(384, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_5);
		     
		     RoundedButton2 one_10_9_6 = new RoundedButton2("ㅡ");
		     one_10_9_6.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "m";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "m";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_10_9_6.setText("m");
		     one_10_9_6.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_6.setBounds(439, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_6);
		     
		     RoundedButton2 one_10_9_6_1 = new RoundedButton2("Shift ↑");
		     one_10_9_6_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		doublekeypadpanel.setVisible(false);
		     		doublekeypadpanel_1.setVisible(true);
		     	}
		     });
		     one_10_9_6_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_6_1.setBounds(549, 163, 178, 43);
		     doublekeypadpanel.add(one_10_9_6_1);
		     
		     RoundedButton2 one_10_9_7 = new RoundedButton2("한/영");
		     one_10_9_7.setFont(new Font("굴림", Font.BOLD, 16));
		     one_10_9_7.setBounds(494, 163, 43, 43);
		     doublekeypadpanel.add(one_10_9_7);
		     
		     RoundedButton2 one_10_9_6_1_2 = new RoundedButton2("Enter");
		      one_10_9_6_1_2.addActionListener(new ActionListener() {
			      	public void actionPerformed(ActionEvent e) {
			      		if(focusTextFeild == 1)
			      		{
			      			focusTextFeild = 2;
			      		}
			      		else if(focusTextFeild == 2)
			      		{
			      			focusTextFeild = 1;
			      		}
			      	}
			      });
		     one_10_9_6_1_2.setText("Enter");
		     one_10_9_6_1_2.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_6_1_2.setBounds(594, 108, 133, 43);
		     doublekeypadpanel.add(one_10_9_6_1_2);
		     
		     RoundedButton2 one_11_1 = new RoundedButton2("2");
		     one_11_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "2";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "2";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_1.setBounds(137, 2, 43, 43);
		     doublekeypadpanel.add(one_11_1);
		     
		     RoundedButton2 one_11_2 = new RoundedButton2("3");
		     one_11_2.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "3";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "3";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_2.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_2.setBounds(192, 2, 43, 43);
		     doublekeypadpanel.add(one_11_2);
		     
		     RoundedButton2 one_11_3 = new RoundedButton2("4");
		     one_11_3.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "4";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "4";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_3.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_3.setBounds(247, 2, 43, 43);
		     doublekeypadpanel.add(one_11_3);
		     
		     RoundedButton2 one_11_4 = new RoundedButton2("5");
		     one_11_4.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "5";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "5";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_4.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_4.setBounds(302, 2, 43, 43);
		     doublekeypadpanel.add(one_11_4);
		     
		     RoundedButton2 one_11_5 = new RoundedButton2("6");
		     one_11_5.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "6";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "6";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_5.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_5.setBounds(357, 2, 43, 43);
		     doublekeypadpanel.add(one_11_5);
		     
		     RoundedButton2 one_11_6 = new RoundedButton2("7");
		     one_11_6.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "7";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "7";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_6.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_6.setBounds(412, 2, 43, 43);
		     doublekeypadpanel.add(one_11_6);
		     
		     RoundedButton2 one_11_7 = new RoundedButton2("8");
		     one_11_7.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "8";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "8";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_7.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_7.setBounds(467, 2, 43, 43);
		     doublekeypadpanel.add(one_11_7);
		     
		     RoundedButton2 one_11_8 = new RoundedButton2("9");
		     one_11_8.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "9";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "9";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_8.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_8.setBounds(522, 2, 43, 43);
		     doublekeypadpanel.add(one_11_8);
		     
		     RoundedButton2 one_11_9 = new RoundedButton2("0");
		     one_11_9.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {      		
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "0";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "0";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_9.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_9.setBounds(577,2, 43, 43);
		     doublekeypadpanel.add(one_11_9);
		     
		     RoundedButton2 one_10_9_6_1_2_1 = new RoundedButton2("Back");
		     one_10_9_6_1_2_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
						String currentText = phonetext.getText();
						if (!currentText.isEmpty()) {
						    String newText = currentText.substring(0, currentText.length() - 1);
						    phonetext.setText(newText);
						}
		      		}
		      		else if(focusTextFeild == 2)
		      		{
						String currentText = emailtext.getText();
						if (!currentText.isEmpty()) {
						    String newText = currentText.substring(0, currentText.length() - 1);
						    emailtext.setText(newText);
						}
		      		}
				
		     	}
		     });
		     one_10_9_6_1_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_10_9_6_1_2_1.setBounds(632, 2, 95, 43);
		     doublekeypadpanel.add(one_10_9_6_1_2_1);
		     
		     RoundedButton2 one_11_1_1 = new RoundedButton2("1");
		     one_11_1_1.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		if(focusTextFeild == 1)
		      		{
				  		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "1";  // 기존 문자열에 "~" 추가
						phonetext.setText(newText); 
		      		}
		      		else if(focusTextFeild == 2)
		      		{
				  		String currentText = emailtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
						String newText = currentText + "1";  // 기존 문자열에 "~" 추가
						emailtext.setText(newText); 
		      		}
		     	}
		     });
		     one_11_1_1.setText("1");
		     one_11_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		     one_11_1_1.setBounds(82, 2, 43, 43);
		     doublekeypadpanel.add(one_11_1_1);
	}
}
