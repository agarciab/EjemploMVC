package com.vn.model;

public class Room {

	private Integer roomId;
	
	private String name;
	
	private Integer building;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBuilding() {
		return building;
	}

	public void setBuilding(Integer building) {
		this.building = building;
	}	
	
	public String toString() {
		return "Room num.: " + roomId + " Nombre: " + name + " Building: " + building;
	}
	
}
