package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LockerCheck {

	private JFrame frame;
	int year;
	int month;
	int day;
	int hour;
	int minute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LockerCheck window = new LockerCheck("","",new JFrame());
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
	public LockerCheck(String lock, String lock_number, JFrame frame1) {
		initialize(lock,lock_number,frame1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String lock, String lock_number, JFrame frame1) {
		frame = new JFrame();
		frame.setBounds(380, 120, 550, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 536, 473);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 512, 453);
		panel.add(panel_1);
		frame.setVisible(true);
		panel_1.setBorder(border);
	   panel_1.setLayout(null);
	   panel_1.setBackground(new Color(255,255,255));
	   
	   JPanel panel_2 = new JPanel();
	   panel_2.setBounds(123, 10, 271, 39);
	   panel_1.add(panel_2);
	   panel_2.setLayout(null);
	   panel_2.setBorder(border);
	   panel_2.setBackground(new Color(255,255,255));
	   
	   JLabel lblNewLabel = new JLabel("POTEN STUDY CAFE");
	   lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
	   lblNewLabel.setBounds(55, 6, 167, 28);
	   panel_2.add(lblNewLabel);
	   lblNewLabel.setForeground(new Color(114,166,255));
	   
	   JLabel lblNewLabel_1 = new JLabel("전    화   번    호  : ");
	   lblNewLabel_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1.setBounds(25, 112, 184, 28);
	   panel_1.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel_1_1 = new JLabel("사 물 함    번  호  : ");
	   lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1.setBounds(25, 192, 184, 28);
	   panel_1.add(lblNewLabel_1_1);
	   
	   JLabel lblNewLabel_1_1_1 = new JLabel("사물함 사용 기한  : ");
	   lblNewLabel_1_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1.setBounds(25, 272, 202, 28);
	   panel_1.add(lblNewLabel_1_1_1);
	   
	   JLabel phonelabel = new JLabel("");
	   phonelabel.setForeground(new Color(114, 166, 255));
	   phonelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   phonelabel.setBounds(221, 112, 279, 28);
	   panel_1.add(phonelabel);
	   
	   JLabel locklabel = new JLabel("");
	   locklabel.setForeground(new Color(114, 166, 255));
	   locklabel.setFont(new Font("굴림", Font.BOLD, 20));
	   locklabel.setBounds(221, 192, 279, 28);
	   panel_1.add(locklabel);
	   
	   JLabel timelabel = new JLabel("");
	   timelabel.setForeground(new Color(114, 166, 255));
	   timelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   timelabel.setBounds(221, 272, 279, 28);
	   panel_1.add(timelabel);
	   
	   JLabel lblNewLabel_1_1_1_1 = new JLabel("사물함을 선택하시겠습니까?");
	   lblNewLabel_1_1_1_1.setForeground(new Color(255, 72, 72));
	   lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1_1.setBounds(123, 340, 270, 28);
	   panel_1.add(lblNewLabel_1_1_1_1);
	   
	   JPanel panel_3 = new JPanel();
	   panel_3.setVisible(false);
	   
	   RoundedButton2 okbutton = new RoundedButton2("확인");
	   okbutton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JSONObject data = new JSONObject();
		        Post po = new Post();
		        try {
		            Info.lock_number = lock_number;
		            data.put("phone", Info.phone);
		            data.put("locknumber", lock_number);
		            data.put("activations", "0");
		            JSONObject check = po.jsonpost("/UpdateLock", data);

		            panel_3.setVisible(true);
		            panel_1.setVisible(false);

		            // Timer를 사용하여 3초 후에 frame을 종료
		            Timer timer = new Timer(3000, new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    frame.dispose();
		                    frame1.dispose();
		                    Locker lo = new Locker();
		                }
		            });
		            timer.setRepeats(false); // 타이머를 단 한 번만 실행
		            timer.start();
		            System.out.println(Info.seat_number);
		        } catch (JSONException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	   okbutton.setFont(new Font("굴림", Font.BOLD, 15));
	   okbutton.setText("확인");
	   okbutton.setBounds(90, 390, 95, 39);
	   panel_1.add(okbutton);
	   
	   RoundedButton2 nobutton = new RoundedButton2("취소");
	   nobutton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		frame.dispose();
	   	}
	   });
	   nobutton.setText("취소");
	   nobutton.setFont(new Font("굴림", Font.BOLD, 15));
	   nobutton.setBounds(330, 390, 95, 39);
	   panel_1.add(nobutton);
	   
	   JLabel lblNewLabel_1_1_1_1_1 = new JLabel("사물함 선택이 완료되었습니다!");
	   lblNewLabel_1_1_1_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1_1_1.setBounds(105, 364, 301, 28);
	   panel_3.add(lblNewLabel_1_1_1_1_1);
	   
	   JLabel lblNewLabel_2 = new JLabel("");
	   lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\locker.gif"));
	   lblNewLabel_2.setBounds(120, 60, 280, 280);
	   panel_3.add(lblNewLabel_2);

	   panel_3.setBounds(12, 10, 512, 453);
	   panel.add(panel_3);
	   panel_3.setLayout(null);
	   panel_3.setBackground(new Color(255,255,255));
	   panel_3.setBorder(border);

	   JPanel labelpanel = new JPanel();
	   labelpanel.setBounds(123, 10, 271, 39);
	   panel_3.add(labelpanel);
	   labelpanel.setLayout(null);
	   labelpanel.setBorder(border);
	   labelpanel.setBackground(new Color(255,255,255));
	   
	   JLabel label = new JLabel("POTEN STUDY CAFE");
	   label.setFont(new Font("굴림", Font.BOLD, 15));
	   label.setBounds(55, 6, 167, 28);
	   labelpanel.add(label);
	   label.setForeground(new Color(114,166,255));
		JSONObject data = new JSONObject();
		Post po = new Post();
		try {
			data.put("phone", Info.phone);
			JSONObject check = po.jsonpost("/FindLockTime", data);
   		String lock_time = check.getString("lock_time");
   		if((check.get("check")).equals("true"))
			{
   			 String arr[] = lock_time.split(" ");
	    		  for(String cut : arr) {
	    			  year = Integer.valueOf(arr[0]);
	    			  month = Integer.valueOf(arr[1]);
	    			  day = Integer.valueOf(arr[2]);
	    			  hour = Integer.valueOf(arr[3]);
	    			  minute = Integer.valueOf(arr[4]);
	    			  String formattedMonth = String.format("%02d", month);
		    		  String formattedDay = String.format("%02d", day);
		    		  String formattedHour = String.format("%02d", hour);
		    		  String formattedMinute = String.format("%02d", minute);
		    		  phonelabel.setText(Info.phone);
		    		  locklabel.setText(lock + " 번");
		    		  timelabel.setText(year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분");
		    		  
	    		  }
	    		  
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
