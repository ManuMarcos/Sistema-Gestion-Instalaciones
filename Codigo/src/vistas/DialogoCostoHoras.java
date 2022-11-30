package vistas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoCostoHoras extends JDialog {

	private JPanel panelPrincipal = new JPanel();
	private JTextField textFieldCostoJunior;
	private JTextField textFieldCostoSemiSenior;
	private JTextField textFieldCostoSenior;
	private JLabel labelJunior;
	private JLabel labelSemiSenior;
	private JLabel labelSenior;
	private JPanel panelCentral;
	private JPanel panelBotones;
	private JPanel panelCostoJunior;
	private JPanel panelCostoSemiSenior;
	private JPanel panelCostoSenior;
	private JButton buttonConfirmar;
	private JButton buttonCancelar;

	public DialogoCostoHoras(JFrame framePadre, boolean esModal) {
		super(framePadre, esModal);
		setBounds(100, 100, 327, 260);
		this.setBackground(Color.WHITE);
		this.setTitle("Costo Horas de Trabajo");
		panelPrincipal.setOpaque(false);
		getContentPane().setLayout(new BorderLayout());
		this.agregarPaneles();
		this.agregarBotones();
		this.agregarEtiquetas();
		this.agregarTextFields();
	}
	
	private void agregarPaneles() {
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelPrincipal.add(panelCentral);
		panelCentral.setLayout(new GridLayout(3, 1, 0, 0));
		
		panelCostoJunior = new JPanel();
		panelCostoJunior.setOpaque(false);
		panelCentral.add(panelCostoJunior);
		
		panelCostoSemiSenior = new JPanel();
		panelCostoSemiSenior.setOpaque(false);
		panelCentral.add(panelCostoSemiSenior);
		
		panelCostoSenior = new JPanel();
		panelCostoSenior.setOpaque(false);
		panelCentral.add(panelCostoSenior);
		
		panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		
	}

	private void agregarEtiquetas() {

		this.labelJunior = VistaConfig.crearEtiquetaFormateada("Junior");
		panelCostoJunior.add(labelJunior);
		
		this.labelSemiSenior = VistaConfig.crearEtiquetaFormateada("SemiSenior");
		panelCostoSemiSenior.add(labelSemiSenior);
		
		this.labelSenior = VistaConfig.crearEtiquetaFormateada("Senior");
		panelCostoSenior.add(labelSenior);
	}
	
	private void agregarBotones() {
		buttonConfirmar = VistaConfig.crearBotonFormateado("Confirmar", "CONFIRMAR_COSTOS_HORA");
		panelBotones.add(buttonConfirmar);
		
		buttonCancelar = VistaConfig.crearBotonFormateado("Cancelar", "CANCELAR_COSTOS_HORA");
		panelBotones.add(buttonCancelar);
	}
	
	private void agregarTextFields() {
		textFieldCostoJunior = VistaConfig.crearTextFieldFormateado(5);
		panelCostoJunior.add(textFieldCostoJunior);

		textFieldCostoSemiSenior = VistaConfig.crearTextFieldFormateado(5);
		panelCostoSemiSenior.add(textFieldCostoSemiSenior);

		textFieldCostoSenior = VistaConfig.crearTextFieldFormateado(5);
		panelCostoSenior.add(textFieldCostoSenior);
	}
	
	public void setCostos(String costoJunior, String costoSemiSenior, String costoSenior) {
		this.textFieldCostoJunior.setText(costoJunior);
		this.textFieldCostoSemiSenior.setText(costoSemiSenior);
		this.textFieldCostoSenior.setText(costoSenior);
		this.setVisible(true);
	}

	public void cerrar() {
		this.setVisible(false);
	}

	public String getCostoJunior() {
		return this.textFieldCostoJunior.getText();
	}
	
	public String getCostoSemiSenior() {
		return this.textFieldCostoSemiSenior.getText();
	}

	public String getCostoSenior() {
		return this.textFieldCostoSenior.getText();
	}

	public void setActionListener(ActionListener controlador) {
		this.buttonConfirmar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	

}
