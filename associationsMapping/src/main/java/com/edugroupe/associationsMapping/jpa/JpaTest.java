package com.edugroupe.associationsMapping.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.edugroupe.associationsMapping.beans.Categorie;
import com.edugroupe.associationsMapping.beans.Produit;


public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

//        input.nextLine();
//		System.out.println("--------------------------------------");
//		test2(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test3(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{	
		System.out.println("-----------------DEBUT TEST1------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
			Categorie c1 = new Categorie(0,"Boucherie");
			Categorie c2 = new Categorie(0,"Epicerie");
			Categorie c3 = new Categorie(0,"Céréales");
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			
			
			Produit p1 = new Produit(0,"Steack de lamas", 29.99,10);
			p1.setCategorie(c1);
			//c1.getProduits().add(p1);
			
			Produit p2 = new Produit(0,"Tofu tofu", 8.99,4);
			p2.setCategorie(c2);
			//c2.getProduits().add(p2);
			
			Produit p3 = new Produit(0,"Escalope d'autruche", 24.99,25);
			p3.setCategorie(c1);
			//c1.getProduits().add(p3);
			
			Produit p4 = new Produit(0,"Miel des carpathes", 5.99,7);
			p4.setCategorie(c2);
			//c2.getProduits().add(p4);
			
			Produit p5 = new Produit(0,"Biéres aux algues", 4.99,12);

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			em.persist(p5);
			
			c1.getProduits().stream().forEach(p -> System.out.println(p));
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("-----------------FIN TEST1------------------");
	}


	public static void test2(EntityManagerFactory emf)
	{
		System.out.println("-----------------DEBUT TEST2------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
//		Produit p1 = em.find(Produit.class, 1);
//		System.out.println(p1);
//		System.out.println(p1.getCategorie());
//		
//		List<Produit> produits = em.createQuery("From Produit ", Produit.class).getResultList();
//		for(Produit p : produits) {
//			System.out.println(p.getNom() + " - " + ((p.getCategorie() != null) ? p.getCategorie().getLibelle() : " pas de categorie"));
//		}
		
		Categorie c1 = em.find(Categorie.class, 1);
		System.out.println(c1);
		System.out.println(Arrays.toString(c1.getProduits().toArray()));
		
		System.out.println("-----------REMOVE----------------");
		//em.remove(c1);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("-----------------FIN TEST2------------------");
	}
	
	
	public static void test3(EntityManagerFactory emf)
	{
		System.out.println("-----------------DEBUT TEST3------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		/*
		 * 
		 * JPA traduit automatiquement la navigation dans les attributs des entier
		 * en jointure quand cela est nécessaire
		 * 
		 * 
		 * */
		Query q1 = em.createQuery("SELECT p.nom,p.categorie.libelle FROM Produit as p WHERE p.prix >:prix_min");
		
		q1.setParameter("prix_min", 8.0);
		List<Object[]> result = q1.getResultList();
		for(Object[] ligne : result) {
			System.out.println(Arrays.toString(ligne));
		}
		
		
		//-------------------------------------
		tx.commit();
		em.close();
		System.out.println("-----------------FIN TEST3------------------");
	}

}
