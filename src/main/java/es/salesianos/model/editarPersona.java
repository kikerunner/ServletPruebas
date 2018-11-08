package es.salesianos.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class editarPersona extends HttpServlet{
	
	private Service servicio = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona persona = PersonaAssembler.assembleUserFrom(req);
		Persona personaFromDatabase = servicio.searchOnePerson(persona.getCodPersona());
		req.setAttribute("owner", personaFromDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListarPersonas.jsp");
		dispatcher.forward(req, resp);
	}
}
