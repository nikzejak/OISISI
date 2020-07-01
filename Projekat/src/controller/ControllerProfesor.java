package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Predmet;
import model.ProfesorskaBaza;
import model.Titula;
import model.Zvanje;
import view.AbstractTableModelPredmet;
import view.AbstractTableModelProfesor;
import view.TablePredmet;
import view.TableProfesor;

public class ControllerProfesor {

	private static ControllerProfesor instance = null;
	
	public static ControllerProfesor getInstance() {
		if(instance == null) {
			instance = new ControllerProfesor();
		}
		return instance;
	}
	
	public void obrisiProfesora(String brLicneKarte) {
		ProfesorskaBaza.getInstance().izbrisiProfesora(brLicneKarte);
		
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) TableProfesor.getInstance().getModel();
		AbstractTableModelPredmet model2 = (AbstractTableModelPredmet) TablePredmet.getInstance().getModel();
		
		model.fireTableDataChanged();
		model2.fireTableDataChanged();
	}
	
	public void izmeniProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		ProfesorskaBaza.getInstance().izmeniProfesora(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti);
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) TableProfesor.getInstance().getModel();
		model.fireTableDataChanged();
		
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti){
		System.out.println("Dodavanje Profesora");
		ProfesorskaBaza.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti);
		
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) TableProfesor.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) TableProfesor.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
}
