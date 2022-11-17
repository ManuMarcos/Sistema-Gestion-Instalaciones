package controladores;

import java.util.Calendar;

import modelos.Agenda;
import modelos.Cliente;
import modelos.Instalacion;
import modelos.Tecnico;
import modelos.Turno;

public class ControladorPrincipal {

	public boolean agendarInstalacion(Cliente cliente, Tecnico tecnico, Calendar fecha) {
		Agenda agendaCliente = cliente.getAgenda();
		Agenda agendaTecnico = tecnico.getAgenda();
		Turno turno = new Turno(fecha);
		
		if (agendaCliente.estaDisponible(turno) && agendaTecnico.estaDisponible(turno)){
			agendaCliente.agendarTurno(turno);
			agendaTecnico.agendarTurno(turno);
			
			Instalacion instalacion = new Instalacion(cliente, tecnico);
			turno.setInstalacion(instalacion);
			System.out.println("Se agendo con exito la instalacion para la fecha " + fecha.getTime());
			return true;
		}
		System.out.println("No se agendo la instalacion para la fecha " + fecha.getTime());
		
		return false;
	}
	
	
	
	
}
