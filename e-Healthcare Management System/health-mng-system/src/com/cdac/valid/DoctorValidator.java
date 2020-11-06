package com.cdac.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Doctor;

@Service
public class DoctorValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Doctor.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctorName","unmKey", "name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctorPass", "passKey","password required");
		
		Doctor dr = (Doctor)target;
		if(dr.getDoctorPass()!=null) {
			if(dr.getDoctorPass().length()<3) { 
				errors.rejectValue("doctorPass", "passKey", "password should contain more than 2 chars");
			}
		}
	}
	
}
