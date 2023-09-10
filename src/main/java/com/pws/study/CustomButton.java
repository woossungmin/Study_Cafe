package com.pws.study;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private Color backgroundColor = new Color(217, 231, 255);
    private Color borderColor = new Color(114, 166, 255);
    private Color textColor = Color.BLACK;
    private int textX = 5;
    private int textY = 1;
    private String customDate;

    public CustomButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setBorderPainted(true);
        // HTML 렌더링 활성화
        /*setHorizontalAlignment(SwingConstants.CENTER);

        // 금액 텍스트가 "원"으로 끝나는 경우에 가운데 정렬 설정
        if (text.contains("원")) {
            String[] parts = text.split("원");
            String totalMoney = parts[0]; // "total_money" 부분 추출
            String formattedText = "<html><center>" + totalMoney + "</center>원</html>";
            setText(formattedText);
        }*/
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(backgroundColor);
        g.fillRect(0, 0, width, height);

        g.setColor(borderColor);
        g.drawRect(0, 0, width - 1, height - 1);

        g.setColor(textColor);
        g.setFont(getFont());

        FontMetrics metrics = g.getFontMetrics();
        int x = textX;
        int y = textY + metrics.getAscent(); // 좌측 상단 모서리 위치 조절

        // 텍스트에 줄바꿈 태그가 포함되어 있다면 줄바꿈 처리
        String[] lines = getText().split("<br>");
        for (String line : lines) {
            g.drawString(line, x, y);
            y += metrics.getHeight();
        }
    }

    // 배경색 설정 메서드
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    // 테두리 색 설정 메서드
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    // 글자색 설정 메서드
    public void setTextColor(Color color) {
        this.textColor = color;
        repaint();
    }

    // 텍스트의 x 좌표 설정 메서드
    public void setTextX(int x) {
        this.textX = x;
        repaint();
    }

    // 텍스트의 y 좌표 설정 메서드
    public void setTextY(int y) {
        this.textY = y;
        repaint();
    }

    // CustomButton 객체에 날짜 정보를 설정하는 메서드
    public void setCustomDate(String date) {
        this.customDate = date;
    }

    // CustomButton 객체의 날짜 정보를 가져오는 메서드
    public String getCustomDate() {
        return customDate;
    }
}
