package clases;

public class Producto {

	private int codigoProducto, ventasEfectuadas, unidadesVendidas;
	private String descripcion;
	private double precio, importeTotal;
	
	public Producto(int codigoProducto, int ventasEfectuadas, int unidadesVendidas, String descripcion, double precio, double importeTotal) {

		this.codigoProducto = codigoProducto;
		this.ventasEfectuadas = ventasEfectuadas;
		this.unidadesVendidas = unidadesVendidas;
		this.descripcion = descripcion;
		this.precio = precio;
		this.importeTotal = importeTotal;
	}
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getVentasEfectuadas() {
		return ventasEfectuadas;
	}
	public void setVentasEfectuadas(int ventasEfectuadas) {
		this.ventasEfectuadas = ventasEfectuadas;
	}
	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}
	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	

	
}