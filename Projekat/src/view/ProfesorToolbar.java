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

import controller.ControllerProfesor;
import model.Profesor;
import model.ProfesorskaBaza;

public class ProfesorToolbar extends JToolBar {

	
	public ProfesorToolbar() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addProfesorBtn = new JButton("");
		addProfesorBtn.setIcon(new ImageIcon("images/add_stud.png"));
		addProfesorBtn.setToolTipText("Dodavanje profesora");
		panel.add(addProfesorBtn);
		
		JButton editProfesorBtn = new JButton("");
		editProfesorBtn.setIcon(new ImageIcon("images/edit_stud.png"));
		editProfesorBtn.setToolTipText("Izmena profesora");
		panel.add(editProfesorBtn);
		
		JButton deleteProfesorBtn = new JButton("");
		deleteProfesorBtn.setIcon(new ImageIcon("images/delete1.png"));
		deleteProfesorBtn.setToolTipText("Brisanje profesora");
		panel.add(deleteProfesorBtn);
		
		addProfesorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeProfesoraDialog d = new DodavanjeProfesoraDialog(0,null);
			    d.setVisible(true);
			}
		});
		
		deleteProfesorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		editProfesorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
				
				}});
	
	}
}
