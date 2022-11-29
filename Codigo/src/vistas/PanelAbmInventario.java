package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class PanelAbmInventario extends Panel {
	
	private JTable tablaProductos;
	private JScrollPane scrollPaneTablaProductos;
	private JPanel panelPrincipal;
	private DialogoDatosProducto dialogoDatosProducto;
	private JPanel panelBotones;
	private JButton buttonActualizar;

	
	public PanelAbmInventario() {
		setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarTablas();
		this.agregarBotones();
		this.iniciarDialogoDatosProducto();
		this.setBordePanel("Inventario");
		
	}

	private void agregarTablas() {
		this.tablaProductos = new JTable();
		this.tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPaneTablaProductos = new JScrollPane(tablaProductos);
		scrollPaneTablaProductos.setOpaque(false);
		panelPrincipal.add(scrollPaneTablaProductos);
		
	}
	
	private void agregarBotones() {
		buttonActualizar = VistaConfig.crearBotonFormateado("Actualizar", "ACTUALIZAR");
		panelBotones.add(buttonActualizar);
	}
	
	public void setearTablaProductos(DefaultTableModel listadoProductos) {
		this.tablaProductos.setModel(listadoProductos);
	}
	
	public int getIdProductoSeleccionado() {
		int filaSeleccionada = this.tablaProductos.getSelectedRow();
		if (filaSeleccionada != -1) {
			//Se retorna la columna 0 (id) de la fila seleccionada
			return (int) this.tablaProductos.getValueAt(filaSeleccionada, 0);
		}
		return -1;
	}
	
	public void cerrarDialogoDatosProducto() {
		this.dialogoDatosProducto.cerrar();
	}
	
	public void mostrarDatosProducto(int idProducto, String nombreProducto, int cantStock, float precio) {
		this.dialogoDatosProducto.setearDatosProducto(idProducto, nombreProducto, cantStock, precio);
	}
	
	private void iniciarDialogoDatosProducto() {
		JFrame framePadre = (JFrame) SwingUtilities.getWindowAncestor(this);
		this.dialogoDatosProducto = new DialogoDatosProducto(framePadre, true);
		dialogoDatosProducto.setLocationRelativeTo(this);
	}
	
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
	}

	public String getNombreProducto() {
		return this.dialogoDatosProducto.getNombreProducto();
	}
	
	public String getPrecioProducto() {
		return this.dialogoDatosProducto.getPrecio();
	}
	
	public String getStockProducto() {
		return this.dialogoDatosProducto.getStock();
	}
	

	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		
	}

	public void setMouseListener(MouseListener controlador) {
		this.tablaProductos.addMouseListener(controlador);
	}
	
	@Override
	public void setActionListener(ActionListener controlador) {
		this.dialogoDatosProducto.setActionListener(controlador);
		this.buttonActualizar.addActionListener(controlador);
	}

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}
	
}
