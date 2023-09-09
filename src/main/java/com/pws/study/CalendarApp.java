package com.pws.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarApp {
    private JFrame frame;
    private JPanel calendarPanel;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private JLabel monthLabel;
    private JButton[][] dateButtons;

    private Calendar currentCalendar;

    public CalendarApp() {
        frame = new JFrame("Calendar App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Calendar Panel
        calendarPanel = new JPanel();
        calendarPanel.setBounds(10, 10, 500, 400);
        frame.getContentPane().add(calendarPanel);

        // Previous Month Button
        prevMonthButton = new JButton("이전 달");
        prevMonthButton.setBounds(10, 420, 100, 30);
        frame.getContentPane().add(prevMonthButton);

        // Month Label
        monthLabel = new JLabel("", JLabel.CENTER);
        monthLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        monthLabel.setBounds(120, 420, 400, 30);
        frame.getContentPane().add(monthLabel);

        // Next Month Button
        nextMonthButton = new JButton("다음 달");
        nextMonthButton.setBounds(530, 420, 100, 30);
        frame.getContentPane().add(nextMonthButton);

        currentCalendar = Calendar.getInstance();
        currentCalendar.set(Calendar.DAY_OF_MONTH, 1);

        initCalendar();

        prevMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, -1);
                initCalendar();
            }
        });

        nextMonthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, 1);
                initCalendar();
            }
        });

        frame.setVisible(true);
    }

    private void initCalendar() {
        calendarPanel.removeAll();
        dateButtons = new JButton[7][7];

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
        monthLabel.setText(sdf.format(currentCalendar.getTime()));

        Calendar tempCalendar = (Calendar) currentCalendar.clone();
        tempCalendar.set(Calendar.DAY_OF_MONTH, 1);

        int maxDay = tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfWeek = tempCalendar.get(Calendar.DAY_OF_WEEK) - 1;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                dateButtons[i][j] = new JButton();
                calendarPanel.add(dateButtons[i][j]);

                if (i == 0) {
                    // 요일 이름 설정
                    String[] daysOfWeek = {"일", "월", "화", "수", "목", "금", "토"};
                    dateButtons[i][j].setText(daysOfWeek[j]);
                } else {
                    dateButtons[i][j].setText("");

                    dateButtons[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton clickedButton = (JButton) e.getSource();
                            int selectedDay = Integer.parseInt(clickedButton.getText());
                            JOptionPane.showMessageDialog(frame, "날짜 선택: " + selectedDay);
                        }
                    });
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i > 0) {
                    int day = (i - 1) * 7 + j - firstDayOfWeek + 1;
                    if (day >= 1 && day <= maxDay) {
                        dateButtons[i][j].setText(String.valueOf(day));
                    }
                }
            }
        }

        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarApp();
            }
        });
    }
}
