package modelos;

public class TecnicoView extends EmpleadoView{

	private String turnoLaboral;
	private String experienciaLaboral;
	private String contrasena;
	
	public TecnicoView(int id, String nombreApellido, String turnoLaboral, String experienciaLaboral, String direccion,
			String usuario, String contrasena, String tipoEmpleado) {
		super(id, nombreApellido, direccion, usuario, tipoEmpleado);
		this.turnoLaboral = turnoLaboral;
		this.experienciaLaboral = experienciaLaboral;
		//Se manda la contrasena porque el admin la puede ver y setear
		this.contrasena = contrasena;
	}

	public String getTurnoLaboral() {
		return turnoLaboral;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	
	
}
