package modelos;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Turno {

	//Attributes
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private Instalacion instalacion;

	
	//Methods
	
	//Constructor
	public Turno(Calendar horaInicio, Instalacion instalacion) {
		this.horaInicio =  horaInicio;
		this.asignarHoraFinalizacion(horaInicio);
	}
	
	private void asignarHoraFinalizacion(Calendar horaInicio) {
		this.horaFinalizacion = (Calendar) horaInicio.clone();
		horaFinalizacion.add(Calendar.MINUTE, 90);
	}
	
	public String toString() {
		return "Hora Inicio: " + this.horaInicio.getTime() + "\nHora Finalizacion: " + this.horaFinalizacion.getTime();
	}
	
	public boolean estaEnMiRangoHorario(Calendar hora) {
		if (this.horaInicio.before(hora) && this.horaFinalizacion.after(hora)) {
			return true;
		}
		return false;
	}
	
	public Calendar getHoraInicio() {
		return this.horaInicio;
	}
	
	public Calendar getHoraFinalizacion() {
		return this.horaFinalizacion;
	}
	
	public Instalacion getInstalacion() {
		return this.instalacion;
	}
}
