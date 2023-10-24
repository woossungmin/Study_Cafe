package com.pws.study;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.JList;

public class SelectFaq {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFaq window = new SelectFaq("");
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
	public SelectFaq(String question1) {
		initialize(question1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String question1) {
		Border border = BorderFactory.createLineBorder(new Color(114, 166, 250), 2);
		frame = new JFrame();
		frame.setBounds(450, 150, 450, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 331);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setVisible(true);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 412, 311);
		panel.add(panel_1);
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(217,231,255));
		
		JLabel lblNewLabel = new JLabel("키워드명 : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 49, 85, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(114,166,255));
		
		JTextField keyword = new JTextField();
		keyword.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
		keyword.setBounds(109, 51, 291, 30);
		panel_1.add(keyword);
		keyword.setColumns(10);
		keyword.setBorder(border);
		keyword.setEditable(false);
		keyword.setForeground(new Color(114,166,255));
		
		JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
		BackButton.setBounds(380, 7, 25, 25);
		panel_1.add(BackButton);
		BackButton.setBorderPainted(false); 
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		
		JLabel lblNewLabel_1 = new JLabel("질      문 : ");
		lblNewLabel_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 89, 85, 30);
		panel_1.add(lblNewLabel_1);
		
		JTextField question = new JTextField();
		question.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
		question.setColumns(10);
		question.setBounds(109, 91, 291, 30);
		panel_1.add(question);
		question.setBorder(border);
		question.setEditable(false);
		question.setForeground(new Color(114,166,255));
		
		JLabel lblNewLabel_1_1 = new JLabel("답      변 : ");
		lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 129, 85, 30);
		panel_1.add(lblNewLabel_1_1);
		
		 JTextArea answer = new JTextArea() {
	            @Override
	            public void setText(String t) {
	                if (t.length() > 30) {
	                    StringBuilder sb = new StringBuilder();
	                    int i = 0;
	                    while (i < t.length()) {
	                        sb.append(t, i, Math.min(i + 30, t.length()));
	                        if (i + 30 < t.length()) {
	                            sb.append("\n");
	                        }
	                        i += 30;
	                    }
	                    t = sb.toString();
	                }
	                super.setText(t);
	            }
	        };
	        answer.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
	        answer.setBounds(109, 131, 291, 170);
	        panel_1.add(answer);
	        answer.setBorder(border);
	        answer.setForeground(new Color(114, 166, 255));
	        answer.setEditable(false);
	        answer.setBackground(new Color(240,240,240));
	
		 Post po = new Post();
	        JSONObject data = new JSONObject();
			try {
				data.put("question", question1);
		        JSONObject check = po.jsonpost("/FindQuestion", data);
		   		if((check.get("check")).equals("true"))
					{
		   				String originkeyword = check.getString("keyword");
		   				String originquestion = check.getString("question");
		   				String originanswer = check.getString("answer");
		   				keyword.setText(originkeyword);
		   				question.setText(originquestion);
		   				answer.setText(originanswer);
			        }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
