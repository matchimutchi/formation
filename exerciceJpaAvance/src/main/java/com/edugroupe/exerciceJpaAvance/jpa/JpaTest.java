package com.edugroupe.exerciceJpaAvance.jpa;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.edugroupe.exerciceJpaAvance.beans.Contenu;
import com.edugroupe.exerciceJpaAvance.beans.DocumentPdf;
import com.edugroupe.exerciceJpaAvance.beans.Galerie;
import com.edugroupe.exerciceJpaAvance.beans.Image;
import com.edugroupe.exerciceJpaAvance.beans.Tag;



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
		System.out.println("-------------------DEBUT TEST 1------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		em.persist(new Tag(0, "Tag 1"));
		em.persist(new Tag(0, "Tag 2"));
		em.persist(new Tag(0, "Tag 3"));
		em.persist(new Tag(0, "Tag 4"));
		em.persist(new Tag(0, "Tag 5"));
		
		em.persist(new Galerie(0, "Galerie1", LocalDate.of(2018, 5, 14), LocalDate.of(2019, 2, 18),"galerie1"));
		em.persist(new Galerie(0, "Galerie2", LocalDate.of(2018, 7, 14), LocalDate.of(2019, 8, 1),"galerie2"));
		em.persist(new Galerie(0, "Galerie3", LocalDate.of(2018, 8, 14), LocalDate.of(2019, 5, 15),"galerie3"));

				
		Random rd = new Random();
		for (int i = 1; i <= 50; i++) {
			Image im = new Image(0, "Img" + i, 
					LocalDate.of(2019,rd.nextInt(4) + 1,5), 
					LocalDate.of(2019,rd.nextInt(4) + 6,5), 
					"image" + i, 
					"Jenny" + i);
			for (int j = 1; j <= 3; j++) {
				if (rd.nextDouble() > 0.5) {
					em.find(Galerie.class, j).addImages(im);
				}
			}
			
			for (int k = 1; k <= 5; k++) {
				if (rd.nextDouble() > 0.5) {
					em.find(Tag.class, k).addToContenu(im);
				}
			}
			
			DocumentPdf doc = new DocumentPdf(0, "Doc" + i,
					LocalDate.of(2019,rd.nextInt(4) + 1,5), 
					LocalDate.of(2019,rd.nextInt(4) + 6,5),
					"document" + i, 
					"Melo" + i);
					for (int l = 1; l <= 5; l++) {
							if (rd.nextDouble() > 0.8) {
								em.find(Tag.class, l).addToContenu(doc);
							}
					}

			em.persist(im);
			em.persist(doc);
			
		}
		
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("-------------------FIN TEST 1------------------");
	}


	public static void test2(EntityManagerFactory emf)
	{
		System.out.println("-------------------DEBUT TEST 2------------------");
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("\n");
		System.out.println("-------------------RESULTAT EXERCICE 1--------------");
		TypedQuery<Image> q1 = em.createQuery(
				"select im from Image as im join im.tags as ta  where ta.id = :nbId ",
				Image.class);
		q1.setParameter("nbId", 1);
		List<Image> images = q1.getResultList();
		images.stream().forEach(im -> System.out.println(im + "->" + im.getTags()));
		
		
		
		
		System.out.println("\n");
		System.out.println("-------------------RESULTAT EXERCICE 2--------------");
		Query q2 = em.createQuery(
				"select ga,COUNT(im) from Galerie as ga join ga.images as im GROUP BY ga.id");
		
		List<Object[]> data = q2.getResultList();
		data.stream().forEach(ligne -> System.out.println(Arrays.toString(ligne)));

		
		
		
		System.out.println("\n");
		System.out.println("-------------------RESULTAT EXERCICE 3--------------");

		
		TypedQuery<Image> q3 = em.createQuery(
				"SELECT im FROM Image as im JOIN im.tags as ta1 JOIN im.tags as ta2  WHERE ta1.id = :nbId AND ta2.id = :nbId2",
				Image.class);
		q3.setParameter("nbId", 1);
		q3.setParameter("nbId2", 2);
		List<Image> images3 = q3.getResultList();
		images3.stream().forEach(im3 -> System.out.println(im3));
		
		
		
		
		
		System.out.println("\n");
		System.out.println("-------------------RESULTAT EXERCICE 4--------------");
		Query q4 = em.createQuery(
				"select ta,COUNT(co) from Tag as ta join ta.contenus as co GROUP BY ta.id");
		
		List<Object[]> data1 = q4.getResultList();
		data1.stream().forEach(ligne1 -> System.out.println(Arrays.toString(ligne1)));
	
		
		
		
		
		System.out.println("\n");
		System.out.println("-------------------RESULTAT EXERCICE 5--------------");
		
		TypedQuery<Image> q5 = em.createQuery("SELECT im FROM Image as im JOIN im.tags as ta"
				+ " WHERE ta.id = :tid1 "
				+ "AND NOT EXISTS("
				+ "SELECT im2 FROM Image as im2 "
				+ "JOIN im2.tags as ta2 "
				+ "WHERE ta2.id = :tid2 "
				+ "AND im2.id = im.id)",
				Image.class);
		q5.setParameter("tid1", 1);
		q5.setParameter("tid2", 2);
		q5.getResultList().stream().forEach(img5 -> System.out.println(img5));
		
		System.out.println("\n");
		System.out.println("-------------------CREER des requete sans creer des jpql--------------");
		//je recupere notre "querybuilder a la sauce jpa"
		CriteriaBuilder cbuilder = em.getCriteriaBuilder();
		CriteriaQuery<DocumentPdf> query = cbuilder.createQuery(DocumentPdf.class);
		Root<DocumentPdf> from = query.from(DocumentPdf.class);
		TypedQuery<DocumentPdf> q6 = em.createQuery(query.select(from));
		q6.getResultList().stream().forEach(d -> System.out.println(d));
		//----------------------------------------------------
		tx.commit();
		em.close();
		System.out.println("\n");
		System.out.println("-------------------FIN TEST 2------------------");
	}

}
