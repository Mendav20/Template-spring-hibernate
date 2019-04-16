package com.supaada.treage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supaada.treage.dao.UserProfileDao;
import com.supaada.treage.model.RolesUs;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	 @Autowired
	    UserProfileDao dao;
	     
	    public RolesUs findById(Integer idRol) {
	        return dao.findById(idRol);
	    }
	 
	    public RolesUs findByNombreRol(String NombreRol){
	        return dao.findByRol(NombreRol);
	    }
	 
	    public List<RolesUs> findAll() {
	        return dao.findAll();
	    }
}
