package com.edugroupe.springjpaexercice.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edugroupe.springjpaexercice.metier.Post;

@Service
public class PostModelImpl implements PostModel {

	@PersistenceContext
	private EntityManager em;
	

	@Override
	@Transactional(readOnly = true)
	public List<Post> findAll(){
		return em.createQuery("From Post", Post.class).getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Post findById(int id) {
		return em.find(Post.class,id);
	}
	
	
	@Override
	@Transactional
	public Post save(Post p) {
		if(p.getId() == 0) {
			em.persist(p);
			
		}
		else {
			Post po =em.find(Post.class, p.getId());
			p.setDateCreation(po.getDateCreation());
			p = em.merge(p);
		}
		return p;
	}
	

	@Override
	@Transactional
	public boolean deleteById(int id) {
		Post p = em.find(Post.class, id);
		if(p == null)
			return false;
		em.remove(p);
		return true;

				
	}
	
	@Override
	@Transactional
	public List<Post> search(String auteur){
		TypedQuery<Post> pu = em.createQuery("Select p FROM Post as p WHERE p.auteur LIKE :search",Post.class);
		pu.setParameter("search", "%" + auteur + "%");
		return pu.getResultList();
		
	}
	
	@Override
	@Transactional
	public List<Post> searchDate(LocalDate date){
		TypedQuery<Post> pu = em.createQuery("Select p FROM Post as p WHERE p.dateCreation > :date ",Post.class);
		pu.setParameter("date",  date );
		return pu.getResultList();
		
	}
	
	
	
	
	
}
