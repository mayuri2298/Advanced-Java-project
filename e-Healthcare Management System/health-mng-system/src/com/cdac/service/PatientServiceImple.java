package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.PatientDao;
import com.cdac.dto.Patient;
@Service
public class PatientServiceImple implements PatientService{
	@Autowired
	private PatientDao patientDao;
	@Override
	public void addPatient(Patient patient) {
		patientDao.insertPatient(patient);
		
	}

	@Override
	public void removePatient(int patientId) {
		patientDao.deletePatient(patientId);
		
	}

	@Override
	public void modifyPatient(Patient patient) {
		patientDao.updatePatient(patient);
		
	}

	@Override
	public Patient getPatient(int patientId) {
		
		return patientDao.selectPatient(patientId);
	}

	@Override
	public List<Patient> patientList(int doctorId) {
		return patientDao.selectAll(doctorId);
	}

	@Override
	public boolean checPatient(Patient patient) {
		
		return patientDao.checkPatient(patient);
	}
	
}
