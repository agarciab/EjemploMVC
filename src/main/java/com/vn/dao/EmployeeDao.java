package com.vn.dao;

import java.util.List;

import com.vn.model.Employee;

public interface EmployeeDao extends Dao<Employee, Integer> {

	public Employee findByName(String name);
	public List<Employee> getEmployeesGreaterThanId(Integer id);
	
	public void reubicarEmpleados(Integer habitacionOrigen, Integer habitacionDestino);
}
