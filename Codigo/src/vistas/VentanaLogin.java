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

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaLogin extends JFrame {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioTextField;
	private JPasswordField contrasenaField;

		/**
		 * Create the frame.
		 */
		public VentanaLogin(ControladorLogin controlador) {
			setTitle("Sistema de Gestion de Instalaciones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 716, 642);
			this.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setForeground(new Color(255, 255, 255));
			panelPrincipal.setBackground(VistaConfig.celeste);
			contentPane.add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			
			JPanel panelSuperior = new JPanel();
			panelSuperior.setOpaque(false);
			panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
			panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel logoEmpresaLabel = new JLabel("");
			logoEmpresaLabel.setIcon(new ImageIcon("logo-empresa.png"));
			panelSuperior.add(logoEmpresaLabel);
			
			JPanel panelInferior = new JPanel();
			panelInferior.setOpaque(false);
			panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
			
			JLabel footerLabel = new JLabel("Desarrollado por Grupo  6 - Programacion Orientada a Objetos");
			footerLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panelInferior.add(footerLabel);
			
			JPanel panelCentral = new JPanel();
			panelCentral.setOpaque(false);
			panelPrincipal.add(panelCentral, BorderLayout.CENTER);
			panelCentral.setLayout(new BorderLayout(0, 0));
			
			JPanel panelCentralDatos = new JPanel();
			panelCentralDatos.setOpaque(false);
			panelCentralDatos.setBorder(new EmptyBorder(50,50,50,50));
			panelCentral.add(panelCentralDatos);
			panelCentralDatos.setLayout(new GridLayout(0, 2, 50, 50));
			
			JLabel usuarioLabel = new JLabel("Usuario");
			usuarioLabel.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			usuarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(usuarioLabel);
			
			usuarioTextField = new JTextField();
			usuarioTextField.setColumns(20);
			panelCentralDatos.add(usuarioTextField);
			
			JLabel contrasenaLabel = new JLabel("Contraseña");
			contrasenaLabel.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			contrasenaLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(contrasenaLabel);
			
			contrasenaField = new JPasswordField();
			contrasenaField.setColumns(20);
			contrasenaField.setMaximumSize(new Dimension(30, 30));
			panelCentralDatos.add(contrasenaField);
			
			JLabel tipoDeUsuarioLabel = new JLabel("Tipo de Usuario");
			tipoDeUsuarioLabel.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 20));
			tipoDeUsuarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(tipoDeUsuarioLabel);
			
		
			String [] tiposEmpleado = {"Seleccione","Operador","Administrativo", "Administrador", "Tecnico"};
			JComboBox<String> tipoDeUsuarioComboBox = new JComboBox<String>(tiposEmpleado);
			
			panelCentralDatos.add(tipoDeUsuarioComboBox);
			
			JPanel panelInferiorBoton = new JPanel();
			panelInferiorBoton.setOpaque(false);
			panelCentral.add(panelInferiorBoton, BorderLayout.SOUTH);
			
			JButton ingresarButton = VistaConfig.crearBotonFormateado("Ingresar", "INGRESAR");
			ingresarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String usuarioIngresado = usuarioTextField.getText();
					String contrasenaIngresada =  contrasenaField.getText();
					String tipoDeUsuarioSeleccionado = tipoDeUsuarioComboBox.getSelectedItem().toString();
					
					if (usuarioIngresado != "" && contrasenaIngresada != "" && tipoDeUsuarioSeleccionado != "Seleccione") {
						controlador.login(usuarioIngresado, contrasenaIngresada,tipoDeUsuarioSeleccionado);
					}
				}
			});
			ingresarButton.setPreferredSize(new Dimension(200, 50));
			
			panelInferiorBoton.add(ingresarButton);
		}

	
		public void mostrarMensajeDeError(String mensaje) {
			JOptionPane.showMessageDialog(contentPane, mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
		}
		
		public void mostrarMensajeExitoso(String mensaje) {
			JOptionPane.showMessageDialog(contentPane, mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
		}
		
}
