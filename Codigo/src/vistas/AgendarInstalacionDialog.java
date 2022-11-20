package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DateTimePicker;

import controladores.ControladorAgendarInstalacion;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AgendarInstalacionDialog extends JFrame {
	
	
	
	private DateTimePicker dateTimePicker = new DateTimePicker();
	private JPanel panelPrincipal;
	private JPanel buttonPane;
	private JButton agendarButton;
	private JButton cancelButton;
	private JPanel panelCentral;
	private JLabel clienteLabel;
	private JComboBox<String> clientesComboBox;
	private JPanel panel;
	private JLabel fechaLabel;
	
	
	public AgendarInstalacionDialog() {
		setTitle("Agendar Instalacion");
		setBounds(100, 100, 605, 341);
		getContentPane().setLayout(new BorderLayout());
		
		
		
		
		
		
		
		this.dateTimePicker = new DateTimePicker();
		
		
		}
	
	public Calendar getFechaSeleccionada() {
		LocalDate fechaSeleccionada = dateTimePicker.getDatePicker().getDate();
		LocalTime horaSeleccionada = dateTimePicker.getTimePicker().getTime();
		Calendar fechaEnFormatoCalendar = new GregorianCalendar();
		fechaEnFormatoCalendar.set(fechaSeleccionada.getYear(), fechaSeleccionada.getMonthValue(), fechaSeleccionada.getDayOfMonth(), 
		horaSeleccionada.getHour(), horaSeleccionada.getMinute(), 0);
		return fechaEnFormatoCalendar;
	}
	
	
	

	public void setControlador(ControladorAgendarInstalacion controlador) {
		this.agendarButton.addActionListener(controlador);
	}
	
	public void setClientesComboBox(ArrayList<String> nombreClientes) {
		for (int i = 0; i < nombreClientes.size(); i++) {
			this.clientesComboBox.addItem(nombreClientes.get(i).toString());
		}
	}
	
	
	public void mostrarMensajeDeError(String mensaje) {
		JOptionPane.showMessageDialog(getContentPane(), mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeExitoso(String mensaje) {
		JOptionPane.showMessageDialog(getContentPane(), mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
}
