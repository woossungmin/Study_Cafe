package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EventTicket {

	private JFrame frame;
	JSONObject[] e = new JSONObject[6];
	RoundedButton2[] eventButtons = new RoundedButton2[6];
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
					EventTicket window = new EventTicket();
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
	public EventTicket() {
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
      	
      	Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
      	
      	JPanel panel = new JPanel();
      	panel.setBounds(0, 0, 856, 613);
      	frame.getContentPane().add(panel);
      	panel.setLayout(null);
      	panel.setBackground(new Color(255,255,255));
      	
      	JPanel borderpanel = new JPanel();
      	borderpanel.setBounds(12, 10, 832, 593);
      	panel.add(borderpanel);
      	borderpanel.setLayout(null);
      	frame.setResizable(false);
      	frame.setVisible(true);
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
      	
      	JPanel borderpanel2 = new JPanel();
		borderpanel2.setBounds(35, 106, 766, 402);
		borderpanel.add(borderpanel2);
		borderpanel2.setBackground(new Color(255,255,255));
		borderpanel2.setBorder(border);
		borderpanel2.setLayout(null);
		
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
		
	    String imagePath = "C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png";
	    int[][] labelPositions = {{60, 46},{60, 201},{299, 46},{299, 201},{541, 46},{541, 201}};
	    List<JLabel> circles = new ArrayList<>();

	    for (int i = 0; i < labelPositions.length; i++) {
	        JLabel circle = new JLabel("");
	        circle.setIcon(new ImageIcon(imagePath));
	        circle.setBounds(labelPositions[i][0], labelPositions[i][1], 30, 30);
	        borderpanel2.add(circle);
	        circles.add(circle);
	        circle.setVisible(false);
	    }
		
	    JLabel moneylabel = new JLabel("결제금액 : ");
		moneylabel.setFont(new Font("굴림", Font.BOLD, 20));
		moneylabel.setForeground(new Color(0,0,255));
		moneylabel.setBounds(456, 354, 110, 38);
		borderpanel2.add(moneylabel);
		moneylabel.setVisible(false);
      
		JLabel moneylabel_1 = new JLabel("");
		moneylabel_1.setForeground(Color.BLUE);
		moneylabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		moneylabel_1.setBounds(578, 354, 79, 38);
		borderpanel2.add(moneylabel_1);
		moneylabel_1.setVisible(false);
	      
	    JLabel moneylabel_2 = new JLabel("원");
	    moneylabel_2.setForeground(Color.BLUE);
	    moneylabel_2.setFont(new Font("굴림", Font.BOLD, 20));
	    moneylabel_2.setBounds(669, 354, 50, 38);
	    borderpanel2.add(moneylabel_2);
	    moneylabel_2.setVisible(false);   
	    
	    int[] xeventButtons = {49, 49, 289, 289, 529, 529};
	    int[] yeventButtons = {44, 199, 44, 199, 44, 199};
	    
	    for (int i = 0; i < 6; i++) {
	        int index = i;
	        eventButtons[i] = new RoundedButton2("");
	        eventButtons[i].setForeground(Color.WHITE);
	        eventButtons[i].setFont(new Font("굴림", Font.BOLD, 20));
	        eventButtons[i].setBackground(new Color(114, 166, 255));
	        eventButtons[i].setBounds(xeventButtons[i], yeventButtons[i], 186, 107);
	        borderpanel2.add(eventButtons[i]);
	        eventButtons[i].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                Object source = event.getSource();
	                for (int j = 0; j < eventButtons.length; j++) {
	                    if (source == eventButtons[j]) {
	                        circles.get(j).setVisible(true); // 수정된 부분
	                    } else {
	                        circles.get(j).setVisible(false);
	                    }
	                }
	                try {
	                    moneylabel_1.setText((String) e[index].get("t_money"));
	                    moneylabel.setVisible(true);
	                    moneylabel_1.setVisible(true);
	                    moneylabel_2.setVisible(true);
	                } catch (JSONException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });
	    }
	    fetchDataAndUpdate1("d");
	    
	    RoundedButton2 pay = new RoundedButton2("결제");
	    pay.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JSONObject data = new JSONObject();
	            try {
	                String t_money = moneylabel_1.getText();
	                data.put("t_money", t_money);
	                Post po = new Post();
	                JSONObject check = po.jsonpost("/FindTicketTime", data);
	                String result = check.getString("t_time");
	                String origin_id = check.getString("id");
	                String add_time = null;

	                if ((check.get("check")).equals("true")) {
	                    if (origin_id.equals("a") || origin_id.equals("b")) {
	                        data.put("phone", Info.phone);
	                        check = po.jsonpost("/FindSeatTime", data);
	                        String seat_time = check.getString("seat_time");
	                        if (seat_time.equals("0 0 0 0 0")) {
	                            Calendar now = Calendar.getInstance();
	                            year = now.get(Calendar.YEAR);
	                            month = now.get(Calendar.MONTH) + 1;
	                            day = now.get(Calendar.DAY_OF_MONTH);
	                            hour = now.get(Calendar.HOUR_OF_DAY);
	                            minute = now.get(Calendar.MINUTE);
	                            int time = Integer.parseInt(result);
	                            add_time = plus_time(time);
	                            Payment pa = new Payment();
	                        } else {
	                            String arr[] = seat_time.split(" ");
	                            for (String cut : arr) {
	                                year = Integer.valueOf(arr[0]);
	                                month = Integer.valueOf(arr[1]);
	                                day = Integer.valueOf(arr[2]);
	                                hour = Integer.valueOf(arr[3]);
	                                minute = Integer.valueOf(arr[4]);
	                                int time = Integer.parseInt(result);
	                                add_time = plus_time(time);
	                                Payment pa = new Payment();
	                            }
	                        }
	                        data.put("phone", Info.phone);
	                        data.put("add_time", add_time);
	                        check = po.jsonpost("/AddSeatTime", data);
	                        data.put("t_money", t_money);
	                        data.put("phone", Info.phone);
	                        check = po.jsonpost("/AddPayment", data);
	                    } else {
	                        data.put("phone", Info.phone);
	                        check = po.jsonpost("/FindLockTime", data);
	                        String lock_time = check.getString("lock_time");
	                        if (lock_time.equals("0 0 0 0 0")) {
	                            Calendar now = Calendar.getInstance();
	                            year = now.get(Calendar.YEAR);
	                            month = now.get(Calendar.MONTH) + 1;
	                            day = now.get(Calendar.DAY_OF_MONTH);
	                            hour = now.get(Calendar.HOUR_OF_DAY);
	                            minute = now.get(Calendar.MINUTE);
	                            int time = Integer.parseInt(result);
	                            add_time = plus_time(time);
	                            Payment pa = new Payment();

	                            Thread lockerThread = new Thread(new Runnable() {
	                                public void run() {
	                                    try {
	                                        Thread.sleep(7000); // 5초 대기
	                                        SwingUtilities.invokeLater(new Runnable() {
	                                            public void run() {
	                                                frame.dispose();
	                                                Locker locker = new Locker(); // Locker 호출
	                                            }
	                                        });
	                                    } catch (InterruptedException e) {
	                                        e.printStackTrace();
	                                    }
	                                }
	                            });
	                            lockerThread.start(); // 스레드 시작
	                        } else {
	                            String arr[] = lock_time.split(" ");
	                            for (String cut : arr) {
	                                year = Integer.valueOf(arr[0]);
	                                month = Integer.valueOf(arr[1]);
	                                day = Integer.valueOf(arr[2]);
	                                hour = Integer.valueOf(arr[3]);
	                                minute = Integer.valueOf(arr[4]);
	                                int time = Integer.parseInt(result);
	                                add_time = plus_time(time);
	                                Payment pa = new Payment();
	                            }

	                            Thread lockerThread = new Thread(new Runnable() {
	                                public void run() {
	                                    try {
	                                        Thread.sleep(7000); // 5초 대기
	                                        SwingUtilities.invokeLater(new Runnable() {
	                                            public void run() {
	                                            }
	                                        });
	                                    } catch (InterruptedException e) {
	                                        e.printStackTrace();
	                                    }
	                                }
	                            });
	                            lockerThread.start(); // 스레드 시작
	                        }

	                        data.put("phone", Info.phone);
	                        data.put("add_time", add_time);
	                        check = po.jsonpost("/UpdateLockTime", data);
	                        data.put("t_money", t_money);
	                        data.put("phone", Info.phone);
	                        check = po.jsonpost("/AddPayment", data);
	                    }
	                } else {
	                    // 예외 처리
	                }
	            } catch (JSONException e1) {
	                e1.printStackTrace();
	            }
	        }
	    });
	    pay.setText("결제");
	    pay.setFont(new Font("굴림", Font.BOLD, 20));
	    pay.setBounds(631, 540, 170, 43);
	    borderpanel.add(pay);

	}
	private void fetchDataAndUpdate1(String id) {
	    JSONObject data = new JSONObject();
	    JSONArray jArray = null;
	    try {
	        data.put("id", id);
	        
	        Post po = new Post();
	        JSONObject check = po.jsonpost("/FindTicket", data);

	        if ((check.get("check")).equals("true")) {
	            jArray = check.getJSONArray("tickets");
	        } else {
	            // Handle if check is not true
	        }
	    } catch (JSONException e1) {
	        e1.printStackTrace();
	    }

	    for (int i = 0; i < 6; i++) {
	        if (jArray != null && jArray.length() > i) {
	            try {
	                e[i] = jArray.getJSONObject(i);
	                String name = e[i].optString("t_name", "");
	                String money = e[i].optString("t_money", "");
	                if (name.equals("") || money.equals("")) {
	                    eventButtons[i].setText("X");
	                } else {
		                if(e[i].get("origin_id").equals("a") || e[i].get("origin_id").equals("b")) {
		                    eventButtons[i].setText("좌석 이용권 " + "<br>" + name + "<br>" + money + "원");
		                }
		                else if(e[i].get("origin_id").equals("c")) {
		                	 eventButtons[i].setText("사물함 이용권 " + "<br>" + name + "<br>" + money + "원");
		                }

	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	        } else {
	            eventButtons[i].setText("X");
	        }
	    }
	}
	public String plus_time(int time) { // 시간 넘어가는거 계산
	    int totalHours = hour + time;
	    int additionalDays = totalHours / 24; // 추가되는 날짜 계산
	    hour = totalHours % 24; // 남은 시간 계산

	    day += additionalDays; // 추가되는 날짜를 더해줌

	    if (month == 2) {
	        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	        if (isLeapYear) {
	            if (day > 29) {
	                day = 1;
	                month += 1;
	            }
	        } else {
	            if (day > 28) {
	                day = 1;
	                month += 1;
	            }
	        }
	    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
	        if (day > 30) {
	            day = 1;
	            month += 1;
	        }
	    } else {
	        if (day > 31) {
	            day = 1;
	            month += 1;
	        }
	    }

	    if (month > 12) {
	        month = 1;
	        year += 1;
	    }

	    String formattedMonth = String.format("%02d", month);
	    String formattedDay = String.format("%02d", day);
	    String formattedHour = String.format("%02d", hour);
	    String formattedMinute = String.format("%02d", minute);

	    return year + " " + formattedMonth + " " + formattedDay + " " + formattedHour + " " + formattedMinute;
	}
}
