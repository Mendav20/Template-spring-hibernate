package com.supaada.treage.dao;

import java.util.List;

import com.supaada.treage.model.UserProfile;

public interface UserProfileDao {
	
	List<UserProfile> findAll();
    
    UserProfile findByType(String type);
     
    UserProfile findById(int id);

}
