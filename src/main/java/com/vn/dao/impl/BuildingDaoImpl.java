package com.vn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vn.dao.BuildingDao;
import com.vn.model.Building;

@Repository
public class BuildingDaoImpl extends AbstractDao<Building, Integer> implements BuildingDao {

	@Autowired
	private BeanPropertyRowMapper<Building> buildingMapper;
	
	@Override
	public Building findById(Integer id) {
		String sql = "SELECT * FROM Building WHERE building_id = :buildingId";
		Building building = new Building();
		building.setBuildingId(id);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(building);
		Building b = null;
		try {
			b = namedParameterjdbcTemplate.queryForObject(sql, namedParameters, buildingMapper);
		} catch (Exception e) {
			b= null;
		}
		return b;
	}

	@Override
	public List<Building> findAll() {
		String sql = "SELECT * FROM Building";
		return jdbcTemplate.query(sql, buildingMapper);
	}

	@Override
	@Transactional
	public void save(Building t) {
		Assert.notNull(t, "Building is null");
		Building oldBuilding = findById(t.getBuildingId());
		if (oldBuilding == null) {
			String sql = "INSERT INTO Building (building_id, name) VALUES (?, ?)";
			jdbcTemplate.update(sql, t.getBuildingId(), t.getName());
		} else {
			String sql = "UPDATE Building SET name = ? WHERE building_id = ?";
			jdbcTemplate.update(sql, t.getName(), t.getBuildingId());
		}
	}

	@Override
	@Transactional
	public void delete(Building t) {
		Assert.notNull(t, "Building is null");
		Building oldBuilding = findById(t.getBuildingId());
		if (oldBuilding != null) {
			String sql = "DELETE FROM Building WHERE building_id = ?";
			jdbcTemplate.update(sql, t.getBuildingId());
		} 
	}

}
