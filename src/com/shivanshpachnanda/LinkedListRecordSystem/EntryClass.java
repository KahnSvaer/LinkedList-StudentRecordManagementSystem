package com.shivanshpachnanda.LinkedListRecordSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class EntryClass extends JFrame implements ActionListener,FocusListener{
	private JTextField userText;
	private JTextField rollNo;
	private JTextField Course;
	private JTextField Percentage;
	public JButton submit;
	Node Head;
	int option;
	App2 newAgain;
	public static int count=1;

	EntryClass(int n,Node Head){
		ImageIcon image = new ImageIcon("CICDU_logo.png");
		this.setIconImage(image.getImage());
		this.setTitle("Student Record Management");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
		this.Head = Head;
		this.option = n;
		if(n!=3) {
			this.setSize(430,450);
		}else
		{
			this.setSize(430,250);
		}
			
			
			JLabel Title = new JLabel("Fill the Entries");
			Title.setBounds(10,10,360,60);
			Title.setHorizontalAlignment(JLabel.CENTER);
			Title.setFont(new Font("Times New Roman",Font.PLAIN,28));
			
			JLabel Roll = new JLabel("Roll");
			Roll.setBounds(10,50,360,45);
			Roll.setHorizontalAlignment(JLabel.LEFT);
			Roll.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			rollNo = new JTextField();
			rollNo.setText("Roll");
			rollNo.addFocusListener(this);
			rollNo.setBounds(30,90,360,25);
			rollNo.setFont(new Font("Times New Roman",Font.PLAIN,16));
			rollNo.setForeground(Color.GRAY);	
			
		if(n!=3) {	
			JLabel userName = new JLabel("Name");
			userName.setBounds(10,125,360,45);
			userName.setHorizontalAlignment(JLabel.LEFT);
			userName.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			userText = new JTextField();
			userText.setText("Name");
			userText.addFocusListener(this);
			userText.setBounds(30,165,360,25);
			userText.setFont(new Font("Times New Roman",Font.PLAIN,16));
			userText.setForeground(Color.GRAY);
	
			
			JLabel cour = new JLabel("Course");
			cour.setBounds(10,200,360,45);
			cour.setHorizontalAlignment(JLabel.LEFT);
			cour.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			Course = new JTextField();
			Course.setText("Course");
			Course.addFocusListener(this);
			Course.setBounds(30,240,360,25);
			Course.setFont(new Font("Times New Roman",Font.PLAIN,16));
			Course.setForeground(Color.GRAY);
			
			
			JLabel per = new JLabel("Percentage");
			per.setBounds(10,275,360,45);
			per.setHorizontalAlignment(JLabel.LEFT);
			per.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			Percentage = new JTextField();
			Percentage.setText("Percentage");
			Percentage.addFocusListener(this);
			Percentage.setBounds(30,315,360,25);
			Percentage.setFont(new Font("Times New Roman",Font.PLAIN,16));
			Percentage.setForeground(Color.GRAY);
			
			
			this.add(userName);
			this.add(userText);
			this.add(cour);
			this.add(Course);
			this.add(per);
			this.add(Percentage);
		}
			
			
			submit = new JButton("SUBMIT");//ActionPerformed
			submit.addActionListener(this);
			submit.setFocusable(false);
		if(n!=3)
			submit.setBounds(150,355,100,30);
		else
			submit.setBounds(150,130,100,30);
			
			this.add(Title);
			this.add(Roll);
			this.add(rollNo);
			this.add(submit);	
	 	}

	@Override
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==submit)
		 {	
			 DoAction(option);
			 Node temp = Head;
			 String recordLinkedList="\n  Roll\tName\tCourse\t%\n\n";
			 Login.again.rp.pane.records.setText(recordLinkedList);
			 System.out.println("Checking");
			 while(temp!=null)
			 {
				Login.again.rp.pane.records.append("  "+temp.rollNo+"\t"+temp.name+"\t"+temp.course+"\t"+temp.percentage+"\n");
				temp=temp.nextNode; 
			 }
			 
			 this.dispose();
			 
		 }
	 }
	 
	 @Override
	 public void focusGained(FocusEvent e)
	 {
		 if(e.getSource()==userText&&
				 userText.getForeground()==Color.GRAY)
		 {
			 userText.setText("");
			 userText.setForeground(Color.BLACK);
		 }
		 if(e.getSource()==rollNo&&
				 rollNo.getForeground()==Color.GRAY)
		 {
			 rollNo.setText("");
			 rollNo.setForeground(Color.BLACK);
		 } 
		 if(e.getSource()==Course&&
				 Course.getForeground()==Color.GRAY)
		 {
			 Course.setText("");
			 Course.setForeground(Color.BLACK);
		 } 
		 if(e.getSource()==Percentage&&
				 Percentage.getForeground()==Color.GRAY)
		 {
			 Percentage.setText("");
			 Percentage.setForeground(Color.BLACK);
		 } 
	 }
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==userText&&userText.getText().length()==0)
		 {
			 userText.setForeground(Color.GRAY);
			 userText.setText("Name");
		 }
		if(e.getSource()==rollNo&&rollNo.getText().length()==0)
		 {
			 rollNo.setForeground(Color.GRAY);
			 rollNo.setText("rollNo");
		 }
		if(e.getSource()==Course&&Course.getText().length()==0)
		 {
			 Course.setForeground(Color.GRAY);
			 Course.setText("Course");
		 }
		if(e.getSource()==Percentage&&Percentage.getText().length()==0)
		 {
			Percentage.setForeground(Color.GRAY);
			Percentage.setText("Percentage");
		 }
	}
	public Node DoAction(int t)
	{
		if(t==3)
		{
			Head = LinkedListMethods.DeleteNode(Head, Integer.parseInt(rollNo.getText()));
		}
		else if(t==1)
		{
			Head = LinkedListMethods.InsertNode(Head, Integer.parseInt(rollNo.getText()), userText.getText(), Course.getText(), Float.parseFloat(Percentage.getText()));
		}
		else
		{
			Head = LinkedListMethods.ModifyNode(Head, Integer.parseInt(rollNo.getText()), userText.getText(), Course.getText(), Float.parseFloat(Percentage.getText()));
		}
		return Head;
	}
}
