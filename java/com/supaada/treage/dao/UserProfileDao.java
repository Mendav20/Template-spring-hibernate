package com.supaada.treage.dao;

import java.util.List;

import com.supaada.treage.model.RolesUs;

public interface UserProfileDao {
	
	List<RolesUs> findAll();
    
    RolesUs findByRol(String NombreRol);
     
    RolesUs findById(int id);

}
