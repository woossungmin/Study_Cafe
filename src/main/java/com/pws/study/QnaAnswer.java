package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QnaAnswer {

	private JFrame frame;
	private JTextField question;
	private JTextField time;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnaAnswer window = new QnaAnswer(new JButton(), new JButton(), new JPanel());
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
	public QnaAnswer(JButton homeButton, JButton closeButton, JPanel borderPanel) {
		initialize(homeButton, closeButton, borderPanel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton homeButton, JButton closeButton, JPanel borderPanel) {
		frame = new JFrame();
		frame.setBounds(420, 120, 449, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setResizable(false);
	    frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 438);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255,255,255));
		
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		
		JPanel borderpanel = new JPanel();
		borderpanel.setBounds(12, 10, 411, 418);
		panel.add(borderpanel);
		borderpanel.setBorder(border);
		borderpanel.setLayout(null);
		borderpanel.setBackground(new Color(217, 231, 255));
		
        JLabel lblNewLabel_1 = new JLabel("타        입   : ");
        lblNewLabel_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
        lblNewLabel_1.setBounds(23, 45, 102, 30);
        borderpanel.add(lblNewLabel_1);
        
        JTextField type = new JTextField();
        type.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
        type.setColumns(10);
        type.setBounds(137, 47, 246, 30);
        borderpanel.add(type);
        type.setBorder(border);
        type.setBackground(new Color(240, 240, 240));
        type.setEditable(false);
        
        JLabel lblNewLabel_1_1 = new JLabel("질        문   : ");
        lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_1_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(23, 95, 102, 30);
        borderpanel.add(lblNewLabel_1_1);
        
        question = new JTextField();
        question.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
        question.setColumns(10);
        question.setBackground(SystemColor.menu);
        question.setBounds(137, 97, 246, 30);
        borderpanel.add(question);
        question.setBorder(border);
        question.setEditable(false);

        JLabel lblNewLabel_1_2 = new JLabel("질 문 시 간  : ");
        lblNewLabel_1_2.setForeground(new Color(114, 166, 255));
        lblNewLabel_1_2.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(23, 145, 102, 30);
        borderpanel.add(lblNewLabel_1_2);
        
        time = new JTextField();
        time.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
        time.setColumns(10);
        time.setBackground(SystemColor.menu);
        time.setBounds(137, 147, 246, 30);
        borderpanel.add(time);
        time.setBorder(border);
        time.setEditable(false);
        
        JLabel lblNewLabel_1_3 = new JLabel("답         변   : ");
        lblNewLabel_1_3.setForeground(new Color(114, 166, 255));
        lblNewLabel_1_3.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(23, 245, 102, 30);
        borderpanel.add(lblNewLabel_1_3);
        
        JTextArea textArea = new JTextArea();
        textArea.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(textArea.getText().equals("NULL")) {
        			textArea.setText("");
        		}
        		
        	}
        });
        textArea.setFont(new Font("한컴산뜻돋움", Font.BOLD, 13));
        textArea.setBounds(137, 247, 246, 123);
        borderpanel.add(textArea);
        textArea.setBorder(border);
        textArea.setBackground(SystemColor.menu);
        textArea.setLineWrap(true); // 자동 줄 바꿈 활성화
		
        RoundedButton2 btnNewButton = new RoundedButton2("등록");
        btnNewButton.setText("확인");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Post po = new Post();
                JSONObject data = new JSONObject();
                try {
                    data.put("phone", phone.getText());
                    data.put("q_record", question.getText());
                    data.put("answer", textArea.getText().replace("\n", " "));

                    // 현재 시간을 원하는 형식으로 포맷
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    String formattedDateTime = now.format(formatter);

                    data.put("checks", formattedDateTime); // 형식화된 시간을 JSON에 추가

                    JSONObject response = po.jsonpost("/UpdateAnswer", data);
                    if (response.getString("check").equals("true")) {
                        frame.dispose();
                        QnaPanel fa = new QnaPanel(borderPanel, homeButton, closeButton);
                        switchPanel(fa, borderPanel, homeButton, closeButton);
                        Message ms = new Message("답변을 등록하였습니다!");
                    } else {
                        Message ms = new Message("답변 등록에 실패했습니다.");
                    }
                } catch (JSONException e1) {
                    e1.printStackTrace(); // 예외 스택 트레이스 출력
                }
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
        btnNewButton.setBounds(151, 385, 95, 23);
        borderpanel.add(btnNewButton);

        JButton closebutton = new JButton("");
	      closebutton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      	}
	      });
	      closebutton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
	      closebutton.setForeground(new Color(114, 166, 255));
	      closebutton.setFont(new Font("굴림", Font.BOLD, 20));
	      closebutton.setFocusPainted(false);
	      closebutton.setContentAreaFilled(false);
	      closebutton.setBorderPainted(false);
	      closebutton.setBounds(367, 10, 32, 32);
	      borderpanel.add(closebutton);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("전 화 번 호  : ");
        lblNewLabel_1_2_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_1_2_1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 15));
        lblNewLabel_1_2_1.setBounds(23, 195, 102, 30);
        borderpanel.add(lblNewLabel_1_2_1);
        
        phone = new JTextField();
        phone.setFont(new Font("한컴산뜻돋움", Font.BOLD, 12));
        phone.setColumns(10);
        phone.setBackground(SystemColor.menu);
        phone.setBounds(137, 197, 246, 30);
        phone.setBorder(border);
        borderpanel.add(phone);
        phone.setEditable(false);
        
        Post po = new Post();
        JSONObject data = new JSONObject();
        // 데이터를 서버에 전송하고 응답을 받아옵니다.
        int number = 0;
        JSONArray managerInfoArray;
		try {
			data.put("phone",Click.phone );
			data.put("q_record", Click.question);
	        JSONObject response = po.jsonpost("/FindQNA2", data);
			managerInfoArray = response.getJSONArray("manager_info");
			for (int i = 0; i < managerInfoArray.length(); i++) {
			    JSONObject managerInfo = managerInfoArray.getJSONObject(i);
			    String q_type = managerInfo.getString("q_type");
			    String q_record = managerInfo.getString("q_record");
			    String ph = managerInfo.getString("phone");
			    String time = managerInfo.getString("q_time");
			    String answer = managerInfo.getString("answer");
			    question.setText(q_record);
			    this.time.setText(time);
			    phone.setText(ph);
			    type.setText(q_type);
			    textArea.setText(answer);
			}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
