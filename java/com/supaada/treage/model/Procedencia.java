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
@Table(name = "procedencia")
public class Procedencia implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProcedencia;
	
	@NotEmpty
	@Column(name = "NombreProcedencia", unique = true, nullable = false)
	private String nombreProcedencia;

	public Integer getIdProcedencia() {
		return idProcedencia;
	}

	public void setIdProcedencia(Integer idProcedencia) {
		this.idProcedencia = idProcedencia;
	}

	public String getNombreProcedencia() {
		return nombreProcedencia;
	}

	public void setNombreProcedencia(String nombreProcedencia) {
		this.nombreProcedencia = nombreProcedencia;
	}


}
