package com.vn.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.exception.PersonaNoTrobadaException;
import com.vn.model.Persona;

@RestController
public class PersonaRestController {
	
	@PutMapping("/persones/plus1")
	public Persona incrementaEdadJson(@RequestBody Persona persona, HttpServletResponse response) {
		if ("Alex".equals(persona.getNombre())) {
			throw new PersonaNoTrobadaException("Persona " + persona.getNombre() + " no trobada");
		}
		persona.setEdad(persona.getEdad()+1);
		response.setStatus(HttpServletResponse.SC_CREATED);
		return persona;
	}
	
}
