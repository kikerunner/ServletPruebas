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

import es.salesianos.model.Persona;
import es.salesianos.service.Service;

@Controller
public class UpdatePersona extends HttpServlet{
	
	@Autowired
	@Qualifier("servicePrueba")
	private Service servicio;
	

	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Persona persona = PersonaAssembler.assembleUserFrom(req);
		System.out.println(persona.getCodPersona());
		System.out.println(persona.getName());
		System.out.println(persona.getApellido());
		servicio.updatePerson(persona);	
		redirect(req, resp);
	}
	/*
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updatePersona.jsp");
		dispatcher.forward(req, resp);
	}*/

}
