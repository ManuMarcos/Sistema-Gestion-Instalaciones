package modelos;

public class ComboItem {

	//Attributes
	private String nombre;
	private int id;
	
	public ComboItem(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String toString() {
		return this.nombre;
	}
}
