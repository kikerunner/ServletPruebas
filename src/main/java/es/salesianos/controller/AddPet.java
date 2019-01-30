package es.salesianos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.repository.PersonasRepository;
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
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Mascota mascota = PetAssembler.assemblerPetFrom(req);
		repository.insertPet(mascota);
		redirect(req, resp, "/insertarPet.jsp");
	}*/
}
