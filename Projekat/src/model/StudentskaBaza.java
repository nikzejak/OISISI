package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ListIterator;

import controller.ControllerStudent;

public class StudentskaBaza implements Serializable{

	private static StudentskaBaza instance = null;
	
	public static StudentskaBaza getInstance() {
		if (instance == null) {
			instance = new StudentskaBaza();
		}
		return instance;
	}
	
	private ArrayList<String> kolone;
	private ArrayList<Student> studenti;
	private SimpleDateFormat sdf;
	
	private StudentskaBaza() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		init();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Email");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	private void init() {
		this.studenti = new ArrayList<Student>();
		
		try {
			studenti.add(new Student("Nemanja", "Mirkovic", sdf.parse("27/12/1997"), "Milana Rakica 10", "015222333", "asmirkovic97@gmail.com", "RA216/2016",sdf.parse("08/07/2016"),Godina.CETVRTA,Status.S,8.20));
			studenti.add(new Student("Veljko", "Vukovic", sdf.parse("12/10/1997"), "Stojana Novakovica 44", "015444555", "weca44@gmail.com", "RA52/2016",sdf.parse("08/07/2016"),Godina.CETVRTA,Status.B,8.50));
			studenti.add(new Student("Milan", "Popovic", sdf.parse("22/02/1998"), "Ustanicka 2", "015111222", "miki98@gmail.com", "PR01/2017",sdf.parse("07/007/2017"),Godina.TRECA,Status.B,8.25));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	public int getColumnCount() {
		return kolone.size();
	}
	public void setStudenti(ArrayList<Student> Studenti) {
		this.studenti = Studenti;
	}
	
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch(column) {
		case 0: return student.getIndeks();
		case 1: return student.getIme();
		case 2: return student.getPrezime();
		case 3: return student.getEmail();
		case 4: return student.getGodinaStudija().toString();
		case 5: return student.getStatus().toString();
		case 6: return student.getProsek().toString();
		default: return null;
		}
	}
	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
		
	}
	
	public void izmeniStudenta(Student s) {
		ListIterator<Student> iterator = studenti.listIterator();
		while (iterator.hasNext()) {
			Student student=iterator.next();
				if(student.getIndeks().equals(s.getIndeks())) {
					student.setIme(s.getIme());
					student.setPrezime(s.getPrezime());
					student.setAdresaStanovanja(s.getAdresaStanovanja());
					student.setEmail(s.getEmail());
					student.setTelefon(s.getTelefon());
					student.setGodinaStudija(s.getGodinaStudija());
					student.setStatus(s.getStatus());
					student.setDatumRodj(s.getDatumRodj());
					iterator.set(student);
					System.out.println(iterator.toString());
				}
			
			}
	}
	
	public void brisanjeStudenta(Student s) {
		ListIterator<Student> iterator = studenti.listIterator();
		while (iterator.hasNext()) {
			Student student=iterator.next();
				if(student.getIndeks().equals(s.getIndeks())) {
					iterator.remove();
					}
				}
	}
	
	public void serijalizacijaStudenata() {
		try {
			FileOutputStream fStudenata = new FileOutputStream("spisak_studenata.ser");
			ObjectOutputStream studentOut = new ObjectOutputStream(fStudenata);
			studentOut.writeObject(StudentskaBaza.getInstance().getStudenti());
			
			studentOut.close();
			fStudenata.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserijalizacijaStudenata() {
		try {
			System.out.println("\n\n");
			FileInputStream fStudenata = new FileInputStream("spisak_studenata.ser");
			ObjectInputStream studentIn = new ObjectInputStream(fStudenata);
			@SuppressWarnings("unchecked")
			ArrayList<Student> studenti = (ArrayList<Student>) studentIn.readObject();
			StudentskaBaza.getInstance().setStudenti(studenti);
		    ControllerStudent.getInstance().promenaPosleDeserijalizacije();
			
			studentIn.close();
			fStudenata.close();
		}catch (IOException e) {
			
			 e.printStackTrace();
		}catch (ClassNotFoundException cnf) {
		  	 
			cnf.printStackTrace();
		}
	}
	
}
