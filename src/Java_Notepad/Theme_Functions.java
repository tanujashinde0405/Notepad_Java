package Java_Notepad;

import java.awt.Color;

public class Theme_Functions {
	
	GUI gui;
	
	public Theme_Functions(GUI gui)
	{
		this.gui= gui;
	}
	
	public void change_theme(String theme)
	{
		switch(theme) {
		case "White":
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;
			
		case "Black":
			gui.window.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.white);
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
