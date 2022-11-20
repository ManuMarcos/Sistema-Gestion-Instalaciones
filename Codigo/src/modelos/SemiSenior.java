package modelos;

public class SemiSenior extends ExperienciaLaboral {
	
	//Attributes
	private static double costoSemiSenior = 250;

	//Constructor
	public SemiSenior() {
		super();
		this.setCostoHora(SemiSenior.costoSemiSenior);
	}
}
