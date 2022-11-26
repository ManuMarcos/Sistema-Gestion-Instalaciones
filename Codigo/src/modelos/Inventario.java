package modelos;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashMap;



public class Inventario {

	//Attributes
	private HashMap<Producto, Integer> productos;
	
	//Constructor
	public Inventario() {
		this.productos = new HashMap<Producto, Integer>();
	}
	
	
	/**
	 * Devuelve el stock del producto. Si el producto no existe en el inventario devuelve -1
	 * @param producto
	 * @return cantEnStock
	 */
	
	public int getStock(Producto producto) {
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
		Producto productoBuscado = this.buscarProducto(producto);
		if (productoBuscado != null) {
			productos.put(productoBuscado, cantidad);
		}
		else {
			productos.put(producto, cantidad);
		}
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
	
	public void agregarProducto(Producto producto) {
		Producto productoBuscado = this.buscarProducto(producto);
		if (productoBuscado != null) {
			this.productos.merge(productoBuscado, 1, Integer :: sum);
		}
		else {
			this.productos.put(producto, 1);
		}
	}
	
	
	/**
	 * Verifica si hay stock del producto. Devolviendo true si hay y false si no.
	 * @param producto
	 * @return boolean
	 */
	public boolean hayStock(Producto producto) {
		if (this.getStock(producto) > 0) {
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
		int stockDisponible = this.productos.get(productoBuscado);
		
		if (productoBuscado != null && stockDisponible > 0) {
			this.productos.put(productoBuscado, stockDisponible - 1);
			return productoBuscado;
		}
		return null;
	}
	
	/*
	 * Si se puede quitar la cantidad de productos ingresados devuelve el arrayList de los productos quitados, sino devuelve null
	 */
	
	public ArrayList<Producto> quitarProductos(Producto producto, int cantidad){
		Producto productoBuscado = this.buscarProducto(producto);
		int stockDisponible = this.productos.get(productoBuscado);
		
		if (stockDisponible - cantidad >= 0 && productoBuscado != null) {
			ArrayList<Producto> productosQuitados = new ArrayList<Producto>();
			for (int i = 0; i < cantidad; i++) {
				productosQuitados.add(productoBuscado);
			}
			this.productos.put(productoBuscado, stockDisponible - cantidad);
			return productosQuitados;
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
			if (pi.getClass().equals(producto.getClass())) {
				return pi;
			}
		}
		return null;
	}
	
	public ArrayList<ProductoInventarioView> getProductos() {
		ArrayList<ProductoInventarioView> productosView = new ArrayList<ProductoInventarioView>();
		for (Producto pi : this.productos.keySet()) {
			productosView.add(new ProductoInventarioView(pi.getId(),pi.getPrecio(), (int) this.productos.get(pi), pi.getClass().getSimpleName()));
		}
		return productosView;
	}
	
	public ProductoInventarioView getProductoView(int idProducto) {
		for (Producto pi : this.productos.keySet()) {
			if (pi.getId() == idProducto) {
				return new ProductoInventarioView(pi.getId(), pi.getPrecio(),(int) this.productos.get(pi), pi.getClass().getSimpleName());
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
