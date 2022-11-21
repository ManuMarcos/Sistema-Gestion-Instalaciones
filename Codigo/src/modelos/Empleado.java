package modelos;

public abstract class Empleado extends Persona{

	//Attributes
	protected static int generador = 1;
	protected float sueldo;
	private String usuario;
	private String contrasena;
	
	
	//Methods
	
	//Constructor
	protected Empleado(String nombre, String direccion, String usuario, String contrasena) {
		super(nombre, direccion);
		this.id = generador;
		generador ++;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	
}
