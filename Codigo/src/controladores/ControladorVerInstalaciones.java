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

public class ControladorVerInstalaciones implements ActionListener {

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
			
			break;
		case "CANCELAR": 
			
			vista.resetearPanel();
			break;
		}
	}
	
	private DefaultTableModel setearListadoDeInstalaciones() {
		DefaultTableModel tableModel = new DefaultTableModel();
		String[] columnas = { "ID", "Fecha" ,"Cliente", "Direccion", "Estado", "Evaporadoras", "Condensadoras", "Kits"};
		tableModel.setColumnIdentifiers(columnas);
		
		ArrayList<InstalacionView> instalacionesAsignadas = this.modelo.getInstalacionesAsignadas(this.empleadoLogueado.getId());
		System.out.println(instalacionesAsignadas.toString());
		
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

	public PanelVerInstalaciones getVista() {
		return this.vista;
	}

}
