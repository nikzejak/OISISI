package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controller.ControllerProfesor;

public class ProfesorskaBaza implements Serializable{
	
	private static ProfesorskaBaza instance = null;
	
	public static ProfesorskaBaza getInstance() {
		if (instance == null) {
			instance = new ProfesorskaBaza();
		}
		return instance;
	}

	private ArrayList<String> kolone;
	private ArrayList<Profesor> profesori;
	private SimpleDateFormat sdf;
	
	private ProfesorskaBaza() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		init();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Br. licne karte");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Telefon");
		this.kolone.add("E-mail");
		this.kolone.add("Adresa kancelarije");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	private void init() {
		this.profesori = new ArrayList<Profesor>();
		
		try {
			profesori.add(new Profesor("Nikola", "Nikolic", Calendar.getInstance().getTime(), "Zeleznicka 10", "015555333", "nikola@gmail.com", "Trg Dositeja Obradovica 1", "1111111", Titula.DR, Zvanje.DOCENT, new ArrayList<Predmet>()));
			profesori.add(new Profesor("Petar", "Petrovic", Calendar.getInstance().getTime(), "Narodnog fronta 1", "015222555", "petar@gmail.com", "Radnicka 18", "222222222", Titula.PROFESOR, Zvanje.VANREDNI, new ArrayList<Predmet>()));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 10;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch(column) {
		case 0: return profesor.getBrojLicne();
		case 1: return profesor.getIme();
		case 2: return profesor.getPrezime();
		case 3: {
			Date datum = profesor.getDatumRodj();
		    SimpleDateFormat formatDatum = new SimpleDateFormat("dd/MM/yyyy");
		    String formattedDate = formatDatum.format(datum);
			return formattedDate;
		}
		case 4: return profesor.getAdresaStanovanja();
		case 5: return profesor.getTelefon();
		case 6: return profesor.getEmail();
		case 7: return profesor.getAdresaKancelarije();
		case 8: return profesor.getTitula().toString();
		case 9: return profesor.getZvanje().toString();
		default: return null;
		}
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti));
	}

	public void izbrisiProfesora(String brLicneKarte) {
		Profesor profesor = nadjiPoId(brLicneKarte);
		if(profesor.getPredmeti().size() > 0) {
			for(Predmet p : PredmetskaBaza.getInstance().getPredmeti()) {
				if(p.getProfesor().getBrojLicne().equals(brLicneKarte)) {
					p.setProfesor(null);
				}
			}
		}
		profesori.remove(nadjiPoId(brLicneKarte));
	}
	
	public void izmeniProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		for (Profesor p : profesori) {
			if (p.getBrojLicne().equals(brLicne)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodj(datumRodjenja);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setTelefon(telefon);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setBrojLicne(brLicne);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}
	
	public void serijalizacijaProfesora() {
		try {
			FileOutputStream fProf = new FileOutputStream("spisak_profesora.ser");
			ObjectOutputStream profOut = new ObjectOutputStream(fProf);
			profOut.writeObject(ProfesorskaBaza.getInstance().getProfesori());
			
			profOut.close();
			fProf.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void deserijalizacijaProfesora() {
		try {
			FileInputStream fProf = new FileInputStream("spisak_profesora.ser");
			ObjectInputStream profIn= new ObjectInputStream(fProf);
			ArrayList<Profesor> profesori = (ArrayList<Profesor>) profIn.readObject();
			ProfesorskaBaza.getInstance().setProfesori(profesori);
			ControllerProfesor.getInstance().promenaPosleDeserijalizacije();
			
			fProf.close();
			profIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	public Profesor nadjiPoId(String brLicne) {
		for(Profesor p : profesori) {
			if(p.getBrojLicne().equals(brLicne)) {
				return p;
			}
		}
		return null;
	}
	
}
