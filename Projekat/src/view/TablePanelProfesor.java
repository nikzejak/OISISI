package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public class TablePanelProfesor extends JPanel{

	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	public TablePanelProfesor() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	public TablePanelProfesor(Component c) {
		setLayout(new BorderLayout());
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.setBackground(Color.WHITE);
		add(c);
	}
	
}
