package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Profesor implements Serializable{
	
	private String ime;
	private String prezime;
	private Date datumRodj;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicne;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> predmeti;
	
	public Profesor(){
		this.ime = "";
		this.prezime = "";
		this.datumRodj = new Date();
		this.adresaStanovanja = "";
		this.telefon = "";
		this.email = "";
		this.adresaKancelarije = "";
		this.brojLicne = "";
		this.titula = Titula.PROFESOR;
		this.zvanje = Zvanje.DOCENT;
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, Date datumRodj, String adresaStanovanja, String telefon, String email,
			String adresaKancelarije, String brojLicne, Titula titula, Zvanje zvanje, ArrayList<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodj = datumRodj;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicne = brojLicne;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}

	public Profesor(Profesor p) {
		this.ime = p.ime;
		this.prezime = p.prezime;
		this.datumRodj = p.datumRodj;
		this.adresaStanovanja = p.adresaStanovanja;
		this.telefon = p.telefon;
		this.email = p.email;
		this.adresaKancelarije = p.adresaKancelarije;
		this.brojLicne = p.brojLicne;
		this.titula = p.titula;
		this.zvanje = p.zvanje;
		this.predmeti = p.predmeti;
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
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrojLicne() {
		return brojLicne;
	}
	public void setBrojLicne(String brojLicne) {
		this.brojLicne = brojLicne;
	}
	public Titula getTitula() {
		return titula;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public void izbrisiPredmet(String sifra) {
		for(Predmet p : predmeti) {
			if(p.getSifra().equals(sifra)) {
				predmeti.remove(p);
				break;
			}
		}
	}
	
}
