package com.supaada.treage.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supaada.treage.model.PersistentLogin;



@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin>
		implements PersistentTokenRepository {
	static final Logger logger = (Logger) LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		logger.info("Creating Token for user : {}", token.getUsername());
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLastUsed(token.getDate());
		persist(persistentLogin);
		
		
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		logger.info("Updating Token for seriesId : {}", series);
		PersistentLogin persistentLogin = getByKey(series);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLastUsed(lastUsed);
		update(persistentLogin);
		
		
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String series) {
		logger.info("Fect TOken if any for seriesId : {}", series);
		try {
			Criteria crit = createEntityCriteria();
			crit.add(Restrictions.eq("series", series));
			PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
			
			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLastUsed());
			
		} catch (Exception e) {
			logger.info("Token not found...");
			return null;
		}
		
	}


	@Override
	public void removeUserTokens(String username) {
		logger.info("Removing Token if any user : {}", username);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
		if(persistentLogin !=null) {
			logger.info("rememberMe was selected");
			delete(persistentLogin);
		}
		
	}

}
