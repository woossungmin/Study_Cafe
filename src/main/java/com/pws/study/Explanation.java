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
import javax.swing.JLabel;

public class Explanation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explanation window = new Explanation();
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
	public Explanation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 150, 500, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
      	JPanel panel_1 = new JPanel();
      	panel_1.setBounds(0, 0, 486, 423);
      	frame.getContentPane().add(panel_1);
      	panel_1.setLayout(null);
      	panel_1.setBackground(new Color(255,255,255));
      	
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);

      	JPanel panel = new JPanel();
      	panel.setBounds(12, 10, 462, 403);
      	panel_1.add(panel);
      	panel.setBorder(border);
      	panel.setBackground(new Color(255,255,255));
      	panel.setLayout(null);
      	
      	JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
		BackButton.setBounds(417, 0, 45, 37);
		panel.add(BackButton);
		BackButton.setBorderPainted(false); 
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
	      
	      JLabel projectname2_2 = new JLabel("2.");
	      projectname2_2.setForeground(new Color(114, 166, 255));
	      projectname2_2.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2.setBounds(39, 141, 15, 25);
	      panel.add(projectname2_2);
	      
	      JLabel projectname2_2_1 = new JLabel("스터디 카페를 사용할 수 있는 공간입니다.");
	      projectname2_2_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_1.setBounds(57, 166, 327, 25);
	      panel.add(projectname2_2_1);
	      
	      JLabel projectname2_2_1_1 = new JLabel("조용한 공간에서 개인 공부를 할 수 있는 공간입니다.");
	      projectname2_2_1_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_1_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_1_1.setBounds(58, 241, 377, 25);
	      panel.add(projectname2_2_1_1);
	      
	      JLabel projectname2_2_1_1_1 = new JLabel("가벼운 이야기와 함께 공부 할 수 있는 공간입니다.");
	      projectname2_2_1_1_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_1_1_1.setBounds(57, 316, 377, 25);
	      panel.add(projectname2_2_1_1_1);
	      
	      JLabel projectname2_2_3 = new JLabel("LAPTOP ZOON");
	      projectname2_2_3.setForeground(new Color(0, 0, 255));
	      projectname2_2_3.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3.setBounds(57, 141, 113, 25);
	      panel.add(projectname2_2_3);
	      
	      JLabel projectname2_2_3_1 = new JLabel("은 노트북을 함께 사용하며");
	      projectname2_2_3_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_3_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3_1.setBounds(172, 141, 200, 25);
	      panel.add(projectname2_2_3_1);
	      
	      JLabel projectname2_2_3_2 = new JLabel("STUDY ZOON");
	      projectname2_2_3_2.setForeground(Color.BLUE);
	      projectname2_2_3_2.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3_2.setBounds(57, 216, 113, 25);
	      panel.add(projectname2_2_3_2);
	      
	      JLabel projectname2_2_2 = new JLabel("3.");
	      projectname2_2_2.setForeground(new Color(114, 166, 255));
	      projectname2_2_2.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_2.setBounds(39, 216, 15, 25);
	      panel.add(projectname2_2_2);
	      
	      JLabel projectname2_2_3_1_1 = new JLabel("은 노트북을 함께 사용하지 못하며");
	      projectname2_2_3_1_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_3_1_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3_1_1.setBounds(163, 216, 253, 25);
	      panel.add(projectname2_2_3_1_1);
	      
	      JLabel projectname2_2_2_1 = new JLabel("4.");
	      projectname2_2_2_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_2_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_2_1.setBounds(39, 291, 15, 25);
	      panel.add(projectname2_2_2_1);
	      
	      JLabel projectname2_2_3_2_1 = new JLabel("STUDY ROOM");
	      projectname2_2_3_2_1.setForeground(Color.BLUE);
	      projectname2_2_3_2_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3_2_1.setBounds(57, 291, 113, 25);
	      panel.add(projectname2_2_3_2_1);
	      
	      JLabel projectname2_2_3_1_1_1 = new JLabel("은 여러 인원이 함께 입장하여");
	      projectname2_2_3_1_1_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_3_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_3_1_1_1.setBounds(163, 291, 253, 25);
	      panel.add(projectname2_2_3_1_1_1);
	      
	      JPanel panel_2 = new JPanel();
	      panel_2.setBounds(140, 12, 183, 30);
	      panel.add(panel_2);
	      panel_2.setBackground(new Color(255,255,255));
	      panel_2.setBorder(border);
	      panel_2.setLayout(null);
	      
	      JLabel projectname2 = new JLabel("POTEN STUDY CAFE");
	      projectname2.setForeground(new Color(114, 166, 255));
	      projectname2.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2.setBounds(11, 5, 164, 25);
	      panel_2.add(projectname2);
	      
	      JLabel projectname2_2_4 = new JLabel("1.");
	      projectname2_2_4.setForeground(new Color(114, 166, 255));
	      projectname2_2_4.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_4.setBounds(39, 91, 15, 25);
	      panel.add(projectname2_2_4);
	      
	      JPanel panel_3 = new JPanel();
	      panel_3.setBounds(57, 91, 25, 25);
	      panel.add(panel_3);
	      panel_3.setBorder(border);
	      panel_3.setBackground(new Color(200,196,196));
	      
	      JLabel projectname2_2_4_1 = new JLabel("색은 사용 불가");
	      projectname2_2_4_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_4_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_4_1.setBounds(86, 91, 139, 25);
	      panel.add(projectname2_2_4_1);
	      
	      JPanel panel_3_1 = new JPanel();
	      panel_3_1.setBackground(new Color(255, 255, 255));
	      panel_3_1.setBounds(226, 91, 25, 25);
	      panel.add(panel_3_1);
	      panel_3_1.setBorder(border);
	      
	      JLabel projectname2_2_4_1_1 = new JLabel("색은 사용 가능");
	      projectname2_2_4_1_1.setForeground(new Color(114, 166, 255));
	      projectname2_2_4_1_1.setFont(new Font("굴림", Font.BOLD, 15));
	      projectname2_2_4_1_1.setBounds(253, 91, 122, 25);
	      panel.add(projectname2_2_4_1_1);
	      
	      
	      ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop");
	       
	}
}
