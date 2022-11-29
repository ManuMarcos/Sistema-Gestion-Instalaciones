package vistas;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DateTimePicker;

import controladores.ControladorAgendarInstalacion;
import modelos.ComboItem;
import modelos.EmpleadoView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class PanelAgendarInstalacion extends Panel {

	private DialogoSeleccionarTecnico ventanaSeleccionarTecnico;
	private JPanel panelAgendarInstalacion;
	private JPanel panelCentral;
	private JPanel panelDatos;
	private JPanel panelBuscarCliente;
	private JPanel panelBuscarClienteDatos;
	private JPanel panelDatosCliente;
	private JPanel panelSeleccionarDatos;
	private JPanel panelInferior;
	private JPanel panelSeleccionarFecha;
	private JPanel panelCheckBox;

	private JTextField idClienteTextField;
	private JTable tablaDatosCliente;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonAgendar;
	private DateTimePicker dateTimePicker;
	private JCheckBox checkBoxNecesitaSeguro;
	private JCheckBox checkBoxNecesitaSoportePared;
	private JLabel labelBuscarCliente;
	private JLabel labelSeleccionarFecha;
	private DialogoListadoClientes dialogoListadoClientes;
	private JButton buttonBuscarCliente;
	
	
	
	public PanelAgendarInstalacion() {
		
		this.setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarCheckBoxes();
		this.agregarBotones();
		this.agregarTabla();
		this.agregarDatePickers();
		this.iniciarDialogoListadoClientes();
		
	}
	
	
	private void agregarPaneles() {
		this.panelAgendarInstalacion = new JPanel();
		panelAgendarInstalacion.setOpaque(false);
		this.setBordePanel("Agendar Instalacion");
		add(panelAgendarInstalacion);
		panelAgendarInstalacion.setLayout(new BorderLayout(0, 0));

		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelAgendarInstalacion.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		this.panelDatos = new JPanel();
		panelDatos.setOpaque(false);
		panelCentral.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		this.panelBuscarCliente = new JPanel();
		panelBuscarCliente.setOpaque(false);
		panelDatos.add(panelBuscarCliente, BorderLayout.CENTER);
		panelBuscarCliente.setLayout(new BorderLayout(0, 0));
		
		this.panelBuscarClienteDatos = new JPanel();
		panelBuscarClienteDatos.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelBuscarClienteDatos.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelBuscarCliente.add(panelBuscarClienteDatos, BorderLayout.NORTH);
		
		this.panelDatosCliente = new JPanel();
		panelDatosCliente.setOpaque(false);
		panelBuscarCliente.add(panelDatosCliente, BorderLayout.CENTER);
		panelDatosCliente.setLayout(new BorderLayout(0, 0));
		
		this.panelSeleccionarDatos = new JPanel();
		panelSeleccionarDatos.setOpaque(false);
		panelDatos.add(panelSeleccionarDatos, BorderLayout.SOUTH);
		
		this.panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelAgendarInstalacion.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.panelSeleccionarFecha = new JPanel();
		panelSeleccionarFecha.setOpaque(false);
		FlowLayout fl_panelSeleccionarFecha = (FlowLayout) panelSeleccionarFecha.getLayout();
		fl_panelSeleccionarFecha.setAlignment(FlowLayout.LEFT);
		panelSeleccionarDatos.add(panelSeleccionarFecha);
		
		this.panelCheckBox = new JPanel();
		panelCheckBox.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelCheckBox.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelSeleccionarDatos.add(panelCheckBox);
	}
	
	private void agregarEtiquetas() {
		this.labelSeleccionarFecha = this.crearEtiquetaFormateada("Seleccionar fecha");
		panelSeleccionarFecha.add(labelSeleccionarFecha);
	}
	
	
	
	private void agregarBotones() {
		this.buttonAgendar= this.crearBotonFormateado("Agendar", "AGENDAR");
		panelInferior.add(buttonAgendar);
		
		
		this.buttonCancelar = this.crearBotonFormateado("Cancelar", "CANCELAR");
		panelInferior.add(buttonCancelar);
		panelSeleccionarDatos.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.buttonBuscarCliente = this.crearBotonFormateado("Seleccionar cliente", "ABRIR_LISTADO_CLIENTES");
		panelBuscarClienteDatos.add(buttonBuscarCliente);
	}
	
	private void agregarCheckBoxes() {
		this.checkBoxNecesitaSeguro = new JCheckBox("Seguro de trabajo en altura");
		this.checkBoxNecesitaSeguro.setOpaque(false);
		this.checkBoxNecesitaSeguro.setFont(this.getFuentaEtiqueta());
		panelCheckBox.add(checkBoxNecesitaSeguro);
		
		this.checkBoxNecesitaSoportePared= new JCheckBox("Soporte para pared");
		this.checkBoxNecesitaSoportePared.setOpaque(false);
		this.checkBoxNecesitaSoportePared.setFont(this.getFuentaEtiqueta());
		panelCheckBox.add(this.checkBoxNecesitaSoportePared);
	}
	
	private void agregarDatePickers() {
		this.dateTimePicker = new DateTimePicker();
		panelSeleccionarFecha.add(dateTimePicker);
		
		this.dateTimePicker.getTimePicker().setTimeToNow();
		this.dateTimePicker.getDatePicker().setDateToToday();
	}
	
	private void agregarTabla() {
		tablaDatosCliente = new JTable();
		this.tablaDatosCliente.setEnabled(false);
		this.tablaScrollPane= new JScrollPane(tablaDatosCliente);
		tablaScrollPane.setOpaque(false);
		panelDatosCliente.add(tablaScrollPane);
	}
	

	public void mostrarDatosCliente(DefaultTableModel datosTableModel) {
		this.tablaDatosCliente.setModel(datosTableModel);
		this.tablaDatosCliente.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}
	
	
	private void limpiarDatosCliente() {
		this.tablaDatosCliente.setModel(new DefaultTableModel());
	}
	
	private void resetearFecha() {
		this.dateTimePicker.getDatePicker().setDateToToday();
		this.dateTimePicker.getTimePicker().setTimeToNow();
	}
	
	public Calendar getFechaSeleccionada() {
		LocalDate fechaSeleccionada = dateTimePicker.getDatePicker().getDate();
		LocalTime horaSeleccionada = dateTimePicker.getTimePicker().getTime();
		Calendar fechaEnFormatoCalendar = new GregorianCalendar();
		fechaEnFormatoCalendar.set(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue() - 1, fechaSeleccionada.getDayOfMonth(), 
		horaSeleccionada.getHour(), horaSeleccionada.getMinute(), 0);
		return fechaEnFormatoCalendar;
	}
	

	public void mostrarListadoClientes(DefaultTableModel listadoClientes) {
		this.dialogoListadoClientes.setListadoClientes(listadoClientes);
	}
	
	public void cerrarListadoClientes() {
		this.dialogoListadoClientes.cerrar();
	}
	
	
	
	
	private void iniciarDialogoListadoClientes() {
		JFrame framePadre = (JFrame) SwingUtilities.getWindowAncestor(this);
		this.dialogoListadoClientes = new DialogoListadoClientes(framePadre, true);
		dialogoListadoClientes.setLocationRelativeTo(this);
	}
	
	public void setActionListener(ActionListener controlador) {
		this.buttonAgendar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
		this.buttonBuscarCliente.addActionListener(controlador);
	}
	
	public void setKeyListener(KeyListener controlador) {
		this.dialogoListadoClientes.setKeyListener(controlador);
	}
	
	public void setMouseListener(MouseListener controlador) {
		this.dialogoListadoClientes.setMouseListener(controlador);
	}
	
	public void mostrarTecnicosDisponibles(DefaultComboBoxModel<EmpleadoView> comboBoxModel, ControladorAgendarInstalacion controlador) {
		JFrame framePadre =  (JFrame) SwingUtilities.getWindowAncestor(this);
		this.ventanaSeleccionarTecnico = new DialogoSeleccionarTecnico(framePadre, true);
		this.ventanaSeleccionarTecnico.setControlador(controlador);
		this.ventanaSeleccionarTecnico.setTecnicosDisponibles(comboBoxModel);
		this.ventanaSeleccionarTecnico.setLocationRelativeTo(this);
		this.ventanaSeleccionarTecnico.setVisible(true);
	}
	
	public void cerrarVentanasEmergentes() {
		this.ventanaSeleccionarTecnico.setVisible(false);
	}
	
	private void limpiarCheckBoxes() {
		this.checkBoxNecesitaSoportePared.setSelected(false);
		this.checkBoxNecesitaSeguro.setSelected(false);
	}
	
	
	public int getIdTecnicoSeleccionado() {
		return this.ventanaSeleccionarTecnico.getTecnicoSeleccionado().getId();
	}
	
	public long getIdClienteSeleccionado() {
		return this.dialogoListadoClientes.getIdFilaSeleccionada();
	}
	
	public boolean necesitaSeguro() {
		return this.checkBoxNecesitaSeguro.isSelected();
	}
	
	public boolean necesitaSoporte() {
		return this.checkBoxNecesitaSoportePared.isSelected();
	}
	
	public String getNombreClienteIngresado() {
		return this.dialogoListadoClientes.getNombreIngresado();
	}

	
	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		this.limpiarDatosCliente();
		this.resetearFecha();
		this.limpiarCheckBoxes();
	}


	
	
	
	
	

}
