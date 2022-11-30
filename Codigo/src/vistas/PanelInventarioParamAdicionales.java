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

public class PanelInventarioParamAdicionales extends Panel {
	
	private JTable tablaProductos;
	private JScrollPane scrollPaneTablaProductos;
	private JPanel panelPrincipal;
	private DialogoDatosProducto dialogoDatosProducto;
	private DialogoParametrosAdicionales dialogoParamAdicionales;
	private JPanel panelBotones;
	private JButton buttonActualizar;
	private JButton buttonParamAdicionales;

	
	public PanelInventarioParamAdicionales() {
		setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarTablas();
		this.agregarBotones();
		this.iniciarDialogoDatosProducto();
		this.iniciarDialogoParamAdicionales();
		this.setBordePanel("Inventario y Parametros Adicionales");
		
	}

	private void agregarTablas() {
		this.tablaProductos = new JTable();
		this.tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPaneTablaProductos = new JScrollPane(tablaProductos);
		scrollPaneTablaProductos.setOpaque(false);
		panelPrincipal.add(scrollPaneTablaProductos);
		
	}
	
	private void agregarBotones() {
		buttonActualizar = VistaConfig.crearBotonFormateado("Actualizar", "ACTUALIZAR_LISTADO_PRODUCTOS");
		panelBotones.add(buttonActualizar);
		
		buttonParamAdicionales = VistaConfig.crearBotonFormateado("Parametros adicionales", "PARAMETROS_ADICIONALES");
		panelBotones.add(buttonParamAdicionales);
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
	
	private void iniciarDialogoParamAdicionales() {
		JFrame framePadre = (JFrame) SwingUtilities.getWindowAncestor(this);
		this.dialogoParamAdicionales = new DialogoParametrosAdicionales(framePadre, true);
		dialogoParamAdicionales.setLocationRelativeTo(this);
	}
	
	public void setParametrosAdicionales(String costoSeguro, String costoViaje) {
		this.dialogoParamAdicionales.setParametrosAdicionales(costoSeguro, costoViaje);
	}
	
	public void cerrarDialogoParamAdicionales() {
		this.dialogoParamAdicionales.cerrar();
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
	
	public String getCostoViaje() {
		return this.dialogoParamAdicionales.getCostoViaje();
	}
	
	public String getCostoSeguro() {
		return this.dialogoParamAdicionales.getCostoSeguro();
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
		this.buttonActualizar.addActionListener(controlador);
		this.buttonParamAdicionales.addActionListener(controlador);
		this.dialogoDatosProducto.setActionListener(controlador);
		this.dialogoParamAdicionales.setActionListener(controlador);
	}

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}
	
}
