package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControllerStudent;
import model.Godina;
import model.Profesor;
import model.Status;
import model.Student;
import model.StudentskaBaza;

	public class DodavanjeStudentaDijalog extends JDialog{

		private JLabel lIme;
		private JLabel lPrezime;
		private JLabel lDatum;
		private JLabel lAdresa;
		private JLabel lTelefon;
		private JLabel lIndex;
		private JLabel lGodina;
		private JLabel lProsek;
		private JLabel lblNewLabel_5;
		
		private JTextField tIme;
		private JTextField tPrezime;
		private JTextField tDatum;
		private JTextField tAdresa;
		private JTextField tTelefon;
		private JTextField tIndex;
		private JTextField tProsek;
		private JTextField textField_5;
		
		private JComboBox cbGodina;
		
		private JRadioButton rbBudzet;
		private JRadioButton rbFinansiranje;
		
		private JPanel p1;
		private JPanel p2;
		private JPanel p3;
		private JPanel p4;
		private JPanel p5;
		private JPanel p6;
		private JPanel p7;
		private JPanel p8;
		private JPanel p9;
		private JPanel p10;
		private JPanel p12;
		private JPanel panel_6;
		
		private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		public DodavanjeStudentaDijalog(int i,Student s) {
			
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension d = new Dimension();
			d = kit.getScreenSize();
			d.setSize(d.width/3, d.height*3/4);
			setSize(d);
			this.setModal(true);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			getContentPane().setBackground(Color.WHITE);
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] {10};
			gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{1.0};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			getContentPane().setLayout(gridBagLayout);
			
			//ime
			p1=new JPanel();
			p1.setBackground(Color.WHITE);
			GridBagConstraints gbc_p = new GridBagConstraints();
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(30, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 0;
			getContentPane().add(p1, gbc_p);
			GridBagLayout gbl_p1 = new GridBagLayout();
			gbl_p1.columnWidths = new int[]{10, 0, 0};
			gbl_p1.rowHeights = new int[]{0, 0};
			gbl_p1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p1.setLayout(gbl_p1);
			
			lIme = new JLabel("Ime*");
			lIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p1.add(lIme, gbc_lblNewLabel);
			lIme.setHorizontalAlignment(SwingConstants.LEFT);
			
			if(i==0)
				tIme = new JTextField();
			else
				tIme= new JTextField(s.getIme());
			
			tIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p1.add(tIme, gbc_textField);
			tIme.setColumns(10);
			
			//Prezime	

			p2 = new JPanel();
			p2.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 1;
			getContentPane().add(p2, gbc_p);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{10, 0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p2.setLayout(gbl_panel_2);
			
			lPrezime = new JLabel("Prezime*");
			lPrezime.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(10, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p2.add(lPrezime, gbc_lblNewLabel);
			lPrezime.setHorizontalAlignment(SwingConstants.LEFT);
			
			if(i==0)
				tPrezime = new JTextField();
			else
				tPrezime= new JTextField(s.getPrezime());
			
			tPrezime.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(10, 0, 0, 0);
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p2.add(tPrezime, gbc_textField);
			tPrezime.setColumns(10);
			
			//Datum
			
			p3 = new JPanel();
			p3.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 2;
			getContentPane().add(p3, gbc_p);
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{10, 0, 0};
			gbl_panel_3.rowHeights = new int[]{0, 0};
			gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p3.setLayout(gbl_panel_3);
			
			lDatum = new JLabel("Datum rodjenja*(dd/MM/yyyy)");
			lDatum.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p3.add(lDatum, gbc_lblNewLabel);
			
			
			if(i==0)
				tDatum = new JTextField();
			else
				tDatum= new JTextField(sdf.format(s.getDatumRodj()));
			
			tDatum.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p3.add(tDatum, gbc_textField);
			tDatum.setColumns(10);
			
			//Adresa
			
			p4 = new JPanel();
			p4.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 3;
			getContentPane().add(p4, gbc_p);
			GridBagLayout gbl_p4 = new GridBagLayout();
			gbl_p4.columnWidths = new int[]{10, 0, 0};
			gbl_p4.rowHeights = new int[]{0, 0};
			gbl_p4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p4.setLayout(gbl_p4);
			
			lAdresa = new JLabel("Adresa stanovanja*");
			lAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p4.add(lAdresa, gbc_lblNewLabel);
			
			if(i==0)
				tAdresa = new JTextField();
			else
				tAdresa= new JTextField(s.getAdresaStanovanja());
			
			tAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p4.add(tAdresa, gbc_textField);
			tAdresa.setColumns(10);
			
			
			//Broj telefona
			
			p5 = new JPanel();
			p5.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 4;
			getContentPane().add(p5, gbc_p);
			GridBagLayout gbl_p5 = new GridBagLayout();
			gbl_p5.columnWidths = new int[]{10, 0, 0};
			gbl_p5.rowHeights = new int[]{0, 0};
			gbl_p5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p5.setLayout(gbl_p5);
			
			lTelefon = new JLabel("Broj telefona*");
			lTelefon.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p5.add(lTelefon, gbc_lblNewLabel);
			
			if(i==0)
				tTelefon = new JTextField();
			else
				tTelefon= new JTextField(s.getTelefon());
			
			tTelefon.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p5.add(tTelefon, gbc_textField);
			tTelefon.setColumns(10);
			
			
			//Email
			panel_6 = new JPanel();
			panel_6.setBackground(Color.WHITE);
			GridBagConstraints gbc_panel_6 = new GridBagConstraints();
			gbc_panel_6.fill = GridBagConstraints.BOTH;
			gbc_panel_6.insets = new Insets(10, 40, 10, 40);
			gbc_panel_6.gridx = 0;
			gbc_panel_6.gridy = 5;
			getContentPane().add(panel_6, gbc_panel_6);
			GridBagLayout gbl_panel_6 = new GridBagLayout();
			gbl_panel_6.columnWidths = new int[]{10, 0, 0};
			gbl_panel_6.rowHeights = new int[]{0, 0};
			gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_6.setLayout(gbl_panel_6);
			
			lblNewLabel_5 = new JLabel("E-mail");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 0;
			panel_6.add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			if(i==0)
				textField_5 = new JTextField();
			else {
				textField_5= new JTextField(s.getEmail());
				textField_5.setEditable(false);
			}
			textField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 1;
			gbc_textField_5.gridy = 0;
			panel_6.add(textField_5, gbc_textField_5);
			textField_5.setColumns(10);
			
			//Broj indeksa

			p6 = new JPanel();
			p6.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 6;
			getContentPane().add(p6, gbc_p);
			GridBagLayout gbl_p6 = new GridBagLayout();
			gbl_p6.columnWidths = new int[]{10, 0, 0};
			gbl_p6.rowHeights = new int[]{0, 0};
			gbl_p6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p6.setLayout(gbl_p6);
			
			lIndex = new JLabel("Broj indeksa*");
			lIndex.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p6.add(lIndex, gbc_lblNewLabel);
			
			if(i==0)
				tIndex = new JTextField();
			else
				{
					tIndex= new JTextField(s.getIndeks());
					tIndex.setEditable(false);
				}
			
			tIndex.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p6.add(tIndex, gbc_textField);
			tIndex.setColumns(10);
			
			//Prosek

			p12 = new JPanel();
			p12.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 7;
			getContentPane().add(p12, gbc_p);
			GridBagLayout gbl_p12 = new GridBagLayout();
			gbl_p12.columnWidths = new int[]{10, 0, 0};
			gbl_p12.rowHeights = new int[]{0, 0};
			gbl_p12.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p12.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p12.setLayout(gbl_p12);
			
			lProsek = new JLabel("Prosecna ocena*");
			lProsek.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p12.add(lProsek, gbc_lblNewLabel);
			
			if(i==0)
				tProsek = new JTextField();
			else
				{
					tProsek= new JTextField(s.getProsek().toString());
				}
			
			tProsek.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			p12.add(tProsek, gbc_textField);
			tProsek.setColumns(10);
			
			//Godina studija
			
			p7 = new JPanel();
			p7.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 8;
			getContentPane().add(p7, gbc_p);
			GridBagLayout gbl_p7 = new GridBagLayout();
			gbl_p7.columnWidths = new int[]{10, 0, 0};
			gbl_p7.rowHeights = new int[]{0, 0};
			gbl_p7.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p7.setLayout(gbl_p7);
			
			lGodina = new JLabel("Trenutna godina studiranja*");
			lGodina.setFont(new Font("Tahoma", Font.PLAIN, 12));
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			p7.add(lGodina, gbc_lblNewLabel);
			
			
			cbGodina=new JComboBox<Godina>(Godina.values());
			if(i==1)
				cbGodina.setSelectedItem(s.getGodinaStudija());
			cbGodina.setBackground(Color.WHITE);
			cbGodina.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.gridx = 1;
			gbc_comboBox_1.gridy = 0;
			p7.add(cbGodina, gbc_comboBox_1);
			
			//Status
			
			p8=new JPanel();
			p8.setBackground(Color.WHITE);
			gbc_p.fill = GridBagConstraints.BOTH;
			gbc_p.insets = new Insets(10, 40, 10, 40);
			gbc_p.gridx = 0;
			gbc_p.gridy = 9;
			gbc_p.gridheight=2;
			getContentPane().add(p8, gbc_p);
			GridBagLayout gbl_p8 = new GridBagLayout();
			gbl_p8.columnWidths = new int[]{10, 0, 0};
			gbl_p8.rowHeights = new int[]{0, 0};
			gbl_p8.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_p8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			p8.setLayout(gbl_p8);
			
			ButtonGroup bg=new ButtonGroup();    
			
				if(i==1)
					{
					if(s.getStatus()==Status.S)
					{
						rbBudzet=new JRadioButton("Budzet",false);
						rbFinansiranje= new JRadioButton("Samofinansiranje",true);
						}
					else
					{
						rbBudzet=new JRadioButton("Budzet",true);
						rbFinansiranje= new JRadioButton("Samofinansiranje",false);
						}
					}
				else if(i==0)
					{
						rbBudzet=new JRadioButton("Budzet",true);
						rbFinansiranje= new JRadioButton("Samofinansiranje",false);
					}
			rbBudzet.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rbBudzet.setBackground(Color.WHITE);

			rbFinansiranje.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rbFinansiranje.setBackground(Color.WHITE);
			bg.add(rbBudzet);
			bg.add(rbFinansiranje);
			GridBagConstraints gbc_rb_1 = new GridBagConstraints();
			gbc_rb_1.gridx=0;
			gbc_rb_1.gridy=0;
			gbc_rb_1.anchor=GridBagConstraints.WEST;
			p8.add(rbBudzet,gbc_rb_1);
			gbc_rb_1.gridx=0;
			gbc_rb_1.gridy=1;
			gbc_rb_1.anchor=GridBagConstraints.WEST;
			p8.add(rbFinansiranje,gbc_rb_1);
			
			//dugmad
			
			p9 = new JPanel();
			p9.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) p9.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 10, 30);
			gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 12;
			getContentPane().add(p9, gbc_panel);
			
			
			
			JButton btnOdustanak = new JButton("Odustanak");
			btnOdustanak.setForeground(Color.BLACK);
			btnOdustanak.setBackground(Color.WHITE);
			btnOdustanak.setFont(new Font("Tahoma", Font.BOLD, 12));
			p9.add(btnOdustanak);
			
			p10 = new JPanel();
			p10.setBorder(null);
			p10.setBackground(Color.WHITE);
			p9.add(p10);
			
			JButton btnPotvrda = new JButton("Potvrda");
			btnPotvrda.setForeground(Color.BLACK);
			btnPotvrda.setBackground(Color.WHITE);
			btnPotvrda.setFont(new Font("Tahoma", Font.BOLD, 12));
			p9.add(btnPotvrda);
			
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
					// TODO Auto-generated method stubs
			       if (!(tIme.getText().trim().isEmpty()||tPrezime.getText().trim().isEmpty()||tDatum.getText().trim().isEmpty()||tAdresa.getText().trim().isEmpty()||tTelefon.getText().trim().isEmpty()||tIndex.getText().trim().isEmpty()||tProsek.getText().trim().isEmpty())) {
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
						Date datumRodjenja=null;
						Double prosek=0.0;
						if(i==0)
								for(Student s: StudentskaBaza.getInstance().getStudenti()) {
									if(tIndex.getText().toLowerCase().equals(s.getIndeks().toLowerCase() )) {
										JOptionPane.showMessageDialog(null,"Već postoji student sa brojem indeksa " + tIndex.getText(), "Greška",JOptionPane.ERROR_MESSAGE);
										return;
									}
								}
						try {
						prosek=Double.parseDouble(tProsek.getText().trim()); 
						} catch(NumberFormatException exception) {
						    System.out.println("Prosek mora biti realan broj");
						}
						
						try {
							datumRodjenja = sdf.parse(tDatum.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Unesite u obliku (dd/mm/yyyy)", "Pogresno unet datum!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
							return;
						}
						
						Status status;
						Godina godinaStudija = (Godina)cbGodina.getSelectedItem();
						
						if(rbBudzet.isSelected())
							status=Status.B;
						else
							status=Status.S;
						Student student;
						student= new Student(tIme.getText(), tPrezime.getText(),datumRodjenja, tAdresa.getText(), tTelefon.getText(), textField_5.getText(), tIndex.getText(),Calendar.getInstance().getTime(), godinaStudija,status, prosek);
						if(i==0)
						{
							ControllerStudent.getInstance().dodajStudenta(student);
						}
						else if(i==1)
							ControllerStudent.getInstance().izmeniStudenta(student);
				}
				else 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Popunite sva obavezna polja", "Obavezna polja nisu popunjena!", JOptionPane.ERROR_MESSAGE);
				}
			       for(Student s: StudentskaBaza.getInstance().getStudenti()) {
						System.out.println(s.toString());
					}
				
				dispose();
				}
				});
			
			
			if(i==0) {
				this.setName("Dodavanje studenta");
				this.setTitle("Dodavanje studenta");
			}
			else {
				this.setName("Izmena studenta");
				this.setTitle("Izmena studenta");
			}
		
		}
		
	
}
