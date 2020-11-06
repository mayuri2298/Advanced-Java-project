package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Doctor;
import com.cdac.dto.Patient;
import com.cdac.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "/patient_add_form.htm",method = RequestMethod.GET)
	public String addPatientForm(ModelMap map) {
		map.put("patient", new Patient());
		return "patient_form";
	}
	@RequestMapping(value = "/patient_add.htm",method = RequestMethod.POST)
	public String addPatient(Patient patient,HttpSession session,ModelMap map) {
		int doctorId =((Doctor)session.getAttribute("doctor")).getDoctorId();
		patient.setDoctorId(doctorId);
		patientService.addPatient(patient);
		return "doctor_home";
	}
	@RequestMapping(value = "/patient_list.htm",method = RequestMethod.GET)
	public String patientList(ModelMap map,HttpSession session) {
		
			int doctorId =((Doctor)session.getAttribute("doctor")).getDoctorId();
			List <Patient> p = patientService.patientList(doctorId);
			map.put("patientList", p);
			return "list_of_patients";
	}
	
	@RequestMapping(value = "/patient_delete.htm",method = RequestMethod.GET)
	public String deletePatient(@RequestParam int patientId,ModelMap map,HttpSession session) {
		patientService.removePatient(patientId);
		int doctorId = ((Doctor)session.getAttribute("doctor")).getDoctorId();
		
		List<Patient> p = patientService.patientList(doctorId);
		map.put("patientList", p);
		return "list_of_patients";
	}
	@RequestMapping(value = "/patient_update_form.htm",method = RequestMethod.GET)
	public String updatePatientForm(@RequestParam int patientId,ModelMap map) {
		Patient p = patientService.getPatient(patientId);
		map.put("patient", p);
		return "patient_update_form";
	}
	@RequestMapping(value = "/patient_update.htm",method = RequestMethod.POST)
	public String updatePatient(Patient patient,ModelMap map,HttpSession session) {
		int doctorId = ((Doctor)session.getAttribute("doctor")).getDoctorId();
		patient.setDoctorId(doctorId);
		patientService.modifyPatient(patient);
		List<Patient> p = patientService.patientList(doctorId);
		map.put("patientList", p);
		return "list_of_patients";
	}
	@RequestMapping(value = "/generate_report.htm",method = RequestMethod.GET)
	public String generateReport(@RequestParam int patientId,ModelMap map) {
		Patient p = patientService.getPatient(patientId);
		map.put("patient", p);
		return "patient_report";
	}
	@RequestMapping(value = "/patient_details.htm",method = RequestMethod.GET)
	public String patientDetail(ModelMap map) {
		map.put("patient", new Patient());
		return "patient_detail";
	}
	@RequestMapping(value = "/patient_generate_report.htm",method = RequestMethod.POST)
	public String generate(Patient patient,HttpSession session,ModelMap map) {
			boolean b = patientService.checPatient(patient);
			if(b) {
				Patient p = patientService.getPatient(patient.getPatientId());
				session.setAttribute("patient", p);
				return "report";
			}else {
				map.put("patient", new Patient());
				return "patient_detail";
			}
			
		}		
		
	}


















