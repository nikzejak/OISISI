package controller;

import java.util.ArrayList;

import model.Godina;
import model.Predmet;
import model.PredmetskaBaza;
import model.Profesor;
import model.ProfesorskaBaza;
import model.Semestar;
import model.Student;
import model.StudentskaBaza;
import view.AbstractTableModelPredmet;
import view.TablePredmet;

public class ControllerPredmet {

	private static ControllerPredmet instance = null;
	
	public static ControllerPredmet getInstance() {
		if (instance == null) {
			instance = new ControllerPredmet();
		}
		return instance;
	}
	
	public void dodavanjePredmetaUTabelu(String sifra, String naziv, Semestar semestar1, Godina godina1) {
		
		PredmetskaBaza.getInstance().dodajPredmet(sifra, naziv, semestar1, godina1, new Profesor(), new ArrayList<Student>());
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void brisanjePredmetaIzTabele(Predmet p) {
		PredmetskaBaza.getInstance().izbrisiPredmet(p);
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void dodavanjeProfesoraNaPredmet(int indeks, String brLicneKarte) {
		PredmetskaBaza.getInstance().dodajProfesoraNaPredmet(indeks, brLicneKarte);
		System.out.println(ProfesorskaBaza.getInstance());
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void dodavanjeStudentaNaPredmet(String indeks) {
		PredmetskaBaza.getInstance().dodajStudentaNaPredmet(indeks);
		System.out.println(StudentskaBaza.getInstance());
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void brisanjeStudentaSaPredmeta(String indeks,Predmet predmet) {
		PredmetskaBaza.getInstance().obrisiStudentaSaPredmeta(indeks,predmet);
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
		
	}
	
	public void izmenaPredmetaIzTabele(Predmet predmet, String sifra, String naziv, Semestar semestar1, Godina godina1) {
		PredmetskaBaza.getInstance().izmeniPredmet(predmet, sifra, naziv, semestar1, godina1);
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void brisanjeProfesoraSaPredmeta(int index) {
		PredmetskaBaza.getInstance().brisanjeProfesoraSaPredmeta(index);
		
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelPredmet model = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
}
