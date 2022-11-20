package modelos;

public class Cliente extends Persona{

	//Attributes
	private int cuitCuil;
	private Agenda agenda;
	private TipoCliente tipoCliente;
	private String correoElectronico;
	
	
	
	
	//Methods
	
	
	//Constructor

	public Cliente(String nombre, String direccion, int cuitCuil, TipoCliente tipoCliente, String correoElectronico) {
		super(nombre, direccion);
		this.cuitCuil = cuitCuil;
		this.tipoCliente = tipoCliente;
		this.correoElectronico =  correoElectronico;
		this.agenda = new Agenda();
	}
	
	public boolean tengoElCuitCuil(int cuitCuil) {
		if (this.cuitCuil == cuitCuil) {
			return true;
		} 
		return false;
	}
	
	public Agenda getAgenda() {
		return this.agenda;
	}
	
	
	
	
	
	
}
