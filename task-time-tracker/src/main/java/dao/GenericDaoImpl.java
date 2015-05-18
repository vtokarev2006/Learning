package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	final protected Logger logger =	LoggerFactory.getLogger(this.getClass());	
	
	@PersistenceContext(unitName="tttPU")
	protected EntityManager em;
	
	protected Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public T find(ID id) {
		return (T)em.find(type, id);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void persist(T obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public T merge(T obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void remove(T obj) {
		em.remove(em.merge(obj));
	}

}
