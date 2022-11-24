package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PanelAbmInventario extends Panel {
	
	private JTable tablaProductos;
	private JScrollPane scrollPaneTablaProductos;
	private JPanel panelPrincipal;

	
	public PanelAbmInventario() {
		setLayout(new BorderLayout(0, 0));
		
		this.agregarPaneles();
		this.agregarTablas();
		this.setBordePanel("Inventario");
	}

	private void agregarTablas() {
		this.tablaProductos = new JTable();
		this.scrollPaneTablaProductos = new JScrollPane(tablaProductos);
		panelPrincipal.add(scrollPaneTablaProductos);
	}
	
	public void setearTablaProductos(DefaultTableModel listadoProductos) {
		this.tablaProductos.setModel(listadoProductos);
	}
	
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
	}

	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}
	
}
