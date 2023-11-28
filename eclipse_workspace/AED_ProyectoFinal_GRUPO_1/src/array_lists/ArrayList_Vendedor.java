package array_lists;

import clases.Vendedor;
import java.io.*;
import java.util.ArrayList;

public class ArrayList_Vendedor {
	// Creamos el ArrayList (atributo privado)
	private ArrayList<Vendedor> vendedor;

	// Constructor (para inicializar el ArrayList)
	public ArrayList_Vendedor() {
		vendedor = new ArrayList<Vendedor>();
		cargarVendedores();
	}

	// Operaciones públicas básicas ArrayList
	public void adicionar(Vendedor x) {
		vendedor.add(x);
	}

	public int tamanio() {
		return vendedor.size();
	}

	public Vendedor obtener(int i) {
		return vendedor.get(i);
	}

	public int buscar(int codigoVendedor) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodigoVendedor() == codigoVendedor) {
				return i;
			}
		}
		return -1;
	}

	public void eliminar(int x) {
		vendedor.remove(x);
	}

	public void set(int posicion, Vendedor x) {
		vendedor.set(posicion, x);
	}

	public void grabarSobrescribirVendedores() {
		try {
			PrintWriter pw;
			String linea;
			Vendedor x;
			pw = new PrintWriter(new FileWriter("vendedor.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoVendedor() + ";" + 
						x.getCategoria() + ";" + 
						x.getNombres() + ";" + 
						x.getApellidos() + ";" + 
						x.getTelefono() + ";" + 
						x.getDni() + ";" + 
						x.getVentasEfectuadas() + ";" + 
						x.getUnidadesVendidas() + ";" + 
						x.getImporteTotal();
				pw.println(linea);
			}
			pw.close();
		} 
		catch (Exception e) {
		}
	}
	
	
	

	public void cargarVendedores() {
		try {
			BufferedReader br;
			int categoria, codigoVendedor,ventasEfectuadas,unidadesVendidas;
			double importeTotal;
			String linea;
			String nombres, apellidos, telefono, dni;
			String [] s;
			br = new BufferedReader(new FileReader("vendedor.txt"));
			while((linea = br.readLine())!=null) {
				s = linea.split(";");
				codigoVendedor=Integer.parseInt(s[0].trim());
				categoria=Integer.parseInt(s[1].trim());
				nombres=s[2].trim();
				apellidos=s[3].trim();
				telefono=s[4].trim();
				dni=s[5].trim();
				ventasEfectuadas=Integer.parseInt(s[6].trim());
				unidadesVendidas=Integer.parseInt(s[7].trim());
				importeTotal=Double.parseDouble(s[8].trim());
				adicionar(new Vendedor(codigoVendedor,categoria,nombres,apellidos,telefono,dni,ventasEfectuadas,unidadesVendidas,importeTotal));
			}
			br.close();
		} catch (Exception e) {
		}

	}
	
	public int generarCodigoCorrelativoVendedor() {
		if(tamanio()==0) {
			return 2001;
		} else {
			return obtener(tamanio()-1).getCodigoVendedor()+1;
		}
	}

}
