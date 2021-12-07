package com.spring.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String employeeName;
		private String employeeDepartment;
		private String employeeEmail;
		private String employeeExperience;
		private String employeeAddress;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getEmployeeDepartment() {
			return employeeDepartment;
		}
		public void setEmployeeDepartment(String employeeDepartment) {
			this.employeeDepartment = employeeDepartment;
		}
		public String getEmployeeEmail() {
			return employeeEmail;
		}
		public void setEmployeeEmail(String employeeEmail) {
			this.employeeEmail = employeeEmail;
		}
		public String getEmployeeExperience() {
			return employeeExperience;
		}
		public void setEmployeeExperience(String employeeExperience) {
			this.employeeExperience = employeeExperience;
		}
		public String getEmployeeAddress() {
			return employeeAddress;
		}
		public void setEmployeeAddress(String employeeAddress) {
			this.employeeAddress = employeeAddress;
		}
		public Employee(long id, String employeeName, String employeeDepartment, String employeeEmail,
				String employeeExperience, String employeeAddress) {
			super();
			this.id = id;
			this.employeeName = employeeName;
			this.employeeDepartment = employeeDepartment;
			this.employeeEmail = employeeEmail;
			this.employeeExperience = employeeExperience;
			this.employeeAddress = employeeAddress;
		}
		public Employee(String employeeName, String employeeDepartment, String employeeEmail, String employeeExperience,
				String employeeAddress) {
			super();
			this.employeeName = employeeName;
			this.employeeDepartment = employeeDepartment;
			this.employeeEmail = employeeEmail;
			this.employeeExperience = employeeExperience;
			this.employeeAddress = employeeAddress;
		}
		public Employee() {
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeDepartment="
					+ employeeDepartment + ", employeeEmail=" + employeeEmail + ", employeeExperience="
					+ employeeExperience + ", employeeAddress=" + employeeAddress + "]";
		}
		
}
