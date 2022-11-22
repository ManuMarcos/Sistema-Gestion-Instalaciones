package vistas;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DateTimePicker;

import controladores.ControladorOperador;
import modelos.EmpleadoVO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JRadioButton;

public class PanelOperador extends JPanel {

	private VentanaSeleccionarTecnico ventanaSeleccionarTecnico;
	private VentanaUsuario ventanaUsuario;
	private JPanel panelAgendarInstalacion;
	private JPanel panel;
	private DateTimePicker dateTimePicker; 
	private JTextField idClienteTextField;
	private JTable tablaDatosCliente;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonAgendar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelOperador() {
		//this.ventanaUsuario= ventanaUsuario;
		setLayout(new GridLayout(2, 1, 0, 0));
		this.setOpaque(false);
		
		this.panelAgendarInstalacion = new JPanel();
		this.setearBordePanel(panelAgendarInstalacion, "Agendar Instalacion");
		add(panelAgendarInstalacion);
		
		
		
		panelAgendarInstalacion.setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelAgendarInstalacion.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panelDatos = new JPanel();
		panelDatos.setOpaque(false);
		panelCentral.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarCliente = new JPanel();
		panelBuscarCliente.setOpaque(false);
		panelDatos.add(panelBuscarCliente, BorderLayout.CENTER);
		panelBuscarCliente.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarClienteDatos = new JPanel();
		panelBuscarClienteDatos.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelBuscarClienteDatos.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelBuscarCliente.add(panelBuscarClienteDatos, BorderLayout.NORTH);
		
		JLabel labelBuscarCliente = new JLabel("Buscar cliente");
		labelBuscarCliente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelBuscarClienteDatos.add(labelBuscarCliente);
		
		idClienteTextField = new JTextField();
		idClienteTextField.setColumns(20);
		panelBuscarClienteDatos.add(idClienteTextField);
		
		JPanel panelDatosCliente = new JPanel();
		panelDatosCliente.setOpaque(false);
		panelBuscarCliente.add(panelDatosCliente, BorderLayout.CENTER);
		panelDatosCliente.setLayout(new BorderLayout(0, 0));
		
		
		tablaDatosCliente = new JTable();
		this.tablaDatosCliente.setEnabled(false);
		this.tablaScrollPane= new JScrollPane(tablaDatosCliente);
		tablaScrollPane.setOpaque(false);
		panelDatosCliente.add(tablaScrollPane);
		
		JPanel panelSeleccionarFecha = new JPanel();
		panelSeleccionarFecha.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelSeleccionarFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelSeleccionarFecha, BorderLayout.SOUTH);
		
		JLabel labelSeleccionarFecha = new JLabel("Seleccionar Fecha");
		labelSeleccionarFecha.setFont(new Font(VistaConfig.labelFontFamily, Font.PLAIN, VistaConfig.labelFontSize));
		panelSeleccionarFecha.add(labelSeleccionarFecha);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelAgendarInstalacion.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.buttonAgendar= new JButton("Agendar");
		this.buttonAgendar.setActionCommand("AGENDAR");
		VistaConfig.setButtonStyle(buttonAgendar);
		
		panelInferior.add(buttonAgendar);
		
		
		this.buttonCancelar= new JButton("Cancelar");
		this.buttonCancelar.setActionCommand("CANCELAR");
		VistaConfig.setButtonStyle(buttonCancelar);
		panelInferior.add(buttonCancelar);
		
		
		this.dateTimePicker = new DateTimePicker();
		panelSeleccionarFecha.add(dateTimePicker);
		
		JPanel panelCrearCliente = new JPanel();
		panelCrearCliente.setOpaque(false);
		this.setearBordePanel(panelCrearCliente, "Crear Cliente");
		add(panelCrearCliente);
		panelCrearCliente.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelCrearCliente.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre y Apellido");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panelCrearCliente.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion");
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panelCrearCliente.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Cuit/Cuil");
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panelCrearCliente.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Cliente");
		panel_4.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_4.add(rdbtnNewRadioButton_1);
		
		JPanel panel_5 = new JPanel();
		panelCrearCliente.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Correo Electronico");
		panel_5.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panelCrearCliente.add(panel_6);
		
		JButton btnNewButton = new JButton("Crear cliente");
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_6.add(btnNewButton_1);
		dateTimePicker.getDatePicker().setDateToToday();
		dateTimePicker.getTimePicker().setTimeToNow();
		
		
	}
	public String getIdCliente() {
		return this.idClienteTextField.getText();
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
	

	
	public void setControladorDeEventos(ControladorOperador controlador) {
		this.idClienteTextField.addKeyListener(controlador);
		this.buttonAgendar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	public void mostrarMensajeDeError(String mensaje) {
		JOptionPane.showMessageDialog(panelAgendarInstalacion, mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeDeError(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(panelAgendarInstalacion, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void mostrarMensajeExitoso(String mensaje) {
		JOptionPane.showMessageDialog(panelAgendarInstalacion, mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeInformativo(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this.ventanaSeleccionarTecnico, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void mostrarTecnicosDisponibles(DefaultComboBoxModel<EmpleadoVO> comboBoxModel, ControladorOperador controlador) {
		this.ventanaSeleccionarTecnico = new VentanaSeleccionarTecnico(this.ventanaUsuario, true);
		this.ventanaSeleccionarTecnico.setControlador(controlador);
		this.ventanaSeleccionarTecnico.setTecnicosDisponibles(comboBoxModel);
		this.ventanaSeleccionarTecnico.setLocationRelativeTo(this);
		this.ventanaSeleccionarTecnico.setVisible(true);
	}
	
	public void resetearPanel() {
		this.ventanaSeleccionarTecnico.setVisible(false);
		this.idClienteTextField.setText(null);
		this.limpiarDatosCliente();
		this.resetearFecha();
	}
	
	
	public int getIdTecnicoSeleccionado() {
		return this.ventanaSeleccionarTecnico.getTecnicoSeleccionado().getId();
	}
	
	public void setearBordePanel(JPanel panel, String titulo) {
		panel.setBackground(Color.BLACK);
		panel.setOpaque(false);
		Border borde = BorderFactory.createRaisedBevelBorder();
		panel.setBorder(BorderFactory.createTitledBorder(borde, titulo, TitledBorder.CENTER, 
				TitledBorder.CENTER, VistaConfig.getLabelFont(), Color.BLACK));
	}
	
	

}
