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
@Table(name = "estado")
public class Estado implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;
	
	@NotEmpty
	@Column(name = "NombreEstado")
	private String nombreestado;
	
	public Integer getidEstados() {
		return idEstado;
	}
	
	public void setidEstados(String nombreestado) {
		this.nombreestado = nombreestado;
	}

}
