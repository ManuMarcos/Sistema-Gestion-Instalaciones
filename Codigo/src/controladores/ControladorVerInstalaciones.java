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
import modelos.InstalacionView;
import modelos.Tecnico;
import modelos.Turno;
import vistas.PanelVerInstalaciones;
import vistas.VistaConfig;

public class ControladorVerInstalaciones implements ActionListener, KeyListener {

	// Attributes
	private PanelVerInstalaciones vista;
	private Empresa modelo;
	private EmpleadoView empleadoLogueado;

	public ControladorVerInstalaciones(EmpleadoView empleadoLogueado) {
		this.vista = new PanelVerInstalaciones();
		this.vista.setActionListener(this);
		this.modelo = Empresa.getInstance();
		this.empleadoLogueado =  empleadoLogueado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
		case "ACTUALIZAR":
			vista.mostrarDatosInstalacion(this.setearListadoDeInstalaciones());
			//ELIMINAR
			this.modelo.imprimirFacturas();
			break;
			
		case "CANCELAR": 
			
			vista.resetearPanel();
		}
	}
	
	private DefaultTableModel setearListadoDeInstalaciones() {
		DefaultTableModel tableModel = new DefaultTableModel();
		String[] columnas = { "ID", "Fecha" ,"Cliente", "Direccion", "Estado", "Evaporadoras", "Condensadoras", "Kits"};
		tableModel.setColumnIdentifiers(columnas);
		
		ArrayList<InstalacionView> instalacionesAsignadas = this.modelo.getInstalacionesAsignadas(this.empleadoLogueado.getId());
		
		for (InstalacionView instalacion : instalacionesAsignadas) {
			tableModel.addRow(new Object[] {instalacion.getId(), VistaConfig.formatearFecha(instalacion.getHoraInicio()), instalacion.getClienteView().getNombre(), 
					instalacion.getClienteView().getDireccion(), instalacion.getEstado(),instalacion.getElementosUtilizados().get("Evaporadora"), 
					instalacion.getElementosUtilizados().get("Condensadora"), instalacion.getElementosUtilizados().get("KitDeInstalacion"), });
		}
		return tableModel;
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

			String[] columnas = { "ID", "Cliente", "Direccion", "Estado", "Elementos" };
			DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
			for (int i = 0; i < modelo.instalacionesAsignadasATecnico(1).size(); i++) {
				int id = modelo.instalacionesAsignadasATecnico(1).get(i).getId();
				String cliente = modelo.instalacionesAsignadasATecnico(1).get(i).getCliente().getNombre();
				String direccion = modelo.instalacionesAsignadasATecnico(1).get(i).getCliente().getDireccion();
				Estado estado = modelo.instalacionesAsignadasATecnico(1).get(i).getEstado();
				String cantidadElementos = modelo.instalacionesAsignadasATecnico(1).get(i).getElementos().toString();

				Object[] filas = { id, cliente, direccion, estado, cantidadElementos };
				tableModel.addRow(filas);
			}

			vista.mostrarDatosInstalacion(tableModel);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	// No funciona y no se por que :P
	public boolean existeInstalacion(int idInstalacion) {
		if (modelo.esIdDeInstalacionExistente(idInstalacion) == false) {
			vista.mostrarMensajeDeError("La instalación ingresada no existe");
			return false;
		}
		return true;
	}

	public PanelVerInstalaciones getVista() {
		return this.vista;
	}

}
