package com.vn.model;

public class Employee {

	private Integer employeeId;
	
	private String name;
	
	private Integer telf;
	
	private Integer room;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTelf() {
		return telf;
	}

	public void setTelf(Integer telf) {
		this.telf = telf;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}
	
	public String toString() {
		return "Employee num.: " + employeeId + " Nombre: " + name + " Telf.:" + telf + " Room: " + room;
	}
	
}
