package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DateTimePicker;

import controladores.ControladorAgendarInstalacion;
import modelos.EmpleadoVO;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.SwingConstants;

public class VentanaAgendarInstalacion extends JFrame {

	private VentanaSeleccionarTecnico ventanaSeleccionarTecnico;
	private JPanel contentPane;
	private DateTimePicker dateTimePicker; 
	private JTextField idClienteTextField;
	private JTable tablaDatosCliente;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonAgendar;


	/**
	 * Create the frame.
	 */
	public VentanaAgendarInstalacion() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 795, 221);
		this.setTitle("Agendar Instalacion");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panelDatos = new JPanel();
		panelCentral.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarCliente = new JPanel();
		panelDatos.add(panelBuscarCliente, BorderLayout.CENTER);
		panelBuscarCliente.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarClienteDatos = new JPanel();
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
		panelBuscarCliente.add(panelDatosCliente, BorderLayout.CENTER);
		panelDatosCliente.setLayout(new BorderLayout(0, 0));
		
		
		tablaDatosCliente = new JTable();
		this.tablaScrollPane= new JScrollPane(tablaDatosCliente);
		panelDatosCliente.add(tablaScrollPane);
		
		JPanel panelSeleccionarFecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSeleccionarFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelSeleccionarFecha, BorderLayout.SOUTH);
		
		JLabel labelSeleccionarFecha = new JLabel("Seleccionar Fecha");
		labelSeleccionarFecha.setFont(new Font(VistaConfig.labelFamilyFont, Font.PLAIN, VistaConfig.labelFontSize));
		panelSeleccionarFecha.add(labelSeleccionarFecha);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
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
	
	public Calendar getFechaSeleccionada() {
		LocalDate fechaSeleccionada = dateTimePicker.getDatePicker().getDate();
		LocalTime horaSeleccionada = dateTimePicker.getTimePicker().getTime();
		Calendar fechaEnFormatoCalendar = new GregorianCalendar();
		fechaEnFormatoCalendar.set(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue() - 1, fechaSeleccionada.getDayOfMonth(), 
		horaSeleccionada.getHour(), horaSeleccionada.getMinute(), 0);
		return fechaEnFormatoCalendar;
	}
	

	
	public void setControladorDeEventos(ControladorAgendarInstalacion controlador) {
		this.idClienteTextField.addKeyListener(controlador);
		this.buttonAgendar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	public void mostrarMensajeDeError(String mensaje) {
		JOptionPane.showMessageDialog(contentPane, mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeDeError(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(contentPane, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void mostrarMensajeExitoso(String mensaje) {
		JOptionPane.showMessageDialog(contentPane, mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarTecnicosDisponibles(DefaultComboBoxModel<EmpleadoVO> comboBoxModel, ControladorAgendarInstalacion controlador) {
		this.ventanaSeleccionarTecnico = new VentanaSeleccionarTecnico(this, true);
		this.ventanaSeleccionarTecnico.setControlador(controlador);
		this.ventanaSeleccionarTecnico.setTecnicosDisponibles(comboBoxModel);
		this.ventanaSeleccionarTecnico.setLocationRelativeTo(this);
		this.ventanaSeleccionarTecnico.setVisible(true);
	}
	
	public int getIdTecnicoSeleccionado() {
		return this.ventanaSeleccionarTecnico.getTecnicoSeleccionado().getId();
	}
	
	public void mostrarMensajeInformativo(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this.ventanaSeleccionarTecnico, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	
	
}
