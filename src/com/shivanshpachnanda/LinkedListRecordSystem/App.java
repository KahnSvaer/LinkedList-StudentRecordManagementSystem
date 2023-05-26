package com.shivanshpachnanda.LinkedListRecordSystem;

import javax.swing.JComponent;
class App {
	static IntroPage ip = new IntroPage();
	static JComponent[] panes = {ip};
	public static Window win = new Window(panes);
}
