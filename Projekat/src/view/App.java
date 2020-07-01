package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 
		 UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel");
		 
		 MainFrame.getInstance().setVisible(true);
	 }
}
