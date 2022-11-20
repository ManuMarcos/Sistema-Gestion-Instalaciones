package vistas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pruebaVistas extends JFrame{

	JTable tabla;
	

	public pruebaVistas(){
	String[] columnas = {"DNI", "Nombre", "Club"};
	Object[][] datos = {{41915027, "Manuel Marcos", "Boca Juniors"}};
	
	DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
	
	this.tabla = new JTable(modeloTabla);
	this.getContentPane().add(new JScrollPane(tabla));
	}
	
	
}
