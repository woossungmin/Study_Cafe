package com.pws.study;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.pws.study.FaqPanel.CustomHeaderRenderer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FAQ {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ window = new FAQ();
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
	public FAQ() {
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
	      Border border1 =  BorderFactory.createLineBorder(new Color(255,0,0),2);
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
	   	
	   	                    Click.question = (String) table.getModel().getValueAt(row, 1);
	   	                   
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
	   	        scrollPane.setBounds(12, 166, 813, 417);
	   	        borderpanel.add(scrollPane);
	   	        
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
		      JButton BackButton = new JButton("");
				BackButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Login lo = new Login();
					}
				});
				BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\back.png"));
				BackButton.setBounds(0, 0, 45, 40);
				borderpanel.add(BackButton);
				BackButton.setBorderPainted(false); 
				BackButton.setContentAreaFilled(false);
				BackButton.setFocusPainted(false);
				
				  JButton qeustion = new JButton("");
			      qeustion.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\kakao-talk.png"));
				qeustion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QR qr = new QR();
					}
				});
				qeustion.setBounds(775, 10, 50, 50);
				qeustion.setBorderPainted(false);
				qeustion.setContentAreaFilled(false);
				qeustion.setFocusPainted(false);
				borderpanel.add(qeustion);
				
				JPanel panel = new JPanel();
				panel.setBounds(536, 60, 289, 61);
				borderpanel.add(panel);
				panel.setBackground(new Color(255,255,255));
			    panel.setBorder(border1);
				panel.setVisible(false);
				panel.setLayout(null);
				
			      borderpanel.addMouseListener(new MouseAdapter() {
				      	@Override
				      	public void mouseClicked(MouseEvent e) {
				      		panel.setVisible(false);
				      	}
				      });
				JLabel text = new JLabel("");
				text.setBounds(16, 7, 261, 15);
				panel.add(text);
				
				JLabel text_1 = new JLabel("");
				text_1.setBounds(16, 24, 214, 15);
				panel.add(text_1);
				
				text.setText("QR 코드를 통해 카카오톡 문의도 가능합니다.");
				text.setForeground(new Color(255, 0, 0));
				text_1.setText("사용 문의 전 FAQ를 확인해주세요!");
				text_1.setForeground(new Color(255, 0, 0));
				
				JLabel text_1_1 = new JLabel("문의하기 사용 시 더블클릭!");
				text_1_1.setForeground(new Color(255, 0, 0));
				text_1_1.setBounds(16, 40, 214, 15);
				panel.add(text_1_1);
				
				JButton keyword5 = new JButton("");
				keyword5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setNumRows(0);
				        Post po = new Post();
				        JSONObject data = new JSONObject();
				        // 데이터를 서버에 전송하고 응답을 받아옵니다.
				        int number = 0;
				        JSONArray FaqInfoArray;
						try {
							data.put("keyword", keyword5.getText());
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
				});
				keyword5.setForeground(new Color(114, 166, 255));
				keyword5.setFont(new Font("굴림", Font.BOLD, 17));
				keyword5.setFocusPainted(false);
				keyword5.setBorderPainted(false);
				keyword5.setBackground(Color.WHITE);
				keyword5.setBounds(610, 115, 105, 37);
				borderpanel.add(keyword5);
				
			    RoundedButton2 inquiry = new RoundedButton2("문의하기"); 
				inquiry.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						panel.setVisible(true);
						if(e.getClickCount()>1)
						{
							frame.dispose();
							Inquiry in = new Inquiry();
						}
					}
				});
				inquiry.setFont(new Font("굴림", Font.BOLD, 15));
				inquiry.setBounds(730, 126, 95, 30);
				borderpanel.add(inquiry);				
		  JButton keyword = new JButton("");
			keyword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
			});	
			keyword.setFont(new Font("굴림", Font.BOLD, 17));
			keyword.setBounds(10, 115, 105, 37);
			borderpanel.add(keyword);
		    keyword.setForeground(new Color(114, 166, 255));
			keyword.setBorderPainted(false);
			keyword.setBackground(new Color(255,255,255));
			keyword.setFocusPainted(false);
			borderpanel.add(keyword);
			
	        JButton keyword1 = new JButton("");
	        keyword1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
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
	        });
	        keyword1.setForeground(new Color(114, 166, 255));
	        keyword1.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword1.setFocusPainted(false);
	        keyword1.setBorderPainted(false);
	        keyword1.setBackground(Color.WHITE);
	        keyword1.setBounds(130, 115, 105, 37);
	        borderpanel.add(keyword1);
	        
	        JButton keyword2 = new JButton("");
	        keyword2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
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
	        });
	        keyword2.setForeground(new Color(114, 166, 255));
	        keyword2.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword2.setFocusPainted(false);
	        keyword2.setBorderPainted(false);
	        keyword2.setBackground(Color.WHITE);
	        keyword2.setBounds(250, 115, 105, 37);
	        borderpanel.add(keyword2);
	        
	        JButton keyword3 = new JButton("");
	        keyword3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
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
	        });
	        keyword3.setForeground(new Color(114, 166, 255));
	        keyword3.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword3.setFocusPainted(false);
	        keyword3.setBorderPainted(false);
	        keyword3.setBackground(Color.WHITE);
	        keyword3.setBounds(370, 115, 105, 37);
	        borderpanel.add(keyword3);
	        
	        JButton keyword4 = new JButton("");
	        keyword4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
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
	        });
	        keyword4.setForeground(new Color(114, 166, 255));
	        keyword4.setFont(new Font("굴림", Font.BOLD, 17));
	        keyword4.setFocusPainted(false);
	        keyword4.setBorderPainted(false);
	        keyword4.setBackground(Color.WHITE);
	        keyword4.setBounds(490, 115, 105, 37);
	        borderpanel.add(keyword4);	
	        JSONObject data = new JSONObject();
	        try {
	            data.put("keyword", "");
	            Post po = new Post();

	            JSONObject check = po.jsonpost("/Findkeyword", data);

	            if (check.has("check") && check.getString("check").equals("true")) {
	                JSONArray keywordArray = check.getJSONArray("keyword");

	                // Assuming you have TextView objects named keyword, keyword1, keyword2, ...
	                for (int i = 0; i < 6; i++) {
	                    JSONObject keywordObject = keywordArray.getJSONObject(i);
	                    String keywordText = keywordObject.getString("keyword");

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
			
			data = new JSONObject();
			try {
			    data.put("keyword", "");
			    po = new Post();

			    JSONObject check = po.jsonpost("/Findkeyword", data);

			    if (check.has("check") && check.getString("check").equals("true")) {
			        JSONArray keywordArray = check.getJSONArray("keyword");

			        // Assuming you have JButton objects named keyword, keyword1, keyword2, ...
			        JButton[] keywordButtons = { keyword, keyword1, keyword2, keyword3, keyword4, keyword5 };

			        for (int i = 0; i < keywordArray.length(); i++) {
			            JSONObject keywordObject = keywordArray.getJSONObject(i);
			            String keywordText = keywordObject.getString("keyword");

			            // Check if the keyword is "NULL" and disable the button accordingly
			            if ("NULL".equals(keywordText)) {
			                keywordButtons[i].setEnabled(false);
			            } else {
			                keywordButtons[i].setEnabled(true);
			            }

			            // Set the button's text to "X" if the keyword is "NULL"
			            keywordButtons[i].setText("NULL".equals(keywordText) ? "X" : keywordText);
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
	            if ("구 분".equals(value) || "제 목".equals(value)|| "답 변".equals(value)) {
	                renderer.setBackground(new Color(217, 231, 255));
	                renderer.setForeground(new Color(114, 166, 255));
	                renderer.setFont(new Font("굴림", Font.BOLD, 18));
	                renderer.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, new Color(114, 166, 255))); // 내부 선 색상 설정
	            }
	            return renderer;
	        }
	    }
}
