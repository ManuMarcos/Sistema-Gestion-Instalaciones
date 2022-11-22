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
		} else {
			System.out.println("No se pueden facturar instalaciones no finalizadas");
		}
	};
	
	public void modificarNecesitaSeguro(Instalacion instalacion, boolean necesita){
		instalacion.setNecesitaSeguro(necesita);
	};
	
	public void modificarNecesitaSoportePared(Instalacion instalacion, boolean necesita) {
		instalacion.setNecesitaSoportePared(necesita);
	};
	
	public void agregarElementoAInstalacion(Instalacion instalacion, Producto producto) {
		instalacion.agregarElementos(producto);
	};
	
	public void modificarAlmuerzo(Instalacion instalacion, boolean almorzo) {
		instalacion.setAlmuerzo(almorzo);
	};
	
	public void modificarEstado(Instalacion instalacion, Estado estado) {
		instalacion.setEstado(estado);
	};
	
	public void modificarCliente(Instalacion instalacion, Cliente cliente) {
		instalacion.setCliente(cliente);
	};
	
	public void modificarHoraInicio(Instalacion instalacion, Calendar horaInicio) {
		instalacion.setHoraInicio(horaInicio);
	};
	
	public void modificarHoraFinalizacion(Instalacion instalacion, Calendar horaFinalizacion) {
		instalacion.setHoraFinalizacion(horaFinalizacion);
	};
	
	public void modificarFactura(Instalacion instalacion, Factura factura) {
		instalacion.setFactura(factura);
	};
	
	
	
}
