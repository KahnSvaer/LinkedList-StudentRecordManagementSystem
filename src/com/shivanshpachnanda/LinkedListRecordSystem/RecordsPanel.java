package com.shivanshpachnanda.LinkedListRecordSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
class RecordsPanel extends JPanel{
	JTextArea records;
	Node Head;
	Node temp;
	RecordsPanel(Node Head)
	{	
		this.Head = Head;
		this.temp = Head;
		this.setBounds(300,50,600,600);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setLayout(new BorderLayout());
		
		
		
		records = new JTextArea();
		records.setEditable(true);
		JScrollPane scrollingArea = new JScrollPane(records);
		scrollingArea.setPreferredSize(new Dimension(600,700));
		records.setFont(new Font("Times New Roman",Font.BOLD,28));
		records.setEditable(false);
		
		if(Head==null)
		{
			records.setFont(new Font("Times New Roman",Font.PLAIN,28));
			records.setText("Empty File/LinkedList");
		}else
		{
			records.setText("\n  Roll\tName\tCourse\t%\n\n");
			
		}
		while(temp!=null)
		{
			records.setFont(new Font("Times New Roman",Font.PLAIN,28));
			records.append("  "+temp.rollNo+"\t"+temp.name+"\t"+temp.course+"\t"+temp.percentage+"\n");
			temp=temp.nextNode;
		}
		
		this.add(scrollingArea, BorderLayout.CENTER);
	}
}
