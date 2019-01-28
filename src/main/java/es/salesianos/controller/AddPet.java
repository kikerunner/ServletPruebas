package es.salesianos.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Mascota;
import es.salesianos.repository.PetRepository;
import es.salesianos.service.Service;

@Controller
public class AddPet {
	
	@Autowired
	PetRepository repository;
	@Autowired
	@Qualifier("servicePrueba")
	private Service servicio;
	
	@PostMapping("/addPet")
	protected String save(Mascota mascota){
		repository.insertPet(mascota);
		return "insertarPet";
	}
	
	/*@GetMapping("/addPet")
	protected void doGet(){
		Persona personaEnFormulario = PersonaAssembler.assembleUserFrom(req);
		Persona personaEnDatabase = servicio.searchOnePerson(personaEnFormulario.getCodPersona());
		req.setAttribute("ownerPet", personaEnDatabase);
		//redirect(req,resp, "/addPet.jsp");
	}*/
}
