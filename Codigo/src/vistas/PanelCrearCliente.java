package vistas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;

public class PanelCrearCliente extends Panel {

	private JTextField textFieldNombreApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldCuitCuil;
	private JTextField textFieldCorreo;
	private ButtonGroup buttonGroupTipoCliente;
	private JLabel labelNombreApellido ;
	private JLabel labelDireccion;
	private JLabel labelCuitCuil;
	private JLabel labelCorreoElectronico;
	private JLabel labelTipoCliente;
	private JPanel panelCrearCliente;
	private JPanel panelNombreApellido;
	private JPanel panelDireccion;
	private JPanel panelCuitCuil;
	private JPanel panelCorreoElectronico;
	private JPanel panelTipoCliente;
	private JPanel panelBotones;
	private JRadioButton radioButtonIndividuo;
	private JRadioButton radioButtonEmpresa;
	private JButton buttonCrearCliente;
	private JButton buttonCancelar;
	
	
	public PanelCrearCliente() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarTextFields();
		this.agregarRadioButtons();
		this.agregarBotones();
	}


	private void agregarTextFields() {
		
		//Nombre apellido
		this.textFieldNombreApellido = new JTextField();
		this.panelNombreApellido.add(textFieldNombreApellido);
		this.textFieldNombreApellido.setColumns(40);
		
		//Direccion
		this.textFieldDireccion = new JTextField();
		this.panelDireccion.add(textFieldDireccion);
		this.textFieldDireccion.setColumns(40);
		
		//Cuit Cuil
		this.textFieldCuitCuil= this.crearTextFieldFormatoTexto(11);
		this.panelCuitCuil.add(textFieldCuitCuil);
		
		//Correo Electronico
		this.textFieldCorreo = new JTextField();
		this.panelCorreoElectronico.add(textFieldCorreo);
		this.textFieldCorreo.setColumns(40);
	}
	
	private void agregarPaneles() {
		
		//Panel Principal
		this.panelCrearCliente= new JPanel();
		panelCrearCliente.setOpaque(false);
		this.setBordePanel(panelCrearCliente, "Crear Cliente");
		add(panelCrearCliente);
		panelCrearCliente.setLayout(new GridLayout(6, 0, 0, 0));
		
		//Panel Nombre Apellido
		this.panelNombreApellido= new JPanel();
		panelNombreApellido.setOpaque(false);
		FlowLayout fl_panelNombreApellido = (FlowLayout) panelNombreApellido.getLayout();
		fl_panelNombreApellido.setAlignment(FlowLayout.LEFT);
		panelCrearCliente.add(panelNombreApellido);
		
		//Panel Direccion
		this.panelDireccion= new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDireccion.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDireccion.setOpaque(false);
		panelCrearCliente.add(panelDireccion);
		
		//Panel CuitCuil
		this.panelCuitCuil= new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelCuitCuil.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCuitCuil.setOpaque(false);
		panelCrearCliente.add(panelCuitCuil);
		
		//Panel Correo Electronico
		this.panelCorreoElectronico= new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelCorreoElectronico.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelCorreoElectronico.setOpaque(false);
		panelCrearCliente.add(panelCorreoElectronico);
		
		
		//Panel Tipo Cliente
		this.panelTipoCliente =  new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelTipoCliente.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelTipoCliente.setOpaque(false);
		panelCrearCliente.add(panelTipoCliente);
		
		//Panel Botones
		this.panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelCrearCliente.add(panelBotones);
	}
	
	
	private void agregarEtiquetas() {
		
		//Nombre Apellido
		this.labelNombreApellido= this.crearEtiquetaFormateada("Nombre y Apellido");
		panelNombreApellido.add(labelNombreApellido);
		
		//Direccion
		this.labelDireccion= this.crearEtiquetaFormateada("Direccion");
		panelDireccion.add(labelDireccion);
		
		//CuitCuil
		this.labelCuitCuil= this.crearEtiquetaFormateada("Cuit/Cuil");
		panelCuitCuil.add(labelCuitCuil);
		
		//Correo Electronico
		this.labelCorreoElectronico= this.crearEtiquetaFormateada("Correo Electronico");
		panelCorreoElectronico.add(labelCorreoElectronico);
		
		//Tipo Cliente
		this.labelTipoCliente= this.crearEtiquetaFormateada("Tipo de cliente");
		panelTipoCliente.add(labelTipoCliente);
	}
	
	private void agregarRadioButtons() {
		this.buttonGroupTipoCliente = new ButtonGroup();
		
		//Individuo
		this.radioButtonIndividuo = new JRadioButton("Individuo");
		this.radioButtonIndividuo.setActionCommand("INDIVIDUO");
		radioButtonIndividuo.setFont(this.getFuentaEtiqueta());
		radioButtonIndividuo.setOpaque(false);
		buttonGroupTipoCliente.add(radioButtonIndividuo);
		panelTipoCliente.add(radioButtonIndividuo);
		
		//Empresa
		this.radioButtonEmpresa = new JRadioButton("Empresa");
		this.radioButtonEmpresa.setActionCommand("EMPRESA");
		radioButtonEmpresa.setOpaque(false);
		radioButtonEmpresa.setFont(this.getFuentaEtiqueta());
		buttonGroupTipoCliente.add(radioButtonEmpresa);
		panelTipoCliente.add(radioButtonEmpresa);
		
		this.buttonGroupTipoCliente.setSelected(this.radioButtonIndividuo.getModel(), true);
	}
	
	@Override
	public void setActionListener(ActionListener controlador) {
		this.buttonCrearCliente.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	
	private void agregarBotones() {
		this.buttonCrearCliente = this.crearBotonFormateado("Crear Cliente", "CREAR_CLIENTE");
		panelBotones.add(buttonCrearCliente);
		
		this.buttonCancelar = this.crearBotonFormateado("Limpiar", "LIMPIAR");
		panelBotones.add(buttonCancelar);
	}
	
	public String getNombreApellido() {
		return this.textFieldNombreApellido.getText();
	}
	
	public String getCuitCuil() {
		return this.textFieldCuitCuil.getText();
	}
	
	public String getCorreoElectronico() {
		return this.textFieldCorreo.getText();
	}
	
	public String getTipoCliente() {
		return this.buttonGroupTipoCliente.getSelection().getActionCommand();
	}
	
	public String getDireccion() {
		return this.textFieldDireccion.getText();
	}
	
	
	
	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		this.textFieldNombreApellido.setText(null);
		this.textFieldCuitCuil.setText(null);
		this.textFieldDireccion.setText(null);
		this.textFieldCorreo.setText(null);
		this.buttonGroupTipoCliente.clearSelection();
	}


	@Override
	public void setKeyListener(KeyListener controlador) {
		// TODO Auto-generated method stub
		
	}
	
	

}
