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
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Lockactivation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lockactivation window = new Lockactivation("","",new JPanel(),new JButton(),new JButton());
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
	public Lockactivation(String lock,String lock_number,JPanel borderpanel, JButton homebutton, JButton closebutton) {
		initialize(lock, lock_number, borderpanel, homebutton, closebutton);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String lock, String lock_number,JPanel borderpanel, JButton homebutton, JButton closebutton ) {
		frame = new JFrame();
		frame.setBounds(550, 230, 360, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setResizable(false);
	    frame.setVisible(true);
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
		
		JLabel locklabel = new JLabel();
		locklabel.setFont(new Font("굴림", Font.BOLD, 25));
		locklabel.setBounds(85, 30, 136, 30);
		panel_1.add(locklabel);
		locklabel.setForeground(new Color(255, 128, 128));
		locklabel.setText(lock);
		
		JLabel locklabel_1 = new JLabel();
		locklabel_1.setText("번");
		locklabel_1.setForeground(new Color(114, 166, 255));
		locklabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		locklabel_1.setBounds(210, 32, 38, 27);
		panel_1.add(locklabel_1);
		
		JLabel locklabel_2 = new JLabel();
		locklabel_2.setText("활성화를 원하시면 확인 버튼을 눌러주세요.");
		locklabel_2.setForeground(new Color(114, 166, 255));
		locklabel_2.setFont(new Font("굴림", Font.BOLD, 13));
		locklabel_2.setBounds(22, 80, 285, 30);
		panel_1.add(locklabel_2);
		
		JLabel Countlabel3 = new JLabel("3");
		Countlabel3.setFont(new Font("굴림", Font.BOLD, 20));
		Countlabel3.setBounds(150, 105, 25, 30);
		Countlabel3.setForeground(new Color(255, 128, 128));
		
		JLabel Countlabel2 = new JLabel("2");
		Countlabel2.setFont(new Font("굴림", Font.BOLD, 20));
		Countlabel2.setBounds(150, 105, 25, 30);
		Countlabel2.setForeground(new Color(255, 128, 128));
		
		JLabel Countlabel1 = new JLabel("1");
		Countlabel1.setFont(new Font("굴림", Font.BOLD, 20));
		Countlabel1.setBounds(150, 105, 25, 30);
		Countlabel1.setForeground(new Color(255, 128, 128));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 10, 322, 143);
		panel.add(panel2);
		panel2.setBackground(new Color(255,255,255));
		panel2.setBorder(border);
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		JLabel text_1 = new JLabel("활성화가 완료되었습니다!");
		text_1.setBounds(37, 43, 261, 24);
		panel2.add(text_1);
		text_1.setForeground(new Color(255, 128, 128));
		text_1.setFont(new Font("굴림", Font.BOLD, 20));
		
		RoundedButton2 btnNewButton = new RoundedButton2("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel2.setVisible(true);
				JSONObject data = new JSONObject();
				Post po = new Post();
				try {
					data.put("lock_number", lock_number);
					data.put("phone", "NULL");
					data.put("activations", "1");
					JSONObject check = po.jsonpost("/UpdateLock", data);		
					if((check.get("check")).equals("true")) {
						
						Timer timer = new Timer(1000, new ActionListener() {
						    int countdown = 3; // 초기 카운트 값
						    boolean threadExecuted = false;
						    
						    public void actionPerformed(ActionEvent evt) {
						        if (countdown > 0) {
						            if (countdown == 3) {
						                panel2.add(Countlabel3); // 3초일 때는 Countlabel3을 추가
						            } else if (countdown == 2) {
						                panel2.remove(Countlabel3); // 2초일 때는 Countlabel3 제거
						                panel2.add(Countlabel2); // Countlabel2 추가
						            } else if (countdown == 1) {
						                panel2.remove(Countlabel2); // 1초일 때는 Countlabel2 제거
						                panel2.add(Countlabel1); // Countlabel1 추가
						            }

						            panel2.revalidate(); // 패널 갱신
						            panel2.repaint(); // 패널 다시 그리기

						            countdown--; // 카운트 다운 값 감소
						        } else if (!threadExecuted) {
						        	threadExecuted = true;
						            frame.dispose();
						            Lockerpanel sa = new Lockerpanel(borderpanel,homebutton,closebutton);
						            switchPanel(sa,borderpanel, homebutton,closebutton);
						        }
						    }
						});

						timer.setInitialDelay(0); // 타이머 초기 지연 시간을 0으로 설정
						timer.start(); // 타이머 시작
		                
					}
				}catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(32, 110, 95, 23);
		panel_1.add(btnNewButton);
		
		RoundedButton2 btnNewButton_1 = new RoundedButton2("확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setText("취소");
		btnNewButton_1.setBounds(185, 110, 95, 23);
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
