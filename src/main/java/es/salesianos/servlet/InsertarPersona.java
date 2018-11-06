package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Persona;
import es.salesianos.repository.PersonasRepository;

public class InsertarPersona extends HttpServlet{
	
	PersonasRepository repository = new PersonasRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Persona persona = new Persona();
		persona.setName(req.getParameter("name"));
		persona.setApellido(req.getParameter("apellido"));
		repository.insert(persona);
		redirect(req, resp, "/feedback.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}
