package com.shivanshpachnanda.LinkedListRecordSystem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
class RecordsPage extends JLayeredPane{
	ImageIcon image;
	JLabel bGround;
	ButtonsPanel bp;
	RecordsPanel pane;
	RecordsPage(Node Head)	{
		bp = new ButtonsPanel(Head);
		bGround = new JLabel();
		pane = new RecordsPanel(Head);
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);
		
		//bGround container
		ImageIcon bGimage = new ImageIcon("BGCIC.jpg");
		bGround.setIcon(bGimage);
		bGround.setBounds(0,0,1200,800);
		
		
		
		this.add(bp);
		this.add(pane);
		this.add(bGround);
	}
}
