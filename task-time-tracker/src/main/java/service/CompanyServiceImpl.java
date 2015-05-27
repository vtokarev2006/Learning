package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vo.*;
import dao.CompanyDao;
import domain.*;

@Transactional
@Service("companyService")
public class CompanyServiceImpl extends AbstractService implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	public CompanyServiceImpl(){
		super();
	}
	
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<Company> find(Integer companyId, String actionUsername) {

		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		Company company = companyDao.find(companyId);
		return ResultFactory.getSuccessResult(company);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Company> store(Integer companyId, String companyName,	String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
			
		Company company;

		if (companyId == null) {
			company = new Company();
		} else {
			company = companyDao.find(companyId);
			if (company == null) {
				return ResultFactory.getFailResult("Unable to find company instance with ID="+ companyId);
			}
		}
		company.setName(companyName);
		if (company.getId() == null) {
			companyDao.persist(company);
		} else {
			company = companyDao.merge(company);
		}
		return ResultFactory.getSuccessResult(company);

	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Company> remove(Integer companyId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (companyId == null) {
			return ResultFactory.getFailResult("Unable to remove Company [null companyId]");
		}
		
		Company company = companyDao.find(companyId);
		
		if (company==null) {
			return ResultFactory.getFailResult("Unable to load Company for removal with companyId=" + companyId);
		} else {
			if (company.getProjects()!=null) {
				return ResultFactory.getFailResult("Company has	projects assigned and could not be deleted");				
				
			} else {
				
				companyDao.remove(company);
				String msg = "Company " + company.getName() + " was deleted by " + actionUsername;
				logger.info(msg);
				return ResultFactory.getSuccessResultMsg(msg);				
			}
		}
	}


	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<List<Company>> findAll(String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
			
		List<Company> companies = companyDao.findAll();
		return ResultFactory.getSuccessResult(companies);
	}

}
