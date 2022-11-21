package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PruebaPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PruebaPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("TITULO");
		panelSuperior.add(lblNewLabel);
		
		JPanel panelCentral = new JPanel();
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ok");
		panelInferior.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panelInferior.add(btnNewButton_1);
		
		JPanel panelIzquierdo = new JPanel();
		panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);

	}

}
