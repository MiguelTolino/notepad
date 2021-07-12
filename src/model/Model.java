package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.Window;

public class Model {
	
	private File fichero;
	
	public String openFile(Window win) throws FileNotFoundException {
		JFileChooser fc = new JFileChooser();
		int selection = fc.showOpenDialog(win.getContentPane());
		String text = "";
		
		if (selection == JFileChooser.APPROVE_OPTION)
		{
		   fichero = fc.getSelectedFile();
		   // Aquí debemos abrir y leer el fichero.
		   Scanner sc = new Scanner(fichero);
		   while (sc.hasNextLine())
			   text += (sc.nextLine() + "\n");
		   sc.close();
		}
		return (text);	
	}
	
	public void newFile(String name) {
	    try {
	    	fichero = new File("C:\\Users\\migue\\eclipse-workspace\\notepad\\src\\" + name);
	        if (fichero.createNewFile()) {
	          System.out.println("File created: " + fichero.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	public void saveFile(Window win) throws IOException {
		if (fichero == null) {
			String name = JOptionPane.showInputDialog("File name: ");
			if(name == null)
				return;
			fichero = new File(name);
		}
		FileWriter fw = new FileWriter(fichero);
		fw.write(win.getTextPane().getText());
		fw.close();
	}
	
}
