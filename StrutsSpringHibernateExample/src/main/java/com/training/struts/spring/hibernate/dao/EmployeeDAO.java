package com.training.struts.spring.hibernate.dao;

import java.util.List;

import com.training.struts.spring.hibernate.model.Employee;

//interface - methods declaration no method implementation
public interface EmployeeDAO {

	// This method will be called when a employee object is added
	public void addEmployee(Employee employee);

	// This method return list of employees in database
	public List<Employee> getAllEmployees();

	// Deletes a employee by it's id
	public void deleteEmployee(Integer employeeId);
	
	//edits a employee by it's id
	public Employee getEmployee(Integer employeeId);
	
	//updates a employee by it's id
		public void updateEmployee(Employee employee);
	
}
