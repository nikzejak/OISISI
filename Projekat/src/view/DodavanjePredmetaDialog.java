package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerPredmet;
import model.Godina;
import model.Predmet;
import model.PredmetskaBaza;
import model.Semestar;

public class DodavanjePredmetaDialog extends JDialog {
	
	public DodavanjePredmetaDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/3);
		setSize(d);
		
		this.setTitle("Dodavanje predmeta");
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gbLayout);
		
		JLabel sifraLabel = new JLabel("Sifra");
		sifraLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField sifraTextField = new JTextField();
		sifraTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sifraTextField.setColumns(15);
		
		JPanel unosSifre = new JPanel();
		unosSifre.add(sifraLabel);
		unosSifre.add(sifraTextField);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		unosSifre.setBackground(Color.WHITE);
		this.add(unosSifre, c);
		
		JLabel nazivLabel = new JLabel("Naziv");
		nazivLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JTextField nazivTextField = new JTextField();
		nazivTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nazivTextField.setColumns(15);
		
		JPanel unosNaziva = new JPanel();
		unosNaziva.add(nazivLabel);
		unosNaziva.add(nazivTextField);
		c.gridx = 0;
		c.gridy = 1;
		unosNaziva.setBackground(Color.WHITE);
		this.add(unosNaziva, c);
		
		JLabel semestarLabel = new JLabel("Semestar");
		semestarLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<Semestar> semestarComboBox = new JComboBox<Semestar>(Semestar.values());
		
		JPanel unosSemestra = new JPanel();
		unosSemestra.add(semestarLabel);
		unosSemestra.add(semestarComboBox);
		c.gridx = 0;
		c.gridy = 2;
		unosSemestra.setBackground(Color.WHITE);
		this.add(unosSemestra, c);
		
		JLabel godinaLabel = new JLabel("Godina Studija");
		godinaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<Godina> godinaComboBox = new JComboBox<Godina>(Godina.values());
		
		JPanel unosGodine = new JPanel();
		unosGodine.add(godinaLabel);
		unosGodine.add(godinaComboBox);
		c.gridx = 0;
		c.gridy = 3;
		unosGodine.setBackground(Color.WHITE);
		this.add(unosGodine, c);
		
		JButton btnOdustanak = new JButton("Odustanak");
		btnOdustanak.setForeground(Color.BLACK);
		btnOdustanak.setBackground(Color.WHITE);
		
		JButton btnPotvrda = new JButton("Potvrda");
		btnPotvrda.setForeground(Color.BLACK);
		btnPotvrda.setBackground(Color.WHITE);
		btnPotvrda.setEnabled(false);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnOdustanak);
		buttonPanel.add(btnPotvrda);
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.SOUTHEAST;
		c.fill = GridBagConstraints.NONE;
		buttonPanel.setBackground(Color.WHITE);
		this.add(buttonPanel, c);
		
		btnOdustanak.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnOdustanak.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOdustanak.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});

		btnPotvrda.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnPotvrda.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPotvrda.setBackground(Color.LIGHT_GRAY);	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String semestar = semestarComboBox.getSelectedItem().toString();
				Semestar semestar1 = Semestar.valueOf(semestar);
				
				String godina = godinaComboBox.getSelectedItem().toString();
				Godina godina1 = Godina.valueOf(godina);
				
				for(Predmet p : PredmetskaBaza.getInstance().getPredmeti()) {
					if(sifraTextField.getText().equals(p.getSifra())) {
						JOptionPane.showMessageDialog(null, "Vec postoji predmet sa sifrom: " + sifraTextField.getText(), "Greška!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				ControllerPredmet.getInstance().dodavanjePredmetaUTabelu(sifraTextField.getText(), nazivTextField.getText(), semestar1, godina1);
				
				dispose();
			}
	});

		KeyListener myKeyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(sifraTextField.getText().trim().length() > 0 && nazivTextField.getText().trim().length() > 0) {
					btnPotvrda.setEnabled(true);
				}else btnPotvrda.setEnabled(false);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		sifraTextField.addKeyListener(myKeyListener);
		nazivTextField.addKeyListener(myKeyListener);
		
		
	}
	
}
