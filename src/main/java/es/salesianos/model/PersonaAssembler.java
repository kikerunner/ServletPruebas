package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class PersonaAssembler {

	public static Persona assembleUserFrom(HttpServletRequest req) {

		Persona persona = new Persona();
		String name = req.getParameter("name");
		String apellido = req.getParameter("apellido");
		persona.setName(name);
		persona.setApellido(apellido);

		return persona;

	}

}
