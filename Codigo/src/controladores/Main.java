package controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import modelos.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TurnoLaboral turnoManana = new TurnoManana();
		
		Tecnico tecnico1 = new Tecnico("Nahuel Damiano", "Los Indios 254", turnoManana);
		
		Cliente cliente = new Cliente("Manuel", "Marcos", TipoCliente.INDIVIDUO, "manuelignaciomarcos@gmail.com");
		
		
		System.out.println(tecnico1.toString());
		
		
		Calendar fecha1 = new GregorianCalendar();
		Calendar fecha2 = new GregorianCalendar();
		Calendar fecha3 = new GregorianCalendar();
		Calendar fecha4 = new GregorianCalendar();
		Calendar fecha5 = new GregorianCalendar();
		Calendar fecha6 = new GregorianCalendar();
		Calendar fecha7 = new GregorianCalendar();
		Calendar fecha8 = new GregorianCalendar();

	
		
		
		fecha1.set(2023, 8, 24, 10, 0);
		fecha2.set(2023, 8, 24, 11, 0);
		fecha3.set(2023, 8, 24, 16, 30);
		fecha4.set(2023, 8, 24, 16, 0);
		
		fecha5.set(2022, 10, 12, 9, 30);
		fecha6.set(2022, 10, 12, 8, 30);
		fecha7.set(2022, 10, 12, 8, 0);
		fecha8.set(2022, 10, 12, 18, 0, 0);
		
		
		Instalacion instalacion1 = new Instalacion(cliente);
		
		//Se intentan agendar turnos para el dia 24/9/2020
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha1);
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha2);
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha3);
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha4);
		
		//Se intentan agendar turnos para el dia 2/5/2020
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha5);
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha6);
		
		tecnico1.getAgenda().agendarInstalacion(instalacion1, fecha7);
		
		tecnico1.getAgenda().imprimirTurnosPorFecha(fecha2);
		
		tecnico1.getAgenda().imprimirTurnosPorFecha(fecha5);
		
		
		
		
	
		
		/*
		Turno turno1 = new Turno(fecha1.getTime());
		Turno turno2 = new Turno(fecha2.getTime());
		Turno turno3 = new Turno(fecha3.getTime());
		Turno turno4 = new Turno(fecha4.getTime());
		Turno turno5 = new Turno(fecha5.getTime());
		
		
		System.out.println("Turno 1: " + turno1.toString() + "\n");
		System.out.println("Turno 2: " + turno2.toString() + "\n");
		System.out.println("Turno 3: " + turno3.toString() + "\n");
		System.out.println("Turno 4: " + turno4.toString() + "\n");
		System.out.println("Turno 5: " + turno4.toString() + "\n");
		
		dia.agregarTurno(turno1);
		dia.agregarTurno(turno2);
		dia.agregarTurno(turno4);
		dia.agregarTurno(turno5);
		
		//Esta sucediendo un error con el horario de finalizacion, no se esta checkeando
		
		System.out.println();
		System.out.println();
		dia.imprimirTurnos();
		*/
		
	
		
	}

}
