package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Persona;
import es.salesianos.model.PersonaAssembler;
import service.Service;

public class BorrarPersona extends HttpServlet {
	
	Service servicio = new Service();
	Persona personaEnDatabase = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona personaFormulario = PersonaAssembler.assembleUserFrom(req);
		Persona personaEnDatabase = servicio.searchOnePerson(personaFormulario.getCodPersona());
		req.setAttribute("personaBorrar", personaEnDatabase);
		servicio.borrarPersona(personaEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/borrarPersona.jsp");
		dispatcher.forward(req, resp);
	}
}
