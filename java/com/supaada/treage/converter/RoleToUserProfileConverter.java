package com.supaada.treage.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.supaada.treage.model.RolesUs;
import com.supaada.treage.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, RolesUs>{
	
	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	UserProfileService userProfileService;
	
	
	public RolesUs convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		RolesUs profile = userProfileService.findById(id);
		logger.info("Profile : {}",profile);
		return profile;
	}
	
	

}
