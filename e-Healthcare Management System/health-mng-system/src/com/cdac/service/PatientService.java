package com.cdac.service;

import java.util.List;

import com.cdac.dto.Patient;

public interface PatientService {
	void addPatient(Patient patient);
	void removePatient(int patientId);
	void modifyPatient(Patient patient);
	Patient getPatient(int patientId);
	List<Patient> patientList(int doctorId);
	boolean checPatient(Patient patient);
}
