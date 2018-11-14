package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.model.PersonaAssembler;
import es.salesianos.model.PetAssembler;
import es.salesianos.repository.PersonasRepository;
import service.Service;

public class AddPet extends HttpServlet{
	
	PersonasRepository repository = new PersonasRepository();
	Service servicio = new Service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona personaEnFormulario = PersonaAssembler.assembleUserFrom(req);
		Persona personaEnDatabase = servicio.searchOnePerson(personaEnFormulario.getCodPersona());
		req.setAttribute("ownerPet", personaEnDatabase);
		redirect(req,resp, "/addPet.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Mascota mascota = PetAssembler.assemblerPetFrom(req);
		repository.insertPet(mascota);
		redirect(req, resp, "/insertarPet.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}
	
}
