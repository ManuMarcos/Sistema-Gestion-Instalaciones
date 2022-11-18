package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class VentanaLogin extends JFrame {

		private JPanel contentPane;
		private JTextField usuarioTextField;
		private JPasswordField contrasenaPasswordField;

		/**
		 * Create the frame.
		 */
		public VentanaLogin() {
			setTitle("Sistema de Gestion de Instalaciones");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 912, 610);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panelIzquierdo = new JPanel();
			panelIzquierdo.setBackground(new Color(173, 216, 230));
			contentPane.add(panelIzquierdo);
			panelIzquierdo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel etiquetaNombreSistema = new JLabel("SGI");
			etiquetaNombreSistema.setHorizontalAlignment(SwingConstants.CENTER);
			etiquetaNombreSistema.setFont(new Font("Times New Roman", Font.BOLD, 37));
			panelIzquierdo.add(etiquetaNombreSistema);
			
			JPanel panelDerecho = new JPanel();
			panelDerecho.setBackground(new Color(245, 255, 250));
			contentPane.add(panelDerecho);
			panelDerecho.setLayout(new BorderLayout(0, 0));
			
			JPanel panelTitulo = new JPanel();
			panelDerecho.add(panelTitulo, BorderLayout.NORTH);
			
			JLabel etiquetaLogin = new JLabel("Login");
			etiquetaLogin.setFont(new Font("Times New Roman", Font.ITALIC, 25));
			panelTitulo.add(etiquetaLogin);
			
			JPanel panelDatos = new JPanel();
			panelDerecho.add(panelDatos, BorderLayout.CENTER);
			panelDatos.setLayout(new GridLayout(3, 2, 0, 0));
			
			JLabel etiquetaUsuario = new JLabel("Usuario");
			etiquetaUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			panelDatos.add(etiquetaUsuario);
			
			usuarioTextField = new JTextField();
			usuarioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			panelDatos.add(usuarioTextField);
			usuarioTextField.setColumns(20);
			
			JLabel etiquetaContrasena = new JLabel("Contraseña");
			etiquetaContrasena.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			panelDatos.add(etiquetaContrasena);
			
			contrasenaPasswordField = new JPasswordField();
			panelDatos.add(contrasenaPasswordField);
			
			JLabel etiquetaRol = new JLabel("Rol");
			etiquetaRol.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			panelDatos.add(etiquetaRol);
			
			JComboBox rolesComboBox = new JComboBox();
			rolesComboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrativo", "Administrador", "Operador de Call Center", "Tecnico", ""}));
			panelDatos.add(rolesComboBox);
			
			JPanel panelBotones = new JPanel();
			panelDerecho.add(panelBotones, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("Ingresar");
			panelBotones.add(btnNewButton);
		}

}
