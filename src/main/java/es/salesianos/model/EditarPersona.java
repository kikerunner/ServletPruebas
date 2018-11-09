package es.salesianos.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.repository.PersonasRepository;
import service.Service;

public class EditarPersona extends HttpServlet{
	
	private Service servicio = new Service();
	private PersonasRepository repo = new PersonasRepository();
	private PersonaAssembler personaAssembler = new PersonaAssembler();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona personaFormulario = personaAssembler.assembleUserFrom(req);
		Persona personaEnDatabase = servicio.searchOnePerson(personaFormulario.getCodPersona());
		req.setAttribute("personaEditar", personaEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editar.jsp");
		dispatcher.forward(req, resp);
	}
}