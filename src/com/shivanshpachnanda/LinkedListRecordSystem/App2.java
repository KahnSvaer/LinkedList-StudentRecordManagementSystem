package com.shivanshpachnanda.LinkedListRecordSystem;


import javax.swing.*;

class App2 { 
	Node Head = null;
	Window win2;
	App2()
	{
		Head = LinkedListMethods.ReadFileList("Files/Data.csv");
		RecordsPage rp = new RecordsPage(Head);;
		JComponent[] compon =  {rp};
		win2 = new Window(compon);
	}
	App2(Node head)
	{
		this.Head = head;
		RecordsPage rp = new RecordsPage(Head);
		JComponent[] compon =  {rp};
		Window win2 = new Window(compon);
	}
		
	
}
