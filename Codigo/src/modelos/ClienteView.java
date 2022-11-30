package modelos;

public class ClienteView extends PersonaView{

	//Attributes
	private long cuitCuil;
	private String tipoCliente;
	private String correoElectronico;
	
	//Methods
	public ClienteView(long cuitCuil, String nombre, String direccion, String correoElectronico, String tipoCliente) {
		super(nombre, direccion);
		this.cuitCuil = cuitCuil;
		this.tipoCliente = tipoCliente;
		this.correoElectronico = correoElectronico;
	}

	public long getCuitCuil() {
		return this.cuitCuil;
	}

	public String getTipoCliente() {
		return this.tipoCliente;
	}

	public String getCorreo() {
		return this.correoElectronico;
	}
}
