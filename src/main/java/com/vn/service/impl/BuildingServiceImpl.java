package com.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vn.dao.BuildingDao;
import com.vn.exception.BuildingNoTrobatException;
import com.vn.model.Building;
import com.vn.service.BuildingService;

@Service
@Transactional(readOnly=true)
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDao buildingDao;
	
	@Override
	@Transactional
	public void alta(Building building) {
		buildingDao.save(building);
	}

	@Override
	@Transactional
	public void editar(Integer id, Building building) {
		Building b = buildingDao.findById(id);
		if (b == null) {
			throw new BuildingNoTrobatException();
		}
		buildingDao.save(b);		
	}

	@Override
	public void baixa(Integer id) {
		Building b = buildingDao.findById(id);
		if (b == null) {
			throw new BuildingNoTrobatException();
		}
		buildingDao.delete(b);		
	}

	@Override
	public Building cerca(Integer id) {
		Building b = buildingDao.findById(id);
		if (b == null) {
			throw new BuildingNoTrobatException();
		}
		return b;	
	}

}
