package modelos;

public class Senior extends ExperienciaLaboral {
	
	//Attributes
	private static double costoSenior = 320;

	//Constructor
	public Senior() {
		super();
		this.setCostoHora(Senior.costoSenior);
	}
}
