package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.ClienteView;
import modelos.EmpleadoView;
import modelos.Empresa;
import modelos.TecnicoView;
import vistas.PanelAgendarInstalacion;


public class ControladorAgendarInstalacion implements ActionListener, KeyListener{

	//Attributes
	private PanelAgendarInstalacion vista;
	private Empresa modelo;
	
	public ControladorAgendarInstalacion(){
		this.vista = new PanelAgendarInstalacion();
		this.vista.setActionListener(this);
		this.vista.setKeyListener(this);
		this.modelo = Empresa.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "AGENDAR":
				String idIngresado = this.vista.getIdCliente();
				if (this.esIdValido(idIngresado)) {
					this.agendarInstalacion(Long.parseLong(idIngresado));
				}
				break;
			case "CONFIRMAR_TECNICO":
				this.confirmarInstalacion();
				this.vista.cerrarVentanasEmergentes();
				this.vista.resetearPanel();
				break;
			case "CANCELAR":
				this.vista.resetearPanel();
				break;
		}	
	}

	private void confirmarInstalacion() {
		TecnicoView tecnicoView = this.modelo.getTecnicoView(this.vista.getIdTecnicoSeleccionado());
		ClienteView clienteView = this.modelo.getClienteView(Long.parseLong(this.vista.getIdCliente()));
		Calendar fechaSeleccionada = vista.getFechaSeleccionada();
		boolean necesitaSeguro= this.vista.necesitaSeguro();
		boolean necesitaSoporte = this.vista.necesitaSoporte();
		if (this.modelo.agendarInstalacion(clienteView.getCuitCuil(), tecnicoView.getId(), fechaSeleccionada, necesitaSeguro, necesitaSoporte)) {
			String mensaje = "Se agendo con exito la instalacion \nCliente:  " + clienteView.getNombre() + "\nTecnico:  " + tecnicoView.getNombre() +
					"\nHorario: " + this.modelo.formatearFecha(fechaSeleccionada) + "\nSeguro: " + booleanToString(necesitaSeguro) + "\nSoporte Pared: " + booleanToString(necesitaSoporte);
			vista.mostrarMensajeInformativo("Instalacion agendada con exito" , mensaje);
		}
	}
	
	
	private void agendarInstalacion(long idCliente) {
		boolean hayStockDisponible = this.modelo.hayStockDisponibleParaAgendar();
		boolean existeCliente = this.modelo.existeCliente(idCliente);
		Calendar fechaSeleccionada = this.vista.getFechaSeleccionada();
		
		if (hayStockDisponible) {
			if (existeCliente) {
				if (this.modelo.estaDisponibleCliente(fechaSeleccionada, idCliente)) {
					ArrayList<EmpleadoView> tecnicosDisponibles = this.modelo.getTecnicosDisponibles(fechaSeleccionada);
					if (tecnicosDisponibles.size() > 0) {
						vista.mostrarTecnicosDisponibles(this.setearComboBoxTecnicos(tecnicosDisponibles), this);
					}
					else {
						vista.mostrarMensajeDeError("Tecnicos no disponibles", "No hay tecnicos disponibles para el horario seleccionado");
					}
				}
				else {
					vista.mostrarMensajeDeError("No se pudo agendar la instalacion");
				}
			}
			else {
				vista.mostrarMensajeDeError("Cliente inexistente", "No existe el cliente ingresado");
			}
		}
		else {
			vista.mostrarMensajeDeError("Falta de Stock", "No hay stock de productos, se necesitan: (1 Evaporadora, 1 Kit, 1 Condesadora)");
		};
	}
	
	
	private DefaultComboBoxModel<EmpleadoView> setearComboBoxTecnicos(ArrayList<EmpleadoView> tecnicos) {
		DefaultComboBoxModel<EmpleadoView> comboBoxModel = new DefaultComboBoxModel<EmpleadoView>();
		for(EmpleadoView empleado : tecnicos) {
			comboBoxModel.addElement(empleado);
		}
		return comboBoxModel;
	}
	
	
	private void mostrarDatosCliente() {
		String idIngresado = this.vista.getIdCliente();
		boolean esIdValido = this.esIdValido(idIngresado);
		
		if (esIdValido) {
			long idIngresadoLong = Long.parseLong(idIngresado);
			if (this.existeCliente(idIngresadoLong)){
				ClienteView clienteView = modelo.buscarClienteToView(idIngresadoLong);
				String [] columnas = {"Cuil/Cuit", "NombreApellido", "Direccion", "Categoria", "Correo"};
				String [][] datosCliente = {{Long.toString(clienteView.getCuitCuil()), clienteView.getNombre(), clienteView.getDireccion(), 
						clienteView.getTipoCliente().toString(), clienteView.getCorreo()}};
				DefaultTableModel tableModel = new DefaultTableModel(datosCliente, columnas);
				vista.mostrarDatosCliente(tableModel);
			}
		}
	}
	

	
	
	private String booleanToString(boolean booleano) {
		if (booleano) {
			return "Si";
		}
		return "No";
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			this.mostrarDatosCliente();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	private boolean esIdValido(String idCliente) {
		try {
			Long.parseLong(vista.getIdCliente());
			return true;
		}
		catch (Exception excepcion){
			vista.mostrarMensajeDeError("Por favor ingrese solo numeros");
			return false;
		}
	}

	private boolean existeCliente(long idCliente) {
		if (!this.modelo.existeCliente(idCliente)){
			vista.mostrarMensajeDeError("Cliente inexistente", "El cliente ingresado no existe");
			return false;
		}
		return true;
	}
	
	public PanelAgendarInstalacion getVista() {
		return this.vista;
	}
	
	
}
