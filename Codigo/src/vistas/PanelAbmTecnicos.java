package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;

public class PanelAbmTecnicos extends Panel {
	private JPanel panelPrincipal;
	private JPanel panelSuperior;
	private JLabel labelBuscarTecnico;
	private JPanel panelCentral;
	private JTable tablaTecnicos;
	private JScrollPane scrollPaneTablaTecnicos;
	private JPanel panelBuscarTecnico;
	private JPanel panelNuevoTecnico;
	private JTextField textFieldBuscarTecnico;
	private JButton buttonNuevoTecnico;
	
	
	public PanelAbmTecnicos() {
		setLayout(new BorderLayout(0, 0));
		
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarTextFields();
		this.agregarTabla();
		
		this.setBordePanel("ABM Tecnicos");
	}
	
	
	public void setListadoTecnicos(DefaultTableModel listadoTecnicos) {
		this.tablaTecnicos.setModel(listadoTecnicos);
		this.tablaTecnicos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	}
	
	private void agregarEtiquetas() {
		labelBuscarTecnico = this.crearEtiquetaFormateada("Buscar tecnico");
		labelBuscarTecnico.setHorizontalAlignment(SwingConstants.LEFT);
		panelBuscarTecnico.add(labelBuscarTecnico);
	}
	
	private void agregarPaneles() {
		this.panelPrincipal= new JPanel();
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.panelSuperior= new JPanel();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		this.panelCentral= new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		this.panelBuscarTecnico = new JPanel();
		panelSuperior.add(panelBuscarTecnico, BorderLayout.CENTER);

		panelNuevoTecnico = new JPanel();
		panelSuperior.add(panelNuevoTecnico, BorderLayout.EAST);
		
		buttonNuevoTecnico = this.crearBotonFormateado("Nuevo Tecnico", "NUEVO_TECNICO");
		panelNuevoTecnico.add(buttonNuevoTecnico);
	}
	
	private void agregarTextFields() {
		panelBuscarTecnico.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textFieldBuscarTecnico = new JTextField();
		textFieldBuscarTecnico.setColumns(40);
		panelBuscarTecnico.add(textFieldBuscarTecnico);
		
		
	}
	
	private void agregarTabla() {
		this.tablaTecnicos= new JTable();
		this.scrollPaneTablaTecnicos = new JScrollPane(tablaTecnicos);
		panelCentral.add(scrollPaneTablaTecnicos);
	}
	
	
	
	
	
	

	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setActionListener(ActionListener controlador) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}

}
