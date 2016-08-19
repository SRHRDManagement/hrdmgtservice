package org.khmeracademy.smg.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollStudent {
	@JsonProperty("SEID")
	private int se_id;
	@JsonProperty("CLASS")
	private Class classx;
	@JsonProperty("STUDENT")
	private Student student;
	@JsonProperty("CLAID")
	private int cla_id;
	@JsonProperty("STUID")
	private int stu_id;
	
	public int getCla_id() {
		return cla_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setCla_id(int cla_id) {
		this.cla_id = cla_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getSe_id() {
		return se_id;
	}
	public Class getClassx() {
		return classx;
	}
	public void setSe_id(int se_id) {
		this.se_id = se_id;
	}
	public void setClassx(Class classx) {
		this.classx = classx;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
