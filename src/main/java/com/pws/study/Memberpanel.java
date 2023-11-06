package com.pws.study;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Memberpanel extends JPanel {
    private JTable table;
    private JPanel borderPanel;
    private JButton homebutton;
    private JButton closebutton;

    public Memberpanel(JButton homeButton, JButton closeButton,JPanel borderpanel) {
        setBackground(new Color(255, 255, 255));
        setBounds(23, 40, 816, 580);
        setLayout(null);
        this.borderPanel = borderpanel;
        this.homebutton = homeButton;
        this.closebutton = closeButton;
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

                    Click.phone = (String) table.getModel().getValueAt(row, 1);
                    ModifyMember mo = new ModifyMember(homebutton,closebutton,borderPanel);
                }
            }
        });
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 35));
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "구분", "전화번호", "비밀번호", "이메일", "성별", "생년월일" }
        ));

        // 스크롤 패널에 테이블 추가
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(217, 231, 255));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(114, 166, 255), 2)); // 테두리 선 두께 설정
        scrollPane.setBounds(40, 91, 738, 467);
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
        table.getColumn("구분").setPreferredWidth(10);
        table.getColumn("전화번호").setPreferredWidth(70);
        table.getColumn("비밀번호").setPreferredWidth(10);
        table.getColumn("이메일").setPreferredWidth(80);
        table.getColumn("성별").setPreferredWidth(15);
        table.getColumn("생년월일").setPreferredWidth(45);

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
			data.put("0", "0");
	        JSONObject response = po.jsonpost("/FindManager", data);
	        
			managerInfoArray = response.getJSONArray("manager_info");
		       for (int i = 0; i < managerInfoArray.length(); i++) {
		            JSONObject managerInfo = managerInfoArray.getJSONObject(i);
		            String phone = managerInfo.getString("phone");
		            String pw = managerInfo.getString("pw");
		            String email = managerInfo.getString("email");
		            String gender = managerInfo.getString("gender");
		            String birth = managerInfo.getString("birth");
		            
		            number++;
		            String num_1 = Integer.toString(number);
		            String[] row = { num_1,phone, pw, email, gender, birth };
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
        
        JLabel lblNewLabel_4 = new JLabel("전체 회원 수");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setBounds(40, 10, 121, 24);
		add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(114,166,255));
		JLabel lblNewLabel_4_1 = new JLabel("남          자");
		lblNewLabel_4_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_1.setBounds(228, 10, 121, 24);
		add(lblNewLabel_4_1);
		JLabel lblNewLabel_3_1 = new JLabel("명");
		lblNewLabel_3_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3_1.setBounds(110, 29, 47, 52);
		add(lblNewLabel_3_1);
		
		JLabel member = new JLabel("");
		member.setForeground(new Color(255, 128, 128));
		member.setFont(new Font("굴림", Font.PLAIN, 25));
		member.setBounds(63, 31, 53, 48);
		add(member);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("명");
		lblNewLabel_3_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3_1_1.setBounds(302, 29, 47, 52);
		add(lblNewLabel_3_1_1);
		
		JLabel man = new JLabel("");
		man.setForeground(new Color(255, 128, 128));
		man.setFont(new Font("굴림", Font.PLAIN, 25));
		man.setBounds(255, 31, 53, 48);
		add(man);
		
		JLabel girl = new JLabel("");
		girl.setForeground(new Color(255, 128, 128));
		girl.setFont(new Font("굴림", Font.PLAIN, 25));
		girl.setBounds(463, 31, 53, 48);
		add(girl);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("명");
		lblNewLabel_3_1_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_3_1_1_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3_1_1_1.setBounds(516, 29, 47, 52);
		add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("여           자");
		lblNewLabel_4_1_1.setForeground(new Color(114, 166, 255));
		lblNewLabel_4_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4_1_1.setBounds(442, 10, 121, 24);
		add(lblNewLabel_4_1_1);
		
		int mancount = 0;
		int girlcount = 0;
		int membercount = 0;
		try {
			data.put("gender", "남자");
			JSONObject check = po.jsonpost("/CountGender", data);
			mancount = (int) check.get("count_Member");
			man.setText(String.valueOf(mancount));
			data.put("gender", "여자");
			po = new Post();
			check = po.jsonpost("/CountGender", data);
			girlcount = (int) check.get("count_Member");
			girl.setText(String.valueOf(girlcount));
			membercount = mancount + girlcount;
			member.setText(String.valueOf(membercount));
			
			JLabel lblNewLabel_4_1_1_1 = new JLabel("사용중 회 원");
			lblNewLabel_4_1_1_1.setForeground(new Color(114, 166, 255));
			lblNewLabel_4_1_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_4_1_1_1.setBounds(651, 10, 121, 24);
			add(lblNewLabel_4_1_1_1);
			
			JLabel lblNewLabel_3_1_1_1_1 = new JLabel("명");
			lblNewLabel_3_1_1_1_1.setForeground(new Color(114, 166, 255));
			lblNewLabel_3_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel_3_1_1_1_1.setBounds(719, 29, 47, 52);
			add(lblNewLabel_3_1_1_1_1);
			
			JLabel members = new JLabel((String) null);
			members.setForeground(new Color(255, 128, 128));
			members.setFont(new Font("굴림", Font.PLAIN, 25));
			members.setBounds(672, 31, 53, 48);
			add(members);
			
			String activations = "0";
			data.put("activations", activations);
			check = po.jsonpost("/Count", data);
			if(check.getString("check").equals("true")) {
				int seatcount = (int) check.get("count_Seat");
				String MemberCount = Integer.toString(seatcount);
				members.setText(MemberCount);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
            if ("구분".equals(value) || "전화번호".equals(value) || "비밀번호".equals(value) || "이메일".equals(value)
                    || "성별".equals(value) || "생년월일".equals(value)) {
                renderer.setBackground(new Color(217, 231, 255));
                renderer.setForeground(new Color(114, 166, 255));
                renderer.setFont(new Font("굴림", Font.BOLD, 18));
                renderer.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 색상 설정
            }

            return renderer;
        }
    }
}
