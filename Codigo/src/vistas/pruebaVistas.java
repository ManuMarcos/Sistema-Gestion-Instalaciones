package vistas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.EmpleadoVO;

public class pruebaVistas extends JFrame{

	JTable tabla;
	

	public pruebaVistas(){
	
		this.setSize(500,500);
	//String[] columnas = {"DNI", "Nombre", "Club"};
	//Object[][] datos = {{41915027, "Manuel Marcos", "Boca Juniors"}};
	
	//DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
	/*
	DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
	
	modeloCombo.addElement(new EmpleadoVO("Manuel", 54));
	modeloCombo.addElement(new EmpleadoVO("Rodrigo", 20));
	
	JComboBox combo = new JComboBox();
	combo.setModel(modeloCombo);
	
	this.getContentPane().add(combo);
	*/
	//this.tabla = new JTable(modeloTabla);
	//this.getContentPane().add(new JScrollPane(tabla));
	}
	
	
}
