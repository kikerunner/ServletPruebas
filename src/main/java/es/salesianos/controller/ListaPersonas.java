package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class ListaPersonas {
	
	@Autowired
	@Qualifier("servicePrueba")
	Service service;
	
	@PostMapping(path = "/cargarListado")
	public ModelAndView addOwner() {
		List<Persona> personas = service.listAllUsers();
		ModelAndView model = new ModelAndView("listarPersonas");
		model.addObject("cargarListado", personas);
		return model;
	}
	
	@GetMapping(path = "listarPersonas")
	public String getListOwnerPage() {
		return "listarPersonas";
	}
}
