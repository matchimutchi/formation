	package firtsSwing;

	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;
	import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Fenetre2 extends JFrame implements ActionListener, DocumentListener{


		//constante
		public final static String LOAD_COMMAND = "load";
		public final static String SAVE_COMMAND = "save";
		
		
		private JButton boutonLoad;
		private JButton boutonSave;
		private JTextField nomFicher;
		private JTextArea contenuFichier;
		
		//Faire un menu
		private JMenuBar barreMenu;
		private JMenu menuFichier;
		private JMenu menuEdition;
		
		//constructeur
		public Fenetre2() {
			super("ma giga fenetre");
			
			setSize(500, 400);

			setLocationRelativeTo(null);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//defini cinq zone dans la fenetre ou placer un compsant
			//Ouest, Est , Nord, Sud, Centre
			setLayout(new BorderLayout());
			
			JPanel panelNord = new JPanel();
			BoxLayout layoutNord = new BoxLayout(panelNord, BoxLayout.X_AXIS);
			panelNord.setLayout(layoutNord);
			
			add(panelNord, BorderLayout.NORTH);
			
			//je rempli mon panel nord
			boutonLoad = new JButton("Chargement");
			panelNord.add(boutonLoad);
			boutonSave = new JButton("Sauvegarde");
			panelNord.add(boutonSave);
			nomFicher = new JTextField();
			panelNord.add(nomFicher);
			
			//ma fenetre(via actionPerformed) ecoute au click de ces deux boutons
			boutonLoad.addActionListener(this);
			//on declanche
			boutonLoad.setActionCommand(LOAD_COMMAND);
			boutonSave.addActionListener(this);
			//on declanche
			boutonSave.setActionCommand(SAVE_COMMAND);
			
			
			//on instancie l'objet contenuFichier
			contenuFichier = new JTextArea();
			//Scroll peut scroller dans la fenetre
			add(new JScrollPane(contenuFichier), BorderLayout.CENTER);
			
			
			
			
			//Creation du menu
			barreMenu = new JMenuBar();
			menuFichier = new JMenu("Fichier");
			
			//entree chargement
			JMenuItem charger = new JMenuItem("Chargement");
			charger.setActionCommand(LOAD_COMMAND);
			charger.addActionListener(this);
			menuFichier.add(charger);
			
			//entree sauvergarde du menu fichier
			JMenuItem sauver = new JMenuItem("sauvegarder");
			sauver.setActionCommand(SAVE_COMMAND);
			sauver.addActionListener(this);
			menuFichier.add(sauver);
			
			//ajout du menu fichier dans la barre de menu
			barreMenu.add(menuFichier);
			
			//activer la barre de menu pour notre fenetre
			setJMenuBar(barreMenu);
			
			//ecouter le changement de contenu du champ nomFicher
			nomFicher.getDocument().addDocumentListener(this);
			
			documentChanged(null);
			//vider le champ au debut
			//nomFicher.setText("");
			
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case LOAD_COMMAND:	
				chargerFichier();
				break;
			case SAVE_COMMAND:
				sauverFichier();
				break;
			}
			
		}
		
		
		private void sauverFichier() {
			String filename = nomFicher.getText();
			File f = new File(filename);
			try {
				PrintWriter pw = new PrintWriter(f);
				pw.print(contenuFichier.getText());
				pw.close();
				JOptionPane.showMessageDialog(null, "Sauvegarde effectuer");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "impossible d'écrire","erreur",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
		private void chargerFichier() {
			String filename = nomFicher.getText();
			File f = new File(filename);
			// canRead droit de lire le fichier
			//isFile verifie que ce soit un fochoer et pas un repertoire
			if(f.exists() && f.canRead() && f.isFile()) {
				try {
					Scanner reader = new Scanner(f);
					StringBuilder sb = new StringBuilder();
					while(reader.hasNext()) {
						sb.append(reader.nextLine()).append("\n");
					}
					reader.close();
					contenuFichier.setText(sb.toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "fichier non lisisble","erreur",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		private void documentChanged(DocumentEvent e) {
			String filename = nomFicher.getText();
			File f = new File(filename);
			if(f.exists() && f.isFile() && f.canRead()) {
				nomFicher.setBackground(Color.green);
				boutonLoad.setEnabled(true);
			}else {
				nomFicher.setBackground(Color.pink);
				boutonLoad.setEnabled(false);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {documentChanged(e);}

		@Override
		public void removeUpdate(DocumentEvent e) {documentChanged(e);}

		@Override
		public void changedUpdate(DocumentEvent e) {documentChanged(e);}

}
