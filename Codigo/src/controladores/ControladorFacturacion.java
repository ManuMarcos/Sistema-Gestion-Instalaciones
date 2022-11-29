package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelos.Empresa;
import modelos.FacturaRenglon;
import modelos.FacturaView;
import vistas.PanelFacturacion;

public class ControladorFacturacion implements ActionListener, MouseListener{

	//Attributes
	private PanelFacturacion vista;
	private Empresa modelo;
	
	//Methods
	public ControladorFacturacion(){
		this.vista = new PanelFacturacion();
		this.modelo = Empresa.getInstance();
		this.setearListadoFacturas();
		this.vista.setActionListener(this);
		this.vista.setMouseListener(this);
	}
	
	public JPanel getVista() {
		return this.vista;
	}
	
	private void setearListadoFacturas() {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		
		String[] columnas = {"Numero", "Tipo", "Fecha", "Cliente", "Subtotal", "Importe IVA", "Importe Total"};
		modeloTabla.setColumnIdentifiers(columnas);
		
		for(FacturaView facturaView : this.modelo.getFacturasView()) {
			modeloTabla.addRow(new Object[] {facturaView.getNumero(), facturaView.getTipoFactura(), this.formatearFecha(facturaView.getFecha()), 
					facturaView.getCliente().getNombre(),facturaView.getSubtotal(), facturaView.getImporteIva(), facturaView.getImporteTotal()});
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
	
	private String formatearFecha(Date fecha) {
		DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateada = formatoFecha.format(fecha.getTime());
		return fechaFormateada;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int nroFactura = this.vista.getNroFacturaSeleccionada();
		if (nroFactura != -1) {
			FacturaView facturaView = this.modelo.getFacturaView(nroFactura);
			
			Icon logoEmpresa = new ImageIcon("logo-factura.png");
			String nroFacturaS = Integer.toString(nroFactura);
			String tipoFactura = Character.toString(facturaView.getTipoFactura());
			String fechaFactura = this.formatearFecha(facturaView.getFecha());
			String idCliente = Long.toString(facturaView.getCliente().getCuitCuil());
			String nombreCliente = facturaView.getCliente().getNombre();
			String direccionCliente = facturaView.getCliente().getDireccion();
			
			DefaultTableModel listadoVenta = new DefaultTableModel();
			
			String[] columnasListadoVentas = {"Descripcion", "Cantidad", "Precio unitario", "Importe"};
			listadoVenta.setColumnIdentifiers(columnasListadoVentas);
			for(FacturaRenglon renglon : facturaView.getRenglones()) {
				listadoVenta.addRow(new Object [] {renglon.getDescripcion(), renglon.getCantidad(), renglon.getPrecioUnitario(), renglon.getImporte()});
			}
			
			DefaultTableModel listadoTotales = new DefaultTableModel();
			String[] columnasListadoTotales = {"Subtotal", "Importe Iva", "Importe total"};
			listadoTotales.setColumnIdentifiers(columnasListadoTotales);
			listadoTotales.addRow(new Object[] {facturaView.getSubtotal(), facturaView.getImporteIva(), facturaView.getImporteTotal()});
			
			this.vista.setDatosFactura(logoEmpresa, nroFacturaS, tipoFactura, fechaFactura, idCliente, nombreCliente, direccionCliente, listadoVenta, listadoTotales);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
