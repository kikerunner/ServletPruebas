package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class BuscarOwner {
	
	@Autowired
	@Qualifier("servicePrueba")
	Service service;
	
	@PostMapping("FindOwnerByPet")
	protected ModelAndView save(String namePet){
		Persona persona = service.findOwnerByPet(namePet);
		ModelAndView model = new ModelAndView("FindOwnerByPet");
		model.addObject("persona", persona);
		return model;
	}
	
	@GetMapping(path = "FindOwnerByPet")
	public String getListOwnerPage() {
		return "FindOwnerByPet";
	}
}
