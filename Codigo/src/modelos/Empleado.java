package modelos;

public abstract class Empleado extends Persona{

	//Attributes
	protected static int generador = 1;
	protected int id;
	protected float sueldo;
	protected String usuario;
	protected String contrasena;
	
	
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

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	protected EmpleadoView ToView() {
		return new EmpleadoView(this.id, this.nombre, this.direccion, this.usuario, this.getClass().getSimpleName());
	}
	
}
