package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class DialogoDatosProducto extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JPanel panelButtons;
	private JTextField textFieldId;
	private JTextField textFieldNombreProducto;
	private JTextField textFieldStock;
	private JTextField textFieldPrecio;
	private JPanel panelBotones;
	private JPanel panelDatos;
	private JPanel panelId;
	private JLabel labelId;
	private JLabel labelStock;
	private JLabel labelPrecio;
	private JPanel panelProducto;
	private JLabel labelNombreProducto;
	private JPanel panelStock;
	private JPanel panelPrecio;
	private JButton buttonConfirmar;
	private JButton buttonCancelar;
	
	
	
	public DialogoDatosProducto(JFrame padre, boolean esModal) {
		super(padre, esModal);
		setBounds(100, 100, 401, 301);
		this.setBackground(Color.WHITE);
		this.agregarPaneles();
		this.agregarEtiquetas();
		this.agregarTextFields();
		this.agregarBotones();
		this.setTitle("Datos producto");
	}
	
	private void agregarPaneles() {
		this.panelPrincipal = new JPanel();
		panelPrincipal.setOpaque(false);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.panelDatos= new JPanel();
		panelDatos.setOpaque(false);
		panelPrincipal.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(4, 1, 0, 0));
		
		this.panelId = new JPanel();
		panelId.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panelId.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelId);
		
		this.panelProducto = new JPanel();
		panelProducto.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelProducto.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelProducto);
		
		this.panelPrecio = new JPanel();
		panelPrecio.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panelPrecio.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelPrecio);
		
		this.panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		this.panelStock= new JPanel();
		panelStock.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panelStock.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelDatos.add(panelStock);
	}
	
	private void agregarEtiquetas() {
		this.labelId = VistaConfig.crearEtiquetaFormateada("Id");
		panelId.add(labelId);
		
		this.labelNombreProducto = VistaConfig.crearEtiquetaFormateada("Producto");
		panelProducto.add(labelNombreProducto);
		
		this.labelStock = VistaConfig.crearEtiquetaFormateada("Stock");
		panelStock.add(labelStock);
		
		this.labelPrecio =  VistaConfig.crearEtiquetaFormateada("Precio");
		panelPrecio.add(labelPrecio);
	}
	
	public void setActionListener(ActionListener controlador) {
		this.buttonConfirmar.addActionListener(controlador);
		this.buttonCancelar.addActionListener(controlador);
	}
	
	private void agregarTextFields() {
		textFieldId = VistaConfig.crearTextFieldFormateado(10);
		panelId.add(textFieldId);
		
		textFieldNombreProducto = VistaConfig.crearTextFieldFormateado(20);
		panelProducto.add(textFieldNombreProducto);
	
		textFieldStock = VistaConfig.crearTextFieldFormateado(10);
		panelStock.add(textFieldStock);
		
		textFieldPrecio = VistaConfig.crearTextFieldFormateado(10);
		panelPrecio.add(textFieldPrecio);

	}
	
	private void agregarBotones(){
		this.buttonConfirmar = VistaConfig.crearBotonFormateado("Confirmar", "MODIFICAR_DATOS_PRODUCTO");
		panelBotones.add(buttonConfirmar);
		
		this.buttonCancelar = VistaConfig.crearBotonFormateado("Cancelar", "CANCELAR_DATOS_PRODUCTO");
		panelBotones.add(buttonCancelar);
	}

	public void setearDatosProducto(int idProducto, String nombreProducto, int cantStock, float precio) {
		this.textFieldId.setText(Integer.toString(idProducto));
		this.textFieldId.setEditable(false);
		this.textFieldNombreProducto.setText(nombreProducto);
		this.textFieldNombreProducto.setEditable(false);
		this.textFieldStock.setText(Integer.toString(cantStock));
		this.textFieldPrecio.setText(Float.toString(precio));
		this.setVisible(true);
	}
	
	public void cerrar() {
		this.setVisible(false);
		this.textFieldId.setText(null);
		this.textFieldNombreProducto.setText(null);
		this.textFieldPrecio.setText(null);
		this.textFieldStock.setText(null);
	}
	
	public String getPrecio() {
		return this.textFieldPrecio.getText();
	}
	
	public String getStock() {
		return this.textFieldStock.getText();
	}
	
	public String getNombreProducto() {
		return this.textFieldNombreProducto.getText();
	}
	
}
