package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{

	private String sifra;
	private String naziv;
	private Semestar semestar;
	private Godina godina;
	private Profesor profesor;
	private ArrayList<Student> studenti;
	
	public Predmet() {
		super();
		this.sifra = "";
		this.naziv = "";
		this.semestar = Semestar.PRVI;
		this.godina = Godina.PRVA;
		this.profesor = null;
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, Semestar semestar, Godina godina, Profesor profesor,
			ArrayList<Student> studenti) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = profesor;
		this.studenti = studenti;
	}
	
	public Predmet(Predmet p) {
		super();
		this.sifra = p.sifra;
		this.naziv = p.naziv;
		this.semestar = p.semestar;
		this.godina = p.godina;
		this.profesor = p.profesor;
		this.studenti = p.studenti;
	}
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	public Godina getGodina() {
		return godina;
	}
	public void setGodina(Godina godina) {
		this.godina = godina;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
	}
	
	public void ukloniStudenta(Student s) {
		this.studenti.remove(s);
	}
	
}
