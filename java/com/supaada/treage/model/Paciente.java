package com.supaada.treage.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@NotEmpty
	@Column(name = "Nombre", unique = true, nullable = false)
	private String nombrePaciente;

	@NotEmpty
	@Column(name = "ApellidoPat", unique = true, nullable = false)
	private String apellidoPat;
	
	@NotEmpty
	@Column(name = "ApellidoMat", unique = true, nullable = false)
	private String apellidoMat;
	
	@NotEmpty
	@Column(name = "Sexo", unique = true, nullable = false)
	private String sexoPaciente;
	
	@NotEmpty
	@Column(name = "Edad", unique = true, nullable = false)
	private Integer edad;
	
	@NotEmpty
	@Column(name = "Nss", unique = true, nullable = false)
	private String nss;
	
	@NotEmpty
	@Column(name = "Numf", unique = true, nullable = false)
	private Integer numf;
	
	@NotEmpty
	@Column(name = "FechaAtencion", unique = true, nullable = false)
	private Date fechaAtencion;
	
	@NotEmpty
	@Column(name = "NivelUrgencia", unique = true, nullable = false)
	private String nivelUrgencia;
	
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getSexoPaciente() {
		return sexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public Integer getNumf() {
		return numf;
	}

	public void setNumf(Integer numf) {
		this.numf = numf;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(String nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipopaciente_idTipoPaciente")
	private TipoPaciente tipoPaciente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "procedencia_idProcedencia")
	private Procedencia procedencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destino_idDestino")
	private Destino destino;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "motivoatencion_idMotivoAtencion")
	private MotivoAtencion motivoAtencion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medico_idMedico")
	private Medico medico;
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "criterio_paciente", joinColumns = { @JoinColumn(name =
	 * "idCriterio_Paciente" )}, inverseJoinColumns = {@JoinColumn(name =
	 * "criterio1_idCriterio1")}) private Set<Criterio1> criterio1 = new
	 * HashSet<Criterio1>();
	 */

}
