package Java_Notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{

	JFrame window;
	JTextArea textArea;
	boolean wordWrapOn= false;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu fileMenu,editMenu,formatMenu,themeMenu;
	JMenu fontMenu,fontSizeMenu;
	JMenuItem inew,iopen,isave,isaveas,iexit;
	JMenuItem iWrap,iAraial,iCsms,iTnr,i8,i10,i12,i14,i16,i18,i20,i22,i24;
	JMenuItem itheme1,itheme2;
	JMenuItem iundo,iredo;
	File_Functions file = new File_Functions(this);
	Format_Functions format = new Format_Functions(this);
	Theme_Functions theme = new Theme_Functions(this);
	Edit_Functions edit = new Edit_Functions(this);
	
	UndoManager um = new UndoManager();
	
	public GUI()
	{
		createwindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatmenu();
		createThemeMenu();
		createEditMenu();
		
		format.selectedFont="Comic Sans MS";
		format.createFont(16);
		format.wordWrap();
		theme.change_theme("White");
		
		window.setVisible(true);
	}
	
	public void createwindow()
	{
		window= new JFrame("Notepad");
		window.setSize(700,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea()
	{
		textArea= new JTextArea();
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
				
			}
		});
		scrollPane= new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	
	}
	
	public void createMenuBar()
	{
		menuBar= new JMenuBar();
		
		fileMenu= new JMenu("File");
		editMenu= new JMenu("Edit");
		formatMenu= new JMenu("Format");
		themeMenu= new JMenu("Theme");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(themeMenu);
		
		window.setJMenuBar(menuBar);
	}
	
	
	public void createFileMenu()
	{
		inew= new JMenuItem("New");
		inew.addActionListener(this);
		inew.setActionCommand("New");
		fileMenu.add(inew);
		
		iopen= new JMenuItem("Open");
		iopen.addActionListener(this);
		iopen.setActionCommand("Open");
		fileMenu.add(iopen);
		
		isave= new JMenuItem("Save");
		isave.addActionListener(this);
		isave.setActionCommand("Save");
		fileMenu.add(isave);
		
		isaveas= new JMenuItem("Saveas");
		isaveas.addActionListener(this);
		isaveas.setActionCommand("Saveas");
		fileMenu.add(isaveas);
		
		iexit= new JMenuItem("Exit");
		iexit.addActionListener(this);
		iexit.setActionCommand("Exit");
		fileMenu.add(iexit);
	}
	
	public void createFormatmenu()
	{
		iWrap= new JMenuItem("Word Wrap: OFF");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		formatMenu.add(iWrap);
		
		
		fontMenu= new JMenu("Font");
		formatMenu.add(fontMenu);
		
		iAraial= new JMenuItem("Arial");
		iAraial.addActionListener(this);
		iAraial.setActionCommand("Arial");
		fontMenu.add(iAraial);
		
		iCsms= new JMenuItem("Comic Sans MS");
		iCsms.addActionListener(this);
		iCsms.setActionCommand("Comic Sans MS");
		fontMenu.add(iCsms);
		
		iTnr= new JMenuItem("Times New Roman");
		iTnr.addActionListener(this);
		iTnr.setActionCommand("Times New Roman");
		fontMenu.add(iTnr);
		
		fontSizeMenu= new JMenu("Font Size");
		formatMenu.add(fontSizeMenu);
		
		i8= new JMenuItem("8");
		i8.addActionListener(this);
		i8.setActionCommand("8");
		fontSizeMenu.add(i8);
		
		i10= new JMenuItem("10");
		i10.addActionListener(this);
		i10.setActionCommand("10");
		fontSizeMenu.add(i10);
		
		i12= new JMenuItem("12");
		i12.addActionListener(this);
		i12.setActionCommand("12");
		fontSizeMenu.add(i12);
		
		i14= new JMenuItem("14");
		i14.addActionListener(this);
		i14.setActionCommand("14");
		fontSizeMenu.add(i14);
		
		i16= new JMenuItem("16");
		i16.addActionListener(this);
		i16.setActionCommand("16");
		fontSizeMenu.add(i16);
		
		i18= new JMenuItem("18");
		i18.addActionListener(this);
		i18.setActionCommand("18");
		fontSizeMenu.add(i18);
		
		i20= new JMenuItem("20");
		i20.addActionListener(this);
		i20.setActionCommand("20");
		fontSizeMenu.add(i20);
		
		i22= new JMenuItem("22");
		i22.addActionListener(this);
		i22.setActionCommand("22");
		fontSizeMenu.add(i22);
		
		i24= new JMenuItem("24");
		i24.addActionListener(this);
		i24.setActionCommand("24");
		fontSizeMenu.add(i24);
	}
	
	public void createThemeMenu() {
		itheme1= new JMenuItem("White");
		itheme1.addActionListener(this);
		itheme1.setActionCommand("White");
		themeMenu.add(itheme1);
		
		itheme2= new JMenuItem("Black");
		itheme2.addActionListener(this);
		itheme2.setActionCommand("Black");
		themeMenu.add(itheme2);
	}
	
	public void createEditMenu() {
		iundo= new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setActionCommand("Undo");
		editMenu.add(iundo);
		
		iredo= new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setActionCommand("Redo");
		editMenu.add(iredo);
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
				
		switch (command) {
		case "New": file.newFile(); break;
		case "Open": file.openFile(); break;
		case "Saveas": file.saveAsFile(); break;
		case "Save": file.saveFile();break;
		case "Exit":file.exitFile();break;
		
		
		case "Word Wrap": format.wordWrap(); break;
		
		
		
		case "8" : format.createFont(8);break;
		case "10" : format.createFont(10);break;
		case "12" : format.createFont(12);break;
		case "14" : format.createFont(14);break;
		case "16" : format.createFont(16);break;
		case "18" : format.createFont(18);break;
		case "20" : format.createFont(20);break;
		case "22" : format.createFont(22);break;
		case "24" : format.createFont(24);break;
		
		case "Arial": format.setFont(command);break;
		case "Comic Sans MS":format.setFont(command);break;
		case "Times New Roman":format.setFont(command);break;
		
		case "White":theme.change_theme(command); break;
		case "Black":theme.change_theme(command); break;
		
		case "Undo":edit.undo();break;
		case "Redo":edit.redo();break;

		default:break;
		}
		
	}

}
