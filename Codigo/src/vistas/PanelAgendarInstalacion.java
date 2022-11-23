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
import modelos.EmpleadoVO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
	private JTextField idClienteTextField;
	private JTable tablaDatosCliente;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonAgendar;
	private DateTimePicker dateTimePicker;
	private JCheckBox checkBoxNecesitaSeguro;
	private JCheckBox checkBoxNecesitaSoportePared;
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelAgendarInstalacion() {
		//setLayout(new GridLayout(2, 1, 0, 0));
		this.setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		this.panelAgendarInstalacion = new JPanel();
		panelAgendarInstalacion.setOpaque(false);
		this.setBordePanel(panelAgendarInstalacion, "Agendar Instalacion");
		add(panelAgendarInstalacion);
		
		
		
		panelAgendarInstalacion.setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelAgendarInstalacion.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
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
		
		JLabel labelBuscarCliente = this.crearEtiquetaFormateada("Buscar cliente");
		panelBuscarClienteDatos.add(labelBuscarCliente);
		
		idClienteTextField = this.crearTextFieldFormatoTexto(11);
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
		
		JPanel panelSeleccionarDatos = new JPanel();
		panelSeleccionarDatos.setOpaque(false);
		panelDatos.add(panelSeleccionarDatos, BorderLayout.SOUTH);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelAgendarInstalacion.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.buttonAgendar= this.crearBotonFormateado("Agendar", "AGENDAR");
		panelInferior.add(buttonAgendar);
		
		
		this.buttonCancelar = this.crearBotonFormateado("Cancelar", "CANCELAR");
		panelInferior.add(buttonCancelar);
		panelSeleccionarDatos.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelSeleccionarFecha = new JPanel();
		panelSeleccionarFecha.setOpaque(false);
		FlowLayout fl_panelSeleccionarFecha = (FlowLayout) panelSeleccionarFecha.getLayout();
		fl_panelSeleccionarFecha.setAlignment(FlowLayout.LEFT);
		panelSeleccionarDatos.add(panelSeleccionarFecha);
		
		JLabel labelSeleccionarFecha = this.crearEtiquetaFormateada("Seleccionar fecha");
		panelSeleccionarFecha.add(labelSeleccionarFecha);
		
		this.dateTimePicker = new DateTimePicker();
		panelSeleccionarFecha.add(dateTimePicker);
		
		JPanel panelCheckBox = new JPanel();
		panelCheckBox.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelCheckBox.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelSeleccionarDatos.add(panelCheckBox);
		
		this.checkBoxNecesitaSeguro = new JCheckBox("Seguro de trabajo en altura");
		this.checkBoxNecesitaSeguro.setOpaque(false);
		this.checkBoxNecesitaSeguro.setFont(this.getFuentaEtiqueta());
		panelCheckBox.add(checkBoxNecesitaSeguro);
		
		this.checkBoxNecesitaSoportePared= new JCheckBox("Soporte para pared");
		this.checkBoxNecesitaSoportePared.setOpaque(false);
		this.checkBoxNecesitaSoportePared.setFont(this.getFuentaEtiqueta());
		panelCheckBox.add(this.checkBoxNecesitaSoportePared);
		
		this.dateTimePicker.getTimePicker().setTimeToNow();
		this.dateTimePicker.getDatePicker().setDateToToday();
		
		
		
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
	

	
	public void setActionListener(ActionListener controlador) {
		this.buttonAgendar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	public void setKeyListener(KeyListener controlador) {
		this.idClienteTextField.addKeyListener(controlador);
	}
	
	
	
	public void mostrarTecnicosDisponibles(DefaultComboBoxModel<EmpleadoVO> comboBoxModel, ControladorAgendarInstalacion controlador) {
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
	
	public boolean necesitaSeguro() {
		return this.checkBoxNecesitaSeguro.isSelected();
	}
	
	public boolean necesitaSoporte() {
		return this.checkBoxNecesitaSoportePared.isSelected();
	}
	

	
	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		this.idClienteTextField.setText(null);
		this.limpiarDatosCliente();
		this.resetearFecha();
		this.limpiarCheckBoxes();
	}


	
	
	
	
	

}
