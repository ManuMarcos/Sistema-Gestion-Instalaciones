package modelos;

public class Administrativo extends Empleado{

	//Attributes
	
	
	//Methods
	
	//Constructor
	public Administrativo(String nombre, String direccion) {
		super(nombre, direccion);
		
	}
	
	
	
	
	
	public void facturarInstalacion() {};
	private void emitirFactura() {};
	private void enviarFactura() {};
	public void modificarInstalacion(Instalacion instalacion){};
	public void imprimirFactura() {};
	public void getFacturasEmitidas() {};
	
}
