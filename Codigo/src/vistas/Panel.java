package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public abstract class Panel extends JPanel{

	
	public abstract void resetearPanel();
	public abstract void setActionListener(ActionListener controlador);
	public abstract void setKeyListener(KeyListener controlador);
	
	public void mostrarMensajeDeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, mensaje, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeDeError(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void mostrarMensajeExitoso(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, mensaje, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeInformativo(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void setBordePanel(String titulo) {
		this.setBackground(Color.BLACK);
		this.setOpaque(false);
		Border borde = BorderFactory.createRaisedBevelBorder();
		this.setBorder(BorderFactory.createTitledBorder(borde, titulo, TitledBorder.CENTER, 
				TitledBorder.CENTER, new Font(VistaConfig.labelFontFamily, Font.BOLD, 20), Color.BLACK));
	}
	
	public void setFormatoBoton(JButton boton) {
		boton.setForeground(new Color(255, 255, 255));
		boton.setFont(new Font(VistaConfig.buttonFamlabelFontFamily, VistaConfig.buttonFontStyle, VistaConfig.buttonFontSize));
		boton.setBackground(Color.BLACK);
	}
	
	public static void setFormatoEtiqueta(JLabel etiqueta) {
		etiqueta.setFont(new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize));
	}
	
	public Font getFuentaEtiqueta() {
		return new Font(VistaConfig.labelFontFamily, VistaConfig.labelFontStyle, VistaConfig.labelFontSize);
	}
	
	public JButton crearBotonFormateado(String titulo, String comando) {
		JButton boton = new JButton(titulo);
		boton.setActionCommand(comando);
		this.setFormatoBoton(boton);
		return boton;
	}
	
	public JLabel crearEtiquetaFormateada(String titulo) {
		JLabel etiqueta = new JLabel(titulo);
		etiqueta.setFont(this.getFuentaEtiqueta());
		return etiqueta;
	}
	
	public JTextField crearTextFieldFormatoTexto(int columnas) {
		JTextField campoTexto = new JTextField(columnas);
		return campoTexto;
	}
	
	public JFormattedTextField crearTextFieldFormatoCustom(String formato) {
		MaskFormatter mascaraFormato = null;
		JFormattedTextField campoFormateado = null;
		try {
			mascaraFormato = new MaskFormatter(formato);
			campoFormateado = new JFormattedTextField(mascaraFormato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return campoFormateado;
	}
	
}
