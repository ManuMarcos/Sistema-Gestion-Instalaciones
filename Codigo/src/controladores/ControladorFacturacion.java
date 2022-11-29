package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelos.Empresa;
import modelos.FacturaView;
import vistas.PanelFacturacion;

public class ControladorFacturacion implements ActionListener{

	//Attributes
	private PanelFacturacion vista;
	private Empresa modelo;
	
	//Methods
	public ControladorFacturacion(){
		this.vista = new PanelFacturacion();
		this.modelo = Empresa.getInstance();
		this.setearListadoFacturas();
		this.vista.setActionListener(this);
	}
	
	public JPanel getVista() {
		return this.vista;
	}
	
	private void setearListadoFacturas() {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		
		String[] columnas = {"Numero", "Tipo", "Fecha", "Cliente", "Subtotal", "Importe IVA", "Importe Total"};
		modeloTabla.setColumnIdentifiers(columnas);
		
		for(FacturaView facturaView : this.modelo.getFacturasView()) {
			modeloTabla.addRow(new Object[] {facturaView.getNumero(), facturaView.getTipoFactura(), facturaView.getFecha(), facturaView.getCliente().getNombre(), 
					facturaView.getSubtotal(), facturaView.getImporteIva(), facturaView.getImporteTotal()});
		}
		
		this.vista.setListadoFacturas(modeloTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandoAccionado = e.getActionCommand();
		switch (comandoAccionado) {
			case "ACTUALIZAR":
				this.setearListadoFacturas();
				break;
		}
	}
	
	
	
}
