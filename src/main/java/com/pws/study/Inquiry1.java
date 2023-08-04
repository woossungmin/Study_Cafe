package com.pws.study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
				
				 JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(12, 133, 813, 400);
					borderpanel.add(scrollPane);
					scrollPane.getViewport().setBackground(new Color(255,255,255));
					
					JTable table = new JTable();
					table.setShowGrid(false);
					table.setSurrendersFocusOnKeystroke(true);
					table.setRowSelectionAllowed(false);
					table.setForeground(SystemColor.activeCaption);
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"제목", "답변일", "처리 상태"
						}
					));
					scrollPane.setViewportView(table);
					table.getColumn("제목").setPreferredWidth(500);
					table.getColumn("답변일").setPreferredWidth(10);
					table.getColumn("처리 상태").setPreferredWidth(10);
					table.setGridColor(new Color(114,166,250)); //안쪽 테두리색 변경
					table.getTableHeader().setBackground(new Color(255,255,255)); //헤더 배경색 변경
					table.getTableHeader().setForeground(new Color(114, 166, 255));// 헤더 글자색 변경
					table.getTableHeader().setReorderingAllowed(false); //헤더 이동 불가
					scrollPane.setBorder(border);
					
					RoundedButton2 rr = new RoundedButton2("문의하기");
					rr.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
							Inquiry in = new Inquiry();
						}
					});
					rr.setFont(new Font("굴림", Font.BOLD, 15));
					rr.setBounds(379, 543, 95, 37); 
					borderpanel.add(rr);
					table.getTableHeader().setFont(new Font(" ", Font.BOLD, 15)); //헤더 글씨체 변경
					table.getTableHeader().setPreferredSize(new Dimension(0,30));
					
						
					DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //테이블 밑에 사용 튜플값들 가운데 정렬
				    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
				    TableColumnModel tcm = table.getColumnModel();
				    for(int i = 0; i < tcm.getColumnCount(); i++) {
				    	tcm.getColumn(i).setCellRenderer(dtcr);
				    }
	}

}
