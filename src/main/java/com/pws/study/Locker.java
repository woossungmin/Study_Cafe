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

public class Locker {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locker window = new Locker();
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
	public Locker() {
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
	    Border border1 =  BorderFactory.createLineBorder(new Color(0,0,0),1);
	      
	    JPanel panel_4 = new JPanel();
	    panel_4.setBounds(0, 0, 856, 613);
	    frame.getContentPane().add(panel_4);
	    panel_4.setLayout(null);
	    panel_4.setBackground(new Color(255,255,255));
	      
	    JPanel borderpanel = new JPanel();
	    borderpanel.setBounds(10, 10, 839, 593);
	    panel_4.add(borderpanel);
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
		
		JPanel borderpanel2 = new JPanel();
		borderpanel2.setBounds(36, 121, 766, 430);
		borderpanel.add(borderpanel2);
		borderpanel2.setBackground(new Color(255,255,255));
		borderpanel2.setBorder(border);
		borderpanel2.setLayout(null);
		
		RoundedButton2 l1 = new RoundedButton2("사물함" + "<br>" +"1번");
		l1.setFont(new Font("굴림", Font.BOLD, 15));
		l1.setBounds(40, 29, 129, 87);
		borderpanel2.add(l1);
		
		RoundedButton2 l2 = new RoundedButton2("사물함" + "<br>" +"2번");
		l2.setFont(new Font("굴림", Font.BOLD, 15));
		l2.setBounds(181, 29, 129, 87);
		borderpanel2.add(l2);
		
		RoundedButton2 l3 = new RoundedButton2("사물함" + "<br>" +"3번");
		l3.setFont(new Font("굴림", Font.BOLD, 15));
		l3.setBounds(322, 29, 129, 87);
		borderpanel2.add(l3);
		
		RoundedButton2 l4 = new RoundedButton2("사물함" + "<br>" +"4번");
		l4.setFont(new Font("굴림", Font.BOLD, 15));
		l4.setBounds(463, 29, 129, 87);
		borderpanel2.add(l4);
		
		RoundedButton2 l5 = new RoundedButton2("사물함" + "<br>" +"5번");
		l5.setFont(new Font("굴림", Font.BOLD, 15));
		l5.setBounds(604, 29, 129, 87);
		borderpanel2.add(l5);
		
		RoundedButton2 l6 = new RoundedButton2("사물함" + "<br>" +"6번");
		l6.setFont(new Font("굴림", Font.BOLD, 15));
		l6.setBounds(40, 126, 129, 87);
		borderpanel2.add(l6);
		
		RoundedButton2 l7 = new RoundedButton2("사물함" + "<br>" +"7번");
		l7.setFont(new Font("굴림", Font.BOLD, 15));
		l7.setBounds(181, 126, 129, 87);
		borderpanel2.add(l7);
		
		RoundedButton2 l8 = new RoundedButton2("사물함" + "<br>" +"8번");
		l8.setFont(new Font("굴림", Font.BOLD, 15));
		l8.setBounds(322, 126, 129, 87);
		borderpanel2.add(l8);
		
		RoundedButton2 l9 = new RoundedButton2("사물함" + "<br>" +"9번");
		l9.setFont(new Font("굴림", Font.BOLD, 15));
		l9.setBounds(463, 126, 129, 87);
		borderpanel2.add(l9);
		
		RoundedButton2 l10 = new RoundedButton2("사물함" + "<br>" +"10번");
		l10.setFont(new Font("굴림", Font.BOLD, 15));
		l10.setBounds(604, 126, 129, 87);
		borderpanel2.add(l10);
		
		RoundedButton2 l11 = new RoundedButton2("사물함" + "<br>" +"11번");
		l11.setFont(new Font("굴림", Font.BOLD, 15));
		l11.setBounds(40, 223, 129, 87);
		borderpanel2.add(l11);
		
		RoundedButton2 l12 = new RoundedButton2("사물함" + "<br>" +"12번");
		l12.setFont(new Font("굴림", Font.BOLD, 15));
		l12.setBounds(181, 223, 129, 87);
		borderpanel2.add(l12);
		
		RoundedButton2 l13 = new RoundedButton2("사물함" + "<br>" +"13번");
		l13.setFont(new Font("굴림", Font.BOLD, 15));
		l13.setBounds(322, 223, 129, 87);
		borderpanel2.add(l13);
		
		RoundedButton2 l14 = new RoundedButton2("사물함" + "<br>" +"14번");
		l14.setFont(new Font("굴림", Font.BOLD, 15));
		l14.setBounds(463, 223, 129, 87);
		borderpanel2.add(l14);
		
		RoundedButton2 l15 = new RoundedButton2("사물함" + "<br>" +"15번");
		l15.setFont(new Font("굴림", Font.BOLD, 15));
		l15.setBounds(604, 223, 129, 87);
		borderpanel2.add(l15);
		
		RoundedButton2 l16 = new RoundedButton2("사물함" + "<br>" +"16번");
		l16.setFont(new Font("굴림", Font.BOLD, 15));
		l16.setBounds(40, 320, 129, 87);
		borderpanel2.add(l16);
		
		RoundedButton2 l17 = new RoundedButton2("사물함" + "<br>" +"17번");
		l17.setFont(new Font("굴림", Font.BOLD, 15));
		l17.setBounds(181, 320, 129, 87);
		borderpanel2.add(l17);
		
		RoundedButton2 l18 = new RoundedButton2("사물함" + "<br>" +"18번");
		l18.setFont(new Font("굴림", Font.BOLD, 15));
		l18.setBounds(322, 320, 129, 87);
		borderpanel2.add(l18);
		
		RoundedButton2 l19 = new RoundedButton2("사물함" + "<br>" +"19번");
		l19.setFont(new Font("굴림", Font.BOLD, 15));
		l19.setBounds(463, 320, 129, 87);
		borderpanel2.add(l19);
		
		RoundedButton2 l20 = new RoundedButton2("사물함" + "<br>" +"20번");
		l20.setFont(new Font("굴림", Font.BOLD, 15));
		l20.setBounds(604, 320, 129, 87);
		borderpanel2.add(l20);
		
		JButton lockerticket = new JButton("결제창 가기");
		lockerticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LockerTicket lo = new LockerTicket();
				frame.dispose();
			}
		});
		lockerticket.setFont(new Font("굴림", Font.BOLD, 15));
		lockerticket.setBounds(704, 17, 123, 23);
		lockerticket.setForeground(new Color(33,112,255));
		borderpanel.add(lockerticket);
		lockerticket.setBorderPainted(false);
		lockerticket.setContentAreaFilled(false);   
	}
}
