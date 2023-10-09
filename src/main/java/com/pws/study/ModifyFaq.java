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

public class ModifyFaq {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyFaq window = new ModifyFaq(new JButton(), new JButton(), new JPanel());
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
	public ModifyFaq(JButton homeButton, JButton closeButton, JPanel borderPanel) {
		initialize(homeButton, closeButton, borderPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton homeButton, JButton closeButton, JPanel borderPanel) {
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
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(217,231,255));
		
		JLabel lblNewLabel = new JLabel("키워드명 : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 49, 85, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(114,166,255));
		
		JTextField keyword = new JTextField();
		keyword.setBounds(109, 51, 291, 30);
		panel_1.add(keyword);
		keyword.setColumns(10);
		keyword.setBorder(border);
		keyword.setBackground(new Color(240,240,240));
		keyword.setEnabled(false);
		
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
		question.setColumns(10);
		question.setBounds(109, 91, 291, 30);
		panel_1.add(question);
		question.setBorder(border);
		question.setBackground(new Color(240,240,240));
		
		JLabel lblNewLabel_1_1 = new JLabel("답      변 : ");
		lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 129, 85, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JTextArea answer = new JTextArea();
		answer.setBounds(109, 131, 291, 137);
		panel_1.add(answer);
		answer.setBorder(border);
		answer.setBackground(new Color(240,240,240));
		
		RoundedButton2 btnNewButton = new RoundedButton2("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Post po = new Post();
		        JSONObject data = new JSONObject();
				try {
					data.put("question", question.getText());
					data.put("answer", answer.getText());
					data.put("originquestion", Click.question);
			        JSONObject check = po.jsonpost("/UpdateFaq", data);
			   		if((check.get("check")).equals("true"))
						{
			   				frame.dispose();
				      		FaqPanel fa = new FaqPanel(borderPanel,homeButton,closeButton);
				            switchPanel(fa,borderPanel,homeButton,closeButton);
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
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton.setBounds(109, 278, 95, 23);
		panel_1.add(btnNewButton);
		
		RoundedButton2 btnNewButton_1 = new RoundedButton2("삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Post po = new Post();
		        JSONObject data = new JSONObject();
				try {
					data.put("question", Click.question);
			        JSONObject check = po.jsonpost("/DeleteFaq", data);
			   		if((check.get("check")).equals("true"))
						{
			   				frame.dispose();
				      		FaqPanel fa = new FaqPanel(borderPanel,homeButton,closeButton);
				            switchPanel(fa,borderPanel,homeButton,closeButton);
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
		btnNewButton_1.setText("삭제");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_1.setBounds(216, 278, 95, 23);
		panel_1.add(btnNewButton_1);
	
		 Post po = new Post();
	        JSONObject data = new JSONObject();
			try {
				data.put("question", Click.question);
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
    private void switchPanel(JPanel newPanel,JPanel borderpanel, JButton homebutton, JButton closebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(closebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
}
