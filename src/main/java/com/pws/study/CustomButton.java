package com.pws.study;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {
    private Color backgroundColor = new Color(217,231,255);
    private Color borderColor = new Color(114, 166, 255);
    private Color textColor = Color.BLACK;
    private int textX = 5;
    private int textY = 1;

    public CustomButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(true);        
        setBorderPainted(true);
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
        g.drawString(getText(), x, y);
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
}
