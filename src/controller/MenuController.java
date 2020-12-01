package controller;

import java.awt.Font;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import view.Window;

import javax.swing.*;

public class MenuController implements ActionListener {
	
	private Model m;
	private Window win;
	private int size;
	
	public MenuController(Window win) {
		m = new Model();
		this.win = win;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem event = (JMenuItem)(ae.getSource());
		if (event.getText().equals("Save")) {
			try {
				m.saveFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("SAVE");
		}
		if (event.getText().equals("Open")) {
			try {
				m.openFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Open");
		}
		if (event.getText().equalsIgnoreCase("About"))
			JOptionPane.showMessageDialog(null, "Author: Miguel Mateo Tolino \nGithub: MikelTolino", "More info", JOptionPane.INFORMATION_MESSAGE);
		if (event.getText().equals("New"))
		{
			String name = JOptionPane.showInputDialog("Insert name of new file");
			m.newFile(name);
			try {
				m.openFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("New");
		}
		setFormat(event, size);
		

		
	}
	
	private void setFormat(JMenuItem event, int size) {
		
		if (event.getText().equals("Arial")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.PLAIN, 12));
		}
		if (event.getText().equals("Times New Roman")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.PLAIN, 12));
		}
		if (event.getText().equals("Courier")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.PLAIN, 12));
		}
		if (event.getText().equals("Bold")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.BOLD, 12));
		}
		if (event.getText().equals("Italic")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.ITALIC, 12));
		}
		if (event.getText().equals("Underline")) {
			win.getTextPane().setFont(new Font(event.getText(), Font.ROMAN_BASELINE, 12));
		}
	}
	
	private void setFont(JMenuItem event) {
		String font = event.getText();
		
		if (font != null) {
			win.getTextPane().setFont(new Font(event.getText(), Font.PLAIN, 12));
	}
		String l = win.getTextPane().getSelectedText();
		System.out.println(l);
	
}
	class TextAreaController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ea) {
			JTextPane tpane = (JTextPane) ea.getSource();
			JLabel l1 = win.getLabel();
			l1.setText("Column: " + tpane.getX() + " | Row: " + tpane.getY() + "   ");
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
