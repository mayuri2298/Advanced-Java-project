package com.cdac.service;

import java.util.List;

import com.cdac.dto.Doctor;

public interface DoctorService {
	void addDoctor(Doctor doctor);
	void removeDoctor(int doctorId);
	void modifyDoctor(Doctor doctor);
	Doctor findDoctor(int doctorId);
	List<Doctor> doctorList();
	boolean checDoctor(Doctor doctor);
}
