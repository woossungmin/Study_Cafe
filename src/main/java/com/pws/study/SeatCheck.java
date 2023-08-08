package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class SeatCheck {

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
					SeatCheck window = new SeatCheck("","",new JFrame());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public SeatCheck(String seat, String seatnumber,JFrame frame1) {
		initialize(seat, seatnumber,frame1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String seat, String seatnumber, JFrame frame1) {
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
	   
	   JLabel lblNewLabel_1 = new JLabel("전   화  번   호  : ");
	   lblNewLabel_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1.setBounds(25, 112, 164, 28);
	   panel_1.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel_1_1 = new JLabel("좌   석  번   호  : ");
	   lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1.setBounds(25, 192, 164, 28);
	   panel_1.add(lblNewLabel_1_1);
	   
	   JLabel lblNewLabel_1_1_1 = new JLabel("좌석 사용 기한  : ");
	   lblNewLabel_1_1_1.setForeground(new Color(114, 166, 255));
	   lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
	   lblNewLabel_1_1_1.setBounds(25, 272, 164, 28);
	   panel_1.add(lblNewLabel_1_1_1);
	   
	   JLabel phonelabel = new JLabel("");
	   phonelabel.setForeground(new Color(114, 166, 255));
	   phonelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   phonelabel.setBounds(201, 112, 299, 28);
	   panel_1.add(phonelabel);
	   
	   JLabel seatlabel = new JLabel("");
	   seatlabel.setForeground(new Color(114, 166, 255));
	   seatlabel.setFont(new Font("굴림", Font.BOLD, 20));
	   seatlabel.setBounds(201, 192, 299, 28);
	   panel_1.add(seatlabel);
	   
	   JLabel timelabel = new JLabel("");
	   timelabel.setForeground(new Color(114, 166, 255));
	   timelabel.setFont(new Font("굴림", Font.BOLD, 20));
	   timelabel.setBounds(201, 272, 299, 28);
	   panel_1.add(timelabel);
		JPanel checkpanel = new JPanel();
	   	JSONObject data = new JSONObject();
		Post po = new Post();
		try {
			data.put("phone", Info.phone);
			JSONObject check = po.jsonpost("/FindSeatTime", data);
   		String seat_time = check.getString("seat_time");
   		if((check.get("check")).equals("true"))
			{
   			 String arr[] = seat_time.split(" ");
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
		    		  seatlabel.setText(seat + " 번");
		    		  timelabel.setText(year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분");
		    		  
	    		  }
	    		  
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton closebutton = new JButton("");
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame1.dispose();
				Seat se = new Seat();
			}
		});
		closebutton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
		closebutton.setBounds(476, 10, 24, 24);
		panel_1.add(closebutton);
		closebutton.setBorderPainted(false); 
		closebutton.setContentAreaFilled(false);
		closebutton.setFocusPainted(false);
		
		JLabel randomnumber = new JLabel("");
		JLabel Qrlabel = new JLabel("");
		
		RoundedButton2 okbutton = new RoundedButton2("New button");
		okbutton.setFont(new Font("굴림", Font.BOLD, 15));
		okbutton.setText("확인");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSONObject data = new JSONObject();
				Post po = new Post();
				try {
					Info.seat_number = seatnumber;
					data.put("phone", Info.phone);
					data.put("seatnumber", seatnumber);
					data.put("activations", "0");
					JSONObject check = po.jsonpost("/UpdateSeat", data);
		   		if((check.get("check")).equals("true"))
					{
	   					String Number = RandomNumber(8);  
	   					randomnumber.setText(Number);
	   					generateQRCode(Qrlabel,String.valueOf(Number));
		   				checkpanel.setVisible(true);
		   				panel_1.setVisible(false);
		   				
		   				data.put("phone", Info.phone);
						data.put("Number", Number);
						check = po.jsonpost("/InsertQrNumber", data);
					}
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		okbutton.setBounds(90, 390, 95, 39);
		panel_1.add(okbutton);
		
		RoundedButton2 backbutton = new RoundedButton2("New button");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Info.seat_number = "NULL";
			}
		});
		backbutton.setFont(new Font("굴림", Font.BOLD, 15));
		backbutton.setText("취소");
		backbutton.setBounds(330, 390, 95, 39);
		panel_1.add(backbutton);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("좌석을 선택하시겠습니까?");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 72, 72));
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(134, 340, 259, 28);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		Qrlabel.setBounds(112, 50, 300, 250);
		checkpanel.add(Qrlabel);
		
		randomnumber.setForeground(new Color(255, 72, 72));
		randomnumber.setFont(new Font("굴림", Font.BOLD, 20));
		randomnumber.setBounds(180, 302, 154, 28);
		checkpanel.add(randomnumber);
		
		RoundedButton2 okbutton_1 = new RoundedButton2("New button");
		okbutton_1.setBounds(212, 390, 95, 39);
		okbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame1.dispose();
				Seat se = new Seat();
				}
		});
		checkpanel.setLayout(null);
		checkpanel.add(okbutton_1);
		okbutton_1.setText("확인");
		okbutton_1.setFont(new Font("굴림", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("QR코드를 찍거나 번호를 입력하여 입장해주세요!");
		lblNewLabel_1_1_1_1_1.setBounds(30, 340, 475, 28);
		checkpanel.add(lblNewLabel_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 72, 72));
		lblNewLabel_1_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		

	      checkpanel.setBounds(12, 10, 512, 453);
	      panel.add(checkpanel);
	      frame.setResizable(false);
	      frame.setVisible(true);
	      checkpanel.setBackground(new Color(255,255,255));
	      checkpanel.setBorder(border);
	      checkpanel.setVisible(false);
		
	}
	
	 public static String RandomNumber(int length) {
	        String digits = "0123456789";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(digits.length());
	            char randomDigit = digits.charAt(randomIndex);
	            sb.append(randomDigit);

	            if (i < length - 1) {
	                sb.append(" "); // 숫자 사이에 띄어쓰기 추가
	            }
	        }

	        return sb.toString();
	    }
	 
	    public static void generateQRCode(JLabel qrlabel, String data) {
	        try {
	            // QR 코드 생성기 생성
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();

	            // 데이터를 비트맵 이미지로 변환
	            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 250);

	            // BufferedImage로 변환
	            BufferedImage qrImage = new BufferedImage(300, 250, BufferedImage.TYPE_INT_RGB);
	            for (int x = 0; x < 300; x++) {
	                for (int y = 0; y < 250; y++) {
	                    qrImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
	                }
	            }

	            qrlabel.setIcon(new ImageIcon(qrImage));

	        } catch (WriterException e) {
	            e.printStackTrace();
	        }
	    }
}
