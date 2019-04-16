package com.supaada.treage.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "criterio")
public class Criterio implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCriterio;
	
	@NotEmpty
	@Column(name = "Nombre", unique = true, nullable = false)
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipocriterio_idTipoCriterio")
	private TipoCriterio tipoCriterio;

}
