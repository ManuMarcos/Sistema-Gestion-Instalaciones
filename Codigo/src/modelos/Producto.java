package modelos;

public abstract class Producto {

	//Attributes
	private float precio = 0;
	protected static int generador = 1;
	protected int id;
	
	
	//Methods
	
	public Producto(float precio) {
		this.precio = precio;
		this.id = generador;
		generador++;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecio() {
		return this.precio;	
	}
	
	protected int getId() {
		return this.id;
	}

	

}
