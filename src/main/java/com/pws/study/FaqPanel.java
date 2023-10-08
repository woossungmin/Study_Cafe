package com.pws.study;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pws.study.Memberpanel.CustomHeaderRenderer;

public class FaqPanel extends JPanel {
	JSONObject b1 = null;
	JSONObject b2 = null;
	JSONObject b3 = null;
	JSONObject b4 = null;
	JSONObject b5 = null;
	JSONObject b6 = null;
	
	
	public FaqPanel(JPanel borderpanel, JButton homeButton, JButton closeButton) {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
	     setBackground(new Color(255, 255, 255));
	     setBounds(23, 40, 816, 580);
	     setLayout(null);
	     
	     // 테이블 생성
			JTable table = new JTable() {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        // 모든 셀을 수정 불가능하게 설정
			        return false;
			    }
			};
			table.setFont(new Font("굴림", Font.BOLD, 12));
	        table.getTableHeader().setReorderingAllowed(false);
	        table.getTableHeader().setResizingAllowed(false);
	        table.setBackground(new Color(255, 255, 255));
	        table.setGridColor(new Color(193, 215, 255,100));
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블 마우스 클릭 이벤트
	        table.setForeground(new Color(114,166,255));
	        table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                if (e.getClickCount() == 2) { // 더블 클릭 확인
	                    int row = table.getSelectedRow();
	                    int col = table.getSelectedColumn();
	
	                    Click.phone = (String) table.getModel().getValueAt(row, 1);
	                }
	            }
	        });
	        JTableHeader header = table.getTableHeader();
	        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 35));
	        table.setModel(new DefaultTableModel(
	                new Object[][] {},
	                new String[] { "구 분","제 목", "답 변"}
	        ));
	
	        // 스크롤 패널에 테이블 추가
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBackground(new Color(217, 231, 255));
	        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(114, 166, 255), 2)); // 테두리 선 두께 설정
	        scrollPane.setBounds(12, 57, 792, 513);
	        add(scrollPane);
	        
	        // 각 열의 너비 설정
	        table.getColumn("구 분").setPreferredWidth(1);
	        table.getColumn("제 목").setPreferredWidth(250);
	        table.getColumn("답 변").setPreferredWidth(400);
	
	        // 테이블 셀 가운데 정렬
	        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	        TableColumnModel tcm = table.getColumnModel();
	        for (int i = 0; i < tcm.getColumnCount(); i++) {
	            tcm.getColumn(i).setCellRenderer(dtcr);
	        }
	     
	        // 테이블의 행 높이 설정
	        table.setRowHeight(50); // 원하는 높이로 설정
	
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
	        
	        JButton keyword = new JButton("");
			keyword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(keyword.getText().equals("NULL")) {
						InsertFaq in = new InsertFaq(borderpanel,homeButton,closeButton);
					}
					else {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword.getText());
					        JSONObject response = po.jsonpost("/FindFaq", data);
					        
							FaqInfoArray = response.getJSONArray("Faq_Info");
						       for (int i = 0; i < FaqInfoArray.length(); i++) {
						            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
						            String key = faqinfo.getString("keyword");
						            String question= faqinfo.getString("question");
						            String answer = faqinfo.getString("answer"); 
						            number++;
						            String num_1 = Integer.toString(number);
						            String[] row = { num_1,question,answer};
						            model.addRow(row);
						        }
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});	
			keyword.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) { 
			        	if(!keyword.getText().equals("NULL"))
			        	{
			        		UpdateKeyword up = new UpdateKeyword(keyword.getText(),homeButton,closeButton,borderpanel);	
			        	}
			        }
			    }
			});
			keyword.setFont(new Font("굴림", Font.BOLD, 17));
			keyword.setBounds(12, 10, 105, 37);
			borderpanel.add(keyword);
		    keyword.setForeground(new Color(114, 166, 255));
			keyword.setBorderPainted(false);
			keyword.setBackground(new Color(255,255,255));
			keyword.setFocusPainted(false);
			add(keyword);
			
	        JButton keyword1 = new JButton("");
	        keyword1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					if(keyword1.getText().equals("NULL")) {
						InsertFaq in = new InsertFaq(borderpanel,homeButton,closeButton);
					}
					else {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword1.getText());
					        JSONObject response = po.jsonpost("/FindFaq", data);
					        
							FaqInfoArray = response.getJSONArray("Faq_Info");
						       for (int i = 0; i < FaqInfoArray.length(); i++) {
						            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
						            String key = faqinfo.getString("keyword");
						            String question= faqinfo.getString("question");
						            String answer = faqinfo.getString("answer"); 
						            number++;
						            String num_1 = Integer.toString(number);
						            String[] row = { num_1,question,answer};
						            model.addRow(row);
						        }
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	        	}
	        });
	        keyword1.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) { 
			        	if(!keyword1.getText().equals("NULL"))
			        	{
			        		UpdateKeyword up = new UpdateKeyword(keyword1.getText(),homeButton,closeButton,borderpanel);	
			        	}
			        }
			    }
			});
	        keyword1.setForeground(new Color(114, 166, 255));
	        keyword1.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword1.setFocusPainted(false);
	        keyword1.setBorderPainted(false);
	        keyword1.setBackground(Color.WHITE);
	        keyword1.setBounds(129, 10, 105, 37);
	        add(keyword1);
	        
	        JButton keyword2 = new JButton("");
	        keyword2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					if(keyword2.getText().equals("NULL")) {
						InsertFaq in = new InsertFaq(borderpanel,homeButton,closeButton);
					}
					else {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword2.getText());
					        JSONObject response = po.jsonpost("/FindFaq", data);
					        
							FaqInfoArray = response.getJSONArray("Faq_Info");
						       for (int i = 0; i < FaqInfoArray.length(); i++) {
						            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
						            String key = faqinfo.getString("keyword");
						            String question= faqinfo.getString("question");
						            String answer = faqinfo.getString("answer"); 
						            number++;
						            String num_1 = Integer.toString(number);
						            String[] row = { num_1,question,answer};
						            model.addRow(row);
						        }
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	        	}
	        });
	        keyword2.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) { 
			        	if(!keyword2.getText().equals("NULL"))
			        	{
			        		UpdateKeyword up = new UpdateKeyword(keyword2.getText(),homeButton,closeButton,borderpanel);	
			        	}
			        }
			    }
			});
	        keyword2.setForeground(new Color(114, 166, 255));
	        keyword2.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword2.setFocusPainted(false);
	        keyword2.setBorderPainted(false);
	        keyword2.setBackground(Color.WHITE);
	        keyword2.setBounds(246, 10, 105, 37);
	        add(keyword2);
	        
	        JButton keyword3 = new JButton("");
	        keyword3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					if(keyword3.getText().equals("NULL")) {
						InsertFaq in = new InsertFaq(borderpanel,homeButton,closeButton);
					}
					else {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword3.getText());
					        JSONObject response = po.jsonpost("/FindFaq", data);
					        
							FaqInfoArray = response.getJSONArray("Faq_Info");
						       for (int i = 0; i < FaqInfoArray.length(); i++) {
						            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
						            String key = faqinfo.getString("keyword");
						            String question= faqinfo.getString("question");
						            String answer = faqinfo.getString("answer"); 
						            number++;
						            String num_1 = Integer.toString(number);
						            String[] row = { num_1,question,answer};
						            model.addRow(row);
						        }
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	        	}
	        });
	        keyword3.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) { 
			        	if(!keyword3.getText().equals("NULL"))
			        	{
			        		UpdateKeyword up = new UpdateKeyword(keyword3.getText(),homeButton,closeButton,borderpanel);	
			        	}
			        }
			    }
			});
	        keyword3.setForeground(new Color(114, 166, 255));
	        keyword3.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword3.setFocusPainted(false);
	        keyword3.setBorderPainted(false);
	        keyword3.setBackground(Color.WHITE);
	        keyword3.setBounds(363, 10, 105, 37);
	        add(keyword3);
	        
	        JButton keyword4 = new JButton("");
	        keyword4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					if(keyword4.getText().equals("NULL")) {
						InsertFaq in = new InsertFaq(borderpanel,homeButton,closeButton);
					}
					else {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword4.getText());
					        JSONObject response = po.jsonpost("/FindFaq", data);
					        
							FaqInfoArray = response.getJSONArray("Faq_Info");
						       for (int i = 0; i < FaqInfoArray.length(); i++) {
						            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
						            String key = faqinfo.getString("keyword");
						            String question= faqinfo.getString("question");
						            String answer = faqinfo.getString("answer"); 
						            number++;
						            String num_1 = Integer.toString(number);
						            String[] row = { num_1,question,answer};
						            model.addRow(row);
						        }
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	        	}
	        });
	        keyword4.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) { 
			        	if(!keyword4.getText().equals("NULL"))
			        	{
			        		UpdateKeyword up = new UpdateKeyword(keyword4.getText(),homeButton,closeButton,borderpanel);	
			        	}
			        }
			    }
			});
	        keyword4.setForeground(new Color(114, 166, 255));
	        keyword4.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword4.setFocusPainted(false);
	        keyword4.setBorderPainted(false);
	        keyword4.setBackground(Color.WHITE);
	        keyword4.setBounds(480, 10, 105, 37);
	        add(keyword4);
	        
	        RoundedButton2 btnNewButton = new RoundedButton2("FAQ 등록");
	        btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
	        btnNewButton.setBounds(700, 17, 95, 30);
	        add(btnNewButton);
	        
	        JSONObject data = new JSONObject();
	        try {
	            data.put("keyword", "");
	            Post po = new Post();

	            JSONObject check = po.jsonpost("/Findkeyword", data);

	            if (check.has("check") && check.getString("check").equals("true")) {
	                JSONArray keywordArray = check.getJSONArray("keyword");

	                // Assuming you have TextView objects named keyword, keyword1, keyword2, ...
	                for (int i = 0; i < 5; i++) {
	                    JSONObject keywordObject = keywordArray.getJSONObject(i);
	                    String keywordText = keywordObject.getString("keyword");

	                    // Assuming you have labels named keyword, keyword1, keyword2, ...
	                    if (i == 0) {
	                        keyword.setText(keywordText);
	                    } else if (i == 1) {
	                        keyword1.setText(keywordText);
	                    } else if (i == 2) {
	                        keyword2.setText(keywordText);
	                    } else if (i == 3) {
	                        keyword3.setText(keywordText);
	                    } else if (i == 4) {
	                        keyword4.setText(keywordText);
	                    }
	                }
	            } else {
	                // Handle the case when "check" is not "true"
	            }
	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }
	        
	        Post po = new Post();
	        // 데이터를 서버에 전송하고 응답을 받아옵니다.
	        int number = 0;
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        JSONArray FaqInfoArray;
			try {
				data.put("keyword", keyword.getText());
		        JSONObject response = po.jsonpost("/FindFaq", data);
		        
				FaqInfoArray = response.getJSONArray("Faq_Info");
			       for (int i = 0; i < FaqInfoArray.length(); i++) {
			            JSONObject faqinfo = FaqInfoArray.getJSONObject(i);
			            String key = faqinfo.getString("keyword");
			            String question= faqinfo.getString("question");
			            String answer = faqinfo.getString("answer"); 
			            number++;
			            String num_1 = Integer.toString(number);
			            String[] row = { num_1,question,answer};
			            model.addRow(row);
			        }
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
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
            if ("구 분".equals(value) || "제 목".equals(value)|| "답 변".equals(value)) {
                renderer.setBackground(new Color(217, 231, 255));
                renderer.setForeground(new Color(114, 166, 255));
                renderer.setFont(new Font("굴림", Font.BOLD, 18));
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
