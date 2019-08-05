package com.edugroupe.basicmapping.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.edugroupe.basicmapping.beans.Client;



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

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		//begin = commencer
		tx.begin();
		//----------------------------SAUVEGARDE------------------------
		Client c1 = new Client(0,"Potter","Harry",18,"harry@dumbledorefan.com");
		em.persist(c1);
		System.out.println(c1);
		Client c2 = new Client(0,"Granger","Hermione", 19, "hermione@gmail.com");
		//La méthode persist est destinée à ajouter une nouvelle instance d'entité
		em.persist(c2);
		Client c3 = new Client(0,"Rubeus","Hagrid", 39, "hagrid@gmail.com");
		em.persist(c3);
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//-----------------------LECTURE-----------------------------
		//nom de l'objet Client
		//le langage de requetage des entite s'apelle
		//EJBQL, JPQL, ( specifique hibernate HQL)
		TypedQuery<Client> q1 = em.createQuery("SELECT c FROM Client as c",Client.class);
		//execution de la requete
		List<Client> clients = q1.getResultList();
		for(Client c : clients) {
			System.out.println(c);
		}
		
		System.out.println("-------------------------------------");
		/*
		 * ici, on retrouvera la même instance d'objet client que celle correspondant
		 * a l'id 2 dans la liste requettée au dessus
		 * 
		 * cela abouti a une regle absolue en hibernate JPA
		 * dans un entityManager
		 * il n'y a jamais qu'une seule instance par ligne de table
		 * L'entity manage track/suit toutes les entitées qu'il requete ou sauvegarde
		 * l'entité est managé par l'entityMa,ager
		 * */
		
		
		Client c1 = em.find(Client.class, 2);
		System.out.println(c1);
		
		c1.setAge(22);
		System.out.println(c1);
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
		//l'entité n'est plus suivi par entity manager
		//on dit que l'entité est dans un état "détaché"
		c1.setEmail("harcor@gmail.com");
	}
	
	
	public static void test3(EntityManagerFactory emf)
	{

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//-----------------------LECTURE-----------------------------
		/*considtion = clause dans ce cas WHERE
		 *: = les : est la même chose que le ?
		 *la requete est une requete JPQL
		 * 
		 * En jpql on peut comme en sql parametrer les requete
		 * la syntaxe est :nom_paramtre, le nom_parametre étant à votre choix
		 * il suffit ensuite d'utiliser setParametrer en lui redonnant le nom du parametre
		 * pour attacher la valeur voulue
		 * 
		 * 
		 * */
		TypedQuery<Client> q1 = em.createQuery("SELECT c FROM Client as c WHERE c.age > :age_min", Client.class);
		//cela correpond a la valeur du ?
		q1.setParameter("age_min", 20);
		List<Client> clients = q1.getResultList();
		for(Client c : clients) {
			System.out.println(c);
		}
		
		/*-------------APPELE DU NOM ET PRENOM PAR RAPPORT A L AGE---------------------*/
		//c = objet
		//pas la peine d'utiliser un typedquery si on ne retourne pas un entitée
		//mais certain attributs uniquement
		//cela nous renvoi alors un tableau d'objet, chaque objet coorespondant a un attribut
		//renvoyé
		Query q2 = em.createQuery("SELECT c.nom,c.prenom FROM Client as c WHERE c.age < :age_max");
		q2.setParameter("age_max", 26);
		List<Object[]> data = q2.getResultList();
		for(Object[] ligne : data) {
			System.out.println(Arrays.toString(ligne));
		}
		
		
		/*-----------------EFFACEMENT DANS LA BASE-------------------*/
		Client c1 = em.find(Client.class, 1);
		em.remove(c1);
		
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		
	}

}
