package controladores;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import modelos.Administrador;
import modelos.Administrativo;
import modelos.Empleado;
import modelos.EmpleadoView;
import modelos.Empresa;
import modelos.Operador;
import modelos.Tecnico;
import vistas.PanelAgendarInstalacion;

import vistas.VentanaUsuario;

public class ControladorVentanaUsuario {

	//Attributes
	private VentanaUsuario vista;
	private Empresa modelo;
	private EmpleadoView empleadoView;
	
	
	public ControladorVentanaUsuario(int idUsuario){
		this.modelo = Empresa.getInstance();
		this.empleadoView = this.modelo.getEmpleadoView(idUsuario);
		this.iniciarVista();
		this.mostrarDatosUsuario();
		this.vista.setLocationRelativeTo(null);
		this.vista.setVisible(true);
	}
	
	public void mostrarDatosUsuario() {
		vista.setDatosUsuario(empleadoView.getUsuario(), empleadoView.getNombre(), Integer.toString(empleadoView.getId()));
	}
	
	public void iniciarVista() {
		switch (this.empleadoView.getTipoUsuario()) {
			case "Operador":
				this.iniciarVistaOperador();
				break;
			case "Tecnico":
				
				this.iniciarVistaTecnico(empleadoView);
				break;
			case "Administrativo":
				this.vista =  new VentanaUsuario(new ImageIcon("administrativo.png"), "Administrativo",1,1);
				break;
			case "Administrador":
				this.iniciarVistaAdministrador();
				break;
				
		}
	}
	
	private void iniciarVistaOperador() {
		ControladorAgendarInstalacion controladorAgendarInstalacion = new ControladorAgendarInstalacion();
		ControladorCrearCliente controladorCrearCliente = new ControladorCrearCliente();
		
		this.vista = new VentanaUsuario(new ImageIcon("operadorCallCenter.png"), "Operador", 2, 1);
		this.vista.agregarModulo(controladorAgendarInstalacion.getVista());
		this.vista.agregarModulo(controladorCrearCliente.getVista());
		
	}
	
	private void iniciarVistaTecnico(EmpleadoView empleadoLogueado) {
		ControladorModificarInstalacion controladorModificarInstalacion = new ControladorModificarInstalacion(empleadoLogueado);
		ControladorVerInstalaciones controladorVerInstalaciones = new ControladorVerInstalaciones(empleadoLogueado);
		this.vista = new VentanaUsuario(new ImageIcon("tecnico.png"), "Tecnico", 2 ,1);
		this.vista.agregarModulo(controladorModificarInstalacion.getVista());
		this.vista.agregarModulo(controladorVerInstalaciones.getVista());
	
	}
	

	private void iniciarVistaAdministrador() {

		ControladorAbmTecnicos controladorAbmTecnicos = new ControladorAbmTecnicos();
		ControladorAbmInventario controladorAbmInventario = new ControladorAbmInventario();
		ControladorCrearCliente controladorCrearCliente = new ControladorCrearCliente();
		
		//Se crear el panel modular
		this.vista = new VentanaUsuario(new ImageIcon("administrador.png"), "Administrador",2,1);
		//this.crearPanelModular(new ImageIcon("administrador.png"), "Administrador",2,1);
		//Se le agregan los modulos creados
		this.vista.agregarModulo(controladorAbmTecnicos.getVista());
		this.vista.agregarModulo(controladorAbmInventario.getVista());
	}
	
	private void crearPanelModular(ImageIcon icono, String titulo, int filas, int columnas) {
		this.vista = new VentanaUsuario(icono, titulo, filas, columnas);
	}
	
	
	
}
