package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue
	@Column(name = "admin_id")
	private int adminId;
	@Column(name = "admin_name")
	private String adminName;
	@Column(name = "password")
	private String adminPass;
	private String gender;
	@Column(name = "admin_age")
	private float adminAge;
	public Admin() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getAdminAge() {
		return adminAge;
	}
	public void setAdminAge(float adminAge) {
		this.adminAge = adminAge;
	}
	@Override
	public String toString() {
		return adminId + " " + adminName + " " + adminPass + " "
				+ gender + " " + adminAge;
	}
	
	
	
	
}
