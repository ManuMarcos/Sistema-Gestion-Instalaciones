package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorAbmTecnicos;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;

public class PanelAbmTecnicos extends Panel {
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JTable tablaTecnicos;
	private JScrollPane scrollPaneTablaTecnicos;
	private JPanel panelHeaderListado;
	private JPanel panelBotones;
	private JButton buttonNuevoTecnico;
	private JButton buttonCostoHoras;
	private DialogoDatosTecnico dialogoDatosTecnico;
	private DialogoCostoHoras dialogoCostoHoras;
	
	
	
	public PanelAbmTecnicos() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.WHITE);
		
		this.agregarPaneles();
		this.agregarTabla();
		this.agregarBotones();
		this.iniciarDialogoDatosTecnico();
		this.iniciarDialogoCostoHoras();
		
		this.setBordePanel("ABM Tecnicos");
	}
	
	
	public void setListadoTecnicos(DefaultTableModel listadoTecnicos) {
		this.tablaTecnicos.setModel(listadoTecnicos);
		this.tablaTecnicos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}
	
	public void setComboTurnoLaboral(DefaultComboBoxModel<String> modeloTurnoLaboral) {
		this.dialogoDatosTecnico.setComboBoxTurnoLaboral(modeloTurnoLaboral);
	}
	
	public void setComboExpLaboral(DefaultComboBoxModel<String> modeloExpLaboral) {
		this.dialogoDatosTecnico.setComboBoxExpLaboral(modeloExpLaboral);
	}
	
	
	private void agregarPaneles() {
		this.panelPrincipal= new JPanel();
		panelPrincipal.setOpaque(false);
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.panelSuperior= new JPanel();
		panelSuperior.setOpaque(false);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		this.panelCentral= new JPanel();
		panelCentral.setOpaque(false);
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		this.panelHeaderListado = new JPanel();
		panelHeaderListado.setOpaque(false);
		panelSuperior.add(panelHeaderListado, BorderLayout.CENTER);
		panelHeaderListado.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelSuperior.add(panelBotones, BorderLayout.EAST);
	}
	
	private void agregarBotones() {
		buttonNuevoTecnico = this.crearBotonFormateado("Nuevo Tecnico", "NUEVO_TECNICO");
		panelBotones.add(buttonNuevoTecnico);
		
		buttonCostoHoras = this.crearBotonFormateado("Costo Horas", "COSTO_HORAS");
		panelBotones.add(buttonCostoHoras);
	}
	
	private void iniciarDialogoDatosTecnico() {
		JFrame framePadre = (JFrame) SwingUtilities.getWindowAncestor(this);
		this.dialogoDatosTecnico = new DialogoDatosTecnico(framePadre, true);
		dialogoDatosTecnico.setLocationRelativeTo(this);
	}
	
	public void cerrarDialogoDatosTecnico() {
		dialogoDatosTecnico.cerrar();
	}
	
	private void iniciarDialogoCostoHoras() {
		JFrame framePadre = (JFrame) SwingUtilities.getWindowAncestor(this);
		this.dialogoCostoHoras = new DialogoCostoHoras(framePadre, true);
		dialogoCostoHoras.setLocationRelativeTo(this);
	}
	
	public void cerrarDialogoCostoHoras() {
		dialogoCostoHoras.cerrar();
	}
	
		
	public void mostrarDatosTecnico(int id, String nombreApellido, String direccion, String usuario, String contrasena, 
			String turnoLaboral, String expLaboral) {
		dialogoDatosTecnico.setearDatosTecnico(id, nombreApellido, direccion, usuario, contrasena, turnoLaboral, expLaboral);
	}
	
	public void pedirDatosTecnico() {
		dialogoDatosTecnico.pedirDatosTecnico();
	}
	
	private void agregarTabla() {
		this.tablaTecnicos= new JTable();
		this.tablaTecnicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPaneTablaTecnicos = new JScrollPane(tablaTecnicos);
		panelCentral.add(scrollPaneTablaTecnicos);
	}
	
	public int getIdFilaSeleccionada() {
		int filaSeleccionada = this.tablaTecnicos.getSelectedRow();
		if (filaSeleccionada != -1) {
			//Se retorna la columna 0 (id) de la fila seleccionada
			return (int) this.tablaTecnicos.getValueAt(filaSeleccionada, 0);
		}
		return -1;
	}
	
	

	public void setMouseListener(MouseListener controlador) {
		this.tablaTecnicos.addMouseListener(controlador);
	}
	
	public String getNombreTecnico() {
		return this.dialogoDatosTecnico.getNombreApellido();
	}
	
	public String getUsuarioTecnico() {
		return this.dialogoDatosTecnico.getUsuario();
	}
	
	public String getDireccionTecnico() {
		return this.dialogoDatosTecnico.getDireccion();
	}
	
	public String getContrasenaTecnico() {
		return this.dialogoDatosTecnico.getContrasena();
	}
	
	public String getExpLaboral() {
		return this.dialogoDatosTecnico.getExpLaboral();
	}
	
	public String getTurnoLaboral() {
		return this.dialogoDatosTecnico.getTurnoLaboral();
	}
	
	public String getId() {
		return this.dialogoDatosTecnico.getId();
	}
	
	public String getCostoJunior() {
		return this.dialogoCostoHoras.getCostoJunior();
	}
	
	public String getCostoSemiSenior() {
		return this.dialogoCostoHoras.getCostoSemiSenior();
	}
	
	public String getCostoSenior() {
		return this.dialogoCostoHoras.getCostoSenior();
	}
	
	public void setCostosHoras(String costoJunior, String costoSemiSenior, String costoSenior) {
		this.dialogoCostoHoras.setCostos(costoJunior, costoSemiSenior, costoSenior);
	}
	

	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		this.buttonNuevoTecnico.addActionListener(controlador);
		this.buttonCostoHoras.addActionListener(controlador);
		dialogoDatosTecnico.setActionListener(controlador);
		dialogoCostoHoras.setActionListener(controlador);
	}

	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
	}

}
