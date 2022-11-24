package controladores;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelos.Empresa;
import modelos.ProductoView;
import vistas.PanelAbmInventario;

public class ControladorAbmInventario {

	//Attributes
	private PanelAbmInventario vista;
	private Empresa modelo;
	
	public ControladorAbmInventario() {
		this.modelo = Empresa.getInstance();
		this.vista = new PanelAbmInventario();
		this.cargarListadoDeProductos();
	}
	
	private void cargarListadoDeProductos() {
		DefaultTableModel listadoProductos = new DefaultTableModel();
		
		
		String[] columnas = {"Id", "Producto", "Precio", "Stock"};
		listadoProductos.setColumnIdentifiers(columnas);
		for (ProductoView pv : this.modelo.getProductosView()) {
			listadoProductos.addRow(new Object[] {pv.getId(), pv.getProducto(), pv.getPrecio(), pv.getStock()});
		}
		this.vista.setearTablaProductos(listadoProductos);
		
	}
	
	public JPanel getVista() {
		return this.vista;
	}
	
	
	
	
	
}
