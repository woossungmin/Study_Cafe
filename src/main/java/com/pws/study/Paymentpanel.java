package com.pws.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.Border;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class Paymentpanel extends JPanel {
    private JLabel yearMonthLabel;
    private int currentYear;
    private int currentMonth;
    private CustomButton[] dayButtons; // CustomButton 사용
    private JLabel paymentlabel;
    // 날짜 포맷 설정
    private SimpleDateFormat sdf = new SimpleDateFormat("d");
    
    public Paymentpanel(JPanel borderPanel, JButton homeButton, JButton closeButton) {
        Border border = BorderFactory.createLineBorder(new Color(114, 166, 250), 2);
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setBounds(23, 45, 813, 570);

        // 현재 날짜 정보 가져오기
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 1을 더해줍니다.

        JButton previousButton = new JButton("");
        previousButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\left-arrow.png"));
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth--;
                if (currentMonth < 1) {
                    currentMonth = 12;
                    currentYear--;
                }
                updateCalendar();
                sendYearMonthToServer();
            }
        });
        previousButton.setBounds(288, 1, 32, 32);
        add(previousButton);
        previousButton.setFocusPainted(false);
        previousButton.setContentAreaFilled(false);
        previousButton.setBorderPainted(false);

        yearMonthLabel = new JLabel(currentYear + "년 " + currentMonth + "월");
        yearMonthLabel.setBounds(335, 2, 128, 35);
        add(yearMonthLabel);
        yearMonthLabel.setFont(new Font("굴림", Font.BOLD, 18));

        JButton nextButton = new JButton("");
        nextButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\right-arrow.png"));
        // 다음 버튼의 ActionListener에서 년 월 정보를 서버에 전달
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth++;
                if (currentMonth > 12) {
                    currentMonth = 1;
                    currentYear++;
                }
                updateCalendar();
                sendYearMonthToServer();
            }
        });
        nextButton.setBounds(455, 1, 32, 32);
        add(nextButton);
        nextButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
        
        JButton btnNewButton = new JButton("매출 그래프");
        btnNewButton.setIcon(null);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VisualPaymentpanel vi = new VisualPaymentpanel();
        		switchPanel(vi,borderPanel,homeButton,closeButton);
        	}
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
        btnNewButton.setBounds(79, 2, 141, 32);
        add(btnNewButton);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(87, 147, 255));
        
        JLabel payment = new JLabel("월 매출 : ");
        payment.setFont(new Font("굴림", Font.BOLD, 18));
        payment.setBounds(536, 1, 220, 35);
        add(payment);
        payment.setForeground(new Color(87, 147, 255));
        
        paymentlabel = new JLabel("");
        paymentlabel.setForeground(new Color(255, 128, 128));
        paymentlabel.setFont(new Font("굴림", Font.BOLD, 18));
        paymentlabel.setBounds(633, 1, 122, 35);
        add(paymentlabel);

        dayButtons = new CustomButton[42];
        for (int i = 0; i < 42; i++) {
            dayButtons[i] = new CustomButton(""); // CustomButton 생성
            dayButtons[i].setBorder(BorderFactory.createLineBorder(new Color(114, 166, 250), 2));
            add(dayButtons[i]);
            dayButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Do something when a day button is clicked
                }
            });
        }

        String[] weekDays = {"일", "월", "화", "수", "목", "금", "토"};
        Color[] weekDayColors = {Color.RED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE};

        for (int i = 0; i < weekDays.length; i++) {
            JLabel label = new JLabel(weekDays[i]);
            label.setFont(new Font("굴림", Font.BOLD, 14));
            label.setBounds(70 + i * 111, 50, 90, 22);
            label.setForeground(weekDayColors[i]); // 라벨의 텍스트 색상 설정
            add(label);
        }

        updateCalendar();

        // 프로그램 시작 시 서버에 요청하여 달력에 출력
        sendYearMonthToServer();
    }

    private void updateCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth - 1, 1);

        // 현재 달력의 첫 번째 요일 계산 (일요일: 1, 월요일: 2, 화요일: 3, ... , 토요일: 7)
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 현재 달력의 첫 번째 날짜를 계산합니다.
        calendar.add(Calendar.DAY_OF_MONTH, -firstDayOfWeek + 1);

        int x = 100;
        int y = 100;
        int buttonWidth = 110;
        int buttonHeight = 80;

        for (int i = 0; i < 42; i++) {
            // 현재 달의 날짜를 그립니다.
            Date date = calendar.getTime();

            // 날짜 포맷 적용하여 일자를 가져옴
            String dayOfMonth = sdf.format(date);

            // 일자와 금액을 줄바꿈으로 나눠서 출력
            dayButtons[i].setText(dayOfMonth + "<br><br>0원");
            dayButtons[i].setBounds(x - 80, y - 25, buttonWidth, buttonHeight);
            dayButtons[i].setVisible(true);

            // 일요일과 토요일의 텍스트 색상 변경
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
                dayButtons[i].setTextColor(dayOfWeek == Calendar.SUNDAY ? Color.RED : Color.BLUE);
            } else {
                dayButtons[i].setTextColor(Color.BLACK);
            }

            // 날짜 정보 설정
            SimpleDateFormat customDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String customDate = customDateFormat.format(date);
            dayButtons[i].setCustomDate(customDate);

            // 현재 월의 버튼인지 확인
            boolean isCurrentMonth = (calendar.get(Calendar.MONTH) == currentMonth - 1);

            // 이전달과 다음달에서 가져온 버튼일 경우 회색으로 설정
            if (!isCurrentMonth) {
                dayButtons[i].setBackgroundColor(new Color(219,219,219));
            } else {
                dayButtons[i].setBackgroundColor(new Color(217,231,255));
            }

            x += buttonWidth + 1;

            if ((i + 1) % 7 == 0) {
                x = 100;
                y += buttonHeight + 1;
            }

            // 다음 날짜로 이동
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        yearMonthLabel.setText(currentYear + "년 " + currentMonth + "월");
    }



    private void sendYearMonthToServer() {
        JSONObject data = new JSONObject();
        JSONObject check;
        Post po = new Post();
        int total = 0;

        // 현재 년 월 정보를 가져와서 서버에 전달
        String yearMonth = String.format("%04d-%02d", currentYear, currentMonth);

        try {
            data.put("year_month", yearMonth);

            // Flask 앱에 POST 요청 보내기
            check = po.jsonpost("/SelectPayment", data);
            // Parse the JSON response and update day buttons with total_money
            org.json.JSONArray jsonArray = check.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String dateStr = item.getString("date");
                int totalMoney = item.getInt("total_money");
                total +=  totalMoney;

                // 서버에서 받아온 "yyyy-MM-dd" 형식의 날짜와 버튼에 설정된 날짜를 비교하여 매칭되면 텍스트 업데이트
                for (CustomButton dayButton : dayButtons) {
                    String buttonDate = dayButton.getCustomDate();
                    if (buttonDate != null && buttonDate.equals(dateStr)) {
                        // 날짜 포맷 적용하여 일자를 가져옴
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                        String customDate = new SimpleDateFormat("d").format(date);

                        // 일자와 금액을 줄바꿈으로 나눠서 출력
                        String displayText = customDate + "<br><br>" + totalMoney + "원";
                        dayButton.setText(displayText);
                        break;
                    }
                }
            }
            paymentlabel.setText(total + "원");
        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (java.text.ParseException e2) {
            e2.printStackTrace();
        }
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
