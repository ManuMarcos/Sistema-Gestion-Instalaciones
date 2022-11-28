package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelos.Empresa;
import modelos.ProductoInventarioView;
import vistas.PanelAbmInventario;

public class ControladorAbmInventario implements MouseListener, ActionListener{

	//Attributes
	private PanelAbmInventario vista;
	private Empresa modelo;
	
	public ControladorAbmInventario() {
		this.modelo = Empresa.getInstance();
		this.vista = new PanelAbmInventario();
		this.cargarListadoDeProductos();
		this.vista.setMouseListener(this);
		this.vista.setActionListener(this);
	}
	
	private void cargarListadoDeProductos() {
		DefaultTableModel listadoProductos = new DefaultTableModel();
		
		String[] columnas = {"Id", "Producto", "Precio", "Stock"};
		listadoProductos.setColumnIdentifiers(columnas);
		for (ProductoInventarioView pv : this.modelo.getProductosView()) {
			listadoProductos.addRow(new Object[] {pv.getId(), pv.getNombre(), pv.getPrecio(), pv.getStock()});
		}
		this.vista.setearTablaProductos(listadoProductos);
		
	}
	
	public JPanel getVista() {
		return this.vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int idFilaSeleccionada = this.vista.getIdProductoSeleccionado();
		if (idFilaSeleccionada != -1) {
			this.mostrarDatosProducto(idFilaSeleccionada);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		
		switch (comandoAccionado) {
			case "ACTUALIZAR_DATOS_PRODUCTO":
				this.actualizarDatosProducto();
				this.cargarListadoDeProductos();
				this.vista.cerrarDialogoDatosProducto();
				break;
			case "CANCELAR":
				break;
			case "ACTUALIZAR":
				this.cargarListadoDeProductos();
				break;
		}
	}
	
	public void mostrarDatosProducto(int idProducto) {
		ProductoInventarioView productoView = this.modelo.getProductoView(idProducto);
		this.vista.mostrarDatosProducto(productoView.getId(), productoView.getNombre(), productoView.getStock(), productoView.getPrecio());
	}
	
	public void actualizarDatosProducto() {
		this.modelo.actualizarDatosProducto(this.vista.getNombreProducto(), Float.parseFloat(this.vista.getPrecioProducto()), Integer.parseInt(this.vista.getStockProducto()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
