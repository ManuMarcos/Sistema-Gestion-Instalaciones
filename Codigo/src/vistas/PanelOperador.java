package vistas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class PanelOperador extends JPanel {

	//Esto tambien podria ser dentro del panel del usuario
		
	JPanel prueba;
	
	
	public PanelOperador() {
		setLayout(new GridLayout(2, 1, 0, 0));
	}
	
	
	public void agregarPanel(JPanel panel) {
		this.add(panel);
	}

}
