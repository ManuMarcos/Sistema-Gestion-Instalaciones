package modelos;

public class Senior extends ExperienciaLaboral {
	
	//Attributes
	private static float costoHora = 320;

	//Constructor
	public Senior() {
		super();
	}
	
	public void setCostoHora(float costoHora) {
		Senior.costoHora = costoHora;
	}
	
	public float getCostoHora() {
		return Senior.costoHora;
	}
}
