package com.shivanshpachnanda.LinkedListRecordSystem;


import javax.swing.*;

class App2 { 
	Node Head = null;
	Window win2;
	RecordsPage rp;
	App2()
	{
		Head = LinkedListMethods.ReadFileList("Files/Data.csv");
		rp = new RecordsPage(Head);
		JComponent[] compon =  {rp};
		win2 = new Window(compon);
	}
		
	
}
