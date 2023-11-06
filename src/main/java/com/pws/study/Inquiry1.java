package com.pws.study;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import com.pws.study.Memberpanel.CustomHeaderRenderer;

public class Inquiry1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inquiry1 window = new Inquiry1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inquiry1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		   	frame = new JFrame();
		      frame.setBounds(210, 20, 870, 650);
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.getContentPane().setLayout(null);
		      frame.setResizable(false);
		      frame.setVisible(true);
		      
		      Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		      Border border1 =  BorderFactory.createLineBorder(new Color(0,0,255),2);
		      JPanel mainpanel  = new JPanel();
		      mainpanel .setBounds(0, 0, 856, 613);
		      frame.getContentPane().add(mainpanel ); 
		      mainpanel .setLayout(null);
		      mainpanel .setBackground(new Color(255,255,255));
		      
		      JPanel borderpanel = new JPanel();
		      borderpanel.setBounds(10, 10, 837, 593);
		      mainpanel.add(borderpanel);
		      borderpanel.setLayout(null);
		      borderpanel.setBackground(new Color(255,255,255));
		      borderpanel.setBorder(border);
		      
		      JLabel projectname = new JLabel("포텐스터디카페");
		      projectname.setFont(new Font("굴림", Font.BOLD, 35));
		      projectname.setForeground(new Color(114, 166, 255));
		      projectname.setBounds(313, 10, 338, 53);
		      borderpanel.add(projectname);
		      
		      JLabel projectname2 = new JLabel("POTEN STUDY CAFE");
		      projectname2.setForeground(new Color(114, 166, 255));
		      projectname2.setFont(new Font("굴림", Font.BOLD, 30));
		      projectname2.setBounds(265, 54, 398, 37);
		      borderpanel.add(projectname2);
		      
		      ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop");
		      JLabel label = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\clock.png"));
		      label.setBounds(265,10,43,43);
		      borderpanel.add(label);
		      
		      JButton BackButton = new JButton("");
				BackButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						FAQ fa = new FAQ();
					}
				});
				BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
				BackButton.setBounds(0, 0, 45, 40);
				borderpanel.add(BackButton);
				BackButton.setBorderPainted(false); 
				BackButton.setContentAreaFilled(false);
				BackButton.setFocusPainted(false);
				
				RoundedButton2 bu_1 = new RoundedButton2("등록하기");
				bu_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Inquiry In = new Inquiry();
					}
				});
				bu_1.setText("문의하기");
				bu_1.setFont(new Font("굴림", Font.BOLD, 15));
				bu_1.setBounds(381, 546, 95, 37);
				borderpanel.add(bu_1);
				
				// 테이블 생성
				JTable table = new JTable() {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				        // 모든 셀을 수정 불가능하게 설정
				        return false;
				    }
				};
		        table.getTableHeader().setReorderingAllowed(false);
		        table.getTableHeader().setResizingAllowed(false);
		        table.setBackground(new Color(255, 255, 255));
		        table.setGridColor(new Color(114, 166, 255));
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 마우스 클릭 이벤트
		        table.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mousePressed(MouseEvent e) {
		                if (e.getClickCount() == 2) { // 더블 클릭 확인
		                    int row = table.getSelectedRow();
		                    int col = table.getSelectedColumn();

		                    Click.question = (String) table.getModel().getValueAt(row, 1);
		                    Click.phone = Info.phone;
		                    CheckAnswer ch = new CheckAnswer(frame);
		                }
		            }
		        });
		        JTableHeader header = table.getTableHeader();
		        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 35));
		        table.setModel(new DefaultTableModel(
		                new Object[][] {},
		                new String[] { "구분", "제목", "질문일", "답변일" }
		        ));

		        // 스크롤 패널에 테이블 추가
		        JScrollPane scrollPane = new JScrollPane(table);
		        scrollPane.setBackground(new Color(217, 231, 255));
		        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(114, 166, 255), 2)); // 테두리 선 두께 설정
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
		        scrollPane.setBounds(12, 91, 813, 449);
		        borderpanel.add(scrollPane);
		        
		        // 각 열의 너비 설정
		        table.getColumn("구분").setPreferredWidth(0);
		        table.getColumn("제목").setPreferredWidth(300);
		        table.getColumn("질문일").setPreferredWidth(40);
		        table.getColumn("답변일").setPreferredWidth(40);

		        // 테이블 셀 가운데 정렬
		        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		        TableColumnModel tcm = table.getColumnModel();
		        for (int i = 0; i < tcm.getColumnCount(); i++) {
		            tcm.getColumn(i).setCellRenderer(dtcr);
		        }
		     
		        Post po = new Post();
		        JSONObject data = new JSONObject();
		        // 데이터를 서버에 전송하고 응답을 받아옵니다.
		        int number = 0;
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        JSONArray managerInfoArray;
				try {
					data.put("phone", Info.phone);
			        JSONObject response = po.jsonpost("/FindQNA", data);
					managerInfoArray = response.getJSONArray("manager_info");
					for (int i = 0; i < managerInfoArray.length(); i++) {
					    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
					    String q_record = managerInfo.getString("q_record");
					    String q_time = managerInfo.getString("q_time");
					    String checks = managerInfo.getString("checks");

					    // 만약 checks가 null이면 'X'로 설정하고, 아니면 checks의 값 그대로 사용합니다.
					    checks = checks.equals("NULL") ? "X" : checks;
					    number++;
					    String num_1 = Integer.toString(number);
					    String[] row = {num_1, q_record, q_time, checks};
					    model.addRow(row);
					}
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        // 테이블의 행 높이 설정
		        table.setRowHeight(30); // 원하는 높이로 설정

		        // 테이블 내부 선의 두께 설정 (내부 선은 행 간 구분 선)
		        table.setIntercellSpacing(new Dimension(0, 0));
		        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		            @Override
		            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		                c.setBackground(Color.WHITE);
		                ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 두께 1로 설정
		                return c;
		            }
		        });

		        // 커스텀 헤더 렌더러 설정
		        table.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
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
	            if ("구분".equals(value) || "제목".equals(value) || "질문일".equals(value) || "답변일".equals(value)) {
	                renderer.setBackground(new Color(217, 231, 255));
	                renderer.setForeground(new Color(114, 166, 255));
	                renderer.setFont(new Font("굴림", Font.BOLD, 18));
	                renderer.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 색상 설정
	            }

	            return renderer;
	        }
	  }

}
