package modelos;

public class Junior extends ExperienciaLaboral {
	
	//Attributes
	private static double costoJunior = 150;

	//Constructor
	public Junior() {
		super();
		this.setCostoHora(Junior.costoJunior);
	}
}
