package modelos;

public class SemiSenior extends ExperienciaLaboral {
	
	//Attributes
	private static float costoHora = 250;

	//Constructor
	public SemiSenior() {
		super();
	}
	
	public void setCostoHora(float costoHora) {
		SemiSenior.costoHora = costoHora;
	}
	
	public float getCostoHora() {
		return SemiSenior.costoHora;
	}
	
	
}


