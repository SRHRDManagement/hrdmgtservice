package org.khmeracademy.smg.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollStaff {
	
	@JsonProperty("SPID")
	private int sp_id;
	@JsonProperty("CLAID")
	private int cla_id;
	@JsonProperty("SUBID")
	private int sub_id;
	@JsonProperty("STAID")
	private int sta_id;
	@JsonProperty("GENID")
	private int gen_id;
	@JsonProperty("COUID")
	private int cou_id;
	private Generation generation;
	private Course course;
	private Class clas;
	private Subject subject;
	private Staff staff;
	 
	public Generation getGeneration() {
		return generation;
	}
	public Course getCourse() {
		return course;
	}
	public Class getClas() {
		return clas;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setGeneration(Generation generation) {
		this.generation = generation;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setClas(Class clas) {
		this.clas = clas;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getSp_id() {
		return sp_id;
	}
	public int getCla_id() {
		return cla_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public int getSta_id() {
		return sta_id;
	}
	public int getGen_id() {
		return gen_id;
	}
	public int getCou_id() {
		return cou_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	public void setCla_id(int cla_id) {
		this.cla_id = cla_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public void setSta_id(int sta_id) {
		this.sta_id = sta_id;
	}
	public void setGen_id(int gen_id) {
		this.gen_id = gen_id;
	}
	public void setCou_id(int cou_id) {
		this.cou_id = cou_id;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
