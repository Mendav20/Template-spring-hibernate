package com.supaada.treage.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tiempoatencion")
public class TiempoAtencion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTiempoAtencion;
	
	@NotEmpty
	@Column(name = "HoraInicio", unique = true, nullable = false)
	private Date horaInicio;
	
	@NotEmpty
	@Column(name = "HoraFin", unique = true, nullable = false)
	private Date horaFin;
	
	
	public Integer getidTiempoAtencion() {
		return idTiempoAtencion;
	}
	public void setidTiempoAtencion(Integer idTiempoAtencion) {
		this.idTiempoAtencion = idTiempoAtencion;
	}
	
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date HoraInicio) {
		this.horaInicio = HoraInicio;
	}
	
	public Date getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Date HoraFin) {
		this.horaFin = HoraFin;
	}

}
