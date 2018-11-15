package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Mascota;
import service.Service;

public class BuscarPet extends HttpServlet {
	
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String namePet = (String) req.getAttribute("namePet");
		List<Mascota> mascota = servicio.listMascotaByPersona(namePet);
		super.doPost(req, resp);
	}

}
