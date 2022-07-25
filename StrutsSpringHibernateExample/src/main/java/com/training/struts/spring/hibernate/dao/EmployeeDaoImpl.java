package com.training.struts.spring.hibernate.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.training.struts.spring.hibernate.controller.EditEmployeeAction;
import com.training.struts.spring.hibernate.model.Employee;

@Repository // fetches data by connecting to db
public class EmployeeDaoImpl implements EmployeeDAO {
	// Session factory injected by spring context
	// session factory - to maintain multiple sessions; session object create ;
	// respective to its session
	private SessionFactory sessionFactory;

	// Logger configured using log4j
	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);

	// This method will be called when a employee object is added
	@Override
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	// This method return list of employees in database
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	// Deletes a employee by it's id
	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	// Edits a employee by it's id
	@Override
	public Employee getEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		logger.debug(employee);
		// System.out.println(employee);
		return employee;
	}

	// updates a employee by it's id
	@Override
	public void updateEmployee(Employee employee) {
		if (null != employee) {
			this.sessionFactory.getCurrentSession().update(employee);
		}
	}

	// This setter will be used by Spring context to inject the sessionFactory
	// instance
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}