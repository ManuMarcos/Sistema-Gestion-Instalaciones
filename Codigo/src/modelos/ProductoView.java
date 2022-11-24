package modelos;

public class ProductoView {

	//Attributes
	private int id;
	private float precio;
	private int stock;
	private String producto;
	
	public ProductoView(int id, float precio, int stock, String nombreProducto) {
		this.id = id;
		this.precio = precio;
		this.stock = stock;
		this.producto = nombreProducto;
	}

	public int getId() {
		return id;
	}

	public float getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public String getProducto() {
		return producto;
	}
	
}
