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
import vistas.VentanaAgendarInstalacion;
import vistas.VentanaLogin;

public class ControladorLogin {

	private VentanaLogin vista;
	private Empresa modelo;
	
	
	public void inciarVentanaLogin() {
		this.vista =  new VentanaLogin(this);
		vista.setVisible(true);
		this.modelo = Empresa.getInstance();
		ControladorAgendarInstalacion controladorInstalacion = new ControladorAgendarInstalacion();
	}
	
	public void login(String usuario, String contrasena, String tipoUsuario) {
		Empresa empresa = Empresa.getInstance();
		if (empresa.esUsuarioValido(usuario, contrasena, tipoUsuario)) {
			vista.mostrarMensajeExitoso("Usuario valido !!");
		}
		else {
			vista.mostrarMensajeDeError("Usuario invalido");
		}
	}
	
	
	
}
