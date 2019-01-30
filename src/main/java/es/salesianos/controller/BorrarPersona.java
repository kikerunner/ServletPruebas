package es.salesianos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class BorrarPersona {
	
	@Autowired
	@Qualifier("servicePrueba")
	Service servicio;
	Persona personaEnDatabase = null;
	
	@GetMapping("confirmarBorrar")
	protected ModelAndView borrarPersona(@RequestParam int codPersona) {
		Persona personaFormulario = new Persona();
		personaFormulario.setCodPersona(codPersona);
		Persona personaEnDatabase = servicio.searchOnePerson(personaFormulario.getCodPersona());
		ModelAndView model = new ModelAndView("confirmarBorrar");
		model.addObject("persona", personaEnDatabase);
		return model;
	}
	
	@PostMapping("borrar")
	protected String save(Persona persona){
		servicio.borrarPersona(persona);
		return "borrarPersona";
	}
}
