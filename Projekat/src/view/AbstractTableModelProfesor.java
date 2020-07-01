package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.ProfesorskaBaza;

public class AbstractTableModelProfesor extends AbstractTableModel{

	public static String kolonaPredmeti = "Predmeti";
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ProfesorskaBaza.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ProfesorskaBaza.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex < 10) {
			return ProfesorskaBaza.getInstance().getValueAt(rowIndex, columnIndex);
		}else if(columnIndex == 10){
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
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		if(column >= ProfesorskaBaza.getInstance().getColumnCount()) {
			return kolonaPredmeti;
		}else return ProfesorskaBaza.getInstance().getColumnName(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex >= 10;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		super.setValueAt(value, rowIndex, columnIndex);
		if(columnIndex != 10) return;
	}

	
}
