package com.edugroupe.springjdbc.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edugroupe.springjdbc.beans.ProduitDAO;
import com.edugroupe.springjdbc.beans.iProduitDAO;
import com.edugroupe.springjdbc.metier.Produit;





public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
   
        System.out.println("-----------------LISTE DE TT LES PRODUITS---------------------");
      ProduitDAO produitDAO = ctx.getBean("produitDAO", ProduitDAO.class);
        
        List<Produit> produits = produitDAO.findAll();
        produits.stream().forEach(p -> System.out.println(p));
        
        System.out.println("-----------------UN PRODUIT---------------------");
        
        Produit p2 = produitDAO.findById(2);
        System.out.println("Produits no2 -> " + p2);

        
        System.out.println("-----------------INSERER UN PRODUIT---------------------");
        System.out.println("Veux tu rajouter un produit oui ou non?");
        String str = input.nextLine();
        str = "oui";
        if(str.equals("oui")) {
        System.out.println("Nom du nouveau produit?");
        String nom = input.nextLine();
        
        System.out.println("Quel est le prix?");
        double prix = Double.parseDouble(input.nextLine());

        System.out.println("Quel est le poid?");
        double poids = Double.parseDouble(input.nextLine());
        
        produitDAO.save(new Produit(0,nom,prix,poids));
        }else{
        	System.out.println("Bonne journée");
        }
        
        System.out.println("-----------------MODIFIER UN PRODUIT---------------------");
        System.out.println("Quel est l'id à modifier?");
        int id = Integer.parseInt(input.nextLine());
        
        System.out.println("Nom du nouveau produit?");
        String nom1 = input.nextLine();
        
        System.out.println("Quel est le prix?");
        double prix1 = Double.parseDouble(input.nextLine());

        System.out.println("Quel est le poid?");
        double poids1 = Double.parseDouble(input.nextLine());
        
        produitDAO.save(new Produit(id,nom1,prix1,poids1));
      
 /*       System.out.println("----------REQUETE MEMENTO----------");
        iProduitDAO mu = ctx.getBean("produitDAO", iProduitDAO.class);
        while (true) {
			System.out.println("Id a charger?");
			int n = Integer.parseInt(input.nextLine());
			if(n == 0) {
				
				break;
			}
			System.out.println("Résultat de ma requete = " + mu.findById(n));
			
		}*/
        
        
        
		System.out.println("done...");
	}

	




}
