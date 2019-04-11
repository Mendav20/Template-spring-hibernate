package com.supaada.treage.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name = "SSO-ID", unique = true, nullable = false)
	private String ssoId;
	
	@NotEmpty
	@Column(name = "PASSWORD", unique = true, nullable = false)
	private String password;
	
	@NotEmpty
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "APP-USER_USER_PROFILE", 
				joinColumns = { @JoinColumn(name = "USER_ID" )},
				inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")})
	
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(); 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getssoId() {
		return ssoId;
	}
	public void setssoId(String ssoId) {
		this.ssoId=ssoId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public Set<UserProfile> getUserProfiles(){
		return userProfiles;
	}
	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles=userProfiles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result= prime * result + ((id==null) ? 0 :id.hashCode());
		result= prime * result +((ssoId==null) ? 0:ssoId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj)
			return true;
		if(obj==null)
			return false;
		if(!(obj instanceof User))
			return false;
		User other = (User) obj;
		if(id==null) {
			if(other.id !=null)
				return false;
		}else if(!id.equals(other.id))
			return false;
		if(ssoId==null) {
			if(other.ssoId!= null)
				return false;
		}else if(!ssoId.equals(other.ssoId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id" + id + ",ssoId=" + ssoId + ", password=" + password + ",username" + username + "]";
	}

}
