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
import modelos.EmpleadoView;

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
import javax.swing.JSpinner;

public class PanelVerInstalaciones extends Panel {

	private DialogoSeleccionarTecnico ventanaSeleccionarTecnico;
	private JPanel panelModificarInstalacion;
	private JTable tablaDatosInstalacion;
	private JScrollPane tablaScrollPane;
	private JButton buttonCancelar;
	private JButton buttonBuscar;
	private DateTimePicker dateTimePickerInicio;
	private DateTimePicker dateTimePickerFinalizacion;
	private JCheckBox checkBoxAlmorzo;
	private JSpinner cantidadEvaporadoras;
	private JSpinner cantidadKits;
	private JSpinner cantidadCondensadoras;

	/**
	 * Create the panel.
	 */
	public PanelVerInstalaciones() {
		// setLayout(new GridLayout(2, 1, 0, 0));
		this.setOpaque(false);
		setLayout(new BorderLayout(0, 0));

		this.panelModificarInstalacion = new JPanel();
		panelModificarInstalacion.setOpaque(false);
		this.setBordePanel("Instalaciones asignadas");
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

		JPanel panelDatosInstalacion = new JPanel();
		panelDatosInstalacion.setOpaque(false);
		panelBuscarInstalacion.add(panelDatosInstalacion, BorderLayout.CENTER);
		panelDatosInstalacion.setLayout(new BorderLayout(0, 0));

		tablaDatosInstalacion = new JTable();
		this.tablaDatosInstalacion.setEnabled(false);
		this.tablaScrollPane = new JScrollPane(tablaDatosInstalacion);
		tablaScrollPane.setOpaque(false);
		panelDatosInstalacion.add(tablaScrollPane);

		JPanel panelSeleccionarDatos = new JPanel();
		panelSeleccionarDatos.setOpaque(false);
		panelDatos.add(panelSeleccionarDatos, BorderLayout.SOUTH);

		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelModificarInstalacion.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.buttonBuscar = this.crearBotonFormateado("Actualizar", "ACTUALIZAR");
		panelInferior.add(buttonBuscar);

		this.buttonCancelar = this.crearBotonFormateado("Cancelar", "CANCELAR");
		panelInferior.add(buttonCancelar);
		panelSeleccionarDatos.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panelSeleccionarProductos = new JPanel();
		panelSeleccionarProductos.setOpaque(false);
		FlowLayout fl_panelSeleccionarProductos = (FlowLayout) panelSeleccionarProductos.getLayout();
		fl_panelSeleccionarProductos.setAlignment(FlowLayout.LEFT);
		fl_panelSeleccionarProductos.setAlignOnBaseline(true);
		fl_panelSeleccionarProductos.setHgap(25);
		panelSeleccionarDatos.add(panelSeleccionarProductos);

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

	public void mostrarDatosInstalacion(DefaultTableModel datosTableModel) {
		this.tablaDatosInstalacion.setModel(datosTableModel);
		this.tablaDatosInstalacion.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}

	private void limpiarDatosCliente() {
		this.tablaDatosInstalacion.setModel(new DefaultTableModel());
	}

	private void resetearFecha() {
		this.dateTimePickerInicio.getDatePicker().setDateToToday();
		this.dateTimePickerInicio.getTimePicker().setTimeToNow();
		this.dateTimePickerFinalizacion.getDatePicker().setDateToToday();
		this.dateTimePickerFinalizacion.getTimePicker().setTimeToNow();
	}

	public Calendar getFechaInicioSeleccionada() {
		LocalDate fechaSeleccionada = dateTimePickerInicio.getDatePicker().getDate();
		LocalTime horaSeleccionada = dateTimePickerInicio.getTimePicker().getTime();
		Calendar fechaEnFormatoCalendar = new GregorianCalendar();
		fechaEnFormatoCalendar.set(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue() - 1,
				fechaSeleccionada.getDayOfMonth(), horaSeleccionada.getHour(), horaSeleccionada.getMinute(), 0);
		return fechaEnFormatoCalendar;
	}

	public Calendar getFechaFinalizacionSeleccionada() {
		LocalDate fechaSeleccionada = dateTimePickerFinalizacion.getDatePicker().getDate();
		LocalTime horaSeleccionada = dateTimePickerFinalizacion.getTimePicker().getTime();
		Calendar fechaEnFormatoCalendar = new GregorianCalendar();
		fechaEnFormatoCalendar.set(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue() - 1,
				fechaSeleccionada.getDayOfMonth(), horaSeleccionada.getHour(), horaSeleccionada.getMinute(), 0);
		return fechaEnFormatoCalendar;
	}

	public void setActionListener(ActionListener controlador) {
		this.buttonBuscar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
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
		this.limpiarDatosCliente();
		this.resetearFecha();
		this.limpiarCheckBoxes();
	}

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}

}
