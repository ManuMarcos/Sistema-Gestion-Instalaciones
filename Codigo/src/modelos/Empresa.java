package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
	
	public boolean crearCliente(String nombre, String direccion, long cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		if (!existeCliente(cuitCuil)) {
			Cliente nuevoCliente = new Cliente(nombre, direccion, cuitCuil, tipoCliente, correoElectronico);
			this.clientes.add(nuevoCliente);
			return true;
		}
		return false;
	}
	
	public boolean existeCliente(long cuitCuil) {
		for (Cliente cliente : this.clientes) {
			if (cliente.tengoElCuitCuil(cuitCuil)) {
				return true;
			}
		}
		return false;
	}
	
	public Cliente buscarCliente(long cuitCuil) {
		for (Cliente cliente : this.clientes) {
			if (cliente.tengoElCuitCuil(cuitCuil)) {
				return cliente;
			}
		}
		return null;
	}
	
	
	public ArrayList<Tecnico> obtenerTecnicosDisponibles(Calendar fecha) {
		ArrayList<Tecnico> tecnicosDisponibles = new ArrayList<Tecnico>();
		for (Empleado empleado : this.empleados) {
			if (empleado.getClass().getSimpleName().equals("Tecnico")) {
				Tecnico tecnico = (Tecnico) empleado;
				if (tecnico.getAgenda().estaDisponible(new Turno(fecha))) {
					tecnicosDisponibles.add(tecnico);
				}
			}
		}
		return tecnicosDisponibles;
	}
	
	
	
	
	public boolean esPosibleAgendarInstalacion(Cliente cliente, Tecnico tecnico, Calendar fecha) {
		Agenda agendaCliente = cliente.getAgenda();
		Agenda agendaTecnico = tecnico.getAgenda();
		Turno turno = new Turno(fecha);
		
		if (agendaCliente.estaDisponible(turno) && agendaTecnico.estaDisponible(turno)){
			agendaCliente.agendarTurno(turno);
			agendaTecnico.agendarTurno(turno);
			/*
			Instalacion instalacion = new Instalacion(cliente, tecnico);
			turno.setInstalacion(instalacion);
			this.instalaciones.add(instalacion);
			System.out.println("Se agendo con exito la instalacion para la fecha " + fecha.getTime());
			*/
			return true;
		}
		System.out.println("No se agendo la instalacion para la fecha " + fecha.getTime());
		
		return false;
	}
	
	
	public boolean agendarInstalacion(Cliente cliente, Tecnico tecnico, Calendar fecha) {
		if (this.esPosibleAgendarInstalacion(cliente, tecnico, fecha)) {
			Turno turno = new Turno(fecha);
			cliente.getAgenda().agendarTurno(turno);
			tecnico.getAgenda().agendarTurno(turno);
			Instalacion instalacion = new Instalacion(cliente, tecnico);
			turno.setInstalacion(instalacion);
			return true;
		}
		return false;
	}
	
	
	
	
	
	public void setStockProducto(Producto producto, int cantidadStock) {
		this.inventario.setStock(producto, cantidadStock);
	}
	
	public void setPrecioProducto(Producto producto, float precio) {
		this.inventario.setPrecioProducto(producto, precio);
	}
	
	public Producto obtenerProducto(Producto producto) {
		return this.inventario.quitarProducto(producto);
	}
	
	public void imprimirInventario() {
		System.out.println(this.inventario.toString());
	}
	
	public boolean esUsuarioValido(String usuario, String contrasena, String tipoEmpleado) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena) 
					&& empleado.getClass().getSimpleName().equals(tipoEmpleado)) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	};
	
	public ArrayList<Cliente> getClientes(){
		return this.clientes;
	}
	
	public ArrayList<String> getNombresClientes(){
		ArrayList<String> nombreClientes = new ArrayList<String>();
		for (Cliente cliente : this.clientes) {
			nombreClientes.add(cliente.getNombre());
		}
		return nombreClientes;
	}
	
	public ArrayList<String> getNombresTecnicos(ArrayList<Tecnico> tecnicos) {
		ArrayList<String> nombres = new ArrayList<String>();
		for (int i = 0; i < tecnicos.size(); i++) {
			nombres.add(tecnicos.get(i).getNombre());
		}
		return nombres;
	}
	
	
	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	
	
	
	
	public void agregarProducto() {};
	
	
	public void agregarCalendario() {};
	
	
	
	
	
	
}
