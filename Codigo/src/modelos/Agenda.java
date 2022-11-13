package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Agenda{

	//Attributes
	private ArrayList<Dia> dias;
	private TurnoLaboral turnoLaboral;
	
	//Methods
	
	//Constructor
	public Agenda(TurnoLaboral turnoLaboral) {
		this.dias = new ArrayList<Dia>();
		this.turnoLaboral = turnoLaboral;
	}
	
	public boolean agendarInstalacion(Instalacion instalacion, Calendar fecha) {
		Dia diaParaAgendar = this.existeDia(fecha);
		if (diaParaAgendar.estaDisponible(fecha) && this.verificarFecha(fecha)) {
			Turno turno = new Turno(fecha, instalacion);
			diaParaAgendar.agregarTurno(turno, turnoLaboral);
			this.dias.add(diaParaAgendar);
			/*
			System.out.println("------------------------------------- ");
			System.out.println("Se agendo la instalacion para el dia: " + diaParaAgendar.toString());
			System.out.println("------------------------------------- ");
			*/
			return true;
		}
		System.out.println("No hay un turno disponible para el dia " + diaParaAgendar.toString());
		return false;
		
	};
	
	public void imprimirTurnosPorFecha(Calendar fecha) {
		Dia diaBuscado = this.buscarDia(fecha);
		if (diaBuscado != null) {
			diaBuscado.imprimirTurnos();
		}
		else {
			System.out.println("No hay ningun turno para ese dia");
		}
	}
	
	/**
	 * Verifica si @dia existe en el calendario. Si existe: lo devuelve. Si no existe: lo crea y lo devuelve
	*/
	private Dia existeDia(Calendar dia) {
		for (Dia di : this.dias) {
			if (di.soyLaFecha(dia)) {
				return di;
			}
		}
		Dia nuevoDia = new Dia(dia);
		return nuevoDia;
	}
	
	private Dia buscarDia(Calendar fecha) {
		for (Dia di : this.dias) {
			if (di.soyLaFecha(fecha)) {
				return di;
			}
		}
		return null;
	}
	
	private boolean verificarFecha(Calendar fecha) {
		if (this.turnoLaboral.esDiaLaboral(fecha)) {
			return true;
		}
		return false;
	}
	
}
