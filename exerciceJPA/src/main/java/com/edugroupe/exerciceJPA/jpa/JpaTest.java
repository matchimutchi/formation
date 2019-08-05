package com.edugroupe.exerciceJPA.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.edugroupe.exerciceJPA.beans.Produit;


public class JpaTest {

	

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test3(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test4(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//----------------------------------------------------
			Produit p1 = new Produit(0,"Sac",2.99,1.23,56);
			em.persist(p1);
			Produit p2 = new Produit(0,"Livre",4.99,2.23,6);
			em.persist(p2);
			Produit p3= new Produit(0,"Montre",7.99,1,3);
			em.persist(p3);
			Produit p4= new Produit(0,"Casque",72.99,2.01,12);
			em.persist(p4);
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);
			System.out.println(p4);
			
			System.out.println("--------Fin partie 1--------------");
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		TypedQuery<Produit> q1 = em.createQuery("SELECT p FROM Produit as p",Produit.class);
		List<Produit> produits = q1.getResultList();
		for(Produit c : produits) {
			System.out.println(c);
		}
		
		System.out.println("-------------------------------------");
		
		
		Produit p1 = em.find(Produit.class, 3);
		p1.setNom("Assiette");
		System.out.println(p1);
		
		System.out.println("--------Fin partie 2--------------");
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	
	public static void test3(EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//-----------------------LECTURE-----------------------------
		TypedQuery<Produit> q1 = em.createQuery("SELECT p FROM Produit as p WHERE p.stock > :stock_max", Produit.class);

		q1.setParameter("stock_max", 5);
		List<Produit> produits = q1.getResultList();
		for(Produit p : produits) {
			System.out.println(p);
		}
		//Produit p1 = em.find(Produit.class, 2);
		//----------------------------------------------------
		tx.commit();
		em.close();
		//p1.setNom("quinao des ameriques");
		//saveproduit = p1;
		System.out.println("--------Fin partie 3--------------");
	}
	
	static Produit saveproduit;
	public static void test4(EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//-----------------------LECTURE-----------------------------
		//sp est suivi par l'entity manager et a pris en compte
		// les modifications précédente
		//Produit sp = em.merge(saveproduit);
		
		//System.out.println(sp);
		
		System.out.println("---------------MODIFICATION HAUT------------------");
		TypedQuery<Produit> q1 = em.createQuery("SELECT p FROM Produit as p WHERE p.stock <= :stock_min", Produit.class);

		q1.setParameter("stock_min", 5);
		
		List<Produit> produits = q1.getResultList();
		for(Produit p : produits) {
			p.setPrix(p.getPrix()* 1.1);
			System.out.println(p);
		}
		
		System.out.println("--------Fin partie 4--------------");
		
		
		System.out.println("--------EFFACEMENT--------------");
		/*-----------------EFFACEMENT DANS LA BASE-------------------*/
		Produit p1 = em.find(Produit.class, 2);
		em.remove(p1);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
	}
}
