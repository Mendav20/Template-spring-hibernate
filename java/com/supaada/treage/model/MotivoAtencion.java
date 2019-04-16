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
@Table(name = "motivoatencion")
public class MotivoAtencion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMotivoAtencion;
	
	@NotEmpty
	@Column(name = "DiagnosticoProb", unique = true, nullable = false)
	private String diagnosticoProb;

	public Integer getIdMotivoAtencion() {
		return idMotivoAtencion;
	}

	public void setIdMotivoAtencion(Integer idMotivoAtencion) {
		this.idMotivoAtencion = idMotivoAtencion;
	}

	public String getDiagnosticoProb() {
		return diagnosticoProb;
	}

	public void setDiagnosticoProb(String diagnosticoProb) {
		this.diagnosticoProb = diagnosticoProb;
	}

	
}
