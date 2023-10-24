package com.pws.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inquiry {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inquiry window = new Inquiry();
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
	public Inquiry() {
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
	      Border border1 =  BorderFactory.createLineBorder(new Color(83, 144, 255),2);
	      JPanel mainpanel  = new JPanel();
	      mainpanel .setBounds(0, 0, 856, 613);
	      frame.getContentPane().add(mainpanel ); 
	      mainpanel .setLayout(null);
	      mainpanel .setBackground(new Color(255,255,255));
	      
	      JPanel borderpanel = new JPanel();
	      borderpanel.setBounds(10, 10, 837, 593);
	      mainpanel.add(borderpanel);
	      borderpanel.setLayout(null);
	      borderpanel.setBackground(new Color(255,255,255));
	      borderpanel.setBorder(border);
	      
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
	      
	      ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop");
	      JLabel label = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\clock.png"));
	      label.setBounds(265,10,43,43);
	      borderpanel.add(label);
	      
	      JButton BackButton = new JButton("");
			BackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					FAQ fa = new FAQ();
				}
			});
			BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
			BackButton.setBounds(0, 0, 45, 40);
			borderpanel.add(BackButton);
			BackButton.setBorderPainted(false); 
			BackButton.setContentAreaFilled(false);
			BackButton.setFocusPainted(false);
			
			JPanel panel = new JPanel();
			panel.setBounds(12, 118, 408, 465);
			borderpanel.add(panel);
			panel.setLayout(null);
			panel.setBorder(border);
			panel.setBackground(new Color(255,255,255));
			
			JLabel projectname2_1 = new JLabel("문의 내용");
			projectname2_1.setForeground(new Color(41, 117, 255));
			projectname2_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
			projectname2_1.setBounds(12, 185, 61, 30);
			panel.add(projectname2_1);
			 
			RoundedButton2 bu = new RoundedButton2("등록하기");
			bu.setText("취소");
			bu.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
			bu.setBounds(205, 418, 95, 37);
			panel.add(bu);
			
			RoundedButton2 bu_1 = new RoundedButton2("등록하기");
			bu_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bu_1.setText("작성하기");
			bu_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
			bu_1.setBounds(108, 418, 95, 37);
			panel.add(bu_1);
			
			JTextArea textArea = new JTextArea();
			textArea.setText("\r\n");
			textArea.setBounds(12, 221, 384, 185);
			panel.add(textArea);
			textArea.setBorder(border);
			textArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
			
			JLabel circle = new JLabel("");
		    circle.setBounds(25, 107, 15, 15);
		    panel.add(circle);
		    circle.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle.setVisible(false);
		    
			JLabel circle1 = new JLabel("");
		    circle1.setBounds(160, 107, 15, 15);
		    panel.add(circle1);
		    circle1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle1.setVisible(false);
		    
			JLabel circle2 = new JLabel("");
		    circle2.setBounds(295, 107, 15, 15);
		    panel.add(circle2);
		    circle2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle2.setVisible(false);
		    
			JLabel circle3 = new JLabel("");
		    circle3.setBounds(25, 147, 15, 15);
		    panel.add(circle3);
		    circle3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle3.setVisible(false);
		    
			JLabel circle4 = new JLabel("");
		    circle4.setBounds(160, 147, 15, 15);
		    panel.add(circle4);
		    circle4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle4.setVisible(false);
		    
			JLabel circle5 = new JLabel("");
		    circle5.setBounds(295, 147, 15, 15);
		    panel.add(circle5);
		    circle5.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check2.png"));
		    circle5.setVisible(false);
		    
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					circle.setVisible(false);
					circle1.setVisible(false);
					circle2.setVisible(false);
					circle3.setVisible(false);
					circle4.setVisible(false);
					circle5.setVisible(false);
				}
			});
			
			RoundedButton3 typebutton = new RoundedButton3("");
			typebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton.getText().equals("X")) {
						circle.setVisible(true);
						circle1.setVisible(false);
						circle2.setVisible(false);
						circle3.setVisible(false);
						circle4.setVisible(false);
						circle5.setVisible(false);
					}
				}
			});
			typebutton.setBounds(11, 101, 122, 30);
			typebutton.setBackgroundColor(new Color(235,242,255));
			typebutton.setTextColor(new Color(114,166,255));
			panel.add(typebutton);
			
			RoundedButton3 typebutton1 = new RoundedButton3("");
			typebutton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton1.getText().equals("X")) {
						circle.setVisible(false);
						circle1.setVisible(true);
						circle2.setVisible(false);
						circle3.setVisible(false);
						circle4.setVisible(false);
						circle5.setVisible(false);
					}
				}
			});
			typebutton1.setBounds(145, 101, 122, 30);
			typebutton1.setBackgroundColor(new Color(235,242,255));
			typebutton1.setTextColor(new Color(114,166,255));
			panel.add(typebutton1);
			
			RoundedButton3 typebutton2 = new RoundedButton3("");
			typebutton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton2.getText().equals("X")) {
						circle.setVisible(false);
						circle1.setVisible(false);
						circle2.setVisible(true);
						circle3.setVisible(false);
						circle4.setVisible(false);
						circle5.setVisible(false);	
					}
				}
			});
			typebutton2.setBounds(279, 101, 122, 30);
			typebutton2.setBackgroundColor(new Color(235,242,255));
			typebutton2.setTextColor(new Color(114,166,255));
			panel.add(typebutton2);
			
			RoundedButton3 typebutton3 = new RoundedButton3("");
			typebutton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton3.getText().equals("X")) {
						circle.setVisible(false);
						circle1.setVisible(false);
						circle2.setVisible(false);
						circle3.setVisible(true);
						circle4.setVisible(false);
						circle5.setVisible(false);
					}
				}
			});
			typebutton3.setBounds(11, 141, 122, 30);
			typebutton3.setBackgroundColor(new Color(235,242,255));
			typebutton3.setTextColor(new Color(114,166,255));
			panel.add(typebutton3);
			
			RoundedButton3 typebutton4 = new RoundedButton3("");
			typebutton4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton4.getText().equals("X")) {
						circle.setVisible(false);
						circle1.setVisible(false);
						circle2.setVisible(false);
						circle3.setVisible(false);
						circle4.setVisible(true);
						circle5.setVisible(false);
					}
				}
			});
			typebutton4.setBounds(145, 141, 122, 30);
			typebutton4.setBackgroundColor(new Color(235,242,255));
			typebutton4.setTextColor(new Color(114,166,255));
			panel.add(typebutton4);
			
			RoundedButton3 typebutton5 = new RoundedButton3("");
			typebutton5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!typebutton5.getText().equals("X")) {
						circle.setVisible(false);
						circle1.setVisible(false);
						circle2.setVisible(false);
						circle3.setVisible(false);
						circle4.setVisible(false);
						circle5.setVisible(true);
					}
					
				}
			});
			typebutton5.setBounds(279, 141, 122, 30);
			typebutton5.setBackgroundColor(new Color(235,242,255));
			typebutton5.setTextColor(new Color(114,166,255));
			panel.add(typebutton5);
			
			JLabel projectname2_1_1 = new JLabel("문의 유형");
			projectname2_1_1.setForeground(new Color(41, 117, 255));
			projectname2_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
			projectname2_1_1.setBounds(11, 60, 61, 30);
			panel.add(projectname2_1_1);
			
			JLabel lblFaq_1 = new JLabel("문의하기");
			lblFaq_1.setForeground(new Color(83, 144, 255));
			lblFaq_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			lblFaq_1.setBounds(11, 10, 122, 30);
			panel.add(lblFaq_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(new Color(47, 85, 198));
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(417, 118, 408, 465);
			borderpanel.add(panel_1);
			panel_1.setBorder(border);
			
		    
			JLabel FAQ1 = new JLabel("");
			FAQ1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ1.getText());
				}
			});
			FAQ1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ1.setBounds(50, 70, 299, 30);
			panel_1.add(FAQ1);
			FAQ1.setForeground(new Color(147, 186, 255));
			
			JLabel FAQ2 = new JLabel("");
			FAQ2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ2.getText());
				}
			});
			FAQ2.setForeground(new Color(147, 186, 255));
			FAQ2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ2.setBounds(50, 108, 327, 30);
			panel_1.add(FAQ2);
			
			JLabel FAQ4 = new JLabel("Q. 제목 ");
			FAQ4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ4.getText());
				}
			});
			FAQ4.setForeground(new Color(147, 186, 255));
			FAQ4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ4.setBounds(50, 178, 327, 30);
			panel_1.add(FAQ4);
			
			JLabel FAQ3 = new JLabel("");
			FAQ3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ3.getText());
				}
			});
			FAQ3.setForeground(new Color(147, 186, 255));
			FAQ3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ3.setBounds(50, 143, 327, 30);
			panel_1.add(FAQ3);
			
			JLabel FAQ5 = new JLabel("");
			FAQ5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ5.getText());
				}
			});
			FAQ5.setForeground(new Color(147, 186, 255));
			FAQ5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ5.setBounds(50, 213, 327, 30);
			panel_1.add(FAQ5);
			
			JLabel FAQ6 = new JLabel("");
			FAQ6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ6.getText());
				
				}
			});
			FAQ6.setForeground(new Color(147, 186, 255));
			FAQ6.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ6.setBounds(50, 248, 327, 30);
			panel_1.add(FAQ6);
			
			JLabel lblFaq = new JLabel("BEST FAQ");
			lblFaq.setForeground(new Color(83, 144, 255));
			lblFaq.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			lblFaq.setBounds(12, 10, 122, 30);
			panel_1.add(lblFaq);
			
			RoundedButton2 bu_2 = new RoundedButton2("문의내역");
			bu_2.setBounds(301, 418, 95, 37);
			panel_1.add(bu_2);
			bu_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					Inquiry1 in = new Inquiry1();
				}
			});
			bu_2.setText("문의 내역");
			bu_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
			
			JLabel FAQ7 = new JLabel("");
			FAQ7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ7.getText());
				
				}
			});
			FAQ7.setForeground(new Color(147, 186, 255));
			FAQ7.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ7.setBounds(50, 283, 327, 30);
			panel_1.add(FAQ7);
			
			JLabel FAQ8 = new JLabel("");
			FAQ8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ8.getText());
				
				}
			});
			FAQ8.setForeground(new Color(147, 186, 255));
			FAQ8.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ8.setBounds(50, 318, 327, 30);
			panel_1.add(FAQ8);
			
			JLabel FAQ9 = new JLabel("");
			FAQ9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ9.getText());
				
				}
			});
			FAQ9.setForeground(new Color(147, 186, 255));
			FAQ9.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ9.setBounds(50, 353, 327, 30);
			panel_1.add(FAQ9);
			
			JLabel FAQ10 = new JLabel("");
			FAQ10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SelectFaq se = new SelectFaq(FAQ10.getText());
				
				}
			});
			FAQ10.setForeground(new Color(147, 186, 255));
			FAQ10.setFont(new Font("한컴산뜻돋움", Font.BOLD, 18));
			FAQ10.setBounds(50, 388, 327, 30);
			panel_1.add(FAQ10);
			
			JLabel Q1 = new JLabel("Q.");
			Q1.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q1.setBounds(22, 70, 21, 30);
			Q1.setForeground(new Color(83,144,255));
			panel_1.add(Q1);
			
			JLabel Q2 = new JLabel("Q.");
			Q2.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q2.setBounds(22, 108, 21, 30);
			Q2.setForeground(new Color(83,144,255));
			panel_1.add(Q2);
			
			JLabel Q3 = new JLabel("Q.");
			Q3.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q3.setBounds(22, 143, 21, 30);
			Q3.setForeground(new Color(83,144,255));
			panel_1.add(Q3);
			
			JLabel Q4 = new JLabel("Q.");
			Q4.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q4.setBounds(22, 178, 21, 30);
			Q4.setForeground(new Color(83,144,255));
			panel_1.add(Q4);
			
			JLabel Q5 = new JLabel("Q.");
			Q5.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q5.setBounds(22, 213, 21, 30);
			Q5.setForeground(new Color(83,144,255));
			panel_1.add(Q5);
			
			JLabel Q6 = new JLabel("Q.");
			Q6.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q6.setBounds(22, 248, 21, 30);
			Q6.setForeground(new Color(83,144,255));
			panel_1.add(Q6);
			
			JLabel Q7 = new JLabel("Q.");
			Q7.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q7.setBounds(22, 283, 21, 30);
			Q7.setForeground(new Color(83,144,255));
			panel_1.add(Q7);
			
			JLabel Q8 = new JLabel("Q.");
			Q8.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q8.setBounds(22, 318, 21, 30);
			Q8.setForeground(new Color(83,144,255));
			panel_1.add(Q8);
			
			JLabel Q9 = new JLabel("Q.");
			Q9.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q9.setBounds(22, 353, 21, 30);
			Q9.setForeground(new Color(83,144,255));
			panel_1.add(Q9);
			
			JLabel Q10 = new JLabel("Q.");
			Q10.setFont(new Font("한컴 고딕", Font.BOLD, 18));
			Q10.setBounds(22, 388, 21, 30);
			Q10.setForeground(new Color(83,144,255));
			panel_1.add(Q10);
			
			 JSONObject data = new JSONObject();
		        try {
		            data.put("keyword", "");
		            Post po = new Post();

		            JSONObject check = po.jsonpost("/Findquestion", data);

		            if (check.has("check") && check.getString("check").equals("true")) {
		                JSONArray keywordArray = check.getJSONArray("result");

		                for (int i = 0; i < 10; i++) {
		                    JSONObject keywordObject = keywordArray.getJSONObject(i);
		                    String questionText = keywordObject.getString("question"); // 수정: "question"으로 변경

		                    if (i == 0) {
		                        FAQ1.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 1) {
		                        FAQ2.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 2) {
		                        FAQ3.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 3) {
		                        FAQ4.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 4) {
		                        FAQ5.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 5) { 
		                        FAQ6.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 6) { 
		                        FAQ7.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 7) { 
		                        FAQ8.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 8) { 
		                        FAQ9.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } else if (i == 9) { 
		                        FAQ10.setText("NULL".equals(questionText) ? "  제목" :  questionText);
		                    } 
		                }
		            } else {
		                // Handle the case when "check" is not "true"
		            }
		        } catch (JSONException e1) {
		            e1.printStackTrace();
		        }
		        
		        try {
		            data.put("keyword", "");
		            Post po = new Post();

		            JSONObject check = po.jsonpost("/Findkeyword", data);

		            if (check.has("check") && check.getString("check").equals("true")) {
		                JSONArray keywordArray = check.getJSONArray("keyword");

		                // Assuming you have TextView objects named keyword, keyword1, keyword2, ...
		                for (int i = 0; i < 6; i++) {
		                    JSONObject keywordObject = keywordArray.getJSONObject(i);
		                    String keywordText = keywordObject.getString("keyword");

		                    if (i == 0) {
		                        typebutton.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    } else if (i == 1) {
		                        typebutton1.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    } else if (i == 2) {
		                    	typebutton2.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    } else if (i == 3) {
		                    	typebutton3.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    } else if (i == 4) {
		                    	typebutton4.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    } else if (i == 5) {
		                    	typebutton5.setText("NULL".equals(keywordText) ? "X" : keywordText);
		                    }
		                }
		            } else {
		                // Handle the case when "check" is not "true"
		            }
		        } catch (JSONException e1) {
		            e1.printStackTrace();
		        }
			
	}
}
