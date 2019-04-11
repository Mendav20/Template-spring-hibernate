package com.supaada.treage.service;

import java.util.List;

import com.supaada.treage.model.User;


public interface UserService {
	
	  User findById(int id);
	     
	    User findBySSO(String ssoId);
	     
	    void saveUser(User user);
	     
	    void updateUser(User user);
	     
	    void deleteUserBySSO(String ssoId);
	 
	    List<User> findAllUsers(); 
	     
	    boolean isUserSSOUnique(Integer id, String ssoId);

}
