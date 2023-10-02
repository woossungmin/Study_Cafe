package com.pws.study;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
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
	      
	      JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 198, 813, 385);
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
					"\uAD6C\uBD84", "\uC81C\uBAA9"
				}
			));
			scrollPane.setViewportView(table);
			table.getColumn("구분").setPreferredWidth(10);
			table.getColumn("제목").setPreferredWidth(500);
			table.setGridColor(new Color(114,166,250)); //안쪽 테두리색 변경
			table.getTableHeader().setBackground(new Color(255,255,255)); //헤더 배경색 변경
			table.getTableHeader().setForeground(new Color(114, 166, 255));// 헤더 글자색 변경
			table.getTableHeader().setReorderingAllowed(false); //헤더 이동 불가
			scrollPane.setBorder(border);
			table.getTableHeader().setFont(new Font(" ", Font.BOLD, 15)); //헤더 글씨체 변경
			table.getTableHeader().setPreferredSize(new Dimension(0,30));
			
				
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //테이블 밑에 사용 튜플값들 가운데 정렬
		    dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		    TableColumnModel tcm = table.getColumnModel();
		    for(int i = 0; i < tcm.getColumnCount(); i++) {
		    	tcm.getColumn(i).setCellRenderer(dtcr);
		    }
		    
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
			      qeustion.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\barcode-scan.png"));
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
				
				JButton keyword1 = new JButton("keyword1");
				keyword1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				keyword1.setFont(new Font("굴림", Font.BOLD, 15));
				keyword1.setBounds(5, 151, 125, 37);
				borderpanel.add(keyword1);
			    keyword1.setForeground(new Color(114, 166, 255));
				keyword1.setBorderPainted(false);
				keyword1.setBackground(new Color(255,255,255));
				keyword1.setFocusPainted(false);
				
				JButton btnKeyword = new JButton("keyword2");
				btnKeyword.setForeground(new Color(114, 166, 255));
				btnKeyword.setFont(new Font("굴림", Font.BOLD, 15));
				btnKeyword.setFocusPainted(false);
				btnKeyword.setBorderPainted(false);
				btnKeyword.setBackground(Color.WHITE);
				btnKeyword.setBounds(142, 151, 126, 37);
				borderpanel.add(btnKeyword);
				
				JButton btnKeyword_1 = new JButton("keyword3");
				btnKeyword_1.setForeground(new Color(114, 166, 255));
				btnKeyword_1.setFont(new Font("굴림", Font.BOLD, 15));
				btnKeyword_1.setFocusPainted(false);
				btnKeyword_1.setBorderPainted(false);
				btnKeyword_1.setBackground(Color.WHITE);
				btnKeyword_1.setBounds(280, 151, 117, 37);
				borderpanel.add(btnKeyword_1);
				
				JButton btnKeyword_2 = new JButton("keyword4");
				btnKeyword_2.setForeground(new Color(114, 166, 255));
				btnKeyword_2.setFont(new Font("굴림", Font.BOLD, 15));
				btnKeyword_2.setFocusPainted(false);
				btnKeyword_2.setBorderPainted(false);
				btnKeyword_2.setBackground(Color.WHITE);
				btnKeyword_2.setBounds(414, 151, 125, 37);
				borderpanel.add(btnKeyword_2);
				
				JPanel panel = new JPanel();
				panel.setBounds(536, 89, 289, 61);
				borderpanel.add(panel);
				panel.setBackground(new Color(255,255,255));
			    panel.setBorder(border1);
				panel.setVisible(false);
				panel.setLayout(null);
				
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
				
			    RoundedButton2 inquiry = new RoundedButton2("문의하기"); 
				inquiry.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						panel.setVisible(true);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panel.setVisible(false);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()>1)
						{
							frame.dispose();
							Inquiry in = new Inquiry();
						}
					}
				});
				inquiry.setFont(new Font("굴림", Font.BOLD, 15));
				inquiry.setBounds(730, 158, 95, 30);
				borderpanel.add(inquiry);				
				
				
	}	
}
