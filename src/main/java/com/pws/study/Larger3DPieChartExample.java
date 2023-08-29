package com.pws.study;

import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class CustomLabelGenerator extends StandardPieSectionLabelGenerator {
    private BufferedImage[] customLabelImages;
    private Font labelFont = new Font("NanumGothic", Font.PLAIN, 12); // 한글 폰트 설정

    public CustomLabelGenerator(BufferedImage... customLabelImages) {
        this.customLabelImages = customLabelImages;
    }

    @Override
    public String generateSectionLabel(PieDataset dataset, Comparable key) {
        return null;
    }

    public BufferedImage generateSectionLabelImage(PieDataset dataset, Comparable key) {
        String sectionKey = key.toString();
        if (sectionKey.equals("남자")) {
            return customLabelImages[0];
        } else if (sectionKey.equals("여자")) {
            return customLabelImages[1];
        }
        return null;
    }
}

public class Larger3DPieChartExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("3D Pie Chart with Custom Labels Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PieDataset dataset = createDataset();
            JFreeChart chart = createChart(dataset);

            ChartPanel chartPanel = new ChartPanel(chart);
            frame.getContentPane().add(chartPanel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("남자", 30);
        dataset.setValue("여자", 40);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart3D(
            "3D Pie Chart with Custom Labels Example", dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setDepthFactor(0.1);
        plot.setLabelGenerator(null);

        BufferedImage customLabelImageMale = createCustomLabel("남자", 100, 50, Color.WHITE, Color.BLACK); // 이미지 크기 및 상자 크기 조정
        BufferedImage customLabelImageFemale = createCustomLabel("여자", 100, 50, Color.WHITE, Color.BLACK); // 이미지 크기 및 상자 크기 조정

        plot.setLabelGenerator(new CustomLabelGenerator(
            customLabelImageMale, customLabelImageFemale));

        return chart;
    }

    private static BufferedImage createCustomLabel(String text, int width, int height, Color bgColor, Color textColor) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(textColor);
        Font font = new Font("Arial", Font.BOLD, 12);
        g2d.setFont(font);

        // 상자 크기를 늘림
        int boxWidth = width + 20;
        int boxHeight = height + 10;

        FontMetrics metrics = g2d.getFontMetrics();
        int textX = (boxWidth - metrics.stringWidth(text)) / 2;
        int textY = ((boxHeight - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(text, textX, textY);
        g2d.setColor(Color.BLACK); // 텍스트 색상 설정
        g2d.drawRect(5, 5, boxWidth, boxHeight); // 상자 그리기
        g2d.dispose();

        return image;
    }
}
