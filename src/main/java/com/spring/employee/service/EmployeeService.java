package com.spring.employee.service;

import java.util.List;

import com.spring.employee.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
//	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
	List<Employee> getEmployeeSort(Integer pageNo, Integer pageSize, String sortBy);
}