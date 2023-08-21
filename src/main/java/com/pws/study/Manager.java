package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager {

	private JFrame frame;
    private JPanel borderPanel;
    private JButton homeButton;
    private JButton closeButton;
    private Loginpanel loginPanel;
    private Homepanel homePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager window = new Manager();
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
	public Manager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame();
	      frame.setBounds(100, 5, 1120, 680);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
		      frame.setResizable(false);
		      frame.setVisible(true);
	      Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
	      
	      JPanel panel_4 = new JPanel();
	      panel_4.setBounds(0, 0, 1106, 643);
	      frame.getContentPane().add(panel_4);
	      panel_4.setLayout(null);
	      panel_4.setBackground(new Color(255,255,255));
	      
	      
	      JPanel borderpanel = new JPanel();
	      borderpanel.setBounds(237, 10, 857, 623);
	      panel_4.add(borderpanel);
	      borderpanel.setLayout(null);
	      borderpanel.setBackground(new Color(255,255,255));
	      borderpanel.setBorder(border);
	      borderPanel = borderpanel; 
	      Homepanel homepanel = new Homepanel(); 
	      
	      JButton homebutton = new JButton("");
	      homebutton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		 Homepanel homepanel = new Homepanel(); 
	               switchPanel(homepanel);
	      	}
	      });
	      homebutton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\home.png"));
	      homebutton.setForeground(new Color(114, 166, 255));
	      homebutton.setFont(new Font("굴림", Font.BOLD, 20));
	      homebutton.setFocusPainted(false);
	      homebutton.setContentAreaFilled(false);
	      homebutton.setBorderPainted(false);
	      homebutton.setBounds(12, 10, 32, 32);
	      borderpanel.add(homebutton);
	      homeButton = homebutton;
	      homePanel = homepanel;
	      
	      ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop");
	      
	      JButton modifybutton = new JButton(" 카드번호 찾기");
	      JButton memberbutton = new JButton("회원");
	      JButton seatbutton = new JButton("좌석 ");
	  	  JButton lockbutton = new JButton("사물함");
	  	  JButton ticketbutton = new JButton("이용권");
	  	  ticketbutton.addActionListener(new ActionListener() {
	  	  	public void actionPerformed(ActionEvent e) {
	  	  		Ticketpanel ti = new Ticketpanel(borderpanel,homeButton,closeButton);
	  	  		switchPanel(ti);
	  	  	}
	  	  });
	  	  JButton salesbutton = new JButton("매출");
	  	  JButton faqbutton = new JButton("FAQ");
	  	  JButton qabutton = new JButton("Q&A");
	  	  JButton caffebutton = new JButton("카페");
	  	  
	      JButton closebutton = new JButton("");
	      closebutton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      		Login lo = new Login();
	      		Info2.phone = "NULL";
	      	}
	      });
	      closebutton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
	      closebutton.setForeground(new Color(114, 166, 255));
	      closebutton.setFont(new Font("굴림", Font.BOLD, 20));
	      closebutton.setFocusPainted(false);
	      closebutton.setContentAreaFilled(false);
	      closebutton.setBorderPainted(false);
	      closebutton.setBounds(813, 10, 32, 32);
	      borderpanel.add(closebutton);
	      closeButton = closebutton;
	  	  
	      Loginpanel lo = new Loginpanel(homePanel,borderPanel,homebutton,closeButton,modifybutton,memberbutton,seatbutton,lockbutton,ticketbutton,
	    		  salesbutton,faqbutton,qabutton,caffebutton);
	      lo.setBounds(23, 45, 813, 568);
	      borderpanel.add(lo);
	      loginPanel = lo;
	      
	      JPanel panel = new JPanel();
	      panel.setBounds(12, 93, 231, 540);
	      panel_4.add(panel);
	      panel.setBackground(new Color(217,231,255));
	      panel.setBorder(border);
	      panel.setLayout(null);
	      
	  	  modifybutton.setBounds(24, 21, 197, 43);
	      modifybutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            modifybutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            modifybutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  modifybutton.setForeground(new Color(114, 166, 255));
	  	  modifybutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  modifybutton.setFocusPainted(false);
	  	  modifybutton.setContentAreaFilled(false);
	  	  modifybutton.setBorderPainted(false);
	  	  panel.add(modifybutton);
	      
	      memberbutton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		Memberpanel me = new Memberpanel();
	            switchPanel(me);
	      	}
	      });
	      memberbutton.setBounds(37, 79, 100, 43);
	      memberbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            memberbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            memberbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});

	      memberbutton.setFont(new Font("굴림", Font.BOLD, 20));
	      panel.add(memberbutton);
	      memberbutton.setForeground(new Color(114,166,255));
	      memberbutton.setBorderPainted(false);
	  	  memberbutton.setContentAreaFilled(false);
	  	  memberbutton.setFocusPainted(false);
	      
	      seatbutton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
		      	  Seatpanel seatPanel = new Seatpanel(borderpanel,homeButton,closeButton); 
	               switchPanel(seatPanel);
	      	}
	      });
	      seatbutton.setBounds(41, 134, 100, 43);
	      seatbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            seatbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            seatbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	      seatbutton.setFont(new Font("굴림", Font.BOLD, 20));
	      seatbutton.setForeground(new Color(114,166,244));
	      panel.add(seatbutton);
	      seatbutton.setBorderPainted(false);
	  	  seatbutton.setContentAreaFilled(false);
	  	  seatbutton.setFocusPainted(false);
	  	  
	  	  lockbutton.addActionListener(new ActionListener() {
		  	  	public void actionPerformed(ActionEvent e) {
			      	  Lockerpanel lockpanel = new Lockerpanel(borderpanel,homebutton,closebutton); 
		               switchPanel(lockpanel);
		  	  	}
		  	  });
	  	  lockbutton.setBounds(46, 189, 100, 43);
	      lockbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            lockbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            lockbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  lockbutton.setForeground(new Color(114, 166, 244));
	  	  lockbutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  lockbutton.setFocusPainted(false);
	  	  lockbutton.setContentAreaFilled(false);
	  	  lockbutton.setBorderPainted(false);
	  	  panel.add(lockbutton);
	  	  
	  	  ticketbutton.setBounds(46,244, 100, 43);
	      ticketbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            ticketbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            ticketbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  ticketbutton.setForeground(new Color(114, 166, 244));
	  	  ticketbutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  ticketbutton.setFocusPainted(false);
	  	  ticketbutton.setContentAreaFilled(false);
	  	  ticketbutton.setBorderPainted(false);
	  	  panel.add(ticketbutton);
	  	  
	  	  salesbutton.setBounds(37, 299, 100, 43);
	      salesbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            salesbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            salesbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  salesbutton.setForeground(new Color(114, 166, 244));
	  	  salesbutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  salesbutton.setFocusPainted(false);
	  	  salesbutton.setContentAreaFilled(false);
	  	  salesbutton.setBorderPainted(false);
	  	  panel.add(salesbutton);

	  	  faqbutton.setBounds(37, 354, 100, 43);
	      faqbutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            faqbutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            faqbutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  faqbutton.setForeground(new Color(114, 166, 244));
	  	  faqbutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  faqbutton.setFocusPainted(false);
	  	  faqbutton.setContentAreaFilled(false);
	  	  faqbutton.setBorderPainted(false);
	  	  panel.add(faqbutton);
	  	  
	  	  qabutton.setBounds(37, 409, 100, 43);
	      qabutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            qabutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            qabutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  qabutton.setForeground(new Color(114, 166, 244));
	  	  qabutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  qabutton.setFocusPainted(false);
	  	  qabutton.setContentAreaFilled(false);
	  	  qabutton.setBorderPainted(false);
	  	  panel.add(qabutton);
	  	  
	  	  caffebutton.setBounds(37, 464, 100, 43);
	      caffebutton.getModel().addChangeListener(new ChangeListener() {
	    	    @Override
	    	    public void stateChanged(ChangeEvent e) {
	    	        ButtonModel model = (ButtonModel) e.getSource();
	    	        
	    	        if (model.isRollover()) {
	    	            caffebutton.setForeground(Color.WHITE); // 글자 색상 변경
	    	        } else {
	    	            caffebutton.setForeground(new Color(114, 166, 255)); // 원래 글자 색상으로 변경
	    	        }
	    	    }
	    	});
	  	  caffebutton.setForeground(new Color(114, 166, 244));
	  	  caffebutton.setFont(new Font("굴림", Font.BOLD, 20));
	  	  caffebutton.setFocusPainted(false);
	  	  caffebutton.setContentAreaFilled(false);
	  	  caffebutton.setBorderPainted(false);
	  	  panel.add(caffebutton);
	  	  
	  	  if(Info2.phone.equals("NULL")) {
	  		  memberbutton.setEnabled(false);
	  		  seatbutton.setEnabled(false);
	  		  lockbutton.setEnabled(false);
	  		  faqbutton.setEnabled(false);
	  		  qabutton.setEnabled(false);
	  		  caffebutton.setEnabled(false);
	  		  ticketbutton.setEnabled(false);
	  		  salesbutton.setEnabled(false);
	  		  homebutton.setEnabled(false);
	  		  modifybutton.setEnabled(false);
	  	  }
	  	  else if(!Info2.phone.equals("NULL")) {
	  		  memberbutton.setEnabled(true);
	  		  seatbutton.setEnabled(true);
	  		  lockbutton.setEnabled(true);
	  		  faqbutton.setEnabled(true);
	  		  qabutton.setEnabled(true);
	  		  caffebutton.setEnabled(true);
	  		  ticketbutton.setEnabled(true);
	  		  salesbutton.setEnabled(true);
	  		  homebutton.setEnabled(true);
	  		  modifybutton.setEnabled(false);
	  	  }
	  	  
	  	  JLabel modifylabel = new JLabel("");
	  	  panel.add(modifylabel);
	  	  modifylabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\modify.png"));
	  	  modifylabel.setBounds(30, 28, 24, 24);
	  	  
	  	  JLabel memberlabel = new JLabel("");
	  	  memberlabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\member.png"));
	  	  memberlabel.setBounds(17, 87, 24, 24);
	  	  panel.add(memberlabel);
	  	  
	  	  JLabel seatlabel = new JLabel("");
	  	  seatlabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\office-chair.png"));
	  	  seatlabel.setBounds(12, 137, 32, 32);
	  	  panel.add(seatlabel);
	  	  
	  	  JLabel lockerlabel = new JLabel("");
	  	  lockerlabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\locker.png"));
	  	  lockerlabel.setBounds(16, 191, 32, 32);
	  	  panel.add(lockerlabel);
	  	  
	  	  JLabel ticketlabel = new JLabel("");
	  	  ticketlabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\ticket.png"));
	  	  ticketlabel.setBounds(14, 247, 32, 32);
	  	  panel.add(ticketlabel);
	  	  
	  	  JLabel saleslabel = new JLabel("");
	  	  saleslabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\dollar.png"));
	  	  saleslabel.setBounds(15, 304, 29, 29);
	  	  panel.add(saleslabel);
	  	  
	  	  JLabel faqlabel = new JLabel("");
	  	  faqlabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\faq.png"));
	  	  faqlabel.setBounds(14, 357, 32, 32);
	  	  panel.add(faqlabel);
	  	  
	  	  JLabel qalabel = new JLabel("");
	  	  qalabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\raise-your-hand-to-ask.png"));
	  	  qalabel.setBounds(12, 411, 32, 32);
	  	  panel.add(qalabel);
	  	  
	  	  JLabel caffelabel = new JLabel("");
	  	  caffelabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\coffee-mug.png"));
	  	  caffelabel.setBounds(14, 466, 32, 32);
	  	  panel.add(caffelabel);
	  	  
	  	  JPanel panel_1 = new JPanel();
	  	  panel_1.setBounds(12, 10, 231, 86);
	  	  panel_4.add(panel_1);
	  	  panel_1.setLayout(null);
	  	  panel_1.setBackground(new Color(217,231,255));
	  	  panel_1.setBorder(border);
	  	  
	  	  JLabel projectname_1 = new JLabel("포텐스터디카페");
	  	  projectname_1.setBounds(46, 10, 194, 43);
	  	  panel_1.add(projectname_1);
	  	  projectname_1.setForeground(new Color(114, 166, 255));
	  	  projectname_1.setFont(new Font("굴림", Font.BOLD, 24));
	  	  
	  	  JLabel projectname2_1 = new JLabel("POTEN STUDY CAFE");
	  	  projectname2_1.setBounds(12, 39, 226, 37);
	  	  panel_1.add(projectname2_1);
	  	  projectname2_1.setForeground(new Color(114, 166, 255));
	  	  projectname2_1.setFont(new Font("굴림", Font.BOLD, 20));
	  	  
	  	  JLabel label_1 = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\clock2.png"));
	  	  label_1.setBounds(12, 15, 30, 30);
	  	  panel_1.add(label_1);

	  	  
	}
    private void switchPanel(JPanel newPanel) {
        borderPanel.removeAll();
        borderPanel.add(homeButton);
        borderPanel.add(closeButton);
        borderPanel.add(newPanel);
        borderPanel.revalidate();
        borderPanel.repaint();
    }
}


