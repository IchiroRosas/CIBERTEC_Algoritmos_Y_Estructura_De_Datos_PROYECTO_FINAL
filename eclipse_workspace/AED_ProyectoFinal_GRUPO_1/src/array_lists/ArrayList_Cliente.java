package array_lists;

import clases.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ArrayList_Cliente {
	
	private ArrayList <Cliente> cliente;
	
	public ArrayList_Cliente() {
		cliente = new ArrayList <Cliente>();
		cargarClientes();
	}
	
	public void adicionar(Cliente x) {
		cliente.add(x);
	}

	public int tamanio() {
		return cliente.size();
	}

	public Cliente obtener(int i) {
		return cliente.get(i);
	}

	public int buscar(int codigoCliente) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodigoCliente() == codigoCliente) {
				return i;
			}
		}
		return -1;
	}

	public void eliminar(int x) {
		cliente.remove(x);
	}
	
	public void set(int posicion, Cliente x) {
		cliente.set(posicion, x);
	}
	
	/*_____________________________Metodos para escribir y leer en los archivos________________________________*/
	
	public void grabarSobrescribirClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("cliente.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigoCliente() + ";" + 
						x.getNombres() + ";" + 
						x.getApellidos() + ";" + 
						x.getTelefono() + ";" + 
						x.getDni();
				pw.println(linea);
			}
			pw.close();
		} 
		catch (Exception e) {
		}
	}
	
	public void cargarClientes() {
		try {
			BufferedReader br;
			int codigoCliente;
			String linea;
			String nombres, apellidos, telefono, dni;
			String [] s;
			br = new BufferedReader(new FileReader("cliente.txt"));
			while((linea = br.readLine())!=null) {
				s = linea.split(";");
				codigoCliente=Integer.parseInt(s[0].trim());
				nombres=s[1].trim();
				apellidos=s[2].trim();
				telefono=s[3].trim();
				dni=s[4].trim();
				adicionar(new Cliente(codigoCliente,nombres,apellidos,telefono,dni));
			}
			br.close();
		} catch (Exception e) {
		}

	}
	
	public int generarCodigoCorrelativoCliente() {
		if(tamanio()==0) {
			return 1001;
		} else {
			return obtener(tamanio()-1).getCodigoCliente()+1;
		}
	}
	
}
