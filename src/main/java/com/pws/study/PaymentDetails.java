package com.pws.study;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class PaymentDetails {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentDetails window = new PaymentDetails();
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
	public PaymentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(375, 100, 541, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 503, 443);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setVisible(true);
		panel.setBackground(new Color(255,255,255));
		panel.setBorder(border);
		
		JLabel projectname2 = new JLabel("결 제 내 역");
		projectname2.setForeground(new Color(114, 166, 255));
		projectname2.setFont(new Font("굴림", Font.BOLD, 20));
		projectname2.setBounds(202, 10, 114, 37);
		panel.add(projectname2);
		
		JButton BackButton = new JButton("");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
		BackButton.setBounds(0, 0, 45, 37);
		panel.add(BackButton);
		BackButton.setBorderPainted(false); 
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
	      	      
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
        table.setGridColor(new Color(114, 166, 255));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 마우스 클릭 이벤트
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) { // 더블 클릭 확인
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();

                }
            }
        });
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 35));
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "구분", "주문번호", "결제내역", "가격", "구매일자"}
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
        scrollPane.setBounds(12, 57, 479, 376);
        panel.add(scrollPane);

        // 각 열의 너비 설정
        table.getColumn("구분").setPreferredWidth(1);
        table.getColumn("주문번호").setPreferredWidth(40);
        table.getColumn("결제내역").setPreferredWidth(100);
        table.getColumn("가격").setPreferredWidth(10);
        table.getColumn("구매일자").setPreferredWidth(70);
        
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
        JSONArray PaymentInfoArray;
		try {
			data.put("phone", Info.phone);
	        JSONObject response = po.jsonpost("/FindPaymentDetails", data);
	        
			PaymentInfoArray = response.getJSONArray("payment_info");
		       for (int i = 0; i < PaymentInfoArray.length(); i++) {
		            JSONObject paymentInfo = PaymentInfoArray.getJSONObject(i);
		            String order_number = paymentInfo.getString("order_number");
		            String t_name = paymentInfo.getString("t_name");
		            String t_money = paymentInfo.getString("t_money");
		            String dates = paymentInfo.getString("dates"); 
		            
		            number++;
		            String num_1 = Integer.toString(number);
		            String[] row = { num_1,order_number, t_name, t_money, dates};
		            model.addRow(row);
		        }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
            if ("구분".equals(value) || "주문번호".equals(value) || "결제내역".equals(value) || "가격".equals(value)
                    || "구매일자".equals(value)) {
                renderer.setBackground(new Color(217, 231, 255));
                renderer.setForeground(new Color(114, 166, 255));
                renderer.setFont(new Font("굴림", Font.BOLD, 12));
                renderer.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 색상 설정
            }

            return renderer;
        }
    }
}


