package controller;

import model.Student;
import model.StudentskaBaza;
import view.AbstractTableModelStudent;
import view.TableStudent;

public class ControllerStudent {

	private static ControllerStudent instance = null;
	
	public static ControllerStudent getInstance() {
		if(instance == null) {
			instance = new ControllerStudent();
		}
		return instance;
	}
	
	public void dodajStudenta(Student s){
		StudentskaBaza.getInstance().dodajStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) TableStudent.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void izmeniStudenta(Student s) {
		StudentskaBaza.getInstance().izmeniStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) TableStudent.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void brisanjeStudenta(Student s) {
		StudentskaBaza.getInstance().brisanjeStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) TableStudent.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) TableStudent.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
}
