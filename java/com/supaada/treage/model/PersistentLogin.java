package com.supaada.treage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "persistentlogin")
public class PersistentLogin implements Serializable{
	
	@Id
	private String Series;
	
	@Column(name = "Username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "Token", unique = true, nullable = false)
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUsed;
	
	
	public String getSeries() {
		return Series;
	}
	public void setSeries(String series) {
		Series = series;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token=token;
	}
	public Date getLastUsed() {
		return lastUsed;
	}
	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
}
