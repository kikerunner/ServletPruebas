package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class BorrarPersona {
	
	@Autowired
	Service servicio;
	
	@GetMapping("/borrarPersona")
	protected String doGet(Persona persona) {
		servicio.borrarPersona(persona);
		return "listOwner";
	}
}
