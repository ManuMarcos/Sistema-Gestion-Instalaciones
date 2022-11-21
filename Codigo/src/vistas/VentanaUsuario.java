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

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableDatosOperador;
	private JScrollPane scrollPaneTableDatosOperador;
	private JLabel iconoUsuario;
	private JPanel panelDatosOperador;

	
	/**
	 * Create the frame.
	 */
	public VentanaUsuario(Icon iconoUsuario, String titulo) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 759, 523);
		this.setTitle(titulo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIcono = new JPanel();
		panelSuperior.add(panelIcono, BorderLayout.WEST);
		
		this.iconoUsuario = new JLabel();
		this.iconoUsuario.setIcon(iconoUsuario);
		panelIcono.add(this.iconoUsuario);
		
		this.panelDatosOperador = new JPanel();
		panelSuperior.add(panelDatosOperador, BorderLayout.CENTER);
		panelDatosOperador.setLayout(new GridLayout(2, 1, 0, 0));
		
		tableDatosOperador = new JTable();
		this.scrollPaneTableDatosOperador = new JScrollPane(tableDatosOperador);
		panelDatosOperador.add(scrollPaneTableDatosOperador);
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.SOUTH);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.WEST);
		
		JButton buttonCerrarSesion = new JButton("New button");
		panelInferior.add(buttonCerrarSesion);
	}
	
	public void setDatosUsuario(DefaultTableModel datosOperador) {
		this.tableDatosOperador.setModel(datosOperador);
	}
	

	
	
	
	
}
