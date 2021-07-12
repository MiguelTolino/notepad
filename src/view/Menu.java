package view;

import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import controller.MenuController;

public class Menu extends JMenuBar {

	private JMenu file, help, edit , font, style, size, format;
	private JMenuItem save, open, nw, about, tnr, arial, courier, bold, italic, under, exit;
	private JTextField text_size;
	private MenuController mu;
	
	public Menu(MenuController mu) {
		super();
		setLayout(null);
		setOpaque(true);
		setPreferredSize(new Dimension(200, 20));
		this.mu = mu;
		file = new JMenu("File");
		help = new JMenu("Help");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		save = new JMenuItem("Save");
		open = new JMenuItem("Open");
		nw = new JMenuItem("New");
		exit = new JMenuItem("Exit");
		about = new JMenuItem("About");
		font = new JMenu("Font");
		style = new JMenu("Style");
		size = new JMenu("Size");
		
		file.add(nw);
		file.add(open);
		file.add(save);
		file.add(exit);
		help.add(about);
		format.add(font);
		format.add(style);
		//format.add(size);
		
		add(file);
//		add(edit);
		add(format);
		add(help);
		
		font.add(arial = new JMenuItem("Arial"));
		font.add(tnr = new JMenuItem("Times New Roman"));
		font.add(courier = new JMenuItem("Courier"));
		
		style.add(under = new JMenuItem("Default"));
		style.add(bold = new JMenuItem("Bold"));
		style.add(italic = new JMenuItem("Italic"));
		
	//	size.add(text_size = new JTextField(2));
		
		JMenuItem verdana = addItem("Verdana", font);
		
		save.addActionListener(mu);
		about.addActionListener(mu);
		open.addActionListener(mu);
		exit.addActionListener(mu);
		nw.addActionListener(mu);
		arial.addActionListener(mu);
		tnr.addActionListener(mu);
		courier.addActionListener(mu);
		bold.addActionListener(mu);
		italic.addActionListener(mu);
		under.addActionListener(mu);
		//text_size.addActionListener(mu);
		verdana.addActionListener(mu);
		
		//Set acelerator
		nw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
	}
	
	public JMenuItem addItem(String type, JMenu menu) {
		JMenuItem item = new JMenuItem(type);
		menu.add(item);
		return (item);
	}
}

