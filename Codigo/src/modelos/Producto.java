package modelos;

public abstract class Producto {

	//Attributes
	protected float precio;
	protected static int generador = 1;
	protected int id;
	
	
	//Methods
	
	public Producto() {
		this.id = generador;
		generador++;
	}
	
	protected void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	protected float getPrecio() {
		return this.precio;	
	}
	
	protected int getId() {
		return this.id;
	}

}
