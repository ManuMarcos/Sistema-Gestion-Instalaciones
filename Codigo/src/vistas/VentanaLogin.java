package vistas;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controladores.ControladorLogin;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;



public class VentanaLogin extends JFrame {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JComboBox<String> comboBoxTipoUsuario;
	private JPanel panelCentral;
	private JPanel panelLogo;
	private JPanel panelContrasena;
	private JPanel panelTipoUsuario;
	private JPanel panelInferior;
	private JPanel panelUsuario;
	private JButton buttonIngresar;
	private JLabel labelTipoUsuario;
	private JLabel labelContrasena;
	private JLabel labelUsuario;
	private JLabel labelLogoEmpresa;
	private JLabel footerLabel;
	
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JPanel panelBoton;
	private JPanel panelTexto;
	private JPanel panelSuperior;
	
	
		public VentanaLogin(ControladorLogin controlador) {
			setTitle("Sistema de Gestion de Instalaciones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 716, 642);
			this.setLocationRelativeTo(null);
			
			this.agregarPaneles();
			
			this.agregarEtiquetas();
			this.agregarTextFields();
			this.agregarBotones();
			this.agregarComboBoxes();
		}

		public void setActionListener(ActionListener controlador) {
			this.buttonIngresar.addActionListener(controlador);
		}
		
		
		private void agregarEtiquetas() {
			this.labelLogoEmpresa= new JLabel();
			labelLogoEmpresa.setIcon(new ImageIcon("logo-empresa.png"));
			panelLogo.add(labelLogoEmpresa);

			this.labelUsuario = new JLabel("Usuario");
			labelUsuario.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
			panelUsuario.add(labelUsuario);
			
			this.labelContrasena = new JLabel("Contraseña");
			labelContrasena.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			labelContrasena.setHorizontalAlignment(SwingConstants.LEFT);
			panelContrasena.add(labelContrasena);
			
			this.labelTipoUsuario = VistaConfig.crearEtiquetaFormateada("Tipo de Usuario");
			labelTipoUsuario.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			labelTipoUsuario.setHorizontalAlignment(SwingConstants.LEFT);
			panelTipoUsuario.add(labelTipoUsuario);
			
			this.footerLabel = new JLabel("Desarrollado por Grupo  6 - Programacion Orientada a Objetos");
			footerLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panelTexto.add(footerLabel);			
		}
		
		private void agregarBotones() {
			this.buttonIngresar = VistaConfig.crearBotonFormateado("Ingresar", "INGRESAR");
			panelBoton.add(buttonIngresar);
			
			buttonIngresar.setPreferredSize(new Dimension(200, 50));
			
		}
		
		private void agregarTextFields() {
			textFieldUsuario = new JTextField();
			textFieldUsuario.setColumns(15);
			textFieldUsuario.setFont(new Font(VistaConfig.labelFontFamily, Font.PLAIN, 18));
			panelUsuario.add(textFieldUsuario);
			textFieldUsuario.setBorder(new EmptyBorder(5,5,5,5));
			
			passwordField = new JPasswordField();
			passwordField.setMaximumSize(new Dimension(30, 30));
			passwordField.setFont(new Font(VistaConfig.labelFontFamily, Font.PLAIN, 18));
			panelContrasena.add(passwordField);
			passwordField.setColumns(15);
			passwordField.setBorder(new EmptyBorder(5,5,5,5));
		}
		
		private void agregarComboBoxes() {
			this.comboBoxTipoUsuario = new JComboBox<String>();
			panelTipoUsuario.add(comboBoxTipoUsuario);
		}
		
		
		
		private void agregarPaneles() {
			
			panelPrincipal = new JPanel();
			panelPrincipal.setBackground(new Color(255, 255, 255));
			panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panelPrincipal);
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			panelPrincipal.setBackground(VistaConfig.celeste);
			
			this.panelCentral = new JPanel();
			panelCentral.setOpaque(false);
			panelPrincipal.add(panelCentral, BorderLayout.CENTER);
			panelCentral.setLayout(new GridLayout(3, 1, 0, 0));
			
			
			this.panelUsuario = new JPanel();
			panelUsuario.setOpaque(false);
			panelCentral.add(panelUsuario);
			
			this.panelContrasena = new JPanel();
			panelContrasena.setOpaque(false);
			panelCentral.add(panelContrasena);
			
			this.panelTipoUsuario = new JPanel();
			panelTipoUsuario.setOpaque(false);
			panelCentral.add(panelTipoUsuario);
			
			this.panelInferior = new JPanel();
			panelInferior.setOpaque(false);
			panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
			panelInferior.setLayout(new GridLayout(2, 1, 0, 0));
			
			panelBoton = new JPanel();
			panelBoton.setOpaque(false);
			panelInferior.add(panelBoton);
			
			panelTexto = new JPanel();
			panelTexto.setOpaque(false);
			panelInferior.add(panelTexto);
			
			panelSuperior = new JPanel();
			panelSuperior.setOpaque(false);
			panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
			
			this.panelLogo = new JPanel();
			panelLogo.setOpaque(false);
			panelSuperior.add(panelLogo);
			
			
		}
		
		public void setComboTiposDeUsuario(DefaultComboBoxModel<String> tiposDeUsuario) {
			this.comboBoxTipoUsuario.setModel(tiposDeUsuario);
			comboBoxTipoUsuario.setFont(new Font(VistaConfig.labelFontFamily, Font.PLAIN, 18));
		}
		
		
		public String getContrasena() {
			return this.passwordField.getText();
		}
		
		public String getUsuario() {
			return this.textFieldUsuario.getText();
		}
		
		public String getTipoDeUsuario() {
			return this.comboBoxTipoUsuario.getSelectedItem().toString();
		}
		
		public void mostrarMensajeDeError(String mensaje) {
			JOptionPane.showMessageDialog(panelPrincipal, mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
		}
		
		public void mostrarMensajeExitoso(String mensaje) {
			JOptionPane.showMessageDialog(panelPrincipal, mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
		}
		
}
