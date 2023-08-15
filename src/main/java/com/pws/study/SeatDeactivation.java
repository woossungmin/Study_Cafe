package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JTextField;
import javax.swing.Timer;

public class SeatDeactivation {

	private JFrame frame;
	private JLabel seatnumber;
	private JPanel jpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatDeactivation window = new SeatDeactivation("","",new JPanel(),new JButton(),new JButton());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SeatDeactivation(String seat, String seatnumber, JPanel borderpanel, JButton homebutton,JButton closebutton) {
		initialize(seat,seatnumber,borderpanel,homebutton,closebutton);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String seat, String seatnumber, JPanel borderpanel, JButton homebutton, JButton closebutton) {
		frame = new JFrame();
		frame.setBounds(550, 230, 360, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	      frame.setResizable(false);
	      frame.setVisible(true);
		System.out.println(seatnumber);
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 346, 163);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 322, 143);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255,255,255));
		panel_1.setBorder(border);
		panel_1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 10, 322, 143);
		panel.add(panel2);
		panel2.setBackground(new Color(255,255,255));
		panel2.setBorder(border);
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		RoundedButton2 btnNewButton = new RoundedButton2("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel2.setVisible(true);
				JSONObject data = new JSONObject();
				Post po = new Post();
				try {
					data.put("seatnumber", seatnumber);
					JSONObject check = po.jsonpost("/FindSeat", data);
					String phone = check.getString("phone");
	   				data.put("phone", phone);
					data.put("Number", "0 0 0 0 0");
					check = po.jsonpost("/InsertQrNumber", data);
					
					data.put("phone", "NULL");
					data.put("seatnumber", seatnumber);
					data.put("activations", "1");
					 check = po.jsonpost("/UpdateSeat", data);
					if((check.get("check")).equals("true")) {
						data.put("seatnumber", seatnumber);
						check = po.jsonpost("/FindSeat", data);
						
		                Timer timer = new Timer(2000, new ActionListener() {
		                    public void actionPerformed(ActionEvent evt) {
		                    	frame.dispose();
								Seatpanel sa = new Seatpanel(borderpanel,homebutton,closebutton);
								switchPanel(sa,borderpanel, homebutton);
		                    }
		                });
		                timer.setRepeats(false); // 타이머 반복 실행 안함
		                timer.start(); // 타이머 시작
		                
					}
				}catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(33, 110, 95, 23);
		panel_1.add(btnNewButton);
		
		JLabel text = new JLabel("강제퇴실을 원하시면 확인 버튼을 눌러주세요");
		text.setFont(new Font("굴림", Font.BOLD, 14));
		text.setBounds(12, 75, 298, 23);
		panel_1.add(text);
		text.setForeground(new Color(255, 128, 128));
		
		RoundedButton2 btnNewButton_1 = new RoundedButton2("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setText("취소");
		btnNewButton_1.setBounds(183, 110, 95, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel seatlabel = new JLabel();
		seatlabel.setFont(new Font("굴림", Font.BOLD, 22));
		seatlabel.setBounds(52, 24, 237, 43);
		panel_1.add(seatlabel);
		seatlabel.setForeground(new Color(114,166,255));
		seatlabel.setText(seat + " 번");
		
		JLabel text_1 = new JLabel("강제퇴실이 완료되었습니다!");
		text_1.setBounds(30, 42, 266, 58);
		panel2.add(text_1);
		text_1.setForeground(new Color(255, 128, 128));
		text_1.setFont(new Font("굴림", Font.BOLD, 20));
	}
    private void switchPanel(JPanel newPanel,JPanel borderpanel, JButton homebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
        
}
