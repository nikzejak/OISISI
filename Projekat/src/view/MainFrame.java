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
		
		StudentToolbar studentToolbar = new StudentToolbar();
		studentToolbar.setFloatable(false);
		add(studentToolbar, BorderLayout.NORTH);
		ProfesorToolbar profesorToolbar = new ProfesorToolbar();
		profesorToolbar.setFloatable(false);
		PredmetToolbar predmetToolbar = new PredmetToolbar();
		predmetToolbar.setFloatable(false);
		
		StatusBar statBar = new StatusBar();
		getContentPane().add(statBar, BorderLayout.SOUTH);
        
        TabbedPane tabbedPane = new TabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void stateChanged(ChangeEvent e) {		
				int tab = tabbedPane.getSelectedIndex();
				menuBar.setTab(tab);
				if(tab == 0) {
					getContentPane().add(studentToolbar,  BorderLayout.NORTH);
					studentToolbar.show();
					profesorToolbar.hide();
					predmetToolbar.hide();
				}
				else if(tab == 1) {
					add(profesorToolbar, BorderLayout.NORTH);
					studentToolbar.hide();
					profesorToolbar.show();
					predmetToolbar.hide();
				}
				else {
					add(predmetToolbar, BorderLayout.NORTH);
					studentToolbar.hide();
					profesorToolbar.hide();
					predmetToolbar.show();
				}
				
			}
		});
		
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
