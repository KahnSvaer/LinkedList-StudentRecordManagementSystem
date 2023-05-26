package com.shivanshpachnanda.LinkedListRecordSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Login extends JLabel implements ActionListener,FocusListener{
	private JTextField userText;
	private JPasswordField passText;
	public JButton submit;
	private JLabel correction;
	public static App2 again;
	

	Login(){
		 	this.setBackground(Color.WHITE);
			this.setOpaque(true);
			this.setBounds(400,275,400,250);
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setLayout(null);
			
			JLabel Title = new JLabel("WELCOME!");
			Title.setBounds(10,10,390,60);
			Title.setHorizontalAlignment(JLabel.CENTER);
			Title.setFont(new Font("Times New Roman",Font.PLAIN,28));
			
			JLabel userName = new JLabel("UserName");
			userName.setBounds(10,50,360,45);
			userName.setHorizontalAlignment(JLabel.LEFT);
			userName.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			userText = new JTextField();
			userText.setText("Username");
			userText.addFocusListener(this);
			userText.setBounds(30,90,350,25);
			userText.setFont(new Font("Times New Roman",Font.PLAIN,16));
			userText.setForeground(Color.GRAY);
			
			
			JLabel passWord = new JLabel("Password");
			passWord.setBounds(10, 120, 360, 45);
			passWord.setHorizontalAlignment(JLabel.LEFT);
			passWord.setFont(new Font("Times New Roman",Font.PLAIN,18));
			
			passText = new JPasswordField(6);
			passText.setEchoChar((char)0);
			passText.setText("Password");
			passText.addFocusListener(this);
			passText.setBounds(30,160,350,25);
			passText.setFont(new Font("Times New Roman",Font.PLAIN,16));
			passText.setForeground(Color.GRAY);
			
			submit = new JButton("SUBMIT");//ActionPerformed
			submit.addActionListener(this);
			submit.setFocusable(false);
			submit.setBounds(150,200,100,30);
			
			correction = new JLabel();
			correction.setHorizontalAlignment(JLabel.CENTER);
			correction.setBounds(10,-10,390,45);
			correction.setText("Incorrect UserName/Password");
			correction.setFont(new Font("Times New Roman",Font.PLAIN,12));
			correction.setForeground(Color.RED);
			correction.setVisible(false);
			
			
			this.add(Title);
			this.add(userName);
			this.add(userText);
			this.add(passWord);
			this.add(passText);
			this.add(submit);
			this.add(correction);	
	 }
	 
	public Boolean Check(String name, char[] cs, String file)
	{
		Boolean flag=false;
		BufferedReader reader = null;
		String line;
		char[] pw;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			reader.readLine(); //Basically to skip HeaderRow
			while((line = reader.readLine()) !=null )
			{
				String[] row = line.split(",");
				if(row[0].compareToIgnoreCase(name)==0) {
					pw = Arrays.copyOf(row[1].toCharArray(), row[1].toCharArray().length );
					if(Arrays.compare(cs, pw)==0)
					{
						flag = true;
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally
		{
			try
			{
				reader.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==submit)
		 {
			 Boolean response = Check(userText.getText(), passText.getPassword(), "Files/admin.csv");
			 correction.setVisible(!response);
			 if(response)
			 {
				 App.win.dispose();
				 again = new App2();
			 }
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
		 if(e.getSource()==passText&&passText.getEchoChar()==(char)0)
		 {
			 passText.setText("");
			 passText.setForeground(Color.BLACK);
			 passText.setEchoChar('•');
		 }	 
	 }
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==userText&&userText.getText().length()==0)
		 {
			 userText.setForeground(Color.GRAY);
			 userText.setText("Username");
		 }
		 if(e.getSource()==passText&&passText.getPassword().length==0)
		 {
			 passText.setEchoChar((char)0);
			 passText.setForeground(Color.GRAY);
			 passText.setText("Password");	 
		 }
	}
}