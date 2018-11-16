package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import service.Service;

public class BuscarPet extends HttpServlet {
	
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String namePet = (String) req.getParameter("namePet");
		Persona listDuenos = servicio.listMascotaByPersona(namePet);
		req.setAttribute("listDuenos", listDuenos);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListarMascotas.jsp");
		dispatcher.forward(req, resp);
	}
}
