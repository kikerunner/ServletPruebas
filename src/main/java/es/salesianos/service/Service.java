package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import es.salesianos.model.Mascota;
import es.salesianos.model.Persona;
import es.salesianos.repository.PersonasRepository;
import es.salesianos.repository.PetRepository;

@org.springframework.stereotype.Service("servicePrueba")
public class Service {
	
	PersonasRepository repository = new PersonasRepository();
	PetRepository repoPet = new PetRepository();
	
	public List<Persona> listAllUsers() {
		return repository.searchAll();
	}
	
	public Persona searchOnePerson(int CodPersona) {
		return repository.selectOnePerson(CodPersona);
	}
	
	public Persona findOwnerByPet(String nomMascota) {
		return repoPet.selectOwnerByPet(nomMascota);
	}
	
	public void updatePerson(Persona persona) {
		repository.updatePerson(persona);
	}
	
	public void insert(Persona persona) {
		repository.insert(persona);
	}
	
	public void borrarPersona(Persona persona) {
		repository.borrarPersona(persona);
	}

}
