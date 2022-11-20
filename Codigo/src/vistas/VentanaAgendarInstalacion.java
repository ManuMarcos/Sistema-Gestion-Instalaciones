package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DateTimePicker;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaAgendarInstalacion extends JFrame {

	private JPanel contentPane;
	private DateTimePicker dateTimePicker; 
	private JTextField textField;
	private JTable tablaDatosCliente;


	/**
	 * Create the frame.
	 */
	public VentanaAgendarInstalacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 272);
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
		panelDatos.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelBuscarCliente = new JPanel();
		panelDatos.add(panelBuscarCliente);
		panelBuscarCliente.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscarClienteDatos = new JPanel();
		panelBuscarCliente.add(panelBuscarClienteDatos, BorderLayout.WEST);
		
		JLabel labelBuscarCliente = new JLabel("Buscar cliente");
		labelBuscarCliente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelBuscarClienteDatos.add(labelBuscarCliente);
		
		textField = new JTextField();
		textField.setColumns(20);
		panelBuscarClienteDatos.add(textField);
		
		JPanel panelDatosCliente = new JPanel();
		panelBuscarCliente.add(panelDatosCliente, BorderLayout.EAST);
		
		tablaDatosCliente = new JTable();
		
		tablaDatosCliente.setToolTipText("");
		panelDatosCliente.add(tablaDatosCliente);
		
		JPanel panelSeleccionarFecha = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSeleccionarFecha.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelSeleccionarFecha);
		
		JLabel labelSeleccionarFecha = new JLabel("Seleccionar Fecha");
		labelSeleccionarFecha.setFont(new Font(VistaConfig.labelFamilyFont, Font.PLAIN, VistaConfig.labelFontSize));
		panelSeleccionarFecha.add(labelSeleccionarFecha);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		JButton buttonAgendar = new JButton("Agendar");
		VistaConfig.setButtonStyle(buttonAgendar);
		
		panelInferior.add(buttonAgendar);
		
		
		JButton buttonCancelar = new JButton("Cancelar");
		VistaConfig.setButtonStyle(buttonCancelar);
		panelInferior.add(buttonCancelar);
		
		
		this.dateTimePicker = new DateTimePicker();
		panelSeleccionarFecha.add(dateTimePicker);
		dateTimePicker.getDatePicker().setDateToToday();
		dateTimePicker.getTimePicker().setTimeToNow();
	}

}
