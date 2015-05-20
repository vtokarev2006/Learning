package service;

import java.util.List;

import domain.Company;
import vo.Result;

public interface CompanyService {

	public Result<Company> store(Integer companyId, String companyName,	String actionUsername);

	public Result<Company> remove(Integer companyId, String actionUsername);

	public Result<Company> find(Integer companyId, String actionUsername);

	public Result<List<Company>> findAll(String actionUsername);
}