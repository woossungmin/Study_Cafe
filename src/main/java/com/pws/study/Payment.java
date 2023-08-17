package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Payment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame();
	      frame.setBounds(400, 100, 500, 450);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      
	      Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
	      
	      JPanel panel = new JPanel();
	      panel.setBounds(0, 0, 486, 425);
	      frame.getContentPane().add(panel);
	      panel.setLayout(null);
	      panel.setBackground(new Color(255,255,255));
	      
	      JPanel borderpanel = new JPanel();
	      borderpanel.setBounds(12, 10, 462, 384);
	      panel.add(borderpanel);
	      frame.setResizable(false);
	      frame.setVisible(true);
	      borderpanel.setBackground(new Color(255,255,255));
	      borderpanel.setBorder(border);
	      borderpanel.setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("");
	      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\ezgif.com-gif-maker.gif"));
	      lblNewLabel.setBounds(95, 50, 263, 188);
	      borderpanel.add(lblNewLabel);
	      
	      JLabel lblNewLabel_1 = new JLabel("결제중입니다. 카드를 꽂아주세요");
	      lblNewLabel_1.setForeground(new Color(0, 0, 255));
	      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	      lblNewLabel_1.setBounds(75, 313, 366, 35);
	      borderpanel.add(lblNewLabel_1);
	     
	      JPanel borderpanel2 = new JPanel();
	      borderpanel2.setBounds(12, 10, 462, 384);
	      panel.add(borderpanel2);
	      frame.setResizable(false);
	      frame.setVisible(true);
	      borderpanel2.setBackground(new Color(255,255,255));
	      borderpanel2.setBorder(border);
	      borderpanel2.setLayout(null);
	      
	      JLabel lblNewLabel1 = new JLabel("");
	      lblNewLabel1.setBounds(155, 90, 155, 129);
	      borderpanel2.add(lblNewLabel1);
	      lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check.png"));
	      
	      JLabel lblNewLabel_2 = new JLabel("결제가 완료되었습니다!");
	      lblNewLabel_2.setForeground(new Color(0, 0, 255));
	      lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
	      lblNewLabel_2.setBounds(120, 280, 366, 35);
	      borderpanel2.add(lblNewLabel_2);
	      
	      Timer timer = new Timer();
	      TimerTask task = new TimerTask() {
	    	  
	    	  public void run() {
	    		  borderpanel2.setVisible(true);
	    		  borderpanel.setVisible(false);
	              try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	              frame.dispose();
	    	  }
	      };
	      
	      timer.schedule(task,5000);
	   
	}

}
