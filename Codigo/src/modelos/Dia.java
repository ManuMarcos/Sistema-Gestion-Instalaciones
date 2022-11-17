package modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
	
	public boolean agregarTurno(Turno turno) {
		if (this.estaDisponible(turno)) {
			this.turnos.add(turno);
			this.ordenarTurnos();
			return true;
		}
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
	
	public boolean estaDisponible(Turno turno) {
		for(Turno ti : turnos) {
			if (ti.estoyOcupando(turno)) {
				return false;
			}
		}
		return true;
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
	
	public void ordenarTurnos() {
		Collections.sort(this.turnos, new ordenarPorTurno());
	}
	
	static class ordenarPorTurno implements Comparator<Turno>{

		@Override
		public int compare(Turno turno1, Turno turno2) {
			// TODO Auto-generated method stub
			return turno1.getHoraInicio().compareTo(turno2.getHoraInicio());
		}

		
		
	}
	
	
}
