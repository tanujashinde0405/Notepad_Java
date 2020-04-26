package Java_Notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File_Functions {
	GUI gui;
	String fileName,fileAddressString;
	public File_Functions(GUI gui) {
		this.gui= gui;
	}
		
	public void newFile()
	{
		gui.textArea.setText("");
		gui.window.setTitle("New Tab");
		fileName= null;
		fileAddressString= null;
	}
	
	public void openFile()
	{
		FileDialog fbDialog= new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fbDialog.setVisible(true);
		
		if(fbDialog.getFile()!= null)
		{
			fileName =fbDialog.getFile();
			fileAddressString= fbDialog.getDirectory();
			gui.window.setTitle(fileName);
		}
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileAddressString + fileName));
			
			gui.textArea.setText("");
			
			String line = null;
			
			while((line = br.readLine())!= null)
			{
				gui.textArea.append(line + "\n");
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println("Error!!");
		}
	}
	
	public void saveFile()
	{
		if(fileName==null)
		{
			saveAsFile();
		}
		else {
			try {
				FileWriter fW = new FileWriter(fileAddressString + fileName);
				fW.write(gui.textArea.getText());
				gui.window.setTitle(fileName);
				fW.close();
				
			} catch (Exception e) {
				System.out.println("Error..");
			}
		}
	}
	
	public void saveAsFile()
	{
		FileDialog fbDialog= new FileDialog(gui.window, "Save", FileDialog.SAVE);
		fbDialog.setVisible(true);
		
		if(fbDialog.getFile()!= null)
		{
			fileName =fbDialog.getFile();
			fileAddressString= fbDialog.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			FileWriter fW = new FileWriter(fileAddressString + fileName);
			fW.write(gui.textArea.getText());
			fW.close();
			
		} catch (Exception e) {
			System.out.println("Error..");
		}
	}

	public void exitFile()
	{
		System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
