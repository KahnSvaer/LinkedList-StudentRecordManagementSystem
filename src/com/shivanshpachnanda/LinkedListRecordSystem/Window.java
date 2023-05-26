package com.shivanshpachnanda.LinkedListRecordSystem;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
class Window extends JFrame{
	Window(JComponent[] panes)
	{	
		ImageIcon image = new ImageIcon("CICDU_logo.png"); 
		this.setTitle("Student Record Management");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setIconImage(image.getImage());
		this.setSize(1200,800);
		this.setVisible(true);
		this.setResizable(false);
		for (JComponent pane : panes)
			this.add(pane);
	}
}
