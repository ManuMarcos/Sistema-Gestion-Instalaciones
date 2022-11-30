package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoListadoClientes extends JDialog {

	private JPanel panelPrincipal;
	private JPanel panelCentral;
	private JTable tablaClientes;
	private JScrollPane scrollPaneTablaClientes;
	private JPanel pabelBuscarCliente;
	private JLabel labelBuscarCliente;
	private JLabel labelNombreApellido;
	private JTextField textFieldNombreApellido;

	

	public DialogoListadoClientes(JFrame padre, boolean esModal) {
		super(padre, esModal);
		setBounds(100, 100, 718, 461);
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarTabla();
		this.agregarEtiquetas();
		this.agregarTextFields();
		this.setTitle("Listado de Clientes");
			
	}
		
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		pabelBuscarCliente = new JPanel();
		pabelBuscarCliente.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) pabelBuscarCliente.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCentral.add(pabelBuscarCliente, BorderLayout.NORTH);
		
	}
	
	
	public String getNombreIngresado() {
		return this.textFieldNombreApellido.getText();
	}
	
	
	
	public long getIdFilaSeleccionada() {
		int filaSeleccionada = this.tablaClientes.getSelectedRow();
		if (filaSeleccionada != -1) {
			//Se retorna la columna 0 (id) de la fila seleccionada
			return (long) this.tablaClientes.getValueAt(filaSeleccionada, 0);
		}
		return -1;
	}
	
	private void agregarTextFields() {
		textFieldNombreApellido = VistaConfig.crearTextFieldFormateado(15);
		pabelBuscarCliente.add(textFieldNombreApellido);
	}
	
	private void agregarEtiquetas() {			
		labelBuscarCliente = VistaConfig.crearEtiquetaFormateada("Buscar cliente por nombre");
		pabelBuscarCliente.add(labelBuscarCliente);
		
	}
	
	
	private void agregarTabla() {
		this.tablaClientes= new JTable();
		this.tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPaneTablaClientes = new JScrollPane(tablaClientes);
		this.panelCentral.add(scrollPaneTablaClientes);
	}
	
	public void setListadoClientes(DefaultTableModel listadoClientes) {
		this.tablaClientes.setModel(listadoClientes);
		this.tablaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		this.setVisible(true);
	}
	
	public void cerrar() {
		this.setVisible(false);
	}
	
	public void setMouseListener(MouseListener controlador) {
		this.tablaClientes.addMouseListener(controlador);
	}
	
	public void setKeyListener(KeyListener controlador) {
		this.textFieldNombreApellido.addKeyListener(controlador);
	}
	
}
