package modelos;

public class Factura {

	//Attributes
	private static int generador;
	private double iva;
	private int numero;
	private double precioTotal;
	
	//Methods
	/**
	 * Devuelve el IVA. DISCLAIMER: Por cómo está la fórmula, devuelve "1.XX", donde XX es el valor que corresponde. Por ejemplo: 1.21 es 21%
	 * @return double
	 */
	public double getIva() {
		return this.iva;
	}
	
	/**
	 * Define el IVA. DISCLAIMER: Por cómo está la fórmula, hay que pasarle "1.XX", donde XX es el valor del IVA. Por ejemplo: 1.21 para 21%
	 * @param double
	 */
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
