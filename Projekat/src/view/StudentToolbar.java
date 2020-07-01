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

import controller.ControllerStudent;
import model.Student;
import model.StudentskaBaza;

public class StudentToolbar extends JToolBar {

	
	public StudentToolbar() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addStudent = new JButton("");
		addStudent.setIcon(new ImageIcon("images/add_stud.png"));
		addStudent.setToolTipText("Dodavanje studenta");
		panel.add(addStudent);
		
		JButton editStudent = new JButton("");
		editStudent.setIcon(new ImageIcon("images/edit_stud.png"));
		editStudent.setToolTipText("Izmena studenta");
		panel.add(editStudent);
		
		JButton deleteStudent = new JButton("");
		deleteStudent.setIcon(new ImageIcon("images/delete1.png"));
		deleteStudent.setToolTipText("Brisanje studenta");
		panel.add(deleteStudent);
		
		addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(0,null);
				d.setVisible(true);
			}
			
		});
		
		editStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da izmenite .\n Moguca je samo pojedinacna izmena", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
				}
				}
			});
		
		deleteStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!TableStudent.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = TableStudent.getInstance().convertRowIndexToModel(TableStudent.getInstance().getSelectedRow());
						Student student = StudentskaBaza.getInstance().getRow(rowIndex);
				
							String poruka =("Da li ste sigurni da želite da obrišete "+student.getIme()+" "+student.getPrezime())+" ?";
				
								if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									ControllerStudent.getInstance().brisanjeStudenta(student);
								}else return;
				}
				else if(TableStudent.getInstance().getRowCount()==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Nema studenata za brisanje.", "Tabela je prazna", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da obrisete .\n Moguce je samo pojedinacno brisanje", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
				}
					
				
			}});
		
		}
	

}
