package com.pws.study;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton2 extends JButton {
	
	private int textSize = 12; // 기본 텍스트 크기
    private Color backgroundColor;
	public RoundedButton2() {
        super();
        decorate();
    }

    public RoundedButton2(String text) {
        super(text);
        decorate();
    }

    public RoundedButton2(Action action) {
        super(action);
        decorate();
    }

    public RoundedButton2(Icon icon) {
        super(icon);
        decorate();
    }

    public RoundedButton2(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false); // 테두리 제거
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = new Color(114, 166, 255); // 배경색 결정
        Color o = new Color(255, 255, 255); // 글자색 결정
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) {
            graphics.setColor(c.darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(c.brighter());
        } else {
            graphics.setColor(c);
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, 10, 10); // -1로 수정하여 테두리를 제대로 그립니다.

        // HTML 태그 적용을 위해 setText() 메서드 사용
        String text = getText().replaceAll("<br>", "<br/>"); // <br> 태그를 <br/>로 변경
        graphics.setColor(o);
        graphics.setFont(getFont());
        drawHTMLText(graphics, text, width, height);
        graphics.dispose();
        super.paintComponent(g);
    }

    private void drawHTMLText(Graphics2D graphics, String text, int width, int height) {
    	
        FontMetrics fontMetrics = graphics.getFontMetrics();
        String[] lines = text.split("<br/>"); // 줄바꿈을 기준으로 텍스트를 나눔

        int textY = (height - fontMetrics.getHeight() * lines.length) / 2 + fontMetrics.getAscent();
        for (String line : lines) {
            Rectangle stringBounds = fontMetrics.getStringBounds(line, graphics).getBounds();
            int textX = (width - stringBounds.width) / 2;
            graphics.drawString(line, textX, textY);
            textY += fontMetrics.getHeight(); // 다음 줄로 이동/
            }
    }
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint(); // 배경색 변경 후 다시 그리기
    }
    public void setTextSize(int textSize) {
        this.textSize = textSize;
        setFont(getFont().deriveFont((float) textSize)); // 텍스트 크
    }
}