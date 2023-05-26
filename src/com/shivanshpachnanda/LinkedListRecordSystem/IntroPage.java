package com.shivanshpachnanda.LinkedListRecordSystem;
import javax.swing.*;

class IntroPage extends JLayeredPane{
	ImageIcon image;
	JLabel bGround;
	Login loginBox;
	
	
	IntroPage()	{
		bGround = new JLabel();
		loginBox = new Login();
		this.setBounds(0, 0, 1200, 800);
		this.setLayout(null);
		
		//bGround container
		ImageIcon bGimage = new ImageIcon("BGCIC.jpg");
		bGround.setIcon(bGimage);
		bGround.setBounds(0,0,1200,800);
		
		//loginBox have a lot of components so just created another class
		
		this.add(loginBox);
		this.add(bGround);
	}
}
