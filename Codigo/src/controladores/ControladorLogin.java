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
		Empleado empleado = this.modelo.esUsuarioValido(usuario, contrasena, tipoUsuario);
		if (empleado != null) {
			vista.mostrarMensajeExitoso("Usuario valido !!");
			ControladorVentanaUsuario controladorVentanaUsuario = new ControladorVentanaUsuario(empleado);
		}
		else {
			vista.mostrarMensajeDeError("Usuario invalido");
		}
	}
	
	
	
}
