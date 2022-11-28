package vistas;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class VistaConfig {

	
	//Configuracion de las etiquetas
	public static final String labelFontFamily = "Times New Roman";
	public static final int labelFontStyle = Font.PLAIN;
	public static final int labelFontSize = 18;
	
	//Paleta de color
	public static final Color celeste = new Color(173, 216, 230);
	
	//Configuracion de los text fields
	public static final String textFieldFontFamily = "Sans Serif";
	public static final int textFieldStyle = Font.ITALIC;
	public static final int textFieldSize = 16;
	
	//Configuracion de los botones
	public static final String buttonFamlabelFontFamily = "Tahoma";
	public static final int buttonFontStyle = Font.PLAIN;
	public static final int buttonFontSize = 16;
	
	
	
	//Configuracion de los titulos
	/*
	public static final String titleFamlabelFontFamily = 
	public static final int titleFontStyle;
	public static final int titleFontSize;
	*/
	//Configuracion de los colores
	
	
	public static String formatearFecha(Calendar fecha) {
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String fechaFormateada = formatoFecha.format(fecha.getTime());
		return fechaFormateada;
	}
	
	public static JButton crearBotonFormateado(String titulo, String comando) {
		JButton boton = new JButton(titulo);
		boton.setActionCommand(comando);
		setFormatoBoton(boton);
		return boton;
	}
	
	private static void setFormatoBoton(JButton boton) {
		boton.setForeground(new Color(255, 255, 255));
		boton.setFont(new Font(VistaConfig.buttonFamlabelFontFamily, VistaConfig.buttonFontStyle, VistaConfig.buttonFontSize));
		boton.setBackground(Color.BLACK);
	}
	
	public static JLabel crearEtiquetaFormateada(String titulo) {
		JLabel etiqueta = new JLabel(titulo);
		etiqueta.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
		return etiqueta;
	}
	
	public static JTextField crearTextFieldFormateado(int columnas) {
		JTextField textField = new JTextField(columnas);
		textField.setFont(new Font(VistaConfig.textFieldFontFamily, VistaConfig.textFieldStyle, VistaConfig.textFieldSize));
		return textField;
	}
	
	
	
	
}
