package com.kenzan.employeetesth2.service;

import org.springframework.stereotype.Service;

import com.kenzan.employeetesth2.entity.Employee;
import com.kenzan.employeetesth2.repository.EmployeeRepository;
import com.kenzan.employeetesth2.util.Status;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository rep;

	public Employee createEmployee(Employee employee) {
		int id = 0;
		employee.setId(id++);
		employee.setStatus(Status.ACTIVE);
		return rep.save(employee);

	}

	public List<Employee> getEmployees() {
		
		List<Employee> allEmployees = (List<Employee>) rep.findAll();
		List<Employee> activeEmployees = allEmployees
				.stream().filter(e -> e.getStatus() == Status.ACTIVE)
				.collect(Collectors.toList());
		
		return activeEmployees;
	}

	public Employee getEmployeeById(int id) throws Exception {
		Employee actEmp = rep.findById(id).get();
		try {
			if (actEmp.getStatus() == Status.ACTIVE)
				return actEmp;
		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered when trying to gather the Employee info with id: " + id, x);
			
		}
		throw new Exception("Could not successfully locate this Employee, please try again.");

	}

	public void deleteEmployee(int id) throws Exception {
		Employee delEmployee = rep.findById(id).get();
		try {
			delEmployee.setStatus(Status.INACTIVE);
			rep.save(delEmployee);

		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered when trying to delete Employee with id: " + id, x);
			throw new Exception("Could not successfully delete this Employee, please try again.");
		}

	}

	public Employee updateEmployee(int id, Employee employee) throws Exception {
		Employee olderEmployee = rep.findById(id).get();
		try {
			if (employee.getFirstName() != null) {
				olderEmployee.setFirstName(employee.getFirstName());
			}
			if (employee.getMiddleInitial() != null) {
				olderEmployee.setMiddleInitial(employee.getMiddleInitial());
			}
			if (employee.getLastName() != null) {
				olderEmployee.setLastName(employee.getLastName());
			}
			if (employee.getDateOfBirth() != null) {
				olderEmployee.setDateOfBirth(employee.getDateOfBirth());
			}
			if (employee.getDateOfEmployment() != null) {
				olderEmployee.setDateOfEmployment(employee.getDateOfEmployment());
			}
			if (employee.getStatus() != null) {
				olderEmployee.setStatus(employee.getStatus());
			}
			return rep.save(olderEmployee);

		} catch (Exception x) {
			LOGGER.error("An Exception was Triggered in Employee Service when trying to update Employee with id: " + id,
					x);
			throw new Exception("Could not successfully update this Employee, please try again.");
		}

	}
}