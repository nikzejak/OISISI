package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Profesor;
import model.ProfesorskaBaza;

public class ButtonColumnProfesori extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	private JButton renderButton;
	private JButton editorButton;
	private JTable table; 
	
	
	public ButtonColumnProfesori(JTable table, int column) {
		
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.renderButton = new JButton("Prikaži");
		this.editorButton = new JButton("Prikaži");
	
		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = TableProfesor.getInstance().convertRowIndexToModel(TableProfesor.getInstance().getSelectedRow());
				Profesor prof = ProfesorskaBaza.getInstance().getRow(rowIndex);
				
				PrikazPredmeta d = new PrikazPredmeta(prof);
				d.setVisible(true);
			}
		});
		
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		return new TablePanelProfesor(this.renderButton);
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		return new TablePanelProfesor(this.editorButton);
	}

}
