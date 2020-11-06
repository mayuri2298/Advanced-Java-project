package com.cdac.cntr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Admin;
import com.cdac.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping(value = "/admin_register_form.htm",method = RequestMethod.GET)
	public String adminRegForm(ModelMap map) {
		map.put("admin", new Admin());
		return "admin_reg_form";
	}
	@RequestMapping(value = "/register_admin.htm",method = RequestMethod.POST)
	public String adminRegister(Admin admin,ModelMap map) {
		adminService.addAdmin(admin);
		return "index";
	}
	@RequestMapping(value = "/admin_login_form.htm",method = RequestMethod.GET)
	public String adminLoginForm(ModelMap map) {
		map.put("admin", new Admin());
		return "admin_log_form";
	}
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String adminLogin(Admin admin,ModelMap map) {
		boolean b = adminService.findAdmin(admin);
		if(b) {
			return "admin_home";
		}
		else {
			map.put("admin", new Admin());
			return "admin_log_form";
		}
	}
}












