package com.s.sb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="student_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})   /**To avoid empty Object return**/
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int sid;
	@Column
	private String sname;
	@Column
	private String sroll;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSroll() {
		return sroll;
	}

	public void setSroll(String sroll) {
		this.sroll = sroll;
	}

}
