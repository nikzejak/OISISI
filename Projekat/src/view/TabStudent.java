package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TabStudent extends JPanel{

	public TabStudent() {
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		JScrollPane jScrollPane= new JScrollPane();
		TableStudent tableStudent = TableStudent.getInstance();
		this.add(jScrollPane, BorderLayout.CENTER);
		jScrollPane.setViewportView(tableStudent);
	}
}
