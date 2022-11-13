package modelos;

import java.util.Date;

public class Tecnico extends Empleado {

	//Attributes
	private ExperienciaLaboral experienciaLaboral;
	private Agenda agenda;
	private TurnoLaboral turnoLaboral;

	//Methods
	
	
	//Constructor
	
	/**
	 * Constructor de Tecnico
	 * @param nombre
	 * @param direccion
	 * @param experienciaLaboral
	 */
	public Tecnico(String nombre, String direccion, ExperienciaLaboral experienciaLaboral) {
		super(nombre, direccion);
		this.experienciaLaboral = experienciaLaboral;
	}
	
	//Constructor para pruebas
	public Tecnico(String nombre, String direccion, TurnoLaboral turnoLaboral) {
		super(nombre,direccion);
		this.turnoLaboral = turnoLaboral;
		this.agenda = new Agenda(turnoLaboral);
	}
	
	public Agenda getAgenda() {
		return this.agenda;
	}
	
	public String toString() {
		return "Id: " + this.id + "\nNombre: " + this.nombre +  "\nDireccion: " + this.direccion +"\n";
	}
	
	
	
	
}
