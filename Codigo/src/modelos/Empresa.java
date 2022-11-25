package modelos;

import java.util.ArrayList;
import java.util.Calendar;


public class Empresa {

	//Attributes
	private ArrayList<Instalacion> instalaciones;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	private Inventario inventario;
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	private static Empresa instance;
	private static double precioSeguro = 100;
	private static double precioSoportePared = 50;
	private static double precioTransporte = 20;

	//Methods
	private Empresa() {
		this.instalaciones = new ArrayList<Instalacion>();
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.inventario = new Inventario();
	}
	
	public static double getPrecioTransporte() {
		return precioTransporte;
	}

	public static void setPrecioTransporte(double precioTransporte) {
		Empresa.precioTransporte = precioTransporte;
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
	
	public Empleado buscarEmpleado(int id) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getId() == id) {
				return empleado;
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
		
		if (agendaCliente.estaDisponible(turno) && agendaTecnico.estaDisponible(turno) && this.hayStockDisponibleParaAgendar()){
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
	
	
	public Instalacion agendarInstalacion(Cliente cliente, Tecnico tecnico, Calendar fecha, boolean necesitaSeguro, boolean necesitaSoportePared) {
		if (this.esPosibleAgendarInstalacion(cliente, tecnico, fecha)) {
			Turno turno = new Turno(fecha);
			cliente.getAgenda().agendarTurno(turno);
			tecnico.getAgenda().agendarTurno(turno);
			Instalacion instalacion = new Instalacion(cliente, tecnico, necesitaSeguro, necesitaSoportePared);
			turno.setInstalacion(instalacion);
			this.agregarInstalaciones(instalacion);
			
			//Se quitan los productos necesarios para una instalacion y se imprime como queda el inventario
			this.inventario.quitarProducto(new Condensadora());
			this.inventario.quitarProducto(new Evaporadora());
			this.inventario.quitarProducto(new KitDeInstalacion());
			System.out.println(this.inventario.toString());
			
			return instalacion;
		}
		return null;
	}
	
	public ArrayList<Instalacion> getInstalaciones() {
		return instalaciones;
	}
	
	public Instalacion buscarInstalacion(int id) {
		for (Instalacion instalacion : this.instalaciones) {
			if (instalacion.getId() == id) {
				return instalacion;
			}
		}
		return null;
	}

	public void agregarInstalaciones(Instalacion instalacion) {
		this.instalaciones.add(instalacion);
	}

	public void setStockProducto(Producto producto, int cantidadStock) {
		this.inventario.setStock(producto, cantidadStock);
	}
	
	public void setPrecioProducto(Producto producto, float precio) {
		this.inventario.setPrecioProducto(producto, precio);
	}
	
	public Producto removerUnidadProducto(Producto producto) {
		return this.inventario.quitarProducto(producto);
	}
	
	public Producto obtenerProducto(Producto producto) {
		return this.inventario.buscarProducto(producto);
	}
	
	public void imprimirInventario() {
		System.out.println(this.inventario.toString());
	}
	
	public Empleado esUsuarioValido(String usuario, String contrasena, String tipoEmpleado) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena) 
					&& empleado.getClass().getSimpleName().equals(tipoEmpleado)) {
				return empleado;
			}
		}
		return null;
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
	
	public ArrayList<TecnicoView> getTecnicosView(){
		ArrayList<TecnicoView> tecnicos = new ArrayList<TecnicoView>();
		for (Empleado empleado : this.empleados) {
			if (empleado.getClass().equals(Tecnico.class)){
				TecnicoView tecnicoView = ((Tecnico) empleado).toView();
				tecnicos.add(tecnicoView);
			}
		}
		return tecnicos;
	}
	
	
	
	public static double getPrecioSeguro() {
		return precioSeguro;
	}

	public static void setPrecioSeguro(double precioSeguro) {
		Empresa.precioSeguro = precioSeguro;
	}

	public static double getPrecioSoportePared() {
		return precioSoportePared;
	}

	public static void setPrecioSoportePared(double precioSoportePared) {
		Empresa.precioSoportePared = precioSoportePared;
	}
	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void agregarProducto(Producto producto, int cantidad) {
		this.inventario.setStock(producto, cantidad);
	};
	
	
	public void agregarCalendario() {}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void agregarFacturas(Factura factura) {
		this.facturas.add(factura);
	};
	
	public Inventario getInventario() {
		return this.inventario;
	}
	
	public boolean hayStockDisponibleParaAgendar() {
		if (this.inventario.hayStock(new Evaporadora()) && this.inventario.hayStock(new Condensadora()) && this.inventario.hayStock(new KitDeInstalacion())) {
			return true;
		}
		return false;
	}
	
	public ArrayList<ProductoView> getProductosView(){
		return this.inventario.getProductos();
	}
	
	
	
	
	
	
	
}
