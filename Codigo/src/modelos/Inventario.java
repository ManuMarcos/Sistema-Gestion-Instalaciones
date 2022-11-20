package modelos;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;



public class Inventario {

	//Attributes
	private HashMap<Producto, Integer> productos;
	
	//Methods
	
	//Constructor
	public Inventario() {
		this.productos = new HashMap<Producto, Integer>();
	}
	
	
	/**
	 * Devuelve el stock del producto. Si el producto no existe en el inventario devuelve -1
	 * @param producto
	 * @return cantEnStock
	 */
	
	public int obtenerStock(Producto producto) {
		Producto productoBuscado = this.buscarProducto(producto);
		if (productoBuscado != null) {
			return this.productos.get(productoBuscado);
		}
		return -1;
	}
		
	
	/**
	 * Setea el stock del producto. Si el producto existia en el inventario, actualiza el stock. Si no existia lo agrega.
	 * @param producto
	 * @param cantidad
	 */
	public void setStock(Producto producto, int cantidad) {
		productos.put(producto, cantidad);
	}
	
	
	/**
	 * Setea el precio del producto. Si el producto existe en el inventario devuelve true. Caso contrario, devuelve false.
	 * @param producto
	 * @param precio
	 * @return boolean
	 */

	public boolean setPrecioProducto(Producto producto, float precio) {
		Producto productoBuscado = this.buscarProducto(producto);
		if (productoBuscado != null) {
			productoBuscado.setPrecio(precio);
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si hay stock del producto. Devolviendo true si hay y false si no.
	 * @param producto
	 * @return boolean
	 */
	public boolean hayStock(Producto producto) {
		if (this.obtenerStock(producto) > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve el producto buscado, decrementando el stock en 1. Si no hay stock o no existe en el inventario, devuelve null
	 * @param producto
	 * @return Producto
	 */
	public Producto quitarProducto(Producto producto) {
		Producto productoBuscado = this.buscarProducto(producto);
		if (productoBuscado != null && this.hayStock(productoBuscado)) {
			this.productos.merge(productoBuscado, -1, Integer::sum);
		}
		return null;
	}
	
	/**
	 * Busca el producto en el inventario. Devuelve la referencia al producto buscado. Si no existe devuelve null
	 * @param producto
	 * @return Producto
	 */
	public Producto buscarProducto(Producto producto) {
		for (Producto pi : this.productos.keySet()) {
			if (pi.getClass().isInstance(producto)) {
				return pi;
			}
		}
		return null;
	}
	
	
	/**
	 * Devuelve un String con todos los productos en el inventario con su Nombre, Stock y Precio
	 */
	public String toString() {
		String listaProductos = "";
		for (Producto producto : this.productos.keySet()) {
			listaProductos += producto.getClass().getSimpleName() + "  Stock: " + this.productos.get(producto) + 
					"  Precio: " + producto.getPrecio() + "\n";
		}
		return listaProductos;
	}
	
	
}
