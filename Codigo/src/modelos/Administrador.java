package modelos;

public class Administrador extends Empleado{

	//Attributes
	Empresa empresa = Empresa.getInstance();

	//Methods
	
	public Administrador(String nombre, String direccion, String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
	
}
