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

public class RoundedButton3 extends JButton {

    private Color backgroundColor = new Color(114, 166, 255);
    private Color textColor = new Color(255, 255, 255);

    public RoundedButton3() {
        super();
        decorate();
    }

    public RoundedButton3(String text) {
        super(text);
        decorate();
    }

    public RoundedButton3(Action action) {
        super(action);
        decorate();
    }

    public RoundedButton3(Icon icon) {
        super(icon);
        decorate();
    }

    public RoundedButton3(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            graphics.setColor(new Color(114,166,255).darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(new Color(114,166,255).brighter());
        } else {
            graphics.setColor(backgroundColor);
        }

        graphics.fillRoundRect(0, 0, width - 1, height - 1, 10, 10);

        String text = getText().replaceAll("<br>", "<br/>");
        graphics.setColor(textColor);
        graphics.setFont(getFont());
        drawHTMLText(graphics, text, width, height);

        graphics.dispose();
        super.paintComponent(g);
    }

    private void drawHTMLText(Graphics2D graphics, String text, int width, int height) {
        FontMetrics fontMetrics = graphics.getFontMetrics();
        String[] lines = text.split("<br/>");

        int textY = (height - fontMetrics.getHeight() * lines.length) / 2 + fontMetrics.getAscent();
        for (String line : lines) {
            Rectangle stringBounds = fontMetrics.getStringBounds(line, graphics).getBounds();
            int textX = (width - stringBounds.width) / 2;
            graphics.drawString(line, textX, textY);
            textY += fontMetrics.getHeight();
        }
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        super.setBackground(backgroundColor);
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        repaint();
    }
    public boolean isBackgroundColorEqual(Color targetColor) { //색상의 미세한 값을 조정해주는 함수
        Color currentColor = getBackgroundColor();
        return currentColor.getRed() == targetColor.getRed() &&
               currentColor.getGreen() == targetColor.getGreen() &&
               currentColor.getBlue() == targetColor.getBlue();
    }
	private Color getBackgroundColor() { //현재 배경색 가져오는 함수
		// TODO Auto-generated method stub
		return backgroundColor;
	}
}
