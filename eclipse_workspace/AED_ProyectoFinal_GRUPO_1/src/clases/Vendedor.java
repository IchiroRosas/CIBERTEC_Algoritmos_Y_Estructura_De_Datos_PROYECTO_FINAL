package clases;

public class Vendedor {

	private int categoria,codigoVendedor, ventasEfectuadas,unidadesVendidas;
	private String nombres, apellidos, telefono, dni;
	double importeTotal;
	
	public Vendedor(int codigoVendedor, int categoria, String nombres, String apellidos, String telefono, String dni, int ventasEfectuadas, int unidadesVendidas, double importeTotal) {
		this.codigoVendedor = codigoVendedor;
		this.categoria = categoria;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
		this.ventasEfectuadas = ventasEfectuadas;
		this.unidadesVendidas = unidadesVendidas;
		this.importeTotal = importeTotal;
		
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	
	
}