package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Company;

@Repository("CompanyDao")
@Transactional
public class CompanyDaoImpl extends GenericDaoImpl<Company, Integer> implements CompanyDao {

	public CompanyDaoImpl() {
		super(Company.class);
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Company> findAll() {
		return em.createNamedQuery("Company.findAll", type).getResultList();
	}

}