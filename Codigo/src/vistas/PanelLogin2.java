package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogin2 extends JPanel{

	//Attributes
	private JLabel titulo;
	private JLabel logoEmpresa;
	
	public PanelLogin2() {
		Color celeste = new Color(21,239,245);
		ImageIcon iconoEmpresa = new ImageIcon("logo-empresa.png");
		this.setLayout(new FlowLayout());
		this.logoEmpresa = new JLabel();
		this.setBackground(celeste);
		this.logoEmpresa.setSize(600,300);
		this.logoEmpresa.setIcon(new ImageIcon(iconoEmpresa.getImage().getScaledInstance(logoEmpresa.getWidth(), logoEmpresa.getHeight(), Image.SCALE_SMOOTH))); 
		this.agregarTitulo();
		this.add(logoEmpresa);
	}
	
	
	public void agregarTitulo() {
		this.titulo = new JLabel("Sistema de Gestion \n de Instalaciones");
		titulo.setSize(600, 300);
		titulo.setFont(new Font(Font.SANS_SERIF,Font.BOLD, 35));
		this.add(titulo);
	}
	
	
}
