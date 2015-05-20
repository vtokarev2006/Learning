package dao;

import java.util.List;

import domain.Company;

public interface CompanyDao extends GenericDao<Company, Integer> {
	
	public List<Company> findAll();
	
	
	
}
