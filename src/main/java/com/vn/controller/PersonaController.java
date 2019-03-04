package com.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.model.Persona;

@Controller
public class PersonaController {

	@PostMapping("/plus1")
	public String incrementaEdad(@ModelAttribute Persona persona, Model model) {
		persona.setEdad(persona.getEdad()+1);
		model.addAttribute("p", persona);
		return "persona";
	}
	
	@ResponseBody
	@PostMapping("/plus1json")
	public Persona incrementaEdadJson(@RequestBody Persona persona) {
		persona.setEdad(persona.getEdad()+1);
		return persona;
	}
	
}
