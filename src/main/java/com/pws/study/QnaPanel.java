package com.pws.study;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class QnaPanel extends JPanel {
	private JTable table_1;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public QnaPanel(JPanel borderpanel, JButton homeButton, JButton closeButton) {
		 addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.setNumRows(0);
				        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
				        model1.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        JSONArray managerInfoArray;
				        JSONArray managerInfoArray1;
						try {
							int number = 0;
							data.put("checks", "NULL");
					        JSONObject response = po.jsonpost("/FindAllQna", data);
							managerInfoArray = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray.length(); i++) {
							    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number++;
							    String num_1 = Integer.toString(number);
							    String[] row = {num_1, q_record,ph};
							    model.addRow(row);
							}
								int number1 = 0;
							    data.put("checks", "0");
						        response = po.jsonpost("/FindAllQna", data);
								JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
								for (int i = 0; i < managerInfoArray2.length(); i++) {
								    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
								    String q_record = managerInfo.getString("q_record");
								    String ph = managerInfo.getString("phone");
								    number1++;
								    String num_1 = Integer.toString(number1);
								    String[] row1 = {num_1, q_record,ph};
								    model1.addRow(row1);
								}
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
	     setBackground(new Color(255, 255, 255));
	     setBounds(23, 40, 816, 580);
	     setLayout(null);
	     
	     JLabel lblNewLabel_4 = new JLabel("답변완료");
	     lblNewLabel_4.setForeground(new Color(114, 166, 255));
	     lblNewLabel_4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
	     lblNewLabel_4.setBounds(484, 88, 100, 30);
	     add(lblNewLabel_4);
	     
	     JLabel lblNewLabel_4_1 = new JLabel("미답변");
	     lblNewLabel_4_1.setForeground(new Color(114, 166, 255));
	     lblNewLabel_4_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
	     lblNewLabel_4_1.setBounds(45, 86, 79, 30);
	     add(lblNewLabel_4_1);
	     
	     JTable table = new JTable() {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        // 모든 셀을 수정 불가능하게 설정
			        return false;
			    }
			};
			table.setFont(new Font("굴림", Font.BOLD, 10));
	        table.getTableHeader().setReorderingAllowed(false);
	        table.getTableHeader().setResizingAllowed(false);
	        table.setBackground(new Color(255, 255, 255));
	        table.setGridColor(new Color(193, 215, 255,100));
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 마우스 클릭 이벤트
	        table.setForeground(new Color(114,166,255));
	        table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 2) { // 더블 클릭 확인
	                    int row = table.getSelectedRow();
	                    
	                    Click.question = (String) table.getModel().getValueAt(row,1);
	                    Click.phone = (String) table.getModel().getValueAt(row, 2);
	                    QnaAnswer qn = new QnaAnswer(homeButton,closeButton,borderpanel);
	                }
	            }
	        });
	        JTableHeader header = table.getTableHeader();
	        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 35));
	        table.setModel(new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "구 분","제 목","전화번호"}
	        ));

	        // 스크롤 패널에 테이블 추가
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBackground(new Color(217, 231, 255));
	        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(114, 166, 255), 2)); // 테두리 선 두께 설정
	        scrollPane.setBounds(12, 123, 358, 447);
	        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
	            @Override
	            protected void configureScrollBarColors() {
	                this.thumbColor = new Color(217, 231, 255);
	            }
	            @Override
	            protected JButton createDecreaseButton(int orientation) {
	                JButton button = super.createDecreaseButton(orientation);
	                button.setBackground(new Color(217, 231, 255)); // 스크롤바 화살표 색상
	                button.setBorder(BorderFactory.createLineBorder(new Color(217, 231, 255))); // 스크롤바 화살표 테두리 색상
	                return button;
	            }

	            @Override
	            protected JButton createIncreaseButton(int orientation) {
	                JButton button = super.createIncreaseButton(orientation);
	                button.setBackground(new Color(217, 231, 255)); // 스크롤바 화살표 색상
	                button.setBorder(BorderFactory.createLineBorder(new Color(217, 231, 255))); // 스크롤바 화살표 테두리 색상
	                return button;
	            }
	            });
	        add(scrollPane);
	        
	        // 각 열의 너비 설정
	        table.getColumn("구 분").setPreferredWidth(30);
	        table.getColumn("제 목").setPreferredWidth(150);
	        table.getColumn("전화번호").setPreferredWidth(100);
	
	        // 테이블 셀 가운데 정렬
	        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	        TableColumnModel tcm = table.getColumnModel();
	        for (int i = 0; i < tcm.getColumnCount(); i++) {
	            tcm.getColumn(i).setCellRenderer(dtcr);
	        }
	     
	        // 테이블의 행 높이 설정
	        table.setRowHeight(30); // 원하는 높이로 설정
	
	        // 테이블 내부 선의 두께 설정 (내부 선은 행 간 구분 선)
	        table.setIntercellSpacing(new Dimension(0, 0)); // 셀 간격을 0으로 설정
	        
	        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                c.setBackground(Color.WHITE);
	                ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(167, 198, 255,100))); // 내부 선 두께 1로 설정
	                return c;
	            }
	        });
	
	        // 커스텀 헤더 렌더러 설정
	        table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
	        
        JTable table_1 = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 모든 셀을 수정 불가능하게 설정
                return false;
            }
        };
        table_1.setFont(new Font("굴림", Font.BOLD, 10));
        table_1.getTableHeader().setReorderingAllowed(false);
        table_1.getTableHeader().setResizingAllowed(false);
        table_1.setBackground(new Color(255, 255, 255));
        table_1.setGridColor(new Color(193, 215, 255,100));
        table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 마우스 클릭 이벤트
        table_1.setForeground(new Color(114,166,255));
        table_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 더블 클릭 확인
                    int row = table_1.getSelectedRow();

                    Click.question = (String) table_1.getModel().getValueAt(row,1);
                    Click.phone = (String) table_1.getModel().getValueAt(row, 2);
                    UpdateAnswer up = new UpdateAnswer(homeButton,closeButton,borderpanel);
                }
            }
        });
        JTableHeader header_1 = table_1.getTableHeader();
        header_1.setPreferredSize(new Dimension(header_1.getPreferredSize().width, 35));
        table_1.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "구 분","제 목","전화번호"}
        ));

        // 스크롤 패널에 테이블 추가
        JScrollPane scrollPane_1 = new JScrollPane(table_1);
        scrollPane_1.setBackground(new Color(217, 231, 255));
        scrollPane_1.setBorder(BorderFactory.createLineBorder(new Color(114, 166, 255), 2)); // 테두리 선 두께 설정
        scrollPane_1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(217, 231, 255);
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(new Color(217, 231, 255)); // 스크롤바 화살표 색상
                button.setBorder(BorderFactory.createLineBorder(new Color(217, 231, 255))); // 스크롤바 화살표 테두리 색상
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(new Color(217, 231, 255)); // 스크롤바 화살표 색상
                button.setBorder(BorderFactory.createLineBorder(new Color(217, 231, 255))); // 스크롤바 화살표 테두리 색상
                return button;
            }
            });
        scrollPane_1.setBounds(446, 123, 358, 447);
        add(scrollPane_1);

        // 각 열의 너비 설정
        table_1.getColumn("구 분").setPreferredWidth(30);
        table_1.getColumn("제 목").setPreferredWidth(150);
        table_1.getColumn("전화번호").setPreferredWidth(100);
        
       this.table = table;
       this.table_1 = table_1;
        
        
        
        // 테이블 셀 가운데 정렬
        DefaultTableCellRenderer dtcr_1 = new DefaultTableCellRenderer();
        dtcr_1.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcm_1 = table_1.getColumnModel();
        for (int i = 0; i < tcm_1.getColumnCount(); i++) {
            tcm_1.getColumn(i).setCellRenderer(dtcr_1);
        }

        // 테이블의 행 높이 설정
        table_1.setRowHeight(30); // 원하는 높이로 설정

        // 테이블 내부 선의 두께 설정 (내부 선은 행 간 구분 선)
        table_1.setIntercellSpacing(new Dimension(0, 0)); // 셀 간격을 0으로 설정
        
        JLabel lblNewLabel_4_1_1 = new JLabel("");
        lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\check-mark.png"));
        lblNewLabel_4_1_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_4_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
        lblNewLabel_4_1_1.setBounds(446, 90, 24, 24);
        add(lblNewLabel_4_1_1);
        
        JLabel lblNewLabel_4_1_1_1 = new JLabel("");
        lblNewLabel_4_1_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cancel.png"));
        lblNewLabel_4_1_1_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_4_1_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
        lblNewLabel_4_1_1_1.setBounds(12, 92, 20, 20);
        add(lblNewLabel_4_1_1_1);

        table_1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.WHITE);
                ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(167, 198, 255,100))); // 내부 선 두께 1로 설정
                return c;
            }
        });

        // 커스텀 헤더 렌더러 설정
        table_1.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
        model1.setNumRows(0);
        Post po = new Post();
        JSONObject data = new JSONObject();
        JSONArray managerInfoArray;
        JSONArray managerInfoArray1;
		try {
			int number = 0;
			data.put("checks", "NULL");
	        JSONObject response = po.jsonpost("/FindAllQna", data);
			managerInfoArray = response.getJSONArray("manager_info");
			for (int i = 0; i < managerInfoArray.length(); i++) {
			    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
			    String q_record = managerInfo.getString("q_record");
			    String ph = managerInfo.getString("phone");
			    number++;
			    String num_1 = Integer.toString(number);
			    String[] row = {num_1, q_record,ph};
			    model.addRow(row);
			}
				int number1 = 0;
			    data.put("checks", "0");
		        response = po.jsonpost("/FindAllQna", data);
				JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
				for (int i = 0; i < managerInfoArray2.length(); i++) {
				    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
				    String q_record = managerInfo.getString("q_record");
				    String ph = managerInfo.getString("phone");
				    number1++;
				    String num_1 = Integer.toString(number1);
				    String[] row1 = {num_1, q_record,ph};
				    model1.addRow(row1);
				}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        
        RoundedButton3 keyword = new RoundedButton3("");
		keyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			        
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						int number = 0;
						data.put("checks", "NULL");
						data.put("q_type", keyword.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
							int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});	
		keyword.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
		keyword.setBounds(22, 24, 105, 37);
		borderpanel.add(keyword);
	    keyword.setTextColor(new Color(114, 166, 255));
		keyword.setBorderPainted(false);
		keyword.setBackgroundColor(new Color(205,224,255));
		keyword.setFocusPainted(false);
		add(keyword);
		
        RoundedButton3 keyword1 = new RoundedButton3("");
        keyword1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			       
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						 int number = 0;
						data.put("checks", "NULL");
					    data.put("q_type",keyword1.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
						 	int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword1.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        });
        keyword1.setTextColor(new Color(114, 166, 255));
        keyword1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
        keyword1.setFocusPainted(false);
        keyword1.setBorderPainted(false);
        keyword1.setBackgroundColor(new Color(205,224,255));
        keyword1.setBounds(152, 24, 105, 37);
        add(keyword1);
        
        RoundedButton3 keyword2 = new RoundedButton3("");
        keyword2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			        
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						int number = 0;
						data.put("checks", "NULL");
					    data.put("q_type",keyword2.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
						int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword2.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        });
        keyword2.setTextColor(new Color(114, 166, 255));
        keyword2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
        keyword2.setFocusPainted(false);
        keyword2.setBorderPainted(false);
        keyword2.setBackgroundColor(new Color(205,224,255));
        keyword2.setBounds(283, 24, 105, 37);
        add(keyword2);
        
        RoundedButton3 keyword3 = new RoundedButton3("");
        keyword3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			        
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						int number = 0;
						data.put("checks", "NULL");
					    data.put("q_type",keyword3.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
						int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword3.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        });
        keyword3.setTextColor(new Color(114, 166, 255));
        keyword3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
        keyword3.setFocusPainted(false);
        keyword3.setBorderPainted(false);
        keyword3.setBackgroundColor(new Color(205,224,255));
        keyword3.setBounds(413, 24, 105, 37);
        add(keyword3);
        
        RoundedButton3 keyword4 = new RoundedButton3("");
        keyword4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			        
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						int number = 0;
						data.put("checks", "NULL");
					    data.put("q_type",keyword4.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
						int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword4.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        });
        keyword4.setTextColor(new Color(114, 166, 255));
        keyword4.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
        keyword4.setFocusPainted(false);
        keyword4.setBorderPainted(false);
        keyword4.setBackgroundColor(new Color(205,224,255));
        keyword4.setBounds(543, 24, 105, 37);
        add(keyword4);
        
        RoundedButton3 keyword5 = new RoundedButton3("");
        keyword5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Post po = new Post();
			        JSONObject data = new JSONObject();
			        // 데이터를 서버에 전송하고 응답을 받아옵니다.
			        
			        DefaultTableModel model = (DefaultTableModel) table.getModel();
			        model.setNumRows(0);
			        DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
			        model1.setNumRows(0);
			        JSONArray managerInfoArray;
			        JSONArray managerInfoArray1;
					try {
						int number = 0;
						data.put("checks", "NULL");
					    data.put("q_type",keyword5.getText());
				        JSONObject response = po.jsonpost("/Findqna", data);
						managerInfoArray = response.getJSONArray("manager_info");
						for (int i = 0; i < managerInfoArray.length(); i++) {
						    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
						    String q_record = managerInfo.getString("q_record");
						    String ph = managerInfo.getString("phone");
						    number++;
						    String num_1 = Integer.toString(number);
						    String[] row = {num_1, q_record,ph};
						    model.addRow(row);
						}
						int number1 = 0;
						    data.put("checks", "0");
						    data.put("q_type",keyword5.getText());
					        response = po.jsonpost("/Findqna", data);
							JSONArray managerInfoArray2 = response.getJSONArray("manager_info");
							for (int i = 0; i < managerInfoArray2.length(); i++) {
							    JSONObject managerInfo = managerInfoArray2.getJSONObject(i);
							    String q_record = managerInfo.getString("q_record");
							    String ph = managerInfo.getString("phone");
							    number1++;
							    String num_1 = Integer.toString(number1);
							    String[] row1 = {num_1, q_record,ph};
							    model1.addRow(row1);
							}
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        });
        keyword5.setTextColor(new Color(114, 166, 255));
        keyword5.setFont(new Font("한컴산뜻돋움", Font.BOLD, 17));
        keyword5.setFocusPainted(false);
        keyword5.setBorderPainted(false);
        keyword5.setBackgroundColor(new Color(205,224,255));
        keyword5.setBounds(676, 24, 105, 37);
        add(keyword5);

        // 데이터를 서버에 전송하고 응답을 받아옵니다.
        try {
            data.put("keyword", "");

            JSONObject check = po.jsonpost("/Findkeyword", data);

            if (check.has("check") && check.getString("check").equals("true")) {
                JSONArray keywordArray = check.getJSONArray("keyword");

                // Assuming you have TextView objects named keyword, keyword1, keyword2, ...
                for (int i = 0; i < 6; i++) {
                    JSONObject keywordObject = keywordArray.getJSONObject(i);
                    String keywordText = keywordObject.getString("keyword");

                    // Assuming you have labels named keyword, keyword1, keyword2, ...
                    if (i == 0) {
                        keyword.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    } else if (i == 1) {
                        keyword1.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    } else if (i == 2) {
                        keyword2.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    } else if (i == 3) {
                        keyword3.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    } else if (i == 4) {
                        keyword4.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    } else if (i == 5) {
                        keyword5.setText("NULL".equals(keywordText) ? "X" : keywordText);
                    }
                }
            } else {
                // Handle the case when "check" is not "true"
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }

	}
	
	static class CustomHeaderRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;

        public CustomHeaderRenderer() {
            this.defaultRenderer = new DefaultTableCellRenderer();
            ((DefaultTableCellRenderer) defaultRenderer).setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JComponent renderer = (JComponent) defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // 특정 컬럼명인 경우 배경색 변경
            if ("구 분".equals(value) || "제 목".equals(value) || "전화번호".equals(value)) {
                renderer.setBackground(new Color(217, 231, 255));
                renderer.setForeground(new Color(114, 166, 255));
                renderer.setFont(new Font("굴림", Font.BOLD, 12));
                renderer.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 색상 설정
            }
            return renderer;
        }
        
        
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
