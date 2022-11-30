package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;

public class DialogoDatosFactura extends JDialog {

	private JPanel panelPrincipal;
	private JPanel panelHeaderFactura;
	private JPanel panelLogoEmpresa;
	private JPanel panelDatosFactura;
	private JPanel panelTipoFactura;
	private JPanel panelFechaFactura;
	private JPanel panelNroFactura;
	private JPanel panelDatosCliente;
	private JPanel panelIdCliente;
	private JPanel panelNombreCliente;
	private JPanel panelDireccionCliente;
	private JPanel panelListadoVenta;
	private JPanel panelTotales;
	
	private JLabel labelTipoFactura;
	private JLabel labelLogoEmpresa;
	private JLabel labelNroFactura;
	private JLabel labelFechaFactura;
	private JLabel labelNombreCliente;
	private JLabel labelIdCliente;
	private JLabel labelDireccionCliente;
	
	private JTable tablaListadoVenta;
	private JTable tablaTotales;
	private JScrollPane scrollPaneListadoVenta;
	private JScrollPane scrollPaneTotales;
	
	private JTextField textFieldNombreCliente;
	private JTextField textFieldIdCliente;
	private JTextField textFieldDireccionCliente;
	private JTextField textFieldTipoFactura;
	private JTextField textFieldNroFactura;
	private JTextField textFieldFechaFactura;

	
	public DialogoDatosFactura(JFrame framePadre, boolean esModal) {
		super(framePadre, esModal);
		setBounds(100, 100, 832, 605);
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarTablas();
		this.agregarEtiquetas();
		this.agregarTextFields();
	}
	
	private void agregarTablas() {
		this.tablaListadoVenta = new JTable();
		this.scrollPaneListadoVenta = new JScrollPane(tablaListadoVenta);
		panelListadoVenta.add(scrollPaneListadoVenta);
		
		this.tablaTotales = new JTable();
		this.scrollPaneTotales = new JScrollPane(tablaTotales);
		panelTotales.add(scrollPaneTotales, BorderLayout.CENTER);
		DefaultTableCellRenderer alineacionDerecha =  new DefaultTableCellRenderer();
		alineacionDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		tablaTotales.setDefaultRenderer(String.class, alineacionDerecha);
	}
	
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(4, 1, 0, 5));
		panelPrincipal.setBorder(new EmptyBorder(5,5,5,5));
		
		this.panelHeaderFactura = new JPanel();
		panelHeaderFactura.setOpaque(false);
		panelPrincipal.add(panelHeaderFactura);
		panelHeaderFactura.setLayout(new GridLayout(1, 2, 0, 0));
		
		this.panelLogoEmpresa = new JPanel();
		panelLogoEmpresa.setOpaque(false);
		panelHeaderFactura.add(panelLogoEmpresa);
		
		this.panelDatosFactura = new JPanel();
		panelDatosFactura.setOpaque(false);
		panelHeaderFactura.add(panelDatosFactura);
		panelDatosFactura.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelTipoFactura = new JPanel();
		panelTipoFactura.setOpaque(false);
		panelDatosFactura.add(panelTipoFactura);
		
		this.panelNroFactura = new JPanel();
		panelNroFactura.setOpaque(false);
		panelDatosFactura.add(panelNroFactura);
		
		this.panelFechaFactura = new JPanel();
		panelFechaFactura.setOpaque(false);
		panelDatosFactura.add(panelFechaFactura);
		
		this.panelDatosCliente = new JPanel();
		panelDatosCliente.setOpaque(false);
		panelPrincipal.add(panelDatosCliente);
		panelDatosCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelNombreCliente = new JPanel();
		panelNombreCliente.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelNombreCliente.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDatosCliente.add(panelNombreCliente);
		
		this.panelIdCliente = new JPanel();
		panelIdCliente.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelIdCliente.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelDatosCliente.add(panelIdCliente);
		
		this.panelDireccionCliente = new JPanel();
		panelDireccionCliente.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panelDireccionCliente.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelDatosCliente.add(panelDireccionCliente);
		
		this.panelListadoVenta = new JPanel();
		panelListadoVenta.setOpaque(false);
		panelPrincipal.add(panelListadoVenta);
		panelListadoVenta.setLayout(new BorderLayout(0, 0));
		
		this.panelTotales = new JPanel();
		panelTotales.setOpaque(false);
		panelPrincipal.add(panelTotales);
		panelTotales.setLayout(new BorderLayout(0, 0));
	}
	
	private void agregarEtiquetas() {
		this.labelLogoEmpresa = new JLabel();
		panelLogoEmpresa.add(labelLogoEmpresa);
		
		this.labelTipoFactura = VistaConfig.crearEtiquetaFormateada("Tipo factura:");
		panelTipoFactura.add(labelTipoFactura);
		
		this.labelNroFactura = VistaConfig.crearEtiquetaFormateada("Nro factura:");
		panelNroFactura.add(labelNroFactura);
		
		this.labelFechaFactura = VistaConfig.crearEtiquetaFormateada("Fecha:");
		panelFechaFactura.add(labelFechaFactura);
		
		this.labelNombreCliente = VistaConfig.crearEtiquetaFormateada("Nombre:");
		panelNombreCliente.add(labelNombreCliente);
		
		this.labelIdCliente = VistaConfig.crearEtiquetaFormateada("ID:");
		panelIdCliente.add(labelIdCliente);
		
		this.labelDireccionCliente =VistaConfig.crearEtiquetaFormateada("Direccion:");
		panelDireccionCliente.add(labelDireccionCliente);
	}
	
	private void agregarTextFields() {
		textFieldTipoFactura = VistaConfig.crearTextFieldFormateado(2);
		textFieldTipoFactura.setEditable(false);
		panelTipoFactura.add(textFieldTipoFactura);
		

		textFieldNroFactura = VistaConfig.crearTextFieldFormateado(10);
		panelNroFactura.add(textFieldNroFactura);
		textFieldNroFactura.setEditable(false);
		
		textFieldFechaFactura = VistaConfig.crearTextFieldFormateado(8);
		panelFechaFactura.add(textFieldFechaFactura);
		textFieldFechaFactura.setEditable(false);
		
		textFieldNombreCliente = VistaConfig.crearTextFieldFormateado(30);
		panelNombreCliente.add(textFieldNombreCliente);
		textFieldNombreCliente.setEditable(false);
		
		
		textFieldIdCliente = VistaConfig.crearTextFieldFormateado(12);
		panelIdCliente.add(textFieldIdCliente);
		textFieldIdCliente.setEditable(false);
		
		textFieldDireccionCliente = VistaConfig.crearTextFieldFormateado(30);
		panelDireccionCliente.add(textFieldDireccionCliente);
		textFieldDireccionCliente.setEditable(false);
	}
	
	
	public void setDatos(Icon logoEmpresa, String nroFactura, String tipoFactura, String fecha, String idCliente, String nombreCliente, String direccionCliente, 
			DefaultTableModel listadoVenta, DefaultTableModel totales) {
		this.setTitle("Factura nro " + nroFactura);
		this.labelLogoEmpresa.setIcon(logoEmpresa);
		this.textFieldNroFactura.setText(nroFactura);
		this.textFieldTipoFactura.setText(tipoFactura);
		this.textFieldFechaFactura.setText(fecha);
		this.textFieldIdCliente.setText(idCliente);
		this.textFieldNombreCliente.setText(nombreCliente);
		this.textFieldDireccionCliente.setText(direccionCliente);
		this.tablaListadoVenta.setModel(listadoVenta);
		this.tablaTotales.setModel(totales);
	}
	
	
	
	public void mostrar() {
		this.setVisible(true);
	}
	
	public void cerrar() {
		this.setVisible(false);
	}
	
}
