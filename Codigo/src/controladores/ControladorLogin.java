package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import modelos.Empresa;
import modelos.Operador;
import modelos.Tecnico;
import vistas.VentanaLogin;

public class ControladorLogin implements ActionListener{

	private VentanaLogin vista;
	private Empresa modelo;
	
	
	public void inciarVentanaLogin() {
		this.vista =  new VentanaLogin(this);
		this.vista.setVisible(true);
		this.modelo = Empresa.getInstance();
		this.setTiposDeUsuario();
		this.vista.setActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch(comandoAccionado) {
			case "INGRESAR":
				this.login();
				break;
		}
		
	}
	
	public void login() {
		
		String usuario =  this.vista.getUsuario();
		String contrasena = this.vista.getContrasena();
		String tipoDeUsuario = this.vista.getTipoDeUsuario();
		
		if (usuario != "" && contrasena != "" && tipoDeUsuario != "Seleccione") {
			int idUsuario = this.modelo.esUsuarioValido(usuario, contrasena, tipoDeUsuario);
			if (idUsuario != -1) {
				ControladorVentanaUsuario controladorVentanaUsuario = new ControladorVentanaUsuario(idUsuario);
				controladorVentanaUsuario.iniciarVista();
			}
			else {
				this.vista.mostrarMensajeDeError("Usuario invalido");
			}
		}
		else {
			this.vista.mostrarMensajeDeError("Por favor complete todos los campos");
		}
	}
	
	public void setTiposDeUsuario() {
		DefaultComboBoxModel<String> tiposDeUsuario = new DefaultComboBoxModel<String>();
		tiposDeUsuario.addElement("Seleccione");
		tiposDeUsuario.addAll(this.modelo.getTiposDeUsuario());
		tiposDeUsuario.setSelectedItem("Seleccione");
		this.vista.setComboTiposDeUsuario(tiposDeUsuario);
	}
	

}
