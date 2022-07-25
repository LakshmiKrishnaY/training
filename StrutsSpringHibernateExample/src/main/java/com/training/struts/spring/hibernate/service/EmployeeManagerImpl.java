package com.training.struts.spring.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.training.struts.spring.hibernate.dao.EmployeeDAO;
import com.training.struts.spring.hibernate.model.Address;
import com.training.struts.spring.hibernate.model.Employee;

public class EmployeeManagerImpl implements EmployeeManager {

	// Employee dao injected by Spring context
	private EmployeeDAO employeeDAO;

	// This method will be called when a employee object is added
	@Override
	@Transactional
	public void addEmployee(Employee employee) {

		List<Address> addresses = new ArrayList<Address>();

		// address 1
		Address address1 = new Address();
		address1.setStreet("615, Park Street");
		address1.setCity("DES MOINES");
		address1.setState("Iowa");
		address1.setZipCode("50309");
		addresses.add(address1);

		// address 2
		Address address2 = new Address();
		address2.setStreet("34655 SKYLARK DR APT 626");
		address2.setCity("UNION CITY");
		address2.setState("California");
		address2.setZipCode("94587");
		addresses.add(address2);

		// address 3
		Address address3 = new Address();
		address3.setStreet("362 W Olive Ave Apt 9");
		address3.setCity("SUNNYVALE");
		address3.setState("California");
		address3.setZipCode("94086");
		addresses.add(address3);

		// address 4
		Address address4 = new Address();
		address4.setStreet("11316 JOLLYVILLE RD APT 115");
		address4.setCity("AUSTIN");
		address4.setState("Texas");
		address4.setZipCode("78759");
		addresses.add(address4);

		// add all addresses to the employee list
		employee.setAddressList(addresses);

		// for Join column value
		address1.setEmployee(employee);

		employeeDAO.addEmployee(employee);
	}

	// This method return list of employees in database
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	// Deletes a employee by it's id
	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	// edits employee details by it's id
	@Override
	@Transactional
	public Employee editEmployee(Integer employeeId) {
		Employee employee = employeeDAO.getEmployee(employeeId);
		return employee;
	}

	// updates employee details by it's id
	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	// This setter will be used by Spring context to inject the dao's instance
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
}