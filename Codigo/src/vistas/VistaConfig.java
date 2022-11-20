package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class VistaConfig {

	
	//Configuracion de las etiquetas
	public static final String labelFamilyFont = "Times New Roman";
	public static final int labelFontStyle = Font.BOLD;
	public static final int labelFontSize = 20;
	
	//Configuracion de los titulos
	/*
	public static final String titleFamilyFont = 
	public static final int titleFontStyle;
	public static final int titleFontSize;
	*/
	//Configuracion de los colores
	
	
	
	
	//Configuracion de los botones
	public static final String buttonFamilyFont = "Tahoma";
	public static final int buttonFontStyle = Font.PLAIN;
	public static final int buttonFontSize = 16;
	
	
	public static void setButtonStyle(JButton boton) {
		boton.setForeground(new Color(255, 255, 255));
		boton.setFont(new Font(VistaConfig.buttonFamilyFont, VistaConfig.buttonFontStyle, VistaConfig.buttonFontSize));
		boton.setBackground(Color.BLACK);
	}
	
	
}
