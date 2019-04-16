package com.supaada.treage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "rolusuario")
public class RolesUs implements Serializable{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRolUsuario;
	
	
	@Column(name = "NombreRol", unique = true, nullable = false)
	private String NombreRol;

	public Integer getIdRolUsuario() {
		return idRolUsuario;
	}

	public void setIdRolUsuario(Integer idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_has_rolusuario", 
				joinColumns = { @JoinColumn(name = "rolusuario_idRolUsuario" )},
				inverseJoinColumns = {@JoinColumn(name = "usuario_idUsuario")})  
	private Set<RolesUs> rolesUs = new HashSet<RolesUs>(); 


}
