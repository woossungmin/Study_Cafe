package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
		
		RoundedButton3 l1 = new RoundedButton3("사물함" + "<br>" +"1번");
		l1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 1", "l1", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 1", "l1", frame);
				}
			}
		});
		l1.setFont(new Font("굴림", Font.BOLD, 15));
		l1.setBounds(40, 29, 129, 87);
		borderpanel2.add(l1);
		
		RoundedButton3 l2 = new RoundedButton3("사물함" + "<br>" +"2번");
		l2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 2", "l2", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 2", "l2", frame);
				}
			}
		});
		l2.setFont(new Font("굴림", Font.BOLD, 15));
		l2.setBounds(181, 29, 129, 87);
		borderpanel2.add(l2);
		
		RoundedButton3 l3 = new RoundedButton3("사물함" + "<br>" +"3번");
		l3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 3", "l3", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 3", "l3", frame);
				}
			}
		});
		l3.setFont(new Font("굴림", Font.BOLD, 15));
		l3.setBounds(322, 29, 129, 87);
		borderpanel2.add(l3);
		
		RoundedButton3 l4 = new RoundedButton3("사물함" + "<br>" +"4번");
		l4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 4", "l4", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 4", "l4", frame);
				}
			}
		});
		l4.setFont(new Font("굴림", Font.BOLD, 15));
		l4.setBounds(463, 29, 129, 87);
		borderpanel2.add(l4);
		
		RoundedButton3 l5 = new RoundedButton3("사물함" + "<br>" +"5번");
		l5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 5", "l5", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 5", "l5", frame);
				}
			}
		});
		l5.setFont(new Font("굴림", Font.BOLD, 15));
		l5.setBounds(604, 29, 129, 87);
		borderpanel2.add(l5);
		
		RoundedButton3 l6 = new RoundedButton3("사물함" + "<br>" +"6번");
		l6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 6", "l6", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 6", "l6", frame);
				}
			}
		});
		l6.setFont(new Font("굴림", Font.BOLD, 15));
		l6.setBounds(40, 126, 129, 87);
		borderpanel2.add(l6);
		
		RoundedButton3 l7 = new RoundedButton3("사물함" + "<br>" +"7번");
		l7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 7", "l7", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 7", "l7", frame);
				}
			}
		});
		l7.setFont(new Font("굴림", Font.BOLD, 15));
		l7.setBounds(181, 126, 129, 87);
		borderpanel2.add(l7);
		
		RoundedButton3 l8 = new RoundedButton3("사물함" + "<br>" +"8번");
		l8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 8", "l8", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 8", "l8", frame);
				}
			}
		});
		l8.setFont(new Font("굴림", Font.BOLD, 15));
		l8.setBounds(322, 126, 129, 87);
		borderpanel2.add(l8);
		
		RoundedButton3 l9 = new RoundedButton3("사물함" + "<br>" +"9번");
		l9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 9", "l9", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 9", "l9", frame);
				}
			}
		});
		l9.setFont(new Font("굴림", Font.BOLD, 15));
		l9.setBounds(463, 126, 129, 87);
		borderpanel2.add(l9);
		
		RoundedButton3 l10 = new RoundedButton3("사물함" + "<br>" +"10번");
		l10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 10", "l10", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 10", "l10", frame);
				}
			}
		});
		l10.setFont(new Font("굴림", Font.BOLD, 15));
		l10.setBounds(604, 126, 129, 87);
		borderpanel2.add(l10);
		
		RoundedButton3 l11 = new RoundedButton3("사물함" + "<br>" +"11번");
		l11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 11", "l11", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 11", "l11", frame);
				}
			}
		});
		l11.setFont(new Font("굴림", Font.BOLD, 15));
		l11.setBounds(40, 223, 129, 87);
		borderpanel2.add(l11);
		
		RoundedButton3 l12 = new RoundedButton3("사물함" + "<br>" +"12번");
		l12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 12", "l12", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 12", "l12", frame);
				}
			}
		});
		l12.setFont(new Font("굴림", Font.BOLD, 15));
		l12.setBounds(181, 223, 129, 87);
		borderpanel2.add(l12);
		
		RoundedButton3 l13 = new RoundedButton3("사물함" + "<br>" +"13번");
		l13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 13", "l13", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 13", "l13", frame);
				}
			}
		});
		l13.setFont(new Font("굴림", Font.BOLD, 15));
		l13.setBounds(322, 223, 129, 87);
		borderpanel2.add(l13);
		
		RoundedButton3 l14 = new RoundedButton3("사물함" + "<br>" +"14번");
		l14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 14", "l14", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 14", "l14", frame);
				}
			}
		});
		l14.setFont(new Font("굴림", Font.BOLD, 15));
		l14.setBounds(463, 223, 129, 87);
		borderpanel2.add(l14);
		
		RoundedButton3 l15 = new RoundedButton3("사물함" + "<br>" +"15번");
		l15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 15", "l15", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 15", "l15", frame);
				}
			}
		});
		l15.setFont(new Font("굴림", Font.BOLD, 15));
		l15.setBounds(604, 223, 129, 87);
		borderpanel2.add(l15);
		
		RoundedButton3 l16 = new RoundedButton3("사물함" + "<br>" +"16번");
		l16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 16", "l16", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 16", "l16", frame);
				}
			}
		});
		l16.setFont(new Font("굴림", Font.BOLD, 15));
		l16.setBounds(40, 320, 129, 87);
		borderpanel2.add(l16);
		
		RoundedButton3 l17 = new RoundedButton3("사물함" + "<br>" +"17번");
		l17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 17", "l17", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 17", "l17", frame);
				}
			}
		});
		l17.setFont(new Font("굴림", Font.BOLD, 15));
		l17.setBounds(181, 320, 129, 87);
		borderpanel2.add(l17);
		
		RoundedButton3 l18 = new RoundedButton3("사물함" + "<br>" +"18번");
		l18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 18", "l18", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 18", "l18", frame);
				}
			}
		});
		l18.setFont(new Font("굴림", Font.BOLD, 15));
		l18.setBounds(322, 320, 129, 87);
		borderpanel2.add(l18);
		
		RoundedButton3 l19 = new RoundedButton3("사물함" + "<br>" +"19번");
		l19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 19", "l19", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 19", "l19", frame);
				}
			}
		});
		l19.setFont(new Font("굴림", Font.BOLD, 15));
		l19.setBounds(463, 320, 129, 87);
		borderpanel2.add(l19);
		
		RoundedButton3 l20 = new RoundedButton3("사물함" + "<br>" +"20번");
		l20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Info.lock_number.equals("NULL")) {
					LockerCheck lo = new LockerCheck("사물함 20", "l20", frame);	
				}
				else if(!Info.lock_number.equals("NULL")) {
					UpdateLock up = new UpdateLock("사물함 20", "l20", frame);
				}
			}
		});
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
		JSONObject data = new JSONObject();
		try {
			String activations = "0";
			data.put("activations", activations);
			Post po = new Post();
			
			JSONObject check = po.jsonpost("/FindLockNumber", data);
			if((check.get("check")).equals("true"))
			{
				JSONArray jArray = new JSONArray();
				jArray = (JSONArray) check.get("lock_numbers");
				
				Map<String, RoundedButton3> buttonMap = new HashMap<>(); //hashMap으로 문자열과 버튼 객체 매칭함
				buttonMap.put("l1",l1);
				buttonMap.put("l2",l2);
				buttonMap.put("l3",l3);
				buttonMap.put("l4",l4);
				buttonMap.put("l5",l5);
				buttonMap.put("l6",l6);
				buttonMap.put("l7",l7);
				buttonMap.put("l8",l8);
				buttonMap.put("l9",l9);
				buttonMap.put("l10",l10);
				buttonMap.put("l11",l11);
				buttonMap.put("l12",l12);
				buttonMap.put("l13",l13);
				buttonMap.put("l14",l14);
				buttonMap.put("l15",l15);
				buttonMap.put("l16",l16);
				buttonMap.put("l17",l17);
				buttonMap.put("l18",l18);
				buttonMap.put("l19",l19);
				buttonMap.put("l20",l20);
				
		        Color selectedColor = new Color(114,166,255).brighter();
		        Color defaultColor = new Color(200, 196, 196);

			        for(int i = 0; i < jArray.length(); i++) {
			            String lockNumber = (String) jArray.get(i); // 좌석 번호를 가져옵니다.
			                RoundedButton3 button = buttonMap.get(lockNumber);
			                if (Info.lock_number.equals(lockNumber)) {
			                    button.setBackgroundColor(selectedColor);
			                } else {
			                    button.setBackgroundColor(defaultColor);
			                }
			                button.setBorderPainted(false);
			                button.setEnabled(false);
			        }
			    } else {
			        // ...
			    }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
