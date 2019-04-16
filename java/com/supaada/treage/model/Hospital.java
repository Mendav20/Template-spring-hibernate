package com.supaada.treage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "hospital")
public class Hospital implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idHospital;
	
	@NotEmpty
	@Column(name = "NombreHospital", unique = true, nullable = false)
	private String nombrehospital;
	
	@NotEmpty
	@Column(name = "Direccion", unique = true, nullable = false)
	private String direccion;
	
	@NotEmpty
	@Column(name = "Telefono", unique = true,nullable = false )
	private Boolean telefono;
	
	@NotEmpty
	@Column(name = "CP", unique = true, nullable = false)
	private Boolean cp;
	
	@NotEmpty
	@Column(name = "Nivel", unique = true, nullable = false)
	private String nivel;
	
	@NotEmpty
	@Column(name = "TipoHospital", unique = true, nullable = false)
	private String tipohospital;			
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ciudad_idCiudad")
	private Ciudad ciudad;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estado_idEstado")
	private Estado estado;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "hospital_has_usuario", 
				joinColumns = { @JoinColumn(name = "hospital_idHospital" )},
				inverseJoinColumns = {@JoinColumn(name = "usuario_idUsuario")})  
	private Set<User> user = new HashSet<User>(); 
	    
}
