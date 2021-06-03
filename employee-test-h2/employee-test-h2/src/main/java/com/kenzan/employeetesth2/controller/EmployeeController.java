package com.kenzan.employeetesth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kenzan.employeetesth2.entity.Employee;
import com.kenzan.employeetesth2.service.EmployeeService;



@RestController
@RequestMapping("/employees")

public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<Object>(service.createEmployee(employee), HttpStatus.CREATED);
		} catch (Exception x) {
			return new ResponseEntity<>("Could not create employee please try again", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable int id) {
		try {
			return new ResponseEntity<Object>(service.getEmployeeById(id), HttpStatus.OK);
		} catch (Exception x) {
			return new ResponseEntity<Object>(x.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		return new ResponseEntity<Object>(service.getEmployees(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		try {
			service.deleteEmployee(id);
			return new ResponseEntity<Object>("the employee with ID:" + id + " has been Deactivated", HttpStatus.OK);
		} catch (Exception x) {
			return new ResponseEntity<Object>(x.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		try {
			return new ResponseEntity<Object>(service.updateEmployee(id, employee), HttpStatus.OK);
		} catch (Exception x) {
			return new ResponseEntity<Object>(x.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
