package modelos;

public class Operador extends Empleado{

	//Attributes
	
	//Methods
	
	//Constructor
	public Operador(String nombre, String direccion) {
		super(nombre, direccion);
		// TODO Auto-generated constructor stub
	};
	
	public void darDeAltaCliente(String nombre, String direccion, int cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		Empresa empresa = Empresa.getInstance();
		empresa.crearCliente(nombre, direccion, cuitCuil, tipoCliente, correoElectronico);
	};
	
	public void agendarInstalacion() {
		
	}
	
	
}
