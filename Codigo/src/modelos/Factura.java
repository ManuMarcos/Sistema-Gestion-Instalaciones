package modelos;

public class Factura {

	//Attributes
	private static int generador;
	private double iva;
	private int numero;
	private double precioTotal;
	
	//Methods
	public double getIva() {
		return this.iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
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
	public Factura(double precioProvisorio, double iva) {
		this.setNumero(generador);
		generador ++;
		this.setPrecioTotal(precioProvisorio * iva);
	}
	
}
