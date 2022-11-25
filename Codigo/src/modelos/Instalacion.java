package modelos;

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
	private long tiempoTrabajado;
	private boolean necesitaSeguro;
	private boolean necesitaSoportePared;
	private boolean almuerzo;

	// Methods

	// Constructor
	public Instalacion(Cliente cliente, Tecnico tecnico, boolean necesitaSeguro, boolean necesitaSoportePared) {
		this.setCliente(cliente);
		this.setTecnico(tecnico);
		this.setId(generador);
		generador++;
		this.setNecesitaSeguro(necesitaSeguro);
		this.setNecesitaSoportePared(necesitaSoportePared);
		this.setEstado(Estado.PROGRAMADA);
		this.elementos = new ArrayList<Producto>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Calendar getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Calendar getHoraFinalizacion() {
		return horaFinalizacion;
	}

	public void setHoraFinalizacion(Calendar horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
		this.setTiempoTrabajado(this.getHoraFinalizacion().getTimeInMillis() - this.getHoraInicio().getTimeInMillis());
	}

	public ArrayList<Producto> getElementos() {
		return elementos;
	}

	public void agregarElementosUtilizados(ArrayList<Producto> productosUtilizados) {
		this.elementos.addAll(productosUtilizados);
	}

	public int getCantidadDeElementos(String nombreProducto) {
		int contador = 0;
		
		for (int i = 0; i < this.getElementos().size(); i++) {
			if (nombreProducto == "Evaporadora") {
				if (this.getElementos().get(i).getClass() == new Evaporadora().getClass()) {
					System.out.println("TENGO EVAPORADORA");
					contador++;
				}
			}
			if (nombreProducto == "Condensadora") {
				if (this.getElementos().get(i).getClass() == new Condensadora().getClass()) {
					System.out.println("TENGO CONDENSADORA");
					contador++;
				}
			}
			if (nombreProducto == "Kit De Instalacion") {
				if (this.getElementos().get(i).getClass() == new KitDeInstalacion().getClass()) {
					System.out.println("TENGO KIT");
					contador++;
				}
			}
		}
		
		return contador;
	}

	public void agregarElemento(Producto producto) {
		this.elementos.add(producto);
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

	public long getTiempoTrabajado() {
		return tiempoTrabajado;
	}

	public void setTiempoTrabajado(long tiempoTrabajado) {
		this.tiempoTrabajado = ((tiempoTrabajado / 1000) / 60);
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
		HashMap<String, Integer> elementosUtilizados = new HashMap<String, Integer>();
		for (Producto producto : this.elementos) {
			elementosUtilizados.merge(producto.getClass().getSimpleName(), 1, Integer::sum);
		}
		return new InstalacionView(this.id, this.cliente.toView(), this.tecnico.toView(), this.estado.toString(), elementosUtilizados);
	}
	

}