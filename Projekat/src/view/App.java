package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {

	 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 
		 String s = "de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel";
		 String s2 = "de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel";
		 
		 UIManager.setLookAndFeel(s2);
		 
		 MainFrame.getInstance().setVisible(true);
	 }
}
