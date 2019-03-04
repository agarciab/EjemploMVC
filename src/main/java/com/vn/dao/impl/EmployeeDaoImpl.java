package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vn.dao.EmployeeDao;
import com.vn.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Integer> implements EmployeeDao {
	
	@Autowired
	private BeanPropertyRowMapper<Employee> employeeMapper;
	
	@Override
	public List<Employee> getEmployeesGreaterThanId(Integer id) {
		String sql = "SELECT * FROM Employee WHERE employee_id > :employeeId";
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		return namedParameterjdbcTemplate.query(sql, namedParameters, employeeMapper);
	}

	@Override
	public Employee findById(Integer id) {
		String sql = "SELECT * FROM Employee WHERE employee_id = :employeeId";
		Employee emp = new Employee();
		emp.setEmployeeId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		Employee e = null;
		try {
			e = namedParameterjdbcTemplate.queryForObject(sql, namedParameters, employeeMapper);
		} catch (Exception exception) {
			e= null;
		}
		return e;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "SELECT * FROM Employee";
		return jdbcTemplate.query(sql, employeeMapper);
	}

	@Override
	@Transactional
	public void save(Employee e) {
		Assert.notNull(e, "Building is null");
		Employee oldEmployee = findById(e.getEmployeeId());
		if (oldEmployee == null) {
			String sql = "INSERT INTO Employee (employee_id, name, room, telf) VALUES (?, ?, ? ,?)";
			jdbcTemplate.update(sql, e.getEmployeeId(), e.getName(), e.getRoom(), e.getTelf());
		} else {
			String sql = "UPDATE Employee SET name = ?, room = ?, telf = ? WHERE employee_id = ?";
			jdbcTemplate.update(sql, e.getName(), e.getRoom(), e.getTelf(), e.getEmployeeId());
		}
	}

	@Override
	@Transactional
	public void delete(Employee e) {
		Assert.notNull(e, "Employee is null");
		Employee oldEmployee = findById(e.getEmployeeId());
		if (oldEmployee != null) {
			String sql = "DELETE FROM Employee WHERE employee_id = ?";
			jdbcTemplate.update(sql, e.getEmployeeId());
		} 
		
	}

	@Override
	public Employee findByName(String name) {
		String sql = "SELECT * FROM Employee WHERE name = :name";
		Employee emp = new Employee();
		emp.setName(name);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		Employee e = null;
		try {
			e = namedParameterjdbcTemplate.queryForObject(sql, namedParameters, employeeMapper);
		} catch (Exception exception) {
			e= null;
		}
		return e;
	}

	@Override
	@Transactional
	public void reubicarEmpleados(Integer habitacionOrigen, Integer habitacionDestino) {
		List<Employee> empleados = findAll();
		for (Employee e: empleados) {
			if (e.getRoom().equals(habitacionOrigen)) {
				e.setRoom(habitacionDestino);
				save(e);
			}
		}
	}
	

}
