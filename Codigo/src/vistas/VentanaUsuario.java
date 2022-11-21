package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableDatosOperador;
	private JScrollPane scrollPaneTableDatosOperador;
	private JLabel datoUsuario;
	private JLabel datoNombreApellido;
	private JLabel datoNroLegajo;
	private JPanel panelCentral;
	private JInternalFrame internalFrame;
	private JLabel labelIconoUsuario;

	
	/**
	 * Create the frame.
	 */
	public VentanaUsuario(Icon iconoUsuario, String titulo) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 867, 528);
		this.setTitle(titulo);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/*
		tableDatosOperador = new JTable();
		this.scrollPaneTableDatosOperador = new JScrollPane(tableDatosOperador);
		panelDatosOperador.add(scrollPaneTableDatosOperador);
		*/
		
		this.panelCentral = new JPanel();
		panelCentral.setBackground(Color.LIGHT_GRAY);
		panelCentral.setOpaque(false);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		
		
		
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setOpaque(false);
		contentPane.add(panelIzquierdo, BorderLayout.WEST);
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		
		this.labelIconoUsuario = new JLabel(iconoUsuario);
		this.labelIconoUsuario.setBorder(new EmptyBorder(0,0,10,0));
		panelIzquierdo.add(labelIconoUsuario);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, 14));
		labelUsuario.setBackground(VistaConfig.celeste);
		labelUsuario.setOpaque(true);
		panelIzquierdo.add(labelUsuario);
		
		datoUsuario = new JLabel();
		datoUsuario.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoUsuario.setForeground(Color.DARK_GRAY);
		datoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoUsuario);
		
		JLabel labelNombreApellido = new JLabel("Nombre Apellido");
		labelNombreApellido.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreApellido.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, 14));
		labelNombreApellido.setBackground(VistaConfig.celeste);
		labelNombreApellido.setOpaque(true);
		panelIzquierdo.add(labelNombreApellido);
		
		datoNombreApellido = new JLabel();
		datoNombreApellido.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoNombreApellido.setForeground(Color.DARK_GRAY);
		datoNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoNombreApellido);
		
		JLabel labelLegajo = new JLabel("Nro de Legajo");
		labelLegajo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelLegajo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLegajo.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, 14));
		labelLegajo.setBackground(VistaConfig.celeste);
		labelLegajo.setOpaque(true);
		panelIzquierdo.add(labelLegajo);
		
		datoNroLegajo = new JLabel();
		datoNroLegajo.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		datoNroLegajo.setForeground(Color.DARK_GRAY);
		datoNroLegajo.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(datoNroLegajo);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
	}
	
	public void setDatosUsuario(String usuario, String nroLegajo, String nombreApellido) {
		this.datoUsuario.setText(usuario);
		this.datoNroLegajo.setText(nroLegajo);
		this.datoNombreApellido.setText(nombreApellido);
		
	}
	
	public void setPanelCentral(JPanel nuevoPanelCentral) {
		this.panelCentral.add(nuevoPanelCentral);
	}
	

	
	
	
	
}
