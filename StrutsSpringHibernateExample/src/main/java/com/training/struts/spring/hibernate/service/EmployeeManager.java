package com.training.struts.spring.hibernate.service;

import java.util.List;

import com.training.struts.spring.hibernate.model.Employee;

public interface EmployeeManager {

	// This method will be called when a employee object is added
	public void addEmployee(Employee employee);

	// This method return list of employees in database
	public List<Employee> getAllEmployees();

	// Deletes a employee by it's id
	public void deleteEmployee(Integer employeeId);

	// edits employee details by it's id
	public Employee editEmployee(Integer employeeId);

	// updates employee details by it's id
	public void updateEmployee(Employee employee);
}
