package controladores;

import modelos.Empresa;
import vistas.PanelAgendarInstalacion;
import vistas.PanelCrearCliente;

public class ControladorCrearCliente {

	//Attributes
		private PanelCrearCliente vista;
		private Empresa modelo;
		
	
	public ControladorCrearCliente() {
		this.vista = new PanelCrearCliente();
		this.modelo = Empresa.getInstance();
	}
		
		
	public PanelCrearCliente getVista() {
		return this.vista;
	}
	
}
