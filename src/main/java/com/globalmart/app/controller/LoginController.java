package com.globalmart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Admin;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;
import com.globalmart.app.services.CustomerServices;

@RestController
public class LoginController {

	@Autowired
	private AdminServices adminServices;

	@Autowired
	private CustomerServices customerServices;

	@GetMapping("login/admin/{adminName}")
	public List<Admin> getAdminByName(@PathVariable("adminName") String name,
			@RequestParam(value = "password") String password) throws GlobalMartException {

		return adminServices.getAdminByNameAndPassword(name, password);
	}

	@GetMapping("login/customer/{userName}")
	public List<Customer> getCustomerByUserName(@RequestParam(value = "userName") String userName,
			@PathVariable(value = "password") String password) throws GlobalMartException {
				
		return customerServices.getCustomerByUserNameAndPassword(userName, password);

	}
}
