package view;

import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {
	private static final long serialVersionUID = -545990780982120727L;

	public TabbedPane() {
		
		TabStudent studenti = new TabStudent();
		this.addTab("Studenti", studenti);
		
		TabProfesor profesori = new TabProfesor();
		this.addTab("Profesori", profesori);
		
		TabPredmet predmeti = new TabPredmet();
		this.addTab("Predmeti", predmeti);
	}
	
}
