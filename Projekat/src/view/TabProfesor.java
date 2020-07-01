package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TabProfesor extends JPanel{

	TabProfesor(){
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		JScrollPane jScrollPane = new JScrollPane();
		TableProfesor tableProfesor = TableProfesor.getInstance();
		this.add(jScrollPane, BorderLayout.CENTER);
		jScrollPane.setViewportView(tableProfesor);
	}
}
