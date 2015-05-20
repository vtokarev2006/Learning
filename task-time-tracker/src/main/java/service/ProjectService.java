package service;

import java.util.List;

import domain.Project;
import vo.Result;

public interface ProjectService {

	public Result<Project> store(Integer projectId, Integer companyId, String projectName, String actionUsername);

	public Result<Project> remove(Integer projectId, String actionUsername);

	public Result<Project> find(Integer projectId, String actionUsername);

	public Result<List<Project>> findAll(String actionUsername);
}
