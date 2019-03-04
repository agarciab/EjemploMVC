package com.vn.dto;

import com.vn.model.Building;

public class BuildingDTO {

	private Integer buildingId;
	
	private String name;
	
	public Building toBuilding() {
		Building b = new Building();
		b.setBuildingId(getBuildingId());
		b.setName(getName());
		return b;
	}

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
	
	
}
