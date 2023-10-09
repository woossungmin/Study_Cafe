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
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateKeyword {

	private JFrame frame;
	private JTextField keyword;
	private JPanel borderpanel;
	private JButton homebutton;
	private JButton closebutton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateKeyword window = new UpdateKeyword("",new JButton(),new JButton(), new JPanel());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param text 
	 */
	public UpdateKeyword(String text, JButton homeButton, JButton closeButton, JPanel borderPanel) {
		initialize(text,homeButton,closeButton,borderPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String text,JButton homeButton, JButton closeButton, JPanel borderPanel) {
		this.borderpanel = borderPanel;
		this.homebutton = homeButton;
		this.closebutton = closeButton;
		frame = new JFrame();
		frame.setBounds(500, 150, 410, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 396, 156);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 372, 136);
		panel.add(panel_1);
		frame.setVisible(true);
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		
		RoundedButton2 btnNewButton = new RoundedButton2("확인");
		btnNewButton.setText("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Post po = new Post();
		        JSONObject data = new JSONObject();
				try {
					data.put("keyword", text);
					data.put("updatekeyword",keyword.getText());
					JSONObject check = po.jsonpost("/UpdateKeyword", data);
					if((check.get("check")).equals("true"))
					{
						frame.dispose();
						FaqPanel fa = new FaqPanel(borderpanel,homebutton,closebutton);
						switchPanel(fa,borderpanel,homebutton,closebutton);
						Message ms = new Message("수정이 완료되었습니다!");
		   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
					}
					else
					{
						frame.dispose();
						Message ms = new Message("수정을 실패하였습니다!");
		   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
					}
			        
			        
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.setLayout(null);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton.setBounds(105, 101, 61, 25);
		panel_1.add(btnNewButton);
		
		JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
		BackButton.setBounds(335, 10, 25, 25);
		panel_1.add(BackButton);
		BackButton.setBorderPainted(false); 
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("키워드 명 : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 49, 104, 37);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(114,166,255));
		
		keyword = new JTextField();
		keyword.setBounds(108, 54, 252, 25);
		panel_1.add(keyword);
		keyword.setColumns(10);
		keyword.setBorder(border);
		keyword.setText(text);
		
		RoundedButton2 btnNewButton_1 = new RoundedButton2("삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Post po = new Post();
		        JSONObject data = new JSONObject();
				try {
					data.put("keyword", text);
					JSONObject check = po.jsonpost("/DeleteKeyword", data);
					if((check.get("check")).equals("true"))
					{
						frame.dispose();
						FaqPanel fa = new FaqPanel(borderpanel,homebutton,closebutton);
						switchPanel(fa,borderpanel,homebutton,closebutton);
						Message ms = new Message("삭제가 완료되었습니다!");
		   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
					}
					else
					{
						frame.dispose();
						Message ms = new Message("삭제를 실패하였습니다!");
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
		btnNewButton_1.setBounds(202, 101, 61, 25);
		panel_1.add(btnNewButton_1);
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
