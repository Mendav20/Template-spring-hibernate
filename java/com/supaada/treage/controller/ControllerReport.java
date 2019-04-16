package com.supaada.treage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supaada.treage.dao.UserDao;
import com.supaada.treage.model.User;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/report")
public class ControllerReport {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	UserDao userDao;
	User user;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView generatedPdfReport(ModelAndView modelAndView) {
		logger.debug("generating PDF .....");
		List<User> userList = userDao.findAllUsers();
		Map<String,Object> param = new HashMap<String, Object>();
		System.out.println("atributos param" + param);
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(userList);
		param.put("dataSource", JRdataSource);
		System.out.println("param put " + param);
		modelAndView = new ModelAndView("pdfReport",param);
		return modelAndView;
	}
	

}
