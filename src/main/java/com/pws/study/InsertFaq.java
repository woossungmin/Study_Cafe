package com.pws.study;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class InsertFaq {

    private JFrame frame;
    private JTextField question;
    private JComboBox<String> keywordComboBox; // JComboBox 선언

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertFaq window = new InsertFaq(new JPanel(), new JButton(), new JButton());
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InsertFaq(JPanel borderpanel, JButton homebutton, JButton closebutton) {
        initialize(borderpanel, homebutton, closebutton);
    }

    private void initialize(JPanel borderpanel, JButton homebutton, JButton closebutton) {
        Border border = BorderFactory.createLineBorder(new Color(114, 166, 250), 2);
        frame = new JFrame();
        frame.setBounds(450, 150, 450, 368);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 436, 331);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
        panel.setBackground(new Color(255, 255, 255));

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(12, 10, 412, 311);
        panel.add(panel_1);
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(border);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(217, 231, 255));

        JLabel lblNewLabel = new JLabel("키워드명 : ");
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel.setBounds(12, 49, 85, 30);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(114, 166, 255));

        JButton BackButton = new JButton("");
        BackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        BackButton.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Study Cafe이미지 파일\\cross.png"));
        BackButton.setBounds(380, 7, 25, 25);
        panel_1.add(BackButton);
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setFocusPainted(false);

        JLabel lblNewLabel_1 = new JLabel("질      문 : ");
        lblNewLabel_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_1.setBounds(12, 89, 85, 30);
        panel_1.add(lblNewLabel_1);

        question = new JTextField();
        question.setColumns(10);
        question.setBounds(109, 91, 291, 30);
        panel_1.add(question);
        question.setBorder(border);
        question.setBackground(new Color(240, 240, 240));

        JLabel lblNewLabel_1_1 = new JLabel("답      변 : ");
        lblNewLabel_1_1.setForeground(new Color(114, 166, 255));
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(12, 129, 85, 30);
        panel_1.add(lblNewLabel_1_1);

        JTextArea answer = new JTextArea();
        answer.setBounds(109, 131, 291, 137);
        panel_1.add(answer);
        answer.setBorder(border);
        answer.setBackground(new Color(240, 240, 240));

     // 추가: JComboBox 초기화
        keywordComboBox = new JComboBox<String>();
        keywordComboBox.setBounds(109, 50, 291, 30);
        panel_1.add(keywordComboBox);
        keywordComboBox.setBorder(border);
        keywordComboBox.setBackground(new Color(240,240,240));
        // 키워드를 JComboBox에 추가
        loadKeywords();
        
        RoundedButton2 btnNewButton = new RoundedButton2("등록");
        btnNewButton.setText("등록");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 JSONObject data = new JSONObject();
                 try {
                     data.put("keyword", keywordComboBox.getSelectedItem());
                     data.put("question", question.getText());
                     data.put("answer", answer.getText());
                     Post po = new Post();

                     JSONObject check = po.jsonpost("/InsertFaq", data);
                     if((check.get("check")).equals("true"))
						{
			   				frame.dispose();
				      		FaqPanel fa = new FaqPanel(borderpanel,homebutton,closebutton);
				            switchPanel(fa,borderpanel,homebutton,closebutton);
			   				Message ms = new Message("  등록이 완료되었습니다!");
			   				ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
				        }
			   		else {
			   			frame.dispose();
			   			Message ms = new Message("  등록을 실패하였습니다!");
			 			ms.frame.setBounds(550, 250, ms.frame.getWidth(), ms.frame.getHeight());
			   		}
                 } catch (JSONException e1) {
                     e1.printStackTrace();
                 }
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
        btnNewButton.setBounds(160, 278, 95, 23);
        panel_1.add(btnNewButton);

    }

    // 키워드를 가져와서 JComboBox에 추가하는 메서드
    private void loadKeywords() {
        JSONObject data = new JSONObject();
        try {
            data.put("keyword", "");
            Post po = new Post();

            JSONObject check = po.jsonpost("/Findkeyword", data);

            if (check.has("check") && check.getString("check").equals("true")) {
                JSONArray keywordArray = check.getJSONArray("keyword");

                // keywordComboBox에 키워드를 추가
                for (int i = 0; i < keywordArray.length(); i++) {
                    JSONObject keywordObject = keywordArray.getJSONObject(i);
                    String keywordText = keywordObject.getString("keyword");
                    if (keywordText != null && !keywordText.isEmpty() && !keywordText.equals("NULL")) {
                        keywordComboBox.addItem(keywordText);
                    }
                }
            } else {
                // Handle the case when "check" is not "true"
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }

    private void switchPanel(JPanel newPanel, JPanel borderpanel, JButton homebutton, JButton closebutton) {
        borderpanel.removeAll();
        borderpanel.add(homebutton);
        borderpanel.add(closebutton);
        borderpanel.add(newPanel);
        borderpanel.revalidate();
        borderpanel.repaint();
    }
}
