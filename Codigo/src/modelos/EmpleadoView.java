package modelos;

public class EmpleadoView extends PersonaView{
	
	//Attributes
	protected int id;
	protected String usuario;
	protected String tipoEmpleado;
	
	
	//Methods
	public EmpleadoView(int id, String nombre, String direccion, String usuario, String tipoEmpleado) {
		super(nombre, direccion);
		this.id = id;
		this.usuario = usuario;
		this.tipoEmpleado = tipoEmpleado;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getTipoUsuario() {
		return this.tipoEmpleado;
	}
	
	public String toString() {
		return this.nombre;
	}
}
