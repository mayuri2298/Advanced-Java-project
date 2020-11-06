package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Patient;

public interface PatientDao {
	void insertPatient(Patient patient);
	void deletePatient(int patientId);
	void updatePatient(Patient patient);
	Patient selectPatient(int patientId);
	List<Patient> selectAll(int doctorId);
	boolean checkPatient(Patient patient);
}
