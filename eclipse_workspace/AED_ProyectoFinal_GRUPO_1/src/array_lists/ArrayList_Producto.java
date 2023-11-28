package array_lists;

import clases.Producto;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ArrayList_Producto {
	// Creamos el ArrayList (atributo privado)
	private ArrayList<Producto> producto;

	// Constructor (para inicializar el ArrayList)
	public ArrayList_Producto() {
		producto = new ArrayList<Producto>();
		cargarProductos();
	}

	// Operaciones públicas básicas ArrayList
	public void adicionar(Producto x) {
		producto.add(x);
	}

	public int tamanio() {
		return producto.size();
	}

	public Producto obtener(int i) {
		return producto.get(i);
	}

	public int buscar(int codigoProducto) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodigoProducto() == codigoProducto) {
				return i;
			}
		}
		return -1;
	}

	public void eliminar(int x) {
		producto.remove(x);
	}

	public void set(int posicion, Producto x) {
		producto.set(posicion, x);
	}

	public void grabarSobrescribirProductos() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("producto.txt", false));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoProducto() + ";" + 
						x.getVentasEfectuadas() + ";" +
						x.getUnidadesVendidas() + ";" +
						x.getDescripcion() + ";" + 
						x.getPrecio() + ";" +
						x.getImporteTotal();
				pw.println(linea);
			}
			pw.close();
		} 
		catch (Exception e) {
		}
	}	

	public void cargarProductos() {
		try {
			BufferedReader br;
			String linea;
			int codigoProducto, ventasEfectuadas, unidadesVendidas;
			String descripcion;
			double precio, importeTotal;
			String [] s;
			br = new BufferedReader(new FileReader("producto.txt"));
			while((linea = br.readLine())!=null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				ventasEfectuadas = Integer.parseInt(s[1].trim());
				unidadesVendidas = Integer.parseInt(s[2].trim());
				descripcion = s[3].trim();
				precio = Double.parseDouble(s[4].trim());
				importeTotal = Double.parseDouble(s[5].trim());
				Producto nuevoProducto = new Producto(codigoProducto,ventasEfectuadas,unidadesVendidas,descripcion,precio,importeTotal);
				adicionar(nuevoProducto);
			}
			br.close();
		} catch (Exception e) {
		}
	}
	
	public int generarCodigoCorrelativoProducto() {
		if(tamanio()==0) {
			return 3001;
		} else {
			return obtener(tamanio()-1).getCodigoProducto()+1;
		}
	}
	
	public double sumaPrecios() {
		double suma = 0;
		for(int i = 0; i<tamanio(); i++) {
			suma += obtener(i).getPrecio();
		}
		return suma;
	}
	
	public String promedioPrecios() {
		
		double promedio = sumaPrecios() / tamanio();
		String promedioF = df2.format(promedio);

		return promedioF;
	}
	
	public String menorPrecio() {
		double menor = obtener(0).getPrecio();
		for(int i = 1; i<tamanio(); i++) {
			if(obtener(i).getPrecio() < menor) {
				menor = obtener(i).getPrecio();
			}
		}
		String menorF = df2.format(menor);
		return menorF;
	}
	
	public String mayorPrecio() {
		double mayor = 0;
		for(int i = 0; i<tamanio(); i++) {
			if(obtener(i).getPrecio() > mayor) {
				mayor = obtener(i).getPrecio();
			}
		}
		String mayorF = df2.format(mayor);
		return mayorF;
	}
	
	DecimalFormat df2 = new DecimalFormat("0.00");
	
}