package com.supaada.treage.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.supaada.treage.model.RolesUs;
import com.supaada.treage.model.User;
import com.supaada.treage.service.UserProfileService;
import com.supaada.treage.service.UserService;

@Controller
@SessionAttributes("roles")
public class AppController {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userList";
	}
	
	@RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	 @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	    public String saveUser(@Valid User user, BindingResult result,
	            ModelMap model) {
		 
	 
	        if (result.hasErrors()) {
	        	System.out.println("algo es incorrecto..");
	        	System.out.println(result);
	            return "registration";
	        }
	 
	      
	        if(!userService.isUserSSOUnique(user.getIdUsuario(), user.getUsername())){
	            FieldError ssoError =new FieldError("user","username",messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
	            result.addError(ssoError);
	            return "registration";
	        }
	         
	        userService.saveUser(user);
	 
	        model.addAttribute("success", "user " + user.getUsername() + " registered successfully");
	        model.addAttribute("loggedinuser", getPrincipal());
	        return "registrationsuccess";
	    }
	 
	 @RequestMapping(value = {"/edit-user-{idUsuario}"},method = RequestMethod.GET)
	 public String editUser(@PathVariable int idUsuario, ModelMap model) {
		 User user = userService.findById(idUsuario);
		 model.addAttribute("user", user);
		 model.addAttribute("edit",true);		 
		 model.addAttribute("loggedinuser", getPrincipal());
		 return "registration";
	 }
	 
	 @RequestMapping(value = {"/edit-user-{idUsuario}"}, method = RequestMethod.POST)
	 public String updaterUser(@Valid User user, BindingResult result, ModelMap model,@PathVariable int idUsuario) {
		 
		 if(result.hasErrors()) {			 
			 return "registration";
		 }
		 System.out.println("algo salio mal..");
		 userService.updateUser(user);
		 model.addAttribute("success", "User" + user.getUsername() + "updated successfully");
		 model.addAttribute("loggedinuser", getPrincipal());
		 return "registrationsuccess";
	 }
	 
	 @RequestMapping(value = {"/delete-user-{idUsuario}"}, method = RequestMethod.GET)
	 public String deleteUser(@PathVariable Integer idUsuario) {
		 userService.deleteUserByID(idUsuario);
			 return "redirect:/list";
	 }
	 
	 @ModelAttribute("roles")
	 public List<RolesUs>initializerProfiles(){
		 return userProfileService.findAll();
	 }
	 
	 @RequestMapping(value = "/Acces_Denied", method = RequestMethod.GET)
	 public String accessDeniedPage(ModelMap model) {
		 model.addAttribute("loggedinuser", getPrincipal());
		 return "accesDenied";
	 }
	 
	 @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	 public String loginPage() {
		 if(isCurrentAuthenticationAnonymous()) {
			 return "login";
		 }else {
			 return "redirect:/list";
		 }
	 }
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth !=null) {
			 persistentTokenBasedRememberMeServices.logout(request, response, auth);
			 SecurityContextHolder.getContext().setAuthentication(null);
		 }
		 return "redirect:/login?logout";		 
	 }
	 
	 private String getPrincipal(){
		 String userName = null;
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 if(principal instanceof UserDetails) {
			 userName = ((UserDetails)principal).getUsername();
		 }else {
			 userName = principal.toString();
		 }
		 return userName;
	 }
	 
	 private boolean isCurrentAuthenticationAnonymous() {
		 final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 return authenticationTrustResolver.isAnonymous(authentication);
	 }
		
	 }
