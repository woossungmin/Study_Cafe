package com.pws.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;

public class VisualPaymentpanel extends JPanel {
    private JLabel yearMonthLabel;
    private JLabel yearMonthLabel2;
    private int currentYear;
    private int currentYear1;
    private int currentYear2;
    private JLabel titleLabel;
    private JButton previousButton;
    private JButton nextButton;
    private JButton previousButton1;
    private JButton nextButton1;
    private JButton previousButton2;
    private JButton nextButton2;
    private JRadioButton monthButton;
    private JRadioButton yearButton;
    private JPanel panel_1;
    private ChartPanel chartPanel; // ChartPanel을 필드로 선언합니다.

    public VisualPaymentpanel(JPanel borderPanel, JButton homeButton, JButton closeButton) {
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setBounds(23, 45, 813, 554);

        panel_1 = new JPanel();
        panel_1.setBounds(146, 0, 467, 37);
        add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(null);
        panel_1.setVisible(false);

        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentYear1 = calendar.get(Calendar.YEAR);
        currentYear2 = calendar.get(Calendar.YEAR);

        JFreeChart chart = createChart();
        this.chartPanel = new ChartPanel(chart); // 필드를 초기화합니다.
        this.chartPanel.setPreferredSize(new Dimension(800, 500));
        this.chartPanel.setBounds(1, 55, 800, 501);
        this.chartPanel.setOpaque(false);

        // 아래 라인을 추가하여 그래프 패널을 VisualPaymentpanel에 추가합니다.
        add(this.chartPanel, BorderLayout.CENTER);

        previousButton1 = new JButton("");
        previousButton1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\left-arrow.png"));
        previousButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear1--;
                yearMonthLabel.setText(currentYear1 + "년 ");
                }
        });
        previousButton1.setBounds(0, 2, 32, 32);
        previousButton1.setFocusPainted(false);
        previousButton1.setContentAreaFilled(false);
        previousButton1.setBorderPainted(false);
        previousButton1.setVisible(true);
        panel_1.add(previousButton1);

        nextButton1 = new JButton("");
        nextButton1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\right-arrow.png"));
        nextButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear1++;
                yearMonthLabel.setText(currentYear1 + "년 ");
            }
        });
        nextButton1.setBounds(158, 2, 32, 32);
        nextButton1.setFocusPainted(false);
        nextButton1.setContentAreaFilled(false);
        nextButton1.setBorderPainted(false);
        nextButton1.setVisible(true);
        panel_1.add(nextButton1);

        previousButton2 = new JButton("");
        previousButton2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\left-arrow.png"));
        previousButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear2--;
                yearMonthLabel2.setText(currentYear2 + "년 ");
            }
        });
        previousButton2.setBounds(275, 2, 32, 32);
        previousButton2.setFocusPainted(false);
        previousButton2.setContentAreaFilled(false);
        previousButton2.setBorderPainted(false);
        previousButton2.setVisible(true);
        panel_1.add(previousButton2);

        nextButton2 = new JButton("");
        nextButton2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\right-arrow.png"));
        nextButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear2++;
                yearMonthLabel2.setText(currentYear2 + "년 ");
            }
        });
        nextButton2.setBounds(433, 2, 32, 32);
        nextButton2.setFocusPainted(false);
        nextButton2.setContentAreaFilled(false);
        nextButton2.setBorderPainted(false);
        nextButton2.setVisible(true);
        panel_1.add(nextButton2);

        yearMonthLabel = new JLabel(currentYear1 + "년 ");
        yearMonthLabel.setBounds(63, 1, 69, 32);
        panel_1.add(yearMonthLabel);
        yearMonthLabel.setVisible(true);
        yearMonthLabel.setFont(new Font("굴림", Font.BOLD, 18));

        yearMonthLabel2 = new JLabel(currentYear2 + "년 ");
        yearMonthLabel2.setBounds(338, 1, 69, 32);
        panel_1.add(yearMonthLabel2);
        yearMonthLabel2.setVisible(true);
        yearMonthLabel2.setFont(new Font("굴림", Font.BOLD, 18));

        JLabel lblNewLabel = new JLabel("~");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
        lblNewLabel.setBounds(229, 2, 23, 32);
        panel_1.add(lblNewLabel);
        
	    JPanel panel = new JPanel();
	    panel.setBounds(300, 0, 192, 37);
	    add(panel);
	    panel.setLayout(null);
	    panel.setBackground(new Color(255, 255, 255));
	    panel.setBorder(null);
	    panel.setVisible(true);
	    
	    JButton btnNewButton = new JButton("매출 달력");
        btnNewButton.setIcon(null);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Paymentpanel bi = new Paymentpanel(borderPanel,homeButton,closeButton);
        		switchPanel(bi,borderPanel,homeButton,closeButton);
        	}
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
        btnNewButton.setBounds(1, 0, 141, 32);
        add(btnNewButton);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(87, 147, 255));
	    
        previousButton = new JButton("");
        previousButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\left-arrow.png"));
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear--;
                titleLabel.setText(currentYear + "년");
                updateChart();
            }
        });
        previousButton.setBounds(0, 0, 32, 32);
        previousButton.setFocusPainted(false);
        previousButton.setContentAreaFilled(false);
        previousButton.setBorderPainted(false);
        previousButton.setVisible(true);
        panel.add(previousButton);
        
        nextButton = new JButton("");
        nextButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\right-arrow.png"));
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentYear++;
                titleLabel.setText(currentYear + "년");
                updateChart();
            }
        });
        nextButton.setBounds(158, 0, 32, 32);
        nextButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
        nextButton.setVisible(true);
        panel.add(nextButton);

        titleLabel = new JLabel(currentYear + "년");
        titleLabel.setFont(new Font("굴림", Font.BOLD, 18));
        titleLabel.setBounds(63, 2, 78, 30);
        titleLabel.setVisible(true);
        panel.add(titleLabel);

        ButtonGroup group = new ButtonGroup();

        monthButton = new JRadioButton("월 별");
        monthButton.setFont(new Font("굴림", Font.BOLD, 16));
        monthButton.setBounds(639, 5, 78, 27);
        monthButton.setBorderPainted(false);
        monthButton.setContentAreaFilled(false);
        monthButton.setForeground(new Color(83, 144, 255));
        monthButton.setSelected(true);
        group.add(monthButton);
        add(monthButton);

        yearButton = new JRadioButton("년 별");
        yearButton.setFont(new Font("굴림", Font.BOLD, 16));
        yearButton.setBounds(727, 5, 78, 27);
        yearButton.setBorderPainted(false);
        yearButton.setContentAreaFilled(false);
        yearButton.setForeground(new Color(83, 144, 255));
        group.add(yearButton);
        add(yearButton);

        monthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
                panel_1.setVisible(false);
                chartPanel.setVisible(monthButton.isSelected()); // 월 별 버튼 선택 시 chartPanel 표시
                revalidate();
                repaint();
            }
        });

        yearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel_1.setVisible(true);
                chartPanel.setVisible(false); // 년 별 버튼 선택 시 chartPanel 숨김
                revalidate();
                repaint();
            }
        });

        // 초기 그래프 표시
        updateChart();
    }

    private JFreeChart createChart() {
        // 그래프 생성 로직
        XYSeriesCollection dataset = new XYSeriesCollection();

        // 서버에서 데이터 가져오기
        JSONObject data = new JSONObject();
        JSONObject check;
        Post po = new Post();
        try {
            data.put("year", currentYear);
            check = po.jsonpost("/SelectMonthPayment", data);
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null; // 오류가 발생하면 null을 반환하여 그래프를 생성하지 않음
        }

        // 데이터를 XYSeries에 추가
        XYSeries series = new XYSeries("");

        JSONArray resultArray;
        try {
            resultArray = check.getJSONArray("result");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject item = resultArray.getJSONObject(i);
                String yearMonth = item.getString("year_month");
                int totalMoney = item.getInt("total_money");

                // "yyyy-MM" 형식의 문자열을 파싱하여 월을 추출
                String[] parts = yearMonth.split("-");
                int month = Integer.parseInt(parts[1]);

                series.add(month, totalMoney);
            }

            dataset.addSeries(series);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
            "",  // 그래프 제목 (비워두기)
            "월",      // X 축 레이블
            "매출 (만원)",      // Y 축 레이블
            dataset,           // 데이터셋
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        chart.removeLegend(); // 범례를 숨김

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(1)); // 월 간격을 1로 설정

        // X 축 범위를 조정하여 여백 추가
        double lowerBound = 0.5; // 시작 범위
        double upperBound = 12.5; // 끝 범위
        xAxis.setRange(lowerBound, upperBound);

        // 한글 폰트 설정 (Malgun Gothic)
        Font axisLabelFont = new Font("Malgun Gothic", Font.BOLD, 12);
        Font tickLabelFont = new Font("Malgun Gothic", Font.BOLD, 10);

        // X, Y 축 레이블 및 텍스트 색상 변경
        xAxis.setLabelPaint(new Color(83, 114, 255)); // X 축 레이블 색상 변경
        xAxis.setTickLabelPaint(new Color(83, 114, 255)); // X 축 틱 레이블 색상 변경
        xAxis.setLabelFont(axisLabelFont);
        xAxis.setTickLabelFont(tickLabelFont);

        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setLabelPaint(new Color(83, 114, 255)); // Y 축 레이블 색상 변경
        yAxis.setTickLabelPaint(new Color(83, 114, 255)); // Y 축 틱 레이블 색상 변경
        yAxis.setLabelFont(axisLabelFont);
        yAxis.setTickLabelFont(tickLabelFont);

        // Y 축 범위를 0부터 150만원까지, 10만원 간격으로 설정
        yAxis.setRange(0.0, 1500000.0);
        NumberAxis yAxis2 = (NumberAxis) plot.getRangeAxis();
        yAxis2.setTickUnit(new NumberTickUnit(100000.0));

        // 차트 배경색 변경
        plot.setBackgroundPaint(new Color(217, 231, 255)); // 배경색 변경
        renderer.setSeriesPaint(0, new Color(255, 128, 128));

        for (int i = 0; i < series.getItemCount(); i++) {
            double x = (double) series.getX(i); // X 값 가져오기
            double y = (double) series.getY(i); // Y 값 가져오기
            XYTextAnnotation annotation = new XYTextAnnotation(String.format("%,.0f원", y), x, y + 50000); // Y값을 조절하여 원하는 위치로 이동
            annotation.setFont(new Font("Malgun Gothic", Font.BOLD, 7));
            annotation.setTextAnchor(TextAnchor.BOTTOM_CENTER);
            annotation.setPaint(new Color(83,114,255));
            plot.addAnnotation(annotation);
        }


        return chart;
    }

    private void updateChart() {
        // 그래프를 업데이트할 때 호출되는 메서드
    	JFreeChart chart = createChart();
        this.chartPanel.setChart(chart); // chartPanel 필드를 사용하여 차트를 업데이트합니다.
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
