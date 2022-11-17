package modelos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Disponibilidad {

	//Methods
	public Disponibilidad() {
	}
	
	public abstract Calendar getHoraInicio();
	
	public abstract Calendar getHoraFin();;
	
	public abstract boolean esDiaLaboral(Calendar fecha);
	
	public abstract boolean esHorarioLaboral(Turno turno);
	
	//Methods
	
}
