package modelos;

import java.util.Calendar;
import java.util.Date;

public class Tecnico extends Empleado {

	//Attributes
	private ExperienciaLaboral experienciaLaboral;
	private Agenda agenda;
	private Disponibilidad turnoLaboral;
	private Empresa empresa = Empresa.getInstance();

	//Methods
	
	//Constructor
	public Tecnico(String nombre, String direccion, Disponibilidad turnoLaboral,String usuario, String contrasena, ExperienciaLaboral experiencia) {
		super(nombre,direccion, usuario, contrasena);
		this.turnoLaboral = turnoLaboral;
		this.agenda = new Agenda(turnoLaboral);
		this.setExperienciaLaboral(experiencia);
	}
	
	
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
	
	public void completarInstalacion(Instalacion instalacion, Calendar horaInicio, Calendar horaFinalizacion, boolean almuerzo, int cantidadEvaporadoras, int cantidadKitsDeInstalacion, int cantidadCondensadoras) {
		empresa.completarInstalacion(instalacion, horaInicio, horaFinalizacion, almuerzo, cantidadEvaporadoras, cantidadKitsDeInstalacion, cantidadCondensadoras);
	}
	
	public void agregarElementoUtilizado(Instalacion instalacion, Producto producto, int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			empresa.removerUnidadProducto(producto);
			instalacion.agregarElementos(producto);
		}
	}
	
	public TecnicoView toView() {
		return new TecnicoView(this.id, this.nombre, this.turnoLaboral.toString(), this.experienciaLaboral.getClass().getSimpleName(), this.direccion,
				this.usuario, this.contrasena);
	}
	
	
	
	
	public String toString() {
		return "Id: " + this.id + "\nNombre: " + this.nombre +  "\nDireccion: " + this.direccion +"\n";
	}
	
	
	
	
}
