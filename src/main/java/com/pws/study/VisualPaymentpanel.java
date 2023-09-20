package com.pws.study;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VisualPaymentpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public VisualPaymentpanel() {
        Border border = BorderFactory.createLineBorder(new Color(114, 166, 250), 2);
        setBackground(new Color(255, 255, 255));
        setLayout(null);
        setBounds(23, 45, 813, 570);
	}
}
