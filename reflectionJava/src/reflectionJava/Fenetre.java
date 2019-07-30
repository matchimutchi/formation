package reflectionJava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener{
	
	//instancier l'objet
	public static final String INSTANCIER_COMMAND = "new";
	public static final String REQUETTER_COMMAND = "requetter";
	private JTextField className;
	private JButton instancier;
	private JButton requetter;
	//composant graphique d'une liste
	private JList<Object> myBeans;
	//le compartiment de la liste
	private DefaultListModel<Object> myBeansData;
	
	private Connection base;
	
	
	public Fenetre() {
		super("instanciator!");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel panelHaut = new JPanel();
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		
		className = new JTextField(70);
		panelHaut.add(className);
		
		
		instancier = new JButton("Instancier");
		instancier.setActionCommand(INSTANCIER_COMMAND);
		panelHaut.add(instancier);
		
		add(panelHaut, BorderLayout.NORTH);
		
		
		//---------INSTANCIER JLIST--------------
		myBeansData = new DefaultListModel<>();
		myBeans = new JList<>(myBeansData);
		
		//----Gére le dépasement
		add(new JScrollPane(myBeans), BorderLayout.CENTER);
		
		instancier.addActionListener(this);
		
		
		//sql requettage
		try {
			Class.forName("com.mysql.jdbc.Driver");
			base = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_java2", "root", "");
			
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		
		requetter = new JButton("requetter produits");
		panelHaut.add(requetter);
		requetter.setActionCommand(REQUETTER_COMMAND);
		requetter.addActionListener(this);
	}


	//methode actionlistener
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case INSTANCIER_COMMAND:
			instanciate();
			break;
		case REQUETTER_COMMAND:
			requetter_action();
			break;
		}
		
	}
	
	
	public void requetter_action() {
		try {
			DynamicDao<Produit> dao = new DynamicDao<>(base, Produit.class);
			List<Produit> produits = dao.findAll();
			for(Produit p : produits) {
				myBeansData.addElement(p);
			}
		} 
		catch (NoSuchMethodException e) {e.printStackTrace();} 
		catch (SecurityException e) {e.printStackTrace();}
	}
	public void  instanciate() {
		try {
			Class clazz = Class.forName(className.getText());
			myBeansData.clear();
			myBeansData.addElement("Nom classe = " + clazz.getSimpleName());
			myBeansData.addElement("Nom package = " + clazz.getPackage().getName());
			
			//------------liste des setter de l'objet-------------------------
			ArrayList<Method> setters = new ArrayList<>();
			
			//permet de selection que les setters
			for(Method m : clazz.getDeclaredMethods()) {
				//si ce n'est pas public cela ne nous intérrese pas
				if(!Modifier.isPublic(m.getModifiers())) {
					continue;
				}
				
				if(Modifier.isStatic(m.getModifiers())) {
					continue;
				}
				//on ne veut que les methodes qui ont qu'un parametre
				Class[] params = m.getParameterTypes();
				if(params.length != 1) {
					continue;
				}
				if(m.getName().startsWith("set")) {
					//c'est bon, c'est un setter valide
					setters.add(m);
				}
				//myBeansData.addElement("Méthode = " + m.getName());
			}
			
			//j'instancie l'objet vide
			Object instance = clazz.newInstance();
			
			//j'affiche mes setters
			for(Method m : setters) {
				String saisie = JOptionPane.showInputDialog(null, "Valeur pour " + m.getName()
											+ " de type " + m.getParameterTypes()[0].getSimpleName());
						
				//myBeansData.addElement(m.getName());
				if(m.getParameterTypes()[0].equals(String.class)) {
					//set d'une chaine de caractere
					//invoke appele la methode
					m.invoke(instance, saisie);
					
				}
				if(m.getParameterTypes()[0].equals(double.class)) {
					//set d'une valeur double
					m.invoke(instance, Double.parseDouble(saisie));
					
				}
				
				if(m.getParameterTypes()[0].equals(int.class)) {
					//set d'un entier
					m.invoke(instance, Integer.parseInt(saisie));
					
				}
				
			}
			
			//j'ajouter mon bean instancier dans la liste
			myBeansData.addElement(instance);
	
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (InstantiationException e) {e.printStackTrace();} 
		catch (IllegalAccessException e) {e.printStackTrace();} 
		catch (IllegalArgumentException e) {e.printStackTrace();} 
		catch (InvocationTargetException e) {e.printStackTrace();}
	}
}
