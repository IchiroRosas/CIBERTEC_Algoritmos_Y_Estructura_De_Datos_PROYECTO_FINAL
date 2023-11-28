package array_lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Factura;

public class ArrayList_Factura {
	private ArrayList<Factura> factura;
	
	public ArrayList_Factura() {
		factura = new ArrayList<Factura>();
		cargarFacturas();
	}
	
	public void adicionar(Factura x) {
		factura.add(x);
	}

	public int tamanio() {
		return factura.size();
	}

	public Factura obtener(int i) {
		return factura.get(i);
	}

	public int buscar(int codigoFactura) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodigoFactura() == codigoFactura) {
				return i;
			}
		}
		return -1;
	}

	public void eliminar(int x) {
		factura.remove(x);
	}
	
	public void set(int posicion, Factura x) {
		factura.set(posicion, x);
	}
	
	//Grabar Facturas, solamente agregando la nueva factura al txt, no sobreescribe nada.
	public void grabarFactura(Factura facturaNueva) {
        try {
            PrintWriter pw;
            String linea;
            pw = new PrintWriter(new FileWriter("factura.txt", true));  // Abre el archivo en modo "append"
            linea = facturaNueva.getCodigoFactura() + ";" +
                    facturaNueva.getCodigoProducto() + ";" +
                    facturaNueva.getCodigoVendedor() + ";" +
                    facturaNueva.getUnidades() + ";" +
                    facturaNueva.getPrecio();
            pw.println(linea);
            pw.close();
        } catch (Exception e) {
        }
    }
	
	public void cargarFacturas() {
		try {
			BufferedReader br;
			int codigoFactura, codigoProducto, codigoVendedor, unidades;
			double precio;
			String linea;
			String [] s;
			br = new BufferedReader(new FileReader("factura.txt"));
			while((linea = br.readLine())!=null) {
				s = linea.split(";");
				codigoFactura = Integer.parseInt(s[0].trim());
				codigoProducto = Integer.parseInt(s[1].trim());
				codigoVendedor = Integer.parseInt(s[2].trim());
				unidades = Integer.parseInt(s[3].trim());
				precio =  Double.parseDouble((s[4].trim()));
				
				adicionar(new Factura(codigoFactura,codigoProducto,codigoVendedor,unidades,precio));
			}
			br.close();
		} 
		catch (Exception e) {
		}		
	}
	
	public int generarCodigoCorrelativoFactura() {
		if(tamanio() == 0) {
			return 4001;
		} else {
			return obtener(tamanio()-1).getCodigoFactura()+1;
		}
	}	
}