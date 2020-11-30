package view;

import java.awt.Dimension;
import javax.swing.*;

import controller.MenuController;

public class Menu extends JMenuBar {

	private JMenu file, help, edit , font, style, size;
	private JMenuItem save, open, nw, about, tnr, arial, courier, bold, italic, under;
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
		save = new JMenuItem("Save");
		open = new JMenuItem("Open");
		nw = new JMenuItem("New");
		about = new JMenuItem("About");
		font = new JMenu("Font");
		style = new JMenu("Style");
		size = new JMenu("Size");
		
		file.add(nw);
		file.add(open);
		file.add(save);
		help.add(about);
		edit.add(font);
		edit.add(style);
		edit.add(size);
		
		add(file);
		add(edit);
		add(help);
		
		font.add(arial = new JMenuItem("Arial"));
		font.add(tnr = new JMenuItem("Times New Roman"));
		font.add(courier = new JMenuItem("Courier"));
		
		style.add(bold = new JMenuItem("Bold"));
		style.add(italic = new JMenuItem("Italic"));
		style.add(under = new JMenuItem("Underline"));
		
		size.add(text_size = new JTextField(2));
		
		save.addActionListener(mu);
		open.addActionListener(mu);
		nw.addActionListener(mu);
		arial.addActionListener(mu);
		tnr.addActionListener(mu);
		courier.addActionListener(mu);
		bold.addActionListener(mu);
		italic.addActionListener(mu);
		under.addActionListener(mu);
		text_size.addActionListener(mu);
		
	}
}

