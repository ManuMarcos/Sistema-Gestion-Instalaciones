package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorAbmTecnicos;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class DialogoDatosTecnico extends JDialog {

	//Attributes
	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JTextField textFieldId;
	private JTextField textFieldNombreApellido;
	private JTextField textFieldDireccion;
	private JTextField textFieldContrasena;
	private JTextField textFieldUsuario;
	private JPanel panelId;
	private JPanel panelNombreApellido;
	private JPanel panelTurnoLaboral ;
	private JPanel panelExperienciaLaboral;
	private JPanel panelDireccion;
	private JPanel panelUsuario;
	private JPanel panelContrasena;
	private JPanel panelBotones;
	private JLabel labelId;
	private JLabel labelNombreApellido;
	private JLabel labelTurnoLaboral;
	private JLabel labelExpLaboral;
	private JLabel labelDireccion;
	private JLabel labelUsuario;
	private JLabel labelContrasena;
	private JComboBox<String> comboBoxExpLaboral;
	private JComboBox<String> comboBoxTurnoLaboral;
	private JButton buttonConfirmar;
	private JButton buttonCancelar;
	private JButton buttonEliminar;
	
	
	//Methods
	
	public DialogoDatosTecnico(JFrame framePadre, boolean esModal) {
		super(framePadre, esModal);
		setBounds(100, 100, 638, 410);
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		this.setBackground(Color.WHITE);
		this.setTitle("Datos tecnico");
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarTextFields();
		this.agregarComboBoxes();
		this.agregarBotones();
	}

	private void agregarEtiquetas() {
		
		this.labelId = new JLabel("Id");
		this.labelId.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelId.add(labelId);
		
		
		this.labelNombreApellido = new JLabel("Nombre y Apellido");
		this.labelNombreApellido.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelNombreApellido.add(labelNombreApellido);
		
		this.labelTurnoLaboral = new JLabel("Turno laboral");
		this.labelTurnoLaboral.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelTurnoLaboral.add(labelTurnoLaboral);
		
		this.labelExpLaboral = new JLabel("Experiencia laboral");
		this.labelExpLaboral.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelExperienciaLaboral.add(labelExpLaboral);
		
		this.labelDireccion = new JLabel("Direccion");
		this.labelDireccion.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelDireccion.add(labelDireccion);
		
		this.labelUsuario = new JLabel("Usuario");
		this.labelUsuario.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelUsuario.add(labelUsuario);
		
		this.labelContrasena = new JLabel("Contraseña");
		this.labelContrasena.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		panelContrasena.add(labelContrasena);
	}
	
	private void agregarTextFields() {
		panelId.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textFieldId = VistaConfig.crearTextFieldFormateado(15);
		textFieldId.setEditable(false);
		panelId.add(textFieldId);
		
		textFieldNombreApellido = VistaConfig.crearTextFieldFormateado(30);
		panelNombreApellido.add(textFieldNombreApellido);
		
		textFieldDireccion = VistaConfig.crearTextFieldFormateado(30);
		panelDireccion.add(textFieldDireccion);
		
		textFieldUsuario = VistaConfig.crearTextFieldFormateado(30);
		panelUsuario.add(textFieldUsuario);
		
		textFieldContrasena = VistaConfig.crearTextFieldFormateado(30);
		panelContrasena.add(textFieldContrasena);
	}
	
	private void agregarBotones() {
		this.buttonConfirmar= VistaConfig.crearBotonFormateado("Confirmar", "DINAMICO");
		panelBotones.add(buttonConfirmar);
	
		this.buttonCancelar = VistaConfig.crearBotonFormateado("Cancelar", "CANCELAR");
		panelBotones.add(buttonCancelar);
		
		this.buttonEliminar = VistaConfig.crearBotonFormateado("Eliminar", "ELIMINAR_TECNICO");
		this.buttonEliminar.setBackground(Color.RED);
		panelBotones.add(buttonEliminar);
	}
	
	public void setearDatosTecnico(int id, String nombreApellido, String direccion, String usuario, String contrasena, String turnoLaboral, String expLaboral) {
		this.textFieldId.setText(Integer.toString(id));
		this.textFieldNombreApellido.setText(nombreApellido);
		this.textFieldDireccion.setText(direccion);
		this.textFieldUsuario.setText(usuario);
		this.textFieldContrasena.setText(contrasena);
		this.comboBoxTurnoLaboral.setSelectedItem(turnoLaboral);
		this.comboBoxExpLaboral.setSelectedItem(expLaboral);
		this.buttonEliminar.setVisible(true);
		this.buttonConfirmar.setActionCommand("MODIFICAR_TECNICO");
		this.setVisible(true);
	}
	
	public void setComboBoxExpLaboral(DefaultComboBoxModel<String> modeloExpLaboral) {
		this.comboBoxExpLaboral.setModel(modeloExpLaboral);
	}
	
	public void setComboBoxTurnoLaboral(DefaultComboBoxModel<String> modeloTurnoLaboral) {
		this.comboBoxTurnoLaboral.setModel(modeloTurnoLaboral);
	}
	
	
	private void agregarComboBoxes() {
		this.comboBoxTurnoLaboral= new JComboBox<String>();
		panelTurnoLaboral.add(comboBoxTurnoLaboral);
		
		this.comboBoxExpLaboral= new JComboBox<String>();
		comboBoxExpLaboral.setOpaque(false);
		panelExperienciaLaboral.add(comboBoxExpLaboral);
	}
	
	public void setActionListener(ActionListener controlador) {
		this.buttonConfirmar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
		this.buttonEliminar.addActionListener(controlador);
	}
	
	public void cerrar() {
		this.setVisible(false);
		this.limpiarDatos();
	}
	
	private void limpiarDatos() {
		this.textFieldId.setText("Asignado por el sistema");
		this.textFieldNombreApellido.setText(null);
		this.textFieldDireccion.setText(null);
		this.textFieldContrasena.setText(null);
		this.textFieldUsuario.setText(null);
		this.comboBoxExpLaboral.setSelectedIndex(0);
		this.comboBoxTurnoLaboral.setSelectedIndex(0);
		this.buttonEliminar.setVisible(false);
	}
	
	public void pedirDatosTecnico() {
		this.buttonConfirmar.setActionCommand("CREAR_TECNICO");
		this.limpiarDatos();
		this.setVisible(true);
	}
	
	private void agregarPaneles() {
		
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(7, 1, 0, 0));
		
		this.panelId= new JPanel();
		panelId.setOpaque(false);
		panelPrincipal.add(panelId);
		
		this.panelNombreApellido= new JPanel();
		panelNombreApellido.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelNombreApellido.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelNombreApellido);
		
		this.panelTurnoLaboral= new JPanel();
		panelTurnoLaboral.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panelTurnoLaboral.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelTurnoLaboral);
		
		this.panelExperienciaLaboral= new JPanel();
		panelExperienciaLaboral.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panelExperienciaLaboral.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelExperienciaLaboral);
		
		this.panelDireccion= new JPanel();
		panelDireccion.setOpaque(false);
		FlowLayout flowLayout_4 = (FlowLayout) panelDireccion.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelDireccion);
		
		this.panelUsuario= new JPanel();
		panelUsuario.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panelUsuario.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelUsuario);
		
		this.panelContrasena= new JPanel();
		panelContrasena.setOpaque(false);
		FlowLayout flowLayout_6 = (FlowLayout) panelContrasena.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panelPrincipal.add(panelContrasena);
		
		this.panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
	}
	
	public String getNombreApellido() {
		return this.textFieldNombreApellido.getText();
	}
	
	public String getDireccion() {
		return this.textFieldDireccion.getText();
	}
	
	public String getUsuario() {
		return this.textFieldUsuario.getText();
	}
	
	public String getContrasena() {
		return this.textFieldContrasena.getText();
	}
	
	public String getTurnoLaboral() {
		return this.comboBoxTurnoLaboral.getSelectedItem().toString();
	}
	
	public String getExpLaboral() {
		return this.comboBoxExpLaboral.getSelectedItem().toString();
	}

	public String getId() {
		return this.textFieldId.getText();
	}
	
	
	
	
	
	

}
