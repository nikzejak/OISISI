package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TabPredmet extends JPanel{

	public TabPredmet() {
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		JScrollPane jScrollPane = new JScrollPane();
		TablePredmet tablePredmet = TablePredmet.getInstance();
		this.add(jScrollPane, BorderLayout.CENTER);
		jScrollPane.setViewportView(tablePredmet);
	}
}
