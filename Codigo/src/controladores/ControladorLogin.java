package controladores;

import modelos.Empleado;
import modelos.Empresa;

import vistas.VentanaLogin;

public class ControladorLogin {

	private VentanaLogin vista;
	private Empresa modelo;
	
	
	public void inciarVentanaLogin() {
		this.vista =  new VentanaLogin(this);
		this.vista.setVisible(true);
		this.modelo = Empresa.getInstance();
	}
	
	public void login(String usuario, String contrasena, String tipoUsuario) {
		int idUsuario = this.modelo.esUsuarioValido(usuario, contrasena, tipoUsuario);
		if (idUsuario != -1) {
			ControladorVentanaUsuario controladorVentanaUsuario = new ControladorVentanaUsuario(idUsuario);
		}
		else {
			vista.mostrarMensajeDeError("Usuario invalido");
		}
	}
	
	
	
}
