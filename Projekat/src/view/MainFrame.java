package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.PredmetskaBaza;
import model.ProfesorskaBaza;
import model.StudentskaBaza;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4*3, screenHeight/4*3);
        setLocationRelativeTo(null);
        setTitle("Studentska sluzba");
        
        MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);
        
        TabbedPane tabbedPane = new TabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				PredmetskaBaza.getInstance().deserijalizacijaPredmeta();
				ProfesorskaBaza.getInstance().deserijalizacijaProfesora();
				StudentskaBaza.getInstance().deserijalizacijaStudenata();
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				PredmetskaBaza.getInstance().serijalizacijaPredmeta();
				ProfesorskaBaza.getInstance().serijalizacijaProfesora();
				StudentskaBaza.getInstance().serijalizacijaStudenata();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
}
