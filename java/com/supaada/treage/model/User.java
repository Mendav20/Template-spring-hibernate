package com.supaada.treage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@NotEmpty
	@Column(name = "Username", unique = true, nullable = false)
	private String username;	
	
	@NotEmpty
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	
	@NotEmpty
	@Column(name = "Password", unique = true, nullable = false)
	private String password;


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public Set<RolesUs> getRolesUs() {
		return rolesUs;
	}


	public void setRolesUs(Set<RolesUs> rolesUs) {
		this.rolesUs = rolesUs;
	}


	public Set<Hospital> getHospital() {
		return hospital;
	}


	public void setHospital(Set<Hospital> hospital) {
		this.hospital = hospital;
	}


	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_has_rolusuario", 
				joinColumns = { @JoinColumn(name = "usuario_idUsuario" )},
				inverseJoinColumns = {@JoinColumn(name = "rolusuario_idRolUsuario")})  
	private Set<RolesUs> rolesUs = new HashSet<RolesUs>(); 


	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hospital_has_usuario", 
				joinColumns = { @JoinColumn(name = "hospital_idHospital" )},
				inverseJoinColumns = {@JoinColumn(name = "usuario_idUsuario")})  
	private Set<Hospital> hospital = new HashSet<Hospital>(); 


}
