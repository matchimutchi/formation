package com.edugroupe.jpaheritageSingleTable1.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.edugroupe.jpaheritageSingleTable1.beans.Client;
import com.edugroupe.jpaheritageSingleTable1.beans.Employe;
import com.edugroupe.jpaheritageSingleTable1.beans.Personne;



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

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		System.out.println("------------------DEBUT TEST 1--------------------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		em.persist(new Personne(0,"Eponge","Bob"));
		em.persist(new Personne(0,"Etoile","Patrick"));
		em.persist(new Personne(0,"Poulpe","Carlo"));
		em.persist(new Personne(0,"Ecureil","Sandy"));
		em.persist(new Personne(0,"Crabs","Capitaine"));
		
		
		em.persist(new Employe(0, "Potter", "Harry", "Entretien", 1500.0));
		em.persist(new Employe(0, "Granger", "Hermione", "Accueil", 1700.0));
		em.persist(new Employe(0, "Weysley", "Ron", "Marketing", 1650.0));
		em.persist(new Employe(0, "Dumbledore", "Albus", "CEO", 2650.0));
		em.persist(new Employe(0, "Rogue", "Severus", "Vente", 1850.0));
		
		em.persist(new Client(0, "Swcharzenegger","Arnold", "arnie@governator", 15000));
		em.persist(new Client(0, "Stalone","Sylverster", "sylv@rambo", 12000));
		em.persist(new Client(0, "Foster","Jodie", "jodie@gmail.com", 11000));
		em.persist(new Client(0, "Reeves","keanu", "kean@gmail.com", 18000));
		em.persist(new Client(0, "Dujardin","Jean", "jean@france.fr", 7000));

		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("------------------FIN TEST 1--------------------------------");
	}


	public static void test2(EntityManagerFactory emf)
	{
		System.out.println("------------------DEBUT TEST 2--------------------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("------------------RESULTAT TOUT--------------------------------");
		List<Personne> peoples = em.createQuery("FROM Personne", Personne.class).getResultList();
		peoples.stream().forEach(p -> System.out.println(p));
		
		
		
		System.out.println("------------------RESULTAT EMPLOYE--------------------------------");
		List<Employe> employes = em.createQuery("FROM Employe", Employe.class).getResultList();
		employes.stream().forEach(e -> System.out.println(e));
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("------------------FIN TEST 2--------------------------------");
	}

}
