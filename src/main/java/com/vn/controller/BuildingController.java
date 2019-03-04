package com.vn.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.dto.BuildingDTO;
import com.vn.model.Building;
import com.vn.service.BuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {

	@Autowired
	private Validator altaBuildingValidator;
	
	@Autowired
	private Validator modificacioBuildingValidator;
	
	@Autowired
	private BuildingService buildingService;
	
	@PostMapping("/")
	public void altaBuilding(@RequestBody BuildingDTO building, BindingResult errors, HttpServletResponse response) {
		altaBuildingValidator.validate(building, errors);
		buildingService.alta(building.toBuilding());
		response.setStatus(HttpServletResponse.SC_CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void baixaBuilding(@PathVariable Integer id) {
		buildingService.baixa(id);
	}
	
	@PutMapping("/{id}")
	public void editarBuilding(@PathVariable Integer id, @RequestBody BuildingDTO building, BindingResult errors) {
		modificacioBuildingValidator.validate(building, errors);
		buildingService.editar(id, building.toBuilding());
	}
	
	@GetMapping("/{id}")
	public Building cercaBuilding(@PathVariable Integer id) {
		return buildingService.cerca(id);
	}
}
