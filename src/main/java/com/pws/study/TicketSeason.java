package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

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

public class TicketSeason {

	private JFrame frame;
	JSONObject b1 = null;
	JSONObject b2 = null;
	JSONObject b3 = null;
	JSONObject b4 = null;
	JSONObject b5 = null;
	JSONObject b6 = null;
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
					TicketSeason window = new TicketSeason();
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
	public TicketSeason() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(210, 20, 870, 650);
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.getContentPane().setLayout(null);
      	frame.setResizable(false);
      	frame.setVisible(true);
 
      	Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
      
      	JPanel panel_4 = new JPanel();
      	panel_4.setBounds(0, 0, 856, 613);
      	frame.getContentPane().add(panel_4);
      	panel_4.setLayout(null);
      	panel_4.setBackground(new Color(255,255,255));
      
      	JPanel borderpanel = new JPanel();
      	borderpanel.setBounds(10, 10, 837, 593);
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
		JPanel borderpanel2 = new JPanel();
		
	    
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
	
		RoundedButton2 pay = new RoundedButton2("결제");
		JSONObject data = new JSONObject();
		
		try {
			String id = "b";
			data.put("id", id);
			Post po = new Post();
			
			JSONObject check = po.jsonpost("/FindTicket", data);
			
			if((check.get("check")).equals("true"))
			{
				JSONArray jArray = new JSONArray();
				jArray = (JSONArray) check.get("tickets");
				b1 = (JSONObject) jArray.get(0);
				b2 = (JSONObject) jArray.get(1);
				b3 = (JSONObject) jArray.get(2);
				b4 = (JSONObject) jArray.get(3);
				b5 = (JSONObject) jArray.get(4);
				b6 = (JSONObject) jArray.get(5);				
			}
			else
			{
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("asdasdsasad");
		}
		
	    JLabel circle = new JLabel("");
	    circle.setBounds(60, 56, 30, 30);
	    borderpanel2.add(circle);
	    circle.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    JLabel circle1 = new JLabel("New label");
	    circle1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    circle1.setBounds(541, 56, 30, 30);
	    borderpanel2.add(circle1);
	    JLabel circle2 = new JLabel("New label");
	    circle2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    circle2.setBounds(299, 56, 30, 30);
	    borderpanel2.add(circle2); 
	    JLabel circle3 = new JLabel("New label");
	    circle3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    circle3.setBounds(60, 211, 30, 30);
	    borderpanel2.add(circle3);   
	    JLabel circle4 = new JLabel("New label");
	    circle4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    circle4.setBounds(299, 211, 30, 30);
	    borderpanel2.add(circle4);    
	    JLabel circle5 = new JLabel("New label");
	    circle5.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check1.png"));
	    circle5.setBounds(541, 211, 30, 30);
	    borderpanel2.add(circle5);
	    
	    circle.setVisible(false);
	    circle1.setVisible(false);
	    circle2.setVisible(false);
	    circle3.setVisible(false);
	    circle4.setVisible(false);
	    circle5.setVisible(false);
		
	    RoundedButton2 ticketbutton; 
		try {
			
				ticketbutton = new RoundedButton2((String) b1.get("t_name") + "<br>" + (String) b1.get("t_money") + "원");
				ticketbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						    circle1.setVisible(false);
						    circle2.setVisible(false);
						    circle3.setVisible(false);
						    circle4.setVisible(false);
						    circle5.setVisible(false);
							moneylabel_1.setText((String) b1.get("t_money"));
							circle.setVisible(true);
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
						    moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ticketbutton.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton.setBounds(49, 44, 186, 107); 
				borderpanel2.add(ticketbutton);
				ticketbutton.setBackground(new Color(114,166,255));
				ticketbutton.setForeground(new Color(255,255,255));
				
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    RoundedButton2 ticketbutton_1;
		try {
				ticketbutton_1 = new RoundedButton2((String) b2.get("t_name") + "<br>" + (String) b2.get("t_money") + "원");
				ticketbutton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle2.setVisible(true);
						try {
						    circle.setVisible(false);
						    circle1.setVisible(false);
						    circle3.setVisible(false);
						    circle4.setVisible(false);
						    circle5.setVisible(false);
							moneylabel_1.setText((String)b2.getString("t_money"));
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
							moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ticketbutton_1.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_1.setBounds(289, 44, 186, 107);
				borderpanel2.add(ticketbutton_1);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    RoundedButton2 ticketbutton_2;
		try {
				ticketbutton_2 = new RoundedButton2((String) b3.get("t_name") + "<br>" + (String) b3.get("t_money") + "원");
				ticketbutton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle1.setVisible(true);
						try {
						    circle.setVisible(false);
						    circle2.setVisible(false);
						    circle3.setVisible(false);
						    circle4.setVisible(false);
						    circle5.setVisible(false);
							moneylabel_1.setText((String) b3.get("t_money"));
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
							moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ticketbutton_2.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_2.setBounds(529, 44, 186, 107);
		      borderpanel2.add(ticketbutton_2);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    RoundedButton2 ticketbutton_3;
		try {
				ticketbutton_3 = new RoundedButton2((String) b4.get("t_name") + "<br>" + (String) b4.get("t_money") + "원");
				ticketbutton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle3.setVisible(true);
						try {
						    circle.setVisible(false);
						    circle1.setVisible(false);
						    circle2.setVisible(false);
						    circle4.setVisible(false);
						    circle5.setVisible(false);
							moneylabel_1.setText("");
							moneylabel_1.setText((String) b4.get("t_money"));
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
							moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ticketbutton_3.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_3.setBounds(49, 199, 186, 107);
				borderpanel2.add(ticketbutton_3);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    RoundedButton2 ticketbutton_4;
		try {
				ticketbutton_4 = new RoundedButton2((String) b5.get("t_name") + "<br>" + (String) b5.get("t_money") + "원");
				ticketbutton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle4.setVisible(true);
						try {
						    circle.setVisible(false);
						    circle1.setVisible(false);
						    circle2.setVisible(false);
						    circle3.setVisible(false);
						    circle5.setVisible(false);
							moneylabel_1.setText((String) b5.get("t_money"));
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
							moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				ticketbutton_4.setFont(new Font("굴림", Font.BOLD, 20));
				ticketbutton_4.setBounds(289, 199, 186, 107);
				borderpanel2.add(ticketbutton_4);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    RoundedButton2 ticketbutton_5;
		try {
				ticketbutton_5 = new RoundedButton2((String) b6.get("t_name") + "<br>" + (String) b6.get("t_money") + "원");
				ticketbutton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle5.setVisible(true);
						try {
						    circle.setVisible(false);
						    circle1.setVisible(false);
						    circle2.setVisible(false);
						    circle3.setVisible(false);
						    circle4.setVisible(false);
							moneylabel_1.setText((String) b6.get("t_money"));
							pay.setVisible(true);
							moneylabel.setVisible(true);
							moneylabel_1.setVisible(true);
							moneylabel_2.setVisible(true);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			    ticketbutton_5.setFont(new Font("굴림", Font.BOLD, 20));
			    ticketbutton_5.setBounds(529, 199, 186, 107);
			    borderpanel2.add(ticketbutton_5);

			    
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		borderpanel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    circle.setVisible(false);
			    circle1.setVisible(false);
			    circle2.setVisible(false);
			    circle3.setVisible(false);
			    circle4.setVisible(false);
			    circle5.setVisible(false);
				pay.setVisible(false);
				moneylabel.setVisible(false);
				moneylabel_1.setVisible(false);
				moneylabel_2.setVisible(false);
			}
		});
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
		
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
      			JSONObject data = new JSONObject();
      			try {
      				String t_money = moneylabel_1.getText();
					data.put("t_money",t_money);
					Post po = new Post();
					JSONObject check = po.jsonpost("/FindTicketTime", data);
				    String result = check.getString("t_time");
				    String add_time = null;
					if((check.get("check")).equals("true"))
					{	
						  data.put("phone", Info.phone);
						  check = po.jsonpost("/FindSeatTime", data);
						  String seat_time = check.getString("seat_time");
						  if(seat_time.equals("0 0 0 0 0"))
						  {
							  Calendar now = Calendar.getInstance();
						      year = now.get(Calendar.YEAR);
						      month = now.get(Calendar.MONTH)+1;
						      day = now.get(Calendar.DAY_OF_MONTH);
						      hour = now.get(Calendar.HOUR_OF_DAY);
						      minute = now.get(Calendar.MINUTE); 
						      int time = Integer.parseInt(result);
						      add_time = plus_time(time);
						      Payment pa = new Payment();
						  }
						  else {
							  String arr[] = seat_time.split(" ");
							  for(String cut : arr) {
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
					      System.out.println(add_time);
					      data.put("phone", Info.phone);
					      data.put("add_time",add_time);
					      check = po.jsonpost("/AddSeatTime", data);
					      if((check.get("check")).equals("true"))
							{
					    	  System.out.println("성공");
							}
					      else
							{
								System.out.println("오류");
							}
					}
					else
					{
						System.out.println("오류");
					}
      			} catch (JSONException e1) {
						e1.printStackTrace();
				}
			}
		});
		pay.setText("결제");
		pay.setFont(new Font("굴림", Font.BOLD, 20));
		pay.setBounds(631, 530, 170, 43);
		borderpanel.add(pay);
		
	/*	JSONObject check;
		Post po = new Post();
		try {
			data.put("phone", Info.phone);
			check = po.jsonpost("/FindSeatTime", data);
			String seat_time = check.getString("seat_time");
			 String arr[] = seat_time.split(" ");
			  for(String cut : arr) {
				  year = Integer.valueOf(arr[0]);
				  month = Integer.valueOf(arr[1]);
				  day = Integer.valueOf(arr[2]);
				  hour = Integer.valueOf(arr[3]);
				  minute = Integer.valueOf(arr[4]);
				  
			  }
			  String formattedMonth = String.format("%02d", month);
			  String formattedDay = String.format("%02d", day);
			  String formattedHour = String.format("%02d", hour);
			  String formattedMinute = String.format("%02d", minute);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pay.setVisible(false);
*/
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
