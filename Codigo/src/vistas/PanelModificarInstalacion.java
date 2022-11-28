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
import com.github.lgooddatepicker.components.TimePicker;

import controladores.ControladorAgendarInstalacion;
import modelos.EmpleadoView;
import modelos.Empresa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;

public class PanelModificarInstalacion extends Panel {

	private DialogoSeleccionarTecnico ventanaSeleccionarTecnico;
	private JPanel panelModificarInstalacion;
	private JTextField idInstalacionTextField;
	private JTable tablaDatosInstalacion;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonAgendar;
	private TimePicker timePickerHoraInicio;
	private TimePicker timePickerHoraFinalizacion;
	private JCheckBox checkBoxAlmorzo;
	private JSpinner cantidadEvaporadoras;
	private JSpinner cantidadKits;
	private JSpinner cantidadCondensadoras;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldFechaFinalizacion;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelModificarInstalacion() {
		//setLayout(new GridLayout(2, 1, 0, 0));
		this.setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		this.panelModificarInstalacion = new JPanel();
		panelModificarInstalacion.setOpaque(false);
		this.setBordePanel("Modificar Instalacion");
		add(panelModificarInstalacion);
		
		
		
		panelModificarInstalacion.setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelModificarInstalacion.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDatos = new JPanel();
		panelDatos.setOpaque(false);
		panelCentral.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarInstalacion = new JPanel();
		panelBuscarInstalacion.setOpaque(false);
		panelDatos.add(panelBuscarInstalacion, BorderLayout.CENTER);
		panelBuscarInstalacion.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarInstalacionDatos = new JPanel();
		panelBuscarInstalacionDatos.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelBuscarInstalacionDatos.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelBuscarInstalacion.add(panelBuscarInstalacionDatos, BorderLayout.NORTH);
		
		JLabel labelBuscarInstalacion = this.crearEtiquetaFormateada("Buscar instalación");
		panelBuscarInstalacionDatos.add(labelBuscarInstalacion);
		
		idInstalacionTextField = this.crearTextFieldFormatoTexto(11);
		panelBuscarInstalacionDatos.add(idInstalacionTextField);
		
		JPanel panelDatosInstalacion = new JPanel();
		panelDatosInstalacion.setOpaque(false);
		panelBuscarInstalacion.add(panelDatosInstalacion, BorderLayout.CENTER);
		panelDatosInstalacion.setLayout(new BorderLayout(0, 0));
		
		
		tablaDatosInstalacion = new JTable();
		this.tablaDatosInstalacion.setEnabled(false);
		this.tablaScrollPane= new JScrollPane(tablaDatosInstalacion);
		tablaScrollPane.setOpaque(false);
		panelDatosInstalacion.add(tablaScrollPane);
		
		JPanel panelSeleccionarDatos = new JPanel();
		panelSeleccionarDatos.setOpaque(false);
		panelDatos.add(panelSeleccionarDatos, BorderLayout.SOUTH);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelModificarInstalacion.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.buttonAgendar= this.crearBotonFormateado("Finalizar", "FINALIZAR");
		panelInferior.add(buttonAgendar);
		
		
		this.buttonCancelar = this.crearBotonFormateado("Cancelar", "CANCELAR");
		panelInferior.add(buttonCancelar);
		panelSeleccionarDatos.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelSeleccionarProductos = new JPanel();
		panelSeleccionarProductos.setOpaque(false);
		FlowLayout fl_panelSeleccionarProductos = (FlowLayout) panelSeleccionarProductos.getLayout();
		fl_panelSeleccionarProductos.setAlignOnBaseline(true);
		fl_panelSeleccionarProductos.setAlignment(FlowLayout.LEFT);
		fl_panelSeleccionarProductos.setHgap(25);
		panelSeleccionarDatos.add(panelSeleccionarProductos);
		
		JLabel labelSpinnerEvaporadora = this.crearEtiquetaFormateada("Evaporadoras");
		panelSeleccionarProductos.add(labelSpinnerEvaporadora);
		
		cantidadEvaporadoras = this.crearSpinner();
		panelSeleccionarProductos.add(cantidadEvaporadoras);
								
		JLabel labelSpinnerCondensadora = this.crearEtiquetaFormateada("Condensadoras");
		panelSeleccionarProductos.add(labelSpinnerCondensadora);
		
		cantidadCondensadoras = this.crearSpinner();
		panelSeleccionarProductos.add(cantidadCondensadoras);
		
		JLabel labelKitDeInstalacion = this.crearEtiquetaFormateada("Kits de Instalación");
		panelSeleccionarProductos.add(labelKitDeInstalacion);
		
		cantidadKits = this.crearSpinner();
		panelSeleccionarProductos.add(cantidadKits);
		
		JPanel panelHoras = new JPanel();
		panelHoras.setOpaque(false);
		panelSeleccionarDatos.add(panelHoras);
		panelHoras.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panelSeleccionarHoraInicio = new JPanel();
		panelSeleccionarHoraInicio.setOpaque(false);
		FlowLayout fl_panelSeleccionarHoraInicio = (FlowLayout) panelSeleccionarHoraInicio.getLayout();
		fl_panelSeleccionarHoraInicio.setAlignment(FlowLayout.LEFT);
		panelHoras.add(panelSeleccionarHoraInicio);
		
		JLabel labelSeleccionarHoraInicio = this.crearEtiquetaFormateada("Hora inicio");
		panelSeleccionarHoraInicio.add(labelSeleccionarHoraInicio);
		
		JPanel panelSeleccionarHoraFinalizacion = new JPanel();
		panelSeleccionarHoraFinalizacion.setOpaque(false);
		FlowLayout fl_panelSeleccionarHoraFinalizacion = (FlowLayout) panelSeleccionarHoraFinalizacion.getLayout();
		fl_panelSeleccionarHoraFinalizacion.setAlignment(FlowLayout.LEFT);
		panelHoras.add(panelSeleccionarHoraFinalizacion);
		
		JLabel labelSeleccionarHoraFinalizacion = this.crearEtiquetaFormateada("Hora finalización");
		panelSeleccionarHoraFinalizacion.add(labelSeleccionarHoraFinalizacion);
		
		textFieldFechaInicio = this.crearTextFieldFormatoTexto(8);
		panelSeleccionarHoraInicio.add(textFieldFechaInicio);
		
		this.timePickerHoraInicio = new TimePicker();
		panelSeleccionarHoraInicio.add(timePickerHoraInicio);
		
		textFieldFechaFinalizacion = this.crearTextFieldFormatoTexto(8);
		panelSeleccionarHoraFinalizacion.add(textFieldFechaFinalizacion);
		
		this.timePickerHoraFinalizacion = new TimePicker();
		panelSeleccionarHoraFinalizacion.add(timePickerHoraFinalizacion);
		
		JPanel panelCheckBox = new JPanel();
		panelCheckBox.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelCheckBox.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelSeleccionarDatos.add(panelCheckBox);
		
		this.checkBoxAlmorzo = new JCheckBox("Almorzó");
		this.checkBoxAlmorzo.setOpaque(false);
		this.checkBoxAlmorzo.setFont(this.getFuentaEtiqueta());
		panelCheckBox.add(checkBoxAlmorzo);
		
	}
	
	
	public String getIdInstalacion() {
		return this.idInstalacionTextField.getText();
	}
	
	public String getCantidadDeEvaporadoras() {
		return this.cantidadEvaporadoras.getValue().toString();
	}

	public String getCantidadDeKits() {
		return this.cantidadKits.getValue().toString();
	}
	
	public String getCantidadDeCondensadoras() {
		return this.cantidadCondensadoras.getValue().toString();
	}
	
	public void setCantKits(int cantKits) {
		this.cantidadKits.setValue(cantKits);
	}
	
	public void setCantCondensadoras(int cantCondensadoras) {
		this.cantidadCondensadoras.setValue(cantCondensadoras);
	}
	
	public void setCantEvaporadoras(int cantEvaporadoras) {
		this.cantidadEvaporadoras.setValue(cantEvaporadoras);
	}
	
	public boolean getAlmuerzo() {
		return this.checkBoxAlmorzo.isSelected();
	}
	
	
	public void mostrarDatosInstalacion(DefaultTableModel datosTableModel) {
		this.tablaDatosInstalacion.setModel(datosTableModel);
		this.tablaDatosInstalacion.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}
	
	private void limpiarDatosCliente() {
		this.tablaDatosInstalacion.setModel(new DefaultTableModel());
	}
	
	private void resetearFecha() {
		
		this.timePickerHoraInicio.setTimeToNow();
		this.timePickerHoraFinalizacion.setTimeToNow();
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.textFieldFechaInicio.setText(fechaInicio);
		this.textFieldFechaInicio.setEditable(false);
	}
	
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.textFieldFechaFinalizacion.setText(fechaFinalizacion);
		this.textFieldFechaFinalizacion.setEditable(false);
	}
	
	public void setHoraInicio(Calendar horaInicio) {
		this.timePickerHoraInicio.setTime(LocalTime.of(horaInicio.get(Calendar.HOUR_OF_DAY), horaInicio.get(Calendar.MINUTE)));
	}
	
	
	public void setHoraFinalizacion(Calendar horaFinalizacion) {
		this.timePickerHoraFinalizacion.setTime(LocalTime.of(horaFinalizacion.get(Calendar.HOUR_OF_DAY), horaFinalizacion.get(Calendar.MINUTE)));
	}
	

	
	
	public LocalTime getHoraInicio() {
		return timePickerHoraInicio.getTime();
	}
	
	public LocalTime getHoraFinalizacion() {
		return timePickerHoraFinalizacion.getTime();
	}

	
	public void setActionListener(ActionListener controlador) {
		this.buttonAgendar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	public void setKeyListener(KeyListener controlador) {
		this.idInstalacionTextField.addKeyListener(controlador);
	}
	
	public void cerrarVentanasEmergentes() {
		this.ventanaSeleccionarTecnico.setVisible(false);
	}
	
	private void limpiarCheckBoxes() {
		this.checkBoxAlmorzo.setSelected(false);
	}
	
	public boolean tecnicoAlmorzo() {
		return this.checkBoxAlmorzo.isSelected();
	}
	

	
	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		this.idInstalacionTextField.setText(null);
		this.limpiarDatosCliente();
		this.resetearFecha();
		this.limpiarCheckBoxes();
	}


	
	
	
	
	

}
