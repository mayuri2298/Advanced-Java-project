package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue
	@Column(name = "patient_id")
	private int patientId;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "age")
	private float patientAge;
	@Column(name = "weight")
	private float patientWeight;
	@Column(name = "mob_no")
	private String mobNo;
	private String city;
	private String state;
	@Column(name = "blood_group")
	private String bloodGrp;
	private String disease;
	private String symptoms;
	private String comments;
	private String medicine;
	private int doctorId;
	public Patient() {
		super();
	}
	
	public Patient(int patientId) {
		super();
		this.patientId = patientId;
	}
	

	public Patient(String mobNo) {
		super();
		this.mobNo = mobNo;
	}

	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public float getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(float patientAge) {
		this.patientAge = patientAge;
	}
	public float getPatientWeight() {
		return patientWeight;
	}
	public void setPatientWeight(float patientWeight) {
		this.patientWeight = patientWeight;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return patientId + " " + patientName + " " + patientAge
				+ " " + patientWeight + " " + mobNo + " " + city + " " + state
				+ " " + bloodGrp + " " + disease + " " + symptoms + " "
				+ comments + " " + medicine + " " + doctorId;
	}
	
}
