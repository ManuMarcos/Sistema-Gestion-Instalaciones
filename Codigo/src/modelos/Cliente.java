package modelos;

public class Cliente extends Persona{

	//Attributes
	private static int generador = 1;
	private TipoCliente tipoCliente;
	private String correoElectronico;
	
	
	
	//Methods
	
	//Constructor
	
	/**
	 * Constructor de Cliente
	 * @param nombre
	 * @param direccion
	 * @param tipoCliente
	 * @param correoElectronico
	 */
	public Cliente(String nombre, String direccion, TipoCliente tipoCliente, String correoElectronico) {
		super(nombre, direccion);
		this.tipoCliente = tipoCliente;
		this.correoElectronico =  correoElectronico;
		this.id = generador;
		generador ++;
	}
	
}
