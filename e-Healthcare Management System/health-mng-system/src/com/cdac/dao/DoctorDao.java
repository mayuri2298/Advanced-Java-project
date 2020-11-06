package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Doctor;

public interface DoctorDao {
	void insertDoctor(Doctor doctor);
	void deleteDoctor(int doctorId);
	void updateDoctor(Doctor doctor);
	Doctor selectDoctor(int doctorId);
	List<Doctor> selectAll();
	boolean checkDoctor(Doctor doctor);
}
