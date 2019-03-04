package com.vn.model;

public class Building {

	private Integer buildingId;
	private String name;
	
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Building ID.: " + buildingId + " Nombre: " + name;
	}
}
