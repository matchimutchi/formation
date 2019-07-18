package validationtext;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MaFenetre extends JFrame {

	
		private JTextField champRegex;
		private JTextField champValidation;
		
		// une expression reguliere c'est un motif de texte a reconnaitre
		// "toto" -> "toto"
		//"t.to" ->"toto", "tato" , "trto" etc...
		//"to+" -> "to", "too", "tooo" ( +1 n fois ce qui precede immediatement
		// "to*" -> 0 à n fois -> "t","to","too"
		// "to?" -> 0 à 1 fois -> "t" ou "to"
		//"to{2,4}" -> 2 à 4 fois -> "too","tooo","tooo"
		// "pa(ri)+" -> "pari", "pariri","paririri"
		//"p[aeiou]" -> "pa", "pe", "pi"
		//"p[a-z]" -> "pa", "pb" .... "pz"
		// [a-zA-Z0-9]
		//[.] --> "."
		//[^a-zA-Z] --> n'importe quelle caractere seud de a à z
		// ^-> début du motif et $ -> fin du motif
		//^to -> "toti" ok "atoti"
		//(ti | to) -> "ti" ou "to"
		
		// code postale simple => [0-9] {5}
		// telephone => 015223366478           OK 
		//				01 52 36 64 78         OK
		//				01.52.36.64.78         OK
		//				0a 52 36 64 78         ko
		// 				01..52 36..64..78       ko
		// email => vincent.courtalon@gm.com    OK
		//		 => toto@yahoo.fr               OK
		//       => bob@@eponde.com             KO
		//       => bob                          KO
		//       => bob..eponge@.com 			KO
		private Pattern regex;
		
		public MaFenetre() {
			super("validator");
			
			//Matcher m = Pattern.compile("");
			
			
			
			setSize(300,100);
			
			setLocationRelativeTo(null);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
			setLayout(layout);
			
			champRegex = new JTextField();
			add(champRegex);
			champValidation = new JTextField();
			add(champValidation);
			
			champRegex.getDocument().addDocumentListener(new DocumentListener() {
				
				private void valider(DocumentEvent e) {
					try {
					regex = Pattern.compile(champRegex.getText());
					champRegex.setBackground(Color.green);
					
					}
					catch(PatternSyntaxException ex){
						regex = null;
						champRegex.setBackground(Color.pink);
					}
					validerTexte(e);
				}
				@Override
				public void removeUpdate(DocumentEvent e){valider(e);}
				
				@Override
				public void insertUpdate(DocumentEvent e){valider(e);}

				@Override
				public void changedUpdate(DocumentEvent e){valider(e);}
			});
			
			//champRegex.setText("[0-9]+");
			//champRegex.setText("[0-9]{2}([. ]?[0-9]{2}){4}");
			//champRegex.setText("[0-9]{2}(([0-9]{2}){4}|([ 0-9]{2}){4}|([.0-9]{2}){4}");
			champRegex.setText("[a-zA-Z0-9]+([.][a-zA-Z0-9]+)*@[a-zA-Z0-9]++([.][a-zA-Z0-9]+)*([.][a-zA-Z0-9]{2,4})");
			
			champValidation.getDocument().addDocumentListener(new DocumentListener(){
				

				@Override
				public void removeUpdate(DocumentEvent e){validerTexte(e);}
				
				@Override
				public void insertUpdate(DocumentEvent e){validerTexte(e);}

				@Override
				public void changedUpdate(DocumentEvent e){validerTexte(e);}
			});
			
			//champValidation.setText("75016");
			//champValidation.setText("015223366478");
			champValidation.setText("vincent.courtalon@gm.com");
		}
		
		private void validerTexte(DocumentEvent e) {
			if(regex == null) {
				champValidation.setBackground(Color.yellow);
			}
			else {
				if(regex.matcher(champValidation.getText()).matches()) {
					champValidation.setBackground(Color.green);
				}
				else {
					champValidation.setBackground(Color.pink);
					
				}
			}
		}
}
