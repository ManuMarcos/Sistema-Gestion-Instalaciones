package modelos;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TurnoCompleto extends Disponibilidad{
	
	
	//Attributes
	private static Calendar horaInicio = new GregorianCalendar();
	private static Calendar horaFin = new GregorianCalendar();
	private static int[] diasNoLaborales = {Calendar.SUNDAY};
	
	static {
		horaInicio.set(0, 0, 0, 0, 0);
		horaFin.set(0, 0, 0, 23, 59);
	}
	
	//Methods
	public TurnoCompleto() {
		
	}
	
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	
	public Calendar getHoraFin() {
		return horaFin;
	}
	
	public boolean esDiaLaboral(Calendar fecha) {
		for (int i = 0; i < diasNoLaborales.length; i++) {
			if (fecha.get(Calendar.DAY_OF_WEEK) == diasNoLaborales[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean esHorarioLaboral(Turno turno) {
		if (horaInicio.get(Calendar.HOUR_OF_DAY) <= turno.getHoraInicio().get(Calendar.HOUR_OF_DAY) && 
				horaFin.get(Calendar.HOUR_OF_DAY) >= turno.getHoraFinalizacion().get(Calendar.HOUR_OF_DAY)) {
			return true;
		}

		return false;
	}
	
	
}
