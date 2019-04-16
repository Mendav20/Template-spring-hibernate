package com.supaada.treage.service;

import java.util.List;

import com.supaada.treage.model.User;


public interface UserService {
	
	  User findById(Integer idUsuario);
	     
	    User findByNombre(String username);
	     
	    void saveUser(User user);
	     
	    void updateUser(User user);
	     
	    void deleteUserByID(Integer idUsuario);
	 
	    List<User> findAllUsers(); 
	     
	    boolean isUserSSOUnique(Integer id, String username);

}
