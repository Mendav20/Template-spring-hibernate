package com.supaada.treage.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tipopaciente")
public class TipoPaciente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPaciente;
	
	@NotEmpty
	@JoinColumn(name = "TipoPaciente", unique = true, nullable = false)
	private String TipoPaciente;
	
	public Integer getidTipoPaciente() {
		return idTipoPaciente;
	}
	public void setidTipoPaciente(Integer IdTipoPaciente) {
		this.idTipoPaciente = IdTipoPaciente;
	}
	
	public String getTipoPaciente() {
		return TipoPaciente;
	}
	public void setTipoPaciente(String TipoPaciente) {
		this.TipoPaciente = TipoPaciente;
	}

}
