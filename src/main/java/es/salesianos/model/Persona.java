package es.salesianos.model;

public class Persona {
	
	private int codPersona;
	private String name;
	private String Apellido;
	
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
