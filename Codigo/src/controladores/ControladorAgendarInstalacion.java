package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelos.Empresa;
import vistas.AgendarInstalacionDialog;

public class ControladorAgendarInstalacion implements ActionListener{

	private AgendarInstalacionDialog vistaAgendarInstalacion;
	private Empresa empresa;
	
	public ControladorAgendarInstalacion() {
		this.vistaAgendarInstalacion = new AgendarInstalacionDialog();
		this.empresa = Empresa.getInstance();
		this.vistaAgendarInstalacion.setClientesComboBox(empresa.getNombresClientes());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
			case "AGENDAR":
				this.vistaAgendarInstalacion.mostrarMensajeExitoso(vistaAgendarInstalacion.getFechaSeleccionada().getTime().toString());
		}
	}

	
	
	
}
