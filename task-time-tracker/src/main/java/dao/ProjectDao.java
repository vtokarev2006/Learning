package dao;

import java.util.List;

import model.Project;

public interface ProjectDao extends GenericDao<Project,Integer> {
	public List<Project> findAll();
}
