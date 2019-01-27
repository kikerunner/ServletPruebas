package es.salesianos.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.model.assembler.PersonaAssembler;
import es.salesianos.model.assembler.PetAssembler;
import es.salesianos.repository.PersonasRepository;
import es.salesianos.repository.PetRepository;
import service.Service;

public class AddPet extends HttpServlet{
	
	@Autowired
	PetRepository repository;
	@Autowired
	Service servicio = new Service();
	
	@PostMapping("/addPet")
	protected String save(Mascota mascota){
		repository.insertPet(mascota);
		return "insertarPet";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona personaEnFormulario = PersonaAssembler.assembleUserFrom(req);
		Persona personaEnDatabase = servicio.searchOnePerson(personaEnFormulario.getCodPersona());
		req.setAttribute("ownerPet", personaEnDatabase);
		//redirect(req,resp, "/addPet.jsp");
	}
}
