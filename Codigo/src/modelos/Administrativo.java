package modelos;

import java.util.ArrayList;
import java.util.Calendar;

public class Administrativo extends Empleado{

	//Attributes
	Empresa empresa = Empresa.getInstance();

	//Methods

	//Constructor
	public Administrativo(String nombre, String direccion,String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
}
