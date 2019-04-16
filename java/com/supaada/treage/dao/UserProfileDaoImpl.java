package com.supaada.treage.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.supaada.treage.model.RolesUs;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, RolesUs> implements UserProfileDao{
	
	public RolesUs findById(int id) {
	        return getByKey(id);
	    }
	 
	    public RolesUs findByRol(String rol) {
	        Criteria crit = createEntityCriteria();
	        crit.add(Restrictions.eq("NombreRol", rol));
	        return (RolesUs) crit.uniqueResult();
	    }
	     
	    @SuppressWarnings("unchecked")
	    public List<RolesUs> findAll(){
	        Criteria crit = createEntityCriteria();
	        crit.addOrder(Order.asc("NombreRol"));
	        return (List<RolesUs>)crit.list();
	    }
}
