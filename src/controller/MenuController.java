package controller;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JMenuItem;

import model.Model;
import view.Window;

import javax.swing.*;

public class MenuController implements ActionListener {
	
	private Model m;
	private Window win;
	
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
		if (event.getText().equals("About"))
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
		if (event.getText().equals("Arial")) {
			win.getTextPane().setFont(new Font(event.getText(), 20, 20));
			
		}
	}
	
}
