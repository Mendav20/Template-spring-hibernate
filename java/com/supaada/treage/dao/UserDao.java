package com.supaada.treage.dao;

import java.util.List;

import com.supaada.treage.model.User;

public interface UserDao {
	
	User findById(int idUsuario);
	
	User findByNombre(String username);
	
	void save(User user);
	
	void deleteByID(Integer Id);
	
	List<User>findAllUsers();
}
