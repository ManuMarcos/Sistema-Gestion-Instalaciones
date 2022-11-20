package modelos;

import java.util.Date;

public class Tecnico extends Empleado {

	//Attributes
	private ExperienciaLaboral experienciaLaboral;
	private Agenda agenda;
	private Disponibilidad turnoLaboral;

	//Methods
	public ExperienciaLaboral getExperienciaLaboral() {
		return this.experienciaLaboral;
	}
	
	public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public Disponibilidad getTurnoLaboral() {
		return turnoLaboral;
	}

	public void setTurnoLaboral(Disponibilidad turnoLaboral) {
		this.turnoLaboral = turnoLaboral;
	}

	public Agenda getAgenda() {
		return this.agenda;
	}
	
	//Constructor
	/**
	 * Constructor de Tecnico
	 * @param nombre
	 * @param direccion
	 * @param experienciaLaboral
	 */
	public Tecnico(String nombre, String direccion, ExperienciaLaboral experienciaLaboral, String usuario, String contrasena, ExperienciaLaboral experiencia) {
		super(nombre, direccion, usuario, contrasena);
		this.setExperienciaLaboral(experiencia);
	}
	
	//Constructor para pruebas
	public Tecnico(String nombre, String direccion, Disponibilidad turnoLaboral,String usuario, String contrasena, ExperienciaLaboral experiencia) {
		super(nombre,direccion, usuario, contrasena);
		this.turnoLaboral = turnoLaboral;
		this.agenda = new Agenda(turnoLaboral);
		this.setExperienciaLaboral(experiencia);
	}
	
	
	

	
	public String toString() {
		return "Id: " + this.id + "\nNombre: " + this.nombre +  "\nDireccion: " + this.direccion +"\n";
	}
	
	
	
	
}
