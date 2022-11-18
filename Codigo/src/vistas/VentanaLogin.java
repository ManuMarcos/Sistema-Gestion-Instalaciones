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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Dimension;



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
		public VentanaLogin() {
			setTitle("Sistema de Gestion de Instalaciones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 774, 621);
			this.setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setForeground(new Color(255, 255, 255));
			panelPrincipal.setBackground(new Color(173, 216, 230));
			contentPane.add(panelPrincipal, BorderLayout.CENTER);
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			
			JPanel panelSuperior = new JPanel();
			panelSuperior.setOpaque(false);
			panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
			panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\manue\\OneDrive - Fundación UADE\\2do Cuatrimestre 2022\\IOO\\TPO\\TPO-POO\\logo-empresa (1).png"));
			panelSuperior.add(lblNewLabel_1);
			
			JPanel panelInferior = new JPanel();
			panelInferior.setOpaque(false);
			panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
			
			JLabel lblNewLabel = new JLabel("Desarrollado por Grupo  6 - Programacion Orientada a Objetos");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			panelInferior.add(lblNewLabel);
			
			JPanel panelCentral = new JPanel();
			panelCentral.setOpaque(false);
			panelPrincipal.add(panelCentral, BorderLayout.CENTER);
			panelCentral.setLayout(new BorderLayout(0, 0));
			
			JPanel panelSuperiorTitulo = new JPanel();
			panelSuperiorTitulo.setOpaque(false);
			panelCentral.add(panelSuperiorTitulo, BorderLayout.NORTH);
			
			JPanel panelCentralDatos = new JPanel();
			panelCentralDatos.setOpaque(false);
			panelCentralDatos.setBorder(new EmptyBorder(50,50,50,50));
			panelCentral.add(panelCentralDatos);
			panelCentralDatos.setLayout(new GridLayout(0, 2, 50, 50));
			
			JLabel usuarioLabel = new JLabel("Usuario");
			usuarioLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			usuarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(usuarioLabel);
			
			usuarioTextField = new JTextField();
			usuarioTextField.setColumns(20);
			panelCentralDatos.add(usuarioTextField);
			
			JLabel contrasenaLabel = new JLabel("Contraseña");
			contrasenaLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			contrasenaLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(contrasenaLabel);
			
			contrasenaField = new JPasswordField();
			contrasenaField.setColumns(20);
			contrasenaField.setMaximumSize(new Dimension(30, 30));
			panelCentralDatos.add(contrasenaField);
			
			JLabel tipoDeUsuarioLabel = new JLabel("Tipo de Usuario");
			tipoDeUsuarioLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			tipoDeUsuarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelCentralDatos.add(tipoDeUsuarioLabel);
			
			
			String [] tiposEmpleado = {"Operador","Administrativo", "Administrador", "Tecnico"};
			JComboBox<String> tipoDeUsuarioComboBox = new JComboBox<String>(tiposEmpleado);
			
			
			panelCentralDatos.add(tipoDeUsuarioComboBox);
			
			JPanel panelInferiorBoton = new JPanel();
			panelInferiorBoton.setOpaque(false);
			panelCentral.add(panelInferiorBoton, BorderLayout.SOUTH);
			
			JButton ingresarButton = new JButton("Ingresar");
			ingresarButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			ingresarButton.setPreferredSize(new Dimension(200, 50));
			ingresarButton.setBackground(Color.BLACK);
			ingresarButton.setForeground(UIManager.getColor("Button.focus"));
			panelInferiorBoton.add(ingresarButton);
		}

}
