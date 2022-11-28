package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelos.ClienteView;
import modelos.EmpleadoView;
import modelos.Empresa;
import modelos.TecnicoView;
import vistas.PanelAgendarInstalacion;
import vistas.VistaConfig;


public class ControladorAgendarInstalacion implements ActionListener, KeyListener, MouseListener{

	//Attributes
	private PanelAgendarInstalacion vista;
	private Empresa modelo;
	
	public ControladorAgendarInstalacion(){
		this.vista = new PanelAgendarInstalacion();
		this.vista.setActionListener(this);
		this.vista.setMouseListener(this);
		this.vista.setKeyListener(this);
		this.modelo = Empresa.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "AGENDAR":
				long idCliente = this.vista.getIdClienteSeleccionado();
				this.agendarInstalacion(idCliente);
				break;
			case "CONFIRMAR_TECNICO":
				this.confirmarInstalacion();
				this.vista.cerrarVentanasEmergentes();
				this.vista.resetearPanel();
				break;
			case "ABRIR_LISTADO_CLIENTES":
				this.mostrarListadoClientes(this.modelo.getClientesView());
				break;
			case "CANCELAR":
				this.vista.resetearPanel();
				break;
		}	
	}

	private void confirmarInstalacion() {
		TecnicoView tecnicoView = this.modelo.getTecnicoView(this.vista.getIdTecnicoSeleccionado());
		ClienteView clienteView = this.modelo.getClienteView(this.vista.getIdClienteSeleccionado());
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
		Calendar fechaSeleccionada = this.vista.getFechaSeleccionada();
		
		if (hayStockDisponible) {
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
	
	/*
	private void mostrarDatosCliente() {
		
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
	*/
	
	
	
	
	private void mostrarListadoClientes(ArrayList<ClienteView> clientes) {
		DefaultTableModel tableModel = new DefaultTableModel();
		String[] columnas = {"Cuil/Cuit", "NombreApellido", "Direccion", "Categoria", "Correo"};
		tableModel.setColumnIdentifiers(columnas);
		
		for (ClienteView cv : clientes) {
			tableModel.addRow(new Object[] {cv.getCuitCuil(), cv.getNombre(), cv.getDireccion(), 
					cv.getTipoCliente(), cv.getCorreo()});
		}
		this.vista.mostrarListadoClientes(tableModel);
	}

	
	
	private String booleanToString(boolean booleano) {
		if (booleano) {
			return "Si";
		}
		return "No";
	}
		
	public PanelAgendarInstalacion getVista() {
		return this.vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		long idClienteSeleccionado = this.vista.getIdClienteSeleccionado();
		if (idClienteSeleccionado != -1) {
			ClienteView clienteView = this.modelo.getClienteView(idClienteSeleccionado);
			DefaultTableModel datosCliente = new DefaultTableModel();
			String[] columnas = {"Cuil/Cuit", "NombreApellido", "Direccion", "Categoria", "Correo"};
			datosCliente.setColumnIdentifiers(columnas);
			datosCliente.addRow(new Object [] {clienteView.getCuitCuil(), clienteView.getNombre(), clienteView.getDireccion(), clienteView.getTipoCliente(),
					clienteView.getCorreo()});
			this.vista.mostrarDatosCliente(datosCliente);
			this.vista.cerrarListadoClientes();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		ArrayList<ClienteView> clientesLikeNombre = this.modelo.buscarNombreClienteLike(this.vista.getNombreClienteIngresado());
		this.mostrarListadoClientes(clientesLikeNombre);
	}
	
	
}
