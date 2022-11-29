package modelos;

import java.time.LocalTime;
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
	
	public ClienteView buscarClienteToView(long cuitCuil) {
		for (Cliente cliente : this.clientes) {
			if (cliente.tengoElCuitCuil(cuitCuil)) {
				return cliente.toView();
			}
		}
		return null;
	}
	
	private Cliente buscarCliente(long cuitCuil) {
		for (Cliente cliente : this.clientes) {
			if(cliente.tengoElCuitCuil(cuitCuil)) {
				return cliente;
			}
		}
		return null;
	}
	

	public ArrayList<Instalacion> instalacionesAsignadasATecnico(int idTecnico) {
		ArrayList<Instalacion> resultado = new ArrayList<>();
		for (Instalacion i : this.instalaciones) {
			if (i.getTecnico().getId() == idTecnico) {
				resultado.add(i);
			}
		}
		return resultado;
	}

	
	public Empleado buscarEmpleado(int id) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getId() == id) {
				return empleado;
			}
		}
		return null;
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
	
	
	public boolean agendarInstalacion(long idCliente, int idTecnico, Calendar fecha, boolean necesitaSeguro, boolean necesitaSoportePared) {
		Cliente cliente = this.buscarCliente(idCliente);
		Tecnico tecnico = (Tecnico) this.buscarEmpleado(idTecnico);
		
		if (this.esPosibleAgendarInstalacion(cliente, tecnico, fecha)) {
			if (this.hayStockDisponibleParaAgendar()) {
				Turno turno = new Turno(fecha);
				cliente.getAgenda().agendarTurno(turno);
				tecnico.getAgenda().agendarTurno(turno);
				Instalacion instalacion = new Instalacion(cliente, tecnico, necesitaSeguro, necesitaSoportePared);
				turno.setInstalacion(instalacion);
				this.instalaciones.add(instalacion);
				instalacion.setHoraInicio(turno.getHoraInicio());
				instalacion.setHoraFinalizacion(turno.getHoraFinalizacion());
				instalacion.agregarElemento(this.inventario.quitarProducto(new Condensadora()));
				instalacion.agregarElemento(this.inventario.quitarProducto(new Evaporadora()));
				instalacion.agregarElemento(this.inventario.quitarProducto(new KitDeInstalacion()));
				
				return true;
			}
		}
		return false;
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
	
	public boolean existeInstalacion(int id) {
		for (Instalacion instalacion : this.instalaciones) {
			if (instalacion.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void agregarInstalaciones(Instalacion instalacion) {
		this.instalaciones.add(instalacion);
	}

	public boolean setStockProducto(String nombreProducto, int cantidadStock) {
		Producto producto = this.crearProducto(nombreProducto);
		if (producto != null) {
			this.inventario.setStock(producto, cantidadStock);
			return true;
		}
		return false;
	}
	
	public boolean setPrecioProducto(String nombreProducto, float precio) {
		Producto producto = this.crearProducto(nombreProducto);
		if (producto != null) {
			producto.setPrecio(precio);
			return true;
		}
		return false;
	}
	
	public ArrayList<ClienteView> buscarNombreClienteLike(String nombreApellido) {
		ArrayList<ClienteView> clientesView = new ArrayList<ClienteView>();
		System.out.println(nombreApellido);
		for (Cliente cliente : this.clientes) {
			if (cliente.getNombre().toLowerCase().contains(nombreApellido)) {
				clientesView.add(cliente.toView());
			}
		}
		return clientesView;
	}
	
	
	
	public Producto removerUnidadProducto(Producto producto) {
		return this.inventario.quitarProducto(producto);
	}
	
	
	
	
	
	public void imprimirInventario() {
		System.out.println(this.inventario.toString());
	}
	
	
	
	/*
	 * Valida el usuario, contrasena y tipo de empleado. Si existe devuelve el id, caso contrario devuelve -1
	 */
	
	public int esUsuarioValido(String usuario, String contrasena, String tipoEmpleado) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena) 
					&& empleado.getClass().getSimpleName().equals(tipoEmpleado)) {
				return empleado.getId();
			}
		}
		return -1;
	}
	
	
	public ArrayList<InstalacionView> getInstalacionesAsignadas(int idTecnico) {
		ArrayList<InstalacionView> instalacionesAsignadas = new ArrayList<InstalacionView>();
		for (Instalacion instalacion : this.instalaciones) {
			if (instalacion.getTecnico().getId() == idTecnico) {
				instalacionesAsignadas.add(instalacion.toView());
			}
		}
		return instalacionesAsignadas;
	}
	
	public ArrayList<FacturaView> getFacturasView(){
		ArrayList<FacturaView> facturasView = new ArrayList<FacturaView>();
		for (Factura factura : this.facturas) {
			facturasView.add(factura.toView());
		}
		return facturasView;
	}
	
	public FacturaView getFacturaView(int nroFactura) {
		for (Factura factura : this.facturas) {
			if(factura.getNumero() == nroFactura) {
				return factura.toView();
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	public boolean completarInstalacion(int id, LocalTime horaInicio, LocalTime horaFinalizacion, boolean almuerzo, 
			int evaporadorasAdicionales, int kitsAdicionales, int condensadorasAdicionales, float otrosGastos) {
		boolean sePudoCompletar = true;
		Instalacion instalacion = this.buscarInstalacion(id);	
		if (instalacion != null) {
			ArrayList<Producto> elementosUtilizados = new ArrayList<Producto>();
			
			if (this.inventario.hayStockSuficiente(new Evaporadora(), evaporadorasAdicionales) && 
					this.inventario.hayStockSuficiente(new Condensadora(), condensadorasAdicionales)
					&& this.inventario.hayStockSuficiente(new KitDeInstalacion(), kitsAdicionales)) {
				elementosUtilizados.addAll(this.inventario.quitarProductos(new Evaporadora(), evaporadorasAdicionales));
				elementosUtilizados.addAll(this.inventario.quitarProductos(new Condensadora(), condensadorasAdicionales));
				elementosUtilizados.addAll(this.inventario.quitarProductos(new KitDeInstalacion(), kitsAdicionales));
			}
			else {
				System.out.println("Ocurrio un error, elementos utilizados > stock en inventario");
			}
			
			Factura factura = instalacion.finalizar(horaInicio, horaFinalizacion, elementosUtilizados, otrosGastos, almuerzo);
			this.facturas.add(factura);
			System.out.println(factura.toString());
		}
		else {
			sePudoCompletar = false;
		}
		return sePudoCompletar;
	}
	
	
	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	};
	
	/*
	public ArrayList<Cliente> getClientes(){
		return this.clientes;
	}
	*/
	
	public ArrayList<ClienteView> getClientesView(){
		ArrayList<ClienteView> clientesView = new ArrayList<ClienteView>();
		for (Cliente cliente : this.clientes) {
			clientesView.add(cliente.toView());
		}
		return clientesView;
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
	
	public ClienteView getClienteView(long idCliente) {
		return this.buscarCliente(idCliente).toView();
	}
	
	public String formatearFecha(Calendar fecha) {
		return Agenda.formatearFecha(fecha);
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
	
	public boolean agregarProducto(String nombreProducto, int cantidad) {
		Producto producto = this.crearProducto(nombreProducto);
		if (producto != null) {
			this.inventario.setStock(producto, cantidad);
			return true;
		}
		return false;
	};
	
	
	public void agregarCalendario() {}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	};
	
	
	
	
	
	public Inventario getInventario() {
		return this.inventario;
	}
	
	public EmpleadoView getEmpleadoView(int id) {
		Empleado empleado = this.buscarEmpleado(id);
		if (empleado != null) {
			return empleado.ToView();
		}
		return null;
	}
	
	public ArrayList<EmpleadoView> getTecnicosDisponibles(Calendar fecha) {
		ArrayList<EmpleadoView> tecnicosDisponibles = new ArrayList<EmpleadoView>();
		for (Tecnico tecnico : this.getTecnicos()) {
			if (tecnico.getAgenda().estaDisponible(new Turno(fecha))) {
				tecnicosDisponibles.add(tecnico.ToView());
			}
		}
		return tecnicosDisponibles;
	}
	
	
	private ArrayList<Tecnico> getTecnicos(){
		ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
		for (Empleado empleado : this.empleados) {
			if (empleado.getClass().equals(Tecnico.class)) {
				tecnicos.add((Tecnico) empleado);
			}
		}
		return tecnicos;
	}
	
	
	public InstalacionView getInstalacionView(int id) {
		for(Instalacion instalacion : this.instalaciones) {
			if (instalacion.getId() == id) {
				return instalacion.toView();
			}
		}
		return null;
	}
	

	public boolean estaDisponibleCliente(Calendar fecha, long cuitCuil) {
		Cliente cliente = this.buscarCliente(cuitCuil);
		Turno turno = new Turno(fecha);
		if (cliente.getAgenda().estaDisponible(turno)) {
			return true;
		}
		return false;
	}
	
	
	public boolean hayStockDisponibleParaAgendar() {
		if (this.inventario.hayStock(new Evaporadora()) && this.inventario.hayStock(new Condensadora()) && this.inventario.hayStock(new KitDeInstalacion())) {
			return true;
		}
		return false;
	}
	
	public ArrayList<ProductoInventarioView> getProductosView(){
		return this.inventario.getProductos();
	}
	
	public TecnicoView getTecnicoView(int id) {
		for (Empleado empleado : this.empleados) {
			if (empleado.getClass().equals(Tecnico.class) && empleado.getId() == id) {
				Tecnico tecnico = (Tecnico) empleado;
				return tecnico.toView();
			}
		}
		return null;
	}
	
	public ProductoInventarioView getProductoView(int idProducto) {
		return this.inventario.getProductoView(idProducto);
	}
	
	
	public void actualizarDatosProducto(String nombreProducto, float precio, int stock) {
		Producto producto = this.crearProducto(nombreProducto);
		this.inventario.setStock(producto, stock);
		this.inventario.setPrecioProducto(producto, precio);
	}
	
	
	
	/*
	
	*/
	/*
	public void imprimirTecnicos() {
		for (Tecnico tecnico : this.getTecnicos()) {
			System.out.println(tecnico.toString());
		}
	}
	*/
	
	public Producto crearProducto(String nombreProducto) {
		switch (nombreProducto) {
			case "Condensadora":
				return new Condensadora();
			case "Evaporadora":
				return new Evaporadora();
			case "KitDeInstalacion":
				return new KitDeInstalacion();
			default:
				System.out.println("ERROR");
				return null;
		}
	}
	
	public Disponibilidad crearTurnoLaboral(String turno) {
		switch (turno) {
			case "TurnoManana":
				return new TurnoManana();
			case "TurnoTarde":
				return new TurnoTarde();
			case "TurnoCompleto":
				return new TurnoCompleto();
			default:
				System.out.println("ERROR");
				return null;
		}
	}
	
	public ExperienciaLaboral crearExpLaboral(String expLaboral) {
		switch (expLaboral) {
		case "Junior":
			return new Junior();
		case "SemiSenior":
			return new SemiSenior();
		case "Senior":
			return new Senior();
		default:
			System.out.println("ERROR");
			return null;
		}
	}
	
	public TecnicoView crearTecnico(String nombre, String direccion, String turnoLaboral, String usuario, String contrasena, String experiencia) {
		Tecnico tecnico = new Tecnico(nombre,direccion, this.crearTurnoLaboral(turnoLaboral),usuario,contrasena, this.crearExpLaboral(experiencia));
		this.empleados.add(tecnico);
		return tecnico.toView();
	}
	
	public void modificarTecnico(int id, String nombre, String direccion, String turnoLaboral, String usuario, String contrasena, String expLaboral) {
		Tecnico tecnico = (Tecnico) this.buscarEmpleado(id);
		tecnico.setNombre(nombre);
		tecnico.setDireccion(direccion);
		tecnico.setTurnoLaboral(this.crearTurnoLaboral(turnoLaboral));
		tecnico.setExperienciaLaboral(this.crearExpLaboral(expLaboral));
		tecnico.setUsuario(usuario);
		tecnico.setContrasena(contrasena);
	}
	
	public boolean eliminarEmpleado(int id) {
		for (int i = 0; i < this.empleados.size(); i++) {
			if (empleados.get(i).getId() ==  id) {
				this.empleados.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
}
