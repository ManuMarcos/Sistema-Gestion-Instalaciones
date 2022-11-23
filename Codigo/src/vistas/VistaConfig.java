package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class VistaConfig {

	
	//Configuracion de las etiquetas
	public static final String labelFontFamily = "Times New Roman";
	public static final int labelFontStyle = Font.PLAIN;
	public static final int labelFontSize = 18;
	
	//Paleta de color
	public static final Color celeste = new Color(173, 216, 230);
	
	
	
	
	//Configuracion de los titulos
	/*
	public static final String titleFamlabelFontFamily = 
	public static final int titleFontStyle;
	public static final int titleFontSize;
	*/
	//Configuracion de los colores
	
	
	
	
	//Configuracion de los botones
	public static final String buttonFamlabelFontFamily = "Tahoma";
	public static final int buttonFontStyle = Font.PLAIN;
	public static final int buttonFontSize = 16;
	
	public static JButton getBotonFormateado(String titulo, String comando) {
		JButton boton = new JButton(titulo);
		boton.setActionCommand(comando);
		setFormatoBoton(boton);
		return boton;
	}
	
	public static void setFormatoBoton(JButton boton) {
		boton.setForeground(new Color(255, 255, 255));
		boton.setFont(new Font(VistaConfig.buttonFamlabelFontFamily, VistaConfig.buttonFontStyle, VistaConfig.buttonFontSize));
		boton.setBackground(Color.BLACK);
	}
	
	
}
