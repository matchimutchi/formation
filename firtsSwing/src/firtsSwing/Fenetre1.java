package firtsSwing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fenetre1 extends JFrame {
	
	//constructeur
	public Fenetre1() {
		super("Ma super fenetre");
		
		//configurer la taille de la fenetre
		setSize(400, 300);
		
		//centrer la fenetre le relativeTo centre automatique 
		setLocationRelativeTo(null);
		
		//demander a terminer le programme quand on ferme la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//flowLayout 
		// le bouton ne prendra pas tte la fenetre
		setLayout(new FlowLayout());
		
		
		JButton bouton1 = new JButton("cliquez moi");
		
		//ajouter le bouton dans la fenetre
		add(bouton1);
		
		//liste les action effectuer sur le bouton
		bouton1.addActionListener(e -> System.out.println("je suis cliqué!!!"));
		//Affiche un popup
		// null pour ne rien passer (les composants parent
		bouton1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Bonjour"));
		
		for(int i = 1; i <= 9;i++) {
			add(new JButton("bouton" + i));
		}
	}
}



