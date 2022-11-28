package modelos;

public abstract class ExperienciaLaboral {

	//Attributes
	
	
	//Methods
	public abstract float getCostoHora();

	public abstract void setCostoHora(float costoHora);
	
	public float costearHorasTrabajadas(float horasTrabajadas) {
		//System.out.println("Costo hora:" + getCostoHora());
		//System.out.println("Horas trabajadas:" +  horasTrabajadas);
		return getCostoHora() * horasTrabajadas;
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
}