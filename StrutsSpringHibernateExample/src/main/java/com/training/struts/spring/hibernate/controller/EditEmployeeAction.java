package com.training.struts.spring.hibernate.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.training.struts.spring.hibernate.model.Employee;
import com.training.struts.spring.hibernate.service.EmployeeManager;

public class EditEmployeeAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;

	// Logger configured using log4j
	private static final Logger logger = LogManager.getLogger(EditEmployeeAction.class);

	// List of employees; Setter and Getter are below
	private List<Employee> employees;

	// Employee object to be added; Setter and Getter are below
	private Employee employee;

	// Employee manager injected by spring context; This is cool !!
	private EmployeeManager employeeManager;

	// This method return list of employees in database
	public String listEmployees() {
		logger.info("listEmployees method called");
		employees = employeeManager.getAllEmployees();
		return SUCCESS;
	}

	// This method will be called when a employee object is added
	public String addEmployee() {
		logger.info("addEmployee method called");
		employeeManager.addEmployee(employee);
		return SUCCESS;
	}

	// Deletes a employee by it's id passed in path parameter
	public String deleteEmployee() {
		logger.info("deleteEmployee method called");
		employeeManager.deleteEmployee(employee.getId());
		return SUCCESS;
	}

	// edits employee details by it's id
	public String editEmployee() {
		logger.info("edits employee details");
		employee = employeeManager.editEmployee(employee.getId());
		logger.debug(employee);
		return SUCCESS;

	}

	// updates employee details by it's id
	public String updateEmployee() {
		logger.info("updates employee details");
		employeeManager.updateEmployee(employee);
		return SUCCESS;

	}

	// This method will be called before any of Action method is invoked;
	// So some pre-processing if required.
	@Override
	public void prepare() throws Exception {
		employee = null;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeManager getEmployeeManager() {
		return employeeManager;
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

}