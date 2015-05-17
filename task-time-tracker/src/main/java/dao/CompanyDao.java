package dao;

import java.util.List;

import model.Company;

public interface CompanyDao extends GenericDao<Company, Integer> {
	
	public List<Company> findAll();
	
	
	
}
