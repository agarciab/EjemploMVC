package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vn.dao.RoomDao;
import com.vn.model.Room;

@Repository
public class RoomDaoImpl extends AbstractDao<Room, Integer> implements RoomDao {

	@Autowired
	private BeanPropertyRowMapper<Room> roomMapper;
	
	@Override
	public Room findById(Integer id) {
		String sql = "SELECT * FROM Room WHERE room_id=:roomId"; 
		Room room = new Room();
		room.setRoomId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(room);
		Room b = null;
		try {
			b = namedParameterjdbcTemplate.queryForObject(sql, namedParameters, roomMapper);
		} catch (Exception e) {
			b= null;
		}
		return b;
	}

	@Override
	public List<Room> findAll() {
		String sql = "SELECT * FROM Room";
		return jdbcTemplate.query(sql, roomMapper);
	}

	@Override
	@Transactional
	public void save(Room r) {
		Assert.notNull(r, "Room is null");
		Room oldRoom = findById(r.getRoomId());
		if (oldRoom == null) {
			String sql = "INSERT INTO Room (room_id, name, building) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, r.getRoomId(), r.getName(), r.getBuilding());
		} else {
			String sql = "UPDATE Building SET name = ?, building = ? WHERE room_id = ?";
			jdbcTemplate.update(sql, r.getName(), r.getBuilding(), r.getRoomId());
		}		
	}

	@Override
	@Transactional
	public void delete(Room r) {
		Assert.notNull(r, "Building is null");
		Room oldRoom = findById(r.getRoomId());
		if (oldRoom != null) {
			String sql = "DELETE FROM Room WHERE room_id = ?";
			jdbcTemplate.update(sql, r.getRoomId());
		} 
	}


}
