package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import modelos.Agenda;
import modelos.Cliente;
import modelos.EmpleadoView;
import modelos.Empresa;
import modelos.Instalacion;
import modelos.Tecnico;
import modelos.Turno;
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
		Cliente cliente;
		Calendar fechaSeleccionada;
		Tecnico tecnicoSeleccionado;
		boolean necesitaSoporte;
		boolean necesitaSeguro;
		switch (comandoAccionado) {
			case "AGENDAR":
				if (modelo.hayStockDisponibleParaAgendar()) {
					if (this.esIdValido(vista.getIdCliente())) {
						if (this.existeCliente(Long.parseLong(vista.getIdCliente()))){
							cliente = modelo.buscarCliente(Long.parseLong(vista.getIdCliente()));
							fechaSeleccionada = vista.getFechaSeleccionada();
							if (cliente.getAgenda().estaDisponible(new Turno(fechaSeleccionada))) {
								ArrayList<Tecnico> tecnicosDisponibles = modelo.obtenerTecnicosDisponibles(fechaSeleccionada);
								if (tecnicosDisponibles.size() > 0) {	
									DefaultComboBoxModel<EmpleadoView> comboBoxModel = new DefaultComboBoxModel<EmpleadoView>();
									for(Tecnico tecnico : tecnicosDisponibles) {
										comboBoxModel.addElement(new EmpleadoView(tecnico.getNombre(), tecnico.getId()));
										System.out.println(tecnico.getNombre() + " - " + Integer.toString(tecnico.getId()));
									}
									vista.mostrarTecnicosDisponibles(comboBoxModel, this);
								}
								else {
									vista.mostrarMensajeDeError("Tecnicos no disponibles", "No hay tecnicos disponibles para el horario seleccionado");
								}
							}
							else {
								vista.mostrarMensajeDeError("No se pudo agendar la instalacion");
							}
						}
					}
				}
				else {
					vista.mostrarMensajeDeError("Falta de Stock", "No hay stock de productos, se necesitan: (1 Evaporadora, 1 Kit, 1 Condesadora)");
				}
				break;
			case "CONFIRMAR_TECNICO":
				tecnicoSeleccionado = (Tecnico) modelo.buscarEmpleado(vista.getIdTecnicoSeleccionado());
				cliente = modelo.buscarCliente(Long.parseLong(vista.getIdCliente()));
				fechaSeleccionada = vista.getFechaSeleccionada();
				necesitaSeguro= this.vista.necesitaSeguro();
				necesitaSoporte = this.vista.necesitaSoporte();
				
				Instalacion instalacion = modelo.agendarInstalacion(cliente, tecnicoSeleccionado, fechaSeleccionada, necesitaSeguro, necesitaSoporte);
				String mensaje = "Se agendo con exito la instalacion \nCliente:  " + cliente.getNombre() + "\nTecnico:  " + tecnicoSeleccionado.getNombre() +
						"\nHorario: " + Agenda.formatearFecha(fechaSeleccionada) + "\nSeguro: " + booleanToString(necesitaSeguro) + "\nSoporte Pared: " + booleanToString(necesitaSoporte);
				vista.mostrarMensajeInformativo("Instalacion agendada con exito" , mensaje);
				this.vista.cerrarVentanasEmergentes();
				this.vista.resetearPanel();
				break;
			case "CANCELAR":
				this.vista.resetearPanel();
		}	
	}

	
	public String booleanToString(boolean booleano) {
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
			if (this.esIdValido(vista.getIdCliente())) {
				if (this.existeCliente(Long.parseLong(vista.getIdCliente()))) {
					Cliente cliente = modelo.buscarCliente(Long.parseLong(vista.getIdCliente()));
					String [] columnas = {"Cuil/Cuit", "NombreApellido", "Direccion", "Categoria", "Correo"};
					String [][] datosCliente = {{Long.toString(cliente.getCuitCuil()), cliente.getNombre(), cliente.getDireccion(), 
							cliente.getTipoCliente().toString(), cliente.getCorreoElectronico()}};
					DefaultTableModel tableModel = new DefaultTableModel(datosCliente, columnas);
					vista.mostrarDatosCliente(tableModel);
				}
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public boolean esIdValido(String idCliente) {
		try {
			Long.parseLong(vista.getIdCliente());
			return true;
		}
		catch (Exception excepcion){
			vista.mostrarMensajeDeError("Por favor ingrese solo numeros");
			return false;
		}
	}

	public boolean existeCliente(long idCliente) {
		if (modelo.buscarCliente(idCliente) == null){
			vista.mostrarMensajeDeError("El cliente ingresado no existe");
			return false;
		}
		return true;
	}
	
	public PanelAgendarInstalacion getVista() {
		return this.vista;
	}
	
	
}
