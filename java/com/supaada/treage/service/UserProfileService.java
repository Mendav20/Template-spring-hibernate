package com.supaada.treage.service;

import java.util.List;

import com.supaada.treage.model.UserProfile;

public interface UserProfileService {
	
	  UserProfile findById(int id);
	  
	    UserProfile findByType(String type);
	     
	    List<UserProfile> findAll();

}
