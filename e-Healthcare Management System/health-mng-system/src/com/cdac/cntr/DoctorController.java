package com.cdac.cntr;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Doctor;
import com.cdac.service.DoctorService;
import com.cdac.valid.DoctorValidator;


@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DoctorValidator doctorValidator;
	@RequestMapping(value = "/doctor_register_form.htm",method = RequestMethod.GET)
	public String addDoct(ModelMap map) {
		map.put("doctor", new Doctor());
		return "add_doct_form";
	}
	@RequestMapping(value = "/reg_doctor.htm",method = RequestMethod.POST)
	public String regDoct(Doctor doctor,ModelMap map) {
		doctorService.addDoctor(doctor);
		return "admin_home";
	}
	@RequestMapping(value = "/doctor_list.htm",method = RequestMethod.GET)
	public String doctList(ModelMap map) {
		List<Doctor> l = doctorService.doctorList();
		map.put("doctorList", l);
		return "doctor_list";
	}
	@RequestMapping(value = "/doctor_delete.htm",method = RequestMethod.GET)
	public String deleteDoctor(@RequestParam int doctorId,ModelMap map) {
		doctorService.removeDoctor(doctorId);
		List<Doctor> l = doctorService.doctorList();
		map.put("doctorList", l);
		return "doctor_list";
	}
	@RequestMapping(value = "/doctor_update_form.htm",method = RequestMethod.GET)
	public String updateDoctor(@RequestParam int doctorId,ModelMap map) {
		Doctor d = doctorService.findDoctor(doctorId);
		map.put("doctor", d);
		return "update_doctor_form";
	}
	@RequestMapping(value = "/update_doctor.htm",method = RequestMethod.POST)
	public String updateDoct(Doctor doctor,ModelMap map) {
		doctorService.modifyDoctor(doctor);
		List<Doctor> l = doctorService.doctorList();
		map.put("doctorList", l);
		return "doctor_list";
	}
	@RequestMapping(value = "/doctor_login_form.htm",method = RequestMethod.GET)
	public String loginDoct(ModelMap map) {
		map.put("doctor", new Doctor());
		return "doctor_login_form";
	}
	@RequestMapping(value = "/doct_login.htm",method = RequestMethod.POST)
	public String logDoct(Doctor doctor,BindingResult result,ModelMap map,HttpSession session) {
		doctorValidator.validate(doctor, result);
		if(result.hasErrors()) {
			return "doctor_login_form";
		}
		boolean b = doctorService.checDoctor(doctor);
		if(b) {
			session.setAttribute("doctor", doctor);
			return "doctor_home";
		}else {
			map.put("doctor", new Doctor());
			return "doctor_login_form";
		}
	}
	@RequestMapping(value = "/logout.htm",method = RequestMethod.GET)
	public String logoutDoctor(HttpSession session,ModelMap map) {
		
		session.removeAttribute("doctor");
		session.invalidate();
		map.put("doctor", new Doctor());
		return "doctor_login_form";
		
	}
}














