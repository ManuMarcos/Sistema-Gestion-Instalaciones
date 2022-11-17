package controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import modelos.*;
import vistas.CrearClienteVista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ControladorPrincipal controlador= new ControladorPrincipal();
		
		
		Disponibilidad turnoManana = new TurnoManana();
		
		Tecnico tecnico1 = new Tecnico("Nahuel Damiano", "Los Indios 254", turnoManana);
		Cliente cliente1 = new Cliente("Manuel Marcos", "Rivadavia 2589", 2041510275, TipoCliente.INDIVIDUO, 
				"manuelignaciomarcos@gmail.com");
		
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
	
		
		fecha1.set(2022, 10, 17, 8, 0, 0);
		fecha2.set(2022, 10, 17, 11, 0, 0);
		fecha3.set(2022, 10, 17, 11, 20, 0);
		fecha4.set(2022, 10, 17, 16, 0, 0);
		fecha5.set(2022, 10, 18, 8, 0, 0);
		fecha6.set(2022, 10, 18, 9, 30, 0);
		
		
		//Sabado 26/11/2022
		fecha7.set(2022, 10, 26, 8, 00);
		fecha8.set(2022, 10, 26, 12, 30);
		
		fecha9.set(2022, 10, 17, 11, 0, 0);
				
	
		
		controlador.agendarInstalacion(cliente1, tecnico1, fecha1);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha2);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha3);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha4);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha5);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha6);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha7);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha8);
		controlador.agendarInstalacion(cliente1, tecnico1, fecha9);
		

		
		
		System.out.println("-----------------------------Agenda Tecnico-----------------------------");
		tecnico1.getAgenda().imprimirTurnos();
		System.out.println("-----------------------------Agenda Cliente-----------------------------");
		cliente1.getAgenda().imprimirTurnos();
		
		
		Inventario inventario = new Inventario();
		
		inventario.setStock(new Evaporadora(), 50);
		inventario.setStock(new Condensadora(), 20);
		inventario.setStock(new KitDeInstalacion(), 5);
		
		inventario.quitarProducto(new Evaporadora());
		inventario.quitarProducto(new Condensadora());
		inventario.quitarProducto(new KitDeInstalacion());
		
		
		
		
		inventario.setPrecioProducto(new Evaporadora(), 500);
		inventario.setPrecioProducto(new Condensadora(), 780);
		inventario.setPrecioProducto(new KitDeInstalacion(), 200);
		
		
		System.out.println(inventario.toString());
		
		/*
		CrearClienteVista vista = new CrearClienteVista(400,300);
		
		vista.setVisible(true);
		*/
		
		
		
		
	}

}
