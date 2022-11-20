 package modelos;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class TurnoTarde extends Disponibilidad{

	//Attributes
	private static Calendar horaInicio = new GregorianCalendar();
	private static Calendar horaFin = new GregorianCalendar();
	private static int[] diasNoLaborales = {Calendar.SATURDAY, Calendar.SUNDAY};
	
	static {
		horaInicio.set(0, 0, 0, 14, 0);
		horaFin.set(0, 0, 0, 20, 0);
	}
	
	//Methods
	public TurnoTarde() {
		
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
				return true;
			}
		}
		return false;
	}
	
	public boolean esHorarioLaboral(Turno turno) {
		if (horaInicio.get(Calendar.HOUR_OF_DAY)  <= turno.getHoraInicio().get(Calendar.HOUR_OF_DAY) && 
				horaFin.get(Calendar.HOUR_OF_DAY) >= turno.getHoraFinalizacion().get(Calendar.HOUR_OF_DAY)) {
			if(horaFin.get(Calendar.HOUR_OF_DAY) == turno.getHoraFinalizacion().get(Calendar.HOUR_OF_DAY)
					&& horaFin.get(Calendar.MINUTE) < turno.getHoraFinalizacion().get(Calendar.MINUTE)) {
				return false;
			}
			return true;
		}
		return false;
	}
	
}

