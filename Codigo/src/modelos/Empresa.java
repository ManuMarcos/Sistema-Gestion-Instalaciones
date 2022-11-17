package modelos;

import java.util.ArrayList;
import java.util.Calendar;

public class Empresa {

	//Attributes
	private ArrayList<Instalacion> instalaciones;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	private Inventario inventario;
	private static Empresa instance;
	
	
	//Methods
	private Empresa() {
		this.instalaciones = new ArrayList<Instalacion>();
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.inventario = new Inventario();
	}
	
	public static Empresa getInstance() {
		if (instance == null) {
			instance = new Empresa();
		}
		return instance;
	}
	
	public boolean crearCliente(String nombre, String direccion, int cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		if (!existeCliente(cuitCuil)) {
			Cliente nuevoCliente = new Cliente(nombre, direccion, cuitCuil, tipoCliente, correoElectronico);
			this.clientes.add(nuevoCliente);
			return true;
		}
		return false;
	}
	
	public boolean existeCliente(int cuitCuil) {
		for (Cliente cliente : this.clientes) {
			if (cliente.tengoElCuitCuil(cuitCuil)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	public void agregarProducto() {};
	public void agregarCliente() {};
	public void agregarEmpleado() {};
	public void agregarCalendario() {};
	
	
	
	
	
	
}
