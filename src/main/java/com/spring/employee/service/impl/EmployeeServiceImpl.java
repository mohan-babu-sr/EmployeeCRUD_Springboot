package com.spring.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.employee.exception.EmployeeException;
import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepository;
import com.spring.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

//	@Override
//	public List<Employee> getAllEmployees() {
//		return employeeRepository.findAll();
//	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
						new EmployeeException("Employee", "Id", id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeException("Employee", "Id", id)); 
		
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
		existingEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
		existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());
		existingEmployee.setEmployeeExperience(employee.getEmployeeExperience());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> 
								new EmployeeException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getEmployeeSort(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
	}


}