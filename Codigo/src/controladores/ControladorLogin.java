package controladores;

import java.util.Calendar;

import javax.swing.JFrame;

import modelos.Agenda;
import modelos.Cliente;
import modelos.Empresa;
import modelos.Instalacion;
import modelos.Tecnico;
import modelos.Turno;
import vistas.AgendarInstalacionDialog;
import vistas.VentanaLogin;

public class ControladorLogin {

	private VentanaLogin ventanaLogin;
	
	
	public void inciarVentanaLogin() {
		this.ventanaLogin =  new VentanaLogin(this);
		ventanaLogin.setVisible(true);
		AgendarInstalacionDialog agendarInstalacion = new AgendarInstalacionDialog();
		agendarInstalacion.setVisible(true);
		
	}
	
	public void login(String usuario, String contrasena, String tipoUsuario) {
		Empresa empresa = Empresa.getInstance();
		if (empresa.esUsuarioValido(usuario, contrasena, tipoUsuario)) {
			ventanaLogin.mostrarMensajeExitoso("Usuario valido !!");
		}
		else {
			ventanaLogin.mostrarMensajeDeError("Usuario invalido");
		}
	}
	
	
	
}
