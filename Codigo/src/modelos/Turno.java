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
		return "Hora Inicio: " + this.horaInicio.getTimeInMillis()/1000 + "\nHora Finalizacion: " + this.horaFinalizacion.getTimeInMillis()/1000;
	}
	
	
	public boolean estoyOcupando(Turno turno) {
		//System.out.println("Nuevo turno " + turno.toString());
		//System.out.println("Mi turno " + this.toString());
		
		/*
		if ((turno.getHoraInicio().after(this.horaInicio) && turno.getHoraInicio().before(this.horaFinalizacion))
				|| (turno.getHoraFinalizacion().after(this.horaInicio) && turno.getHoraFinalizacion().before(this.horaFinalizacion))
				|| (turno.getHoraInicio().equals(horaInicio))) {
			System.out.println("ESTOY OCUPANDO");
			return true;
		}
		return false;
		*/
		//No se utiliza esa forma ya que hay un bug ocasionado por los milisegundos al querer agendar un pegado a otro
		//Se deja comentado por si se encuentra algun bug en la nueva metodologia
		
		long turnoHoraInicio = turno.getHoraInicio().getTimeInMillis()/1000;
		long turnoHoraFin = turno.getHoraFinalizacion().getTimeInMillis()/1000;
		long esteTurnoHoraInicio = this.getHoraInicio().getTimeInMillis()/1000;
		long esteTurnoHoraFin = this.getHoraFinalizacion().getTimeInMillis()/1000;
		
		if((turnoHoraInicio > esteTurnoHoraInicio && turnoHoraInicio < esteTurnoHoraFin)
				|| (turnoHoraFin > esteTurnoHoraInicio && turnoHoraFin < esteTurnoHoraFin)
				|| (turnoHoraInicio == esteTurnoHoraInicio)) {
			System.out.println("Estoy ocupando");
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
