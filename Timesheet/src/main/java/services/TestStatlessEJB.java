package services;

import java.util.List;

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

	public List<Brand> GetAllBrands(){
		
		TypedQuery<Brand> query = em.createQuery("SELECT b FROM Brand b", Brand.class);
		List<Brand> brands = query.getResultList();
		return brands;
		
	}
	
	
	public void createClient(Client client){
		
		em.persist(client);
			
		
		
	}
	
	
}
