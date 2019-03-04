package com.vn.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.dto.BuildingDTO;

@RestController("/building")
public class BuildingController {

	@PostMapping("/")
	public void altaBuilding(@RequestBody BuildingDTO building) {
		
	}
	
	@DeleteMapping("/{id}")
	public void baixaBuilding(@PathVariable Integer id) {
		
	}
	
	@PutMapping("/{id}")
	public void editBuilding(@PathVariable Integer id, @RequestBody BuildingDTO building) {
		
	}
	
	@GetMapping("/{id}")
	public void cercaBuilding(@PathVariable Integer id) {
		
	}
}
