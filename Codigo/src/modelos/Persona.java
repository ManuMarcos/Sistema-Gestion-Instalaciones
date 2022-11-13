package modelos;

public abstract class Persona {

	//Attributes
	protected int id;
	protected String nombre;
	protected String direccion;
	
	protected Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	
	
	
}
