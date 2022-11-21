package modelos;

import java.util.ArrayList;
import java.util.Calendar;

public class Administrativo extends Empleado{

	//Attributes
	private ArrayList<Factura> facturas;
	Empresa empresa = Empresa.getInstance();

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
	

	public void facturarInstalacion(Instalacion instalacion, double iva) {
		if (instalacion.getEstado() == Estado.FINALIZADA) {
			double precio = 0;
			for (Producto p : instalacion.getElementos()) {
				precio = precio + p.getPrecio();
			}
			if (instalacion.getNecesitaSeguro()) {
				precio = precio + Empresa.getPrecioSeguro();
			}
			if (instalacion.getNecesitaSoportePared()) {
				precio = precio + Empresa.getPrecioSoportePared();
			}
			
			Factura factura = new Factura(precio, iva);
			
			empresa.agregarFacturas(factura);
		}
	};
	
	public void modificarInstalacion(Instalacion instalacion, boolean necesitaSoporte, boolean necesitaSeguro){};
	
}
