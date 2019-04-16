package com.supaada.treage.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.supaada.treage.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User>implements UserDao{
	
	
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	
	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null) {
			Hibernate.initialize(user.getRolesUs());
		}
		return user;		
	} 
	
	@Override
	public User findByNombre(String username) {		
		  logger.info("username : {}",username);
		  Criteria crit = createEntityCriteria();
		  crit.add(Restrictions.eq("username", username));
		  logger.info("user : {}",crit.uniqueResult());
		  User user = (User)crit.uniqueResult();
		  if(user!=null) {
		  Hibernate.initialize(user.getRolesUs());		 
		  }
			return user;	
		}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("username"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<User> users = (List<User>) criteria.list();
		return users;
	}
	
	public void save(User user) {
		persist(user);
	}
	
	public void deleteByID(Integer id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idUsuario", id));
        User user = (User)crit.uniqueResult();
        delete(user);
	}
}
