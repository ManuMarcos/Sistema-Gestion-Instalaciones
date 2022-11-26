package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class VentanaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	//Panels
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelIzquierdo;
	private JPanel panelInferior;
	//Labels
	private JLabel labelUsuario;
	private JLabel labelNombreApellido;
	private JLabel labelLegajo;
	private JLabel labelIconoUsuario;
	private JLabel datoUsuario;
	private JLabel datoNombreApellido;
	private JLabel datoNroLegajo;
	
	

	
	public VentanaUsuario(Icon iconoUsuario, String titulo, int filas, int columnas) {
		this.setTitle(titulo);
		this.modificarContentPane();
		this.agregarPaneles(filas, columnas);
		this.setearIcono(iconoUsuario);
		this.agregarEtiquetas();
	}
	
	private void modificarContentPane() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 928, 570);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	
	private void setearIcono(Icon iconoUsuario) {
		this.labelIconoUsuario = new JLabel(iconoUsuario);
		this.labelIconoUsuario.setBorder(new EmptyBorder(0,0,10,0));
		panelIzquierdo.add(labelIconoUsuario);
	}
	
	private void setearPanelModular(int filas, int columnas) {
		this.panelCentral = new JPanel();
		this.panelCentral.setBorder(new EmptyBorder(0,5,0,5));
		panelCentral.setBackground(Color.WHITE);
		panelCentral.setOpaque(false);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		//Setear cantidad de columnas y filas
		panelCentral.setLayout(new GridLayout(filas, columnas, 5, 5));
	}
	

	private void agregarPaneles(int columnas, int filas) {
		
		this.setearPanelModular(columnas, filas);
		
		this.panelIzquierdo = new JPanel();
		panelIzquierdo.setOpaque(false);
		contentPane.add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		
		this.panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
	}
	
	private void agregarEtiquetas() {
		this.labelUsuario = new JLabel("Usuario");
		labelUsuario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 14));
		labelUsuario.setBackground(VistaConfig.celeste);
		labelUsuario.setOpaque(true);
		panelIzquierdo.add(labelUsuario);
		
		datoUsuario = new JLabel();
		datoUsuario.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoUsuario.setForeground(Color.DARK_GRAY);
		datoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoUsuario);
		
		this.labelNombreApellido = new JLabel("Nombre Apellido");
		labelNombreApellido.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreApellido.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 14));
		labelNombreApellido.setBackground(VistaConfig.celeste);
		labelNombreApellido.setOpaque(true);
		panelIzquierdo.add(labelNombreApellido);
		
		datoNombreApellido = new JLabel();
		datoNombreApellido.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoNombreApellido.setForeground(Color.DARK_GRAY);
		datoNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoNombreApellido);
		
		this.labelLegajo = new JLabel("Nro de Legajo");
		labelLegajo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelLegajo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLegajo.setFont(new Font(VistaConfig.labelFontFamily, Font.BOLD, 14));
		labelLegajo.setBackground(VistaConfig.celeste);
		labelLegajo.setOpaque(true);
		panelIzquierdo.add(labelLegajo);
		
		datoNroLegajo = new JLabel();
		datoNroLegajo.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoNroLegajo.setForeground(Color.DARK_GRAY);
		datoNroLegajo.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoNroLegajo);
	}
	
	
	
	
	public void setDatosUsuario(String usuario, String nroLegajo, String nombreApellido) {
		this.datoUsuario.setText(usuario);
		this.datoNroLegajo.setText(nroLegajo);
		this.datoNombreApellido.setText(nombreApellido);
		
	}
	
	public void agregarModulo(JPanel panel) {
		this.panelCentral.add(panel);
	}
	

	
	
	
	
}
