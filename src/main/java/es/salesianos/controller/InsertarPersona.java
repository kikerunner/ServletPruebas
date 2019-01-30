package es.salesianos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class InsertarPersona {
	
	@Autowired
	@Qualifier("servicePrueba")
	Service service;
	
	@PostMapping("/insertar")
	protected String save(Persona persona){
		service.insert(persona);
		return "insertar";
	}
}
