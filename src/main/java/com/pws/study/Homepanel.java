package com.pws.study;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Homepanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Homepanel() {
		Border border =  BorderFactory.createLineBorder(new Color(114,166,250),2);
		setBackground(new Color(255,255,255));
		setLayout(null);
		setBounds(23, 120, 816, 494);
		setBorder(border);
	}

}
