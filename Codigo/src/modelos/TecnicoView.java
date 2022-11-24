package modelos;

public class TecnicoView {

	private int id;
	private String nombreApellido;
	private String turnoLaboral;
	private String experienciaLaboral;
	private String direccion;
	private String usuario;
	private String contrasena;
	
	public TecnicoView(int id, String nombreApellido, String turnoLaboral, String experienciaLaboral, String direccion,
			String usuario, String contrasena) {
		this.id = id;
		this.nombreApellido = nombreApellido;
		this.turnoLaboral = turnoLaboral;
		this.experienciaLaboral = experienciaLaboral;
		this.direccion = direccion;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public int getId() {
		return id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public String getTurnoLaboral() {
		return turnoLaboral;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	
	
}
