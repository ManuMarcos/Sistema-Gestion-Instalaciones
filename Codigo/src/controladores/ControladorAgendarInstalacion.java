package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelos.Cliente;
import modelos.Empresa;
import modelos.Persona;
import modelos.Tecnico;
import modelos.Turno;
import vistas.AgendarInstalacionDialog;
import vistas.VentanaAgendarInstalacion;

public class ControladorAgendarInstalacion implements ActionListener, KeyListener{

	private VentanaAgendarInstalacion vista;
	private Empresa modelo;
	
	public ControladorAgendarInstalacion() {
		this.vista = new VentanaAgendarInstalacion();
		this.modelo = Empresa.getInstance();
		this.vista.setVisible(true);
		this.vista.setControladorDeEventos(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "AGENDAR":
				if (this.esIdValido(vista.getIdCliente())) {
					if (this.existeCliente(Long.parseLong(vista.getIdCliente()))){
						Cliente cliente = modelo.buscarCliente(Long.parseLong(vista.getIdCliente()));
						Calendar fechaSeleccionada = vista.getFechaSeleccionada();
						if (cliente.getAgenda().estaDisponible(new Turno(fechaSeleccionada))) {
							ArrayList<String> nombreTecnicosDisponibles = modelo.getNombresTecnicos(modelo.obtenerTecnicosDisponibles(fechaSeleccionada));
							if (nombreTecnicosDisponibles.size() > 0) {
								vista.mostrarTecnicosDisponibles(nombreTecnicosDisponibles);
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
				break;
			case "CANCELAR":
				System.out.println("CANCELAR");
				break;
		}
		
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
			long idClienteToLong = Long.parseLong(vista.getIdCliente());
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
	
	
	
	
	
	
	
	
}
