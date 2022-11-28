package modelos;

public class Junior extends ExperienciaLaboral {
	
	//Attributes
	private static float costoHora = 150;

	//Constructor
	public Junior() {
		super();
	}
	
	public void setCostoHora(float costoHora) {
		Junior.costoHora = costoHora;
	}
	
	public float getCostoHora() {
		return Junior.costoHora;
	}
}
