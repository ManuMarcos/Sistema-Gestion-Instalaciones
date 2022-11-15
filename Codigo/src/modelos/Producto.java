package modelos;

public abstract class Producto {

	//Attributes
	protected float precio;
	
	
	//Methods
	protected void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	protected float getPrecio() {
		return this.precio;	
	}
}
