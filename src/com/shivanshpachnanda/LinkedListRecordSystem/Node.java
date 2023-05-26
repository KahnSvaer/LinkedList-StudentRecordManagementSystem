package com.shivanshpachnanda.LinkedListRecordSystem;

class Node {
	int rollNo;
	String name;
	String course;
	float percentage;
	Node nextNode;
	Node(int roll, String name)
	{
		this.rollNo = roll;
		this.name = name;
		this.course = "BTech";
		this.percentage = 0f;
	}
	Node(int roll, String name, String course)
	{
		this.rollNo = roll;
		this.name = name;
		this.course = course;
		this.percentage = 0f;
	}
	Node(int roll, String name, String course, float percentage)
	{
		this.rollNo = roll;
		this.name = name;
		this.course = course;
		this.percentage = percentage;
	}
}
