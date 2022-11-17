package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;


public class Agenda{

	//Attributes
	private ArrayList<Dia> dias;
	private Disponibilidad disponibilidad;
	
	//Methods
	
	//Constructor
	public Agenda(Disponibilidad turnoLaboral) {
		this.dias = new ArrayList<Dia>();
		this.disponibilidad = turnoLaboral;
	}
	
	public Agenda() {
		this.dias = new ArrayList<Dia>();
		this.disponibilidad = new TurnoCompleto();
	}
	
	
	public boolean agendarTurno(Turno turno) {
		Dia dia = this.getDia(turno.getHoraInicio());
		if (this.esValido(turno)) {
			if (dia.agregarTurno(turno)) {
				return true;
			};
		}
		return false;
	};
	
	public void setInstalacionAlTurno(Instalacion instalacion, Turno turno) {
		for (Turno ti : this.getTurnosAgendados()) {
			ti.setInstalacion(instalacion);
		}
	}

	public boolean estaDisponible(Turno turno) {
		Calendar fechaDelTurno = turno.getHoraInicio();
		if (this.esValido(turno)) {
			if (this.existeDia(fechaDelTurno)) {
				Dia dia = this.buscarDia(fechaDelTurno);
				return dia.estaDisponible(turno);
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean esValido(Turno turno) {
		if(this.disponibilidad.esDiaLaboral(turno.getHoraInicio()) && this.disponibilidad.esHorarioLaboral(turno) 
				&& this.tieneFechaPosteriorAHoy(turno)) {
			return true;
		}
		return false;
	}
	
	private boolean tieneFechaPosteriorAHoy(Turno turno) {
		Calendar fechaHoy = new GregorianCalendar();
		if (turno.getHoraInicio().before(fechaHoy)) {
			return false;
		}
		return true;
	}
	
	
	
	
	public void imprimirTurnosPorFecha(Calendar fecha) {
		Dia diaBuscado = this.buscarDia(fecha);
		if (diaBuscado != null) {
			diaBuscado.imprimirTurnos();
		}
		else {
			System.out.println("No hay ningun turno para ese dia");
		}
	}
	
	public ArrayList<Turno> getTurnosAgendados(){
		ArrayList<Turno> turnosAgendados = new ArrayList<Turno>();
		for (Dia dia : this.dias) {
			turnosAgendados.addAll(dia.getTurnos());
		}
		return turnosAgendados;
	}
	
	/**
	 * Verifica si @dia existe en el calendario. Si existe: lo devuelve. Si no existe: lo crea y lo devuelve
	*/
	private Dia getDia(Calendar dia) {
		for (Dia di : this.dias) {
			if (di.soyLaFecha(dia)) {
				return di;
			}
		}
		Dia nuevoDia = new Dia(dia);
		this.dias.add(nuevoDia);
		this.ordenarDias();
		return nuevoDia;
	}
	
	private Dia buscarDia(Calendar fecha) {
		for (Dia dia : this.dias) {
			if (dia.soyLaFecha(fecha)) {
				return dia;
			}
		}
		return null;
	}
	
	private boolean existeDia(Calendar dia) {
		for (Dia di : this.dias) {
			if (di.soyLaFecha(dia)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void imprimirTurnos() {
		for (Dia dia : this.dias) {
			dia.imprimirTurnos();
		}
	}
	
	public void ordenarDias() {
		Collections.sort(this.dias, new ordenarPorDia());
	}
	
	public ArrayList<Dia> getDias(){
		return this.dias;
	}
	
	
	static class ordenarPorDia implements Comparator<Dia>{

		@Override
		public int compare(Dia dia1, Dia dia2) {
			// TODO Auto-generated method stub
			return dia1.getFecha().compareTo(dia2.getFecha());
		}
		
	}

	
	
	
	
}
