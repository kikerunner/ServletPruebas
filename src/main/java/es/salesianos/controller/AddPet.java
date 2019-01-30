package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.repository.PetRepository;
import es.salesianos.service.Service;

@Controller
public class AddPet {
	
	@Autowired
	PetRepository repository;

	@Autowired
	@Qualifier("servicePrueba")
	Service service;
	
	
	@GetMapping("/addPet")
	protected ModelAndView savePet(@RequestParam int codPersona){
	ModelAndView model = new ModelAndView("addPet");
	Persona persona = new Persona();
	Persona personaEnDatabase = service.searchOnePerson(codPersona);
	persona.setCodPersona(codPersona);;
	persona.setName(personaEnDatabase.getName());
	persona.setApellido(personaEnDatabase.getApellido());
	model.addObject("persona", persona);
	return model;
	}
	
	@PostMapping("/addPet")
	protected String createPet(@RequestParam int codPersona, String namePet) {	
		Mascota mascota = new Mascota();
		mascota.setCodPersona(codPersona);
		mascota.setNomMascota(namePet);
		repository.insertPet(mascota);
		return "insertarPet";
	}
}
