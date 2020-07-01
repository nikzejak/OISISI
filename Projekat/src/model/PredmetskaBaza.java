package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControllerPredmet;
import view.TablePredmet;

public class PredmetskaBaza implements Serializable{
	
	private static PredmetskaBaza instance = null;
	
	public static PredmetskaBaza getInstance() {
		if(instance == null) {
			instance = new PredmetskaBaza();
		}
		return instance;
	}
	
	private ArrayList<String> kolone;
	private ArrayList<Predmet> predmeti;
	
	private PredmetskaBaza() {
		init();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Profesor");
		this.kolone.add("Semestar");
		this.kolone.add("Godina");
	}
	
	private void init() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("E1234", "Algebra", Semestar.PRVI, Godina.PRVA, new Profesor(), new ArrayList<Student>()));
		predmeti.add(new Predmet("E2225", "OISISI", Semestar.PETI, Godina.DRUGA, new Profesor(), new ArrayList<Student>()));
		predmeti.add(new Predmet("R4345", "SIMS", Semestar.SESTI, Godina.TRECA, new Profesor(), new ArrayList<Student>()));
	}
	
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			String prof;
			if(predmet.getProfesor() == null) {
				prof = "";
			}else prof = predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime();
			return prof;
		case 3:
			return predmet.getSemestar().toString();
		case 4:
			return predmet.getGodina().toString();
		default:
			return null;
		}
	}
	
	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}

	public void dodajPredmet(String sifra, String naziv, Semestar semestar, Godina godina, Profesor profesor,
			ArrayList<Student> studenti) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar,  godina,  null, studenti));
	}

	public void izbrisiPredmet(Predmet p) {
		Profesor prof = p.getProfesor();
		if(prof != null) {
			for(Profesor profesor : ProfesorskaBaza.getInstance().getProfesori()) {
				if(profesor.getBrojLicne().equals(prof.getBrojLicne())) {
					profesor.izbrisiPredmet(p.getSifra());
				}
			}
		}
		predmeti.remove(p);
		System.out.println(ProfesorskaBaza.getInstance());
	}

	public void izmeniPredmet(Predmet predmet, String sifra, String naziv, Semestar semestar, Godina godina) {
		for(Profesor profesor : ProfesorskaBaza.getInstance().getProfesori()) {
			for(Predmet p : profesor.getPredmeti()) {
				if(p.getSifra().equals(predmet.getSifra())) {
					p.setSifra(sifra);
					p.setNaziv(naziv);
					p.setSemestar(semestar);
					p.setGodina(godina);
					break;
				}
			}
		}
		predmet.setSifra(sifra);
		predmet.setNaziv(naziv);
		predmet.setSemestar(semestar);
		predmet.setGodina(godina);
		
	}
	
	public void dodajStudentaNaPredmet(String indeks) {
		int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
		Predmet predmet = PredmetskaBaza.getInstance().getPredmeti().get(rowIndex);
		
		for(Student s: StudentskaBaza.getInstance().getStudenti()) {
			if(indeks.toLowerCase().trim().equals(s.getIndeks().trim().toLowerCase() )) {
				if(predmet.getGodina().equals(s.getGodinaStudija()) )
				{
					if(predmet.getStudenti().isEmpty())
					{
						predmet.dodajStudenta(s);
						s.dodajPredmet(predmet);
						return;
					}
					else {
					for(Student student: predmet.getStudenti()) {
						if(!indeks.toLowerCase().equals(student.getIndeks().toLowerCase()))
							{	
	
								predmet.dodajStudenta(student);
								student.dodajPredmet(predmet);
								return;
							}
						else
							{
							JOptionPane.showMessageDialog(null,"Student je vec upisan na ovaj predmet ", "Greska",JOptionPane.ERROR_MESSAGE);
							return;
							}
					}
				}
			}else 
				JOptionPane.showMessageDialog(null,"Student nije odgovarajuca godina za izabrani predmet", "Greska",JOptionPane.ERROR_MESSAGE);
				return;
				
				}
		}
		JOptionPane.showMessageDialog(null,"Ne postoji student sa unetim indeksom ", "Greska",JOptionPane.ERROR_MESSAGE);
	}
	
	public void dodajProfesoraNaPredmet(int indeks, String brLicneKarte) {
		int postoji = 0;
		Predmet predmet = PredmetskaBaza.getInstance().getPredmeti().get(indeks);
		for(Profesor p : ProfesorskaBaza.getInstance().getProfesori()) {
			if(p.getBrojLicne().equals(brLicneKarte)) {
				postoji = 1;
				if(predmet.getProfesor() == null) {
					predmet.setProfesor(p);
					p.getPredmeti().add(predmet);
					break;
				}else if(!predmet.getProfesor().getBrojLicne().equals(p.getBrojLicne())){
					
					brisanjeProfesoraSaPredmeta(indeks);
					predmet.setProfesor(p);
					p.getPredmeti().add(predmet);	
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Vec postoji profesor na tom predmetu sa istim brojem licne karte", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(postoji == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji zadati broj licne karte u bazi profesora", "Greska!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void obrisiStudentaSaPredmeta(String indeks,Predmet predmet) {
		for(Student student:predmet.getStudenti())
			if(student.getIndeks().toLowerCase().trim().equals(indeks.trim().toLowerCase()))
				{
				predmet.ukloniStudenta(student);
				student.ukloniPredmet(predmet);
				return;
				}
	}
	
	public void brisanjeProfesoraSaPredmeta(int index) {
		Predmet predmet = PredmetskaBaza.getInstance().getPredmeti().get(index);
		Profesor prof = PredmetskaBaza.getInstance().getPredmeti().get(index).getProfesor();
		for(Profesor p : ProfesorskaBaza.getInstance().getProfesori()) {
			if(p.getBrojLicne().equals(prof.getBrojLicne())) {
				p.izbrisiPredmet(predmet.getSifra());
				break;
			}
		}
		predmet.setProfesor(null);
		System.out.println(ProfesorskaBaza.getInstance());
	}
	
	public void serijalizacijaPredmeta() {
		try {
			FileOutputStream fPred = new FileOutputStream("spisak_predmeta.ser");
			ObjectOutputStream predOut = new ObjectOutputStream(fPred);
			predOut.writeObject(PredmetskaBaza.getInstance().getPredmeti());
			
			predOut.close();
			fPred.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void deserijalizacijaPredmeta() {
		try {
			System.out.println("\n\n");
			FileInputStream fPred = new FileInputStream("spisak_predmeta.ser");
			ObjectInputStream predIn= new ObjectInputStream(fPred);
			ArrayList<Predmet> predmeti = (ArrayList<Predmet>) predIn.readObject();
			PredmetskaBaza.getInstance().setPredmeti(predmeti);
			ControllerPredmet.getInstance().promenaPosleDeserijalizacije();
			
			fPred.close();
			predIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
}
