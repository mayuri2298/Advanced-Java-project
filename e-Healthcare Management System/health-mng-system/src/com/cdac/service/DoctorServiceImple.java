package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.DoctorDao;
import com.cdac.dto.Doctor;

@Service
public class DoctorServiceImple implements DoctorService{
	@Autowired
	private DoctorDao doctorDao;
	@Override
	public void addDoctor(Doctor doctor) {
		doctorDao.insertDoctor(doctor);
		
	}

	@Override
	public void removeDoctor(int doctorId) {
		doctorDao.deleteDoctor(doctorId);
		
	}

	@Override
	public void modifyDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
		
	}

	@Override
	public Doctor findDoctor(int doctorId) {
		return doctorDao.selectDoctor(doctorId);
	}

	@Override
	public List<Doctor> doctorList() {

		return doctorDao.selectAll();
	}

	@Override
	public boolean checDoctor(Doctor doctor) {
		
		return doctorDao.checkDoctor(doctor);
	}

}
