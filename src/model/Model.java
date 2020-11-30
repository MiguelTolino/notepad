package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;

import view.Gui;

public class Model {
	
	public void openFile() throws FileNotFoundException {
		int selection = fileChooser.showOpenDialog(this.getContentPane());
		String text = "";
		
		if (selection == JFileChooser.APPROVE_OPTION)
		{
		   fichero = fileChooser.getSelectedFile();
		   // Aquí debemos abrir y leer el fichero.
		   Scanner sc = new Scanner(fichero);
		   while (sc.hasNextLine())
			   text += (sc.nextLine() + "\n");
		   ta.setText(text);
		   sc.close();
		}
		
	}
	
	public void newFile(String name) {
	    try {
	    	fichero = new File("C:\\Users\\migue\\eclipse-workspace\\notepad\\src\\" + name);
	    	if ((fichero.getName().substring(fichero.getName().length() - 4).equals(".txt")))
	    	{
	    			String n = fichero.getName() + ".txt";
	    			fichero = new File("C:\\Users\\migue\\eclipse-workspace\\notepad\\src\\"  + n);
	    	}
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
	
	public void saveFile() throws IOException {
		FileWriter fw = new FileWriter(fichero);
		fw.write(ta.getText());
		fw.close();
	}
	
}
