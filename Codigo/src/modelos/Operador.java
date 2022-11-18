package modelos;

import java.util.Calendar;

public class Operador extends Empleado{

	//Attributes
	
	//Methods
	
	//Constructor
	public Operador(String nombre, String direccion, String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		// TODO Auto-generated constructor stub
	};
	
	public void darDeAltaCliente(String nombre, String direccion, int cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		Empresa empresa = Empresa.getInstance();
		empresa.crearCliente(nombre, direccion, cuitCuil, tipoCliente, correoElectronico);
	};
	
	public boolean existeCliente(int cuitCuil) {
		Empresa empresa = Empresa.getInstance();
		return empresa.existeCliente(cuitCuil);
	}
	
	public void agendarInstalacion(Cliente cliente, Tecnico tecnico, Calendar fecha) {
		Empresa empresa = Empresa.getInstance();
		empresa.agendarInstalacion(cliente, tecnico, fecha);
	}
	
	public Cliente buscarCliente(int cuitCuil) {
		Empresa empresa = Empresa.getInstance();
		return empresa.buscarCliente(cuitCuil);
	}
	
	
	
}
