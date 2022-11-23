package controladores;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import modelos.Administrador;
import modelos.Administrativo;
import modelos.Empleado;
import modelos.Empresa;
import modelos.Operador;
import modelos.Tecnico;
import vistas.PanelAgendarInstalacion;

import vistas.VentanaUsuario;

public class ControladorVentanaUsuario {

	//Attributes
	private VentanaUsuario vista;
	private Empresa modelo;
	private Empleado usuario;
	
	public ControladorVentanaUsuario(Empleado empleado){
		this.usuario = empleado;
		this.modelo = Empresa.getInstance();
		this.iniciarVista();
		this.setDatosUsuario(this.usuario);
		this.vista.setLocationRelativeTo(null);
		this.vista.setVisible(true);
	}
	
	public void setDatosUsuario(Empleado usuario) {
		vista.setDatosUsuario(this.usuario.getUsuario(), Integer.toString(this.usuario.getId()), this.usuario.getNombre());
	}
	
	public void iniciarVista() {
		switch (this.usuario.getClass().getSimpleName()) {
			case "Operador":
				Operador operador = (Operador) usuario;
				this.iniciarVistaOperador(operador);
				break;
			case "Tecnico":
				Tecnico tecnico = (Tecnico) usuario;
				this.vista = new VentanaUsuario(new ImageIcon("tecnico.png"), "Tecnico",1,1);
				break;
			case "Administrativo":
				Administrativo administrativo = (Administrativo) usuario;
				this.vista =  new VentanaUsuario(new ImageIcon("administrativo.png"), "Administrativo",1,1);
				break;
			case "Administrador":
				Administrador administrador = (Administrador) usuario;
				this.vista =  new VentanaUsuario(new ImageIcon("administrador.png"), "Administrador",1,1);
				break;
				
		}
	}
	
	public void iniciarVistaOperador(Operador operador) {
		ControladorAgendarInstalacion controladorAgendarInstalacion = new ControladorAgendarInstalacion();
		ControladorCrearCliente controladorCrearCliente = new ControladorCrearCliente();
		
		this.vista = new VentanaUsuario(new ImageIcon("operadorCallCenter.png"), "Operador", 2, 1);
		this.vista.agregarModulo(controladorAgendarInstalacion.getVista());
		this.vista.agregarModulo(controladorCrearCliente.getVista());
		
	}
	
	
	
	
	
	
	
	
}
