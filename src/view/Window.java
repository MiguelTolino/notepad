package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import controller.MenuController;

public class Window extends JFrame {
	
	private int width, height;
	private ImageIcon img;
	private JTextPane text_pane;
	private JScrollPane scroll;
	private JFileChooser fileChooser;
	private File fichero;
	private JLabel l1;
	private Menu mn;
	private MenuController mu;

	public Window() {
		super("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setIcon();
		setLayout(new BorderLayout());
		text_pane = new JTextPane();
		l1 = new JLabel("Column: " + text_pane.getX() + " | Row: " + text_pane.getY() + "   ", JLabel.RIGHT);
		add(l1, BorderLayout.SOUTH);
		add(text_pane, BorderLayout.CENTER);
		mu = new MenuController(this);
		mn = new Menu(mu);
		setJMenuBar(mn);
		setVisible(true);
		}
	
	private void setIcon() {
		img = new ImageIcon("img/notepad.jpg");
		setIconImage(img.getImage());
	}
	
	public JTextPane getTextPane() {
		return text_pane;
	}
}
