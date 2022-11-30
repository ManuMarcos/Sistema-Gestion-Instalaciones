package controladores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import modelos.*;

import vistas.PanelAgendarInstalacion;
import vistas.VentanaLogin;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empresa empresa = Empresa.getInstance();
		
		Instalacion.setCostoViaje(350);
		
		empresa.crearTecnico("Carlos Garcia", "Machado 365", "TurnoManana", "tecnico1", "tecnico1", "Junior");
		empresa.crearTecnico("Roberto Robertson", "Los Indios 123", "TurnoTarde", "tecnico2", "tecnico2", "Senior");
		empresa.crearTecnico("Raul Batista", "Callao 203", "TurnoManana", "tecnico3", "tecnico3", "SemiSenior");
		empresa.crearEmpleado("Operador", "Sebastian Robles", "Casullo 182", "operador", "operador");
		empresa.crearEmpleado("Administrador", "admin","Sarmiento 201", "admin", "admin");
		empresa.crearEmpleado("Administrativo", "Jesus Lopez", "Arenales 874", "administrativo", "administrativo123");
		empresa.crearCliente("Manuel Marcos", "Rivadavia 2589",20419150275L, TipoCliente.INDIVIDUO, 
				"manuelignaciomarcos@gmail.com");
		empresa.crearCliente("Burger King", "Colonia 329", 20206958745L, TipoCliente.EMPRESA, "burgerking@gmail.com");
		
		
		empresa.setStockProducto("Evaporadora", 5);
		empresa.setStockProducto("Condensadora", 6);
		empresa.setStockProducto("KitDeInstalacion", 2);
		empresa.setStockProducto("SoportePared", 0);
		
		ControladorLogin controlador = new ControladorLogin();
		controlador.inciarVentanaLogin();
		
	}
	
	

}
