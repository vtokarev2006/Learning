package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Project;

@Repository("ProjectDao")
@Transactional
public class ProjectDaoImpl extends GenericDaoImpl<Project, Integer> implements ProjectDao {

	public ProjectDaoImpl() {
		super(Project.class);
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Project> findAll() {
		return em.createNamedQuery("Project.findAll", type).getResultList();
	}

}