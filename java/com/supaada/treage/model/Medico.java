package com.supaada.treage.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "medico")
public class Medico implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@NotEmpty
	@Column(name = "NombreMedico", unique = true, nullable = false)
	private String nombremedico;

	@NotEmpty
	@Column(name = "ApellidoPat", unique = true, nullable = false)
	private String apellidopat;
	
	@NotEmpty
	@Column(name = "ApellidoMat", unique = true, nullable = false)
	private String apellidomat;
	
	@NotEmpty
	@Column(name = "Matricula", unique = true, nullable = false)
	private String matricula;
	
	
	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombremedico() {
		return nombremedico;
	}

	public void setNombremedico(String nombremedico) {
		this.nombremedico = nombremedico;
	}

	public String getApellidopat() {
		return apellidopat;
	}

	public void setApellidopat(String apellidopat) {
		this.apellidopat = apellidopat;
	}

	public String getApellidomat() {
		return apellidomat;
	}

	public void setApellidomat(String apellidomat) {
		this.apellidomat = apellidomat;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tiempoatencion_idTiempoAtencion")
	private TiempoAtencion tiempoAtencion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_idHospital")
	private Hospital hospital;
}
