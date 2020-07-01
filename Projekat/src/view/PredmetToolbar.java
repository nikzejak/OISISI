package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.ControllerPredmet;
import model.Predmet;
import model.PredmetskaBaza;
import model.Student;
import model.StudentskaBaza;

public class PredmetToolbar extends JToolBar {
	
	public PredmetToolbar() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addPredmetBtn = new JButton("");
		addPredmetBtn.setIcon(new ImageIcon("images/add_stud.png"));
		addPredmetBtn.setToolTipText("Dodavanje predmeta");
		panel.add(addPredmetBtn);
		
		JButton editPredmetBtn = new JButton("");
		editPredmetBtn.setIcon(new ImageIcon("images/edit_stud.png"));
		editPredmetBtn.setToolTipText("Izmena predmeta");
		panel.add(editPredmetBtn);
		
		JButton deletePredmetBtn = new JButton("");
		deletePredmetBtn.setIcon(new ImageIcon("images/delete1.png"));
		deletePredmetBtn.setToolTipText("Brisanje predmeta");
		panel.add(deletePredmetBtn);
		
		JButton addProfesorUPredmetBtn = new JButton("");
		addProfesorUPredmetBtn.setIcon(new ImageIcon("images/add_prof.png"));
		addProfesorUPredmetBtn.setToolTipText("Dodavanje profesora na predmet");
		panel.add(addProfesorUPredmetBtn);
		
		JButton deleteProfesoraSaPredmetaBtn = new JButton("");
		deleteProfesoraSaPredmetaBtn.setIcon(new ImageIcon("images/delete.png"));
		deleteProfesoraSaPredmetaBtn.setToolTipText("Brisanje profesora sa predmeta");
		panel.add(deleteProfesoraSaPredmetaBtn);
		
		JButton addStudentUPredmetBtn = new JButton("");
		addStudentUPredmetBtn.setIcon(new ImageIcon("images/add2.jpg"));
		addStudentUPredmetBtn.setToolTipText("Dodavanje studenta na predmet");
		panel.add(addStudentUPredmetBtn);
		
		JButton deleteStudentaSaPredmetaBtn = new JButton("");
		deleteStudentaSaPredmetaBtn.setIcon(new ImageIcon("images/delete3.png"));
		deleteStudentaSaPredmetaBtn.setToolTipText("Brisanje studenta sa predmeta");
		panel.add(deleteStudentaSaPredmetaBtn);
		
		
		addPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaDialog d = new DodavanjePredmetaDialog();
			    d.setVisible(true);
			}
		});

		
		
		deletePredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
					System.out.println("Selected row: " + rowIndex);
					Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
					
					if(JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet", "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ControllerPredmet.getInstance().brisanjePredmetaIzTabele(predmet);
					}else return;
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji želite da obrišete ", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		addProfesorUPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {	
					DodavanjeProfesoraNaPredmet dialog = new DodavanjeProfesoraNaPredmet();
					dialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet u koji želite da upišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		editPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
					Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
					
					IzmenaPredmetaDijalog dialog = new IzmenaPredmetaDijalog(predmet);
					dialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji želite da izmenite", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		deleteProfesoraSaPredmetaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
					Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
					if(predmet.getProfesor() != null) {
						if(JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete profesora", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)		
							ControllerPredmet.getInstance().brisanjeProfesoraSaPredmeta(rowIndex);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Predmet nema profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet iz kojeg želite da obrišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		deleteStudentaSaPredmetaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
					Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
					Student student = StudentskaBaza.getInstance().getRow(rowIndex);
					
					
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet iz kojeg želite da obrišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		addStudentUPredmetBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!TablePredmet.getInstance().getSelectionModel().isSelectionEmpty()) {	
					int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
					Predmet predmet = PredmetskaBaza.getInstance().getRow(rowIndex);
					
					DodavanjeStudentaNaPredmet dialog = new DodavanjeStudentaNaPredmet();
					dialog.setVisible(true);
				}
				else if(TablePredmet.getInstance().getRowCount()==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Tabela studenata je prazna.\n Molim prvo dodajte predmet.", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet u koji želite da upišete studenta", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}});
	}
	
}
