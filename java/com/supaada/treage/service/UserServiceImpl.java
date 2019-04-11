package com.supaada.treage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
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
	    
	     
	    public User findById(int id) {
	        return dao.findById(id);
	    }
	 
	    public User findBySSO(String sso) {
	        User user = dao.findBySSO(sso);
	        return user;
	    }
	 
	    public void saveUser(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        dao.save(user);
	    }
	
	    public void updateUser(User user) {
	        User entity = dao.findById(user.getId());
	        if(entity!=null){
	            entity.setssoId(user.getssoId());
	            if(!user.getPassword().equals(entity.getPassword())){
	                entity.setPassword(passwordEncoder.encode(user.getPassword()));
	            }
	            entity.setUsername(user.getUsername());
	            entity.setUserProfiles(user.getUserProfiles());
	        }
	    }
	 
	     
	    public void deleteUserBySSO(String sso) {
	        dao.deleteBySSO(sso);
	    }
	 
	    public List<User> findAllUsers() {
	        return dao.findAllUsers();
	    }
	 
	    public boolean isUserSSOUnique(Integer id, String sso) {
	        User user = findBySSO(sso);
	        return ( user == null || ((id != null) && (user.getId() == id)));
	    }

}
