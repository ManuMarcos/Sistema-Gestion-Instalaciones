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
import vistas.PruebaPanel;
import vistas.VentanaAgendarInstalacion;
import vistas.VentanaUsuario;

public class ControladorVentanaUsuario {

	//Attributes
	private VentanaUsuario vista;
	private Empresa modelo;
	private Empleado usuario;
	
	public ControladorVentanaUsuario(Empleado empleado){
		this.usuario = empleado;
		this.modelo = Empresa.getInstance();
		this.iniciarVista(empleado);
		this.setDatosUsuario(empleado);
		this.vista.setLocationRelativeTo(null);
		this.vista.setVisible(true);
	}
	
	public void setDatosUsuario(Empleado empleado) {
		/*
		String [] columnas = {"Usuario", "Nombre y Apellido", "Legajo"};
		String [][] datosEmpleado = {{empleado.getUsuario(), empleado.getNombre(), Integer.toString(empleado.getId())}};
		DefaultTableModel tableModel = new DefaultTableModel(datosEmpleado, columnas);
		vista.setDatosUsuario(tableModel);
		*/
		vista.setDatosUsuario(empleado.getUsuario(), Integer.toString(empleado.getId()), empleado.getNombre());
	}
	
	public void iniciarVista(Empleado empleado) {
		switch (empleado.getClass().getSimpleName()) {
			case "Operador":
				Operador operador = (Operador) empleado;
				this.iniciarVistaOperador(operador);
				break;
			case "Tecnico":
				Tecnico tecnico = (Tecnico) empleado;
				this.vista = new VentanaUsuario(new ImageIcon("tecnico.png"), "Tecnico");
				break;
			case "Administrativo":
				Administrativo administrativo = (Administrativo) empleado;
				this.vista =  new VentanaUsuario(new ImageIcon("administrativo.png"), "Administrativo");
				break;
			case "Administrador":
				Administrador administrador = (Administrador) empleado;
				this.vista =  new VentanaUsuario(new ImageIcon("administrador.png"), "Administrador");
				break;
				
		}
	}
	
	public void iniciarVistaOperador(Operador operador) {
		ControladorAgendarInstalacion agendarInstalacion = new ControladorAgendarInstalacion();
		
		this.vista = new VentanaUsuario(new ImageIcon("operadorCallCenter.png"), "Operador");
		this.vista.setPanelCentral(agendarInstalacion.getVista());
	}
	
	
	
	/*
	switch (tipoUsuario.toUpperCase()) {
	case "OPERADOR":
			Operador operador = (Operador) empleado;
			ControladorVentanaUsuario controladorVentanaUsuario = new ControladorVentanaUsuario();
			vista.setVisible(false);
			break;
		case "ADMINISTRADOR":
			vista.mostrarMensajeExitoso("Seccion de Administrador en desarrollo");
			break;
		case "ADMINISTRATIVO":
			vista.mostrarMensajeExitoso("Seccion de Administrativo en desarrollo");
			break;
		case "TECNICO":
			vista.mostrarMensajeExitoso("Seccion de Tecnico en desarrollo");
			break;
	}
	*/
	
	
	
	
}
