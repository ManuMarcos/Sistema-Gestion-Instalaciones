package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Instalacion {

	//Attributes
	private static int generador;
	private int id;
	private Estado estado;
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private ArrayList<Producto> elementos;
	private Tecnico tecnico;
	private Cliente cliente;
	private Factura factura;
	private Calendar tiempoTrabajado;
	private boolean necesitaSeguro;
	private boolean necesitaSoportePared;
	private boolean almuerzo;
	private float costoDeViaje;
	
	
	//Methods
	
	//Constructor
	public Instalacion(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
