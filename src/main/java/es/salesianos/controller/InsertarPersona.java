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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Persona;
import es.salesianos.repository.PersonasRepository;
import es.salesianos.service.Service;

@Controller
public class InsertarPersona {
	
	@Autowired
	@Qualifier("servicePrueba")
	Service service;
	
	@PostMapping("/insertar")
	protected String save(Persona persona){
		service.insert(persona);
		return "insertar";
	}
}
