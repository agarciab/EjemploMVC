package com.vn.service;

import com.vn.model.Building;

public interface BuildingService {

	public void alta(Building building);

	public void editar(Integer id, Building building);

	public void baixa(Integer id);

	public Building cerca(Integer id);
}
