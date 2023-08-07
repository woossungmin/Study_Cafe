package com.pws.study;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Login {

   private static final String Color = null;
   private JFrame frame;
   private JTextField phonetext;
   private JTextField phonetext2;
   private JTextField pwtext;
   int focusTextFeild = 1;
   int year;
   int month;
   int day;
   int hour;
   int minute;
   int currentYear;
   int currentMonth; // 월은 0부터 시작하므로 1을 더해줍니다.
   int currentDay;
   int currentHour;
   int currentMinute;
   String seat_time = "0 0 0 0 0";
   JSONObject data = new JSONObject();
   JSONObject check;
   String lock_time = "0 0 0 0 0";
   Post po = new Post();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
	  	   
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Login window = new Login();
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
   public Login() {
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
      Border border1 =  BorderFactory.createLineBorder(new Color(255,0,0),2);
      
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
       
      
	   JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	   tabbedPane.setBounds(12, 426, 475, 157);
	   borderpanel.add(tabbedPane);
	   
	   JPanel textpanel = new JPanel();
	   tabbedPane.addTab("회원", null, textpanel, null);
	   textpanel.setLayout(null);
	   textpanel.setBackground(new Color(255,255,255));
	   
	   JPanel textpanel2 = new JPanel(); 
	   textpanel2.setBounds(0, 0, 470, 128);
	   textpanel.add(textpanel2);
	   textpanel2.setLayout(null);
	   textpanel2.setBackground(new Color(255,255,255));
	   
	   
	   JPanel textpanel3 = new JPanel(); 
	   textpanel3.setBounds(0, 0, 470, 128);
	   textpanel.add(textpanel3);
	   textpanel3.setLayout(null);
	   textpanel3.setBackground(new Color(255,255,255));
	   textpanel3.setVisible(false);
	   
	   
		JPanel keypanel = new JPanel();
		keypanel.setBounds(291, 14, 167, 108);
		textpanel2.add(keypanel);
		keypanel.setLayout(null);
		keypanel.setVisible(false);
		keypanel.setBackground(new Color(255,255,255));
	   
	   JPanel keypanel2 = new JPanel();
	   keypanel2.setBounds(291, 14, 167, 108);
	   textpanel2.add(keypanel2);
	   keypanel2.setLayout(null);
	   keypanel2.setBackground(new Color(255,255,255));
	   
	  JPanel nomembership = new JPanel();
      tabbedPane.addTab("비회원", null, nomembership, null);
      nomembership.setLayout(null);
      nomembership.setBackground(new Color(255,255,255)); 
	  
      JPanel nokeypanel = new JPanel();
      nokeypanel.setBounds(291, 14, 167, 108);
      nomembership.add(nokeypanel);
      nokeypanel.setLayout(null);
      nokeypanel.setBackground(new Color(255,255,255));
      
      JPanel nokeypanel_1 = new JPanel();
      nokeypanel_1.setLayout(null);
      nokeypanel_1.setBackground(new Color(255,255,255));
      nokeypanel_1.setBounds(291, 14, 167, 108);
      nokeypanel_1.setVisible(false);
      nomembership.add(nokeypanel_1);
    
  	  JLabel Memberlabel_1 = new JLabel("");
	  JLabel Memberlabel = new JLabel("");
	  
	  	JLabel Warning = new JLabel("<html>시간이용권, 기간이용권 중 이용권을 구매한 후에 <br><br>좌석을 선택하여 스터디카페를 사용 가능합니다!.<html>");
	  	Warning.setBounds(72, 16, 450, 57);
		textpanel3.add(Warning);
		Warning.setForeground(new Color(33, 112, 255));
		//Warning.setForeground(new Color(255, 100, 100));
		Warning.setFont(new Font("굴림", Font.BOLD, 14));
		
		JLabel Warning1= new JLabel("<html>회원님은 이미 선택한 좌석이 존재합니다. <br><br>좌석 이동을 원하신다면 좌석 이동 메뉴를 선택해주세요!<html>");
		Warning1.setBounds(72, 16, 450, 57);
		textpanel3.add(Warning1);
		Warning1.setForeground(new Color(33, 112, 255));
		Warning1.setFont(new Font("굴림", Font.BOLD, 13));
		Warning1.setVisible(false);
		Warning.setVisible(false);
		
      RoundedButton2 ticketbutton1 = new RoundedButton2("좌석 선택"); 
      ticketbutton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boolean isEnabled = ticketbutton1.isEnabled();
				if(!isEnabled)
				{
					if(seat_time.equals("0 0 0 0 0")) {
						Warning.setVisible(true);
						Warning1.setVisible(false);
						Memberlabel.setVisible(false);
						Memberlabel_1.setVisible(false);
						
					}
					else if(!Info.seat_number.equals("NULL")){
						Warning1.setVisible(true);
						Warning.setVisible(false);
						Memberlabel.setVisible(false);
						Memberlabel_1.setVisible(false);
					}
			}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Warning.setVisible(false);
				Warning1.setVisible(false);
				Memberlabel.setVisible(true);
				Memberlabel_1.setVisible(true);
			}
		});
      ticketbutton1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		frame.dispose();
      		Seat se = new Seat();
      	}
      });
      ticketbutton1.setBounds(250, 88, 200, 23);
      textpanel3.add(ticketbutton1);
      ticketbutton1.setEnabled(false);

      RoundedButton2 logoutbutton2 = new RoundedButton2("입장하기");
      logoutbutton2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      logoutbutton2.setBounds(12, 78, 235, 23);
      nomembership.add(logoutbutton2); 
      
      RoundedButton2 one = new RoundedButton2("1일 이용권");
      one.setText("시간 이용권");
      one.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		frame.dispose();
      		SeatTicketDay ti = new SeatTicketDay();
      	}
      });
      one.setFont(new Font("굴림", Font.BOLD, 20));
      one.setBounds(137, 156, 170, 95);
      borderpanel.add(one);
      
      RoundedButton2 move = new RoundedButton2("자리이동");
      move.setFont(new Font("굴림", Font.BOLD, 20));
      move.setText("자리이동");
      move.setBounds(137, 267, 170, 95);
      borderpanel.add(move);
      
      RoundedButton2 spirit = new RoundedButton2("정기이용권");
      spirit.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		frame.dispose();
      		SeatTicketSeason ti = new SeatTicketSeason();
      	}
      });
      spirit.setFont(new Font("굴림", Font.BOLD, 20));
      spirit.setText("기간 이용권");
      spirit.setBounds(329, 156, 170, 95);
      borderpanel.add(spirit);
      
      RoundedButton2 checkout = new RoundedButton2("퇴실하기");
      
      RoundedButton2 lock = new RoundedButton2("사물함이용권");
      lock.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(Info.lock_time.equals("0 0 0 0 0")) {
          		LockerTicket lo = new LockerTicket();
          		frame.dispose();
      		}
      		else if(!Info.lock_time.equals("0 0 0 0 0")) {
      			Locker lo = new Locker();
      			frame.dispose();
      		}
      	}
      });
      lock.setFont(new Font("굴림", Font.BOLD, 20));
      lock.setText("사물함");
      lock.setBounds(521, 156, 170, 95);
      borderpanel.add(lock);
      
      RoundedButton2 coffe = new RoundedButton2("커피");
      coffe.setFont(new Font("굴림", Font.BOLD, 20));
      coffe.setText("커피 ");
      coffe.setBounds(521, 267, 170, 95);
      borderpanel.add(coffe);
      
	  one.setEnabled(false);
	  move.setEnabled(false);
	  spirit.setEnabled(false);
	  checkout.setEnabled(false);
	  lock.setEnabled(false);
	  coffe.setEnabled(false);
	  
	  JLabel phonelabel = new JLabel("전화번호 : ");
	  phonelabel.setFont(new Font("굴림", Font.BOLD, 12));
	  phonelabel.setBounds(12, 14, 75, 15); 
	  textpanel2.add(phonelabel);
	  
	  Memberlabel.setFont(new Font("굴림", Font.BOLD, 14));
	  Memberlabel.setForeground(new Color(255, 100, 100));
	  Memberlabel.setBounds(28, 15, 430, 34); 
	  textpanel3.add(Memberlabel); 
	  
	   if(Info.phone == "NULL")
	   {
		   textpanel2.setVisible(true);
		   textpanel3.setVisible(false);
	   }
	   else if(Info.phone != "NULL")
	   {
	    	try {
				data.put("phone", Info.phone);
	   		check = po.jsonpost("/FindSeatPhone", data);
	   		Info.seat_number = check.getString("seat_number");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   textpanel3.setVisible(true);
		   textpanel2.setVisible(false);
	    	one.setEnabled(true);
	    	move.setEnabled(true);
	    	spirit.setEnabled(true);
	    	checkout.setEnabled(true);
	    	lock.setEnabled(true);
	    	coffe.setEnabled(true);
	    	try {	
	    		data.put("phone", Info.phone);
	    		check = po.jsonpost("/FindSeatTime", data);
	    		seat_time = check.getString("seat_time");
	    		if(seat_time.equals("0 0 0 0 0"))
	    		{
	    			Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
	    			ticketbutton1.setEnabled(false);
	    			seat_time = "0 0 0 0 0";
	    		}
	    		else {
	    			 String arr[] = seat_time.split(" ");
		    		  for(String cut : arr) {
		    			  year = Integer.valueOf(arr[0]);
		    			  month = Integer.valueOf(arr[1]);
		    			  day = Integer.valueOf(arr[2]);
		    			  hour = Integer.valueOf(arr[3]);
		    			  minute = Integer.valueOf(arr[4]);
		    			  
		    		  }
		    		  if (currentYear > year
		    				    || (currentYear == year && currentMonth > month)
		    				    || (currentYear == year && currentMonth == month && currentDay > day)
		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour > hour)
		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour == hour && currentMinute > minute)) {
		    			  String add_time = "0 0 0 0 0";
		    			  data.put("phone", Info.phone);
					      data.put("add_time",add_time);
					      check = po.jsonpost("/AddSeatTime", data);
					      if((check.get("check")).equals("true"))
							{
					    	  Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
								data.put("phone", Info.phone);
						   		check = po.jsonpost("/FindSeatPhone", data);
						   		Info.seat_number = check.getString("seat_number");
								data.put("phone", "NULL");
								data.put("seatnumber", Info.seat_number);
								data.put("activations", "1");
								check = po.jsonpost("/UpdateSeat", data);
								Info.seat_number = "NULL";
								seat_time = "0 0 0 0 0";
								check = po.jsonpost("/UpdateSeat", data);
				   				data.put("phone", Info.phone);
								data.put("Number", "0 0 0 0 0");
								check = po.jsonpost("/InsertQrNumber", data);
							}
					      else
							{
							}
		    		  }
		    		  else {
		    			  String formattedMonth = String.format("%02d", month);
			    		  String formattedDay = String.format("%02d", day);
			    		  String formattedHour = String.format("%02d", hour);
			    		  String formattedMinute = String.format("%02d", minute);
			    		  Memberlabel.setText("좌    석 : " + year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분까지 사용 가능합니다.");
		    		  }
		    		  
		    			try {
							data.put("phone", Info.phone);
				   		check = po.jsonpost("/FindSeatPhone", data);
				   		Info.seat_number = check.getString("seat_number");
				    	if((Info.seat_number.equals("NULL")) && !seat_time.equals("0 0 0 0 0"))
				    	{
				    		ticketbutton1.setEnabled(true);
				    	}
				    	else if ((Info.seat_number.equals("NULL")) && (seat_time.equals("0 0 0 0 0"))) {
				    		ticketbutton1.setEnabled(false);
				    	}
				    	else {
				    	}
				    	} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
				    	}
	    				}
	    		}catch(JSONException e1) {
	    			
	    		}
  		  try {	
	    		data.put("phone", Info.phone);
	    		check = po.jsonpost("/FindLockTime", data);
	    		lock_time = check.getString("lock_time");
	    		Info.lock_time = lock_time;
	    		if(lock_time.equals("0 0 0 0 0"))
	    		{
	    			Memberlabel_1.setText("           사물함 사용 가능 시간이 남아 있지 않습니다!");
	    			ticketbutton1.setEnabled(false);
	    			lock_time = "0 0 0 0 0";
	    		}
	    		else {
	    			 String arr[] = lock_time.split(" ");
		    		  for(String cut : arr) {
		    			  year = Integer.valueOf(arr[0]);
		    			  month = Integer.valueOf(arr[1]);
		    			  day = Integer.valueOf(arr[2]);
		    			  hour = Integer.valueOf(arr[3]);
		    			  minute = Integer.valueOf(arr[4]);
		    			  
		    		  }
		    		  if (currentYear > year
		    				    || (currentYear == year && currentMonth > month)
		    				    || (currentYear == year && currentMonth == month && currentDay > day)
		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour > hour)
		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour == hour && currentMinute > minute)) {
		    			  String add_time = "0 0 0 0 0";
		    			  data.put("phone", Info.phone);
					      data.put("add_time",add_time);
					      check = po.jsonpost("/UpdateLockTime", data);
					      if((check.get("check")).equals("true"))
							{
					    	  Memberlabel.setText("           사물함 사용 가능 시간이 남아 있지 않습니다!");
								
					    	  	data.put("phone", Info.phone);
						   		check = po.jsonpost("/FindLockPhone", data);
						   		Info.lock_number = check.getString("lock_number");
								data.put("phone", "NULL");
								data.put("locknumber", Info.lock_number);
								data.put("activations", "1");
								check = po.jsonpost("/UpdateLock", data);
								Info.lock_number = "NULL";
							}
					      else
							{
							}
		    		  }
		    		  else {
		    			  String formattedMonth = String.format("%02d", month);
			    		  String formattedDay = String.format("%02d", day);
			    		  String formattedHour = String.format("%02d", hour);
			    		  String formattedMinute = String.format("%02d", minute);
			    		  Memberlabel_1.setText("사 물 함  : " + year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분까지 사용 가능합니다.");
		    		  }
	    			}
	    		}catch(JSONException e1) {
	    			
	    		}
	    	}
   
	  
	  phonetext = new JTextField();
	  phonetext.addMouseListener(new MouseAdapter() {
	  	@Override
	  	public void mouseClicked(MouseEvent e) {
	  		focusTextFeild = 1;
	  	}
	  });
	  phonetext.setBounds(85, 14, 162, 21);
	  textpanel2.add(phonetext); 
	  phonetext.setColumns(10);
	  phonetext.setBorder(border);
	  
	pwtext = new JPasswordField(); 
	pwtext.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			focusTextFeild = 2;
		}
	});
	pwtext.setColumns(10);
	pwtext.setBounds(85, 47, 162, 21);
	textpanel2.add(pwtext);
	pwtext.setBorder(border);
	
	JLabel phonelabel_1 = new JLabel("비밀번호 : ");
	phonelabel_1.setFont(new Font("굴림", Font.BOLD, 12));
	phonelabel_1.setBounds(12, 47, 75, 15);
	textpanel2.add(phonelabel_1);
	      
    RoundedButton2 loginbutton = new RoundedButton2("로그인");
    loginbutton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String phone = phonetext.getText();
    		String pw = pwtext.getText();
    		
    		JSONObject data = new JSONObject();
    		try {
				data.put("phone", phone);
				data.put("pw", pw);
				Post po = new Post();
				JSONObject check = po.jsonpost("/Login", data);
				
				if((check.get("check")).equals("true"))
				{
					Calendar calendar = Calendar.getInstance();
				   	currentYear = calendar.get(Calendar.YEAR);
				   	currentMonth = calendar.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
				   	currentDay = calendar.get(Calendar.DAY_OF_MONTH);
				   	currentHour = calendar.get(Calendar.HOUR_OF_DAY);
				   	currentMinute = calendar.get(Calendar.MINUTE);
					Message ms = new Message("로그인이 완료되었습니다!");
					Info.phone = check.getString("phone");
					Info.pw = check.getString("pw");
					Info.seat_time = check.getString("seat_time");
					textpanel2.setVisible(false);
					textpanel3.setVisible(true);
			    	one.setEnabled(true);
			    	move.setEnabled(true);
			    	spirit.setEnabled(true);
			    	checkout.setEnabled(true);
			    	lock.setEnabled(true);
			    	coffe.setEnabled(true);
			    	try {
			    		data.put("phone", Info.phone);
			    		check = po.jsonpost("/FindSeatTime", data);
			    		seat_time = check.getString("seat_time");
			    		
			    		if(seat_time.equals("0 0 0 0 0")) {
			    			Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
			    			ticketbutton1.setEnabled(false);
			    			seat_time = "0 0 0 0 0";
			    		}
			    		else {
			    			 String arr[] = seat_time.split(" ");
				    		  for(String cut : arr) {
				    			  year = Integer.valueOf(arr[0]);
				    			  month = Integer.valueOf(arr[1]);
				    			  day = Integer.valueOf(arr[2]);
				    			  hour = Integer.valueOf(arr[3]);
				    			  minute = Integer.valueOf(arr[4]);
				    			  
				    		  }
				    		  if (currentYear > year
				    				    || (currentYear == year && currentMonth > month)
				    				    || (currentYear == year && currentMonth == month && currentDay > day)
				    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour > hour)
				    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour == hour && currentMinute > minute)) {
				    			  String add_time = "0 0 0 0 0";
				    			  data.put("phone", Info.phone);
							      data.put("add_time",add_time);
							      check = po.jsonpost("/AddSeatTime", data);
							      if((check.get("check")).equals("true"))
									{
							    	  Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
										data.put("phone", Info.phone);
								   		check = po.jsonpost("/FindSeatPhone", data);
								   		Info.seat_number = check.getString("seat_number");
										data.put("phone", "NULL");
										data.put("seatnumber", Info.seat_number);
										data.put("activations", "1");
										check = po.jsonpost("/UpdateSeat", data);
										Info.seat_number = "NULL";
										seat_time = "0 0 0 0 0";
										check = po.jsonpost("/UpdateSeat", data);
						   				data.put("phone", Info.phone);
										data.put("Number", "0 0 0 0 0");
										check = po.jsonpost("/InsertQrNumber", data);
									}
							      else
									{
									}
				    		  }
				    		  else {
				    			  String formattedMonth = String.format("%02d", month);
					    		  String formattedDay = String.format("%02d", day);
					    		  String formattedHour = String.format("%02d", hour);
					    		  String formattedMinute = String.format("%02d", minute);
					    		  Memberlabel.setText("좌    석 : " + year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분까지 사용 가능합니다.");
				    		  }
				    		  
				    			try {
									data.put("phone", Info.phone);
						   		check = po.jsonpost("/FindSeatPhone", data);
						   		Info.seat_number = check.getString("seat_number");
						    	if((Info.seat_number.equals("NULL")) && !seat_time.equals("0 0 0 0 0"))
						    	{
						    		ticketbutton1.setEnabled(true);
						    	}
						    	else if ((Info.seat_number.equals("NULL")) && (seat_time.equals("0 0 0 0 0"))) {
						    		ticketbutton1.setEnabled(false);
						    	}
						    	else {
						    	}
						    	} catch (JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			    		}
			    		
			    	} catch (JSONException e1) {
			    		// TODO Auto-generated catch block
			    		e1.printStackTrace();
			    	}
			    	
			    	 try {	
			  	    		data.put("phone", Info.phone);
			  	    		check = po.jsonpost("/FindLockTime", data);
			  	    		lock_time = check.getString("lock_time");
			  	    		Info.lock_time = lock_time;
			  	    		if(lock_time.equals("0 0 0 0 0"))
			  	    		{
			  	    			Memberlabel_1.setText("           사물함 사용 가능 시간이 남아 있지 않습니다!");
			  	    			ticketbutton1.setEnabled(false);
			  	    			lock_time = "0 0 0 0 0";
			  	    		}
			  	    		else {
			  	    			 String arr[] = lock_time.split(" ");
			  		    		  for(String cut : arr) {
			  		    			  year = Integer.valueOf(arr[0]);
			  		    			  month = Integer.valueOf(arr[1]);
			  		    			  day = Integer.valueOf(arr[2]);
			  		    			  hour = Integer.valueOf(arr[3]);
			  		    			  minute = Integer.valueOf(arr[4]);
			  		    			  
			  		    		  }
			  		    		  if (currentYear > year
			  		    				    || (currentYear == year && currentMonth > month)
			  		    				    || (currentYear == year && currentMonth == month && currentDay > day)
			  		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour > hour)
			  		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour == hour && currentMinute > minute)) {
			  		    			  String add_time = "0 0 0 0 0";
			  		    			  data.put("phone", Info.phone);
			  					      data.put("add_time",add_time);
			  					      check = po.jsonpost("/UpdateLockTime", data);
			  					      if((check.get("check")).equals("true"))
			  							{
			  					    	  Memberlabel.setText("           사물함 사용 가능 시간이 남아 있지 않습니다!");
			  								
			  					    	  	data.put("phone", Info.phone);
			  						   		check = po.jsonpost("/FindLockPhone", data);
			  						   		Info.lock_number = check.getString("lock_number");
			  								data.put("phone", "NULL");
			  								data.put("locknumber", Info.lock_number);
			  								data.put("activations", "1");
			  								check = po.jsonpost("/UpdateLock", data);
			  								Info.lock_number = "NULL";
			  							}
			  					      else
			  							{
			  							}
			  		    		  }
			  		    		  else {
			  		    			  String formattedMonth = String.format("%02d", month);
			  			    		  String formattedDay = String.format("%02d", day);
			  			    		  String formattedHour = String.format("%02d", hour);
			  			    		  String formattedMinute = String.format("%02d", minute);
			  			    		  Memberlabel_1.setText("사 물 함  : " + year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분까지 사용 가능합니다.");
			  		    		  }
			  	    			}
			  	    		}catch(JSONException e1) {
			  	    			
			  	    		}
				}
				else
				{
					Message ms = new Message("로그인을 실패하였습니다!");
					phonetext.setText("");
					pwtext.setText("");
				}
    		} catch (JSONException e1) {
    		}
    		
    	}
    });
    loginbutton.setBounds(12, 78, 235, 23);
    textpanel2.add(loginbutton);
    
    RoundedButton2 logoutbutton = new RoundedButton2("로그아웃");
    logoutbutton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Info.phone = "NULL";
    		Info.pw = "NULL";
    		Info.seat_number = "NULL";
    		Message ms = new Message("로그아웃이 완료되었습니다!");
			textpanel2.setVisible(true);
			textpanel3.setVisible(false);
			phonetext.setText("");
			pwtext.setText("");
		    one.setEnabled(false);
		    move.setEnabled(false);
		    spirit.setEnabled(false);
		    checkout.setEnabled(false);
		    lock.setEnabled(false);
		    coffe.setEnabled(false);
    	}
    });
    logoutbutton.setBounds(20, 88, 200, 23);
    textpanel3.add(logoutbutton);
    
    checkout.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
			if(Info.seat_number.equals("NULL")) {
				Message ms = new Message("현재 입실 상태가 아닙니다!");
			}
			else if(!Info.seat_number.equals("NULL")) {
	      		CheckOut ch = new CheckOut(Info.phone, Info.seat_number, seat_time,frame);
			}
      	}
      });
      checkout.setFont(new Font("굴림", Font.BOLD, 20));
      checkout.setText("퇴실");
      checkout.setBounds(329, 267, 170, 95);
      borderpanel.add(checkout);
    
    RoundedButton2 b1 = new RoundedButton2("1");
    b1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "1";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "1";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}

    	}
    });
    b1.setBounds(12, 0, 39, 23);
    keypanel2.add(b1);
    
    RoundedButton2 b2 = new RoundedButton2("2");
    b2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "2";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "2";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b2.setBounds(60, 0, 39, 23);
    keypanel2.add(b2);
    
    RoundedButton2 b3 = new RoundedButton2("3");
    b3.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "3";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "3";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b3.setBounds(108, 0, 39, 23);
    keypanel2.add(b3);
    
    RoundedButton2 b6 = new RoundedButton2("6");
    b6.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "6";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "6";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b6.setBounds(108, 27, 39, 23);
    keypanel2.add(b6);
    
    RoundedButton2 b5 = new RoundedButton2("5");
    b5.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "5";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "5";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b5.setBounds(60, 27, 39, 23);
    keypanel2.add(b5);
    
    RoundedButton2 b4 = new RoundedButton2("4");
    b4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "4";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "4";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b4.setBounds(12, 27, 39, 23);
    keypanel2.add(b4);
    
    RoundedButton2 b7 = new RoundedButton2("7");
    b7.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "7";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "7";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b7.setBounds(12, 54, 39, 23);
    keypanel2.add(b7);
    
    RoundedButton2 b8 = new RoundedButton2("8");
    b8.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "8";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "8";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b8.setBounds(60, 54, 39, 23);
    keypanel2.add(b8);
    
    RoundedButton2 b9 = new RoundedButton2("9");
    b9.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "9";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "9";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b9.setBounds(108, 54, 39, 23);
    keypanel2.add(b9);
    
    RoundedButton2 bb = new RoundedButton2("↑");
    bb.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		keypanel.setVisible(true);
    		keypanel2.setVisible(false);
    	}
    });
    bb.setBounds(108, 81, 39, 23);
    keypanel2.add(bb);
    
    RoundedButton2 b0 = new RoundedButton2("0");
    b0.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "0";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "0";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    	}
    });
    b0.setBounds(60, 81, 39, 23);
    keypanel2.add(b0);
    
    RoundedButton2 b = new RoundedButton2("←");
    b.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
    			String currentText = phonetext.getText();
    			if (!currentText.isEmpty()) {
    			    String newText = currentText.substring(0, currentText.length() - 1);
    			    phonetext.setText(newText);
    		}
    		}
    		else if(focusTextFeild == 2)
    		{
    			String currentText = pwtext.getText();
    			if (!currentText.isEmpty()) {
    			    String newText = currentText.substring(0, currentText.length() - 1);
    			    pwtext.setText(newText);
    		}
    		}
    	}
    });
    b.setBounds(12, 81, 39, 23);
    keypanel2.add(b);
	
	JButton membership_1 = new JButton("비밀번호 찾기");
	membership_1.setFont(new Font("굴림", Font.BOLD, 12));
	membership_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Findpw fi = new Findpw();
			frame.dispose();
		}
	});
	membership_1.setContentAreaFilled(false);
	membership_1.setBorderPainted(false);
	membership_1.setBounds(129, 105, 118, 23);
	textpanel2.add(membership_1);
	
	JLabel lblNewLabel_6 = new JLabel("ㅣ");
	lblNewLabel_6.setBounds(110, 108, 21, 15);
	textpanel2.add(lblNewLabel_6);
	
	JButton membership = new JButton("회원가입");
	membership.setFont(new Font("굴림", Font.BOLD, 12));
	membership.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Membership mb = new Membership();
			frame.dispose();
		}
	});
	membership.setBounds(12, 105, 95, 23);
	textpanel2.add(membership);
	membership.setBorderPainted(false);
	membership.setContentAreaFilled(false);   
	
	RoundedButton2 b1_1 = new RoundedButton2("~");
	b1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "~";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "~";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b1_1.setBounds(12, 0, 39, 23);
	keypanel.add(b1_1);
	
	RoundedButton2 b2_1 = new RoundedButton2("!");
	b2_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "!";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "!";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b2_1.setBounds(60, 0, 39, 23);
	keypanel.add(b2_1);
	
	RoundedButton2 b3_1 = new RoundedButton2("@");
	b3_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "@";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "@";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b3_1.setBounds(108, 0, 39, 23);
	keypanel.add(b3_1);
	
	RoundedButton2 b6_1 = new RoundedButton2("%");
	b6_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "%";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "%";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b6_1.setBounds(108, 27, 39, 23);
	keypanel.add(b6_1);
	
	RoundedButton2 b5_1 = new RoundedButton2("$");
	b5_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "$";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "$";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b5_1.setBounds(60, 27, 39, 23);
	keypanel.add(b5_1);
	
	RoundedButton2 b4_1 = new RoundedButton2("#");
	b4_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "#";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "#";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b4_1.setBounds(12, 27, 39, 23);
	keypanel.add(b4_1);
	
	RoundedButton2 b7_1 = new RoundedButton2("^");
	b7_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "^";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "^";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b7_1.setBounds(12, 54, 39, 23);
	keypanel.add(b7_1);
	
	RoundedButton2 b8_1 = new RoundedButton2("&");
	b8_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "&";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "&";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b8_1.setBounds(60, 54, 39, 23);
	keypanel.add(b8_1);
	
	RoundedButton2 b9_1 = new RoundedButton2("*");
	b9_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "*";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "*";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b9_1.setBounds(108, 54, 39, 23);
	keypanel.add(b9_1);
	
	RoundedButton2 bb_1 = new RoundedButton2("↓");
	bb_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			keypanel.setVisible(false);
			keypanel2.setVisible(true);
		}
	});
	bb_1.setBounds(108, 81, 39, 23);
	keypanel.add(bb_1);
	
	RoundedButton2 b_1 = new RoundedButton2("←");
	b_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
    			String currentText = phonetext.getText();
    			if (!currentText.isEmpty()) {
    			    String newText = currentText.substring(0, currentText.length() - 1);
    			    phonetext.setText(newText);
    		}
    		}
    		else if(focusTextFeild == 2)
    		{
    			String currentText = pwtext.getText();
    			if (!currentText.isEmpty()) {
    			    String newText = currentText.substring(0, currentText.length() - 1);
    			    pwtext.setText(newText);
    		}
    		}
		}
	});
	b_1.setBounds(12, 81, 39, 23);
	keypanel.add(b_1);
	
	RoundedButton2 b9_1_1 = new RoundedButton2("-");
	b9_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if(focusTextFeild == 1)
    		{
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "-";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
    		else if(focusTextFeild == 2)
    		{
        		String currentText = pwtext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "-";  // 기존 문자열에 "~" 추가
        		pwtext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
    		}
		}
	});
	b9_1_1.setBounds(60, 81, 39, 23);
	keypanel.add(b9_1_1);
	
	Memberlabel_1.setForeground(new Color(255, 100, 100));
	Memberlabel_1.setFont(new Font("굴림", Font.BOLD, 14));
	Memberlabel_1.setBounds(28, 45, 430, 34);
	textpanel3.add(Memberlabel_1);
	
      RoundedButton2 b1_2_1 = new RoundedButton2("~");
      b1_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
        		String currentText = phonetext.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
        		String newText = currentText + "~";  // 기존 문자열에 "~" 추가
        		phonetext.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b1_2_1.setBounds(12, 0, 39, 23);
      nokeypanel_1.add(b1_2_1);
      
      RoundedButton2 b2_2_1 = new RoundedButton2("!");
      b2_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "!";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b2_2_1.setBounds(60, 0, 39, 23);
      nokeypanel_1.add(b2_2_1);
      
      RoundedButton2 b3_2_1 = new RoundedButton2("@");
      b3_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "@";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b3_2_1.setBounds(108, 0, 39, 23);
      nokeypanel_1.add(b3_2_1);
      
      RoundedButton2 b6_2_1 = new RoundedButton2("%");
      b6_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "%";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b6_2_1.setBounds(108, 27, 39, 23);
      nokeypanel_1.add(b6_2_1);
      
      RoundedButton2 b5_2_1 = new RoundedButton2("$");
      b5_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "$";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b5_2_1.setBounds(60, 27, 39, 23);
      nokeypanel_1.add(b5_2_1);
      
      RoundedButton2 b4_2_1 = new RoundedButton2("#");
      b4_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "#";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b4_2_1.setBounds(12, 27, 39, 23);
      nokeypanel_1.add(b4_2_1);
      
      RoundedButton2 b7_2_1 = new RoundedButton2("^");
      b7_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "^";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b7_2_1.setBounds(12, 54, 39, 23);
      nokeypanel_1.add(b7_2_1);
      
      RoundedButton2 b8_2_1 = new RoundedButton2("&");
      b8_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "&";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b8_2_1.setBounds(60, 54, 39, 23);
      nokeypanel_1.add(b8_2_1);
      
      RoundedButton2 b9_2_1 = new RoundedButton2("*");
      b9_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "*";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b9_2_1.setBounds(108, 54, 39, 23);
      nokeypanel_1.add(b9_2_1);
      
      RoundedButton2 bb_2_1 = new RoundedButton2("↓");
      bb_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		nokeypanel_1.setVisible(false);
      		nokeypanel.setVisible(true);
      	}
      });
      bb_2_1.setBounds(108, 81, 39, 23);
      nokeypanel_1.add(bb_2_1);
      
      RoundedButton2 b0_1_1 = new RoundedButton2("-");
      b0_1_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "-";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b0_1_1.setBounds(60, 81, 39, 23);
      nokeypanel_1.add(b0_1_1);
      
      RoundedButton2 b_2_1 = new RoundedButton2("←");
      b_2_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();
			if (!currentText.isEmpty()) {
			    String newText = currentText.substring(0, currentText.length() - 1);
			    phonetext2.setText(newText);
			}
      	}
      });
      b_2_1.setBounds(12, 81, 39, 23);
      nokeypanel_1.add(b_2_1);
      
      RoundedButton2 b1_2 = new RoundedButton2("1");
      b1_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
			String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "1";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b1_2.setBounds(12, 0, 39, 23);
      nokeypanel.add(b1_2);
      
      RoundedButton2 b2_2 = new RoundedButton2("2");
      b2_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "2";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b2_2.setBounds(60, 0, 39, 23);
      nokeypanel.add(b2_2);
      
      RoundedButton2 b3_2 = new RoundedButton2("3");
      b3_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "3";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b3_2.setBounds(108, 0, 39, 23);
      nokeypanel.add(b3_2);
      
      RoundedButton2 b6_2 = new RoundedButton2("6");
      b6_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "6";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b6_2.setBounds(108, 27, 39, 23);
      nokeypanel.add(b6_2);
      
      RoundedButton2 b5_2 = new RoundedButton2("5");
      b5_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "5";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b5_2.setBounds(60, 27, 39, 23);
      nokeypanel.add(b5_2);
      
      RoundedButton2 b4_2 = new RoundedButton2("4");
      b4_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "4";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b4_2.setBounds(12, 27, 39, 23);
      nokeypanel.add(b4_2);
      
      RoundedButton2 b7_2 = new RoundedButton2("7");
      b7_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "7";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b7_2.setBounds(12, 54, 39, 23);
      nokeypanel.add(b7_2);
      
      RoundedButton2 b8_2 = new RoundedButton2("8");
      b8_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "8";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b8_2.setBounds(60, 54, 39, 23);
      nokeypanel.add(b8_2);
      
      RoundedButton2 b9_2 = new RoundedButton2("9");
      b9_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "9";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b9_2.setBounds(108, 54, 39, 23);
      nokeypanel.add(b9_2);
      
      RoundedButton2 bb_2 = new RoundedButton2("↑");
      bb_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
    		nokeypanel_1.setVisible(true);
      		nokeypanel.setVisible(false);

      	}
      });
      bb_2.setBounds(108, 81, 39, 23);
      nokeypanel.add(bb_2);
      
      RoundedButton2 b0_1 = new RoundedButton2("0");
      b0_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String currentText = phonetext2.getText();  // 현재 텍스트 필드에 있는 문자열 가져오기
			String newText = currentText + "0";  // 기존 문자열에 "~" 추가
			phonetext2.setText(newText);  // 텍스트 필드에 새로운 문자열 설정
      	}
      });
      b0_1.setBounds(60, 81, 39, 23);
      nokeypanel.add(b0_1);
      
      RoundedButton2 b_2 = new RoundedButton2("←");
      b_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
			String currentText = phonetext2.getText();
			if (!currentText.isEmpty()) {
			    String newText = currentText.substring(0, currentText.length() - 1);
			    phonetext2.setText(newText);
			}
      	}
      });
      b_2.setBounds(12, 81, 39, 23);
      nokeypanel.add(b_2);
      
      JLabel phonelabel2 = new JLabel("전화번호 : ");
      phonelabel2.setFont(new Font("굴림", Font.BOLD, 12));
      phonelabel2.setBounds(12, 35, 75, 15);
      nomembership.add(phonelabel2);
      
      phonetext2 = new JTextField();
      phonetext2.setColumns(10);
      phonetext2.setBounds(85, 35, 162, 21);
      nomembership.add(phonetext2);
      phonetext2.setBorder(border);
       
      JLabel projectname = new JLabel("포텐스터디카페");
      projectname.setFont(new Font("굴림", Font.BOLD, 35));
      projectname.setForeground(new Color(114, 166, 255));
      projectname.setBounds(313, 10, 264, 53);
      borderpanel.add(projectname);
      
      JLabel projectname2 = new JLabel("POTEN STUDY CAFE");
      projectname2.setForeground(new Color(114, 166, 255));
      projectname2.setFont(new Font("굴림", Font.BOLD, 30));
      projectname2.setBounds(265, 54, 315, 37);
      borderpanel.add(projectname2);
      
      JPanel panel_5 = new JPanel();
      panel_5.setBounds(532, 443, 293, 140);
      borderpanel.add(panel_5);
      panel_5.setLayout(null);
      panel_5.setBackground(new Color(255,255,255));
      panel_5.setBorder(border);
      
      JLabel uselabel = new JLabel("이용안내");
      uselabel.setForeground(new Color(0, 0, 255));
      uselabel.setBounds(110, 10, 76, 24);
      panel_5.add(uselabel);
      uselabel.setFont(new Font("굴림", Font.BOLD, 15));
      
      JLabel uselabel1 = new JLabel("1. 로그인을 한다.");
      uselabel1.setForeground(new Color(0, 0, 255));
      uselabel1.setBounds(12, 44, 194, 15);
      panel_5.add(uselabel1);
      uselabel1.setFont(new Font("굴림", Font.BOLD, 13));
      
      JLabel uselabel2 = new JLabel("2. 원하는 이용권을 선택한다.");
      uselabel2.setForeground(new Color(0, 0, 255));
      uselabel2.setBounds(12, 69, 194, 15);
      panel_5.add(uselabel2);
      uselabel2.setFont(new Font("굴림", Font.BOLD, 13));
   
      JLabel uselabel3 = new JLabel("3. 원하는 좌석을 선택한다. ");
      uselabel3.setForeground(new Color(0, 0, 255));
      uselabel3.setBounds(12, 94, 194, 15);
      panel_5.add(uselabel3);
      uselabel3.setFont(new Font("굴림", Font.BOLD, 13));
      
      JLabel uselabel4 = new JLabel("4. 입실하여 사용한다.");
      uselabel4.setForeground(new Color(0, 0, 255));
      uselabel4.setBounds(12, 119, 194, 15);
      panel_5.add(uselabel4);
      uselabel4.setFont(new Font("굴림", Font.BOLD, 13));
      
      JButton faq = new JButton("");
      faq.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\faq (3).png"));
	faq.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			FAQ qu = new FAQ();
			frame.dispose();
		}
	});
	faq.setBounds(761, 5, 64, 64);
	borderpanel.add(faq);
	faq.setBorderPainted(false);
	faq.setContentAreaFilled(false);
	faq.setFocusPainted(false);
	
	
//	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//    Runnable serverRequestTask = new Runnable() {
//        @Override
//        public void run() {
//        	if(!Info.phone.equals("NULL")) {
//        		try {
//    	    		data.put("phone", Info.phone);
//    	    		check = po.jsonpost("/FindSeatTime", data);
//    	    		String seat_time = check.getString("seat_time");
//    	    		if(seat_time.equals("0 0 0 0 0"))
//    	    		{
//    	    			Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
//    	    			ticketbutton1.setEnabled(false);
//    	    		}
//    	    		else {
//   	    			 String arr[] = seat_time.split(" ");
//   		    		  for(String cut : arr) {
//   		    			  year = Integer.valueOf(arr[0]);
//   		    			  month = Integer.valueOf(arr[1]);
//   		    			  day = Integer.valueOf(arr[2]);
//   		    			  hour = Integer.valueOf(arr[3]);
//   		    			  minute = Integer.valueOf(arr[4]);
//   		    			  
//   		    		  }
//   		    		  if (currentYear > year
//   		    				    || (currentYear == year && currentMonth > month)
//   		    				    || (currentYear == year && currentMonth == month && currentDay > day)
//   		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour > hour)
//   		    				    || (currentYear == year && currentMonth == month && currentDay == day && currentHour == hour && currentMinute > minute)) {
//   		    			  String add_time = "0 0 0 0 0";
//   		    			  data.put("phone", Info.phone);
//   					      data.put("add_time",add_time);
//   					      check = po.jsonpost("/AddSeatTime", data);
//   					      if((check.get("check")).equals("true"))
//   							{
//   					    	  Memberlabel.setText("            좌석 사용 가능 시간이 남아 있지 않습니다!");
//   	    					data.put("phone", "NULL");
//   	    					data.put("seatnumber", Info.seat_number);
//   	    					data.put("activations", "1");
//   	    					check = po.jsonpost("/UpdateSeat", data);
//   							}
//   					      else
//   							{
//   							}
//   		    		  }
//   		    		  else {
//   		    			  String formattedMonth = String.format("%02d", month);
//   			    		  String formattedDay = String.format("%02d", day);
//   			    		  String formattedHour = String.format("%02d", hour);
//   			    		  String formattedMinute = String.format("%02d", minute);
//   			    		  Memberlabel.setText("좌    석 : " + year + "년 " + formattedMonth + "월 " + formattedDay + "일 " + formattedHour + "시 " + formattedMinute + "분까지 사용 가능합니다.");
//   		    		  }
//   		    			try {
//   							data.put("phone", Info.phone);
//   				   		check = po.jsonpost("/FindSeatPhone", data);
//   				   		Info.seat_number = check.getString("seat_number");
//   				    	if((Info.seat_number.equals("NULL")) && !seat_time.equals("null"))
//   				    	{
//   				    		ticketbutton1.setEnabled(true);
//   				    	}
//   				    	else if ((Info.seat_number.equals("NULL")) && (seat_time.equals("null"))) {
//   				    		ticketbutton1.setEnabled(false);
//   				    	}
//   				    	else {
//   				    	}
//   				    	} catch (JSONException e1) {
//   							// TODO Auto-generated catch block
//   							e1.printStackTrace();
//   				    	}
//   	    				}
//   	    		}catch(JSONException e1) {
//   	    			
//   	    		}
//        	}
//        }
//    };
//
//    // 30초마다 서버에게 동작 요청
//    scheduler.scheduleWithFixedDelay(serverRequestTask, 0, 30, TimeUnit.SECONDS);
   }
}