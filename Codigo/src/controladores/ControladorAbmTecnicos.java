package controladores;


import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelos.Empresa;
import modelos.TecnicoView;
import vistas.PanelAbmTecnicos;

public class ControladorAbmTecnicos {

	//Attributes
	private PanelAbmTecnicos vista;
	private Empresa modelo;
	
	//Methods
	public ControladorAbmTecnicos() {
		this.vista = new PanelAbmTecnicos();
		this.modelo = Empresa.getInstance();
		this.cargarListadoTecnicos();
	}
	
	private void cargarListadoTecnicos() {
		DefaultTableModel modeloTablaTecnicos = new DefaultTableModel() {
			@Override
			   public boolean isCellEditable(int row, int column) {
			       int []columnasNoEditables = {this.findColumn("Id"), this.findColumn("Turno"), this.findColumn("Experiencia Laboral")};
			       for (int i : columnasNoEditables) {
			    	   if (i == column) {
			    		   return false;
			    	   }
			       }
			       return true;
			   }
		};
		
		String[] columnas = {"Id","Nombre","Direccion","Turno", "Experiencia Laboral","Usuario","Contraseña"};
		modeloTablaTecnicos.setColumnIdentifiers(columnas);
		
		ArrayList<TecnicoView> tecnicos = this.modelo.getTecnicosView();
		for (TecnicoView tecnicoView : tecnicos) {
			modeloTablaTecnicos.addRow(new Object[] {tecnicoView.getId(), tecnicoView.getNombreApellido(), tecnicoView.getDireccion(), tecnicoView.getTurnoLaboral(),
					tecnicoView.getExperienciaLaboral(),tecnicoView.getUsuario(), tecnicoView.getContrasena()});
		}
		this.vista.setListadoTecnicos(modeloTablaTecnicos);
		
	}
	
	public PanelAbmTecnicos getVista() {
		return this.vista;
	}
	
	
	
}
