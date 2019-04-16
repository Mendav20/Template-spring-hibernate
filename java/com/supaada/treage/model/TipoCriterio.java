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
@Table(name = "tipocriterio")
public class TipoCriterio implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoCriterio;
	
	@NotEmpty
	@Column(name = "TipoCriterio", unique = true, nullable = false)
	private String tipoCriterio;

}
