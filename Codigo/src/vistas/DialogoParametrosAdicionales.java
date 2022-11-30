package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoParametrosAdicionales extends JDialog {

	private JPanel panelPrincipal;
	private JTextField textFieldCostoSeguro;
	private JTextField textFieldCostoViaje;
	private JLabel labelCostoSeguro;
	private JLabel labelCostoViaje;
	private JPanel panelCentral;
	private JPanel panelBotones;
	private JPanel panelCostoViaje;
	private JPanel panelCostoSeguro;
	private JButton buttonConfirmar;
	private JButton buttonCancelar;

	public DialogoParametrosAdicionales(JFrame framePadre, boolean esModal) {
		super(framePadre, esModal);
		setBounds(100, 100, 384, 209);
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarBotones();
		this.agregarTextFields();
		this.setTitle("Parametros adicionales");
	}

	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		this.setContentPane(panelPrincipal);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(2, 1, 0, 0));
		
		panelCostoViaje = new JPanel();
		panelCostoViaje.setOpaque(false);
		panelCentral.add(panelCostoViaje);
		
		panelCostoSeguro = new JPanel();
		panelCostoSeguro.setOpaque(false);
		panelCentral.add(panelCostoSeguro);
		
		panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

	}
	
	private void agregarEtiquetas() {
		this.labelCostoSeguro = VistaConfig.crearEtiquetaFormateada("Costo seguro");
		panelCostoSeguro.add(labelCostoSeguro);
		
		this.labelCostoViaje = VistaConfig.crearEtiquetaFormateada("Costo viaje");
		panelCostoViaje.add(labelCostoViaje);		
	}
	
	private void agregarTextFields() {
		textFieldCostoSeguro = VistaConfig.crearTextFieldFormateado(5);
		panelCostoSeguro.add(textFieldCostoSeguro);
	
		textFieldCostoViaje = VistaConfig.crearTextFieldFormateado(5);
		panelCostoViaje.add(textFieldCostoViaje);
	}
	
	private void agregarBotones() {
		buttonConfirmar = VistaConfig.crearBotonFormateado("Confirmar", "MODIFICAR_PARAMETROS");
		panelBotones.add(buttonConfirmar);
		
		buttonCancelar = VistaConfig.crearBotonFormateado("Cancelar", "CANCELAR_PARAMETROS");
		panelBotones.add(buttonCancelar);
	}
	
	public void setParametrosAdicionales(String costoSeguro, String costoViaje) {
		this.textFieldCostoSeguro.setText(costoSeguro);
		this.textFieldCostoViaje.setText(costoViaje);
		this.setVisible(true);
	}
	
	public void cerrar() {
		this.setVisible(false);
	}
	
	public String getCostoSeguro() {
		return this.textFieldCostoSeguro.getText();
	}
	
	public String getCostoViaje() {
		return this.textFieldCostoViaje.getText();
	}
	
	
	public void setActionListener(ActionListener controlador) {
		this.buttonConfirmar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
}
