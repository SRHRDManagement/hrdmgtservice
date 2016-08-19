	package org.khmeracademy.smg.api.model;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("ID")
	private int usr_id;
	@JsonProperty("EMAIL")
	private String usr_email;
	@JsonProperty("PASSWORD")
	private String usr_password;
	@JsonProperty("USRDATE")
	private Date usr_date;
	private Role role;
	private List<Role> roles;
	
	@JsonProperty("USRFIRSTNAME")
	private String usr_firstname;
	@JsonProperty("USRLASTNAME")
	private String usr_lastname;
	@JsonProperty("USRGENDER")
	private String usr_gender;
	@JsonProperty("USRPHONE")
	private String usr_phone;
	@JsonProperty("USRAVATAR")
	private String usr_avatar;
	@JsonProperty("USRSTATUS")
	private boolean usr_status;
	@JsonProperty("ROLE_ID")
	private int rol_id;
	@JsonProperty("STUID")
	private int stu_id;
	@JsonProperty("STAID")
	private int sta_id;

	public int getStu_id() {
		return stu_id;
	}
	public int getSta_id() {
		return sta_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public void setSta_id(int sta_id) {
		this.sta_id = sta_id;
	}
	public String getUsr_firstname() {
		return usr_firstname;
	}
	public String getUsr_lastname() {
		return usr_lastname;
	}
	public String getUsr_gender() {
		return usr_gender;
	}
	public String getUsr_phone() {
		return usr_phone;
	}
	public String getUsr_avatar() {
		return usr_avatar;
	}
	public boolean isUsr_status() {
		return usr_status;
	}
	public void setUsr_firstname(String usr_firstname) {
		this.usr_firstname = usr_firstname;
	}
	public void setUsr_lastname(String usr_lastname) {
		this.usr_lastname = usr_lastname;
	}
	public void setUsr_gender(String usr_gender) {
		this.usr_gender = usr_gender;
	}
	public void setUsr_phone(String usr_phone) {
		this.usr_phone = usr_phone;
	}
	public void setUsr_avatar(String usr_avatar) {
		this.usr_avatar = usr_avatar;
	}
	public void setUsr_status(boolean usr_status) {
		this.usr_status = usr_status;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	public int getUsr_id() {
		return usr_id;
	}

	public String getUsr_email() {
		return usr_email;
	}

	public String getUsr_password() {
		return usr_password;
	}

	public Date getUsr_date() {
		return usr_date;
	}

	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}

	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}

	public void setUsr_date(Date usr_date) {
		this.usr_date = usr_date;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usr_password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usr_email;
	}
	public int getRol_id() {
		return rol_id;
	}
	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}
	
	
}
