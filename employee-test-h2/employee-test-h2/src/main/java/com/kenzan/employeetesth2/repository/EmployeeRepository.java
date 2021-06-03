package com.kenzan.employeetesth2.repository;

import org.springframework.data.repository.CrudRepository;

import com.kenzan.employeetesth2.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
