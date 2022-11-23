package vistas;

import java.awt.FlowLayout;
import java.awt.GridLayout;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelCrearCliente() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));

		JPanel panelCrearCliente = new JPanel();
		panelCrearCliente.setOpaque(false);
		this.setBordePanel(panelCrearCliente, "Crear Cliente");
		add(panelCrearCliente);
		panelCrearCliente.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panelNombreApellido = new JPanel();
		panelNombreApellido.setOpaque(false);
		FlowLayout fl_panelNombreApellido = (FlowLayout) panelNombreApellido.getLayout();
		fl_panelNombreApellido.setAlignment(FlowLayout.LEFT);
		panelCrearCliente.add(panelNombreApellido);
		
		JLabel labelNombreApellido = this.crearEtiquetaFormateada("Nombre y Apellido");
		panelNombreApellido.add(labelNombreApellido);
		
		this.textFieldNombreApellido = new JTextField();
		panelNombreApellido.add(textFieldNombreApellido);
		textFieldNombreApellido.setColumns(40);
		
		JPanel panelDireccion = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDireccion.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDireccion.setOpaque(false);
		panelCrearCliente.add(panelDireccion);
		
		JLabel labelDireccion = this.crearEtiquetaFormateada("Direccion");
		panelDireccion.add(labelDireccion);
		
		textFieldDireccion = new JTextField();
		panelDireccion.add(textFieldDireccion);
		textFieldDireccion.setColumns(40);
		
		JPanel panelCuitCuil = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelCuitCuil.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCuitCuil.setOpaque(false);
		panelCrearCliente.add(panelCuitCuil);
		
		JLabel labelCuitCuil = this.crearEtiquetaFormateada("Cuit/Cuil");
		panelCuitCuil.add(labelCuitCuil);
		
		textFieldCuitCuil = this.crearTextFieldFormatoTexto(11);
		panelCuitCuil.add(textFieldCuitCuil);
		
		JPanel panelCorreoElectronico = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelCorreoElectronico.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelCorreoElectronico.setOpaque(false);
		panelCrearCliente.add(panelCorreoElectronico);
		
		JLabel labelCorreoElectronico = this.crearEtiquetaFormateada("Correo Electronico");
		panelCorreoElectronico.add(labelCorreoElectronico);
		
		textFieldCorreo = new JTextField();
		panelCorreoElectronico.add(textFieldCorreo);
		textFieldCorreo.setColumns(40);
		
		
		
		JPanel panelTipoCliente = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelTipoCliente.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelTipoCliente.setOpaque(false);
		panelCrearCliente.add(panelTipoCliente);
		
		
		
		JLabel labelTipoCliente = this.crearEtiquetaFormateada("Tipo de cliente");
		panelTipoCliente.add(labelTipoCliente);
		
		JRadioButton radioButtonIndividuo = new JRadioButton("Individuo");
		radioButtonIndividuo.setFont(this.getFuentaEtiqueta());
		radioButtonIndividuo.setOpaque(false);
		buttonGroup.add(radioButtonIndividuo);
		panelTipoCliente.add(radioButtonIndividuo);
		
		JRadioButton radioButtonEmpresa = new JRadioButton("Empresa");
		radioButtonEmpresa.setOpaque(false);
		radioButtonEmpresa.setFont(this.getFuentaEtiqueta());
		buttonGroup.add(radioButtonEmpresa);
		panelTipoCliente.add(radioButtonEmpresa);
		
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelCrearCliente.add(panelBotones);
		
		JButton buttonCrearCliente = this.crearBotonFormateado("Crear Cliente", "CREAR_CLIENTE");
		panelBotones.add(buttonCrearCliente);
		
		JButton buttonCancelar = this.crearBotonFormateado("Limpiar", "LIMPIAR");
		panelBotones.add(buttonCancelar);
	}



	@Override
	public void resetearPanel() {
		// TODO Auto-generated method stub
		
	}

}
