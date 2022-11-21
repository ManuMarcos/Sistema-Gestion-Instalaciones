package modelos;

import java.util.ArrayList;

public class Administrativo extends Empleado{

	//Attributes
	private ArrayList<Factura> facturas;

	//Methods
	public ArrayList<Factura> verFacturas() {
		return facturas;
	}

	public void agregarFacturas(Factura factura) {
		this.facturas.add(factura);
	}
	
	//Constructor
	public Administrativo(String nombre, String direccion,String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
	

	public void facturarInstalacion() {};
	private void emitirFactura() {};
	private void enviarFactura() {};
	public void modificarInstalacion(Instalacion instalacion, boolean necesitaSoporte, boolean necesitaSeguro){};
	public void imprimirFactura() {};
	public void getFacturasEmitidas() {};
	
}
