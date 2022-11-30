package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;
import modelos.EmpleadoView;
import modelos.Empresa;
import modelos.Instalacion;
import modelos.InstalacionView;
import vistas.PanelModificarInstalacion;


public class ControladorModificarInstalacion implements ActionListener, KeyListener{

	//Attributes
	private PanelModificarInstalacion vista;
	private Empresa modelo;
	private EmpleadoView empleadoLogueado;
	
	public ControladorModificarInstalacion(EmpleadoView empleadoLogueado){
		this.vista = new PanelModificarInstalacion();
		this.vista.setActionListener(this);
		this.vista.setKeyListener(this);
		this.empleadoLogueado = empleadoLogueado;
		this.modelo = Empresa.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "FINALIZAR":
				if (this.esIdValido(vista.getIdInstalacion())) {
					int idInstalacion = Integer.parseInt(this.vista.getIdInstalacion());
					if (this.modelo.existeInstalacion(idInstalacion)) {
						LocalTime horaInicio = this.vista.getHoraInicio();
						LocalTime horaFinalizacion = this.vista.getHoraFinalizacion();
						boolean almorzo = this.vista.getAlmuerzo();
						int condensadorasAdicionales = Integer.parseInt(this.vista.getCantidadDeCondensadoras()) - 1;
						int kitsAdicionales = Integer.parseInt(this.vista.getCantidadDeKits()) - 1 ;
						int evaporadorasAdicionales = Integer.parseInt(this.vista.getCantidadDeEvaporadoras()) -1;
						
						if (!this.modelo.completarInstalacion(idInstalacion, horaInicio, horaFinalizacion, almorzo, 
								evaporadorasAdicionales, kitsAdicionales, condensadorasAdicionales, 0)) {
							vista.mostrarMensajeDeError("Error", "No se pudo completar la instalacion");
						}
					}
					else {
						vista.mostrarMensajeDeError("Instalacion inexistente", "No existe ninguna instalacion con el id ingresado");
					}
				} else {
					vista.mostrarMensajeDeError("No se puede finalizar una instalación no válida. Utilice sólo números.");
				}
				this.vista.resetearPanel();
				break;
			case "CANCELAR":
				this.vista.resetearPanel();
		}	
	}

	
	public String booleanToString(boolean booleano) {
		if (booleano) {
			return "Si";
		}
		return "No";
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			if (this.esIdValido(vista.getIdInstalacion())) {
				int idInstalacion = Integer.parseInt(this.vista.getIdInstalacion());
				if (this.modelo.existeInstalacion(idInstalacion)) {
					InstalacionView instalacionView = this.modelo.getInstalacionView(Integer.parseInt(this.vista.getIdInstalacion()));
					DefaultTableModel tableModel = new DefaultTableModel();
					String [] columnas = {"ID", "Cliente", "Direccion", "Estado"};
					tableModel.setColumnIdentifiers(columnas);
					tableModel.addRow(new Object[] {Integer.toString(instalacionView.getId()), instalacionView.getClienteView().getNombre(), 
							instalacionView.getClienteView().getDireccion(), instalacionView.getEstado()});
					
					vista.mostrarDatosInstalacion(tableModel);
					
					this.vista.setCantCondensadoras(instalacionView.getElementosUtilizados().get("Condensadora"));
					this.vista.setCantEvaporadoras(instalacionView.getElementosUtilizados().get("Evaporadora"));
					this.vista.setCantKits(instalacionView.getElementosUtilizados().get("KitDeInstalacion"));
					
					this.vista.setFechaInicio(this.formatearFecha(instalacionView.getHoraInicio()));
					this.vista.setHoraInicio(instalacionView.getHoraInicio());
					
					this.vista.setFechaFinalizacion(this.formatearFecha(instalacionView.getHoraFinalizacion()));
					this.vista.setHoraFinalizacion(instalacionView.getHoraFinalizacion());
					
					
					
				}
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public boolean esIdValido(String idInstalacion) {
		try {
			Integer.parseInt(vista.getIdInstalacion());
			return true;
		}
		catch (Exception excepcion){
			vista.mostrarMensajeDeError("Por favor ingrese solo numeros");
			return false;
		}
	}

	
	
	public PanelModificarInstalacion getVista() {
		return this.vista;
	}
	
	private String formatearFecha(Calendar fecha) {
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateada = formatoFecha.format(fecha.getTime());
		return fechaFormateada;
	}
	
	
}
