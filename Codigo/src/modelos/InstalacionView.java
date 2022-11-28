package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class InstalacionView {

	private int id;
	private ClienteView clienteView;
	private TecnicoView tecnicoView;
	private String estado;
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private HashMap<String, Integer> elementosUtilizados;
	
	public InstalacionView(int id, ClienteView clienteView, TecnicoView tecnicoView, String estado, HashMap<String, Integer> elementosUtilizados,
			Calendar horaInicio, Calendar horaFinalizacion) {
		this.id = id;
		this.clienteView = clienteView;
		this.tecnicoView = tecnicoView;
		this.estado = estado;
		this.elementosUtilizados = elementosUtilizados;
		this.horaInicio = horaInicio;
		this.horaFinalizacion = horaFinalizacion;
	}

	public int getId() {
		return id;
	}

	public ClienteView getClienteView() {
		return clienteView;
	}

	public TecnicoView getTecnicoView() {
		return tecnicoView;
	}

	public String getEstado() {
		return estado;
	}

	public HashMap<String, Integer> getElementosUtilizados() {
		return elementosUtilizados;
	}

	public Calendar getHoraInicio() {
		return horaInicio;
	}

	public Calendar getHoraFinalizacion() {
		return horaFinalizacion;
	}
	
}
