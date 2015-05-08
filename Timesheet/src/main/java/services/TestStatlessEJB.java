package services;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Brand;
import entity.Client;


@Stateless
public class TestStatlessEJB {
	
	@PersistenceContext
	private EntityManager em;

	public Set<Brand> GetAllBrands(){
		
		TypedQuery<Brand> query = em.createQuery("SELECT b FROM Brand b", Brand.class);
		Set<Brand> brands = new HashSet<>();
		brands.addAll(query.getResultList());
		return brands;
		
	}
	
	
	public void createClient(Client client){
		
		em.persist(client);
			
		
		
	}
	
	
}
