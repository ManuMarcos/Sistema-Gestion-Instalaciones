package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelos.Empresa;
import modelos.TipoCliente;
import vistas.PanelAgendarInstalacion;
import vistas.PanelCrearCliente;

public class ControladorCrearCliente implements ActionListener{

	//Attributes
		private PanelCrearCliente vista;
		private Empresa modelo;
		
	
	public ControladorCrearCliente() {
		this.vista = new PanelCrearCliente();
		this.modelo = Empresa.getInstance();
		this.vista.setActionListener(this);
	}
		
		
	public PanelCrearCliente getVista() {
		return this.vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
		case "CREAR_CLIENTE":
			if (this.estaElFormularioCompleto() ) {
				String nombreApellido = this.vista.getNombreApellido();
				String direccion = this.vista.getDireccion();
				long cuitCuil = Long.parseLong(this.vista.getCuitCuil());
				TipoCliente tipoCliente = this.stringToTipoCliente(this.vista.getTipoCliente());
				String correoElectronico = this.vista.getCorreoElectronico();
				String mensaje = "Se creo el cliente con los siguientes datos:\n"
						+ "- Nombre: " + nombreApellido + "\n- Direccion: " + direccion + "\n- Cuit/Cuil: " + cuitCuil + "\n- Tipo Cliente: " + tipoCliente + 
						"\n- Correo electronico: " + correoElectronico;
				if (modelo.crearCliente(nombreApellido, direccion, cuitCuil, tipoCliente, correoElectronico)) {
					vista.mostrarMensajeInformativo("Cliente creado exitosamente", mensaje);
					vista.resetearPanel();
				}
				else{
					vista.mostrarMensajeDeError("Cliente existente", "El cliente ingresado ya existe en el sistema");
				}
			}	
			break;
		case "LIMPIAR":
			this.vista.resetearPanel();
			break;
		}
	}
	
	public boolean esIdValido(String idCliente) {
		try {
			Long.parseLong(this.vista.getCuitCuil());
			return true;
		}
		catch (Exception excepcion){
			vista.mostrarMensajeDeError("Cuit/Cuil incorrecto, ingrese solo numeros");
			return false;
		}
	}
	
	public boolean estaElFormularioCompleto() {
		boolean estaCompleto = true;
		String camposIncompletos = "";
		String mensajeError;
		
		if (this.vista.getNombreApellido().length() == 0) {
			camposIncompletos += "\n- Nombre y Apellido";
			estaCompleto = false;
		}
		if (this.vista.getDireccion().length() == 0) {
			camposIncompletos += "\n- Direccion";
			estaCompleto = false;
		}
		if (this.vista.getCuitCuil().length() == 0 || !this.esIdValido(this.vista.getCuitCuil())) {
			camposIncompletos += "\n- Cuit/Cuil";
			estaCompleto = false;
		}
		if (this.vista.getCorreoElectronico().length() == 0) {
			camposIncompletos += "\n- Correo electronico";
			estaCompleto = false;
		}
	
		mensajeError = "Por favor complete los siguientes campos" + camposIncompletos;
		if (estaCompleto == false) {
			this.vista.mostrarMensajeDeError("Datos Incompletos", mensajeError);
		}
		
		return estaCompleto;
	}
	
	private TipoCliente stringToTipoCliente(String tipoClienteString) {
		TipoCliente tipoCliente = TipoCliente.INDIVIDUO;
		switch (tipoClienteString) {
			case "INDIVIDUO":
				tipoCliente = TipoCliente.INDIVIDUO;
				break;
			case "EMPRESA":
				tipoCliente = TipoCliente.EMPRESA;
				break;
		}
		return tipoCliente;
	}
	
	
	
	
}
