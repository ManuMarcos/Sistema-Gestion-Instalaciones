package modelos;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class Turno {

	//Attributes
	private Calendar horaInicio;
	private Calendar horaFinalizacion;
	private Instalacion instalacion;

	
	//Methods
	
	//Constructor
	public Turno(Calendar horaInicio) {
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
	
	public boolean estoyOcupando(Turno turno) {
		if ((turno.getHoraInicio().after(this.horaInicio) && turno.getHoraInicio().before(this.horaFinalizacion)
				|| turno.getHoraFinalizacion().after(horaInicio) && turno.getHoraFinalizacion().before(this.horaFinalizacion)
				|| turno.getHoraInicio().equals(this.horaInicio))){
			System.out.println("Estoy ocupando turno");
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
	
	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
	
	
	
	
	
	
	
	
	
	
}
