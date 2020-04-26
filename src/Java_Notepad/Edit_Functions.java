package Java_Notepad;

public class Edit_Functions {
	
	GUI gui;
	public Edit_Functions(GUI gui)
	{
		this.gui= gui;
	}
	
	public void undo() {
		gui.um.undo();
	}
	
	public void redo() {
		gui.um.redo();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
