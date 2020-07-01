package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable{

	private String ime;
	private String prezime;
	private Date datumRodj;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String indeks;
	private Date datumUpisa;
	private Godina godinaStudija;
	private Status status;
	private Double prosek;
	private ArrayList<Predmet> predmeti;
	
	
	public Student() {
		super();
		this.ime = "";
		this.prezime = "";
		this.datumRodj = new Date();
		this.adresaStanovanja = "";
		this.telefon = "";
		this.email = "";
		this.indeks = "";
		this.datumUpisa = new Date();
		this.godinaStudija = Godina.PRVA;
		this.status = Status.B;
		this.prosek =0.00;
		predmeti= new ArrayList<Predmet>();
	}
	
	public Student(String ime, String prezime, Date datumRodj, String adresaStanovanja, String telefon, String email,
			String indeks, Date datumUpisa, Godina godinaStudija, Status status, Double prosek) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodj = datumRodj;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.indeks = indeks;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.status = status;
		this.prosek = prosek;
		predmeti = new ArrayList<Predmet>();
	}
	
	Student(Student s){
		super();
		this.ime = s.ime;
		this.prezime = s.prezime;
		this.datumRodj = s.datumRodj;
		this.adresaStanovanja = s.adresaStanovanja;
		this.telefon = s.telefon;
		this.email = s.email;
		this.indeks = s.indeks;
		this.datumUpisa = s.datumUpisa;
		this.godinaStudija = s.godinaStudija;
		this.status = s.status;
		this.prosek = s.prosek;
		this.predmeti = s.predmeti;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatumRodj() {
		return datumRodj;
	}
	public void setDatumRodj(Date datumRodj) {
		this.datumRodj = datumRodj;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public Date getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public Godina getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(Godina godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Double getProsek() {
		return prosek;
	}
	public void setProsek(Double prosek) {
		this.prosek = prosek;
	}
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public Boolean dodajPredmet(Predmet predmet) {
		return predmeti.add(predmet);
	}
	
	public Boolean ukloniPredmet(Predmet predmet) {
		return predmeti.remove(predmet);
	}
	
}
