package view;

import javax.swing.JTable;

public class TablePredmet extends JTable{

	private static TablePredmet instance = null;
	
	public static TablePredmet getInstance() {
		if(instance == null) {
			instance = new TablePredmet();
		}
		return instance;
	}
	
	private TablePredmet() {
		this.setModel(new AbstractTableModelPredmet());
		new ButtonColumnPredmeti(this, 5);
	}
}
