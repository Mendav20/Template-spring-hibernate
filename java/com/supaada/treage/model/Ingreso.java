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
@Table(name = "ingreso")
public class Ingreso implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngreso;
	
	@NotEmpty
	@Column(name = "Valor", unique = true, nullable = false)
	private String valor;	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medico_idMedico")
	private Criterio criterio;
}
