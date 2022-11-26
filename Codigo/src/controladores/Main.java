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
		
		Disponibilidad turnoManana = new TurnoManana();
		
		ExperienciaLaboral junior = new Junior();
		ExperienciaLaboral semisenior = new SemiSenior();
		
		ExperienciaLaboral junior2 = new Junior();
		
		
		
		

		Tecnico tecnico1 = new Tecnico("Nahuel Damiano", "Los Indios 254", new TurnoManana(), "tecnico1", "tecnico1", junior);
		Tecnico tecnico2 = new Tecnico("Roberto Robertson", "Los Indios 123", new TurnoManana(), "tecnico2", "tecnico2", semisenior);
		Tecnico tecnico3 = new Tecnico("Raul Batista", "Callao 203", new TurnoTarde(), "tecnico3", "tecnico3", junior);

		Operador operador = new Operador("Sebastian Robles", "Casullo 182", "operador", "operador");
		Administrador administrador = new Administrador("admin","Sarmiento 201", "admin", "admin");
		Administrativo administrativo = new Administrativo("Jesus Lopez", "Arenales 874", "administrativo", "administrativo123");
		
		Cliente cliente1 = new Cliente("Manuel Marcos", "Rivadavia 2589",20419150275L, TipoCliente.INDIVIDUO, 
				"manuelignaciomarcos@gmail.com");
		
		
		Cliente cliente2 = new Cliente("Burger King", "Colonia 329", 20206958745L, TipoCliente.EMPRESA, "burgerking@gmail.com");
		
		empresa.agregarEmpleado(operador);
		empresa.agregarEmpleado(tecnico1);
		empresa.agregarEmpleado(tecnico2);
		empresa.agregarEmpleado(tecnico3);
		empresa.agregarCliente(cliente1);
		empresa.agregarCliente(cliente2);
		empresa.agregarEmpleado(administrador);
		empresa.agregarEmpleado(administrativo);
		
		System.out.println(tecnico1.toString());
		
		
		
		
		
		
		Calendar fecha1 = new GregorianCalendar();
		Calendar fecha2 = new GregorianCalendar();
		Calendar fecha3 = new GregorianCalendar();
		Calendar fecha4 = new GregorianCalendar();
		Calendar fecha5 = new GregorianCalendar();
		Calendar fecha6 = new GregorianCalendar();
		Calendar fecha7 = new GregorianCalendar();
		Calendar fecha8 = new GregorianCalendar();
		Calendar fecha9 = new GregorianCalendar();
	
		
		fecha1.set(2022, 12, 26, 9, 0, 0);
		fecha2.set(2022, 12, 29, 9, 0, 0);
		fecha3.set(2022, 12, 19, 9, 20, 0);
		fecha4.set(2022, 12, 11, 7, 0, 0);
		fecha5.set(2022, 12, 18, 7, 0, 0);
		fecha6.set(2022, 12, 18, 8, 30, 0);
		
		
		//Sabado 26/11/2022
		fecha7.set(2022, 10, 26, 8, 00);
		fecha8.set(2022, 10, 22, 12, 30);
		
		
		fecha9.set(2022, 10, 22, 11, 0, 0);
		
		
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
		
	
		
		System.out.println(empresa.getInventario().toString());
		
		
		/*
		empresa.setPrecioProducto("Evaporadora", 50);
		empresa.setPrecioProducto("Condensadora", 78);
		empresa.setPrecioProducto("KitDeInstalacion", 40);
		*/
		
		empresa.setPrecioProducto("Evaporadora", 200);
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

		
		
		ControladorLogin controlador = new ControladorLogin();
		controlador.inciarVentanaLogin();
		
		
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
