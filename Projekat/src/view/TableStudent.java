package view;

import javax.swing.JTable;

public class TableStudent extends JTable{

	private static TableStudent instance = null;
	
	public static TableStudent getInstance() {
		if(instance == null) {
			instance = new TableStudent();
		}
		return instance;
	}
	
	private TableStudent() {
		this.setModel(new AbstractTableModelStudent());
	}
}
