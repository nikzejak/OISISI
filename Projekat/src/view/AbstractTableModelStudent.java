package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.StudentskaBaza;

public class AbstractTableModelStudent extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return StudentskaBaza.getInstance().getColumnCount() ;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return StudentskaBaza.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		if (arg1 < 7)
			return StudentskaBaza.getInstance().getValueAt(arg0, arg1);
		else if (arg1 == 7) {
			JButton btn = new JButton("" + arg0);
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
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return StudentskaBaza.getInstance().getColumnName(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex >= 7;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		super.setValueAt(value, rowIndex, columnIndex);
		if (columnIndex != 7) {
			return;
		}
	}

	
}
