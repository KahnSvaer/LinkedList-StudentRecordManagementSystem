package com.shivanshpachnanda.LinkedListRecordSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ButtonsPanel extends JLabel implements ActionListener{
	
	JButton newEntry;
	JButton Modify;
	JButton Delete;
	JButton Save;
	Node Head;
	Node temp;

	
	ButtonsPanel(Node Head)
	{
		this.Head = Head;
		this.setLayout(null);
		this.setBounds(300,650,600,50); //May need to be changed
		
		newEntry = new JButton("New Entry");
		newEntry.addActionListener(this);
		newEntry.setFocusable(false);
		newEntry.setBounds(0,10,105,30);
		
		Modify = new JButton("Modify");
		Modify.addActionListener(this);
		Modify.setFocusable(false);
		Modify.setBounds(165,10,105,30);
		
		Delete = new JButton("Delete");
		Delete.addActionListener(this);
		Delete.setFocusable(false);
		Delete.setBounds(330,10,105,30);
		
		Save = new JButton("Save");
		Save.addActionListener(this);
		Save.setFocusable(false);
		Save.setBounds(495,10,105,30);
		
		this.add(Save);
		this.add(Delete);
		this.add(Modify);
		this.add(newEntry);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newEntry)
		{
			EntryClass Entry = new EntryClass(1,Head);
		}
		if(e.getSource()==Modify)
		{
			EntryClass Entry = new EntryClass(2,Head);
		}
		if(e.getSource()==Delete)
		{
			EntryClass Entry = new EntryClass(3,Head);
		}
		if(e.getSource()==Save)
		{
			LinkedListMethods.WriteFileList(Head);
		}
		
	}

}
 