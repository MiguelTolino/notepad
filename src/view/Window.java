package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.io.File;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import controller.MenuController;

public class Window extends JFrame {
	
	private ImageIcon img;
	private JTextArea text_pane;
	private JLabel l1;
	private Menu mn;
	private MenuController mu;
	private PopUpMenu pop;

	public Window() {
		super("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setIcon();
		setLayout(new BorderLayout());
		text_pane = new JTextArea();
		l1 = new JLabel("Line, " + (text_pane.getX() + 1) + " : Col, " + (text_pane.getY() + 1) + "   ", JLabel.RIGHT);
		add(l1, BorderLayout.SOUTH);
		add(text_pane, BorderLayout.CENTER);
		mu = new MenuController(this);
		mn = new Menu(mu);
		setJMenuBar(mn);
		//pop = new PopUpMenu();
		//text_pane.setComponentPopupMenu(pop);
		text_pane.addCaretListener(new setRC());
		setVisible(true);
	}
	
	private void setIcon() {
		img = new ImageIcon("img/notepad.jpg");
		setIconImage(img.getImage());
	}
	
	public JTextArea getTextPane() {
		return text_pane;
	}
	
	public JLabel getLabel() {
		return l1;
	}
	
	class setRC implements CaretListener {

		@Override
		public void caretUpdate(CaretEvent ev) {
			// TODO Auto-generated method stub
			int row = 1, column = 1;
			JTextArea ta = (JTextArea) ev.getSource();
			try {
				 int caretpos = ta.getCaretPosition();
				    row= ta.getLineOfOffset(caretpos);
				    column = caretpos - ta.getLineStartOffset(row);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			row += 1;
			column+=1;
			l1.setText("Line, " + row + " : Col, " + column + "   ");
		}
		
	}

		}
