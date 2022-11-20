package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VentanaSeleccionarTecnico extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxTecnicos;
	
	

	/**
	 * Create the frame.
	 */
	public VentanaSeleccionarTecnico() {
		setTitle("Seleccionar Tecnico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 117);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelTecnicosDisponibles = new JLabel("Tecnicos Disponibles");
		labelTecnicosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		labelTecnicosDisponibles.setFont(new Font(VistaConfig.labelFamilyFont, Font.PLAIN, VistaConfig.labelFontSize));
		panelCentral.add(labelTecnicosDisponibles);
		
		this.comboBoxTecnicos= new JComboBox<String>();
		panelCentral.add(comboBoxTecnicos);
		
		JPanel panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		JButton buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.setForeground(Color.BLACK);
		buttonConfirmar.setFont(new Font(VistaConfig.buttonFamilyFont, VistaConfig.buttonFontStyle, VistaConfig.buttonFontSize));
		buttonConfirmar.setActionCommand("CONFIRMAR");
		panelInferior.add(buttonConfirmar);
	}

	public void setTecnicosDisponibles(ArrayList<String> tecnicosDisponibles) {
		for (int i=0; i < tecnicosDisponibles.size() ; i++) {
			this.comboBoxTecnicos.addItem(tecnicosDisponibles.get(i));
		}
	}
	
	
}
