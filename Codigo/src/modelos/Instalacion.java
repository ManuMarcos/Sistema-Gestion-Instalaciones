package modelos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Instalacion {

	// Attributes
	private static int generador = 1000;
	private int id;
	private Estado estado;
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private ArrayList<Producto> elementos;
	private Tecnico tecnico;
	private Cliente cliente;
	private Factura factura;
	private static float costoViaje;
	private float otrosGastos;
	private int minsTrabajados;
	private boolean necesitaSeguro;
	private boolean necesitaSoportePared;
	private boolean almuerzo;

	// Methods

	// Constructor
	public Instalacion(Cliente cliente, Tecnico tecnico, boolean necesitaSeguro, boolean necesitaSoportePared) {
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.id = generador;
		generador++;
		this.necesitaSeguro = necesitaSeguro;
		this.necesitaSoportePared = necesitaSoportePared;
		this.estado = Estado.PROGRAMADA;
		this.elementos = new ArrayList<Producto>();
	}

	public int getId() {
		return id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		if (estado.equals(Estado.FINALIZADA)) {
			this.facturar();
		}
	}

	public static void setCostoViaje(float costo){
		costoViaje = costo;
	}
	
	public Calendar getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	private void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio.set(this.horaInicio.get(Calendar.YEAR), this.horaInicio.get(Calendar.MONTH), this.horaInicio.get(Calendar.DAY_OF_MONTH), 
				horaInicio.getHour(), horaInicio.getMinute(), 0);
	}
	
	private void setHoraFinalizacion(LocalTime horaFinalizacion) {
		this.horaFinalizacion.set(this.horaFinalizacion.get(Calendar.YEAR), this.horaFinalizacion.get(Calendar.MONTH), this.horaFinalizacion.get(Calendar.DAY_OF_MONTH), 
				horaFinalizacion.getHour(), horaFinalizacion.getMinute(), 0);
		this.setMinsTrabajados(this.horaFinalizacion.getTimeInMillis() - this.horaInicio.getTimeInMillis());
	}
	
	private float calcularPrecioElementos() {
		float precioElementos = 0;
		for (Producto producto : this.elementos) {
			precioElementos += producto.getPrecio();
		}
		return precioElementos;
	}
	
	public float getPrecioProvisorio() {
		return this.calcularPrecioElementos() + costoViaje;
	}
	
	public Factura  finalizar(LocalTime horaInicio, LocalTime horaFinalizacion, ArrayList<Producto> materialesAdicionales, 
			float otrosGastos, boolean almuerzo) {
		this.setHoraInicio(horaInicio);
		this.setHoraFinalizacion(horaFinalizacion);
		this.elementos.addAll(materialesAdicionales);
		this.otrosGastos = otrosGastos;
		this.almuerzo = almuerzo;
		if (almuerzo == true) {
			this.minsTrabajados -= 30;
		}
		this.estado = Estado.FINALIZADA;
		return this.facturar();
	}
	
	public Calendar getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public void setHoraFinalizacion(Calendar horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}

	public ArrayList<Producto> getElementos() {
		return elementos;
	}
	
	public int getCantElementos(Producto producto) {
		int cantidad = 0;
		for (Producto elemento : this.elementos) {
			if (elemento.getClass().isInstance(producto)) {
				cantidad ++;
			}
		}
		return cantidad;
	}
	
	
	private ArrayList<Producto> getTipoElementosUtilizados(){
		ArrayList<Producto> tiposElementosUtilizados = new ArrayList<Producto>();
		
		for (Producto elemento : this.elementos) {
			boolean tipoAgregado = false;
			for (Producto tipoElemento : tiposElementosUtilizados) {
				if (elemento.getClass().equals(tipoElemento.getClass())) {
					tipoAgregado = true;
				}
			}
			if (tipoAgregado == false) {
				tiposElementosUtilizados.add(elemento);
			}
		}
		return tiposElementosUtilizados;
	}
	
	
	private Factura facturar() {
		this.factura = new Factura();
		
		ArrayList<Producto> tiposElementosUtilizados = this.getTipoElementosUtilizados();
		System.out.println(tiposElementosUtilizados.size());
		for (Producto elemento : tiposElementosUtilizados) {
			factura.agregarRenglon(elemento.toString(), this.getCantElementos(elemento), elemento.getPrecio());
		}
		
		float horasTrabajadas = (float) this.minsTrabajados / 60;
		factura.agregarRenglon("Mano de Obra - " + this.tecnico.getExperienciaLaboral().toString() + " * " + horasTrabajadas + " Horas", 
				1, this.tecnico.getExperienciaLaboral().costearHorasTrabajadas(horasTrabajadas));
		
		factura.agregarRenglon("Costo de Viaje", 1, costoViaje);
		if (this.otrosGastos != 0) {
			factura.agregarRenglon("Otros gastos", 1, this.otrosGastos);
		}
		return this.factura;
	}

	public void agregarElemento(Producto producto) {
		this.elementos.add(producto);
		System.out.println(producto.toString());
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getMinsTrabajados() {
		return this.minsTrabajados;
	}

	private void setMinsTrabajados(long tiempoTrabajado) {
		this.minsTrabajados = (int) ((tiempoTrabajado / 1000) / 60);
	}

	public boolean getNecesitaSeguro() {
		return necesitaSeguro;
	}

	public void setNecesitaSeguro(boolean necesitaSeguro) {
		this.necesitaSeguro = necesitaSeguro;
	}

	public boolean getNecesitaSoportePared() {
		return necesitaSoportePared;
	}

	public void setNecesitaSoportePared(boolean necesitaSoportePared) {
		this.necesitaSoportePared = necesitaSoportePared;
	}

	public boolean almorzoElTecninco() {
		return almuerzo;
	}
	
	public void setAlmuerzo(boolean almuerzo) {
		this.almuerzo = almuerzo;
	}

	
	public InstalacionView toView() {
		HashMap<String, Integer> tiposElementosUtilizados = new HashMap<String, Integer>();
		
		for (Producto producto : this.getTipoElementosUtilizados()) {
			tiposElementosUtilizados.put(producto.getClass().getSimpleName(), this.getCantElementos(producto));
		}
		return new InstalacionView(this.id, this.cliente.toView(), this.tecnico.toView(), this.estado.toString(), tiposElementosUtilizados, this.horaInicio, this.horaFinalizacion);
	}
	

}