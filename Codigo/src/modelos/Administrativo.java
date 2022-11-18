package modelos;

public class Administrativo extends Empleado{

	//Attributes
	
	//Methods
	
	//Constructor
	public Administrativo(String nombre, String direccion,String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
	
	
	
	
	
	public void facturarInstalacion() {};
	private void emitirFactura() {};
	private void enviarFactura() {};
	public void modificarInstalacion(Instalacion instalacion){};
	public void imprimirFactura() {};
	public void getFacturasEmitidas() {};
	
}
