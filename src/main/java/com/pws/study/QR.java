package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class QR {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QR window = new QR();
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
	public QR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 150, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
      	JPanel panel_1 = new JPanel();
      	panel_1.setBounds(0, 0, 436, 373);
      	frame.getContentPane().add(panel_1);
      	panel_1.setLayout(null);
      	panel_1.setBackground(new Color(255,255,255));
      	
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
      	JPanel panel = new JPanel();
      	panel.setBounds(12, 10, 412, 353);
      	panel_1.add(panel);
      	panel.setBorder(border);
      	panel.setBackground(new Color(255,255,255));
      	
        JLabel projectname2 = new JLabel("QR 코드를 찍어주세요!");
        projectname2.setForeground(new Color(114, 166, 255));
        projectname2.setFont(new Font("굴림", Font.BOLD, 20));
        projectname2.setBounds(92, 10, 230, 37);
        panel.add(projectname2);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\qr.png"));
        lblNewLabel.setBounds(61, 44, 288, 288);
        panel.add(lblNewLabel);
        
		JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
		BackButton.setBounds(0, 0, 45, 37);
		panel.add(BackButton);
		BackButton.setBorderPainted(false); 
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
	}
}
