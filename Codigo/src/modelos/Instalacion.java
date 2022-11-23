package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Instalacion {

	//Attributes
	private static int generador = 1000;
	private int id;
	private Estado estado;
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private ArrayList<Producto> elementos = new ArrayList<Producto>();
	private Tecnico tecnico;
	private Cliente cliente;
	private Factura factura;
	private long tiempoTrabajado;
	private boolean necesitaSeguro;
	private boolean necesitaSoportePared;
	private boolean almuerzo;
	
	
	//Methods
	
	//Constructor
	public Instalacion(Cliente cliente, Tecnico tecnico, boolean necesitaSeguro, boolean necesitaSoportePared) {
		this.setCliente(cliente);
		this.setTecnico(tecnico);
		this.setId(generador);
		generador++;
		this.setNecesitaSeguro(necesitaSeguro);
		this.setNecesitaSoportePared(necesitaSoportePared);
		this.setEstado(Estado.PROGRAMADA);
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


	public void agregarElementos(Producto producto) {
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
		this.tiempoTrabajado = ((tiempoTrabajado / 1000) / 60) ;
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

	





	
}