package controladores;


import javax.swing.ImageIcon;
import modelos.EmpleadoView;
import modelos.Empresa;
import vistas.VentanaUsuario;

public class ControladorVentanaUsuario {

	//Attributes
	private VentanaUsuario vista;
	private Empresa modelo;
	private EmpleadoView empleadoView;
	
	
	public ControladorVentanaUsuario(int idUsuario){
		this.modelo = Empresa.getInstance();
		this.empleadoView = this.modelo.getEmpleadoView(idUsuario);
	}
	
	private void mostrarDatosUsuario() {
		this.vista.setDatosUsuario(empleadoView.getUsuario(), Integer.toString(empleadoView.getId()), empleadoView.getNombre());
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
				this.iniciarVistaAdministrativo();
				break;
			case "Administrador":
				this.iniciarVistaAdministrador();
				break;		
		}
		this.mostrarDatosUsuario();
		this.vista.setLocationRelativeTo(null);
		this.vista.setVisible(true);
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

	private void iniciarVistaAdministrativo(){
		ControladorFacturacion controladorFacturacion = new ControladorFacturacion();
		
		this.vista = new VentanaUsuario(new ImageIcon("administrativo.png"), "Administrativo", 1,1);
		this.vista.agregarModulo(controladorFacturacion.getVista());
	}
	

	private void iniciarVistaAdministrador() {

		ControladorAbmTecnicos controladorAbmTecnicos = new ControladorAbmTecnicos();
		ControladorInventarioParamAdicionales controladorAbmInventario = new ControladorInventarioParamAdicionales();
		
		//Se crear el panel modular
		this.vista = new VentanaUsuario(new ImageIcon("administrador.png"), "Administrador",2,1);
		
		//Se le agregan los modulos creados
		this.vista.agregarModulo(controladorAbmTecnicos.getVista());
		this.vista.agregarModulo(controladorAbmInventario.getVista());
	}
	
	
	
	
	
}
