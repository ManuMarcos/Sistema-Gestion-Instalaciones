package vistas;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class PanelFacturacion extends Panel {

	//Attributes
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	private JScrollPane scrollPane;
	private JTable listadoFacturas;
	private JButton buttonActualizar;
	private JLabel labelBuscarFactura;
	private JTextField textFieldBuscarFactura;
	
	
	public PanelFacturacion() {
		setLayout(new BorderLayout(0, 0));
		this.setBordePanel("Listado de facturas");
		this.agregarPaneles();
		this.agregarTabla();
		this.agregarBotones();
		this.agregarEtiquetas();
		this.agregarTextFields();
	}
	
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.panelSuperior = new JPanel();
		panelSuperior.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelSuperior.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		this.panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		
	}
	
	private void agregarTabla() {
		panelCentral.setLayout(new BorderLayout(0, 0));
		this.listadoFacturas = new JTable();
		this.listadoFacturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.scrollPane = new JScrollPane(listadoFacturas);
		panelCentral.add(scrollPane);
	}
	
	private void agregarBotones() {
		buttonActualizar = VistaConfig.crearBotonFormateado("Actualizar", "ACTUALIZAR");
		panelInferior.add(buttonActualizar);
	}
	
	private void agregarEtiquetas() {
		labelBuscarFactura = VistaConfig.crearEtiquetaFormateada("Buscar factura por numero");
		panelSuperior.add(labelBuscarFactura);
	}
	
	
	private void agregarTextFields() {
		textFieldBuscarFactura = VistaConfig.crearTextFieldFormateado(10);
		panelSuperior.add(textFieldBuscarFactura);
	}
	
	public void setListadoFacturas (DefaultTableModel listadoFacturas) {
		this.listadoFacturas.setModel(listadoFacturas);
	}
	
	@Override
	public void setActionListener(ActionListener controlador) {
		this.buttonActualizar.addActionListener(controlador);
	}
	
	
	
	

	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}

}
