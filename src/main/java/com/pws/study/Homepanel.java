package com.pws.study;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.ImageIcon;

public class Homepanel extends JPanel {
	String MemberCount = "";
	String SeatCount = "";
	String LockCount = "";
	String ManCount = "";
	String GirlCount = "";
	/**
	 * Create the panel.
	 */
	public Homepanel() {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(23, 45, 813, 570);
		
		JPanel chartpanel = new JPanel();
		chartpanel.setBounds(12, 247, 789, 313);
		add(chartpanel);
		chartpanel.setBackground(new Color(217,231,255));
		chartpanel.setBorder(border);
		chartpanel.setLayout(null);
		chartpanel.setOpaque(false);
		
		JPanel memberpanel = new JPanel();
		memberpanel.setBounds(12, 67, 226, 136);
		add(memberpanel);
		memberpanel.setBackground(new Color(255,255,255));
		memberpanel.setBorder(border);
		memberpanel.setLayout(null);
		
		JLabel member = new JLabel("");
		member.setBounds(150, 10, 37, 27);
		memberpanel.add(member);
		member.setFont(new Font("굴림", Font.BOLD, 15));
		member.setForeground(new Color(255, 128, 128));
		
		JLabel lblNewLabel = new JLabel(" 명");
		lblNewLabel.setBounds(180, 8, 27, 30);
		memberpanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(114,166,255));
		
		JLabel lblNewLabel_4_3 = new JLabel("총 회원 수 : ");
		lblNewLabel_4_3.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_3.setBounds(12, 10, 96, 24);
		memberpanel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("남       자  : ");
		lblNewLabel_4_3_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_3_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_3_1.setBounds(12, 40, 96, 24);
		memberpanel.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_3_2 = new JLabel("여       자  : ");
		lblNewLabel_4_3_2.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_3_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_3_2.setBounds(12, 70, 96, 24);
		memberpanel.add(lblNewLabel_4_3_2);
		
		JLabel lblNewLabel_3 = new JLabel(" 명");
		lblNewLabel_3.setForeground(new Color(114, 166, 255));
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3.setBounds(180, 40, 27, 30);
		memberpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(" 명");
		lblNewLabel_5.setForeground(new Color(114, 166, 255));
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_5.setBounds(180, 70, 27, 30);
		memberpanel.add(lblNewLabel_5);
		
		JLabel member_1 = 
				new JLabel("");
		member_1.setForeground(new Color(255, 128, 128));
		member_1.setFont(new Font("굴림", Font.BOLD, 15));
		member_1.setBounds(150, 40, 37, 27);
		memberpanel.add(member_1);
		
		JLabel member_2 = new JLabel("");
		member_2.setForeground(new Color(255, 128, 128));
		member_2.setFont(new Font("굴림", Font.BOLD, 15));
		member_2.setBounds(150, 70, 37, 27);
		memberpanel.add(member_2);
		
		JPanel seatpanel = new JPanel();
		seatpanel.setBounds(294, 67, 226, 136);
		add(seatpanel);
		seatpanel.setBackground(new Color(255,255,255));
		seatpanel.setBorder(border);
		seatpanel.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("사 용 중 : ");
		lblNewLabel_4_1.setBounds(12, 10, 102, 24);
		seatpanel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 15));
		JLabel seat = new JLabel("");
		seat.setBounds(145, 9, 27, 27);
		seatpanel.add(seat);
		seat.setForeground(new Color(255, 128, 128));
		seat.setFont(new Font("굴림", Font.BOLD, 15));
		JLabel lblNewLabel_3_1 = new JLabel("/");
		lblNewLabel_3_1.setBounds(168, 10, 17, 27);
		seatpanel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 15));
		JLabel lblNewLabel_1 = new JLabel(" 56");
		lblNewLabel_1.setBounds(180, 10, 34, 27);
		seatpanel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		
		JLabel laptopzonelabel = new JLabel("LAPTOP ZONE :");
		laptopzonelabel.setForeground(new Color(114, 166, 255));
		laptopzonelabel.setFont(new Font("굴림", Font.BOLD, 15));
		laptopzonelabel.setBounds(12, 40, 128, 24);
		seatpanel.add(laptopzonelabel);
		
		JLabel laptopzone = new JLabel("");
		laptopzone.setForeground(new Color(255, 128, 128));
		laptopzone.setFont(new Font("굴림", Font.BOLD, 15));
		laptopzone.setBounds(145, 39, 27, 27);
		seatpanel.add(laptopzone);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("/");
		lblNewLabel_3_1_2.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBounds(168, 40, 17, 27);
		seatpanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel(" 10");
		lblNewLabel_1_2.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(180, 40, 34, 27);
		seatpanel.add(lblNewLabel_1_2);
		
		JLabel studyzonelabel = new JLabel("STUDY ZONE   : ");
		studyzonelabel.setForeground(new Color(114, 166, 255));
		studyzonelabel.setFont(new Font("굴림", Font.BOLD, 15));
		studyzonelabel.setBounds(12, 70, 128, 24);
		seatpanel.add(studyzonelabel);
		
		JLabel studyzone = new JLabel("");
		studyzone.setForeground(new Color(255, 128, 128));
		studyzone.setFont(new Font("굴림", Font.BOLD, 15));
		studyzone.setBounds(145, 69, 27, 27);
		seatpanel.add(studyzone);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("/");
		lblNewLabel_3_1_3.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3_1_3.setBounds(168, 70, 17, 27);
		seatpanel.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel(" 16");
		lblNewLabel_1_3.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(180, 70, 34, 27);
		seatpanel.add(lblNewLabel_1_3);
		
		JLabel studyroomlabel = new JLabel("CAFE    ZONE  : ");
		studyroomlabel.setForeground(new Color(114, 166, 255));
		studyroomlabel.setFont(new Font("굴림", Font.BOLD, 15));
		studyroomlabel.setBounds(12, 100, 128, 24);
		seatpanel.add(studyroomlabel);
		
		JLabel studyroom = new JLabel("");
		studyroom.setForeground(new Color(255, 128, 128));
		studyroom.setFont(new Font("굴림", Font.BOLD, 15));
		studyroom.setBounds(145, 99, 27, 27);
		seatpanel.add(studyroom);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("/");
		lblNewLabel_3_1_4.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3_1_4.setBounds(168, 100, 17, 27);
		seatpanel.add(lblNewLabel_3_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("30");
		lblNewLabel_1_4.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(188, 100, 19, 27);
		seatpanel.add(lblNewLabel_1_4);
		
		JPanel lockpanel = new JPanel();
		lockpanel.setBounds(575, 67, 226, 136);
		add(lockpanel);
		lockpanel.setBackground(new Color(255,255,255));
		lockpanel.setBorder(border);
		lockpanel.setLayout(null);
		
		JLabel lock = new JLabel("");
		lock.setBounds(145, 9, 27, 27);
		lockpanel.add(lock);
		lock.setForeground(new Color(255, 128, 128));
		lock.setFont(new Font("굴림", Font.BOLD, 15));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("/");
		lblNewLabel_3_1_1.setBounds(168, 10, 17, 27);
		lockpanel.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel(" 20");
		lblNewLabel_1_1.setBounds(180, 10, 34, 27);
		lockpanel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		
		JLabel lblNewLabel_4_1_1 = new JLabel("사 용 중  : ");
		lblNewLabel_4_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1_1.setBounds(12, 10, 102, 24);
		lockpanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("비활성화 : ");
		lblNewLabel_4_1_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4_1_1_1.setBounds(12, 40, 102, 24);
		lockpanel.add(lblNewLabel_4_1_1_1);
		
		JLabel lock_1 = new JLabel("");
		lock_1.setForeground(new Color(255, 128, 128));
		lock_1.setFont(new Font("굴림", Font.BOLD, 15));
		lock_1.setBounds(145, 39, 27, 27);
		lockpanel.add(lock_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("/");
		lblNewLabel_3_1_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3_1_1_1.setBounds(168, 39, 17, 27);
		lockpanel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" 20");
		lblNewLabel_1_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(180, 39, 34, 27);
		lockpanel.add(lblNewLabel_1_1_1);
		JLabel lblNewLabel_4 = new JLabel("회  원");
		lblNewLabel_4.setBounds(45, 38, 62, 24);
		add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setForeground(new Color(114,166,255));
		
		JLabel lblNewLabel_4_2 = new JLabel("좌  석");
		lblNewLabel_4_2.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_2.setBounds(326, 38, 62, 24);
		add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("사 물 함");
		lblNewLabel_4_2_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_2_1.setBounds(609, 38, 75, 24);
		add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_4 = new JLabel("회 원 통 계");
		lblNewLabel_4_4.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_4.setBounds(12, 213, 113, 24);
		add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\member.png"));
		lblNewLabel_2.setBounds(12, 38, 24, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\office-chair.png"));
		lblNewLabel_2_1.setBounds(290, 33, 34, 32);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\locker.png"));
		lblNewLabel_2_1_1.setBounds(575, 34, 32, 32);
		add(lblNewLabel_2_1_1);
		
		JSONObject data = new JSONObject();
		try {
			String activations = "0";
			data.put("activations", activations);
			Post po = new Post();
			JSONObject check = po.jsonpost("/Count", data);
			if(check.getString("check").equals("true")) {
				int membercount = (int) check.get("count_Member");
				int seatcount = (int) check.get("count_Seat");
				int lockcount = (int) check.get("count_Lock");
				MemberCount = Integer.toString(membercount);
				SeatCount = Integer.toString(seatcount);
				LockCount = Integer.toString(lockcount);
				member.setText(MemberCount);
				seat.setText(SeatCount);
				lock.setText(LockCount);
				
				data.put("activations", activations);
				data.put("id", "LAPTOP ZONE");
				check = po.jsonpost("/FindSeatType", data);
				int count1 = (int) check.get("count");
				data.put("activations", activations);
				data.put("id", "STUDY ZONE");
				check = po.jsonpost("/FindSeatType", data);
				int count2 = (int) check.get("count");
				data.put("activations", activations);
				data.put("id", "CAFE ZONE");
				check = po.jsonpost("/FindSeatType", data);
				int count3 = (int) check.get("count");
				
				laptopzone.setText(Integer.toString(count1));
				studyzone.setText(Integer.toString(count2));
				studyroom.setText(Integer.toString(count3));
			}else {
			}
		}catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String activations = "2";
		try {
			data.put("activations", activations);
			Post po = new Post();
			JSONObject check = po.jsonpost("/Count", data);
			int lockcount = (int) check.get("count_Lock");
			LockCount = Integer.toString(lockcount);
			lock_1.setText(LockCount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int mancount = 0;
		int girlcount = 0;
		try {
			data.put("gender", "남자");
			Post po = new Post();
			JSONObject check = po.jsonpost("/CountGender", data);
			mancount = (int) check.get("count_Member");
			member_1.setText(String.valueOf(mancount));
			data.put("gender", "여자");
			po = new Post();
			check = po.jsonpost("/CountGender", data);
			girlcount = (int) check.get("count_Member");
			member_2.setText(String.valueOf(girlcount));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray managerInfoArray;
		Post po = new Post();

		// 연령대별 카운트를 저장할 변수 초기화
		int count10s = 0;
		int count20s = 0;
		int count30s = 0;
		int count40s = 0;
		int count50s = 0;
		int count60s = 0;
		int count70s = 0;

		try {
		    data.put("0", "0");
		    JSONObject response = po.jsonpost("/FindManager", data);

		    managerInfoArray = response.getJSONArray("manager_info");
		    for (int i = 0; i < managerInfoArray.length(); i++) {
		        JSONObject managerInfo = managerInfoArray.getJSONObject(i);
		        String birth = managerInfo.getString("birth");
		        // birth 값에서 연도 추출
		        String birthYear = birth.substring(0, 4);
		        // 현재 연도 구하기 (예: 2023)
		        Calendar calendar = Calendar.getInstance();
		        int currentYear = calendar.get(Calendar.YEAR);
		        // 연령 계산
		        int age = currentYear - Integer.parseInt(birthYear);
		        // 연령대에 따라 카운트 증가
		        if (age >= 70) {
		            count70s++;
		        } else if (age >= 60 && age < 70) {
		            count60s++;
		        } else if (age >= 50 && age < 60) {
		            count50s++;
		        } else if (age >= 40 && age < 50) {
		            count40s++;
		        } else if (age >= 30 && age < 40) {
		            count30s++;
		        } else if (age >= 20 && age < 30) {
		            count20s++;
		        } else if (age >= 10 && age < 20) {
		            count10s++;
		        }
		    }

		} catch (JSONException e1) {
		    e1.printStackTrace();
		}
		drawPieChart(chartpanel, 1, 12, 380, 280, mancount, girlcount); //원형그래프
		drawBarChart(chartpanel, 380, 10, 387, 300,
		        List.of("10대", "20대", "30대", "40대", "50대", "60대", "70대"),
		        List.of((double) count10s, (double) count20s, (double) count30s, (double) count40s, (double) count50s, (double) count60s, (double) count70s));
		}

		public static void drawBarChart(JPanel panel, int x, int y, int width, int height, List<String> ageRanges, List<Double> values) {
		    DefaultCategoryDataset dataset = createDataset(ageRanges, values);
		    JFreeChart chart = createChart(dataset);
		    ChartPanel chartPanel = new ChartPanel(chart);
		    chartPanel.setBounds(x, y, width, height);
		    chartPanel.setOpaque(false);
		    panel.add(chartPanel);
		}

		private static DefaultCategoryDataset createDataset(List<String> ageRanges, List<Double> values) {
		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		    for (int i = 0; i < ageRanges.size(); i++) {
		        dataset.addValue(values.get(i), "", ageRanges.get(i));
		    }

		    return dataset;
		}

    private static JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "", // Chart title (타이틀은 빈 문자열로 설정)
                "", // Domain axis label
                "", // Range axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                false, // Show legend
                true, // Use tooltips
                false // Configure chart to generate URLs
        );

        // 한글 폰트 설정
        Font koreanFont = new Font("Malgun Gothic", Font.BOLD, 12);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setLabelFont(koreanFont);
        plot.getRangeAxis().setLabelFont(koreanFont);
        plot.setBackgroundPaint(new Color(217, 231, 255));

        // 타이틀 폰트와 색상 설정
        TextTitle title = new TextTitle("회원 연령별 비율", koreanFont);
        title.setPaint(new Color(83, 144, 255));
        chart.setTitle(title);

        // Customize chart appearance
        chart.setBackgroundPaint(Color.white);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(koreanFont);
        domainAxis.setTickLabelPaint(new Color(83, 144, 255)); // x축 레이블 색상 변경

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setRange(0, 100); // Y-axis maximum value set to 100

        // Customize Y-axis label format
        rangeAxis.setTickUnit(new NumberTickUnit(10)); // Set the interval to 10
        rangeAxis.setNumberFormatOverride(new DecimalFormat("#명"));
        rangeAxis.setTickLabelFont(koreanFont);
        rangeAxis.setTickLabelPaint(new Color(83, 144, 255)); // Y-축 레이블 색상 변경
        // Customize graph renderer
        CategoryItemRenderer renderer = new BarRenderer();

        // Create and set label generator for the bar chart
        StandardCategoryItemLabelGenerator labelGenerator = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("#명"));
        renderer.setDefaultItemLabelGenerator(labelGenerator);
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        renderer.setDefaultItemLabelPaint(new Color(255, 128, 128));
        // Set font for item labels
        Font labelFont = new Font("Malgun Gothic", Font.BOLD, 8); // 폰트 설정
        renderer.setDefaultItemLabelFont(labelFont); // 아이템 라벨 폰트 설정

        plot.setRenderer(renderer);

        // Customize bar color
        BarRenderer barRenderer = (BarRenderer) renderer;
        barRenderer.setBarPainter(new StandardBarPainter());
        barRenderer.setSeriesPaint(0, new Color(83, 144, 255));

        return chart;
    }



	//원형 그래프
    public static void drawPieChart(JPanel panel, int x, int y, int width, int height, double man, double girl) {
        // 데이터셋 생성
        PieDataset dataset = createDataset(man, girl);
        // 차트 생성
        JFreeChart chart = createChart(dataset);
        // 차트 패널 생성 및 설정
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(x, y, width, height);
        chartPanel.setOpaque(false);
        // 패널에 차트 패널 추가
        panel.add(chartPanel);
    }

    private static PieDataset createDataset(double man, double girl) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("남자", man);
        dataset.setValue("여자", girl);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("", dataset, false, false, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255, 0));
        plot.setOutlineVisible(false);

        // 라벨 포맷 설정
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("({2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        plot.setLabelBackgroundPaint(new Color(0, 0, 0, 0));
        plot.setLabelShadowPaint(null);
        plot.setLabelPaint(new Color(83, 144, 255)); // 라벨 글자색 설정
        plot.setLabelOutlinePaint(new Color(0, 0, 0, 0)); // 라벨 테두리 색 설정
        Font labelFont = plot.getLabelFont(); // 현재 라벨 글꼴 가져오기
        Font boldLabelFont = labelFont.deriveFont(Font.BOLD); // 더 두껍게 설정
        plot.setLabelFont(boldLabelFont); // 라벨 글꼴을 더 두껍게 설정

        plot.setSectionPaint("남자", new Color(114, 166, 255));
        plot.setSectionPaint("여자", new Color(255, 128, 128));

        // 타이틀 폰트와 색상 설정
        TextTitle title = new TextTitle("회원 남여 비율");
        title.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
        title.setPaint(new Color(83, 144, 255));
        chart.setTitle(title);

        // 범례 위치 설정
        LegendTitle legend = new LegendTitle(plot);
        legend.setPosition(RectangleEdge.BOTTOM);
        chart.addLegend(legend);

        // 그래프 방향 및 시작 각도 설정
        plot.setDirection(Rotation.ANTICLOCKWISE);
        plot.setStartAngle(90);

        // 그래프 패딩 설정
        plot.setInteriorGap(0.04);

        // 타이틀과 차트의 간격 조정
        chart.setPadding(new RectangleInsets(0, 0, 0, 0));

        return chart;
    }
}
