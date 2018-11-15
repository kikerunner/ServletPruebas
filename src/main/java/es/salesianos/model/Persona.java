package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	private int codPersona;
	private String name;
	private String Apellido;
	private List<Mascota> mascotas = new ArrayList();
	
	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}

	public int getCodPersona() {
		return codPersona;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
}
