package com.pws.study;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class RoundedButton extends JButton {

    private Color backgroundColor = new Color(255, 255, 255); // 배경색을 흰색(255, 255, 255)로 설정
    private Color borderColor = new Color(37, 115, 255); // 테두리 색을 114, 166, 255로 설정
    private Color textColor = new Color(0, 0, 0); // 글자색을 검정색(0, 0, 0)으로 설정
    private boolean borderPainted = true;

    public RoundedButton() {
        super();
        decorate();
    }

    public RoundedButton(String text) {
        super(text);
        decorate();
    }

    public RoundedButton(Action action) {
        super(action);
        decorate();
    }

    public RoundedButton(Icon icon) {
        super(icon);
        decorate();
    }

    public RoundedButton(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(borderPainted); // 테두리 보이도록 설정 (true로 변경)
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) {
            graphics.setColor(new Color(114, 166, 255).darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(new Color(114, 166, 255).brighter());
        } else {
            graphics.setColor(backgroundColor);
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, 10, 10); // -1로 수정하여 테두리를 제대로 그립니다.

        // HTML 태그 적용을 위해 setText() 메서드 사용
        String text = getText().replaceAll("<br>", "<br/>"); // <br> 태그를 <br/>로 변경
        graphics.setColor(textColor);
        graphics.setFont(getFont());
        drawHTMLText(graphics, text, width, height);
        graphics.setColor(borderColor);
        graphics.setStroke(new BasicStroke(3)); // 테두리 두께를 3으로 설정
        graphics.drawRoundRect(0, 0, width - 1, height - 1, 10, 10); // 테두리 그리기

        graphics.dispose();
        super.paintComponent(g);
    }

    private void drawHTMLText(Graphics2D graphics, String text, int width, int height) {
        FontMetrics fontMetrics = graphics.getFontMetrics();
        String[] lines = text.split("<br/>"); // 줄바꿈을 기준으로 텍스트를 나눔

        int totalHeight = fontMetrics.getHeight() * lines.length;
        int textY = (height - totalHeight) / 2 + fontMetrics.getAscent()-5;
        for (String line : lines) {
            Rectangle stringBounds = fontMetrics.getStringBounds(line, graphics).getBounds();
            int textX = (width - stringBounds.width) / 2;
            graphics.drawString(line, textX, textY);
            textY += fontMetrics.getHeight(); // 다음 줄로 이동
        }

        // 가로 선 그리기
        double lineY = height * 1 / 3.0; // 버튼 위쪽 1/3 위치로 변경
        int lineLength = width - 5; // 가로 선의 길이 더 늘리기
        int lineX1 = (width - lineLength) / 2; // 가로 선의 시작점 X 좌표
        int lineX2 = lineX1 + lineLength; // 가로 선의 끝점 X 좌표
        graphics.setColor(new Color(37, 115, 255)); // 가로 선 색상
        graphics.setStroke(new BasicStroke(2)); // 가로 선 두께
        graphics.drawLine(lineX1, (int) lineY, lineX2, (int) lineY); // lineY 값을 int로 캐스팅하여 사용
    }

    // 외부에서 배경색을 변경할 수 있는 메서드 추가
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint(); // 배경색 변경 후 다시 그리기
    }

    // 외부에서 테두리 색을 변경할 수 있는 메서드 추가
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint(); // 테두리 색 변경 후 다시 그리기
    }

    // 외부에서 테두리 여부를 설정할 수 있는 메서드 추가
    public void setBorderPainted(boolean borderPainted) {
        this.borderPainted = borderPainted;
        repaint(); // 테두리 여부 변경 후 다시 그리기
    }

    // 외부에서 글자색을 변경할 수 있는 메서드 추가
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        repaint(); // 글자색 변경 후 다시 그리기
    }

    // 배경색이 지정한 색상과 같은지 확인하는 메서드 추가
    public boolean isBackgroundColorEqual(Color targetColor) {
        Color currentColor = getBackgroundColor();
        return currentColor.getRed() == targetColor.getRed() &&
               currentColor.getGreen() == targetColor.getGreen() &&
               currentColor.getBlue() == targetColor.getBlue();
    }

    // 현재 배경색을 가져오는 메서드 추가
    private Color getBackgroundColor() {
        return backgroundColor;
    }
}
