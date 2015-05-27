package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vo.Result;
import vo.ResultFactory;
import dao.CompanyDao;
import dao.ProjectDao;
import domain.*;


@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
@Service("projectService")
public class ProjectServiceImpl extends AbstractService implements ProjectService {
	
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	
	public ProjectServiceImpl(){
		super();
	}
	
	

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Project> store(Integer projectId, Integer companyId, String projectName, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (companyId==null)
			return ResultFactory.getFailResult("Unable to store new project without a valid Company [null companyId]");
		
		Company company = companyDao.find(companyId);

		if (company==null)
			return ResultFactory.getFailResult("Unable to store new project without a valid Company companyId="+companyId);
		
		
		Project project;
		

		if (projectId == null) {
			project = new Project();
			project.setCompany(company);
			
			if (company.getProjects() == null) {
				List<Project> projects = new ArrayList<>();
				company.setProjects(projects);
			}
			
			company.getProjects().add(project);
		} else {
			project = projectDao.find(projectId);
			if (project == null) {
				return ResultFactory.getFailResult("Unable to find project instance with ID="+ projectId);
			}
		}
		project.setName(projectName);
		
		if (project.getId() == null) {
			projectDao.persist(project);
		} else {
			project = projectDao.merge(project);
		}
		return ResultFactory.getSuccessResult(project);
		
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Project> remove(Integer projectId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);

		if (projectId == null) {
			return ResultFactory.getFailResult("Unable to remove Project [null projectId]");
		}
		
		Project project = projectDao.find(projectId);
		
		if (project==null) {
			return ResultFactory.getFailResult("Unable to load Project for removal with projectId=" + projectId);
		} else {
			if (project.getTasks()!=null && !project.getTasks().isEmpty() ) {
				
				return ResultFactory.getFailResult("Project has	tasks assigned and could not be deleted");
				
			} else {
				
				projectDao.remove(project);
				String msg = "Project " + project.getName() + " was deleted by " + actionUsername;
				logger.info(msg);
				return ResultFactory.getSuccessResultMsg(msg);				
			}
		}
		
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<Project> find(Integer projectId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		Project project = projectDao.find(projectId);
		return ResultFactory.getSuccessResult(project);

	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<List<Project>> findAll(String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		List<Project> projects = projectDao.findAll();
		return ResultFactory.getSuccessResult(projects);
	}
	
	

}