package service;

import java.util.List;

import es.salesianos.model.Persona;
import es.salesianos.repository.PersonasRepository;

public class Service {
	
	PersonasRepository repository = new PersonasRepository();
	
	public List<Persona> listAllUsers() {
		return repository.searchAll();
	}
	
	public Persona searchOnePerson(int CodPersona) {
		return repository.selectOnePerson(CodPersona);
	}
	
	public Persona updatePerson(Persona persona) {
		return repository.updatePerson(persona);
	}

}
