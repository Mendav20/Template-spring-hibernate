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
@Table(name = "destino")
public class Destino implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDestino;
	
	@NotEmpty
	@Column(name = "NombreDestino", unique = true, nullable = false)
	private String nombreDestino;

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public String getNombreDestino() {
		return nombreDestino;
	}

	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}
	
	

}
