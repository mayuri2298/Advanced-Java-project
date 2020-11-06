package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue
	@Column(name = "doctor_d")
	private int doctorId;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name = "doctor_password")
	private String doctorPass;
	@Column(name = "speciality")
	private String  doctorSpcl;
	@Column(name = "mobile_no")
	private String mobNo;
	public Doctor() {
		super();
	}
	
	public Doctor(int doctorId) {
		super();
		this.doctorId = doctorId;
	}

	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorPass() {
		return doctorPass;
	}

	public void setDoctorPass(String doctorPass) {
		this.doctorPass = doctorPass;
	}

	public String getDoctorSpcl() {
		return doctorSpcl;
	}
	public void setDoctorSpcl(String doctorSpcl) {
		this.doctorSpcl = doctorSpcl;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	@Override
	public String toString() {
		return doctorId + " " + doctorName + " " + doctorPass
				+ " " + doctorSpcl + " " + mobNo;
	}
	
}
