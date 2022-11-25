package modelos;

public class Cliente extends Persona{

	//Attributes
	private long cuitCuil;
	private Agenda agenda;
	private TipoCliente tipoCliente;
	private String correoElectronico;
	
	
	
	
	//Methods
	
	
	//Constructor

	public Cliente(String nombre, String direccion, long cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		super(nombre, direccion);
		this.cuitCuil = cuitCuil;
		this.tipoCliente = tipoCliente;
		this.correoElectronico =  correoElectronico;
		this.agenda = new Agenda();
	}
	
	public boolean tengoElCuitCuil(long cuitCuil) {
		if (this.cuitCuil == cuitCuil) {
			return true;
		} 
		return false;
	}
	
	public Agenda getAgenda() {
		return this.agenda;
	}
	
	public long getCuitCuil() {
		return this.cuitCuil;
	}
	
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}
	
	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}
	
	public ClienteView toView() {
		return new ClienteView(this.cuitCuil, this.nombre, this.direccion, this.correoElectronico, this.getClass().getSimpleName());
	}
	
	
	
	
	
	
}
