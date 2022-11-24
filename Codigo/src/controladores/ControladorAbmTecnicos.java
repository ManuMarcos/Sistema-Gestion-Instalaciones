package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import modelos.Empleado;
import modelos.Empresa;
import modelos.Junior;
import modelos.SemiSenior;
import modelos.Senior;
import modelos.TecnicoView;
import modelos.TurnoCompleto;
import modelos.TurnoManana;
import modelos.TurnoTarde;
import vistas.PanelAbmTecnicos;

public class ControladorAbmTecnicos implements MouseListener, ActionListener{

	//Attributes
	private PanelAbmTecnicos vista;
	private Empresa modelo;
	
	//Methods
	public ControladorAbmTecnicos() {
		this.vista = new PanelAbmTecnicos();
		this.modelo = Empresa.getInstance();
		this.cargarListadoTecnicos();
		this.setComboExpLaboral();
		this.setComboTurnoLaboral();
		this.vista.setMouseListener(this);
		this.vista.setActionListener(this);
	}
	
	private void cargarListadoTecnicos() {
		DefaultTableModel modeloTablaTecnicos = new DefaultTableModel();
		
		String[] columnas = {"Id","Nombre","Direccion","Turno", "Experiencia Laboral","Usuario","Contraseña"};
		modeloTablaTecnicos.setColumnIdentifiers(columnas);
		
		ArrayList<TecnicoView> tecnicos = this.modelo.getTecnicosView();
		for (TecnicoView tecnicoView : tecnicos) {
			modeloTablaTecnicos.addRow(new Object[] {tecnicoView.getId(), tecnicoView.getNombreApellido(), tecnicoView.getDireccion(), tecnicoView.getTurnoLaboral(),
					tecnicoView.getExperienciaLaboral(),tecnicoView.getUsuario(), tecnicoView.getContrasena()});
		}
		this.vista.setListadoTecnicos(modeloTablaTecnicos);
		
		
	}
	
	private void setComboExpLaboral() {
		DefaultComboBoxModel<String> comboExpLaboral = new DefaultComboBoxModel<String>();
		comboExpLaboral.addElement(Junior.class.getSimpleName());
		comboExpLaboral.addElement(SemiSenior.class.getSimpleName());
		comboExpLaboral.addElement(Senior.class.getSimpleName());
		this.vista.setComboExpLaboral(comboExpLaboral);
	}
	
	private void setComboTurnoLaboral() {
		DefaultComboBoxModel<String> comboTurnoLaboral = new DefaultComboBoxModel<String>();
		comboTurnoLaboral.addElement(TurnoManana.class.getSimpleName());
		comboTurnoLaboral.addElement(TurnoTarde.class.getSimpleName());
		comboTurnoLaboral.addElement(TurnoCompleto.class.getSimpleName());
		this.vista.setComboTurnoLaboral(comboTurnoLaboral);
	}
	
	public PanelAbmTecnicos getVista() {
		return this.vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int idFilaSeleccionada = this.vista.getIdFilaSeleccionada();
		if (idFilaSeleccionada != -1) {
			TecnicoView tecnico = modelo.getTecnicoView(idFilaSeleccionada);
			this.vista.mostrarDatosTecnico(tecnico.getId(), tecnico.getNombreApellido(), tecnico.getDireccion(), tecnico.getUsuario(), tecnico.getContrasena(), 
					tecnico.getTurnoLaboral(), tecnico.getExperienciaLaboral());
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "NUEVO_TECNICO":
				this.vista.pedirDatosTecnico();
				break;
			case "CREAR_TECNICO":
				TecnicoView tecnico = this.modelo.crearTecnico(this.vista.getNombreTecnico(), this.vista.getDireccionTecnico(), this.vista.getTurnoLaboral(), this.vista.getUsuarioTecnico(), 
						this.vista.getContrasenaTecnico(), this.vista.getExpLaboral());
				
				String mensaje = "Se creo el siguiente tecnico: \nNombre: " + tecnico.getNombreApellido() + "\nDireccion: " + tecnico.getDireccion() + "\nTurno Laboral: " + 
						tecnico.getTurnoLaboral() + "\nExperiencia Laboral: " + tecnico.getExperienciaLaboral() + "\nUsuario: " + tecnico.getUsuario() + "\nContrasena: " + tecnico.getContrasena();
				
				this.vista.mostrarMensajeInformativo("Tecnico creado con exito", mensaje);
				this.vista.cerrarDialogoDatosTecnico();
				this.cargarListadoTecnicos();
				break;
			case "CANCELAR":
				this.vista.cerrarDialogoDatosTecnico();
		}
	}
	
	
	
}
