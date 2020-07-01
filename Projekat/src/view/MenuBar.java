package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.ControllerPredmet;
import controller.ControllerProfesor;
import controller.ControllerStudent;
import model.Predmet;
import model.PredmetskaBaza;
import model.Profesor;
import model.ProfesorskaBaza;
import model.Student;
import model.StudentskaBaza;

public class MenuBar extends JMenuBar{

	private int tab;
	
	public MenuBar() {
		
		setFont(new Font("Arial", Font.PLAIN, 20));
		JMenu file= new JMenu("File");
		JMenuItem miNew = new JMenuItem("New",new ImageIcon("images/new_icon.png"));
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke("control N"));
		JMenuItem miClose = new JMenuItem("Close",new ImageIcon("images/turn_off.png"));
		miClose.setMnemonic(KeyEvent.VK_W);
		miClose.setAccelerator(KeyStroke.getKeyStroke("control W"));
		
		file.add(miNew);
		file.add(miClose);
		
		JMenu edit= new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit",new ImageIcon("images/edit.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke("control E"));
		JMenuItem miDelete = new JMenuItem("Delete",new ImageIcon("images/delete1.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke("control D"));
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		JMenu help= new JMenu("Help");
		JMenuItem miHelp=new JMenuItem("Help",new ImageIcon("images/help.png"));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke("control H"));
		JMenuItem miAbout=new JMenuItem("About",new ImageIcon("images/about.png"));
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke("control A"));
		
		help.add(miHelp);
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
		
		miNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tab==0){
					DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(0,null);
					d.setVisible(true);
				}
				else if(tab==1)
				{
					DodavanjeProfesoraDialog d = new DodavanjeProfesoraDialog(0,null);
				    d.setVisible(true);
				}
				else
				{
						DodavanjePredmetaDialog d = new DodavanjePredmetaDialog();
					    d.setVisible(true);
				}
			}});
		
		
		miClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}});
		
		miEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tab==0){
					if(!TableStudent.getInstance().getSelectionModel().isSelectionEmpty()) {
						int rowIndex = TableStudent.getInstance().convertRowIndexToModel(TableStudent.getInstance().getSelectedRow());
						Student student = StudentskaBaza.getInstance().getRow(rowIndex);
						
						DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(1,student);
						d.setVisible(true);
					}
					else if(TableStudent.getInstance().getRowCount()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Nema studenata za izmenu.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
							JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da izmenite. \n Moguca je samo pojedinacna izmena ", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
						}
				}
				else if(tab==1)
					{
					if(!TableProfesor.getInstance().getSelectionModel().isSelectionEmpty()) {
						int rowIndex = TableProfesor.getInstance().convertRowIndexToModel(TableProfesor.getInstance().getSelectedRow());
						Profesor profesor = ProfesorskaBaza.getInstance().getRow(rowIndex);
						
						
						DodavanjeProfesoraDialog d=new DodavanjeProfesoraDialog(1,profesor);
						d.setVisible(true);
					}
					else if(TableProfesor.getInstance().getRowCount()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Nema profesora za izmenu.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
					}
					else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati profesora kog zelite da izmenite .\n Moguca je samo pojedinacna izmena ", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
						}
					}
				
				
				
				else
					{
						if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {
								int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
								Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
								
								IzmenaPredmetaDijalog dialog = new IzmenaPredmetaDijalog(predmet);
								dialog.setVisible(true);
						}
						else if(TablePredmet.getInstance().getRowCount()==0)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Nema predmeta za izmenu.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji zelite da izmenite .\n Moguca je samo pojedinacna izmena", "Predmet nije izabran!", JOptionPane.ERROR_MESSAGE);
						}
					}
				
			}});
		
		miDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tab==0){
					if(!TableStudent.getInstance().getSelectionModel().isSelectionEmpty()) {
						int rowIndex = TableStudent.getInstance().convertRowIndexToModel(TableStudent.getInstance().getSelectedRow());
							Student student = StudentskaBaza.getInstance().getRow(rowIndex);
					
								String poruka ="Da li ste sigurni da želite da obrišete "+student.getIme()+" "+student.getPrezime()+" ?";
					
									if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje studenta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
											ControllerStudent.getInstance().brisanjeStudenta(student);
									else return;
					}
					else if(TableStudent.getInstance().getRowCount()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Nema studenata za brisanje.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da obrisete.\n Moguca je samo pojedinacno brisanje ", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(tab==1)
				{
					if(!TableProfesor.getInstance().getSelectionModel().isSelectionEmpty()) {
							int rowIndex = TableProfesor.getInstance().convertRowIndexToModel(TableProfesor.getInstance().getSelectedRow());
							Profesor profesor = ProfesorskaBaza.getInstance().getRow(rowIndex);
							
							String poruka ="Da li ste sigurni da želite da obrišete "+profesor.getIme()+" "+profesor.getPrezime()+" ?";
							
							if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje profesora", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								ControllerProfesor.getInstance().obrisiProfesora(profesor.getBrojLicne());
							}else return;
						}
					else if(TableProfesor.getInstance().getRowCount()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Nema profesora za brisanje.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati profesora kog zelite da obrisete .\\n Moguca je samo pojedinacno brisanje ", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else
				{
					if(!TableProfesor.getInstance().getSelectionModel().isSelectionEmpty()) {
						int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
						System.out.println("Selected row: " + rowIndex);
						Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
						
						String poruka ="Da li ste sigurni da želite da obrišete "+predmet.getNaziv()+" ?";
						
						if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							ControllerPredmet.getInstance().brisanjePredmetaIzTabele(predmet);
						}else return;
					}
					else if(TablePredmet.getInstance().getRowCount()==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Nema predmeta za brisanje.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji zelite da obrisete .\n Moguca je samo pojedinacno brisanje ", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}});
		
	}
	
	public int getTab() {
		return tab;
	}
	
	public void setTab(int tab) {
		this.tab = tab;
	}
	
	
}
