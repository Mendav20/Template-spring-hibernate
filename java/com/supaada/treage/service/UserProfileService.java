package com.supaada.treage.service;

import java.util.List;

import com.supaada.treage.model.RolesUs;

public interface UserProfileService {
	
	  RolesUs findById(Integer id);
	  
	    RolesUs findByNombreRol(String NombreRol);
	     
	    List<RolesUs> findAll();

}
