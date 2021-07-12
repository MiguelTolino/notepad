package view;

import javax.swing.*;

public class PopUpMenu extends JPopupMenu {
	
	JMenuItem copy, cut, select, n;

	public PopUpMenu() {
		
		super();
		n = new JMenuItem("New");
		add(n);
		copy = new JMenuItem("Copy");
		add(copy);
		cut = new JMenuItem("Cut");
		add(cut);
		select = new JMenuItem("Select All");
		add(select);

		
		
	}
}
