package com.pws.study;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Memberpanel extends JPanel {
    private JTable table;

    public Memberpanel() {
        Border border =  BorderFactory.createLineBorder(new Color(114,166,250), 2);
        setBackground(new Color(255, 255, 255));
        setBounds(23, 40, 816, 580);
        setBorder(border);
        setLayout(null);

    }
}
