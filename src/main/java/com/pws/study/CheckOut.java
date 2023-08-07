package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut window = new CheckOut("","","",new JFrame());
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
	public CheckOut(String phone, String seatnumber,String seattime, JFrame frame1) {
		initialize(phone,seatnumber,seattime,frame1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String phone, String seatnumber,String seattime, JFrame frame1) {
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
	   
	   JPanel panel_3 = new JPanel();
	   panel_3.setBounds(12, 82, 488, 361);
	   panel_1.add(panel_3);
	   panel_3.setBackground(new Color(255,255,255));
	   Post po = new Post();
	   JSONObject data = new JSONObject();
	   RoundedButton2 okbutton = new RoundedButton2("New button");
	   okbutton.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent e) {
	   		Info.phone = "NULL";
	   		Info.pw = "NULL";
	   		Info.seat_number = "NULL";
	   		Info.seat_time = "NULL";
			try {
				data.put("phone", "NULL");
				data.put("seatnumber", seatnumber);
				data.put("activations", "1");
				JSONObject	check = po.jsonpost("/UpdateSeat", data);
   				data.put("phone", phone);
				data.put("Number", "0 0 0 0 0");
				check = po.jsonpost("/InsertQrNumber", data);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   		frame1.dispose();
	   		Login lo = new Login();
	   		Message ms = new Message("퇴실이 완료되었습니다!");
	   		
	   	}
	   });
		okbutton.setFont(new Font("굴림", Font.BOLD, 15));
		okbutton.setText("확인");
		okbutton.setBounds(75, 304, 95, 39);
		panel_3.add(okbutton);
		
		RoundedButton2 okbutton_1 = new RoundedButton2("New button");
		okbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		okbutton_1.setText("취소");
		okbutton_1.setFont(new Font("굴림", Font.BOLD, 15));
		okbutton_1.setBounds(315, 304, 95, 39);
		panel_3.add(okbutton_1);
	   
	   JLabel lblNewLabel = new JLabel("POTEN STUDY CAFE");
	   lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
	   lblNewLabel.setBounds(55, 6, 167, 28);
	   panel_2.add(lblNewLabel);
	   lblNewLabel.setForeground(new Color(114,166,255));
	   panel_3.setLayout(null);
	   
	   JLabel lblNewLabel_1 = new JLabel("전   화  번   호  : ");
	   lblNewLabel_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1.setBounds(12, 32, 164, 28);
	   panel_3.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel_1_1 = new JLabel("좌   석  번   호  : ");
	   lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1.setBounds(12, 112, 163, 24);
	   panel_3.add(lblNewLabel_1_1);
	   
	   JLabel lblNewLabel_1_1_1 = new JLabel("좌석 사용 기한  : ");
	   lblNewLabel_1_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1.setBounds(12, 192, 164, 24);
	   panel_3.add(lblNewLabel_1_1_1);
	   
		JLabel lblNewLabel_1_1_1_1 = new JLabel("정말 퇴실하시겠습니까?");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 72, 72));
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(130, 255, 259, 28);
		panel_3.add(lblNewLabel_1_1_1_1);

	   JLabel phonelabel = new JLabel("");
	   phonelabel.setText(phone);
	   phonelabel.setForeground(new Color(114, 166, 255));
	   phonelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   phonelabel.setBounds(188, 32, 288, 28);
	   panel_3.add(phonelabel);
		
	   String seat_id = "";
	   	try {
			data.put("seat_number", seatnumber);
		   	JSONObject check = po.jsonpost("/FindSeatId", data);
		   	seat_id = check.getString("id");
	   	} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   JLabel seatlabel = new JLabel("");
	   seatlabel.setForeground(new Color(114, 166, 255));
	   seatlabel.setFont(new Font("굴림", Font.BOLD, 20));
	   seatlabel.setBounds(187, 112, 288, 28);
	   panel_3.add(seatlabel);
	   seatlabel.setText(seat_id + " , " + seatnumber + "번");
	   
	   JLabel timelabel = new JLabel("");
	   timelabel.setForeground(new Color(114, 166, 255));
	   timelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   timelabel.setBounds(188, 190, 288, 28);
	   panel_3.add(timelabel);
	   String arr[] = seattime.split(" ");
		  for(String cut : arr) {
			 int year = Integer.valueOf(arr[0]);
			 int  month = Integer.valueOf(arr[1]);
			 int  day = Integer.valueOf(arr[2]);
			 int  hour = Integer.valueOf(arr[3]);
			 int  minute = Integer.valueOf(arr[4]);
			 
		  String formattedMonth = String.format("%02d", month);
		  String formattedDay = String.format("%02d", day);
		  String formattedHour = String.format("%02d", hour);
		  String formattedMinute = String.format("%02d", minute);
		  timelabel.setText(year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분");
	   
		
	   
		  }
	}
}
