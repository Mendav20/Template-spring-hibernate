package com.supaada.treage.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.supaada.treage.configuration"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFacory = new LocalSessionFactoryBean();
		sessionFacory.setDataSource(dataSource());
		sessionFacory.setPackagesToScan(new String[] {"com.supaada.treage.model"});
		sessionFacory.setHibernateProperties(hibernateProperties());
		return sessionFacory;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	
	
	private Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.fromat_sql", env.getRequiredProperty("hibernate.format_sql"));
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txtManager = new HibernateTransactionManager();
		txtManager.setSessionFactory(s);
		return txtManager;
	}

}
