package com.edugroupe.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.edugroupe.firstjdbc.dao.ActeurDAO;
import com.edugroupe.firstjdbc.metier.Acteur;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    			try {
    				//driver mysql s'enregistre a son chargement auprés du driverManager
    				Class.forName("com.mysql.jdbc.Driver");
    				//ouvrir une connexion à la base
    				Connection base = DriverManager.getConnection(
    						"jdbc:mysql://localhost:3306/base_java1", 
    						"root", 
    						"");

    				System.out.println("Nous somme connecté  à la base");
    				
    				System.out.println("------------------Afficher la liste des  acteurs------------");
    				//instanciation du dao des acteurs
    				//cette objet permettra de requetter les acteurs dans la base
    				ActeurDAO acteurDAO = new ActeurDAO(base);
    				
    				
    				Scanner reader = new Scanner(System.in);
    				
    				while(true) {
    					System.out.println("Que souhaitez-vous faire?");
    					System.out.println("1- Lister les acteurs");
    					System.out.println("2- Editer un acteur");
    					System.out.println("3- Créer un acteur");
    					System.out.println("4- Effacer un acteur");
    					System.out.println("5- Quitter");
    					
    					int choix = Integer.parseInt(reader.nextLine());
    					switch (choix) {
						case 1:
							listerActeur(acteurDAO);
							break;
						case 2:
							editerActeur(acteurDAO);
							break;
						case 3:
							insererActeur(acteurDAO);
							break;
						case 4:
							deleteActeur(acteurDAO);
							break;
						}
    					//si choix est 5, on sort du while
    					if(choix == 5) {
    						System.out.println("BYE");
    						break;
    					}
    					
    				}
    				
    				//on demande la liste de tous les acteurs de la base
    				//le dao nous le fournit sous la forma d'une liste d'objet metier Acteur
    				/*List<Acteur> acteurs = acteurDAO.findAll();
    				
    				//on affiche les acteurs en question
    				acteurs.stream().forEach(b -> System.out.println(b));
    				
    				System.out.println("\n");
    				System.out.println("------------------Afficher un acteur------------");
    				//afficher un acteur
    				Acteur acteur = acteurDAO.findOne(3);
    				System.out.println(acteur);*/
    				
    				base.close();
	
    			} catch (ClassNotFoundException e) {
    				e.printStackTrace();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    }
    
    private static void listerActeur(ActeurDAO acteurDAO) {
    	acteurDAO.findAll().stream().forEach(a -> System.out.println(a));
    }
    
    private static void editerActeur(ActeurDAO acteurDAO) {
    	listerActeur(acteurDAO);
    	System.out.println("Quel acteur editer(id) ?");
    	Scanner reader = new Scanner(System.in);
    	int id = Integer.parseInt(reader.nextLine());
    	
    	//on récupére l'acteur a éditer
    	Acteur a = acteurDAO.findOne(id);
    	if(a == null) {
    		System.out.println("acteur inconnu");
    		return;
    	}
    	
    	System.out.println("nouveau nom(vide pour ne pas changer '" +a.getNom() + "') ?");
    	String saisie = reader.nextLine();
    	if(saisie.length() > 0) {
    		a.setNom(saisie);
    	}
    	
    	System.out.println("nouveau prenom(vide pour ne pas changer '" +a.getPrenom() + "') ?");
    	saisie = reader.nextLine();
    	if(saisie.length() > 0) {
    		a.setPrenom(saisie);
    	}
    	
    	System.out.println("nouveau email(vide pour ne pas changer '" +a.getEmail() + "') ?");
    	saisie = reader.nextLine();
    	if(saisie.length() > 0) {
    		a.setEmail(saisie);
    	}
    	acteurDAO.save(a);
    }
    
    
    private static void insererActeur(ActeurDAO acteurDAO) {

    	Scanner reader = new Scanner(System.in);

    	Acteur a = new Acteur();
    	
    	
    	System.out.println("nouveau nom ?");
    	String saisie = reader.nextLine();
    	a.setNom(saisie);
    	System.out.println("nouveau prénom ?");
    	saisie = reader.nextLine();
    	a.setPrenom(saisie);
    	System.out.println("nouveau email ?");
    	saisie = reader.nextLine();
    	a.setEmail(saisie);
    	
    	
    	acteurDAO.save(a);
    }
    
    private static void deleteActeur(ActeurDAO acteurDAO) {

    	Scanner reader = new Scanner(System.in);

    	listerActeur(acteurDAO);

    	System.out.println("Quel est l'id de l'acteur à supprimer ?");
    	int id = Integer.parseInt(reader.nextLine());
    	acteurDAO.delete(id);
    }
    
}
