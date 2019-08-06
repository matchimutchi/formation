package com.edugroupe.exerciceUniversiteJPA.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.edugroupe.exerciceUniversiteJPA.beans.Cours;
import com.edugroupe.exerciceUniversiteJPA.beans.Etudiant;
import com.edugroupe.exerciceUniversiteJPA.beans.Matiere;
import com.edugroupe.exerciceUniversiteJPA.beans.Professeur;



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
		test5(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test6(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test7(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST1-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		//-------------DEBUT MATIERE---------------
				Matiere m1 = new Matiere(0,"Math");
				Matiere m2 = new Matiere(0,"Francais");
				Matiere m3 = new Matiere(0,"Anglais");
				Matiere m4 = new Matiere(0,"Sport");
				
				em.persist(m1);
				em.persist(m2);
				em.persist(m3);
				em.persist(m4);
				//-------------FIN MATIERE---------------
				
				
				//-------------DEBUT PROFESSEURS---------------
				Professeur p1 = new Professeur(0,"Pichard","Jean",1256.15);
				Professeur p2 = new Professeur(0,"Rouseeau","Pierre",1458.25);
				Professeur p3 = new Professeur(0,"Legrand","Helene",1756.10);
				Professeur p4 = new Professeur(0,"Ruiz","Pierrette",1800.15);
				
				em.persist(p1);
				em.persist(p2);
				em.persist(p3);
				em.persist(p4);
				
				//-------------FIN PROFESSEURS---------------
				
				//-------------DEBUT Cours---------------
				Cours c1 = new Cours(0, "Debutant", 25, LocalDate.of(2019, 5, 5), LocalDate.of(2019, 5, 6));
				c1.setMatieres(m1);
				c1.setProfesseurs(p2);
				//c1.getEtudiants().add(e1);
				
				Cours c2 = new Cours(0, "Facile", 25, LocalDate.of(2019, 4, 7), LocalDate.of(2019, 4, 8));
				c2.setMatieres(m3);
				c2.setProfesseurs(p1);
				
				Cours c3 = new Cours(0, "Dure", 25, LocalDate.of(2019, 8, 5), LocalDate.of(2019, 8,7));
				c3.setMatieres(m2);
				c3.setProfesseurs(p1);
				
				Cours c4 = new Cours(0, "Pro", 25, LocalDate.of(2019, 8, 5), LocalDate.of(2019, 8, 6));
				c4.setMatieres(m3);
				c4.setProfesseurs(p3);
				
				Cours c5 = new Cours(0, "Moyen", 25, LocalDate.of(2019, 7, 15), LocalDate.of(2019, 7, 16));
				c5.setMatieres(m2);
				c5.setProfesseurs(p4);
				
				Cours c6 = new Cours(0, "Trés facile", 25, LocalDate.of(2019, 6, 14), LocalDate.of(2019, 6, 14));
				c6.setMatieres(m1);
				c6.setProfesseurs(p1);
				
				Cours c7 = new Cours(0, "Trés dure", 25, LocalDate.of(2019, 2, 25), LocalDate.of(2019, 2, 26));
				c7.setMatieres(m3);
				c7.setProfesseurs(p4);
				
				Cours c8 = new Cours(0, "Facilement moyen", 25, LocalDate.of(2019, 4, 20), LocalDate.of(2019, 4, 21));
				c8.setMatieres(m4);
				c8.setProfesseurs(p1);
				
				Cours c9 = new Cours(0, "Pour les nuls", 25, LocalDate.of(2019, 1, 31), LocalDate.of(2019, 2, 1));
				c9.setMatieres(m3);
				c9.setProfesseurs(p3);
				
				Cours c10 = new Cours(0, "Trés trés dur", 25, LocalDate.of(2018, 12, 27), LocalDate.of(2018, 12, 28));
				c10.setMatieres(m1);
				c10.setProfesseurs(p4);
				
				em.persist(c1);
				em.persist(c2);
				em.persist(c3);
				em.persist(c4);
				em.persist(c5);
				em.persist(c6);
				em.persist(c7);
				em.persist(c8);
				em.persist(c9);
				em.persist(c10);
				
				//-------------FIN Cours---------------
					
				//-------------DEBUT ETuDIANTS---------------


				 Random rd = new Random();
				 
		       
		        for (int i = 0; i < 20; i++) {
		        	Etudiant e1 = new Etudiant(0, "Doe"+i, "John", "johndoe@gmail.com");

		        	Etudiant e2 = new Etudiant(0, "Strulu"+i, "Patrick", "strulupatrock@gmail.com");

		        	Etudiant e3 = new Etudiant(0, "Duvin"+i, "Marcel", "duvinmarcel@gmail.com");

		        	Etudiant e4 = new Etudiant(0, "Carre"+i, "Stéphanie", "steph@gmail.com");

		        	Etudiant e5 = new Etudiant(0, "Bar"+i, "Noella", "barnoe@gmail.com");

		        	
		        	em.persist(e1);
		        	em.persist(e2);
		        	em.persist(e3);
		        	em.persist(e4);
		        	em.persist(e5);
		        	
		        	
					System.out.println("--------------------LISTE ETUDIANTS---------------------");					
				
					List<Cours> cours = em.createQuery("From Cours ", Cours.class).getResultList();

					for(Cours c : cours) { 
						if(rd.nextDouble()> 0.8)
							c.getEtudiants().add(e1);
						if(rd.nextDouble()> 0.8)
							c.getEtudiants().add(e2);
						if(rd.nextDouble()> 0.8)
							c.getEtudiants().add(e3);
						if(rd.nextDouble()> 0.8)
							c.getEtudiants().add(e4);
						if(rd.nextDouble()> 0.8)
							c.getEtudiants().add(e5);

					}
		        	
		        }
		        

				
				//-------------FIN ETUDIANTS---------------
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST1-----------------------");
	}


	public static void test2(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST2-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		TypedQuery<Etudiant> q1 = em.createQuery(
				"SELECT DISTINCT(e) FROM Etudiant as e LEFT JOIN e.cours as c WHERE c.dateDebut >:dateDebut_min",Etudiant.class);
		q1.setParameter("dateDebut_min", LocalDate.of(2019, 5, 5));
		
		List<Etudiant> etudiants = q1.getResultList();
		for(Etudiant e : etudiants) {
			System.out.println(e + " nom etudiants = " + e.getNom() + " cours = " + e.getCours());
		}
		

		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST2-----------------------");
	}
	
	
	
	
	public static void test3(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST3-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------


		
		Query q1 = em.createQuery("SELECT COUNT(e),c.libelle FROM Cours as c LEFT JOIN c.etudiants as e GROUP BY c.id");
		

		List<Object[]> cours1 = q1.getResultList();
		System.out.println("------------------------------RESULTAT----------------------------");
		for(Object[] c : cours1) {
			System.out.println( Arrays.toString(c));
		}

		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST3-----------------------");
	}
	
	public static void test4(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST4-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Query q2 = em.createQuery("SELECT c.libelle,COUNT(e) * 100 / c.capacite AS REMPLISSAGE FROM Cours as c LEFT JOIN c.etudiants as e GROUP BY c.id");
		

		List<Object[]> cours2 = q2.getResultList();
		System.out.println("------------------------------RESULTAT----------------------------");
		for(Object[] c1 : cours2) {
			System.out.println( Arrays.toString(c1));
		}

		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST4-----------------------");
	}
	
	public static void test5(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST5-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Query q5 = em.createQuery("SELECT COUNT(e),c.libelle,c.matieres.libelle  FROM Etudiant as e JOIN e.cours as c WHERE c.matieres.id = :matid ");
		

		q5.setParameter("matid", 3);
		List<Object[]> result = q5.getResultList();
		for(Object[] ligne : result) {
			System.out.println(Arrays.toString(ligne));
		}

		//---------------REMOVE---------------------
		
		System.out.println("-------------REMOVE-------------");
		Cours c2 = em.find(Cours.class, 2);
		em.remove(c2);
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST5-----------------------");
	}
	
	
	public static void test6(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST6-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		Query q6 = em.createQuery("SELECT DISTINCT(e.nom),c.libelle  FROM Etudiant as e JOIN e.cours as c WHERE NOT EXISTS(SELECT e2 FROM Etudiant as e2 JOIN e2.cours as c2 WHERE e2.id = e.id AND c2.professeurs.id = :profid) ");
		

		q6.setParameter("profid", 2);
		List<Object[]> result1 = q6.getResultList();
		for(Object[] ligne1 : result1) {
			System.out.println(Arrays.toString(ligne1));
		}

		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST6-----------------------");
	}
	
	
	public static void test7(EntityManagerFactory emf)
	{
		System.out.println("----------------DEBUT TEST7-----------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		
		System.out.println("-------------REMOVE-------------");
		Etudiant e2 = em.find(Etudiant.class, 1);
		e2.cleanCoursBeforeRemove();
		em.remove(e2);
		
		/*Cours c2 = em.find(Cours.class, 2);
		em.remove(c2);*/
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("----------------FIN TEST7-----------------------");
	}

}
