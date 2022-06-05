package br.com.fiap.globalsolution.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.globalsolution.model.Posto;

public class PostoDao {
	public EntityManagerFactory factory =  Persistence.createEntityManagerFactory("globalsolution");
	public EntityManager manager = factory.createEntityManager(); 
	
	public void inserir(Posto posto) {
		manager.getTransaction().begin();
		manager.persist(posto);
		manager.getTransaction().commit();
	}
	
		
	public List<Posto> listarTodos(){
		String jpql = "SELECT p FROM Posto p";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);
		return query.getResultList();
	}
	
	public List<Posto> ordenarTodos(){
		String jpql = "SELECT p FROM Posto p order by estado";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);
		return query.getResultList();
	}

}
