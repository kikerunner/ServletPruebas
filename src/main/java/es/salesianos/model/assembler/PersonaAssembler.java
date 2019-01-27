package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Persona;

public class PersonaAssembler {

	public static Persona assembleUserFrom(HttpServletRequest req) {

		Persona persona = new Persona();
		String codPersona = req.getParameter("codPersona");
		String name = req.getParameter("name");
		String apellido = req.getParameter("apellido");
		
		if (codPersona != null) {
			persona.setCodPersona(Integer.parseInt(codPersona));
		}
		persona.setName(name);
		persona.setApellido(apellido);

		return persona;

	}

}
