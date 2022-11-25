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
import modelos.Estado;
import modelos.Instalacion;
import modelos.Tecnico;
import modelos.Turno;
import vistas.PanelModificarInstalacion;


public class ControladorModificarInstalacion implements ActionListener, KeyListener{

	//Attributes
	private PanelModificarInstalacion vista;
	private Empresa modelo;
	
	public ControladorModificarInstalacion(){
		this.vista = new PanelModificarInstalacion();
		this.vista.setActionListener(this);
		this.vista.setKeyListener(this);
		this.modelo = Empresa.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "FINALIZAR":
				
				if (this.esIdValido(vista.getIdInstalacion())) {
					if (modelo.esIdDeInstalacionExistente(Integer.parseInt(vista.getIdInstalacion())) ) {
						if (modelo.completarInstalacion(Integer.parseInt(vista.getIdInstalacion()), vista.getFechaInicioSeleccionada(), vista.getFechaFinalizacionSeleccionada(), vista.tecnicoAlmorzo(), Integer.parseInt(vista.getCantidadDeEvaporadoras()), Integer.parseInt(vista.getCantidadDeKits()), Integer.parseInt(vista.getCantidadDeCondensadoras())) == false) {
							vista.mostrarMensajeDeError("No se pudo completar la instalacion");
						}
					}
				} else {
					vista.mostrarMensajeDeError("No se puede finalizar una instalación no válida. Utilice sólo números.");
				}
				

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
			if (this.esIdValido(vista.getIdInstalacion())) {
				if (this.existeInstalacion(Integer.parseInt(vista.getIdInstalacion()))) {
					Instalacion instalacion = modelo.buscarInstalacion(Integer.parseInt(vista.getIdInstalacion()));
					String [] columnas = {"ID", "Cliente", "Direccion", "Estado"};
					String [][] datosInstalacion = {{Integer.toString(instalacion.getId()), instalacion.getCliente().getNombre(), instalacion.getCliente().getDireccion(), instalacion.getEstado().toString()}};
					DefaultTableModel tableModel = new DefaultTableModel(datosInstalacion, columnas);
					vista.mostrarDatosInstalacion(tableModel);
				}
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public boolean esIdValido(String idInstalacion) {
		try {
			Integer.parseInt(vista.getIdInstalacion());
			return true;
		}
		catch (Exception excepcion){
			vista.mostrarMensajeDeError("Por favor ingrese solo numeros");
			return false;
		}
	}

	//No funciona y no se por que :P
	public boolean existeInstalacion(int idInstalacion) {
		if (modelo.esIdDeInstalacionExistente(idInstalacion) == false){
			vista.mostrarMensajeDeError("La instalación ingresada no existe");
			return false;
		}
		return true;
	}
	
	public PanelModificarInstalacion getVista() {
		return this.vista;
	}
	
	
}
