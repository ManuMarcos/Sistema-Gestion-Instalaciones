package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLogin extends JPanel{

	//Attributes
	private JLabel etiquetaUsuario;
	private JLabel etiquetaContrasena;
	private JTextField usuario;
	private JTextField contrasena;
	private JButton botonIngresar;
	private JComboBox comboBoxRoles;
	
	
	public PanelLogin() {
		this.agregarBotones();
		this.agregarEtiquetas();
		this.agregarTextField();

	}
	
	public void agregarBotones() {
		this.botonIngresar = new JButton("Ingresar");
		this.add(botonIngresar);
	}
	
	public void agregarEtiquetas() {
		this.etiquetaUsuario = new JLabel("Usuario");
		this.etiquetaContrasena = new JLabel("Contraseña");
		this.add(etiquetaUsuario);
		this.add(etiquetaContrasena);
	}
	
	public void agregarTextField() {
		this.usuario = new JTextField(20);
		this.contrasena = new JTextField(20);
		this.add(usuario);
		this.add(contrasena);		
	}
	
	
	


	
	
	
	
	
}
