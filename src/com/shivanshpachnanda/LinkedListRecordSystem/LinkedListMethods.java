package com.shivanshpachnanda.LinkedListRecordSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class LinkedListMethods {
	//Creation of node
	static Node CreateNode(int rollno, String name,String course,float per)
	{
		Node Head = new Node(rollno,name,course,per);
		return Head;
	}
	
	//Insertion at the end
	static Node InsertNode(Node Head, int rollno, String name, String course, float per)
	{
		Node temp = Head;
		while(temp.nextNode!=null)
			temp=temp.nextNode;
		temp.nextNode = CreateNode(rollno,name,course,per);
		return Head;
	}
	
	//Insertion in mid by position
	static Node InsertNode(Node Head, int rollNo, String name, String course, float per, int changePos)
	{
		Node temp = Head;
		int pos = 1;
		while(temp.nextNode!=null&&changePos>pos) 
		{
			temp=temp.nextNode;
			pos++;
		}
		if(pos==changePos)
		{
			Node temp2 = temp.nextNode;
			temp.nextNode = CreateNode(rollNo, name,course,per);
			temp.nextNode.nextNode = temp2;
		}
		else if(changePos == 0)
		{
			Head = CreateNode(rollNo, name,course,per);
			Head.nextNode = temp;
		}
		else
			System.out.println("Node not found");
		
		return Head;
	}
	
	//DeleteNodeCompletely
	static Node DeleteList(Node Head)
	{
		Head = null;
		return Head;
	}
	
	//Delete by Roll Number
	static Node DeleteNode (Node Head, int rollno)
	{
		Node temp2 = Head;
		Node temp = null;
		
		if(Head.nextNode != null)
		{
			temp = Head.nextNode;
			if(Head.rollNo == rollno)
			{
				Head = temp;
				return Head;
			}
		}else
		{
			if(Head.rollNo == rollno)
				return DeleteList(Head);
			 else 
				{
					System.out.println("Out of index");
					return Head;
				}
		}
		
		while(temp.nextNode!=null&&temp.rollNo!=rollno) 
		{	
			temp2 = temp;
			temp=temp2.nextNode;
		}if(rollno == temp.rollNo)
		{
			temp2.nextNode = temp.nextNode;
		}else 
			System.out.println("Out of index");
		return Head;
	}
	
	//Printing a node information
	static void Show(Node temp)
	{
		System.out.println(temp.rollNo+"\t"+temp.name+"\t"+temp.course+"\t"+temp.percentage);
	}
	
	//Showing all nodes
	static void ShowAll(Node Head)
	{
		Node temp = Head;
		while(temp.nextNode!=null)
		{
			Show(temp);
			temp=temp.nextNode;
		}
		Show(temp);
	}
	
	//Search up a node and display information  
	static Node ModifyNode(Node Head, int rollno, String name, String Course, float per)
	{
		Node temp = Head;
		while(temp.nextNode!=null&&temp.rollNo!=rollno) 
			temp=temp.nextNode;
		if(temp.rollNo==rollno)
		{
			temp.name = name;
			temp.course = Course;
			temp.percentage = per;
		}
		return Head;
	}
	
	//To read data from file
	static Node ReadFileList(String file)
	{
		System.out.println("FileFound");
		Node head = null;
		Node temp = null;
		BufferedReader reader = null;
		String line;
		try
		{
			reader = new BufferedReader(new FileReader(file));
			reader.readLine(); //Basically to skip HeaderRow
			while((line = reader.readLine()) !=null )
			{
				String[] row = line.split(",");
				if(head==null)
				{
					head = CreateNode(Integer.parseInt(row[0]),row[1],row[2],Float.parseFloat(row[3]));
					temp = head;
				}
				else
				{
					temp.nextNode = CreateNode(Integer.parseInt(row[0]),row[1],row[2],Float.parseFloat(row[3]));
					temp = temp.nextNode;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return head;
	}
	
	//to save Data in file
	static void WriteFileList(Node head)
	{
		String file = "Files/Data.csv"; //Only 1 file so no need of parameter
		FileWriter writer = null;
		Node temp = head; 
		try
		{
			writer = new FileWriter(file);
			writer.write("RollNo,Name,Course,Percentage");
			while(temp!=null)
			{
				writer.append("\n"+Integer.toString(temp.rollNo)+","+temp.name+","+temp.course+","+Float.toString(temp.percentage));
				temp = temp.nextNode;
			}
		}catch(Exception e)
		{
				e.printStackTrace();
		}finally{
				try {
				    writer.close();
				   } catch (IOException e) {
				    e.printStackTrace();
				   }			
		}
	}
}

