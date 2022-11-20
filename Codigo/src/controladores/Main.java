package controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import modelos.*;
import vistas.AgendarInstalacionDialog;
import vistas.CrearClienteVista;

import vistas.VentanaLogin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empresa empresa = Empresa.getInstance();
		
		Disponibilidad turnoManana = new TurnoManana();
		
		ExperienciaLaboral junior = new Junior();
		ExperienciaLaboral semisenior = new SemiSenior();

		Tecnico tecnico1 = new Tecnico("Nahuel Damiano", "Los Indios 254", new TurnoManana(), "tecnico", "tecnico", junior);
		Tecnico tecnico2 = new Tecnico("Roberto Robertson", "Los Indios 123", new TurnoManana(), "tecnico", "tecnico", semisenior);

		Operador operador = new Operador("Sebastian Robles", "Casullo 182", "operador", "operador");
		Cliente cliente1 = new Cliente("Manuel Marcos", "Rivadavia 2589", 2041510275, TipoCliente.INDIVIDUO, 
				"manuelignaciomarcos@gmail.com");
		
		empresa.agregarEmpleado(operador);
		empresa.agregarEmpleado(tecnico1);
		
		
		
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
				
	
		
		empresa.agendarInstalacion(cliente1, tecnico1, fecha1);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha2);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha3);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha4);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha5);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha6);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha7);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha8);
		empresa.agendarInstalacion(cliente1, tecnico1, fecha9);
		

		
		
		System.out.println("-----------------------------Agenda Tecnico-----------------------------");
		tecnico1.getAgenda().imprimirTurnos();
		System.out.println("-----------------------------Agenda Cliente-----------------------------");
		cliente1.getAgenda().imprimirTurnos();
		
		
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
		
		empresa.setStockProducto(new Evaporadora(), 50);
		empresa.setStockProducto(new Condensadora(), 20);
		empresa.setStockProducto(new KitDeInstalacion(), 5);
		empresa.setPrecioProducto(new Evaporadora(), 50);
		empresa.setPrecioProducto(new Condensadora(), 78);
		empresa.setPrecioProducto(new KitDeInstalacion(), 40);
		empresa.imprimirInventario();
		
		
		ControladorLogin controlador = new ControladorLogin();
		controlador.inciarVentanaLogin();
		

		
		
		/*
		CrearClienteVista vista = new CrearClienteVista(400,300);
		
		vista.setVisible(true);
		*/
		
		
		
		
	}

}
