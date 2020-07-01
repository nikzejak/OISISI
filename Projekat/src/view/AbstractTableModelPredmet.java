package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.PredmetskaBaza;

public class AbstractTableModelPredmet extends AbstractTableModel{

	public static String kolonaStudenti = "Studenti";
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return PredmetskaBaza.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return PredmetskaBaza.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (columnIndex < 5)
			return PredmetskaBaza.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 5) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		if (column >= PredmetskaBaza.getInstance().getColumnCount()) {
			return kolonaStudenti;
		}
		return PredmetskaBaza.getInstance().getColumnName(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex >= 5;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}
	}
	
	

}
