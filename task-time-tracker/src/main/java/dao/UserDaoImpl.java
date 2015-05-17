package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Repository("UserDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<User> findAll() {
		return em.createNamedQuery("User.findAll", type).getResultList();
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public User findByUsernamePassword(String username, String Password) {
		List<User> users = em.createNamedQuery("User.findByUsernamePassword", type).setParameter("userName", username).getResultList();
		return users.size()==1 ? users.get(0) : null;
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public User findByEmail(String email) {
		List<User> users = em.createNamedQuery("User.findByEmail", type).getResultList();
		return users.size()==1 ? users.get(0) : null;
	}

}
