package com.vn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.vn.model.Building;
import com.vn.model.Employee;
import com.vn.model.Room;

@Configuration
@ComponentScan("com.vn")
public class Config {

	
	@Bean
	public BeanPropertyRowMapper<Employee> employeeMapper() {
		return new BeanPropertyRowMapper<>(Employee.class);
	}
	
	@Bean
	public BeanPropertyRowMapper<Building> buildingMapper() {
		return new BeanPropertyRowMapper<>(Building.class);
	}
	
	@Bean
	public BeanPropertyRowMapper<Room> roomMapper() {
		return new BeanPropertyRowMapper<>(Room.class);
	}
}
