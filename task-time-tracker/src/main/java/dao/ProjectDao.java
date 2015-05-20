package dao;

import java.util.List;

import domain.Project;

public interface ProjectDao extends GenericDao<Project,Integer> {
	public List<Project> findAll();
}
