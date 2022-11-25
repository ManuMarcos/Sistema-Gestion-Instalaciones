package modelos;

public abstract class PersonaView {

	//Attributes
	protected String nombre;
	protected String direccion;
	
	//Methods
	public PersonaView(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
}
