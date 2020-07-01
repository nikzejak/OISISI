package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Predmet;
import model.PredmetskaBaza;

public class ButtonColumnPredmeti extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	private JButton renderButton;
	private JButton editorButton;
	private JTable table; 
	
	public ButtonColumnPredmeti(JTable table, int column) {
		
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.renderButton = new JButton("Prika�i");
		this.editorButton = new JButton("Prika�i");
	
		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int rowIndex = TablePredmet.getInstance().convertRowIndexToModel(TablePredmet.getInstance().getSelectedRow());
				Predmet predmet = PredmetskaBaza.getInstance().getPredmeti().get(rowIndex);
				if(!predmet.getStudenti().isEmpty())
				{	
					PrikazStudenata ps=new PrikazStudenata(predmet);
					ps.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Za izabrani predmet nema studenata","", JOptionPane.INFORMATION_MESSAGE);
				}


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
		return new TablePanelPredmet(this.renderButton);
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		return new TablePanelPredmet(this.editorButton);
	}

}
