package modelos;

public class Condensadora extends Producto{

	//Attributes
	
	//Methods
	
	public Condensadora() {
		super(0);
	}
	
	public Condensadora(float precio) {
		super(precio);
	}
	
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	
}
