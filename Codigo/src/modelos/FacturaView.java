package modelos;

import java.util.ArrayList;
import java.util.Date;

public class FacturaView {

	//Attributes
	private int numero;
	private Date fecha;
	private ArrayList<FacturaRenglon> renglones;
	private ClienteView cliente;
	private char tipoFactura;
	private float importeIva;
	private float subtotal;
	private float importeTotal;
	
	//Methods
	public FacturaView(int numero, Date fecha, ArrayList<FacturaRenglon> renglones, ClienteView cliente, char tipoFactura, float importeIva, float subtotal, 
			float importeTotal) {
		this.numero = numero;
		this.fecha = fecha;
		this.renglones = renglones;
		this.cliente = cliente;
		this.tipoFactura = tipoFactura;
		this.importeIva = importeIva;
		this.subtotal = subtotal;
		this.importeTotal = importeTotal;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public ArrayList<FacturaRenglon> getRenglones() {
		return renglones;
	}
	public ClienteView getCliente() {
		return cliente;
	}
	public char getTipoFactura() {
		return tipoFactura;
	}
	public float getImporteIva() {
		return importeIva;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public float getImporteTotal() {
		return importeTotal;
	}
	public Date getFecha() {
		return fecha;
	}

	
}
