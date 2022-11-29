package modelos;

public class FacturaRenglon {

	//Attributes
	private String descripcion;
	private int cantidad;
	private float precioUnitario;
	private float importe;
	
	public FacturaRenglon(String descripcion, int cantidad, float precioUnitario) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.importe = cantidad * precioUnitario;
	}

	public float getImporte() {
		return importe;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public float getPrecioUnitario() {
		return this.precioUnitario;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String toString() {
		return "Producto: " + this.descripcion + " Cantidad: " + this.cantidad + " Precio unitario: " + this.precioUnitario + " Importe: " + this.importe;
	}
	
	
}
