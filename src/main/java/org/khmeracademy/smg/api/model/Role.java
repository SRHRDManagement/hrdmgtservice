package org.khmeracademy.smg.api.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	@JsonProperty("ID")
	private int rol_id;
	@JsonProperty("NAME")
	private String rol_title;
	
	public Role() {
		rol_title = "";
	}

	public int getRol_id() {
		return rol_id;
	}

	public String getRol_title() {
		return rol_title;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public void setRol_title(String rol_title) {
		this.rol_title = rol_title;
	}

	@Override
	public String getAuthority() {
		return rol_title;
	}

}
