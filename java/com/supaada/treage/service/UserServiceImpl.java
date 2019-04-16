package com.supaada.treage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.supaada.treage.dao.UserDao;
import com.supaada.treage.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private UserDao dao;    
	    
	 
	    @Autowired
	    private PasswordEncoder passwordEncoder;	    
	    
	     
	    public User findById(Integer idUsuario) {
	        return dao.findById(idUsuario);
	    }
	 
	    public User findByNombre(String nombre) {
	        User user = dao.findByNombre(nombre);
	        return user;
	    }
	 
	    public void saveUser(User user) {
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	        dao.save(user);
	    }
	
	    public void updateUser(User user) {
	        User entity = dao.findById(user.getIdUsuario());
	        if(entity!=null){
	        	
	        	entity.setEmail(user.getEmail());
	            if(!user.getPassword().equals(entity.getPassword())){
	                entity.setPassword(passwordEncoder.encode(user.getPassword()));
	            }
	            entity.setUsername(user.getUsername());
	            entity.setRolesUs(user.getRolesUs());
	        }
	    }
	 
	     
	    public void deleteUserByID(Integer Id) {
	        dao.deleteByID(Id);
	    }
	 
	    public List<User> findAllUsers() {
	        return dao.findAllUsers();
	    }
	 
	    public boolean isUserSSOUnique(Integer id, String username) {
	        User user = findByNombre(username);
	        return ( user == null || ((id != null) && (user.getIdUsuario() == id)));
	    }

}
