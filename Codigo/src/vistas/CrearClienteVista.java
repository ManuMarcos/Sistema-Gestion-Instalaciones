package vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelos.TipoCliente;

public class CrearClienteVista extends JFrame{
		
	private JLabel etiquetaNombre;
	private JLabel etiquetaDireccion;
	private JLabel etiquetaCorreoElectronico;
	private JLabel etiquetaCuitCuil;
	private JTextField nombreTextField;
	private JTextField direccionTextField;
	private JTextField correoElectronicoTextField;
	private JTextField cuitCuilTextField;
	private JButton crearClienteButton;
	private JButton cancelarButton;
	private JPanel panelDatos;
	private JPanel panelRadioButtons;
	private JPanel panelButtons;
	

	public CrearClienteVista(int ancho, int alto) {
		super("Crear cliente");
		setSize(ancho,alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.etiquetaNombre = new JLabel("Nombre: ");
		this.etiquetaDireccion = new JLabel("Direccion: ");
		this.etiquetaCorreoElectronico = new JLabel("Correo: ");
		this.etiquetaCuitCuil = new JLabel("Cuit/Cuil: ");
		this.nombreTextField = new JTextField(20);
		this.direccionTextField = new JTextField(20);
		this.correoElectronicoTextField = new JTextField(30);
		this.cuitCuilTextField = new JTextField(20);
		this.crearClienteButton = new JButton("Crear");
		this.cancelarButton = new JButton("Cancelar");
		
		//Panel button group
		this.panelRadioButtons = new JPanel();
		this.panelRadioButtons.setLayout(new FlowLayout());
		this.agregarRadioButtons(this.panelRadioButtons);
		
		//Panel datos
		this.panelDatos = new JPanel();
		this.panelDatos.setLayout(new GridLayout(5,2,0,5));
		this.panelDatos.add(this.etiquetaNombre);
		this.panelDatos.add(this.nombreTextField);
		this.panelDatos.add(this.etiquetaDireccion);
		this.panelDatos.add(this.direccionTextField);
		this.panelDatos.add(this.etiquetaCorreoElectronico);
		this.panelDatos.add(this.correoElectronicoTextField);
		this.panelDatos.add(etiquetaCuitCuil);
		this.panelDatos.add(cuitCuilTextField);
		this.panelDatos.add(this.panelRadioButtons);
		
		
		//Panel buttons
		this.panelButtons = new JPanel();
		this.panelButtons.setLayout(new FlowLayout());
		this.panelButtons.add(crearClienteButton);
		this.panelButtons.add(cancelarButton);
		
		Container cp = this.getContentPane();
		cp.add(this.panelDatos, BorderLayout.CENTER);
		cp.add(this.panelButtons, BorderLayout.SOUTH);

	}
	
	
	public void agregarRadioButtons(JPanel panel) {
		ButtonGroup grupoRbtn = new ButtonGroup();
		for (TipoCliente tipo : TipoCliente.values()) {
			JRadioButton rbtn = new JRadioButton(tipo.name(),false);
			grupoRbtn.add(rbtn);
			panel.add(rbtn);
		}
	}
	

	
	

	
	
	
	
	
	
	
	
	
}
