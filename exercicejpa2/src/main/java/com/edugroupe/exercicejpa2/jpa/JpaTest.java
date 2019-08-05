package com.edugroupe.exercicejpa2.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.edugroupe.exercicejpa2.beans.Film;
import com.edugroupe.exercicejpa2.beans.Producteur;


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
		System.out.println("--------------------DEBUT TEST1---------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Producteur p1 = new Producteur(0,"Travel",LocalDate.of(1985, 8, 15));		
		Producteur p2 = new Producteur(0,"Marcel",LocalDate.of(1978, 5, 26));
		Producteur p3 = new Producteur(0,"Roumanoff",LocalDate.of(1965, 3, 2));
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		Film f1 = new Film(0,"Web de l'horreur",LocalDate.of(2015, 6, 25),156);
		f1.setProducteur(p1);
		Film f2 = new Film(0,"jumanji",LocalDate.of(2018, 5, 25),227);
		f2.setProducteur(p2);
		Film f3 = new Film(0,"L'arraigné",LocalDate.of(2017, 12, 17),184);
		f3.setProducteur(p1);
		Film f4 = new Film(0,"Jumelle",LocalDate.of(2005, 2, 1),178);
		f4.setProducteur(p3);
		Film f5 = new Film(0,"Lourde",LocalDate.of(2006, 4, 29),263);
		f5.setProducteur(p3);
		Film f6 = new Film(0,"Capitaux",LocalDate.of(2009, 11, 10),103);
		f6.setProducteur(p2);
		Film f7 = new Film(0,"Les 7 ",LocalDate.of(2014, 10, 3),132);
		f7.setProducteur(p1);
		Film f8 = new Film(0,"L'envie",LocalDate.of(2012, 9, 5),198);
		f8.setProducteur(p2);
		Film f9 = new Film(0,"La joie",LocalDate.of(1985, 8, 10),166);
		f9.setProducteur(p3);
		Film f10 = new Film(0,"L'intrigue",LocalDate.of(1655, 12, 12),178);
		f10.setProducteur(p1);
		
		
		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);
		em.persist(f6);
		em.persist(f7);
		em.persist(f8);
		em.persist(f9);
		em.persist(f10);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
		System.out.println("--------------------FIN TEST1---------------------");
	}


	public static void test2(EntityManagerFactory emf)
	{
		System.out.println("--------------------DEBUT TEST2---------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("--------------------LISTE FILMS---------------------");
		
		List<Film> films = em.createQuery("From Film ", Film.class).getResultList();

		for(Film f : films) {
			System.out.println(f.getTitre() + " - " + f.getDateSortie() + " - " + f.getDuree());
		}

		System.out.println("--------------------LISTE PRODUCTEURS---------------------");
		
		
		List<Producteur> producteurs = em.createQuery("From Producteur ", Producteur.class).getResultList();

		for(Producteur p : producteurs) {
			System.out.println(p.getNom() + " - " + p.getDateNaissance());
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
		System.out.println("--------------------FIN TEST2---------------------");
	}
	
	public static void test3(EntityManagerFactory emf)
	{
		System.out.println("--------------------DEBUT TEST3---------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Query q1 = em.createQuery("SELECT f.titre,f.duree FROM Film as f WHERE f.duree > :duree_max");
		
		q1.setParameter("duree_max", 200);
		List<Object[]> result = q1.getResultList();
		for(Object[] ligne : result) {
			System.out.println(Arrays.toString(ligne));
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
		System.out.println("--------------------FIN TEST3---------------------");
	}
	
	public static void test4(EntityManagerFactory emf)
	{
		System.out.println("--------------------DEBUT TEST4---------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Query q2 = em.createQuery("SELECT p.nom,p.dateNaissance FROM Producteur as p WHERE p.dateNaissance > :dateNaissance_max");
		
		q2.setParameter("dateNaissance_max", LocalDate.of(1970, 1, 1));
		List<Object[]> result = q2.getResultList();
		for(Object[] ligne : result) {
			System.out.println(Arrays.toString(ligne));
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
		System.out.println("--------------------FIN TEST4---------------------");
	}

}
