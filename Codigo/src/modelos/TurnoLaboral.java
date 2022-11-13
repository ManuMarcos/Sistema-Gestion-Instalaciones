package modelos;

import java.util.Calendar;

public abstract class TurnoLaboral {

	//Attributes
	//Methods
	protected abstract boolean esHorarioLaboral(Turno turno);
	protected abstract Calendar getHoraInicio();
	protected abstract Calendar getHoraFin();
	protected abstract boolean esDiaLaboral(Calendar fecha);
}
