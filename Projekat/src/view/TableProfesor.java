package view;

import javax.swing.JTable;

public class TableProfesor extends JTable{

	private static TableProfesor instance = null;
	
	public static TableProfesor getInstance() {
		if(instance == null) {
			instance = new TableProfesor();
		}
		return instance;
	}
	
	private TableProfesor() {
		this.setModel(new AbstractTableModelProfesor());
		new ButtonColumnProfesori(this, 10);
	}
}
