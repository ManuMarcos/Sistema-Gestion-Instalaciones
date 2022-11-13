package modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Dia {

	//Attributes
	private Calendar fecha;
	private ArrayList<Turno> turnos;
	
	//Methods
	
	//Constructor
	public Dia(Calendar fecha) {
		this.fecha = fecha;
		this.turnos =  new ArrayList<Turno>();
	}
	
	public boolean agregarTurno(Turno turno, TurnoLaboral turnoLaboral) {
		if (this.estaDisponible(turno.getHoraInicio()) && this.estaDisponible(turno.getHoraFinalizacion()) && 
				turnoLaboral.esHorarioLaboral(turno)) {
			this.turnos.add(turno);
			System.out.println("El turno se agrego exitosamente");
			return true;
		}
		System.out.println("El horario solicitado no se encuentra disponible");
		return false;
	};
	
	public void imprimirTurnos() {
		System.out.println();
		System.out.println("Turnos ocupados del dia " + this.toString());
		System.out.println();
		for (Turno turno : this.turnos) {
			System.out.println(turno.toString());
			System.out.println();
		}
	}
	
	public boolean estaDisponible(Calendar fecha) {
		boolean estaDisponible = true;
		for(Turno turno : turnos) {
			if (turno.estaEnMiRangoHorario(fecha)) {
				estaDisponible = false;
			}
		}
		return estaDisponible;
	};
	
	public boolean soyLaFecha(Calendar dia) {
		if (dia.get(Calendar.DAY_OF_MONTH) == this.fecha.get(Calendar.DAY_OF_MONTH) && 
			dia.get(Calendar.MONTH) == this.fecha.get(Calendar.MONTH) &&
			dia.get(Calendar.YEAR) == this.fecha.get(Calendar.YEAR)) {
			return true;
		}
		return false;
	}
	
	public Calendar getFecha() {
		return this.fecha;
	}
	
	public ArrayList<Turno> getTurnos(){
		return this.turnos;
	}
	
	
	
	public String toString() {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateada = formatoFecha.format(this.fecha.getTime());
		return fechaFormateada;
	}
	
	
}
