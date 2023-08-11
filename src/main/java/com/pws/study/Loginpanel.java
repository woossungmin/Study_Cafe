package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Loginpanel extends JPanel {
	private JTextField phonetext;
	private JTextField pwtext;
	private JPanel Keypadpanel;
	private JLabel phonelabel;
	private JLabel pwlabel;
	private JLabel label;
	private JButton Loginbutton;
    int focusTextFeild = 0;
	/**
	 * Create the panel.
	 */
	public Loginpanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	if (focusTextFeild != 0) {  // 포커스가 처음 잡혔을 때만 조정
			    		Keypadpanel.setVisible(false);
	 			        focusTextFeild = 0;
	 			        adjustUIElements(+50);
	 	      		}
			}
		});
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(23, 60, 813, 603);
		//setBorder(border);
		
		phonelabel = new JLabel("전 화 번 호 : ");
		phonelabel.setFont(new Font("굴림", Font.BOLD, 20));
		phonelabel.setForeground(new Color(114, 166, 255));
		phonelabel.setBounds(139, 230, 133, 24);
		add(phonelabel);
      
		pwlabel = new JLabel("카 드  번 호 : "); 
		pwlabel.setForeground(new Color(114, 166, 255));
		pwlabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwlabel.setBounds(139, 282, 133, 24);
		add(pwlabel);
	      
	      JLabel projectname = new JLabel("POTEN STUDY CAFE");
	      projectname.setFont(new Font("굴림", Font.BOLD, 35));
	      projectname.setForeground(new Color(114, 166, 255));
	      projectname.setBounds(218, 10, 369, 43);
	      add(projectname);
	       
		
 	  	 Loginbutton = new RoundedButton2("로그인");
 		 Loginbutton.setText("Login");
 		 Loginbutton.setFont(new Font("굴림", Font.BOLD, 20));
 		 Loginbutton.setBounds(582, 230, 95, 76);
 		 add(Loginbutton);
		 
	      JPanel keypadpanel = new JPanel();
	        keypadpanel.setBounds(12, 287, 789, 253);
	       keypadpanel.setBorder(border);
	        keypadpanel.setLayout(null);
	        keypadpanel.setBackground(new Color(255, 255, 255));
	        add(keypadpanel);
	        keypadpanel.setVisible(false);
	        Keypadpanel = keypadpanel;
	        
	        JPanel doublekeypadpanel = new JPanel();
	        doublekeypadpanel.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		focusTextFeild = focusTextFeild;
	        	}
	        });
	        doublekeypadpanel.setBounds(5, 20, 775, 208);
	        keypadpanel.add(doublekeypadpanel);
	        doublekeypadpanel.setLayout(null);
	        doublekeypadpanel.setBackground(new Color(255, 255, 255));
	        doublekeypadpanel.setVisible(true);
	      
 	        JPanel doublekeypadpanel_1 = new JPanel();
 	        doublekeypadpanel_1.addMouseListener(new MouseAdapter() {
 	        	@Override
 	        	public void mouseClicked(MouseEvent e) {
	        		focusTextFeild = focusTextFeild;
 	        	}
 	        });
 	        doublekeypadpanel_1.setBounds(5, 20, 775, 208);
 	        keypadpanel.add(doublekeypadpanel_1);
 	        doublekeypadpanel_1.setLayout(null);
 	        doublekeypadpanel_1.setBackground(Color.WHITE);
 	        doublekeypadpanel_1.setVisible(false);
 	        
 	       phonetext = new JTextField();
 	      phonetext.addMouseListener(new MouseAdapter() {
 	      	@Override
 	      	public void mouseClicked(MouseEvent e) {
 	      		   if (focusTextFeild != 1 && focusTextFeild != 2) {  // 포커스가 처음 잡혔을 때만 조정
 	                  focusTextFeild = 1;
 	                  keypadpanel.setVisible(true);
 	                  adjustUIElements(-50);
 	      		}
 	      	}
 	      });
 	      phonetext.setBounds(284, 233, 286, 24);
 	      add(phonetext);
 	      phonetext.setColumns(10); 
 	      phonetext.requestFocus(true);
 	      phonetext.setBorder(border);
 	      
 	      pwtext = new JTextField();
 	      pwtext.addMouseListener(new MouseAdapter() {
 	      	@Override
 	      	public void mouseClicked(MouseEvent e) {
 	      	   if (focusTextFeild != 1 && focusTextFeild != 2) {  // 포커스가 처음 잡혔을 때만 조정
	                  focusTextFeild = 2;
	                  keypadpanel.setVisible(true);
	                  adjustUIElements(-50);
	      		}
 	      	}
 	      });
 	      pwtext.setColumns(10);
 	      pwtext.setBounds(284, 282, 286, 24);
 	      add(pwtext);
 	      pwtext.setBorder(border);
 	        
// 	    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\user\\Desktop\\uNBuJu4mVBZQ1ozdrHpUPJ.png");
//	        // 배경 이미지 아이콘을 JLabel에 설정
//	        JLabel backgroundLabel = new JLabel(backgroundImage);
//	        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
//	        setComponentZOrder(backgroundLabel, 0);  // 배경 이미지를 가장 뒤로 보냄
//	        add(backgroundLabel);
// 	      
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "q";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "w";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "e";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "r";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "t";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "y";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "u";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "i";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "o";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "p";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "a";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "s";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "d";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "f";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "g";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "h";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "j";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "k";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "l";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "z";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "x";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "c";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "v";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "b";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "n";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "m";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "2";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "3";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "4";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "5";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "6";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "7";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "8";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "9";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "0";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
					String currentText = pwtext.getText();
					if (!currentText.isEmpty()) {
					    String newText = currentText.substring(0, currentText.length() - 1);
					    pwtext.setText(newText);
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "1";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
	      		}
	     	}
	     });
	     one_11_1_1.setText("1");
	     one_11_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	     one_11_1_1.setBounds(82, 2, 43, 43);
	     doublekeypadpanel.add(one_11_1_1);
	    
	 	        
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "Q";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "W";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "E";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "R";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "T";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "Y";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "U";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "I";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "O";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "P";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "A";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "S";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "D";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "F";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "G";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "H";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "J";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "K";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "L";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "Z";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "X";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "C";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "V";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "B";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "N";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "M";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
	      			focusTextFeild = 3;
	      		}
	      		else if(focusTextFeild == 3)
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "@";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
			  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
					String newText = currentText + "#";  // 기존 문자열에 "~" 추가
					pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "$";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "%";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "^";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "&";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "*";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "(";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + ")";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
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
				String currentText = pwtext.getText();
				if (!currentText.isEmpty()) {
				    String newText = currentText.substring(0, currentText.length() - 1);
				    pwtext.setText(newText);
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
		  		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
				String newText = currentText + "!";  // 기존 문자열에 "~" 추가
				pwtext.setText(newText); 
	 	        		}
	 	        	}
	 	        });
	 	        one_11_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	 	        one_11_1_1_1.setBounds(82, 2, 43, 43);
	 	        doublekeypadpanel_1.add(one_11_1_1_1);
	 	        
	 	        JLabel lblNewLabel = new JLabel("");
	 	        lblNewLabel.setBounds(167, 3, 460, 50);
	 	        add(lblNewLabel);
	 	       lblNewLabel.setBorder(border);
	 
	}
	private void adjustUIElements(int deltaY) {
	    phonetext.setLocation(phonetext.getX(), phonetext.getY() + deltaY);
	    pwtext.setLocation(pwtext.getX(), pwtext.getY() + deltaY);
	    phonelabel.setLocation(phonelabel.getX(), phonelabel.getY() + deltaY);
	    pwlabel.setLocation(pwlabel.getX(), pwlabel.getY() + deltaY);
//	    label.setLocation(label.getX(), label.getY() + deltaY);
	    Loginbutton.setLocation(Loginbutton.getX(), Loginbutton.getY() + deltaY);
	}
}
