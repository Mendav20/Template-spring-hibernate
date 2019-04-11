package com.supaada.treage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supaada.treage.dao.UserProfileDao;
import com.supaada.treage.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	 @Autowired
	    UserProfileDao dao;
	     
	    public UserProfile findById(int id) {
	        return dao.findById(id);
	    }
	 
	    public UserProfile findByType(String type){
	        return dao.findByType(type);
	    }
	 
	    public List<UserProfile> findAll() {
	        return dao.findAll();
	    }

}
