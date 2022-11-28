package modelos;

import java.util.ArrayList;

public class Factura {

	//Attributes
	private static int generador;
	private static final int iva = 21;
	private int numero;
	private float subtotal;
	private float precioTotal;
	private float importeIva;
	private ArrayList<FacturaRenglon> renglones;
	
	
	//Methods
	//Constructor
	public Factura() {
		this.numero = generador;
		generador ++;
		this.renglones = new ArrayList<FacturaRenglon>();
		
	}
	//Tipo cliente para el tipo de factura
	
	
	public int getNumero() {
		return numero;
	}
	
	public void agregarRenglon(String descripcion, int cantidad, float precioUnitario) {
		this.renglones.add(new FacturaRenglon(descripcion, cantidad, precioUnitario));
		this.subtotal += precioUnitario * cantidad;
		this.calcularIva();
		this.calcularPrecioTotal();
	}
	
	private void calcularPrecioTotal() {
		this.precioTotal +=  this.subtotal + this.importeIva;
	}
	
	
	private void calcularIva() {
		this.importeIva += this.subtotal * (iva/100);
	}
	
	public float getPrecioTotal() {
		return this.precioTotal;
	}
	
	public ArrayList<FacturaRenglon> getRenglones(){
		return this.renglones;
	}
	
	public String toString() {
		String factura = "";
		for(FacturaRenglon renglon : this.renglones) {
			factura += renglon.toString() + "\n" ;
		}
		factura += "Subtotal: " + this.subtotal;
		factura += "Importe Iva: " + this.importeIva;
		factura += "Precio total: " + this.precioTotal+ "\n";
		return factura;
	}
	

	
	
}
