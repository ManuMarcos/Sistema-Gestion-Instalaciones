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
		
		Disponibilidad turnoManana = new TurnoManana();
		
		ExperienciaLaboral junior = new Junior();
		ExperienciaLaboral semisenior = new SemiSenior();
		
		empresa.crearTecnico("Carlos Garcia", "Machado 365", "TurnoManana", "tecnico1", "tecnico1", "Junior");
		empresa.crearTecnico("Roberto Robertson", "Los Indios 123", "TurnoTarde", "tecnico2", "tecnico2", "Senior");
		empresa.crearTecnico("Raul Batista", "Callao 203", "TurnoManana", "tecnico3", "tecnico3", "SemiSenior");
	
		Operador operador = new Operador("Sebastian Robles", "Casullo 182", "operador", "operador");
		Administrador administrador = new Administrador("admin","Sarmiento 201", "admin", "admin");
		Administrativo administrativo = new Administrativo("Jesus Lopez", "Arenales 874", "administrativo", "administrativo123");
		
		empresa.agregarEmpleado(operador);
		empresa.agregarEmpleado(administrador);
		empresa.agregarEmpleado(administrativo);
		
		empresa.crearCliente("Manuel Marcos", "Rivadavia 2589",20419150275L, TipoCliente.INDIVIDUO, 
				"manuelignaciomarcos@gmail.com");
		empresa.crearCliente("Burger King", "Colonia 329", 20206958745L, TipoCliente.EMPRESA, "burgerking@gmail.com");

		
		//Se agrega el stock antes de agendar instalaciones
		//Producto evaporadora = new Evaporadora();
		//Producto condensadora = new Condensadora();
		//Producto kitDeInstalacion = new KitDeInstalacion();
		
		empresa.setStockProducto("Evaporadora", 5);
		empresa.setStockProducto("Condensadora", 6);
		empresa.setStockProducto("KitDeInstalacion", 2);
		
		empresa.getInventario().setStock(new Evaporadora(), 1220);
		empresa.getInventario().setStock(new Condensadora(), 500);
		empresa.getInventario().setStock(new KitDeInstalacion(), 20);
		
		
		ControladorLogin controlador = new ControladorLogin();
		controlador.inciarVentanaLogin();
		
		
		
		

		
		
		/*
		empresa.setPrecioProducto("Evaporadora", 50);
		empresa.setPrecioProducto("Condensadora", 78);
		empresa.setPrecioProducto("KitDeInstalacion", 40);
		*/
		
		
		/*
		
		empresa.getInventario().quitarProductos(new Condensadora(), 9);
		empresa.getInventario().quitarProductos(new KitDeInstalacion(), 10);
		System.out.println(empresa.getInventario().obtenerStock(new KitDeInstalacion()));
		empresa.getInventario().quitarProductos(new KitDeInstalacion(), 13);
		*/
		
		
		
		
	
		/*
		empresa.getInventario().quitarProductos(new Evaporadora(), 3);
		System.out.println(empresa.getInventario().toString());
		empresa.getInventario().quitarProductos(new Condensadora(), 4);
		System.out.println(empresa.getInventario().toString());
		*/
		
	
		
		/*					
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha1, true, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha2, true, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha3, false, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha4, true, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha5, false, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha6, true, false);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha7, false, true);
	    empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha8, false, true);
		empresa.agendarInstalacion(cliente1.getCuitCuil(), tecnico1.getId(), fecha9, true, false);
		*/

		
		/*
		System.out.println("-----------------------------Agenda Tecnico-----------------------------");
		tecnico1.getAgenda().imprimirTurnos();
		System.out.println("-----------------------------Agenda Cliente-----------------------------");
		cliente1.getAgenda().imprimirTurnos();
		*/
//		System.out.println("VALOR POR HORA TECNICO 1 SIENDO JUNIOR");
//		System.out.println(tecnico1.getExperienciaLaboral().getCostoHora());
//		
//		System.out.println("VALOR POR HORA TECNICO 2 SIENDO SEMI SENIOR");
//		System.out.println(tecnico2.getExperienciaLaboral().getCostoHora());
//		
//		junior.setCostoHora(500);
//		
//		System.out.println("VALOR POR HORA TECNICO 1 SIENDO JUNIOR DESPUES DEL CAMBIO");
//		System.out.println(tecnico1.getExperienciaLaboral().getCostoHora());
//		
//		System.out.println("VALOR POR HORA TECNICO 2 SIENDO SEMI SENIOR DESPUES DEL CAMBIO");
//		System.out.println(tecnico2.getExperienciaLaboral().getCostoHora());
//		
//		semisenior.setCostoHora(1000);
//
//		System.out.println("VALOR POR HORA TECNICO 1 SIENDO JUNIOR DESPUES DEL CAMBIO EN SSR");
//		System.out.println(tecnico1.getExperienciaLaboral().getCostoHora());
//		
//		System.out.println("VALOR POR HORA TECNICO 2 SIENDO SEMI SENIOR DESPUES DEL CAMBIO EN SSR");
//		System.out.println(tecnico2.getExperienciaLaboral().getCostoHora());

		
		
	
		
		
		//Ejemplo de gestion
//		for (Instalacion i : empresa.getInstalaciones()) {
//			System.out.println("ID: " + i.getId() + " " + "Cliente: " + i.getCliente().getNombre());
//			//Agregamos en empresa? O en inventario?
//			tecnico1.agregarElementoUtilizado(i, kitDeInstalacion, 3);
//			tecnico1.agregarElementoUtilizado(i, evaporadora, 1);
//			tecnico1.agregarElementoUtilizado(i, condensadora, 9);
//			Calendar fechaFinalizacion = new GregorianCalendar();
//			fechaFinalizacion.set(2022, 10, 25, 9, 30, 0);
//			tecnico1.completarInstalacion(i, fecha1, fechaFinalizacion, false);
//			administrativo.facturarInstalacion(i, 1.21);
//			for (Factura f : empresa.getFacturas()) {
//				System.out.println("PRECIO TOTAL: " + f.getPrecioTotal());
//			}
//		}
				
		

		
		
		//Prueba agendar instalacion sin stock
		/*
		empresa.getInventario().setStock(new Condensadora(), 0);
		empresa.getInventario().setStock(new Evaporadora(), 1);
		empresa.getInventario().setStock(new KitDeInstalacion(), 0);
		*/
		
		
		
		
		
		
	}
	
	

}
