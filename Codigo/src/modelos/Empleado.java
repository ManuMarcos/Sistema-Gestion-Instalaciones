package modelos;

public abstract class Empleado extends Persona{

	//Attributes
	protected static int generador = 1;
	protected float sueldo;
	
	
	//Methods
	
	//Constructor
	protected Empleado(String nombre, String direccion) {
		super(nombre, direccion);
		this.id = generador;
		generador ++;
	}
}
