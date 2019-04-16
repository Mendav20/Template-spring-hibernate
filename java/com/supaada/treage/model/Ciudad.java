package com.supaada.treage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCiudad;
	
	@NotEmpty
	@Column(name = "NombreCiudad", unique = true, nullable = false)
	private String nombreciudad;

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreciudad() {
		return nombreciudad;
	}

	public void setNombreciudad(String nombreciudad) {
		this.nombreciudad = nombreciudad;
	}
	
	
}
