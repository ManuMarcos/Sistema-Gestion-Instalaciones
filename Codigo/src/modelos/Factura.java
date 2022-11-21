package modelos;

public class Factura {

	//Attributes
	private static int generador;
	private static double iva;
	private int numero;
	private double precioTotal;
	
	//Methods
	public static double getIva() {
		return iva;
	}
	public static void setIva(double iva) {
		Factura.iva = iva;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	//Constructor
	protected Factura(double precioProvisorio, double iva) {
		this.numero = generador;
		generador ++;
	}
	
}
