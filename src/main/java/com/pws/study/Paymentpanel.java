package com.pws.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.Border;

public class Paymentpanel extends JPanel {
    private JLabel yearMonthLabel;
    private int currentYear = 2023;
    private int currentMonth = 9;
    private CustomButton[] dayButtons; // CustomButton 사용

    public Paymentpanel() {
        Border border = BorderFactory.createLineBorder(new Color(114, 166, 250), 2);
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setBounds(23, 45, 813, 570);
        
        JPanel panel = new JPanel();
        panel.setBounds(50, 1, 710, 565);
        add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(245,247,255));
        panel.setBorder(border);
                JButton previousButton = new JButton("이전");
                previousButton.setBounds(187, 3, 95, 23);
                panel.add(previousButton);
                

                yearMonthLabel = new JLabel(currentYear + "년 " + currentMonth + "월");
                yearMonthLabel.setBounds(294, 0, 128, 35);
                panel.add(yearMonthLabel);
                yearMonthLabel.setFont(new Font("굴림", Font.BOLD, 18));
                
                        JButton nextButton = new JButton("다음");
                        nextButton.setBounds(414, 3, 95, 23);
                        panel.add(nextButton);
                        
                                nextButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        currentMonth++;
                                        if (currentMonth > 12) {
                                            currentMonth = 1;
                                            currentYear++;
                                        }
                                        updateCalendar();
                                    }
                                });

        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth--;
                if (currentMonth < 1) {
                    currentMonth = 12;
                    currentYear--;
                }
                updateCalendar();
            }
        });

        // 35개의 CustomButton 생성
        dayButtons = new CustomButton[35];
        for (int i = 0; i < 35; i++) {
            dayButtons[i] = new CustomButton("");
            dayButtons[i].setBorder(BorderFactory.createLineBorder(new Color(114, 166, 250), 2));
            panel.add(dayButtons[i]);
        }

        // 요일 라벨 추가
        String[] weekDays = {"일", "월", "화", "수", "목", "금", "토"};
        for (int i = 0; i < weekDays.length; i++) {
            JLabel label = new JLabel(weekDays[i]);
            label.setFont(new Font("굴림", Font.BOLD, 14));
            label.setBounds(70 + i * 91, 50, 90, 22);
            panel.add(label);
        }

        updateCalendar();
    }

    private void updateCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth - 1, 1);
        
        // 현재 달력의 첫 번째 요일 계산 (일요일: 1, 월요일: 2, 화요일: 3, ... , 토요일: 7)
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        int x = (firstDayOfWeek - 1) * 91 + 100; // 첫 번째 요일에 따라 x 좌표 설정
        int y = 100;
        int buttonWidth = 90;
        int buttonHeight = 80;

        for (int i = 0; i < 35; i++) {
            if (i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                calendar.set(Calendar.DAY_OF_MONTH, i + 1);
                Date date = calendar.getTime();
                dayButtons[i].setText(sdf.format(date));
                dayButtons[i].setBounds(x-63, y - 25, buttonWidth, buttonHeight);
                dayButtons[i].setVisible(true);

                // 일요일과 토요일의 텍스트 색상 변경
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
                    dayButtons[i].setTextColor(dayOfWeek == Calendar.SUNDAY ? Color.RED : Color.BLUE);
                } else {
                    dayButtons[i].setTextColor(Color.BLACK);
                }
            } else {
                dayButtons[i].setText("");
                dayButtons[i].setVisible(false);
            }

            x += buttonWidth + 1;

            if ((i + firstDayOfWeek) % 7 == 0) {
                x = 100;
                y += buttonHeight + 1;
            }
        }

        yearMonthLabel.setText(currentYear + "년 " + currentMonth + "월");
    }
}
