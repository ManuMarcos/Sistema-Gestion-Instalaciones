package modelos;

public class Administrador extends Empleado{

	//Attributes
	Empresa empresa = Empresa.getInstance();

	//Methods
	
	public Administrador(String nombre, String direccion, String usuario, String contrasena) {
		super(nombre, direccion, usuario, contrasena);
		
	}
	
	
	
	
	public void crearTecnico() {};
	public void crearProducto() {};
	
	public void setCostoHoraTrabajo(ExperienciaLaboral experiencia, float costoHora) {
		experiencia.setCostoHora(costoHora);
	};
	
	/*
	public void setStockProducto(Producto producto, int cantStock) {
		empresa.setStockProducto(producto, cantStock);
	};
	*/
	/*
	public void setPrecioProducto(Producto producto, float precio) {
		empresa.setPrecioProducto(producto, precio);
	};
	*/
	public void setCostoViaje(float costo) {
		Empresa.setPrecioTransporte(costo);
	};
	
}
