package modelos;

public class SoportePared extends Producto{


	//Methods
	public SoportePared() {
		super(0);
	}
	
	
	public SoportePared(float precio) {
		super(precio);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
