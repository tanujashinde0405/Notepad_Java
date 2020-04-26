package Java_Notepad;

import java.awt.Font;

public class Format_Functions {
	
	GUI gui;
	Font arialFont,comicsansFont,timesNewRomanFont;
	String selectedFont;
	
	public Format_Functions(GUI gui)
	{
		this.gui= gui;
	}

	public void wordWrap()
	{
		if(gui.wordWrapOn== false)
		{
			gui.wordWrapOn= true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: ON");
		}
		else if(gui.wordWrapOn== true)
		{
			gui.wordWrapOn= false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
		}
	}
	
	public void createFont(int fontSize) {
		arialFont= new Font("Arial",Font.PLAIN, fontSize);
		comicsansFont= new Font("Comic Sans MS",Font.PLAIN, fontSize);
		timesNewRomanFont= new Font("Times New Roman",Font.PLAIN, fontSize);
		
		setFont(selectedFont);
	}
	
	public void setFont(String font) {
		selectedFont= font;
		
		switch (selectedFont) {
		case "Arial":gui.textArea.setFont(arialFont);break;
		case "Comic Sans MS":gui.textArea.setFont(comicsansFont); break;
		case "Times New Roman":gui.textArea.setFont(timesNewRomanFont); break;

		default:
			break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
