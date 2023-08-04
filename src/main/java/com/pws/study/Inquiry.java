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
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
	      Border border1 =  BorderFactory.createLineBorder(new Color(0,0,255),2);
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
			projectname2_1.setForeground(new Color(0, 0, 255));
			projectname2_1.setFont(new Font("굴림", Font.BOLD, 17));
			projectname2_1.setBounds(23, 26, 95, 37);
			panel.add(projectname2_1);
			 
			RoundedButton2 bu = new RoundedButton2("등록하기");
			bu.setText("작성하기");
			bu.setFont(new Font("굴림", Font.BOLD, 15));
			bu.setBounds(301, 420, 95, 37);
			panel.add(bu);
			
			RoundedButton2 bu_1 = new RoundedButton2("등록하기");
			bu_1.setText("취소");
			bu_1.setFont(new Font("굴림", Font.BOLD, 15));
			bu_1.setBounds(204, 420, 95, 37);
			panel.add(bu_1);
			
			JTextArea textArea = new JTextArea();
			textArea.setText("\r\n");
			textArea.setBounds(113, 33, 283, 377);
			panel.add(textArea);
			textArea.setBorder(border1);
			textArea.setFont(new Font("굴림", Font.BOLD, 15));
			textArea.setText(Info.pw);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(new Color(47, 85, 198));
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(417, 118, 408, 465);
			borderpanel.add(panel_1);
			panel_1.setBorder(border);
			
			JLabel FAQ1 = new JLabel("제목 1");
			FAQ1.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1.setBounds(61, 95, 299, 30);
			panel_1.add(FAQ1);
			FAQ1.setForeground(new Color(0, 0, 255));
			
			JLabel lblQ = new JLabel("Q");
			lblQ.setForeground(new Color(0, 0, 255));
			lblQ.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ.setBounds(33, 95, 29, 30);
			panel_1.add(lblQ);
			
			JLabel lblQ_1 = new JLabel("Q");
			lblQ_1.setForeground(Color.BLUE);
			lblQ_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ_1.setBounds(33, 147, 29, 30);
			panel_1.add(lblQ_1);
			
			JLabel FAQ1_1 = new JLabel("제목 1");
			FAQ1_1.setForeground(Color.BLUE);
			FAQ1_1.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1_1.setBounds(61, 147, 299, 30);
			panel_1.add(FAQ1_1);
			
			JLabel FAQ1_1_1 = new JLabel("제목 1");
			FAQ1_1_1.setForeground(Color.BLUE);
			FAQ1_1_1.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1_1_1.setBounds(61, 251, 299, 30);
			panel_1.add(FAQ1_1_1);
			
			JLabel lblQ_1_1 = new JLabel("Q");
			lblQ_1_1.setForeground(Color.BLUE);
			lblQ_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ_1_1.setBounds(33, 251, 29, 30);
			panel_1.add(lblQ_1_1);
			
			JLabel lblQ_2 = new JLabel("Q");
			lblQ_2.setForeground(Color.BLUE);
			lblQ_2.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ_2.setBounds(33, 199, 29, 30);
			panel_1.add(lblQ_2);
			
			JLabel FAQ1_2 = new JLabel("제목 1");
			FAQ1_2.setForeground(Color.BLUE);
			FAQ1_2.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1_2.setBounds(61, 199, 299, 30);
			panel_1.add(FAQ1_2);
			
			JLabel FAQ1_2_1 = new JLabel("제목 1");
			FAQ1_2_1.setForeground(Color.BLUE);
			FAQ1_2_1.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1_2_1.setBounds(61, 303, 299, 30);
			panel_1.add(FAQ1_2_1);
			
			JLabel lblQ_2_1 = new JLabel("Q");
			lblQ_2_1.setForeground(Color.BLUE);
			lblQ_2_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ_2_1.setBounds(33, 303, 29, 30);
			panel_1.add(lblQ_2_1);
			
			JLabel lblQ_1_1_1 = new JLabel("Q");
			lblQ_1_1_1.setForeground(Color.BLUE);
			lblQ_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblQ_1_1_1.setBounds(33, 355, 29, 30);
			panel_1.add(lblQ_1_1_1);
			
			JLabel FAQ1_1_1_1 = new JLabel("제목 1");
			FAQ1_1_1_1.setForeground(Color.BLUE);
			FAQ1_1_1_1.setFont(new Font("굴림", Font.BOLD, 18));
			FAQ1_1_1_1.setBounds(61, 355, 299, 30);
			panel_1.add(FAQ1_1_1_1);
			
			JLabel lblFaq = new JLabel("BEST FAQ");
			lblFaq.setForeground(Color.BLUE);
			lblFaq.setFont(new Font("굴림", Font.BOLD, 18));
			lblFaq.setBounds(33, 26, 122, 30);
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
			bu_2.setFont(new Font("굴림", Font.BOLD, 15));
			
			
	}
}
